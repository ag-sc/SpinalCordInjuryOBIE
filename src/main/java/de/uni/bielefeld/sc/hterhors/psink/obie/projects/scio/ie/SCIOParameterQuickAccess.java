package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.projects.AbstractProjectEnvironment;
import de.hterhors.obie.ml.corpus.distributor.AbstractCorpusDistributor;
import de.hterhors.obie.ml.corpus.distributor.ActiveLearningDistributor;
import de.hterhors.obie.ml.corpus.distributor.FoldCrossCorpusDistributor;
import de.hterhors.obie.ml.corpus.distributor.ShuffleCorpusDistributor;
import de.hterhors.obie.ml.corpus.distributor.ActiveLearningDistributor.Builder.EMode;
import de.hterhors.obie.ml.evaluation.DatatypeOrListConditon;
import de.hterhors.obie.ml.evaluation.evaluator.BeamSearchEvaluator;
import de.hterhors.obie.ml.evaluation.evaluator.CartesianSearchEvaluator;
import de.hterhors.obie.ml.evaluation.evaluator.IOBIEEvaluator;
import de.hterhors.obie.ml.evaluation.evaluator.StrictNamedEntityLinkingEvaluator;
import de.hterhors.obie.ml.explorer.AbstractOBIEExplorer;
import de.hterhors.obie.ml.explorer.EntityRecognitionAndLinkingExplorer;
import de.hterhors.obie.ml.explorer.IExplorationCondition;
import de.hterhors.obie.ml.explorer.SlotCardinalityExplorer;
import de.hterhors.obie.ml.explorer.SlotFillerExplorer;
import de.hterhors.obie.ml.run.InvestigationRestriction;
import de.hterhors.obie.ml.run.InvestigationRestriction.RestrictedField;
import de.hterhors.obie.ml.run.param.EInstantiationType;
import de.hterhors.obie.ml.run.param.EScorerType;
import de.hterhors.obie.ml.run.param.IInitializeNumberOfObjects;
import de.hterhors.obie.ml.run.param.RunParameter.Builder;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.templates.InBetweenContextTemplate;
import de.hterhors.obie.ml.templates.InterTokenTemplate;
import de.hterhors.obie.ml.templates.LocalTemplate;
import de.hterhors.obie.ml.templates.TokenContextTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.AnimalModelConditionTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.CoRefChainTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.SemanticNumericDataTypeTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.VertebralLocationConditionTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnimalModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.PostsurgicalMedication;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IGroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITreatment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IVertebralLocation;
import learning.optimizer.Optimizer;
import learning.optimizer.SGD;
import learning.regularizer.Regularizer;
import libsvm.svm_parameter;

public class SCIOParameterQuickAccess {

	public final static IInjury keepOnAutoImport_I = null;
	public final static IInvestigationMethod keepOnAutoImport_IM = null;
	public final static IOrganismModel keepOnAutoImport_AM = null;
	public final static ITreatment keepOnAutoImport_T = null;
	public final static IExperimentalGroup keepOnAutoImport_E = null;
	public final static IGroupName keepOnAutoImport_GN = null;
	public final static Random keepOnAutoImport = null;

	/**
	 * The corpus data type defines the data that is stored in the provided corpus.
	 * This might be the same class as the search type or somehow related to the
	 * search type. However, if the search type is unrelated to the corpus type
	 * there wont be any data to train / predict.
	 * 
	 * You can even provide more than one type to create a bigger corpus and then
	 * select just one or a subset type using the search type.
	 * 
	 */
	final private static Class<? extends ISCIOThing> corpusType = IOrganismModel.class;

	/**
	 * The search type defines the root class type to sample. This should be the
	 * same as the corpus type or ontological below. I.e. the corpus the might be
	 * OrganismModel, but you could still search only or RatModels.
	 *
	 * However, usually the search type is the same as the corpus type.
	 *
	 */
	final private static Class<? extends ISCIOThing> searchType = corpusType;

	/***
	 * The runID. This serves as an identifier for locating and saving the model.If*
	 * anything was changed during the development the runID should be reset.
	 */
//	public final static String runID = "1";
	private static final String runID = String.valueOf(new Random().nextInt());

