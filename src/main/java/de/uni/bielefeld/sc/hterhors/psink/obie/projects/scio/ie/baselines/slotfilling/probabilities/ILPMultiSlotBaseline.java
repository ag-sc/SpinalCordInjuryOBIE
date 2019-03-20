package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.baselines.slotfilling.probabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.corpus.BigramInternalCorpus;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.hterhors.obie.ml.variables.OBIEInstance;
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
public class ILPMultiSlotBaseline {

//	public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException,
//	IllegalAccessException, IllegalArgumentException, NoSuchFieldException, SecurityException {
//
//// AbstractConfig scioConfig = Environment.getQuickSCIOConfig();
////
//// SCIOCorpusProvider scioCorpusProvider =
//// SCIOCorpusProvider.getInstance(SCIOCorpusProvider.class, scioConfig);
//
//OBIEParameter param = SCIOParameterBuilder.getDevelopmentREParameter().build();
//BigramCorpusProvider corpusProvider = BigramCorpusProvider.loadCorpusFromFile(param);
//new ILPMultiSlotBaseline(param, corpusProvider.getTestCorpus());
//
//}

	final RunParameter param;

	public ILPMultiSlotBaseline(RunParameter param, BigramInternalCorpus corpus) throws Exception {
		this.param = param;

		Map<String, Map<String, Map<String, Double>>> singleSlotProbs = readSingleProbabilitiesFromFile(
				"scio/baseline/probabilities/tmp/" + CalculatingScoresRunner.type + "_single_probabilities.csv");

		Map<String, List<SlotAssignment>> doubleSlotProbs = readDoubleScoresFromFile(
				"scio/baseline/probabilities/tmp/" + CalculatingScoresRunner.type + "_double_probabilities.csv");

		double meanPrecision = 0;
		double meanRecall = 0;
		double meanF1 = 0;

		for (OBIEInstance doc : corpus.getInternalInstances()) {

			System.out.println(doc.getName());
			List<IOBIEThing> gold = doc.getGoldAnnotation().getAnnotations().stream().map(e -> e.getThing())
					.collect(Collectors.toList());
			singleData = singleSlotProbs.get(doc.getName());
			doubleData = doubleSlotProbs.get(doc.getName());

			List<IOBIEThing> predictions = exhaustiveSearchFindBestDoubleSlot();
			doc.getGoldAnnotation().getAnnotations()
					.forEach(s -> System.out.println(OBIEClassFormatter.format(s.getThing(), false)));
			System.out.println("____________________________");
			predictions.forEach(f -> System.out.println(OBIEClassFormatter.format(f, false)));

			/**
			 * TODO: ADD HERE slot evaluation.
			 */

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
		System.out.println("ILP double slot baseline mean-P = " + meanPrecision);
		System.out.println("ILP double slot baseline mean-R = " + meanRecall);
		System.out.println("ILP double slot baseline mean-F1 = " + meanF1);

	}

	private List<SlotAssignment> doubleData;
	private Map<String, Map<String, Double>> singleData;

	private List<IOBIEThing> exhaustiveSearchFindBestDoubleSlot() {

		Map<String, Set<String>> candidates = getDoubleCandidates();

		List<String> slots = new ArrayList<>(candidates.keySet());
		Map<String, String> slotValues = new HashMap<>();
		List<SlotAssignment> possibleSlotAssignments = new ArrayList<>();
		rec(possibleSlotAssignments, candidates, slots, 0, slotValues);

		Collections.sort(possibleSlotAssignments);

		List<IOBIEThing> instances = new ArrayList<>();
		possibleSlotAssignments.stream().limit(1)
				.forEach(possibleSlotAssignment -> instances.add(toInstance(possibleSlotAssignment)));

		possibleSlotAssignments.stream().limit(1).forEach(System.out::println);

		// double diff = possibleSlotAssignments.get(0).probability -
		// possibleSlotAssignments.get(1).probability;
		// System.out.println(diff);

		return instances;
	}

	private IOBIEThing toInstance(SlotAssignment possibleSlotAssignment) {

		String bestType = possibleSlotAssignment.slotValues.get("type");

		IOBIEThing bestThing;
		try {
			bestThing = (IOBIEThing) Class.forName(param.ontologyEnvironment.getBasePackage() + "classes." + bestType)
					.newInstance();

			for (Entry<String, String> slot : possibleSlotAssignment.slotValues.entrySet()) {

				final String slotName = slot.getKey();

				if (slotName.equals("type"))
					continue;

				final String value = slot.getValue();
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
					} else {
						f.set(bestThing,
								(IOBIEThing) Class
										.forName(param.ontologyEnvironment.getBasePackage() + "classes." + value)
										.newInstance());
					}

			}
			return bestThing;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchFieldException
				| SecurityException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Can not build instance with given slot assignment");
	}

	private void rec(List<SlotAssignment> possibleSlotAssignment, Map<String, Set<String>> candidates,
			List<String> slots, int slotIndex, Map<String, String> slotValues) {

		final String slot = slots.get(slotIndex);

		for (String value : candidates.get(slot)) {
			slotValues.put(slot, value);

			if (slotIndex + 1 < slots.size())
				rec(possibleSlotAssignment, candidates, slots, slotIndex + 1, slotValues);
			else {
				List<String> s = new ArrayList<>(slotValues.keySet());
				double probability = 0;
				/**
				 * Works only for pairs of slots. Make it recursive for n slots.
				 */
				for (int i = 0; i < s.size(); i++) {
					for (int j = i + 1; j < s.size(); j++) {
						double prob = 0;
						for (SlotAssignment sa : doubleData) {
							Map<String, String> o = new HashMap<>();
							o.put(s.get(i), slotValues.get(s.get(i)));
							o.put(s.get(j), slotValues.get(s.get(j)));
							if (sa.slotValues.equals(o)) {
								prob = sa.probability;
								break;
							}
						}
						probability += prob;
					}
					// probability +=
					// singleData.get(s.get(i)).get(slotValues.get(s.get(i)));
				}

				possibleSlotAssignment.add(new SlotAssignment(new HashMap<>(slotValues), probability));
			}
		}
	}

	private Map<String, Set<String>> getDoubleCandidates() {

		/*
		 * slot,values
		 */
		Map<String, Set<String>> candidates = new HashMap<>();

		doubleData.stream().flatMap(sa -> sa.slotValues.keySet().stream()).distinct()
				.forEach(k -> candidates.putIfAbsent(k, new HashSet<>()));

		for (SlotAssignment d : doubleData) {
			for (Entry<String, String> values : d.slotValues.entrySet()) {
				candidates.get(values.getKey()).add(values.getValue());
			}
		}

		return candidates;
	}

	private Map<String, List<SlotAssignment>> readDoubleScoresFromFile(final String fileName)
			throws IOException, ClassNotFoundException {
		Map<String, List<SlotAssignment>> doubleScores = new HashMap<>();

		BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));

		String line = "";
		while ((line = br.readLine()) != null) {

			String data[] = line.split("\t");

			final String docName = data[0];
			final String fieldName1 = data[1];
			final String value1 = data[2];
			final String fieldName2 = data[3];
			final String value2 = data[4];
			final double probability = Double.parseDouble(data[5]);

			Map<String, String> slotValues = new HashMap<>();
			slotValues.put(fieldName1, value1);
			slotValues.put(fieldName2, value2);

			doubleScores.putIfAbsent(docName, new ArrayList<>());
			doubleScores.get(docName).add(new SlotAssignment(slotValues, probability));

		}
		br.close();
		return doubleScores;
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
