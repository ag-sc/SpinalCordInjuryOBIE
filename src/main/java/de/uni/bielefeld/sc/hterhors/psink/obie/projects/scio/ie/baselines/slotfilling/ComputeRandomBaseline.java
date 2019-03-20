package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.baselines.slotfilling;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import de.hterhors.obie.core.evaluation.PRF1;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.ml.run.AbstractOBIERunner;
import de.hterhors.obie.ml.run.DefaultSlotFillingRunner;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.tools.baseline.RandomBaseline;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter.SCIOParameterQuickAccess;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITreatment;

public class ComputeRandomBaseline {

	public static void main(String[] args) throws Exception {

		OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());

		List<Class<? extends ISCIOThing>> searchTypes = Arrays.asList(IOrganismModel.class, IInjury.class,
				IInvestigationMethod.class, ITreatment.class);

		for (Class<? extends ISCIOThing> class1 : searchTypes) {
			nTimesValidation(class1, 100);
		}
	}

	private static void nTimesValidation(Class<? extends ISCIOThing> class1, final int n) throws Exception {
		PRF1 mean = new PRF1(0, 0, 0);

		long allTime = System.currentTimeMillis();

		RunParameter param = SCIOParameterQuickAccess.getREParameter("", false, class1, false).build();

		AbstractOBIERunner runner = new DefaultSlotFillingRunner(param);

		final long initSeed = 100L;
		Random r = new Random(initSeed);
		System.out.println("#############################");
		for (int i = 0; i < n; i++) {

			long seed = r.nextLong();

			long time = System.currentTimeMillis();
			PRF1 prf1 = new RandomBaseline(param, seed).run(runner.corpusProvider.getFullCorpus());

			mean.add(prf1);
//			System.out.println("Time needed: " + (System.currentTimeMillis() - time));

		}
		System.out.println(class1.getSimpleName()+"\t"+mean);
//		System.out.println("Time needed: " + (System.currentTimeMillis() - allTime));
		System.out.println("#############################");

	}
}
