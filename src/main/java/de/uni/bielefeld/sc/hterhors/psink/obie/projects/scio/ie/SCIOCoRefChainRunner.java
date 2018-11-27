package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.evaluation.PRF1;
import de.hterhors.obie.ml.objfunc.REObjectiveFunction;
import de.hterhors.obie.ml.run.AbstractRunner;
import de.hterhors.obie.ml.run.eval.EvaluatePrediction;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.stopcrit.training.EarlyStoppingNoChange;
import de.hterhors.obie.ml.variables.InstanceTemplateAnnotations;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.hterhors.obie.ml.variables.OBIEState;
import learning.ObjectiveFunction;
import learning.Trainer;
import learning.Trainer.EpochCallback;
import sampling.DefaultSampler;

public class SCIOCoRefChainRunner extends AbstractRunner {

	/*
	 * 
	 */
	public static Logger log = LogManager.getFormatterLogger(SCIOCoRefChainRunner.class.getSimpleName());

	protected EarlyStoppingNoChange earlyStopping = new EarlyStoppingNoChange();

	public SCIOCoRefChainRunner(RunParameter parameter) {
		super(parameter);
	}

	public SCIOCoRefChainRunner() {
		this(SCIOParameterQuickAccess.getDevelopmentCoRefChainParameter().build());
	}

	@Override
	public ObjectiveFunction<OBIEState, InstanceTemplateAnnotations> getObjectiveFunction() {
		return new REObjectiveFunction(getParameter());
	}

	@Override
	protected List<EpochCallback> addEpochCallbackOnTrain(
			DefaultSampler<OBIEInstance, OBIEState, InstanceTemplateAnnotations> sampler) {
		return Arrays.asList(
				//
				new EpochCallback() {
					@Override
					public void onStartEpoch(Trainer caller, int epoch, int numberOfEpochs, int numberOfInstances) {
						try {
							if (epoch == 0 || Math.random() >= 0.9) {
								log.info("Use Objective Score for sampling...");
								trainWithObjective = true;
								sampler.setTrainSamplingStrategy(RunParameter.trainSamplingStrategyObjectiveScore);
								sampler.setTrainAcceptStrategy(RunParameter.trainAcceptanceStrategyObjectiveScore);
							} else {
								trainWithObjective = false;
								log.info("Use Model Score for sampling...");
								sampler.setTrainSamplingStrategy(RunParameter.trainSamplingStrategyModelScore);
								sampler.setTrainAcceptStrategy(RunParameter.trainAcceptanceStrategyModelScore);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				},
				//
				new EpochCallback() {
					@Override
					public void onEndEpoch(Trainer caller, int epoch, int numberOfEpochs, int numberOfInstances) {
						try {
							try {
								if (corpusProvider.getDevelopCorpus().getInternalInstances().isEmpty()) {
									log.warn("+++++++++++++++++++++++++++++++++++");
									log.warn(
											"WARN! No development data available. Can not check early stopping criterion!");
									log.warn("+++++++++++++++++++++++++++++++++++");
									return;
								}
							} catch (RuntimeException e) {
								log.warn("+++++++++++++++++++++++++++++++++++");
								log.warn("Can not perform end epoch evaluation. No Development set available.");
								log.warn("+++++++++++++++++++++++++++++++++++");
								return;
							}
							PRF1 prf1 = EvaluatePrediction.evaluateREPredictions(getObjectiveFunction(), testOnDev(),
									getParameter().evaluator);

							caller.stopTraining = earlyStopping.checkConditions(prf1.getF1());
							PrintStream ps = new PrintStream(new FileOutputStream(new File("scio/dev_results"), true));
							ps.println(prf1.toString());
							ps.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
	}

}