package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio;

import java.io.FileNotFoundException;

import de.hterhors.obie.ml.corpus.BigramCorpusProvider;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.tools.upperbound.UpperBound;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOParameterQuickAccess;

public class SCIOUpperBound {

	public static void main(String[] args) throws FileNotFoundException {

		RunParameter param = SCIOParameterQuickAccess.getREParameter().build();

//		OBIEParameter param = SoccerPlayerParameterBuilder.getDevelopmentREParameter().build();

		BigramCorpusProvider corpusProvider = BigramCorpusProvider.loadCorpusFromFile(param);

		new UpperBound(param, corpusProvider.getTestCorpus());
	}

}
