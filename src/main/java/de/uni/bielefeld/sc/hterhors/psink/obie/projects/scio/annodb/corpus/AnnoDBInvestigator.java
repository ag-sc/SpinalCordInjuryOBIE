package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;

import de.hterhors.obie.core.tokenizer.SentenceSplitter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf.AnnoDBTextReader;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticPValue;

public class AnnoDBInvestigator {

	public static void main(String[] args) {

		Map<String, Set<String>> fileNamesSortbyAnnotator = new HashMap<>();
		final String dir = "scio/annodb/";
		Arrays.stream(new File(dir).list()).forEach(file -> {
			String fileName = FilenameUtils.getBaseName(file);
			final String annotator = fileName.split("_")[1];
			fileName = fileName.split("_")[0];

			fileNamesSortbyAnnotator.putIfAbsent(annotator, new HashSet<>());
			fileNamesSortbyAnnotator.get(annotator).add(fileName);
		});
		final String annotator = "Jessica";
		Map<String, Integer> potentialGroupNameCounter = new HashMap<>();
		for (String fileName : fileNamesSortbyAnnotator.get(annotator)) {
			// System.out.println(fileName + "...");
			// System.out.print(".");

			String documentContent = new AnnoDBTextReader(dir + fileName + "_export.csv").read().getText();
			List<String> s = SentenceSplitter.extractSentences(documentContent);

			for (String sentence : s) {

				Set<String> gnPerSentence = doSomething(sentence);
				if (gnPerSentence.size() >= 2) {

					Matcher pvalueMatcher = SemanticPValue.PATTERN.matcher(sentence);

					if (pvalueMatcher.find() || sentence.contains("significant")) {
						System.out.println(sentence);
					}
				}
				// potentialGroupNames.forEach(System.out::println);

				gnPerSentence.forEach(n -> {
					potentialGroupNameCounter.put(n, potentialGroupNameCounter.getOrDefault(n, 0) + 1);
				});
			}
		}

		Map<String, Integer> sorted = new LinkedHashMap<>();
		potentialGroupNameCounter.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
				.forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
		System.out.println("... done:");
		sorted.entrySet().forEach(System.out::println);
		System.out.println("#Of distinct names found: " + potentialGroupNameCounter.size());

	}

	// \u0070\u0072\u0069\u0076\u0061\u0074\u0065
	//
	// \u0073\u0074\u0061\u0074\u0069\u0063
	//
	// \u0066\u0069\u006e\u0061\u006c
	//
	// \u0053\u0074\u0072\u0069\u006e\u0067
	//
	// \u0047\u0052\u004f\u0055\u0050\u005f\u004e\u0041\u004d\u0045\u005f\u0052\u0045\u0047\u0045\u0058
	//
	// \u003d
	// \u0022\u0028\u005b\u005e\u005c\u005c\u0073\u005c\u005c\u002e\u002c\u005d\u002b\u003f\u005c\u005c\u0057\u0029\u007b\u0031\u002c\u0032\u007d\u0028\u0074\u0072\u0065\u0061\u0074\u0065\u0064\u007c\u0074\u0072\u0065\u0061\u0074\u006d\u0065\u006e\u0074\u0073\u003f\u005c\u005c\u0057\u0029\u003f\u0067\u0072\u006f\u0075\u0070\u0073\u003f\u0022\u003b

	private static final String GROUP_NAME_REGEX = "([^\\s\\.,]+?\\W){1,2}(treat[a-z]{1,4}\\W)?group(\\W[1-9])?";

	private static final Pattern groupNamePattern = Pattern.compile(GROUP_NAME_REGEX, Pattern.CASE_INSENSITIVE);

	private static Set<String> doSomething(String documentContent) {

		Matcher matcher = groupNamePattern.matcher(documentContent);

		Set<String> potentialGroupNames = new HashSet<>();

		while (matcher.find()) {
			potentialGroupNames.add(removeStopWords(matcher.group()));
		}
		return potentialGroupNames;

	}

	private static String removeStopWords(String group) {
		return group;
	}

}