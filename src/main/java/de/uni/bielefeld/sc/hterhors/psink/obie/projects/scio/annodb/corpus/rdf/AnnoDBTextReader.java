package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.apache.jena.sparql.function.library.execTime;

import com.opencsv.CSVReader;

public class AnnoDBTextReader {

	public static void main(String[] args) {
		new AnnoDBTextReader("scio/annodb/N001 Yoo, Khaled et al. 2013_export.csv");
	}

	private final String csvFile;
	private CSVReader reader = null;
	private String text;

	public AnnoDBTextReader(String csvFile) {
		this.csvFile = csvFile;
	}

	public AnnoDBTextReader read() {

		if (text == null) {
			StringBuffer document = new StringBuffer();
			try {
				reader = new CSVReader(new FileReader(csvFile));
				String[] line;
				int lastOffset = 0;
				int lineCounter = 0;
				while ((line = reader.readNext()) != null) {

					lineCounter++;
					if (line.length == 1 && line[0].isEmpty() || line[0].startsWith("#"))
						continue;

					int onset = Integer.parseInt(line[6].trim());

					for (int i = 0; i < onset - lastOffset; i++) {
						document.append(" ");
					}

					if (line[8].trim().length() > 100) {
						System.err
								.println("WARN: Long line detected in:" + csvFile + " for line: " + (lineCounter));
					}

					document.append(line[8].trim());
					lastOffset = Integer.parseInt(line[7].trim());
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

			text = document.toString();
		}
		return this;
	}

	public String getText() {
		return text;
	}

}