	public static Builder getDevelopmentNERParameter() {
		final String personalNote = "Dev";
		final Class<? extends IOBIEThing>[] explorationClasses = new Class[] { PostsurgicalMedication.class };

		svm_parameter param = new svm_parameter();
		param.eps = 0.01;
		param.p = 0.1;
		param.C = 0.0001;
		param.svm_type = svm_parameter.EPSILON_SVR;
		param.kernel_type = svm_parameter.LINEAR;
		param.cache_size = 12000;
		param.gamma = 0.0001;

		final File rootDirectory = new File(".");
		final int epochs = 20;
		final Optimizer optimizer = new SGD(0.0001, 0, 0.000001, false);
		final EScorerType scorerType = EScorerType.EXP;

		final boolean multiThreading = true;

		final boolean exploreExistingTemplates = false;
		final boolean exploreOnOntologyLevel = false;
		final boolean enableDiscourseProgression = false;

		IExplorationCondition explorationCondition = new SCIOExplorationConditions();

		InvestigationRestriction sampleRestrictions =
				// new InvestigationRestriction(searchType);
				InvestigationRestriction.noRestrictionInstance;

		// InvestigationRestriction sampleRestrictions = new
		// InvestigationRestriction(searchType, restrictFields, true);

		/**
		 * HACK: REMOVE THIS HACK With the correct number of entities!
		 */
		// IInitializeNumberOfObjects numberOfInitializedObjects = instance ->
		// instance.getGoldAnnotation().entities
		// .size();
		IInitializeNumberOfObjects numberOfInitializedObjects = instance -> 1;
		Random rndForSampling = new Random(100L);

		int numberOfMaxSamplingSteps = 100;
		Regularizer regularizer = null;
//		Regularizer regularizer = new L2(0.01);
		AbstractProjectEnvironment scioEnvironment = SCIOProjectEnvironment.getInstance();

		final int maxEvaluationDepth = Integer.MAX_VALUE;
		final boolean penalizeCardinality = true;

		int maxNumberOfEntityElements = 20;
		int maxNumberOfDataTypeElements = 20;
		final boolean ignoreEmptyInstancesOnEvaluation = false;

		IOBIEEvaluator evaluator = new StrictNamedEntityLinkingEvaluator();

		Set<Class<? extends AbstractOBIEExplorer>> explorerTypes = new HashSet<>();

		explorerTypes.add(EntityRecognitionAndLinkingExplorer.class);

		Set<Class<? extends AbstractOBIETemplate<?>>> templates = new HashSet<>();

		// templates.add(HeterogeneousSlotTemplate.class);
		// templates.add(FrequencyTemplate.class);

		// templates.add(StringSimilarityTemplate.class);
		//
		// templates.add(CooccurrenceTemplate.class);

		// templates.add(SemanticNumericDataTypeTemplate.class);

		templates.add(TokenContextTemplate.class);
		templates.add(InterTokenTemplate.class);

		// if (IOrganismModel.class.isAssignableFrom(searchType))
		// templates.add(AnimalModelConditionTemplate.class);

		// templates.add(DocumentClassificationTemplate.class);
		//
		// templates.add(SlotIsFilledTemplate.class);

		// templates.add(HierarchyTemplate.class);

		// templates.add(Word2VecClusterTemplate.class);

		// templates.add(NERTemplate.class);

		// templates.add(PropertyEvidenceForClassTemplate.class);

		// templates.add(InBetweenContextTemplate.class);
		// templates.add(LocalTemplate.class);

		// templates.add(LocalLocalityTemplate.class);
		// templates.add(GlobalLocalityTemplate.class);
		// templates.add(GlobalSentenceLocalityTemplate.class);
		// templates.add(LocalityTemplate.class);

		/*
		 * Cardinality
		 */

		// templates.add(EmptyRootClassCardinalityTemplate.class);
		// templates.add(RootClassCardinalityTemplate.class);
		// templates.add(MainSlotVarietyTemplate.class);

		return new Builder().setOptimizer(optimizer).setCorpusDistributor(shuffleDist())
				.setEnableDiscourseProgression(enableDiscourseProgression).setEpochs(epochs)
				.setManualExploreClassesWithoutEvidence(explorationClasses)
				.setExploreExistingTemplates(exploreExistingTemplates).setExploreOnOntologyLevel(exploreOnOntologyLevel)
				.setExplorationCondition(explorationCondition).setExplorers(explorerTypes)
				.setInvestigationRestriction(sampleRestrictions).setMultiThreading(multiThreading)
				.setNumberOfInitializedObjects(numberOfInitializedObjects)
				.setNumberOfMaxSamplingSteps(numberOfMaxSamplingSteps).setPersonalNotes(personalNote)
				.setRegularizer(regularizer).setRootDirectory(rootDirectory).addRootSearchType(searchType)
				.setProjectEnvironment(scioEnvironment).setScorerType(scorerType).setSvmParam(param)
				.setTemplates(templates).setRunID(runID).setEvaluator(evaluator)
				.setMaxNumberOfEntityElements(maxNumberOfEntityElements)
				.setMaxNumberOfDataTypeElements(maxNumberOfDataTypeElements).setRandomForSampling(rndForSampling);

	}

