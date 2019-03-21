package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.baselines.slotfilling.probabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.corpus.BigramCorpusProvider;
import de.hterhors.obie.ml.corpus.BigramInternalCorpus;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.SlotFillingProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter.SCIOParameterQuickAccess;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Age;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Dosage;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Weight;

/**
 * This class calculates a baseline using pre-calculated single slot and
 * pairwise slot probabilities.
 * 
 * @author hterhors
 *
 * @date Jan 8, 2018
 */
public class ILPSingleSlotBaseline {

	public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, NoSuchFieldException, SecurityException {

		// AbstractConfig scioConfig = Environment.getQuickSCIOConfig();
		//
		// SCIOCorpusProvider scioCorpusProvider =
		// SCIOCorpusProvider.getInstance(SCIOCorpusProvider.class, scioConfig);

		RunParameter param = SCIOParameterQuickAccess.getREParameter().build();
		BigramCorpusProvider corpusProvider = BigramCorpusProvider.loadCorpusFromFile(param);
		new ILPSingleSlotBaseline(param, corpusProvider.getTestCorpus());

	}

	final RunParameter param;

	public ILPSingleSlotBaseline(RunParameter param, BigramInternalCorpus corpus)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException,
			NoSuchFieldException, SecurityException, IOException {
		this.param = param;
		Map<String, Map<String, Map<String, Double>>> singleSlotProbs = readSingleProbabilitiesFromFile(
				"scio/baseline/probabilities/tmp/" + CalculatingScoresRunner.type + "_single_probabilities.csv");

		double meanPrecision = 0;
		double meanRecall = 0;
		double meanF1 = 0;
		for (OBIEInstance doc : corpus.getInternalInstances()) {

			System.out.println(doc.getName());

			List<IOBIEThing> gold = doc.getGoldAnnotation().getAnnotations().stream().map(e -> e.getThing())
					.collect(Collectors.toList());

			List<IOBIEThing> predictions = exhaustiveSearchFindBestSingleSlot(singleSlotProbs.get(doc.getName()));
			doc.getGoldAnnotation().getAnnotations()
					.forEach(s -> System.out.println(OBIEClassFormatter.format(s.getThing())));
			System.out.println("____________________________");
			predictions.forEach(f -> System.out.println(OBIEClassFormatter.format(f)));

			final double precision = param.evaluator.precision(gold, predictions);
			final double recall = param.evaluator.recall(gold, predictions);
			final double f1 = param.evaluator.f1(gold, predictions);
			System.out.println("precision = " + precision);
			System.out.println("recall = " + recall);
			System.out.println("f1 = " + f1);
			meanPrecision += precision;
			meanRecall += recall;
			meanF1 += f1;
			System.out.println("");
			System.out.println("");
			System.out.println("");
		}
		meanPrecision /= corpus.getInternalInstances().size();
		meanRecall /= corpus.getInternalInstances().size();
		meanF1 /= corpus.getInternalInstances().size();
		System.out.println("ILP single slot baseline mean-P = " + meanPrecision);
		System.out.println("ILP single slot baseline mean-R = " + meanRecall);
		System.out.println("ILP single slot baseline mean-F1 = " + meanF1);

	}

	private List<IOBIEThing> exhaustiveSearchFindBestSingleSlot(Map<String, Map<String, Double>> probs)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException,
			NoSuchFieldException, SecurityException {

		Map.Entry<String, Double> bestType = probs.get("type").entrySet().stream()
				.max(new Comparator<Map.Entry<String, Double>>() {
					@Override
					public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
						return Double.compare(o1.getValue(), o2.getValue());
					}
				}).get();

		IOBIEThing bestThing = (IOBIEThing) Class
				.forName(OntologyEnvironment.getInstance().getBasePackage() + "classes." + bestType.getKey())
				.newInstance();

		for (Entry<String, Map<String, Double>> slots : probs.entrySet()) {

			final String slotName = slots.getKey();

			if (slotName.equals("type"))
				continue;

			Map.Entry<String, Double> best = slots.getValue().entrySet().stream()
					.max(new Comparator<Map.Entry<String, Double>>() {
						@Override
						public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
							return Double.compare(o1.getValue(), o2.getValue());
						}
					}).get();

			final String value = best.getKey();
			final Field f = bestThing.getClass().getDeclaredField(slotName);
			f.setAccessible(true);

			if (value != null && !value.equals("null"))
				if (f.isAnnotationPresent(DatatypeProperty.class)) {
					if (slotName.equals("weight")) {
						f.set(bestThing, new Weight(value));
					} else if (slotName.equals("age")) {
						f.set(bestThing, new Age(value));
					} else if (slotName.equals("dosage")) {
						f.set(bestThing, new Dosage(value));
					} else {
						throw new RuntimeException("Can not interprete value: " + value + "for slot: " + slotName);
					}
					/**
					 * TODO:
					 */
				} else {
					f.set(bestThing,
							(IOBIEThing) Class.forName(
									OntologyEnvironment.getInstance().getBasePackage() + "classes." + value)
									.newInstance());
				}

		}

		return new ArrayList<>(Arrays.asList(bestThing));

	}

	private Map<String, Map<String, Map<String, Double>>> readSingleProbabilitiesFromFile(final String fileName)
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

}
