package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.analysis;

import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.corpus.BigramCorpusProvider;
import de.hterhors.obie.ml.corpus.distributor.ShuffleCorpusDistributor;
import de.hterhors.obie.ml.ner.NERLClassAnnotation;
import de.hterhors.obie.ml.ner.NERLIndividualAnnotation;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.run.param.RunParameter.Builder;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter.EntityRecognitionParameter;

public class PrintBigramCorpus {

	public static void main(String[] args) {
		{
			OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());
		}
		/*
		 * Get some standard parameter. These are not important for this example. the
		 * more important parameter follow below:
		 */
		final Builder paramBuilder = getStandardParameter();

		paramBuilder.setCorpusDistributor(new ShuffleCorpusDistributor.Builder().setCorpusSizeFraction(1F)
				.setTrainingProportion(80).setDevelopmentProportion(0).setTestProportion(20).build());

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

		for (OBIEInstance instance : corpusProvider.getFullCorpus().getInternalInstances()) {

			System.out.println("________" + instance.getName() + "________");
			System.out.println(instance.getContent());
			System.out.println("____________Template Annotation(s)____________");

			for (Class<? extends IOBIEThing> annotatedClass : instance.getEntityAnnotations()
					.getAvailableClassTypes()) {
				for (NERLClassAnnotation classNERLAnnotation : instance.getEntityAnnotations()
						.getClassAnnotations(annotatedClass)) {
					System.out.println(classNERLAnnotation);
				}
			}

			for (AbstractIndividual annotatedIndividual : instance.getEntityAnnotations()
					.getAvailableIndividualTypes()) {
				for (NERLIndividualAnnotation individualNERLAnnotation : instance.getEntityAnnotations()
						.getIndividualAnnotations(annotatedIndividual)) {
					System.out.println(individualNERLAnnotation);
				}
			}

			for (IETmplateAnnotation templateAnnotation : instance.getGoldAnnotation().getAnnotations()) {
				System.out.println(OBIEClassFormatter.format(templateAnnotation.getThing()));
			}
			break;

		}
	}

	/**
	 * We need to set some standard parameter.
	 * 
	 * @return
	 */
	private static Builder getStandardParameter() {
		Builder paramBuilder = EntityRecognitionParameter.getPreDefinedParameterBuilder();

		return paramBuilder;
	}
}
