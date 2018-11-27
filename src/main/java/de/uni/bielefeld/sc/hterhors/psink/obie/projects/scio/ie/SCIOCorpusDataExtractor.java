package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.corpus.OBIECorpus.Instance;
import de.hterhors.obie.core.utils.AnnotationExtractorHelper;
import de.hterhors.obie.ml.variables.TemplateAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnalyzedExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CompoundSupplier;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CompoundTreatment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IGroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IResult;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITreatment;

public class SCIOCorpusDataExtractor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Override
	protected Set<TemplateAnnotation> convertInstancesToAnnotations(Instance instance,
			Class<? extends IOBIEThing> rootClassType) {
		Set<TemplateAnnotation> annotations = null;

//		if (IOrganismModel.class.isAssignableFrom(rootClassType)) {
//			annotations = extractAnimalModels(instance.annotations);
//		}
//
//		else if (ITreatment.class.isAssignableFrom(rootClassType)) {
//			annotations = extractTreatment(instance.annotations);
//		}
//
//		else if (IInjury.class.isAssignableFrom(rootClassType)) {
//			annotations = extractInjury(instance.annotations);
//		}
//
//		else if (IInvestigationMethod.class.isAssignableFrom(rootClassType)) {
//			annotations = extractInvestigationMethod(instance.annotations);
//		}
//
//		else if (IExperimentalGroup.class.isAssignableFrom(rootClassType)) {
//			annotations = extractExperimentalGroups(instance.annotations);
//		}
//
//		else if (IGroupName.class.isAssignableFrom(rootClassType)) {
//			annotations = extractGroupNames(instance.annotations);
//		}
//
//		if (annotations == null) {
//			throw new IllegalArgumentException("Unkown type of root class: " + rootClassType + "!");
//		}

		return annotations;
	}

