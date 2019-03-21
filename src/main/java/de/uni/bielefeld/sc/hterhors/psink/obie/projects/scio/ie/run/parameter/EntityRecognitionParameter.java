package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter;

import java.io.File;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.corpus.distributor.AbstractCorpusDistributor;
import de.hterhors.obie.ml.corpus.distributor.FoldCrossCorpusDistributor;
import de.hterhors.obie.ml.corpus.distributor.ShuffleCorpusDistributor;
import de.hterhors.obie.ml.evaluation.evaluator.StrictNamedEntityLinkingEvaluator;
import de.hterhors.obie.ml.explorer.AbstractOBIEExplorer;
import de.hterhors.obie.ml.explorer.EntityRecognitionExplorer;
import de.hterhors.obie.ml.ner.candidateRetrieval.lucene.LuceneRetrieval;
import de.hterhors.obie.ml.ner.dictionary.IDictionary;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.run.param.RunParameter.Builder;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.templates.InterTokenTemplate;
import de.hterhors.obie.ml.templates.TokenContextTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.EntityRecognitionProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.ShallowAnnotationGuideline;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.dict.TrainingDataDictionary;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

public class EntityRecognitionParameter {

	/**
	 * The search type defines the root class to explore.
	 *
	 * TODO: Chose the root type of interest for the procedure.
	 * 
	 */
	private static Class<? extends ISCIOThing> rootSearchType = IOrganismModel.class;

	/***
	 * The runID. This serves as an identifier for locating and saving the model.If*
	 * anything was changed during the development the runID should be reset.
	 */
	private static final String runID = String.valueOf(new Random().nextInt());

	/**
	 * Returns the set of predefined parameter.
	 * 
	 * @return the run parameter.
	 */
	public static RunParameter getPreDefinedParameter() {
		return getPreDefinedParameterBuilder().build();
	}

	/**
	 * Returns the predefined set of parameter. Parameter might be changed later on.
	 * 
	 * @return the Builder of the predefined set of parameter.
	 */
	public static Builder getPreDefinedParameterBuilder() {

		/**
		 * Just some personal notes. Might be ignored.
		 */
		final String personalNote = "Entity recognition...";

		/**
		 * the root directory to store or load the model.
		 */
		final File rootDirectory = new File(".");

		/**
		 * Number of epochs in the training procedure.
		 * 
		 * TODO: A parameter to play with. However, 10 seems to be reasonable for many
		 * problems.
		 */
		final int epochs = 10;

		/**
		 * Classes to search for. This can be limited in order to train/ test for single
		 * classes only. Does not have to be changed.
		 */
		final Set<Class<? extends IOBIEThing>> searchTypes = ShallowAnnotationGuideline
				.getClassRestrictions(rootSearchType);

		/**
		 * Whether to train in multi-threading. Turn off only for debugging.
		 */
		final boolean multiThreading = false;

		/**
		 * Random seed generation for sampling procedure. Fix seed for deterministic
		 * state generation during debugging or development. Does not have to be
		 * changed.
		 */
		final Random rndForSampling = new Random(100L);

		/**
		 * 
		 * The dictionary for candidate retrieval.
		 * 
		 * TODO: Select dictionary that corresponds the the root search type.
		 */
		IDictionary dict = new TrainingDataDictionary(new File("dictionaries/organismModel.dict"));

		/**
		 * The candidate retrieval, based on Lucene search fed with the dictionary.
		 */
		final LuceneRetrieval candidateRetrieval = new LuceneRetrieval(dict);

		/**
		 * The set of state space exploration strategies. For NERL just one is
		 * necessary. Does not have to be changed.
		 */
		final Set<Class<? extends AbstractOBIEExplorer>> explorerTypes = new HashSet<>();
		/**
		 * We only need the entity recognition exploration strategy. Text span and class
		 * label assignment happens jointly.
		 */
		explorerTypes.add(EntityRecognitionExplorer.class);

		/**
		 * The distribution of the data set. Shuffle takes all instances shuffles and
		 * redistribute according to the set proportions e.g. 80 train 20 test.
		 *
		 * TODO: Might be changed to 10 fold cross validation later on.
		 */
		final AbstractCorpusDistributor datasetDistributor = new ShuffleCorpusDistributor.Builder()
				/**
				 * Set corpus size fraction. Set to 1 to use the full corpus. During development
				 * and debugging this can be much lower in order to speed up the systems
				 * runtime.
				 */
				.setCorpusSizeFraction(1F)

				/**
				 * Set the proportions. Usually 60/20/20 or 80/0/20 is a good distribution
				 * proportion.
				 */
				.setTrainingProportion(80).setDevelopmentProportion(0).setTestProportion(20)
				/**
				 * Build.
				 */
				.build();

		/*
		 * Build and return.
		 */
		return new Builder().setProjectEnvironment(EntityRecognitionProjectEnvironment.getInstance())
				.setOntologyEnvironment(OntologyEnvironment.getInstance()).setEpochs(epochs).setExplorers(explorerTypes)
				.setMultiThreading(multiThreading).setPersonalNotes(personalNote).setRootDirectory(rootDirectory)
				.setRootSearchTypes(searchTypes).setRunID(runID).setEvaluator(new StrictNamedEntityLinkingEvaluator())
				.setRandomForSampling(rndForSampling).setNumberOfInitializedObjects(i -> 0)
				.setCandidateRetrieval(candidateRetrieval).setCorpusDistributor(datasetDistributor);
	}

}
