package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import de.hterhors.obie.core.ontology.InvestigationRestriction;
import de.hterhors.obie.core.ontology.InvestigationRestriction.RestrictedField;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.projects.AbstractProjectEnvironment;
import de.hterhors.obie.ml.corpus.distributor.AbstractCorpusDistributor;
import de.hterhors.obie.ml.corpus.distributor.ActiveLearningDistributor;
import de.hterhors.obie.ml.corpus.distributor.ActiveLearningDistributor.Builder.EMode;
import de.hterhors.obie.ml.corpus.distributor.FoldCrossCorpusDistributor;
import de.hterhors.obie.ml.corpus.distributor.ShuffleCorpusDistributor;
import de.hterhors.obie.ml.evaluation.evaluator.CartesianSearchEvaluator;
import de.hterhors.obie.ml.evaluation.evaluator.IOBIEEvaluator;
import de.hterhors.obie.ml.explorer.AbstractOBIEExplorer;
import de.hterhors.obie.ml.explorer.IExplorationCondition;
import de.hterhors.obie.ml.explorer.SlotCardinalityExplorer;
import de.hterhors.obie.ml.explorer.SlotFillerExplorer;
import de.hterhors.obie.ml.run.param.EInstantiationType;
import de.hterhors.obie.ml.run.param.EScorerType;
import de.hterhors.obie.ml.run.param.IInitializeNumberOfObjects;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.run.param.RunParameter.Builder;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.templates.DSSlotFillerClusterDistanceTemplate;
import de.hterhors.obie.ml.templates.EmptyRootClassCardinalityTemplate;
import de.hterhors.obie.ml.templates.InBetweenContextTemplate;
import de.hterhors.obie.ml.templates.InterTokenTemplate;
import de.hterhors.obie.ml.templates.LocalTemplate;
import de.hterhors.obie.ml.templates.MainSlotVarietyTemplate;
import de.hterhors.obie.ml.templates.RootClassCardinalityTemplate;
import de.hterhors.obie.ml.templates.SlotFillerClusterDistanceTemplate;
import de.hterhors.obie.ml.templates.TokenContextTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOExplorationConditions;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.SlotFillingProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling.SemanticNumericDataTypeTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling.animal.AnimalModelConditionTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling.injury.VertebralLocationConditionTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnimalModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.PostsurgicalMedication;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.VertebralArea;
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
import learning.regularizer.L2;
import learning.regularizer.Regularizer;

public class SlotFillingParameter {

	public final static IOrganismModel keepOnAutoImport_AM = null;
	public final static IInjury keepOnAutoImport_I = null;
	public final static ITreatment keepOnAutoImport_T = null;
	public final static IInvestigationMethod keepOnAutoImport_IM = null;
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
	private static Class<? extends ISCIOThing> searchType = corpusType;

	/***
	 * The runID. This serves as an identifier for locating and saving the model.If*
	 * anything was changed during the development the runID should be reset.
	 */
	private static final String runID = String.valueOf(new Random().nextInt());

	public static Builder getPreDefinedParameterBuilder() {
		return getParameterBuilder(runID, searchType);
	}

	public static RunParameter getPreDefinedParameter() {
		return getPreDefinedParameterBuilder().build();
	}