//	protected void applyNEL() {
//
//		if (config.getNERToolType() == SCIORegExNEL.class) {
//
//		List<InternalInstance> instances = internalInstances.stream().sorted(new Comparator<InternalInstance>() {
//			@Override
//			public int compare(InternalInstance o1, InternalInstance o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		}).collect(Collectors.toList());
//
//		Stream<InternalInstance> s = instances.stream();
//		s = s.parallel();
//		s.forEach(instance -> {
//			log.info("Apply named entity recognition to document: " + instance.getName() + "...");
//
////				final INamedEntitityRecognitionProvider regExNER = new SCIORegExNER(new HashSet<>(Arrays.asList(IResult.class)),
////						getTrainingCorpus());
//			final INamedEntitityLinkingProvider regExNER = new SCIORegExNEL(rootClassTypes, getTrainingCorpus());
//
//			instance.setNamedEntityLinker(regExNER);
//		});
//		} else {
//			throw new IllegalArgumentException("Unkown NER tool selected: " + config.getNERToolType());
//		}
//	}

	/**
	 * Extract training instances for the SCIO-OrganismModel class. IOrganismModel
	 * must be assignable by the given generic type t.
	 * 
	 * @param result
	 * @param t
	 * @return
	 */
	private Set<TemplateAnnotation> extractAnimalModels(List<IResult> scioAnnotationInstance) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<IOrganismModel> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {

			annotations.addAll(extractOrganismModelsFromExperimentalGroup(r.getReferenceExperimentalGroup()));
			annotations.addAll(extractOrganismModelsFromExperimentalGroup(r.getTargetExperimentalGroup()));

		}
		for (IOrganismModel annotation : annotations) {
			if (annotation == null)
				continue;
			TemplateAnnotation entity = new TemplateAnnotation(IOrganismModel.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

//	/**
//	 * Extract training instances for the SCIO-OrganismModel class. IOrganismModel
//	 * must be assignable by the given generic type t.
//	 * 
//	 * @param result
//	 * @param t
//	 * @return
//	 */
//	private Set<InternalAnnotation> extractGenericDataOfInterest(List<IResult> scioAnnotationInstance,
//			Class<? extends ISCIOThing> parentClassTypeOfInterest, Class<? extends ISCIOThing> classTypeOfInterest) {
//
//		Set<InternalAnnotation> internalAnnotations = new HashSet<>();
//
//		for (IResult result : scioAnnotationInstance) {
//			internalAnnotations
//					.addAll(extractGenericDataOfInterestRec(parentClassTypeOfInterest, classTypeOfInterest, result));
//		}
//
//		return internalAnnotations;
//	}
//
//	/**
//	 * Extract training instances for the SCIO-OrganismModel class. IOrganismModel
//	 * must be assignable by the given generic type t.
//	 * 
//	 * @param result
//	 * @param t
//	 * @return
//	 */
//	private Set<InternalAnnotation> extractGenericDataOfInterestRec(
//			Class<? extends ISCIOThing> parentClassTypeOfInterest, Class<? extends ISCIOThing> classTypeOfInterest,
//			ISCIOThing currentParentClass) {
//		Set<InternalAnnotation> internalAnnotations = new HashSet<>();
//
//		final List<Field> fields = ReflectionUtils.getDeclaredOntologyFields(currentParentClass.getClass());
//
//		for (Field field : fields) {
//
//			try {
//				if (field.isAnnotationPresent(OneToManyRelation.class)) {
//
//					@SuppressWarnings("unchecked")
//					List<ISCIOThing> classesOfInterest = (List<ISCIOThing>) field.get(currentParentClass);
//
//					if (classesOfInterest == null)
//						continue;
//
//					for (ISCIOThing listEntry : classesOfInterest) {
//
//						if (parentClassTypeOfInterest.isAssignableFrom(currentParentClass.getClass())
//								&& classTypeOfInterest.isAssignableFrom(listEntry.getClass())) {
//
//							internalAnnotations.add(new InternalAnnotation(classTypeOfInterest, listEntry));
//
//						} else {
//							internalAnnotations.addAll(extractGenericDataOfInterestRec(parentClassTypeOfInterest,
//									classTypeOfInterest, listEntry));
//						}
//					}
//
//				} else {
//
//					ISCIOThing classOfInterest = (ISCIOThing) field.get(currentParentClass);
//
//					if (classOfInterest == null)
//						continue;
//
//					if (parentClassTypeOfInterest.isAssignableFrom(currentParentClass.getClass())
//							&& classTypeOfInterest.isAssignableFrom(classOfInterest.getClass())) {
//
//						internalAnnotations.add(new InternalAnnotation(classTypeOfInterest, classOfInterest));
//
//					} else {
//						internalAnnotations.addAll(extractGenericDataOfInterestRec(parentClassTypeOfInterest,
//								classTypeOfInterest, classOfInterest));
//					}
//				}
//
//			} catch (IllegalArgumentException | IllegalAccessException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return internalAnnotations;
//	}

	@SuppressWarnings("unchecked")
	public static <B extends IOBIEThing> Set<B> extractOrganismModelsFromExperimentalGroup(
			IExperimentalGroup expGroup) {

		Set<B> models = new HashSet<>();

		if (expGroup == null)
			return models;

		IOrganismModel model = expGroup.getOrganismModel();

		if (AnnotationExtractorHelper.isAssignAbleFrom(IOrganismModel.class, model))
			models.add((B) model);

		if (expGroup instanceof AnalyzedExperimentalGroup)
			for (IExperimentalGroup analyzedGroup : ((AnalyzedExperimentalGroup) expGroup)
					.getMemberDefinedExperimentalGroups()) {
				if (AnnotationExtractorHelper.isAssignAbleFrom(IOrganismModel.class, analyzedGroup.getOrganismModel()))
					models.add((B) analyzedGroup.getOrganismModel());
			}

		return models;
	}

	@SuppressWarnings("unchecked")
	public static <B extends IOBIEThing> Set<B> extractInjuryFromExperimentalGroup(IExperimentalGroup expGroup) {

		Set<B> models = new HashSet<>();

		if (expGroup == null)
			return models;

		IInjury model = expGroup.getInjuryModel();

		if (AnnotationExtractorHelper.isAssignAbleFrom(IInjury.class, model))
			models.add((B) model);

		if (expGroup instanceof AnalyzedExperimentalGroup)
			for (IExperimentalGroup analyzedGroup : ((AnalyzedExperimentalGroup) expGroup)
					.getMemberDefinedExperimentalGroups()) {
				if (AnnotationExtractorHelper.isAssignAbleFrom(IInjury.class, analyzedGroup.getInjuryModel()))
					models.add((B) analyzedGroup.getInjuryModel());
			}

		return models;
	}

	@SuppressWarnings("unchecked")
	public static <B extends IOBIEThing> Set<B> extractGroupNamesFromExperimentalGroup(IExperimentalGroup expGroup) {

		Set<B> models = new HashSet<>();

		if (expGroup == null)
			return models;

		for (IGroupName iGroupName : expGroup.getGroupNames()) {

			if (AnnotationExtractorHelper.isAssignAbleFrom(IGroupName.class, iGroupName))
				models.add((B) iGroupName);
		}

		if (expGroup instanceof AnalyzedExperimentalGroup)
			for (IExperimentalGroup analyzedGroup : ((AnalyzedExperimentalGroup) expGroup)
					.getMemberDefinedExperimentalGroups()) {

				for (IGroupName iGroupName : analyzedGroup.getGroupNames()) {

					if (AnnotationExtractorHelper.isAssignAbleFrom(IGroupName.class, iGroupName))
						models.add((B) iGroupName);
				}
			}

		return models;
	}

	@SuppressWarnings("unchecked")
	public static <B extends IOBIEThing> Set<B> extractTreatmentsFromExperimentalGroup(IExperimentalGroup expGroup) {

		Set<B> models = new HashSet<>();

		if (expGroup == null)
			return models;

		for (ITreatment treatment : expGroup.getTreatmentTypes()) {
			if (treatment.getClass() == CompoundTreatment.class)
				if (((CompoundTreatment) treatment).getCompound() != null) {
					if (((CompoundTreatment) treatment).getCompound().getCompoundSupplier() != null
							&& ((CompoundTreatment) treatment).getCompound().getCompoundSupplier()
									.getClass() == CompoundSupplier.class) {
						((CompoundTreatment) treatment).getCompound().setCompoundSupplier(null);
					}
					models.add((B) treatment);
				} else {
					models.add((B) treatment);

				}
		}

		if (expGroup instanceof AnalyzedExperimentalGroup)
			for (IExperimentalGroup memberGroups : ((AnalyzedExperimentalGroup) expGroup)
					.getMemberDefinedExperimentalGroups()) {
				for (ITreatment treatment : memberGroups.getTreatmentTypes()) {
					if (treatment.getClass() == CompoundTreatment.class)
						if (((CompoundTreatment) treatment).getCompound() != null) {
							if (((CompoundTreatment) treatment).getCompound().getCompoundSupplier() != null
									&& ((CompoundTreatment) treatment).getCompound().getCompoundSupplier()
											.getClass() == CompoundSupplier.class) {
								((CompoundTreatment) treatment).getCompound().setCompoundSupplier(null);
							}
							models.add((B) treatment);
						} else {
							models.add((B) treatment);

						}
				}
			}

		return models;

	}

	private Set<TemplateAnnotation> extractExperimentalGroups(List<IResult> scioAnnotationInstance) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<IExperimentalGroup> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {

			/**
			 * TODO: HACK: COMMENT IN!
			 */
			// if (r.getReferenceExperimentalGroup() == null)
			// continue;
			// if (r.getTargetExperimentalGroup() == null)
			// continue;

			IExperimentalGroup referenceOrganismModel = r.getReferenceExperimentalGroup();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IExperimentalGroup.class, referenceOrganismModel))
				annotations.add((IExperimentalGroup) referenceOrganismModel);

			IExperimentalGroup targetAnimalModel = (IExperimentalGroup) r.getTargetExperimentalGroup();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IExperimentalGroup.class, targetAnimalModel))
				annotations.add(targetAnimalModel);

			if (r.getReferenceExperimentalGroup() instanceof AnalyzedExperimentalGroup)
				for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) r.getReferenceExperimentalGroup())
						.getMemberDefinedExperimentalGroups()) {
					if (AnnotationExtractorHelper.isAssignAbleFrom(IExperimentalGroup.class, expGroup))
						annotations.add(expGroup);
				}

			if (r.getTargetExperimentalGroup() instanceof AnalyzedExperimentalGroup)
				for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) r.getTargetExperimentalGroup())
						.getMemberDefinedExperimentalGroups()) {
					if (AnnotationExtractorHelper.isAssignAbleFrom(IExperimentalGroup.class, expGroup))
						annotations.add(expGroup);
				}
		}

		for (IExperimentalGroup annotation : annotations) {

			if (annotation == null)
				continue;

			/**
			 * HACK: REMOVE!!!
			 */
			if (annotation.getGroupNames().isEmpty())
				continue;

			TemplateAnnotation entity = new TemplateAnnotation(IExperimentalGroup.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

	private Set<TemplateAnnotation> extractGroupNames(List<IResult> scioAnnotationInstance) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<IGroupName> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {

			if (r.getReferenceExperimentalGroup() == null)
				continue;
			if (r.getTargetExperimentalGroup() == null)
				continue;

			IExperimentalGroup ref = r.getReferenceExperimentalGroup();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IExperimentalGroup.class, ref))
				annotations.addAll(ref.getGroupNames());

			IExperimentalGroup targetAnimalModel = r.getTargetExperimentalGroup();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IExperimentalGroup.class, targetAnimalModel))
				annotations.addAll(targetAnimalModel.getGroupNames());

			if (r.getReferenceExperimentalGroup() instanceof AnalyzedExperimentalGroup)
				for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) r.getReferenceExperimentalGroup())
						.getMemberDefinedExperimentalGroups()) {
					if (AnnotationExtractorHelper.isAssignAbleFrom(IExperimentalGroup.class, expGroup))
						annotations.addAll(expGroup.getGroupNames());
				}

			if (r.getTargetExperimentalGroup() instanceof AnalyzedExperimentalGroup)
				for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) r.getTargetExperimentalGroup())
						.getMemberDefinedExperimentalGroups()) {
					if (AnnotationExtractorHelper.isAssignAbleFrom(IExperimentalGroup.class, expGroup))
						annotations.addAll(expGroup.getGroupNames());
				}

		}
		for (IGroupName annotation : annotations) {
			if (annotation == null)
				continue;

			if (annotation.getTextMention().equals("null")) {
//				log.warn("WARN!!! Remove null annotation: " + annotation.getTextMention());
				continue;
			}

			if (annotation.getTextMention().contains("...")) {
//				log.warn("WARN!!! Remove discont annotation: " + annotation.getTextMention());
				continue;
			}

			TemplateAnnotation entity = new TemplateAnnotation(IGroupName.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

	/**
	 * Extract training instances for the SCIO-OrganismModel class. IOrganismModel
	 * must be assignable by the given generic type t.
	 * 
	 * @param result
	 * @param t
	 * @return
	 */
	private Set<TemplateAnnotation> extractInvestigationMethod(List<IResult> scioAnnotationInstance) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<IInvestigationMethod> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {

			if (r.getInvestigation() == null)
				continue;

			if (r.getInvestigation().getInvestigationMethod() == null)
				continue;

			IInvestigationMethod investMethod = r.getInvestigation().getInvestigationMethod();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IInvestigationMethod.class, investMethod))
				annotations.add((IInvestigationMethod) investMethod);

		}
		for (IInvestigationMethod annotation : annotations) {
			if (annotation == null)
				continue;

			TemplateAnnotation entity = new TemplateAnnotation(IInvestigationMethod.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

	private Set<TemplateAnnotation> extractInjury(List<IResult> scioAnnotationInstance) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<IInjury> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {

			annotations.addAll(extractInjuryFromExperimentalGroup(r.getReferenceExperimentalGroup()));
			annotations.addAll(extractInjuryFromExperimentalGroup(r.getTargetExperimentalGroup()));

		}
		for (IInjury annotation : annotations) {
			if (annotation == null)
				continue;

			TemplateAnnotation entity = new TemplateAnnotation(IInjury.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

	private Set<TemplateAnnotation> extractTreatment(List<IResult> scioAnnotationInstance) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<ITreatment> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {
			annotations.addAll(extractTreatmentsFromExperimentalGroup(r.getReferenceExperimentalGroup()));
			annotations.addAll(extractTreatmentsFromExperimentalGroup(r.getTargetExperimentalGroup()));

		}
		for (ITreatment annotation : annotations) {
			if (annotation == null)
				continue;
			TemplateAnnotation entity = new TemplateAnnotation(ITreatment.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

}