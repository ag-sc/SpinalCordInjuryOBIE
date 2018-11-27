package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.ml.objfunc.NERLObjectiveFunction;
import de.hterhors.obie.ml.run.AbstractRunner;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.variables.InstanceTemplateAnnotations;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.hterhors.obie.ml.variables.OBIEState;
import learning.ObjectiveFunction;
import learning.Trainer;
import learning.Trainer.EpochCallback;
import sampling.DefaultSampler;

public class SCIONERRunner extends AbstractRunner {
	/*
	 * 
	 */
	public static Logger log = LogManager.getFormatterLogger(SCIONERRunner.class.getSimpleName());

	/*
	 * Starts the bigram NER -procedure with default parameter.
	 */
	public SCIONERRunner(RunParameter parameter)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		super(parameter);
	}

	public SCIONERRunner() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		this(SCIOParameterQuickAccess.getDevelopmentNERParameter().build());
	}

	@Override
	public ObjectiveFunction<OBIEState, InstanceTemplateAnnotations> getObjectiveFunction() {
		return new NERLObjectiveFunction(getParameter());
	}

	@Override
	protected List<EpochCallback> addEpochCallbackOnTrain(
			DefaultSampler<OBIEInstance, OBIEState, InstanceTemplateAnnotations> sampler) {
		return Arrays.asList(new EpochCallback() {
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
		});
	}

}