	public static Builder getParameterBuilder(String runID_param, Class<? extends ISCIOThing> corpusType) {
		final String personalNote = "UNDER DEVELOPMENT";
		final File rootDirectory = new File(".");

		final Optimizer optimizer = new SGD(0.001, 0, 0.0001, false);

		final EScorerType scorerType = EScorerType.EXP;

		final int epochs = 10;

		final boolean multiThreading = true;

		final boolean exploreExistingTemplates = false;

		final boolean exploreOnOntologyLevel = false;

		final boolean restrictExplorationToFoundConcepts = true;

		final boolean enableDiscourseProgression = false;

		IExplorationCondition explorationCondition = new SCIOExplorationConditions();

		final EInstantiationType initializer = EInstantiationType.EMPTY;

		InvestigationRestriction restrictions = null;

		Set<RestrictedField> restrictFields = new HashSet<>();

		if (IOrganismModel.class.isAssignableFrom(corpusType)) {
			restrictFields.add(new RestrictedField("gender", true));
			restrictFields.add(new RestrictedField("age", true));
			restrictFields.add(new RestrictedField("ageCategory", true));
			restrictFields.add(new RestrictedField("weight", true));
			restrictFields.add(new RestrictedField("organismSpecies", true));
			restrictions = new InvestigationRestriction(restrictFields, false);
		}

		if (IInjury.class.isAssignableFrom(corpusType)) {
			restrictFields.add(new RestrictedField("injuryVertebralLocation", true));
			restrictFields.add(new RestrictedField("injuryDevice", true));
			restrictFields.add(new RestrictedField("injuryArea", true));
			restrictFields.add(new RestrictedField("force", true));
			restrictFields.add(new RestrictedField("weight", true));
			restrictFields.add(new RestrictedField("volume", true));
			restrictFields.add(new RestrictedField("pressure", true));
			restrictFields.add(new RestrictedField("distance", true));
			restrictFields.add(new RestrictedField("duration", true));
			restrictFields.add(new RestrictedField("upperVertebrae", true));
			restrictFields.add(new RestrictedField("lowerVertebrae", true));
			restrictions = new InvestigationRestriction(restrictFields, true);
		}

		if (ITreatment.class.isAssignableFrom(corpusType)) {
			restrictFields.add(new RestrictedField("duration", true));
			restrictFields.add(new RestrictedField("deliveryMethod", true));
			restrictFields.add(new RestrictedField("location", true));
			restrictFields.add(new RestrictedField("dosage", true));
			restrictFields.add(new RestrictedField("compound", true));
			restrictions = new InvestigationRestriction(restrictFields, true);
		}
		if (IInvestigationMethod.class.isAssignableFrom(corpusType)) {

			restrictions = InvestigationRestriction.noRestrictionInstance;
		}

//		InvestigationRestriction sampleRestrictions = new InvestigationRestriction(searchType, restrictFieldsTreatment);

//				InvestigationRestriction.noRestrictionInstance;
		/**
		 * HACK: REMOVE THIS HACK With the correct number of entities!
		 */
		IInitializeNumberOfObjects numberOfInitializedObjects;
		numberOfInitializedObjects = instance -> instance.getGoldAnnotation().getAnnotations().size();
//		numberOfInitializedObjects = instance -> 1;

		Regularizer regularizer = new L2(0.01);
		AbstractProjectEnvironment<?> scioEnvironment = SlotFillingProjectEnvironment.getInstance();

		int maxNumberOfEntityElements = 7;
		int maxNumberOfDataTypeElements = 20;
		Random rndForSampling = new Random(100L);

		final boolean penalizeCardinality = true;

		// IEvaluator evaluator = new BeamSearchPRF1(enableCaching,
		// maxEvaluationDepth, penalizeCardinality,
		// sampleRestrictions, new SCIOOrListConditon(),
		// maxNumberOfEntityElements,
		// ignoreEmptyInstancesOnEvaluation);

		IOBIEEvaluator evaluator = new CartesianSearchEvaluator(true, Integer.MAX_VALUE, penalizeCardinality,
				field -> false, maxNumberOfEntityElements, false);

		Set<Class<? extends AbstractOBIEExplorer>> explorerTypes = new HashSet<>();

		// explorerTypes.add(NoChangeExplorer.class);
		explorerTypes.add(SlotFillerExplorer.class);
//		explorerTypes.add(DependentCardinalityExplorer.class);

		explorerTypes.add(SlotCardinalityExplorer.class);
//		explorerTypes.add(TemplateCardinalityExplorer.class);

		Set<Class<? extends AbstractOBIETemplate<?>>> templates = new HashSet<>();

//		templates.add(HeterogeneousSlotTemplate.class);
//		templates.add(FrequencyTemplate.class);

//		templates.add(GenericMainTemplatePriorTemplate.class);
		// templates.add(StringSimilarityTemplate.class);
		//
//		templates.add(CooccurrenceTemplate.class);

		templates.add(SemanticNumericDataTypeTemplate.class);

		templates.add(TokenContextTemplate.class);

		if (exploreOnOntologyLevel)
			templates.add(DSSlotFillerClusterDistanceTemplate.class);
		else
			templates.add(SlotFillerClusterDistanceTemplate.class);

		templates.add(InterTokenTemplate.class);

		if (IOrganismModel.class.isAssignableFrom(corpusType))
			templates.add(AnimalModelConditionTemplate.class);

		if (IVertebralLocation.class.isAssignableFrom(corpusType) || IInjury.class.isAssignableFrom(corpusType))
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
		templates.add(EmptyRootClassCardinalityTemplate.class);
		templates.add(RootClassCardinalityTemplate.class);
		templates.add(MainSlotVarietyTemplate.class);

//		AbstractCorpusDistributor corpusConfiguration = foldCrossDist();
		AbstractCorpusDistributor corpusConfiguration = shuffleDist();

		Class<? extends IOBIEThing>[] exploreClassesWithoutEvidence = new Class[] { VertebralArea.class,
				PostsurgicalMedication.class };

		return new Builder().setOptimizer(optimizer).setCorpusDistributor(corpusConfiguration)
				.setOntologyEnvironment(OntologyEnvironment.getInstance())
				.setEnableDiscourseProgression(enableDiscourseProgression).setEpochs(epochs)
				.setExploreExistingTemplates(exploreExistingTemplates).setExploreOnOntologyLevel(exploreOnOntologyLevel)
				.setRestrictExplorationToFoundConcepts(restrictExplorationToFoundConcepts)
				.setExplorationCondition(explorationCondition).setExplorers(explorerTypes)
				.setInstantiationType(initializer).setDefaultTestInvestigationRestriction(restrictions)
				.setDefaultTrainInvestigationRestriction(restrictions).setMultiThreading(multiThreading)
				.setNumberOfInitializedObjects(numberOfInitializedObjects).setPersonalNotes(personalNote)
				.setRegularizer(regularizer).setRootDirectory(rootDirectory).addRootSearchType(corpusType)
				.setProjectEnvironment(scioEnvironment).setScorerType(scorerType).setTemplates(templates)
				.setRunID(runID_param).setEvaluator(evaluator).setMaxNumberOfEntityElements(maxNumberOfEntityElements)
				.setMaxNumberOfDataTypeElements(maxNumberOfDataTypeElements).setRandomForSampling(rndForSampling)
				.setManualExploreClassesWithoutEvidence(exploreClassesWithoutEvidence);
	}

//	public static Builder getParameterBuilder(String runID_param, boolean singleSlot,
//			Class<? extends ISCIOThing> corpusType, boolean full) {
//		final String personalNote = "UNDER DEVELOPMENT";
//		final Class<? extends IOBIEThing>[] explorationClasses = new Class[] { PostsurgicalMedication.class };
//		svm_parameter SVMParam = new svm_parameter();
//		SVMParam.eps = 0.01;
//		SVMParam.p = 0.1;
//		SVMParam.C = 0.0001;
//		SVMParam.svm_type = svm_parameter.EPSILON_SVR;
//		SVMParam.kernel_type = svm_parameter.LINEAR;
//		SVMParam.cache_size = 12000;
//		SVMParam.gamma = 0.0001;
//		
//		final File rootDirectory = new File(".");
//		
//		final int epochs = 10;
//		
//		final boolean penalizeCardinality = false;
//		
//		final Optimizer optimizer = new SGD(0.001, 0, 0.0001, false);
//		final EScorerType scorerType = EScorerType.EXP;
//		
//		final boolean multiThreading = true;
//		
//		final boolean exploreExistingTemplates = false;
//		
//		final boolean exploreOnOntologyLevel = true;
//		
//		final boolean restrictExplorationToFoundConcepts = false;
//		
//		final boolean enableDiscourseProgression = false;
//		
//		IExplorationCondition explorationCondition = new SCIOExplorationConditions();
//		
//		final EInstantiationType initializer = EInstantiationType.EMPTY;
//		
//		InvestigationRestriction restrictions = null;
//		Set<RestrictedField> restrictFields = new HashSet<>();
//		
//		if (IOrganismModel.class.isAssignableFrom(corpusType)) {
//			restrictFields.add(new RestrictedField("gender", true));
//			restrictFields.add(new RestrictedField("age", true));
//			restrictFields.add(new RestrictedField("ageCategory", true));
//			restrictFields.add(new RestrictedField("weight", true));
//			restrictFields.add(new RestrictedField("organismSpecies", true));
//			restrictions = new InvestigationRestriction(restrictFields, true);
//		}
//		
//		if (IInjury.class.isAssignableFrom(corpusType)) {
//			restrictFields.add(new RestrictedField("injuryVertebralLocation", true));
//			restrictFields.add(new RestrictedField("injuryDevice", true));
//			restrictFields.add(new RestrictedField("injuryArea", true));
//			restrictFields.add(new RestrictedField("force", true));
//			restrictFields.add(new RestrictedField("weight", true));
//			restrictFields.add(new RestrictedField("volume", true));
//			restrictFields.add(new RestrictedField("pressure", true));
//			restrictFields.add(new RestrictedField("distance", true));
//			restrictFields.add(new RestrictedField("duration", true));
//			restrictFields.add(new RestrictedField("upperVertebrae", true));
//			restrictFields.add(new RestrictedField("lowerVertebrae", true));
//			restrictions = new InvestigationRestriction(restrictFields, true);
//		}
//		
//		if (ITreatment.class.isAssignableFrom(corpusType)) {
//			restrictFields.add(new RestrictedField("duration", true));
//			restrictFields.add(new RestrictedField("deliveryMethod", true));
//			restrictFields.add(new RestrictedField("location", true));
//			restrictFields.add(new RestrictedField("dosage", true));
//			restrictFields.add(new RestrictedField("compound", true));
//			restrictions = new InvestigationRestriction(restrictFields, true);
//		}
//		if (IInvestigationMethod.class.isAssignableFrom(corpusType)) {
//			
//			restrictions = InvestigationRestriction.noRestrictionInstance;
//		}
//		
//		
////		InvestigationRestriction sampleRestrictions = new InvestigationRestriction(searchType, restrictFieldsTreatment);
//		
////				InvestigationRestriction.noRestrictionInstance;
//		/**
//		 * HACK: REMOVE THIS HACK With the correct number of entities!
//		 */
//		IInitializeNumberOfObjects numberOfInitializedObjects;
////		if (full)
////			numberOfInitializedObjects = instance -> instance.getGoldAnnotation().getTemplateAnnotations().size();
////		else
//		numberOfInitializedObjects = instance -> 1;
//		
//		int numberOfMaxSamplingSteps = 100;
////		Regularizer regularizer = null;
//		Regularizer regularizer = new L2(0.01);
//		AbstractProjectEnvironment<?> scioEnvironment = SCIOProjectEnvironment.getInstance();
//		
//		// AbstractConfigBuilder<?> config = getQuickNFoldSCIOConfigFull();
//		
//		// AbstractConfigBuilder<?> config = getQuickActiveLearningConfigFull();
//		
//		final int maxEvaluationDepth = Integer.MAX_VALUE;
//		final boolean enableCaching = true;
//		
//		int maxNumberOfEntityElements = 7;
//		int maxNumberOfDataTypeElements = 20;
//		Random rndForSampling = new Random(100L);
//		
//		boolean ignoreEmptyInstancesOnEvaluation = false;
//		
//		// IEvaluator evaluator = new BeamSearchPRF1(enableCaching,
//		// maxEvaluationDepth, penalizeCardinality,
//		// sampleRestrictions, new SCIOOrListConditon(),
//		// maxNumberOfEntityElements,
//		// ignoreEmptyInstancesOnEvaluation);
//		
//		IOBIEEvaluator evaluator = new CartesianSearchEvaluator(enableCaching, maxEvaluationDepth, penalizeCardinality,
//				field -> false, maxNumberOfEntityElements, ignoreEmptyInstancesOnEvaluation);
//		
//		Map<Class<? extends IOBIEThing>, List<IOBIEThing>> initializationObjects = new HashMap<>();
//		
//		List<IOBIEThing> initObjectList = new ArrayList<>();
//		AnimalModel initObject = new AnimalModel();
//		initObjectList.add(initObject);
//		initializationObjects.put(corpusType, initObjectList);
//		
//		Set<Class<? extends AbstractOBIEExplorer>> explorerTypes = new HashSet<>();
//		
//		// explorerTypes.add(NoChangeExplorer.class);
//		explorerTypes.add(SlotFillerExplorer.class);
////		explorerTypes.add(DependentCardinalityExplorer.class);
//		
//		explorerTypes.add(SlotCardinalityExplorer.class);
////		explorerTypes.add(TemplateCardinalityExplorer.class);
//		
//		Set<Class<? extends AbstractOBIETemplate<?>>> templates = new HashSet<>();
//		
////		templates.add(HeterogeneousSlotTemplate.class);
//		templates.add(FrequencyTemplate.class);
//		
//		if (singleSlot)
//			templates.add(GenericMainTemplatePriorTemplate.class);
//		// templates.add(StringSimilarityTemplate.class);
//		//
//		if (!singleSlot)
//			templates.add(CooccurrenceTemplate.class);
//		
//		templates.add(SemanticNumericDataTypeTemplate.class);
//		
//		if (!singleSlot)
//			templates.add(TokenContextTemplate.class);
//		
//		templates.add(InterTokenTemplate.class);
//		
//		if (IOrganismModel.class.isAssignableFrom(corpusType))
//			templates.add(AnimalModelConditionTemplate.class);
//		
//		if (IVertebralLocation.class.isAssignableFrom(corpusType) || IInjury.class.isAssignableFrom(corpusType))
//			templates.add(VertebralLocationConditionTemplate.class);
//		
//		// templates.add(DocumentClassificationTemplate.class);
//		//
//		// templates.add(SlotIsFilledTemplate.class);
//		
//		// templates.add(HierarchyTemplate.class);
//		
//		// templates.add(Word2VecClusterTemplate.class);
//		// templates.add(NERTemplate.class);
//		
//		// templates.add(PropertyEvidenceForClassTemplate.class);
//		
//		if (!singleSlot)
//			templates.add(InBetweenContextTemplate.class);
//		
//		if (!singleSlot)
//			templates.add(LocalTemplate.class);
//		
//		// templates.add(LocalLocalityTemplate.class);
//		// templates.add(GlobalLocalityTemplate.class);
//		// templates.add(GlobalSentenceLocalityTemplate.class);
//		// templates.add(LocalityTemplate.class);
//		
//		/*
//		 * Cardinality
//		 */
//		if (full) {
//			templates.add(EmptyRootClassCardinalityTemplate.class);
//			templates.add(RootClassCardinalityTemplate.class);
//			templates.add(MainSlotVarietyTemplate.class);
//		}
////		AbstractCorpusDistributor corpusConfiguration = foldCrossDist();
//		AbstractCorpusDistributor corpusConfiguration = shuffleDist();
//		
//		Class<? extends IOBIEThing>[] exploreClassesWithoutEvidence = new Class[] { VertebralArea.class };
//		
//		return new Builder().setOptimizer(optimizer).setCorpusDistributor(corpusConfiguration)
//				.setOntologyEnvironment(SCIOOntologyEnvironment.getInstance())
//				.setEnableDiscourseProgression(enableDiscourseProgression).setEpochs(epochs)
//				.setManualExploreClassesWithoutEvidence(explorationClasses)
//				.setExploreExistingTemplates(exploreExistingTemplates).setExploreOnOntologyLevel(exploreOnOntologyLevel)
//				.setRestrictExplorationToFoundConcepts(restrictExplorationToFoundConcepts)
//				.setExplorationCondition(explorationCondition).setExplorers(explorerTypes)
//				.setInitializationObjects(initializationObjects).setInstantiationType(initializer)
//				.setDefaultTestInvestigationRestriction(restrictions)
//				.setDefaultTrainInvestigationRestriction(restrictions).setMultiThreading(multiThreading)
//				.setNumberOfInitializedObjects(numberOfInitializedObjects)
//				.setNumberOfMaxSamplingSteps(numberOfMaxSamplingSteps).setPersonalNotes(personalNote)
//				.setRegularizer(regularizer).setRootDirectory(rootDirectory).addRootSearchType(corpusType)
//				.setProjectEnvironment(scioEnvironment).setScorerType(scorerType).setSvmParam(SVMParam)
//				.setTemplates(templates).setRunID(runID_param).setEvaluator(evaluator)
//				.setMaxNumberOfEntityElements(maxNumberOfEntityElements)
//				.setMaxNumberOfDataTypeElements(maxNumberOfDataTypeElements).setRandomForSampling(rndForSampling)
//				.setManualExploreClassesWithoutEvidence(exploreClassesWithoutEvidence);
//	}

	public static AbstractCorpusDistributor shuffleDist() {
		return new ShuffleCorpusDistributor.Builder().setSeed(100L).setTrainingProportion(80)
				.setDevelopmentProportion(0).setTestProportion(20).build();
	}

	public static AbstractCorpusDistributor foldCrossDist() {
		return new FoldCrossCorpusDistributor.Builder().setN(10).setSeed(12345L).build();
	}

	public static AbstractCorpusDistributor activeLearnigDist() {
		return new ActiveLearningDistributor.Builder().setMode(EMode.ABSOLUT).setBAbsolute(1).setSeed(100L)
				.setInitialTrainingSelectionFraction(0.01F).setTrainingProportion(80).setTestProportion(20).build();
	}
}
