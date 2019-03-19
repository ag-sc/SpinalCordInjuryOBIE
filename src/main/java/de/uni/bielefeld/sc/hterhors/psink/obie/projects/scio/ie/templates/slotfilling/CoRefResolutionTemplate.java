package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.TFIDF;
import de.hterhors.obie.core.utils.CounterMap;
import de.hterhors.obie.ml.run.AbstractOBIERunner;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.variables.OBIEState;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling.CoRefResolutionTemplate.Scope;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IGroupName;
import factors.Factor;
import factors.FactorScope;
import learning.Vector;

public class CoRefResolutionTemplate extends AbstractOBIETemplate<Scope> implements Serializable {

	private static final String TOKEN_SPLITTER_REGEX = "\\W";
	private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList("group", "treated", "treatment", "..."));

	public CoRefResolutionTemplate(AbstractOBIERunner runner) {
		super(runner);
	}

	private static Logger log = LogManager.getFormatterLogger(CoRefResolutionTemplate.class.getName());

	class Scope extends FactorScope {

		/**
		 * Already assigned entities;
		 */
		final private List<List<String>> groupedEntities;

		/**
		 * Left over entities, all entities that are not yet clustered.
		 */
		final private List<String> leftOverEntities;

		public Scope(Class<? extends IOBIEThing> entityRootClassType, AbstractOBIETemplate<?> template,
				final List<List<String>> goupedEntities, final List<String> leftOverEntities) {
			super(template, goupedEntities, leftOverEntities, entityRootClassType);
			this.groupedEntities = goupedEntities;
			this.leftOverEntities = leftOverEntities;
		}

	}

	@Override
	public List<Scope> generateFactorScopes(OBIEState state) {
		List<Scope> factors = new ArrayList<>();

		List<List<String>> clusteredEntities = new ArrayList<>();
		Class<? extends IOBIEThing> entityRootClassType = null;
		List<String> leftOvers = new ArrayList<>();

		/**
		 * TODO: works currently only for ExpGroups and GroupNames.
		 */
		for (IETmplateAnnotation entity : state.getCurrentIETemplateAnnotations().getAnnotations()) {

			if (!IExperimentalGroup.class.isAssignableFrom(entity.rootClassType))
				continue;

			entityRootClassType = entity.rootClassType;

			clusteredEntities.add(((IExperimentalGroup) entity.getThing()).getGroupNames().stream()
					.filter(gn -> gn != null).map(gn -> gn.getTextMention()).collect(Collectors.toList()));

		}
		leftOvers.addAll(state.getLeftOvers(IGroupName.class).stream().map(o -> o.getTextMention())
				.collect(Collectors.toList()));

		if (entityRootClassType != null)
			factors.add(new Scope(entityRootClassType, this, clusteredEntities, leftOvers));

		return factors;
	}

	@Override
	public void computeFactor(Factor<Scope> factor) {

		Vector featureVector = factor.getFeatureVector();

		final List<List<String>> clusteredEntities = factor.getFactorScope().groupedEntities;
		final List<String> leftOvers = factor.getFactorScope().leftOverEntities;

		if (clusteredEntities.isEmpty())
			return;

		double count = 0;
		double numberOfTotalEntities = 0;

		for (List<String> cluster : clusteredEntities) {
			for (String entity : cluster) {
				if (leftOvers.contains(entity)) {
					count++;
				}
			}
			numberOfTotalEntities += cluster.size();
		}

		idf(featureVector, clusteredEntities);

		distribution(featureVector, clusteredEntities);

		checkCardinality(featureVector, clusteredEntities);

		multiValueCheck(featureVector, clusteredEntities);

		unsetDuplicates(featureVector, count);

//		featureVector.set("#OfLeftOvers", leftOvers.size());

		numOfTotalEntities(featureVector, numberOfTotalEntities);

		// multiTokenCheck(featureVector, clusteredEntities);

		// intraCooccurrence(featureVector, clusteredEntities);

		// extraCooccurrence(featureVector, clusteredEntities);

		// intraVSextraCooccurrence(featureVector, clusteredEntities);

		doubleEntries(featureVector, clusteredEntities);

		wordVariance(featureVector, clusteredEntities);

	}

	private void numOfTotalEntities(Vector featureVector, double numberOfTotalEntities) {
		featureVector.set("#NumberOfTotalEntities", numberOfTotalEntities);
	}

	private void unsetDuplicates(Vector featureVector, double count) {
		featureVector.set("#CountDuplicateUnsetLeftOvers", count);
	}

	private void wordVariance(Vector featureVector, List<List<String>> clusteredEntities) {
		for (List<String> cluster : clusteredEntities) {
			final int count = (int) cluster.stream().flatMap(s -> Arrays.stream(s.split(TOKEN_SPLITTER_REGEX)))
					.filter(w -> !STOP_WORDS.contains(w)).distinct().count();
			featureVector.set("TokenVariance", count);
		}
	}

	private void doubleEntries(Vector featureVector, final List<List<String>> clusteredEntities) {
		for (List<String> cluster : clusteredEntities) {
			int counter = 0;
			for (int i = 0; i < cluster.size(); i++) {
				final String e1 = cluster.get(i);
				for (int j = i; j < cluster.size(); j++) {
					final String e2 = cluster.get(j);
					if (e1.equals(e2))
						counter++;
				}
			}
			featureVector.set("Double Entries", counter);
		}
	}

	private void multiTokenCheck(Vector featureVector, final List<List<String>> clusteredEntities) {
		double sum = 0;
		for (List<String> cluster : clusteredEntities) {
			List<String> tokenList = cluster.stream().flatMap(s -> Arrays.stream(s.split(TOKEN_SPLITTER_REGEX)))
					.filter(w -> !STOP_WORDS.contains(w)).collect(Collectors.toList());
			final int listSize = tokenList.size();
			final int setSize = new HashSet<>(tokenList).size();

			sum += listSize - setSize;
		}
		featureVector.set("MultiTokenValue", sum);
	}

	private void multiValueCheck(Vector featureVector, final List<List<String>> clusteredEntities) {
		double sum = 0D;
		for (List<String> cluster : clusteredEntities) {
			final int listSize = cluster.size();
			final int setSize = new HashSet<>(cluster).size();
			sum += listSize - setSize;
		}
		sum /= clusteredEntities.size();
		featureVector.set("MultiValue", sum);
	}

	private void intraVSextraCooccurrence(Vector featureVector, final List<List<String>> clusteredEntities) {

		final List<List<List<String>>> tokenizedClusters = new ArrayList<>();

		for (List<String> cluster : clusteredEntities) {

			List<List<String>> tokenizedCluster = new ArrayList<>();

			for (int i = 0; i < cluster.size(); i++) {
				final List<String> tokenizedList = Arrays.stream(cluster.get(i).split(TOKEN_SPLITTER_REGEX))
						.filter(w -> !STOP_WORDS.contains(w)).distinct().collect(Collectors.toList());
				tokenizedCluster.add(tokenizedList);

			}
			tokenizedClusters.add(tokenizedCluster);

		}

		double countAllIntra = 0D;

		/*
		 * Intra Co-occurrence
		 */
		double countIntra = 0D;
		for (List<List<String>> tokenizedCluster : tokenizedClusters) {

			for (int i = 0; i < tokenizedCluster.size(); i++) {
				for (int j = i; j < tokenizedCluster.size(); j++) {
					for (String e1 : tokenizedCluster.get(i)) {
						for (String e2 : tokenizedCluster.get(j)) {
							countIntra += e1.equals(e2) ? 1 : 0;
							countAllIntra++;
						}
					}
				}
			}
		}
		double countAllExtra = 0D;

		/*
		 * Extra Co-occurrence
		 */
		double countExtra = 0D;
		for (int i = 0; i < tokenizedClusters.size(); i++) {
			final List<List<String>> cluster1 = tokenizedClusters.get(i);
			for (int j = i; j < tokenizedClusters.size(); j++) {
				final List<List<String>> cluster2 = tokenizedClusters.get(j);
				for (int i2 = 0; i2 < cluster1.size(); i2++) {
					final List<String> c1e = cluster1.get(i2);
					for (int j2 = i2; j2 < cluster2.size(); j2++) {
						final List<String> c2e = cluster2.get(j2);
						for (int i3 = 0; i3 < c1e.size(); i3++) {
							final String c1et = c1e.get(i3);
							for (int j3 = i3; j3 < c2e.size(); j3++) {
								final String c2et = c2e.get(j3);
								countExtra += c1et.equals(c2et) ? 0 : 1;
								countAllExtra++;
							}
						}
					}
				}
			}
		}
		if (countAllIntra > 0) {
			final double intraRatio = countIntra / countAllIntra;
			featureVector.set("Intra Co-occurrence Ratio", intraRatio);
		}
		if (countAllExtra > 0) {
			final double extraRatio = countExtra / countAllExtra;
			featureVector.set("Extra Co-occurrence Ratio", extraRatio);
		}
	}

	private void extraCooccurrence(Vector featureVector, final List<List<String>> clusteredEntities) {
		/*
		 * Extra Co-occurrence
		 */

		List<List<List<String>>> tokenizedClusters = new ArrayList<>();

		for (List<String> cluster : clusteredEntities) {

			List<List<String>> tokenizedCluster = new ArrayList<>();

			for (int i = 0; i < cluster.size(); i++) {
				final List<String> tokenizedList = Arrays.stream(cluster.get(i).split(TOKEN_SPLITTER_REGEX))
						.filter(w -> !STOP_WORDS.contains(w)).distinct().collect(Collectors.toList());
				tokenizedCluster.add(tokenizedList);

			}
			tokenizedClusters.add(tokenizedCluster);

		}

		for (int i = 0; i < tokenizedClusters.size(); i++) {
			final List<List<String>> cluster1 = tokenizedClusters.get(i);
			for (int j = i; j < tokenizedClusters.size(); j++) {
				final List<List<String>> cluster2 = tokenizedClusters.get(j);
				for (int i2 = 0; i2 < cluster1.size(); i2++) {
					final List<String> c1e = cluster1.get(i2);
					for (int j2 = i2; j2 < cluster2.size(); j2++) {
						final List<String> c2e = cluster2.get(j2);
						for (int i3 = 0; i3 < c1e.size(); i3++) {
							final String c1et = c1e.get(i3);
							for (int j3 = i3; j3 < c2e.size(); j3++) {
								final String c2et = c2e.get(j3);
								featureVector.set("Extra Co-occurrence " + c1et + ">-<" + c2et, true);
							}
						}
					}
				}
			}
		}
	}

	private void intraCooccurrence(Vector featureVector, final List<List<String>> clusteredEntities) {
		/*
		 * Intra Co-occurrence
		 */
		for (List<String> cluster : clusteredEntities) {

			List<List<String>> tokenizedCluster = new ArrayList<>();

			for (int i = 0; i < cluster.size(); i++) {
				final List<String> tokenizedList = Arrays.stream(cluster.get(i).split(TOKEN_SPLITTER_REGEX))
						.filter(w -> !STOP_WORDS.contains(w)).distinct().collect(Collectors.toList());
				tokenizedCluster.add(tokenizedList);

			}

			for (int i = 0; i < tokenizedCluster.size(); i++) {
				for (int j = i; j < tokenizedCluster.size(); j++) {
					for (String e1 : tokenizedCluster.get(i)) {
						for (String e2 : tokenizedCluster.get(j)) {
							featureVector.set("Intra Co-occurrence " + e1 + "<->" + e2, true);
						}
					}
				}
			}
		}
	}

	/**
	 * Prevent empty lists.
	 * 
	 * @param featureVector
	 * @param groupedEntities
	 */
	private void checkCardinality(Vector featureVector, final List<List<String>> groupedEntities) {
		int numOfEmpty = 0;
		int geq2 = 0;
		int geq3 = 0;
		for (List<String> set : groupedEntities) {
			if (set.size() >= 2) {
				geq2++;
				if (set.size() >= 3) {
					geq3++;
				}
			}
			if (set.size() == 0) {
				numOfEmpty++;
			}
		}
		featureVector.set("SomeAreEmpty", numOfEmpty);
		featureVector.set("#GEQ2", geq2);
		featureVector.set("#GEQ3", geq3);
	}

	/**
	 * Minimize surface form distribution over all clusters.
	 * 
	 * @param featureVector
	 * @param groupedEntities
	 */
	private void distribution(Vector featureVector, final List<List<String>> groupedEntities) {
		final CounterMap<String> counter = new CounterMap<>();

		for (List<String> entry : groupedEntities) {
			entry.stream().distinct().forEach(w -> {
				counter.incrementAndGet(w);
			});
		}

		if (!counter.iterator().hasNext())
			return;

		// counter.forEach(System.out::println);
		double avg = 0;
		for (Map.Entry<String, Integer> entry : counter) {
			avg += entry.getValue();
		}
		avg /= counter.size();
		// System.out.println(counter);
		// System.out.println(avg == 1F);
		featureVector.set("distribution==1", avg == 1F);
		// featureVector.set("distribution!=1", avg != 1F);
	}

	/**
	 * Try to maximize overall IDF in order to minimize token distribution over
	 * clusters.
	 * 
	 * @param featureVector
	 * @param groupedEntities
	 */
	private void idf(Vector featureVector, final List<List<String>> groupedEntities) {
		Map<String, Set<String>> docs = new HashMap<>();

		int index = 0;
		for (List<String> set : groupedEntities) {
			docs.put(String.valueOf(index++),
					set.stream().distinct().flatMap(w -> Arrays.stream(w.split(TOKEN_SPLITTER_REGEX)))
							.filter(w -> !STOP_WORDS.contains(w)).collect(Collectors.toSet()));
		}

		Map<String, Double> idfs = TFIDF.getIDFs(docs);

		if (idfs.size() == 0)
			return;

		// idfs.entrySet().forEach(System.out::println);

		double avgIDF = 0;
		for (Double idf : idfs.values()) {
			avgIDF += idf;
		}
		avgIDF /= idfs.size();
		// System.out.println(avgIDF);
		// System.out.println("###");

		featureVector.set("avgIDF", avgIDF);
	}

}
