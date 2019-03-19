package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.baselines;

import java.util.Arrays;
import java.util.List;

import de.hterhors.obie.core.evaluation.PRF1;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.ml.corpus.distributor.FoldCrossCorpusDistributor;
import de.hterhors.obie.ml.run.AbstractOBIERunner;
import de.hterhors.obie.ml.run.DefaultSlotFillingRunner;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.tools.baseline.HighFrequencyBaseline;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter.SCIOParameterQuickAccess;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITreatment;

public class ComputeHighFreqBaseline {

	public static void main(String[] args) throws Exception {
		OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());

		List<Class<? extends ISCIOThing>> searchTypes = Arrays.asList(
				IOrganismModel.class
				,
				 IInjury.class
				,
				IInvestigationMethod.class
				,
				 ITreatment.class
				
		);

		for (Class<? extends ISCIOThing> class1 : searchTypes) {
			nFoldCrossValidation(class1);
		}
	}

	private static void nFoldCrossValidation(Class<? extends ISCIOThing> class1) throws Exception {
		PRF1 mean = new PRF1(0, 0, 0);

		long allTime = System.currentTimeMillis();

		RunParameter param = SCIOParameterQuickAccess.getREParameter("", false, class1, false).build();

		AbstractOBIERunner runner = new DefaultSlotFillingRunner(param);
		PRF1 prf1 = new HighFrequencyBaseline(param).run(runner.corpusProvider.getFullCorpus());

		mean.add(prf1);
//		while (runner.corpusProvider.nextFold()) {
//
//			System.out.println("#############################");
//			System.out.println("New " + ((FoldCrossCorpusDistributor) runner.getParameter().corpusDistributor).n
//					+ "-fold cross validation iteration: "
//					+ String.valueOf(runner.corpusProvider.getCurrentFoldIndex() + 1));
//			long time = System.currentTimeMillis();
//
//			System.out.println("Set test instances to:");
//			runner.corpusProvider.getTestCorpus().getInternalInstances().forEach(System.out::println);
//			System.out.println("#############################");
//			PRF1 prf1 = new HighFrequencyBaseline(param).run(runner.corpusProvider.getTestCorpus());
//
//			mean.add(prf1);
//			System.out.println("Time needed: " + (System.currentTimeMillis() - time));
//
//		}
		System.out.println(class1.getSimpleName() + "\t" + mean);
//		System.out.println("Time needed: " + (System.currentTimeMillis() - allTime));

	}
}
