package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import de.hterhors.obie.core.tools.annodb.AnnoDBAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.WebAnno3TSVDocument;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.WebannoTSV3Reader;

/**
 * This class takes the annotated document from WebAnno in WebAnno-TSV-3 format.
 * 
 * Converts an annotated document in Webanno format into the annodb
 * readin-format. This is very similar to BRAT a1 files.
 * 
 * 
 * Changes:
 * 
 * 1) Does not support relations.
 * 
 * 2) Discontinuous annotations have the same id.
 * 
 * @author hterhors
 *
 *         Mar 13, 2017
 */
public class WebannoToAnnoDBConverter {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		final String parentInDir = "webanno/raw/new2/";
		final String parentOutDir = "webanno/gen/new2/";

		forDir(parentInDir, parentOutDir);

	}

	private static void forDir(final String parentInDir, final String parentOutDir)
			throws IOException, ClassNotFoundException, FileNotFoundException {

		for (File file : new File(parentInDir).listFiles()) {

			if (file.isDirectory()) {
				System.err.println("Go recursive for directory: " + file);
				forDir(file.getAbsolutePath() + "/", parentOutDir);
				continue;
			}
			System.out.println("Current File: " + file);
			final String docBaseName = file.getName();
			final String documentName = parentInDir + docBaseName;

			final String outputAnnotationsFileName = parentOutDir
					+ docBaseName.replaceAll("%2520", " ").replaceFirst(".tsv", ".annodb");
			final String outputTextFileName = parentOutDir
					+ docBaseName.replaceAll("%2520", " ").replaceFirst(".tsv", ".txt");
			final String outputTokenFileName = parentOutDir
					+ docBaseName.replaceAll("%2520", " ").replaceFirst(".tsv", ".csv");

			convertToAnnoDB(documentName, outputAnnotationsFileName, outputTextFileName);
			transform(documentName, outputTokenFileName);
		}
	}

	private static void transform(final String inputFile, final String outputFile)
			throws FileNotFoundException, IOException {
		PrintStream ps = new PrintStream(new File(outputFile));

		System.out.println("Read file: " + inputFile + "...");
		List<String> docLines = Files.readAllLines(new File(inputFile).toPath());
		System.out.println("Write file: " + outputFile);
		AtomicBoolean firstLine = new AtomicBoolean(true);
		docLines.forEach(l -> {
			if (l.startsWith("#Text")) {
				if (!firstLine.get()) {
					ps.println();
				}
				ps.print(l);
				firstLine.set(false);
			} else if (l.startsWith("#") || l.isEmpty()) {
				if (!l.isEmpty())
					System.out.println("Skip Line: " + l);
			} else {
				if (l.split("\t", 4).length == 4) {

					if (!l.matches("[0-9]{1,4}-[0-9]{1,4}\t.*"))
						throw new RuntimeException("Can not parse line: " + l);
					ps.println();
					ps.print(toTSV(l));
				} else {
					if (l.matches("[1-9]-[1-9].*"))
						System.out.println("Assume Text: " + l);
					ps.print(" " + l);
				}
			}
		});
		System.out.println("Done!");
		ps.close();
	}

	private static String toTSV(String l) {
		final String[] data = l.split("\t", 4);
		return data[0].split("-")[0] + "\t" + data[0].split("-")[1] + "\t" + data[1].split("-")[0] + "\t"
				+ data[1].split("-")[1] + "\t" + data[2];
	}

	private static void convertToAnnoDB(final String documentName, final String outputAnnotationsFileName,
			final String outputTextFileName) throws IOException, ClassNotFoundException, FileNotFoundException {

		WebAnno3TSVDocument webAnnoDoc = WebannoTSV3Reader.readWebAnnoTSV3Document(documentName);

		WebannoAnnotationExtractor annotations = new WebannoAnnotationExtractor(webAnnoDoc);

		PrintStream documentFile = new PrintStream(outputTextFileName);
		annotations.getDocument().forEach(documentFile::print);
		documentFile.close();

		PrintStream annotationFile = new PrintStream(outputAnnotationsFileName);

		int annotationCounter = 0;
		Map<Integer, Integer> idMap = new HashMap<>();

		for (AnnoDBAnnotation annotation : annotations.getAnnotationFactory().values()) {
			// trim string since annotations are divided by splitter.
			annotation.tokenValue = annotation.tokenValue.trim();
			annotationCounter++;
			idMap.put(annotation.annotationID, annotationCounter);

			StringBuffer line = new StringBuffer();
			int id;
			if (webAnnoDoc.disconts.containsKey(annotation.annotationID)) {
				try {
					id = idMap.get(webAnnoDoc.disconts.get(annotation.annotationID));
				} catch (Exception e) {
					System.out.println(e.getMessage());
					id = annotationCounter;
				}
			} else {
				id = annotationCounter;
			}

			line.append("T" + id).append("\t");
			line.append(annotation.classType).append("\t");
			line.append(annotation.onset).append("\t");
			line.append(annotation.offset).append("\t");
			line.append("\"" + annotation.tokenValue + "\"").append("\t");
			line.append("\"" + annotation.additionalInfo + "\"");

			annotationFile.println(line);
			String word = annotations.getFullDocument().substring(annotation.onset, annotation.offset);

			if (!word.equals(annotation.tokenValue)) {
				System.err.println("No match: " + word + " != " + annotation);
			} else {
				System.out.println("Match: " + word + " = " + annotation);
			}
		}

		annotationFile.close();
	}

}
