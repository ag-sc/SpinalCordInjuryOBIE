package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import corpus.SampledInstance;
import de.hterhors.obie.core.evaluation.PRF1;
import de.hterhors.obie.ml.corpus.distributor.FoldCrossCorpusDistributor;
import de.hterhors.obie.ml.evaluation.evaluator.CartesianSearchEvaluator;
import de.hterhors.obie.ml.evaluation.evaluator.IOBIEEvaluator;
import de.hterhors.obie.ml.run.AbstractRunner;
import de.hterhors.obie.ml.run.StandardRERunner;
import de.hterhors.obie.ml.run.eval.EvaluatePrediction;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.run.param.RunParameter.Builder;
import de.hterhors.obie.ml.variables.InstanceTemplateAnnotations;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.hterhors.obie.ml.variables.OBIEState;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOParameterQuickAccess;

/**
 *
 * Preferred VM parameter: -Xmx12g -XX:+UseG1GC -XX:+UseStringDeduplication
 * 
 * @author hterhors
 *
 */
public class StartExtraction {

	public static void main(String[] args) throws Exception {

		new StartExtraction();

	}

	public StartExtraction() throws Exception {

		Builder paramBuilder = SCIOParameterQuickAccess.getREParameter();

		RunParameter parameter = paramBuilder.build();

		AbstractRunner runner = new StandardRERunner(parameter);

		run(runner);
	}

	private static void run(AbstractRunner runner) throws Exception {

		long time = System.currentTimeMillis();

		if (runner.modelExists()) {
			runner.loadModel();
		} else {
			runner.train();
		}

		PRF1 pfr1 = runner.evaluateOnTest();

		System.out.println("Time needed: " + (System.currentTimeMillis() - time));

		System.out.println(pfr1);

	}

	public static class OBIE {

		public static void main(String[] args) throws Exception {

			// AbstractOBIERunner runner = new MUC34RERunner();
			Builder paramBuilder = SCIOParameterQuickAccess.getREParameter();

			RunParameter parameter = paramBuilder.build();
			// AbstractOBIERunner runner = new SCIONERRunner();
			AbstractRunner runner = new StandardRERunner(parameter);
//			AbstractOBIERunner runner = new SoccerPlayerRERunner();
			// AbstractOBIERunner runner = new SCIOCoRefChainRunner();

			standardValidation(runner);
//			nFoldCrossValidation(runner);
			// activeLearningValidation(runner);
		}

		private static void standardValidation(AbstractRunner runner) throws InstantiationException,
				IllegalAccessException, ClassNotFoundException, IOException, Exception, FileNotFoundException {
			// -Xmx12g -XX:+UseG1GC -XX:+UseStringDeduplication

			long time = System.currentTimeMillis();

			try {
				runner.loadModel();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				runner.train();
			}

			List<SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState>> predictions = runner
					.testOnTest();

			// List<SampledInstance<InternalInstance, InstanceAnnotations,
			//
			// ActiveLearningState>> predictions = runner.predictInstance(
			// //
			// runner.corpusProvider.getTestCorpus().getInstanceByName("Waver et al
			// 2005.txt"));

			// List<SampledInstance<InternalInstance, InstanceAnnotations,
			// ActiveLearningState>> predictionsOnTrain = runner
			// .predictOnTrain();

			/**
			 * Train with purity evaluate finally with cartesian
			 */
			IOBIEEvaluator evaluator = new CartesianSearchEvaluator(runner.getParameter().evaluator.isEnableCaching(),
					runner.getParameter().evaluator.getMaxEvaluationDepth(),
					runner.getParameter().evaluator.isPenalizeCardinality(),
					runner.getParameter().evaluator.getInvestigationRestrictions(),
					runner.getParameter().evaluator.getMaxNumberOfAnnotations(),
					runner.getParameter().evaluator.isIgnoreEmptyInstancesOnEvaluation());

			PRF1 pfr1 = EvaluatePrediction.evaluateREPredictions(runner.getObjectiveFunction(), predictions, evaluator);

			// double F_rij =
			// PredictionEvaluator.evaluatePurityPredictions(runner.getObjectiveFunction(),
			// predictions,
			// runner.getParameter().evaluator,
			// runner.getParameter().investigationRestriction);
			// PrintStream ps = new PrintStream(new FileOutputStream(new
			// File("scio/results.tmp.csv"), true));
			// ps.println(runner.getParameter().version + "\tPurity_InversePurity\t" +
			// F_rij);
			// ps.close();

			// PredictionEvaluator.evaluatePerSlotPredictions(runner.getObjectiveFunction(),
			// predictions);

			System.out.println("Time needed: " + (System.currentTimeMillis() - time));

			// Mean(n=73): model=2.0185965597545077; objective=0.392609065211805
			// Mean real performance: 0.508447488584475
			// Time needed: 79633

			PrintStream ps = new PrintStream(new FileOutputStream(new File("scio/results.tmp.csv"), true));
			ps.println(runner.getParameter().runID + "\t" + pfr1);
			ps.close();

			// List<ActiveLearningState> results = psink.predict(model,
			// new File("res/psink/predictCorpus/rat/chondroitinase/"));
			//
			// for (ActiveLearningState psinkState : results) {
			// System.out.println("_______________" +
			// psinkState.getInstance().getDocumentName() + "_______________");
			// System.out.println(psinkState.getModelScore());
			// System.out.println(psinkState.getInfluence());
			// System.out.println(psinkState.getPredictedResult());
			// }
		}

		private static void nFoldCrossValidation(AbstractRunner runner) throws Exception {
			PRF1 mean = new PRF1(0, 0, 0);

			long allTime = System.currentTimeMillis();

			while (runner.corpusProvider.nextFold()) {
				System.out.println("#############################");
				System.out.println("New " + ((FoldCrossCorpusDistributor) runner.getParameter().corpusDistributor).n
						+ "-fold cross validation iteration: "
						+ String.valueOf(runner.corpusProvider.getCurrentFoldIndex() + 1));
				long time = System.currentTimeMillis();

				System.out.println("Number of training data: "
						+ runner.corpusProvider.getTrainingCorpus().getInternalInstances().size());
				System.out.println(
						"Number of test data: " + runner.corpusProvider.getTestCorpus().getInternalInstances().size());

//				System.out.println("Set training instances to:");
//				runner.corpusProvider.getTrainingCorpus().getInternalInstances().forEach(System.out::println);
//				System.out.println("Set test instances to:");
//				runner.corpusProvider.getTestCorpus().getInternalInstances().forEach(System.out::println);
				System.out.println("#############################");
				try {
					runner.loadModel();
				} catch (Exception e) {
					System.err.println(e.getMessage());
					runner.train();
				}

				List<SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState>> predictions = runner
						.testOnTest();

				PRF1 prf1 = EvaluatePrediction.evaluateREPredictions(runner.getObjectiveFunction(), predictions,
						runner.getParameter().evaluator);
				mean.add(prf1);
				System.out.println("Time needed: " + (System.currentTimeMillis() - time));

			}
			System.out.println(((FoldCrossCorpusDistributor) runner.getParameter().corpusDistributor).n
					+ " fold cross validation mean: " + mean);
			System.out.println("Time needed: " + (System.currentTimeMillis() - allTime));

		}

	}

}