	public static Builder getREParameter() {
		final String personalNote = "UNDER DEVELOPMENT";
		final Class<? extends IOBIEThing>[] explorationClasses = new Class[] { PostsurgicalMedication.class };

		svm_parameter SVMParam = new svm_parameter();
		SVMParam.eps = 0.01;
		SVMParam.p = 0.1;
		SVMParam.C = 0.0001;
		SVMParam.svm_type = svm_parameter.EPSILON_SVR;
		SVMParam.kernel_type = svm_parameter.LINEAR;
		SVMParam.cache_size = 12000;
		SVMParam.gamma = 0.0001;

		final File rootDirectory = new File(".");

		final int epochs = 5;

		final Optimizer optimizer = new SGD(0.0001, 0, 0.00001, false);
		final EScorerType scorerType = EScorerType.EXP;

		final boolean multiThreading = true;

		final boolean exploreExistingTemplates = false;
		final boolean exploreOnOntologyLevel = true;
		final boolean enableDiscourseProgression = false;

		IExplorationCondition explorationCondition = new SCIOExplorationConditions();

		final EInstantiationType initializer = EInstantiationType.EMPTY;

//		 Set<RestrictedField> restrictFields = new HashSet<>();
//		 restrictFields.add(new RestrictedField("gender", true));
//		 restrictFields.add(new RestrictedField("age", true));
//		 restrictFields.add(new RestrictedField("ageCategory", true));
//		 restrictFields.add(new RestrictedField("weight", true));
//		 restrictFields.add(new RestrictedField("organismSpecies", true));

//		Set<RestrictedField> restrictFields = new HashSet<>();
//		restrictFields.add(new RestrictedField("injuryVertebralLocation", true));
//		restrictFields.add(new RestrictedField("injuryDevice", true));
//		restrictFields.add(new RestrictedField("injuryArea", true));
//		restrictFields.add(new RestrictedField("force", true));
//		restrictFields.add(new RestrictedField("weight", true));
//		restrictFields.add(new RestrictedField("volume", true));
//		restrictFields.add(new RestrictedField("pressure", true));
//		restrictFields.add(new RestrictedField("distance", true));
//		restrictFields.add(new RestrictedField("duration", true));

		InvestigationRestriction sampleRestrictions =
//				 new InvestigationRestriction(searchType, restrictFields);

				InvestigationRestriction.noRestrictionInstance;

		// InvestigationRestriction sampleRestrictions = new
		// InvestigationRestriction(searchType, restrictFields, true);

		/**
		 * HACK: REMOVE THIS HACK With the correct number of entities!
		 */
		// IInitializeNumberOfObjects numberOfInitializedObjects = instance ->
		// instance.getGoldAnnotation().getEntities()
		// .size();
		IInitializeNumberOfObjects numberOfInitializedObjects = instance -> 1;

		int numberOfMaxSamplingSteps = 100;
		Regularizer regularizer = null;
//		Regularizer regularizer = new L2(0.01);
		AbstractProjectEnvironment scioEnvironment = SCIOProjectEnvironment.getInstance();

		// AbstractConfigBuilder<?> config = getQuickNFoldSCIOConfigFull();

		// AbstractConfigBuilder<?> config = getQuickActiveLearningConfigFull();

		final int maxEvaluationDepth = Integer.MAX_VALUE;
		final boolean penalizeCardinality = true;
		final boolean enableCaching = true;

		int maxNumberOfEntityElements = 7;
		int maxNumberOfDataTypeElements = 20;
		Random rndForSampling = new Random(100L);

		boolean ignoreEmptyInstancesOnEvaluation = false;

		// IEvaluator evaluator = new BeamSearchPRF1(enableCaching,
		// maxEvaluationDepth, penalizeCardinality,
		// sampleRestrictions, new SCIOOrListConditon(),
		// maxNumberOfEntityElements,
		// ignoreEmptyInstancesOnEvaluation);

		IOBIEEvaluator evaluator = new CartesianSearchEvaluator(enableCaching, maxEvaluationDepth, penalizeCardinality,
				sampleRestrictions, new DatatypeOrListConditon(), maxNumberOfEntityElements,
				ignoreEmptyInstancesOnEvaluation);

		Map<Class<? extends IOBIEThing>, List<IOBIEThing>> initializationObjects = new HashMap<>();

		List<IOBIEThing> initObjectList = new ArrayList<>();
		AnimalModel initObject = new AnimalModel();
		initObjectList.add(initObject);
		initializationObjects.put(searchType, initObjectList);

		Set<Class<? extends AbstractOBIEExplorer>> explorerTypes = new HashSet<>();

		// explorerTypes.add(NoChangeExplorer.class);
		explorerTypes.add(SlotFillerExplorer.class);
//		explorerTypes.add(DependentCardinalityExplorer.class);

		explorerTypes.add(SlotCardinalityExplorer.class);
		// explorerTypes.add(TemplateCardinalityExplorer.class);

		Set<Class<? extends AbstractOBIETemplate<?>>> templates = new HashSet<>();

		// templates.add(HeterogeneousSlotTemplate.class);
		// templates.add(FrequencyTemplate.class);

		// templates.add(StringSimilarityTemplate.class);
		//
		// templates.add(CooccurrenceTemplate.class);

		templates.add(SemanticNumericDataTypeTemplate.class);

		templates.add(TokenContextTemplate.class);
		templates.add(InterTokenTemplate.class);

		if (IOrganismModel.class.isAssignableFrom(searchType))
			templates.add(AnimalModelConditionTemplate.class);

		if (IVertebralLocation.class.isAssignableFrom(searchType) || IInjury.class.isAssignableFrom(searchType))
			templates.add(VertebralLocationConditionTemplate.class);

		// templates.add(DocumentClassificationTemplate.class);
		//
		// templates.add(SlotIsFilledTemplate.class);

		// templates.add(HierarchyTemplate.class);

		// templates.add(Word2VecClusterTemplate.class);
		// templates.add(NERTemplate.class);

		// templates.add(PropertyEvidenceForClassTemplate.class);

		templates.add(InBetweenContextTemplate.class);
		templates.add(LocalTemplate.class);

		// templates.add(LocalLocalityTemplate.class);
		// templates.add(GlobalLocalityTemplate.class);
		// templates.add(GlobalSentenceLocalityTemplate.class);
		// templates.add(LocalityTemplate.class);

		/*
		 * Cardinality
		 */

		// templates.add(EmptyRootClassCardinalityTemplate.class);
		// templates.add(RootClassCardinalityTemplate.class);
//		 templates.add(MainSlotVarietyTemplate.class);

		String corpusNamePrefix = "annodb_27082018";

		AbstractCorpusDistributor corpusConfiguration = shuffleDist();

		return new Builder().setOptimizer(optimizer).setCorpusDistributor(corpusConfiguration)
				.setEnableDiscourseProgression(enableDiscourseProgression).setEpochs(epochs)
				.setManualExploreClassesWithoutEvidence(explorationClasses)
				.setExploreExistingTemplates(exploreExistingTemplates).setExploreOnOntologyLevel(exploreOnOntologyLevel)
				.setExplorationCondition(explorationCondition).setExplorers(explorerTypes)
				.setInitializationObjects(initializationObjects).setInstantiationType(initializer)
				.setInvestigationRestriction(sampleRestrictions).setMultiThreading(multiThreading)
				.setNumberOfInitializedObjects(numberOfInitializedObjects)
				.setNumberOfMaxSamplingSteps(numberOfMaxSamplingSteps).setPersonalNotes(personalNote)
				.setRegularizer(regularizer).setRootDirectory(rootDirectory).addRootSearchType(searchType)
				.setProjectEnvironment(scioEnvironment).setScorerType(scorerType).setSvmParam(SVMParam)
				.setTemplates(templates).setRunID(runID).setEvaluator(evaluator)
				.setMaxNumberOfEntityElements(maxNumberOfEntityElements)
				.setMaxNumberOfDataTypeElements(maxNumberOfDataTypeElements).setRandomForSampling(rndForSampling);

	}

