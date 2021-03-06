package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.opencsv.CSVReader;

import de.hterhors.obie.core.evaluation.iob.IOBEvaluator.IOBEnum;
import de.hterhors.obie.core.tokenizer.Token;
import de.hterhors.obie.ml.variables.InstanceTemplateAnnotations;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IGroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IObservedDifference;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

public class GroupNames2IOB {

	public static void main(String[] args) throws FileNotFoundException {

		final String dir = "webanno/gen/";
		final Set<String> groupNames = new HashSet<>();
		List<OBIEInstance> instances = new ArrayList<>();
		Arrays.stream(new File(dir).listFiles()).filter(file -> file.getName().endsWith(".annodb")).sorted()
				.forEach(file -> {
					try {
						Map<String, Set<String>> groupedSurfaceNames = new HashMap<>();

						System.out.println(file + "...");

						List<String> documentContent = Files
								.readAllLines(new File(file.getAbsolutePath().replaceAll(".annodb", ".txt")).toPath());

						StringBuffer rawContent = new StringBuffer();

						for (String sentence : documentContent) {
							rawContent.append(sentence.replaceAll("[^\\x20-\\x7E]", "#")).append("\n");
						}

						CSVReader reader = new CSVReader(new FileReader(file), '\t');
						String[] line;
						InstanceTemplateAnnotations ias = new InstanceTemplateAnnotations();
						while ((line = reader.readNext()) != null) {

							@SuppressWarnings("unchecked")
							final Class<? extends ISCIOThing> clzz = (Class<? extends ISCIOThing>) Class
									.forName(OntologyEnvironment.getInstance().getBasePackage() + "classes."
											+ line[1]);

							if (!(
//									IExperimentalGroup.class.isAssignableFrom(clzz)
							// ||
							IObservedDifference.class.isAssignableFrom(clzz)))
								continue;

							final String surfaceForm = line[4];

							final String ids = line[5];

							if (ids.isEmpty())
								continue;

							for (String id : ids.split(",")) {
								id = id.trim();
								groupedSurfaceNames.putIfAbsent(id, new HashSet<>());
								groupedSurfaceNames.get(id).add(surfaceForm);
								groupNames.add(surfaceForm);
								IGroupName groupName = new GroupName(surfaceForm, surfaceForm);
								groupName.setCharacterOnset(Integer.parseInt(line[2]));
//								groupName.setCharacterOffset(Integer.parseInt(line[3]));
								IETmplateAnnotation ia = new IETmplateAnnotation(IGroupName.class, groupName);
								ias.addAnnotation(ia);
							}

						}
						OBIEInstance ii = new OBIEInstance(file.getName(), rawContent.toString().trim(), ias,
								new HashSet<>(Arrays.asList(IGroupName.class)));
						instances.add(ii);
						reader.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});

		// System.out.println(corpusProvider.getTrainingCorpus().getInstances().size());

		File trainingsDataFile = new File("scio/iob/scio-result-train.iob");
		PrintStream trainFileStream = new PrintStream(trainingsDataFile);

		File testDataFile = new File("scio/iob/scio-result-test.iob");
		PrintStream testFileStream = new PrintStream(testDataFile);

		Random random = new Random(100L);
		Collections.shuffle(instances, random);

		final int numOfTraining = numberOfTrainingData(80, 100, instances.size());

		writeIOBToFile(instances.subList(0, numOfTraining), trainFileStream);
		writeIOBToFile(instances.subList(numOfTraining, instances.size()), testFileStream);

		trainFileStream.close();
		testFileStream.close();

	}

	public static int numberOfTrainingData(final int prop, final int max, final int totalNumberOfDocuments) {
		return Math.round(((float) prop / (float) max) * totalNumberOfDocuments);
	}

	private static void writeIOBToFile(List<OBIEInstance> instances, PrintStream trainFileStream) {
		for (OBIEInstance ii : instances) {

			final List<Token> tokens = ii.getTokens();

			Set<String[]> annotations = new HashSet<>();
			for (IETmplateAnnotation ia : ii.getGoldAnnotation().getAnnotations()) {

				final String text = ia.getThing().getTextMention();
				annotations.add(text.split(" "));

			}
			List<String[]> sortedAnn = new ArrayList<>(annotations);

			Collections.sort(sortedAnn, new Comparator<String[]>() {

				@Override
				public int compare(String[] o1, String[] o2) {
					return -Integer.compare(o1.length, o2.length);
				}
			});

			IOBEnum prevIOBTag = IOBEnum.O;
			int annotationLength = 0;
			long onset = 0;
			long offset = 0;
			for (int i = 0; i < tokens.size(); i++) {
				onset = tokens.get(i).getOnsetCharPosition();
				offset = tokens.get(i).getOffsetCharPosition();
				IOBEnum iobTag = IOBEnum.O;
				if (!prevIOBTag.equals(IOBEnum.B) && annotationLength == 0) {
					for (String[] annotation : sortedAnn) {
						if (annotation[0].equals(tokens.get(i).getText())) {
							boolean matches = true;
							for (int j = 1; j < annotation.length; j++) {
								try {
									if (!annotation[j].equals(tokens.get(i + j).getText())) {
										matches = false;
									}
								} catch (IndexOutOfBoundsException e) {
									matches = false;
								}
								if (!matches)
									break;
							}
							if (matches) {
								iobTag = IOBEnum.B;
								annotationLength = annotation.length - 1;
								break;
							} else {
								iobTag = IOBEnum.O;
								annotationLength = 0;
							}
						}
					}
				} else if (!prevIOBTag.equals(IOBEnum.O)) {
					if (annotationLength > 0) {
						iobTag = IOBEnum.I;
						annotationLength--;
					}
				}
				prevIOBTag = iobTag;
				trainFileStream.println(
						tokens.get(i).getText() + "\t" + onset + "\t" + offset + "\t" + iobTag.getAnnotationName());
			}
			trainFileStream.println();
		}
	}

}
