package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import corpus.SampledInstance;
import de.hterhors.obie.core.evaluation.PRF1;
import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.InvestigationRestriction;
import de.hterhors.obie.core.ontology.InvestigationRestriction.RestrictedField;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.core.ontology.ReflectionUtils;
import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.activelearning.FullDocumentAtomicChangeEntropyRanker;
import de.hterhors.obie.ml.activelearning.FullDocumentEntropyRanker;
import de.hterhors.obie.ml.activelearning.FullDocumentLengthRanker;
import de.hterhors.obie.ml.activelearning.FullDocumentMarginBasedRanker;
import de.hterhors.obie.ml.activelearning.FullDocumentModelScoreRanker;
import de.hterhors.obie.ml.activelearning.FullDocumentObjectiveScoreRanker;
import de.hterhors.obie.ml.activelearning.FullDocumentRandFillerRanker;
import de.hterhors.obie.ml.activelearning.FullDocumentRandomRanker;
import de.hterhors.obie.ml.activelearning.FullDocumentVarianceRanker;
import de.hterhors.obie.ml.activelearning.IActiveLearningDocumentRanker;
import de.hterhors.obie.ml.activelearning.SingleSlotModelScoreRanker;
import de.hterhors.obie.ml.corpus.distributor.FoldCrossCorpusDistributor;
import de.hterhors.obie.ml.evaluation.evaluator.CartesianSearchEvaluator;
import de.hterhors.obie.ml.evaluation.evaluator.IOBIEEvaluator;
import de.hterhors.obie.ml.run.AbstractOBIERunner;
import de.hterhors.obie.ml.run.DefaultSlotFillingRunner;
import de.hterhors.obie.ml.run.eval.EvaluatePrediction;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.run.param.RunParameter.Builder;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import de.hterhors.obie.ml.variables.InstanceTemplateAnnotations;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.hterhors.obie.ml.variables.OBIEState;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter.SCIOParameterQuickAccess;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import learning.Trainer;
import sampling.Explorer;

/**
 *
 * Preferred VM parameter: -Xmx12g -XX:+UseG1GC -XX:+UseStringDeduplication
 * 
 * @author hterhors
 *
 */
@Deprecated
public class StartExtraction {

	protected static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) throws Exception {

//		new StartExtraction();

	}

	final private String acMode;
	final private File printResults;

	public StartExtraction() throws Exception {
		{
			OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());
		}
		log.info(
				"2) argument: mode of active learning, \"random\"(default), \"entropy\", \"entropyAtomic\", \"objective\", \"model\", \"margin\", \"length\" or \"variance\"");
		acMode = "model";
		printResults = new File("runResults/runResults");

