package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.baselines.probabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ScoresToProbabilities {

	static PrintStream psSingle;
	static PrintStream psDouble;

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		psSingle = new PrintStream("scio/baseline/probabilities/" + CalculatingScoresRunner.type + "_single_probabilities.csv");
		psDouble = new PrintStream("scio/baseline/probabilities/" + CalculatingScoresRunner.type + "_double_probabilities.csv");

		/*
		 * docName, fieldName,classType,score
		 */
		Map<String, Map<String, Map<String, Double>>> singleScores = readSingleScoresFromFile(
				"scio/baseline/probabilities/" + CalculatingScoresRunner.type + "_single_scores.csv");

		/*
		 * docName, fieldName,classType,probability
		 */
		Map<String, Map<String, Map<String, Double>>> singleProbabilities = convertSingleScoresToProbabilities(
				singleScores);

		/*
		 * docName, fieldName,classType,score
		 */
		Map<String, Map<List<String>, Map<List<String>, Double>>> doubleScores = readDoubleScoresFromFile(
				"scio/baseline/probabilities/" + CalculatingScoresRunner.type + "_double_scores.csv");

		/*
		 * docName, fieldName,classType,probability
		 */
		Map<String, Map<List<String>, Map<List<String>, Double>>> doubleProbabilities = convertDoubleScoresToProbabilities(
				doubleScores);

	}

	private static Map<String, Map<String, Map<String, Double>>> convertSingleScoresToProbabilities(
			Map<String, Map<String, Map<String, Double>>> singleScores) {
		Map<String, Map<String, Map<String, Double>>> singleProbabilities = new HashMap<>();

		for (Entry<String, Map<String, Map<String, Double>>> document : singleScores.entrySet()) {
			final String docName = document.getKey();

			/*
			 * docName, fieldName, sumScore
			 */
			Map<String, Map<String, Double>> scoreSums = new HashMap<>();
			scoreSums.putIfAbsent(docName, new HashMap<>());
			for (Entry<String, Map<String, Double>> fields : document.getValue().entrySet()) {
				for (Entry<String, Double> classTypes : fields.getValue().entrySet()) {
					scoreSums.get(docName).put(fields.getKey(),
							scoreSums.get(docName).getOrDefault(fields.getKey(), 0D) + classTypes.getValue());
				}
			}

			for (Entry<String, Map<String, Double>> fields : document.getValue().entrySet()) {
				final String fieldName = fields.getKey();
				for (Entry<String, Double> classTypes : fields.getValue().entrySet()) {
					final String classType = classTypes.getKey();
					final double probability = classTypes.getValue() / scoreSums.get(docName).get(fieldName);

					singleScores.putIfAbsent(docName, new HashMap<>());
					singleScores.get(docName).putIfAbsent(fieldName, new HashMap<>());
					singleScores.get(docName).get(fieldName).put(classType, probability);

					psSingle.println(docName + "\t" + fieldName + "\t" + classType + "\t" + probability);

				}
			}

		}

		return singleProbabilities;
	}

	private static Map<String, Map<List<String>, Map<List<String>, Double>>> convertDoubleScoresToProbabilities(
			Map<String, Map<List<String>, Map<List<String>, Double>>> doubleScores) {
		Map<String, Map<List<String>, Map<List<String>, Double>>> doubleProbabilities = new HashMap<>();

		for (Entry<String, Map<List<String>, Map<List<String>, Double>>> document : doubleScores.entrySet()) {
			final String docName = document.getKey();

			/*
			 * docName, fieldNames, sumScore
			 */
			Map<String, Map<List<String>, Double>> scoreSums = new HashMap<>();
			scoreSums.putIfAbsent(docName, new HashMap<>());
			for (Entry<List<String>, Map<List<String>, Double>> fields : document.getValue().entrySet()) {
				for (Entry<List<String>, Double> classTypes : fields.getValue().entrySet()) {
					scoreSums.get(docName).put(fields.getKey(),
							scoreSums.get(docName).getOrDefault(fields.getKey(), 0D) + classTypes.getValue());
				}
			}
			for (Entry<List<String>, Map<List<String>, Double>> fields : document.getValue().entrySet()) {
				final List<String> fieldNames = fields.getKey();
				for (Entry<List<String>, Double> classTypes : fields.getValue().entrySet()) {
					final List<String> classType = classTypes.getKey();
					final double probability = classTypes.getValue() / scoreSums.get(docName).get(fieldNames);
					doubleScores.putIfAbsent(docName, new HashMap<>());
					doubleScores.get(docName).putIfAbsent(fieldNames, new HashMap<>());
					doubleScores.get(docName).get(fieldNames).put(classType, probability);

					psDouble.println(docName + "\t" + fieldNames.get(0) + "\t" + classType.get(0) + "\t"
							+ fieldNames.get(1) + "\t" + classType.get(1) + "\t" + probability);

				}
			}

		}

		return doubleProbabilities;
	}

	private static Map<String, Map<String, Map<String, Double>>> readSingleScoresFromFile(final String fileName)
			throws IOException, ClassNotFoundException {
		Map<String, Map<String, Map<String, Double>>> singleScores = new HashMap<>();

		BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));

		String line = "";
		while ((line = br.readLine()) != null) {

			String data[] = line.split("\t");

			final String docName = data[0];
			final String fieldName = data[1];
			final String classType = data[2];
			final double score = Double.parseDouble(data[3]);

			singleScores.putIfAbsent(docName, new HashMap<>());
			singleScores.get(docName).putIfAbsent(fieldName, new HashMap<>());
			singleScores.get(docName).get(fieldName).put(classType, score);

		}
		br.close();
		return singleScores;
	}

	private static Map<String, Map<List<String>, Map<List<String>, Double>>> readDoubleScoresFromFile(
			final String fileName) throws IOException, ClassNotFoundException {
		Map<String, Map<List<String>, Map<List<String>, Double>>> doubleScores = new HashMap<>();

		BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));

		String line = "";
		while ((line = br.readLine()) != null) {

			String data[] = line.split("\t");

			final String docName = data[0];
			final String fieldName1 = data[1];
			final String value1 = data[2];
			final String fieldName2 = data[3];
			final String value2 = data[4];
			final double score = Double.parseDouble(data[5]);

			List<String> fieldNames = new ArrayList<String>(Arrays.asList(fieldName1, fieldName2));
			List<String> values = new ArrayList<String>(Arrays.asList(value1, value2));

			doubleScores.putIfAbsent(docName, new HashMap<>());
			doubleScores.get(docName).putIfAbsent(fieldNames, new HashMap<>());
			doubleScores.get(docName).get(fieldNames).put(values, score);

		}
		br.close();
		return doubleScores;
	}

}
