package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.analysis;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics;

import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.core.ontology.ReflectionUtils;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.corpus.BigramCorpusProvider;
import de.hterhors.obie.ml.ner.NERLClassAnnotation;
import de.hterhors.obie.ml.ner.NERLIndividualAnnotation;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.run.param.RunParameter.Builder;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter.SCIOParameterQuickAccess;

public class AnalyseBigramCorpus {

	public static void main(String[] args) throws Exception {
		{
			OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());
		}
		/*
		 * Get some standard parameter. These are not important for this example. the
		 * more important parameter follow below:
		 */
		final Builder paramBuilder = getStandardParameter();

		paramBuilder.setCorpusDistributor(SCIOParameterQuickAccess.shuffleDist());

		/*
		 * Build parameter.
		 */
		RunParameter parameter = paramBuilder.build();

		/**
		 * Load the raw corpus from file system. This corpus contains only the document
		 * content and annotations of the template but NO named entity recognition and
		 * linking annotations!
		 */

		BigramCorpusProvider corpusProvider = BigramCorpusProvider.loadCorpusFromFile(parameter);

		Map<String, Integer> counter = new HashMap<>();
		Map<String, Integer> nullCounter = new HashMap<>();
		int mainTemplateCounter = 0;
		for (OBIEInstance instance : corpusProvider.getFullCorpus().getInternalInstances()) {

			for (IETmplateAnnotation ta : instance.getGoldAnnotation().getAnnotations()) {
				mainTemplateCounter++;
				IOBIEThing thing = ta.getThing();

				count(counter, nullCounter, thing);

			}

		}
		
		System.out.println("#Docs = " + corpusProvider.getFullCorpus().getInternalInstances().size());
		System.out.println("main template Counter = " + mainTemplateCounter);

		System.out.println("####COUNTER");
		counter.entrySet().forEach(System.out::println);

		System.out.println("####NULLCOUNTER");
		nullCounter.entrySet().forEach(System.out::println);
	}

	private static void count(Map<String, Integer> counter, Map<String, Integer> nullCounter, IOBIEThing thing)
			throws IllegalAccessException {
		List<Field> slots = ReflectionUtils.getFields(thing.getClass(), thing.getInvestigationRestriction());

		for (Field field : slots) {

			List<IOBIEThing> values = new ArrayList<>();
			if (ReflectionUtils.isAnnotationPresent(field, RelationTypeCollection.class)) {
				values.addAll((List<IOBIEThing>) field.get(thing));
				if (values.isEmpty()) {
					nullCounter.put(field.getName(), nullCounter.getOrDefault(field.getName(), 0) + 1);
				} else {
					counter.put(field.getName(), counter.getOrDefault(field.getName(), 0) + 1);
				}
			} else {
				IOBIEThing child = (IOBIEThing) field.get(thing);
				if (child == null) {
					nullCounter.put(field.getName(), nullCounter.getOrDefault(field.getName(), 0) + 1);
				} else {
					values.add(child);
					counter.put(field.getName(), counter.getOrDefault(field.getName(), 0) + 1);

				}
			}

			for (IOBIEThing child : values) {
				count(counter, nullCounter, child);
			}

		}
	}

	/**
	 * We need to set some standard parameter.
	 * 
	 * @return
	 */
	private static Builder getStandardParameter() {
		Builder paramBuilder = SCIOParameterQuickAccess.getREParameter();

		return paramBuilder;
	}
}
