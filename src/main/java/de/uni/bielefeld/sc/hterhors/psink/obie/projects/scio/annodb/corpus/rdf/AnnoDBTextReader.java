package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class AnnoDBTextReader {

	public static void main(String[] args) {
		System.out.println(
//				new AnnoDBTextReader("annodb/rawData/export_02012019/N001 Yoo, Khaled et al. 2013_export.csv").read().text);
				new AnnoDBTextReader("annodb/rawData/export_02012019/N162 Lebedev 2010_export.csv").read().text);
	}

	private final String csvFile;
	private CSVReader reader = null;
	private String text;

	public AnnoDBTextReader(String csvFile) {
		this.csvFile = csvFile;
	}

	public AnnoDBTextReader read() {
		try {

			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			String l = null;

			if (text == null) {
				StringBuffer document = new StringBuffer();
				try {
					int lastOffset = 0;
					int lineCounter = 0;
					while ((l = br.readLine()) != null) {

						lineCounter++;
						if (l.length() == 1 && l.isEmpty() || l.startsWith("#"))
							continue;
/*
 * Dirty ugly shit... csv is corrupted and csv reader can not parse. 
 */
						
						String[] line = l.split(",", 9);
						line[8] = line[8].substring(2, line[8].length() - 1); // remove space and "

						int onset = Integer.parseInt(line[6].trim());

						for (int i = 0; i < onset - lastOffset; i++) {
							document.append(" ");
						}

						if (line[8].length() > 100) {
							System.err
									.println("WARN: Long line detected in:" + csvFile + " for line: " + (lineCounter));
						}

						document.append(line[8]);
//						if (line[8].trim().isEmpty())
//
//						else {
//							document.append(line[8].trim());
//						}
						lastOffset = Integer.parseInt(line[7].trim());
					}

				} catch (IOException e) {
					e.printStackTrace();
				}

				text = document.toString();
			}
			br.close();
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getText() {
		return text;
	}

}
