package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.baselines.nerl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import de.hterhors.obie.core.evaluation.evaluator.StandardPRF1Evaluator;
import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.corpus.BigramCorpusProvider;
import de.hterhors.obie.ml.ner.NERLClassAnnotation;
import de.hterhors.obie.ml.ner.NERLIndividualAnnotation;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter.EntityRecognitionParameter;

public class SymbolicNERL {

	public static void main(String[] args) {
		{
			OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());
		}

		final RunParameter parameter = EntityRecognitionParameter.getPreDefinedParameter();

		BigramCorpusProvider corpusProvider = BigramCorpusProvider.loadCorpusFromFile(parameter);

		double mp = 0, mr = 0, mf1 = 0;

		for (OBIEInstance instance : corpusProvider.getFullCorpus().getInternalInstances()) {

			Set<String> pred = new HashSet<>();
			System.out.println("________" + instance.getName() + "________");

			for (Class<? extends IOBIEThing> annotatedClass : instance.getEntityAnnotations()
					.getAvailableClassTypes()) {
				for (NERLClassAnnotation classNERLAnnotation : instance.getEntityAnnotations()
						.getClassAnnotations(annotatedClass)) {
					pred.add(classNERLAnnotation.getOnset() + "-"
							+ (classNERLAnnotation.getOnset() + classNERLAnnotation.getText().length()) + "-"
							+ classNERLAnnotation.getText() + "-" + classNERLAnnotation.classType.getSimpleName());
				}
			}

			for (AbstractIndividual annotatedIndividual : instance.getEntityAnnotations()
					.getAvailableIndividualTypes()) {
				for (NERLIndividualAnnotation individualNERLAnnotation : instance.getEntityAnnotations()
						.getIndividualAnnotations(annotatedIndividual)) {
					pred.add(individualNERLAnnotation.getOnset() + "-"
							+ (individualNERLAnnotation.getOnset() + individualNERLAnnotation.getText().length()) + "-"
							+ individualNERLAnnotation.getText() + "-"
							+ individualNERLAnnotation.relatedIndividual.getURI());
				}
			}

			Set<String> gold = instance.getGoldAnnotation().getAnnotations().stream()
					.map(ta -> ta.getThing().getCharacterOnset() + "-" + ta.getThing().getCharacterOffset() + "-"
							+ ta.getThing().getTextMention() + "-" + ta.getThing().getLabel())
					.collect(Collectors.toSet());

			System.out.println("gold" + gold);
			System.out.println("pred" + pred);

			double p = StandardPRF1Evaluator.precision(gold, pred);
			double r = StandardPRF1Evaluator.recall(gold, pred);
			double f1 = StandardPRF1Evaluator.f1(gold, pred);

			mp += p;
			mr += r;
			mf1 += f1;
			System.out.println("p=" + p + ", r=" + r + ", f1=" + f1);
		}
		System.out.println("MICRO PRECISION = " + mp / corpusProvider.getFullCorpus().getInternalInstances().size());
		System.out.println("MICRO RECALL = " + mr / corpusProvider.getFullCorpus().getInternalInstances().size());
		System.out.println("MICRO F1 = " + mf1 / corpusProvider.getFullCorpus().getInternalInstances().size());

	}

}
