package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.hterhors.obie.core.ontology.InvestigationRestriction;
import de.hterhors.obie.core.ontology.InvestigationRestriction.RestrictedField;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.ml.evaluation.evaluator.BeamSearchEvaluator;
import de.hterhors.obie.ml.evaluation.evaluator.CartesianSearchEvaluator;
import de.hterhors.obie.ml.evaluation.evaluator.IOBIEEvaluator;
import de.hterhors.obie.ml.evaluation.evaluator.PurityEvaluator;
import de.hterhors.obie.ml.evaluation.evaluator.StrictNamedEntityLinkingEvaluator;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnimalModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CompleteTransection;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Distance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.ExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Gender;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.NYUImpactor;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RatModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RatSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Vertebrae;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.VertebralArea;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Weight;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IExperimentalGroup;

public class TestEvaluation {

	final static private IOBIEEvaluator purityREevaluator = new PurityEvaluator(true, 1000, true, 10, false);

	final static private IOBIEEvaluator cartesianREevaluator = new CartesianSearchEvaluator(true, 1000, true, 10,
			false);

	final static private IOBIEEvaluator NERevaluator = new StrictNamedEntityLinkingEvaluator();

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());
		Set<RestrictedField> restrictFields = new HashSet<>();
		restrictFields.add(new RestrictedField("injuryVertebralLocation", true));
		restrictFields.add(new RestrictedField("injuryDevice", true));
		restrictFields.add(new RestrictedField("injuryArea", true));
		restrictFields.add(new RestrictedField("force", true));
		restrictFields.add(new RestrictedField("weight", true));
		restrictFields.add(new RestrictedField("volume", true));
		restrictFields.add(new RestrictedField("pressure", true));
		restrictFields.add(new RestrictedField("distance", true));
		restrictFields.add(new RestrictedField("duration", true));

//		InvestigationRestriction sampleRestrictions = new InvestigationRestriction(searchType, restrictFields);