	public static Builder getDevelopmentCoRefChainParameter() {

		final String personalNote = "UNDER DEVELOPMENT";

		final Class<? extends IOBIEThing>[] explorationClasses = new Class[] { PostsurgicalMedication.class };

		svm_parameter param = new svm_parameter();
		param.eps = 0.01;
		param.p = 0.1;
		param.C = 0.0001;
		param.svm_type = svm_parameter.EPSILON_SVR;
		param.kernel_type = svm_parameter.LINEAR;
		param.cache_size = 12000;
		param.gamma = 0.0001;

		final File rootDirectory = new File(".");
		final int epochs = 5;
		final Optimizer optimizer = new SGD(0.01, 0, 0.00001, false);
		final EScorerType scorerType = EScorerType.EXP;

		final boolean multiThreading = true;

		final boolean exploreExistingTemplates = true;

		final boolean exploreOnOntologyLevel = false;
		final boolean enableDiscourseProgression = false;

		IExplorationCondition explorationCondition = new SCIOExplorationConditions();

		final EInstantiationType initializer = EInstantiationType.EMPTY;

		Set<RestrictedField> restrictFields = new HashSet<>();
		restrictFields.add(new RestrictedField("groupNames", true));

		InvestigationRestriction sampleRestrictions = new InvestigationRestriction(searchType, restrictFields, true);

		final int maxEvaluationDepth = Integer.MAX_VALUE;
		final boolean penalizeCardinality = true;
		final boolean enableCaching = true;

		boolean ignoreEmptyInstancesOnEvaluation = false;

		int maxNumberOfDataTypeElements = 1000;
		int maxNumberOfEntityElements = 1000;

		Random rndForSampling = new Random(100L);

		IOBIEEvaluator evaluator = new BeamSearchEvaluator(5);

		// IEvaluator evaluator = new PurityPRF1(false, maxEvaluationDepth,
		// penalizeCardinality, sampleRestrictions,
		// maxNumberOfEntityElements, ignoreEmptyInstancesOnEvaluation);

		// IEvaluator evaluator = new CartesianPRF1(enableCaching,
		// maxEvaluationDepth, penalizeCardinality,
		// sampleRestrictions, maxNumberOfEntityElements,
		// ignoreEmptyInstancesOnEvaluation);

		/**
		 * HACK: REMOVE THE HACK With the correct number of entities!
		 */
		// IInitializeNumberOfObjects numberOfInitializedObjects = instance ->
		// instance.getGoldAnnotation().getEntities()
		// .size();

		IInitializeNumberOfObjects numberOfInitializedObjects = instance -> 1;

		int numberOfMaxSamplingSteps = 100;
		Regularizer regularizer = null;
//		Regularizer regularizer = new L2(0.01);

		AbstractProjectEnvironment scioEnvironment = SCIOProjectEnvironment.getInstance();

		Set<Class<? extends AbstractOBIEExplorer>> explorerTypes = new HashSet<>();

		// explorerTypes.add(NoChangeExplorer.class);
		explorerTypes.add(SlotFillerExplorer.class);
		explorerTypes.add(SlotCardinalityExplorer.class);
		// explorerTypes.add(TemplateCardinalityExplorer.class);

		Set<Class<? extends AbstractOBIETemplate<?>>> templates = new HashSet<>();

		/*
		 * Co-Reference Chain Resolution
		 */

		templates.add(CoRefChainTemplate.class);

		return new Builder().setOptimizer(optimizer).setEnableDiscourseProgression(enableDiscourseProgression)
				.setEpochs(epochs).setManualExploreClassesWithoutEvidence(explorationClasses)
				.setExploreExistingTemplates(exploreExistingTemplates).setExploreOnOntologyLevel(exploreOnOntologyLevel)
				.setExplorationCondition(explorationCondition).setExplorers(explorerTypes)
				.setInstantiationType(initializer).setInvestigationRestriction(sampleRestrictions)
				.setMultiThreading(multiThreading).setNumberOfInitializedObjects(numberOfInitializedObjects)
				.setNumberOfMaxSamplingSteps(numberOfMaxSamplingSteps).setPersonalNotes(personalNote)
				.setRegularizer(regularizer).setRootDirectory(rootDirectory).addRootSearchType(searchType)
				.setProjectEnvironment(scioEnvironment).setScorerType(scorerType).setSvmParam(param)
				.setTemplates(templates).setRunID(runID).setEvaluator(evaluator)
				.setMaxNumberOfEntityElements(maxNumberOfEntityElements)
				.setMaxNumberOfDataTypeElements(maxNumberOfDataTypeElements).setRandomForSampling(rndForSampling);
	}

	public static AbstractCorpusDistributor shuffleDist() {
		return new ShuffleCorpusDistributor.Builder().setTrainingProportion(80).setDevelopmentProportion(0)
				.setTestProportion(20).build();
	}

	public static AbstractCorpusDistributor foldCrossDist() {
		return new FoldCrossCorpusDistributor.Builder().setN(6).setSeed(12345L).build();
	}

	public static AbstractCorpusDistributor activeLearnigDist() {
		return new ActiveLearningDistributor.Builder().setMode(EMode.ABSOLUT).setBAbsolute(1).setSeed(100L)
				.setInitialTrainingSelectionFraction(0.01F).setTrainingProportion(80).setTestProportion(20).build();
	}
}