//		AbstractRunner runner = new DefaultSlotFillingRunner(getParameter("INIT", true, IInvestigationMethod.class, false),
//				false);

		run();
	}

	private RunParameter getParameter(String runID, boolean singleSlot, Class searchType, boolean full) {

//		Builder paramBuilder = SCIOParameterQuickAccess.getREParameter(runID, singleSlot, searchType, full);
		Builder paramBuilder = SCIOParameterQuickAccess.getREParameter();

		RunParameter parameter = paramBuilder.build();

		return parameter;
	}

	private void run() throws Exception {

//		long time = System.currentTimeMillis();
//
//		if (runner.modelExists()) {
//			runner.loadModel();
//		} else {
//			runner.train();
//		}
//
//		PRF1 pfr1 = runner.evaluateOnTest();
//
//		System.out.println("Time needed: " + (System.currentTimeMillis() - time));
//
//		System.out.println(pfr1);

		/*
		 * train and/or test on existing corpus.
		 */
//			reverseEngineerACLearning(runner);

//		if (runner.getParameter().corpusDistributor instanceof ActiveLearningDistributor) {
//			activeLearning(runner);
//		} else if (runner.getParameter().corpusDistributor instanceof FoldCrossCorpusDistributor) {
//		nFoldCrossValidation(runner);
//		} else {
//		trainTest(runner);
//		}

		List<Class<? extends IOBIEThing>> searchTypes = Arrays.asList(
//				
//				IOrganismModel.class
//				,
				IInjury.class
//				,
//				IInvestigationMethod.class
//				, 
//				ITreatment.class
		);
		for (Class<? extends IOBIEThing> searchType : searchTypes) {
			AbstractOBIERunner runner = new DefaultSlotFillingRunner(getParameter(null, true, searchType, false),
					false);
			trainTest(runner, searchType, false, false);
//			for (Boolean full : Arrays.asList(false, true)) {
//				for (Boolean singleSlot : Arrays.asList(true, false)) {
//			runner.corpusProvider.currentFold = -1;
//					nFoldCrossValidation(runner, searchType, singleSlot, full);
//			nFoldCrossValidation(runner, searchType, false, false);
//
//				}
//			}
		}
	}

	/**
	 * Run the system with the specifications and configurations.
	 * 
	 * @param runner
	 * @param full
	 * @param singleSlot
	 * @param searchType
	 * @throws Exception
	 */
	private void trainTest(AbstractOBIERunner runner, Class<? extends IOBIEThing> searchType, Boolean singleSlot,
			Boolean full) throws Exception {
		log.info("Start training / testing of a model with a given corpus...");
		final long trainingTime;
		final long trt;

		if (runner.modelExists()) {
			/*
			 * If the model exists, load the model from the file system. The model location
			 * is specified in the parameter and the environment.
			 */
			runner.loadModel();
			trt = 0;
		} else {
			/*
			 * If the model does not exists train. The model is automatically stored to the
			 * file system to the given model location!
			 */
			trainingTime = System.currentTimeMillis();
//			String runID = String.valueOf(new Random().nextInt());
			runner.clean(getParameter(null, false, null, false));
			runner.train();
			trt = (System.currentTimeMillis() - trainingTime);
			log.info("Total training time: " + trt + " ms.");
		}

		evaluate(runner, trt);

	}

	private Map<Double, PRF1> evaluate(AbstractOBIERunner runner, final long trt)
			throws IOException, FileNotFoundException, ClassNotFoundException, Exception {
		final long testTime = System.currentTimeMillis();
		/**
		 * Get predictions that can be evaluated for full evaluation and
		 * perSlotEvaluation.
		 */
		final List<SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState>> predictions = runner
				.testOnTest();

//		final PRF1 overallPRF1_train = runner.evaluateOnTrain();
//		System.out.println("###################");
//		System.out.println("overallPRF1_train: " + overallPRF1_train);
//		System.out.println("###################");

		/**
		 * Evaluate the trained model on the test data. This is equal to predictOnTest
		 * and apply the results to an evaluator.
		 *
		 * Same as:
		 *
		 * // final PRF1 overallPRF1 = runner.evaluateOnTest();
		 */

		final PRF1 overallPRF1 = EvaluatePrediction.evaluateSlotFillingPredictions(runner.objectiveFunction,
				predictions, runner.getParameter().evaluator);

		log.info("Evaluation results on test data:\n" + overallPRF1);

		log.info("Evaluate predictions per slot:");

		/**
		 * Whether the output for each slot should be shown detailed or not. (Might
		 * generate large output)
		 */
		boolean detailedOutput = false;

		/**
		 * Evaluate the trained model on the test data for each slot individually.
		 *
		 * Same as:
		 *
		 * // runner.evaluatePerSlotOnTest(detailedOutput);
		 */
		EvaluatePrediction.evaluatePerSlotPredictions(runner.objectiveFunction, predictions,
				runner.getParameter().evaluator, detailedOutput);

		Map<Double, PRF1> result = computeSlotConfidenceByEntropy(runner, predictions);

		PrintStream resultPrintStream = new PrintStream(new FileOutputStream(printResults, true));
		resultPrintStream.println("############Performances: " + runner.getParameter().runID + "############");
		resultPrintStream.println("#Precision\tRecall\tF1");
		final String logPerformance = overallPRF1.getPrecision() + "\t" + overallPRF1.getRecall() + "\t"
				+ overallPRF1.getF1();
		resultPrintStream.println(logPerformance);

		resultPrintStream.close();
		final long tet = (System.currentTimeMillis() - testTime);
		log.info("--------------" + runner.getParameter().runID + "---------------");

		log.info("Total training time: " + trt + " ms.");
		log.info("Total test time: " + tet + " ms.");
		log.info("Total time: "
				+ Duration.between(Instant.now(), Instant.ofEpochMilli(System.currentTimeMillis() + (trt + tet))));
		return result;
	}

	/**
	 * Adds investigationRestriction to all slot values of the parent value.
	 * 
	 * @param thing
	 * @param r
	 */
	@SuppressWarnings("unchecked")
	private void setRestrictionRec(IOBIEThing thing, InvestigationRestriction r) {

		if (thing == null)
			return;

		try {

			if (ReflectionUtils.isAnnotationPresent(thing.getClass(), DatatypeProperty.class))
				return;

			thing.setInvestigationRestriction(r);

			for (Field slot : ReflectionUtils.getNonDatatypeSlots(thing.getClass(), r)) {

				if (ReflectionUtils.isAnnotationPresent(slot, RelationTypeCollection.class)) {

					for (IOBIEThing sv : (List<IOBIEThing>) slot.get(thing)) {
						setRestrictionRec(sv, r);
					}
				} else {
					setRestrictionRec((IOBIEThing) slot.get(thing), r);
				}

			}

		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private Map<Double, PRF1> computeSlotConfidenceByEntropy(AbstractOBIERunner runner,
			List<SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState>> predictions) {

		/**
		 * TODO: We assume there is just one type.
		 */
		Class<? extends IOBIEThing> classType = runner.getParameter().rootSearchTypes.iterator().next();

		List<RestrictedField> mainFields = InvestigationRestriction.getMainSingleFields(classType);

		List<Set<RestrictedField>> restrictFieldsList = InvestigationRestriction
				.getFieldRestrictionCombinations(classType, mainFields);

		List<InvestigationRestriction> restrictions = new ArrayList<>();
		restrictions.add(new InvestigationRestriction(Collections.emptySet(), true));

		for (Set<RestrictedField> set : restrictFieldsList) {
			if (set.size() != 1) {
				/**
				 * TODO: allow more than a single field here: parameterize
				 */
				continue;
			}

			if (runner.getParameter().defaultTestInvestigationRestriction.getFieldNamesRestrictions() != null)
				if (!runner.getParameter().defaultTestInvestigationRestriction.getFieldNamesRestrictions()
						.containsAll(set))
					continue;

//			for (int i = 1; i < 3; i++) {
//				restrictions.add(new InvestigationRestriction(set, i % 2 == 0));
//			}
			restrictions.add(new InvestigationRestriction(set, false));
		}
		CartesianSearchEvaluator evaluator = new CartesianSearchEvaluator(true,
				runner.getParameter().evaluator.getMaxEvaluationDepth(), false,
				runner.getParameter().evaluator.getOrListCondition(), 7,
				runner.getParameter().evaluator.isIgnoreEmptyInstancesOnEvaluation());

		Map<Double, PRF1> results = new HashMap<>();
		for (Double threshold : Arrays.asList(0.006, 0.005, 0.004, 0.003, 0.0035, 0.002, 0.0025,
				Double.parseDouble("1E-3"), Double.parseDouble("1.5E-4"), Double.parseDouble("1E-4"),
				Double.parseDouble("1.5E-5"), Double.parseDouble("1E-5"), Double.parseDouble("1E-6"),
				Double.parseDouble("0"))) {

//		Double threshold = Double.parseDouble("0");
//		Double threshold = Double.parseDouble("1E-5");
			PRF1 result = new PRF1();
			results.put(threshold, result);

			double meanEntropy = 0;
			for (SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState> predictedInstance : predictions) {

				for (InvestigationRestriction rest : restrictions) {

					for (IETmplateAnnotation tA : predictedInstance.getState().getCurrentIETemplateAnnotations()
							.getAnnotations()) {
						setRestrictionRec(tA.getThing(), rest);
					}

					OBIEState initialState = new OBIEState(predictedInstance.getState());

					List<OBIEState> nextStates = new ArrayList<>();

					/*
					 * Create possible changes from last sampled state using explorers.
					 */
					for (Explorer<OBIEState> explorer : runner.sampler.getExplorers()) {
						nextStates.addAll(explorer.getNextStates(initialState));
					}

					for (OBIEState tA : nextStates) {
						for (IETmplateAnnotation thing : tA.getCurrentIETemplateAnnotations()
								.getAnnotations()) {
							setRestrictionRec(thing.getThing(),
									runner.getParameter().defaultTestInvestigationRestriction);
						}

					}

					/*
					 * Score with model
					 */
					runner.scoreWithModel(nextStates);

//				nextStates.forEach(log::info);

					final double partition = nextStates.stream().map(s -> s.getModelScore()).reduce(0D, Double::sum);

					double entropy = entropy(nextStates, partition);
					meanEntropy += entropy;
//				double entropy = initialState.getModelScore() / partition;

//				log.info("####FINAL STATE####");
//				log.info(initialState);
//				log.info("########");
//				nextStates.forEach(log::info);
//				log.info(initialState.getInstance().getName() + "\t" + nextStates.size() + "\t" + entropy);

//				log.info("___");
//				if(initialState.getInstance().getName().equals("Arvo_Kraam")) {
//					log.info("__");
//				}
					List<IOBIEThing> goldList = new ArrayList<>();

					List<IOBIEThing> predictionList = new ArrayList<>();

					for (IETmplateAnnotation tA : predictedInstance.getState().getCurrentIETemplateAnnotations()
							.getAnnotations()) {
						setRestrictionRec(tA.getThing(), rest);
						predictionList.add(tA.getThing());
					}

					for (IETmplateAnnotation tA : predictedInstance.getGoldResult().getAnnotations()) {
						setRestrictionRec(tA.getThing(), rest);
						goldList.add(tA.getThing());
					}
					double f1 = evaluator.prf1(goldList, predictionList).getF1();
					String r = rate(result, entropy, threshold, f1);
					log.info("Entropy of :" + rest.summarize());
					log.info("Evaluation:\ngold:" + OBIEClassFormatter.format(goldList.get(0)) + "pred:"
							+ OBIEClassFormatter.format(predictionList.get(0)));
//					log.info(predictedInstance.getInstance());
					log.info(threshold + "\t" + entropy + "\t" + f1 + "\t" + r);
					log.info("");

				}
			}
			meanEntropy /= predictions.size();
			log.info("MeanEntropy: " + meanEntropy);
		}

//		log.info("micro: " + result);
		results.entrySet().forEach(log::info);
		return results;
	}

	private double entropy(List<OBIEState> nextStates, final double partition) {
		double entropy = 0;

		/*
		 * Compute entropy of state
		 */
		for (OBIEState obieState : nextStates) {

			final double modelProbability = (obieState.getModelScore()) / partition;
			entropy -= modelProbability * Math.log(modelProbability);
		}

//				System.out.println("entropy = " + entropy);
		final double maxEntropy = Math.log(nextStates.size());
//				System.out.println("maxEntropy = " + maxEntropy);

		/*
		 * Normalize by max entropy.
		 * 
		 * score of 1 means minimal confident score of 0 means maximal confident
		 */
		entropy /= maxEntropy; // normalize
		entropy = 1 - entropy; // invert entropy to get confidence
		return entropy;
	}

	private String rate(PRF1 result, double entropy, double threshold, double f1) {

		if (entropy >= threshold && f1 == 1.0) {
			result.tp++;
			return "tp";
		}

		if (entropy >= threshold && f1 != 1.0) {
			result.fp++;
			return "fp";
		}

		if (entropy < threshold && f1 == 1.0) {
			result.fn++;
			return "fn";
		}

		if (entropy < threshold && f1 != 1.0) {
			result.tn++;
			return "tn";
		}

		return null;
	}

	private void activeLearning(AbstractOBIERunner runner) throws Exception {

		long allTime = System.currentTimeMillis();

		int i = 1;

		final IActiveLearningDocumentRanker ranker;

		if (acMode.equals("random")) {
			ranker = new FullDocumentRandomRanker(runner);
		} else if (acMode.equals("entropy")) {
			ranker = new FullDocumentEntropyRanker(runner);
		} else if (acMode.equals("rndFiller")) {
			ranker = new FullDocumentRandFillerRanker(runner);
		} else if (acMode.equals("entropyAtomic")) {
			ranker = new FullDocumentAtomicChangeEntropyRanker(runner);
		} else if (acMode.equals("variance")) {
			ranker = new FullDocumentVarianceRanker(runner);
		} else if (acMode.equals("objective")) {
			ranker = new FullDocumentObjectiveScoreRanker(runner);
		} else if (acMode.equals("model")) {
			ranker = new FullDocumentModelScoreRanker(runner);
		} else if (acMode.equals("length")) {
			ranker = new FullDocumentLengthRanker(runner);
		} else if (acMode.equals("margin")) {
			ranker = new FullDocumentMarginBasedRanker(runner);
		} else if (acMode.equals("single")) {
			ranker = new SingleSlotModelScoreRanker(runner);
		} else {
			ranker = null;
			log.error("unkown active learning mode");
			System.exit(1);
		}

		PrintStream resultPrintStream = new PrintStream(new FileOutputStream(printResults, true));
		resultPrintStream.println(
				"############Active Learning Performances: " + acMode + runner.getParameter().runID + "############");
		resultPrintStream.println("#Iteration\t#TrainData\tPrecision\tRecall\tF1");

		List<OBIEInstance> newTrainingInstances = new ArrayList<>();

		final int maxNumberOfIterations = 50;
		int iterationCounter = 0;

		List<String> performances = new ArrayList<>();
		PrintStream ps = new PrintStream(new File("pickedInstances"));

		do {

			if (++iterationCounter > maxNumberOfIterations) {
				log.info("#############################");
				log.info("Reached maximum number of iterations: " + maxNumberOfIterations);
				log.info("#############################");
				break;
			}

			final int c = iterationCounter;

			log.info("#############################");
			log.info("New active learning iteration: " + (i));
			log.info("#############################");

			long time = System.currentTimeMillis();

			if (newTrainingInstances.isEmpty()) {
				runner.train();
			} else {
				log.info("New instances:");
				newTrainingInstances.forEach(s -> log.info(c + "_NEW\t" + s.getName()));
				newTrainingInstances.forEach(s -> ps.println(c + "_NEW\t" + s.getName()));

				/**
				 * TODO: enable
				 */
//				runner.clean(getParameter());
//				runner.train();
			}

			log.info("Apply current model to test data...");

			Level trainerLevel = LogManager.getFormatterLogger(Trainer.class.getName()).getLevel();
			Level runnerLevel = LogManager.getFormatterLogger(AbstractOBIERunner.class).getLevel();

			Configurator.setLevel(Trainer.class.getName(), Level.FATAL);
			Configurator.setLevel(AbstractOBIERunner.class.getName(), Level.FATAL);

			List<SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState>> predictions = runner
					.testOnTest();

			log.info("Training instances:");
			runner.corpusProvider.getTrainingCorpus().getInternalInstances()
					.forEach(s -> log.info(c + "_TRAIN\t" + s.getName()));

			log.info("Test instances:");
			runner.corpusProvider.getTestCorpus().getInternalInstances()
					.forEach(s -> log.info(c + "_TEST\t" + s.getName()));

			Configurator.setLevel(Trainer.class.getName(), trainerLevel);
			Configurator.setLevel(AbstractOBIERunner.class.getName(), runnerLevel);

			PRF1 prf1 = EvaluatePrediction.evaluateSlotFillingPredictions(runner.getObjectiveFunction(), predictions,
					runner.getParameter().evaluator);

			final String logPerformance = iterationCounter + "\t"
					+ runner.corpusProvider.getTrainingCorpus().getInternalInstances().size() + "\t"
					+ prf1.getPrecision() + "\t" + prf1.getRecall() + "\t" + prf1.getF1();

			performances.add(logPerformance);
			resultPrintStream.println(logPerformance);

			log.info("############Active Learning performances: " + acMode + runner.getParameter().runID
					+ "############");
			performances.forEach(log::info);

			log.info("Time needed: " + (System.currentTimeMillis() - time));

		} while (!(newTrainingInstances = runner.corpusProvider.updateActiveLearning(runner, ranker)).isEmpty());
		ps.close();
		log.info("--------------" + acMode + runner.getParameter().runID + "---------------");

		log.info("Total time needed: " + (System.currentTimeMillis() - allTime));

		log.info("Print results to: " + printResults);

		resultPrintStream.close();

	}

	private void nFoldCrossValidation(AbstractOBIERunner runner, Class<? extends IOBIEThing> searchType,
			Boolean singleSlot, Boolean full) throws Exception {
		Map<Double, PRF1> meanConfidences = new HashMap<Double, PRF1>();
		PRF1 meanPerformanceCorrectEval = new PRF1(0, 0, 0);
		PRF1 meanPerformanceBestMatch = new PRF1(0, 0, 0);
//		PRF1 meanPerformanceFullEval = new PRF1(0, 0, 0);

		long allTime = System.currentTimeMillis();

		IOBIEEvaluator evaluatorCorrectEval = new CartesianSearchEvaluator(
				runner.getParameter().evaluator.isEnableCaching(),
				runner.getParameter().evaluator.getMaxEvaluationDepth(), true,
				runner.getParameter().evaluator.getOrListCondition(),
				runner.getParameter().evaluator.getMaxNumberOfAnnotations(),
				runner.getParameter().evaluator.isIgnoreEmptyInstancesOnEvaluation());
		IOBIEEvaluator evaluatorBestMatch = new CartesianSearchEvaluator(
				runner.getParameter().evaluator.isEnableCaching(),
				runner.getParameter().evaluator.getMaxEvaluationDepth(), false,
				runner.getParameter().evaluator.getOrListCondition(),
				runner.getParameter().evaluator.getMaxNumberOfAnnotations(),
				runner.getParameter().evaluator.isIgnoreEmptyInstancesOnEvaluation());
//		IOBIEEvaluator evaluatorFullEval = new CartesianSearchEvaluator(runner.getParameter().evaluator.isEnableCaching(),
//				runner.getParameter().evaluator.getMaxEvaluationDepth(),
//				true,
//				runner.getParameter().evaluator.getOrListCondition(),
//				runner.getParameter().evaluator.getMaxNumberOfAnnotations(),
//				runner.getParameter().evaluator.isIgnoreEmptyInstancesOnEvaluation());
//		String runID = "-454547908"; // ORGANISMMODEL
//		String runID = "-1972790544"; //INJURY
//		String runID = "-442745153"; // INVEST
		String runID = "-1350446652"; // TREATMENT
//		String runID = String.valueOf(new Random().nextInt());

		Map<AbstractIndividual, PRF1> results = new HashMap<>();
		while (runner.corpusProvider.nextFold()) {
			log.info("#############################");
			log.info("New " + ((FoldCrossCorpusDistributor) runner.getParameter().corpusDistributor).n
					+ "-fold cross validation iteration: "
					+ String.valueOf(runner.corpusProvider.getCurrentFoldIndex() + 1));
			long time = System.currentTimeMillis();

			log.info("Number of training data: "
					+ runner.corpusProvider.getTrainingCorpus().getInternalInstances().size());
			log.info("Number of test data: " + runner.corpusProvider.getTestCorpus().getInternalInstances().size());

//			System.out.println("Set training instances to:");
//			runner.corpusProvider.getTrainingCorpus().getInternalInstances().forEach(System.out::println);
//			System.out.println("Set test instances to:");
//			runner.corpusProvider.getTestCorpus().getInternalInstances().forEach(System.out::println);
			log.info("#############################");
			runner.clean(getParameter(runID, singleSlot, searchType, full));
//			try {
			runner.loadModel();
//			} catch (Exception e) {
//				System.err.println(e.getMessage());
//				runner.train();
//			}

//			runner.train();

			List<SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState>> predictions = runner
					.testOnTest();

			PRF1 prf1PerformanceCorrectEval = EvaluatePrediction
					.evaluateSlotFillingPredictions(runner.getObjectiveFunction(), predictions, evaluatorCorrectEval);
			meanPerformanceCorrectEval.add(prf1PerformanceCorrectEval);

			PRF1 prf1PerformanceBestMatch = EvaluatePrediction
					.evaluateSlotFillingPredictions(runner.getObjectiveFunction(), predictions, evaluatorBestMatch);
			meanPerformanceBestMatch.add(prf1PerformanceBestMatch);

//			PRF1 prf1PerformanceFullEval = EvaluatePrediction.evaluateREPredictions(runner.getObjectiveFunction(),
//					predictions, evaluatorFullEval);
//			meanPerformanceFullEval.add(prf1PerformanceFullEval);

			log.info("Time needed: " + (System.currentTimeMillis() - time));

//		
			Map<Double, PRF1> prf1Confidence = evaluate(runner, time);
			for (Entry<Double, PRF1> confidence : prf1Confidence.entrySet()) {
				meanConfidences.putIfAbsent(confidence.getKey(), new PRF1());
				meanConfidences.get(confidence.getKey()).add(confidence.getValue());
			}

		}
		for (Entry<Double, PRF1> meanConfidence : meanConfidences.entrySet()) {
			log.info(meanConfidence.getKey() + "\t" + meanConfidence.getValue().tp + "\t" + meanConfidence.getValue().fp
					+ "\t" + meanConfidence.getValue().fn + "\t" + meanConfidence.getValue().tn + "\t"
					+ meanConfidence.getValue().getPrecision() + "\t" + meanConfidence.getValue().getRecall() + "\t"
					+ meanConfidence.getValue().getF1() + "\t" + meanConfidence.getValue().getAccuracy());
		}

		log.info("full = " + full + "\tsearchType = " + searchType.getSimpleName() + "\tsingleSlot = " + singleSlot
				+ "\t" + ((FoldCrossCorpusDistributor) runner.getParameter().corpusDistributor).n
				+ " fold cross validation mean performance correctEval: " + meanPerformanceCorrectEval);
		log.info("full = " + full + "\tsearchType = " + searchType.getSimpleName() + "\tsingleSlot = " + singleSlot
				+ "\t" + ((FoldCrossCorpusDistributor) runner.getParameter().corpusDistributor).n
				+ " fold cross validation mean performance Best Match: " + meanPerformanceBestMatch);
//		log.info(((FoldCrossCorpusDistributor) runner.getParameter().corpusDistributor).n
//				+ " fold cross validation mean performance FullEval: " + meanPerformanceFullEval);

		for (Entry<AbstractIndividual, PRF1> ie : results.entrySet()) {
			log.info(ie.getKey().name + "-->" + ie.getValue().getF1());
		}

		log.info("Time needed: " + (System.currentTimeMillis() - allTime));

	}
}
