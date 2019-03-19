package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.tools;

import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.ml.corpus.BigramCorpusProvider;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.tools.upperbound.UpperBound;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter.SCIOParameterQuickAccess;

public class SCIOUpperBound {

	public static void main(String[] args) {
		OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());

		RunParameter param = SCIOParameterQuickAccess.getREParameter().build();

		BigramCorpusProvider corpusProvider = BigramCorpusProvider.loadCorpusFromFile(param);

		new UpperBound(param, corpusProvider.getFullCorpus());
	}

}