//				InvestigationRestriction.noRestrictionInstance;

		InvestigationRestriction restrictions = new InvestigationRestriction(restrictFields, true);

		CompleteTransection g1 = new CompleteTransection().setInvestigationRestriction(restrictions)
				.setInjuryDevice(new NYUImpactor())
				.setInjuryVertebralLocation(new VertebralArea().setInvestigationRestriction(restrictions)
						.setLowerVertebrae(new Vertebrae("http://psink.de/scio/T7", null, null))
						.setUpperVertebrae(new Vertebrae("http://psink.de/scio/T8", null, null)));

		CompleteTransection g2 = new CompleteTransection().setInvestigationRestriction(restrictions)
				.setInjuryVertebralLocation(new VertebralArea().setInvestigationRestriction(restrictions));

		System.out.println(OBIEClassFormatter.format(g1));
		System.out.println(OBIEClassFormatter.format(g2));

		System.out.println(cartesianREevaluator.prf1(g1, g2));

		System.exit(1);

		compareEvaluators();

		RatModel gold1 = new RatModel().setGender(new Gender("http://psink.de/scio/Male", null, null))
				.setOrganismSpecies(new RatSpecies("http://psink.de/scio/WistarRat", null, null));
		RatModel gold2 = new RatModel().setGender(new Gender("http://psink.de/scio/Female", null, null))
				.setOrganismSpecies(new RatSpecies("http://psink.de/scio/WistarRat", null, null));

		RatModel pred1 = new RatModel().setGender(new Gender("http://psink.de/scio/Male", null, null))
				.setOrganismSpecies(new RatSpecies("http://psink.de/scio/WistarRat", null, null));
		AnimalModel pred2 = new AnimalModel();

		System.out.println(cartesianREevaluator.f1(Arrays.asList(gold1), Arrays.asList(pred1)));
		System.out.println(cartesianREevaluator.f1(Arrays.asList(gold2), Arrays.asList(pred1)));
		System.out.println(cartesianREevaluator.f1(Arrays.asList(gold1, gold2), Arrays.asList(pred1, pred2)));
		System.out.println("===============");
		System.out.println(purityREevaluator.f1(Arrays.asList(gold1), Arrays.asList(pred1)));
		System.out.println(purityREevaluator.f1(Arrays.asList(gold2), Arrays.asList(pred1)));
		System.out.println(purityREevaluator.f1(Arrays.asList(gold1, gold2), Arrays.asList(pred1, pred2)));

		// System.out.println(
		// CartesianPRF1ObjectWise.getInstance().recall(Arrays.asList(gold1,
		// gold2), Arrays.asList(pred)));
		// System.out.println(CartesianPRF1ObjectWise.getInstance().f1(Arrays.asList(gold1,
		// gold2), Arrays.asList(pred)));
		//
		// System.out.println(CartesianPRF1ObjectWise.getInstance().precision(Arrays.asList(gold1,
		// gold2),
		// Arrays.asList(pred, pred2)));
		// System.out.println(
		// CartesianPRF1ObjectWise.getInstance().recall(Arrays.asList(gold1,
		// gold2), Arrays.asList(pred, pred2)));
		// System.out.println(
		// CartesianPRF1ObjectWise.getInstance().f1(Arrays.asList(gold1, gold2),
		// Arrays.asList(pred, pred2)));

		Set<String> gold = new HashSet<>();
		Set<String> result = new HashSet<>();

		gold.add("A");
		gold.add("B");
		gold.add("C");
		gold.add("D");
		gold.add("E");
		gold.add("F");

		result.add("A");
		result.add("B");
		result.add("G");
		result.add("H");
		result.add("I");
		result.add("J");

		// System.out.println(PRF1.f1(gold, result));

		// testNER();

		// for (int i = 0; i < 10; i++) {

		// Date gDate = new Date("hallo pallo");
		// Date pDate = new Date(null, null, null);
		//
		// System.out.println(CartesianPRF1ObjectWise.getDefaultInstance().f1(gDate,
		// pDate));

		// test3();
		// test2();
		// test1();
		// }
	}

	private static void compareEvaluators() {

		final boolean includeTimeMeasurement = false;

		final IOBIEEvaluator cartesianREevaluatorClustering = new CartesianSearchEvaluator(true, 1000, true,

				10, false);

		final IOBIEEvaluator purityREevaluatorClustering = new PurityEvaluator(true, 1000, true, 10, false);

		final IOBIEEvaluator beamREevaluatorClustering = new BeamSearchEvaluator(5, true, 1000, true, f -> true, 10,
				false);
		InvestigationRestriction gR = new InvestigationRestriction(new HashSet<>(Arrays.asList(new RestrictedField("groupNames", true))),
				true);

		List<IExperimentalGroup> golds = new ArrayList<>();

		IExperimentalGroup eg1 = new ExperimentalGroup();

		eg1.addGroupName(new GroupName("A"));
		eg1.addGroupName(new GroupName("B"));
		eg1.addGroupName(new GroupName("Z"));

		IExperimentalGroup eg2 = new ExperimentalGroup();

		eg2.addGroupName(new GroupName("C"));
		eg2.addGroupName(new GroupName("D"));

		IExperimentalGroup eg3 = new ExperimentalGroup();

		eg3.addGroupName(new GroupName("E"));
		eg3.addGroupName(new GroupName("F"));

		IExperimentalGroup eg4 = new ExperimentalGroup();
		eg4.addGroupName(new GroupName("G"));

		IExperimentalGroup eg5 = new ExperimentalGroup();
		eg5.addGroupName(new GroupName("H"));
		eg5.addGroupName(new GroupName("I"));

		IExperimentalGroup eg6 = new ExperimentalGroup();
		eg6.addGroupName(new GroupName("J"));

		IExperimentalGroup eg7 = new ExperimentalGroup();
		eg7.addGroupName(new GroupName("K"));
		eg7.addGroupName(new GroupName("L"));
		eg7.addGroupName(new GroupName("M"));

		IExperimentalGroup eg8 = new ExperimentalGroup();
		eg8.addGroupName(new GroupName("N"));

		golds.add(eg1);
		golds.add(eg2);
		golds.add(eg3);
		golds.add(eg4);
		golds.add(eg5);
		golds.add(eg6);
//		golds.add(eg7);
//		golds.add(eg8);

		List<IExperimentalGroup> preds = new ArrayList<>();

		IExperimentalGroup ep1 = new ExperimentalGroup();

		ep1.addGroupName(new GroupName("A"));
		ep1.addGroupName(new GroupName("B"));

		IExperimentalGroup ep2 = new ExperimentalGroup();
		ep2.addGroupName(new GroupName("C"));

		IExperimentalGroup ep3 = new ExperimentalGroup();
		ep3.addGroupName(new GroupName("D"));
		ep3.addGroupName(new GroupName("E"));
		ep3.addGroupName(new GroupName("F"));

		IExperimentalGroup ep4 = new ExperimentalGroup();
		ep4.addGroupName(new GroupName("G"));
		ep4.addGroupName(new GroupName("H"));

		IExperimentalGroup ep5 = new ExperimentalGroup();
		ep5.addGroupName(new GroupName("I"));
		ep5.addGroupName(new GroupName("N"));

		IExperimentalGroup ep6 = new ExperimentalGroup();
		ep6.addGroupName(new GroupName("J"));
		ep6.addGroupName(new GroupName("K"));
		ep6.addGroupName(new GroupName("L"));
		ep6.addGroupName(new GroupName("M"));

		preds.add(ep1);
		preds.add(ep2);
		preds.add(ep3);
		preds.add(ep4);
		preds.add(ep5);
		preds.add(ep6);

		if (includeTimeMeasurement) {
			System.out.print("WarmUp...");
			/*
			 * warm up
			 */
			for (int i = 0; i < 100; i++) {
				System.out.print(".");
				for (int j = 0; j < 5000000; j++) {
					Math.random();
				}
			}
		}
		System.out.println("... done");
		System.out.println("##########>>>CARTESIAN<<<#############");

		if (includeTimeMeasurement) {

			long t = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				cartesianREevaluatorClustering.prf1(golds, preds);
			}
			System.out.println((System.currentTimeMillis() - t));
		}
		System.out.println(cartesianREevaluatorClustering.f1(golds, preds));

		System.out.println("##########>>>PURITY<<<#############");
		if (includeTimeMeasurement) {
			long t2 = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				purityREevaluatorClustering.f1(golds, preds);
			}
			System.out.println((System.currentTimeMillis() - t2));
		}
		System.out.println(purityREevaluatorClustering.f1(golds, preds));

		System.out.println("##########>>>BEAM<<<#############");
		if (includeTimeMeasurement) {

			long t3 = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				beamREevaluatorClustering.f1(golds, preds);
			}
			System.out.println((System.currentTimeMillis() - t3));
		}
		System.out.println(beamREevaluatorClustering.f1(golds, preds));
	}

}
