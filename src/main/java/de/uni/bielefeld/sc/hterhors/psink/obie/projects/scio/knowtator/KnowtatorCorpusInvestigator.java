package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import de.hterhors.obie.core.evaluation.PRF1;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.corpus.CorpusFileTools;
import de.hterhors.obie.core.tools.corpus.OBIECorpus;
import de.hterhors.obie.core.tools.corpus.OBIECorpus.Instance;
import de.hterhors.obie.core.utils.AnnotationExtractorHelper;
import de.hterhors.obie.ml.evaluation.evaluator.CartesianSearchEvaluator;
import de.hterhors.obie.ml.run.InvestigationRestriction;
import de.hterhors.obie.ml.variables.TemplateAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOOntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnalyzedExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CompoundSupplier;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CompoundTreatment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IAge;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IAnimalModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IDosage;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IResult;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITreatment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IWeight;

public class KnowtatorCorpusInvestigator {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		final long ontologyVersion = SCIOOntologyEnvironment.getInstance().getOntologyVersion();

		final Set<Class<? extends IOBIEThing>> rootClassTypes = new HashSet<>(Arrays.asList(IInjury.class));

		File bFile = CorpusFileTools.buildRawCorpusFile(new File("scio/knowtator/corpus/"), "knowtator_brigitte_",
				rootClassTypes, ontologyVersion);

		File dFile = CorpusFileTools.buildRawCorpusFile(new File("scio/knowtator/corpus/"), "knowtator_daniel_",
				rootClassTypes, ontologyVersion);

		OBIECorpus brigitteCorpus = OBIECorpus.readRawCorpusData(bFile);

		OBIECorpus danielCorpus = OBIECorpus.readRawCorpusData(dFile);

		// treatmentsAndGroups(brigitteCorpus);

		// calculateIInterAnnotatorAgreement(brigitteCorpus, danielCorpus);
		// printAges(brigitteCorpus);
		printDosages(brigitteCorpus);

	}

	private static void treatmentsAndGroups(OBIECorpus brigitteCorpus) {
		for (Entry<String, Instance> results : brigitteCorpus.getTrainingInstances().entrySet()) {

			System.out.println(results.getKey() + ":" + results.getValue().annotations.size());

			// if (!results.getKey().startsWith("Yaz"))
			// continue;

			Set<IExperimentalGroup> numOfExpGroups = new HashSet<>();
			Set<ITreatment> numOfTreatments = new HashSet<>();
			Set<IInjury> numOfInjuries = new HashSet<>();
			Set<IInvestigationMethod> numOfInvestMethods = new HashSet<>();
			/*
			 * Count # of Entities
			 */
			for (IOBIEThing result : results.getValue().annotations.get(IResult.class)) {
				Set<IExperimentalGroup> groups = new HashSet<>();
				Set<ITreatment> treatments = new HashSet<>();
				Set<IInjury> injuries = new HashSet<>();
				Set<IInvestigationMethod> investigationMethods = new HashSet<>();
				if (((IResult) result).getReferenceExperimentalGroup() != null) {
					groups.add(((IResult) result).getReferenceExperimentalGroup());
				}
				if (((IResult) result).getTargetExperimentalGroup() != null) {
					groups.add(((IResult) result).getTargetExperimentalGroup());
				}

				/*
				 * Collect Treatments;
				 */

				if (((IResult) result).getReferenceExperimentalGroup() != null) {
					for (ITreatment treatment : ((IResult) result).getReferenceExperimentalGroup()
							.getTreatmentTypes()) {
						if (treatment.getClass() == CompoundTreatment.class)
							if (((CompoundTreatment) treatment).getCompound() != null) {
								if (((CompoundTreatment) treatment).getCompound().getCompoundSupplier() != null
										&& ((CompoundTreatment) treatment).getCompound().getCompoundSupplier()
												.getClass() == CompoundSupplier.class) {
									((CompoundTreatment) treatment).getCompound().setCompoundSupplier(null);
								}
								treatments.add(treatment);
							} else {
								treatments.add(treatment);
							}
					}
				}
				if (((IResult) result).getTargetExperimentalGroup() != null) {
					for (ITreatment treatment : ((IResult) result).getTargetExperimentalGroup().getTreatmentTypes()) {
						if (treatment.getClass() == CompoundTreatment.class)
							if (((CompoundTreatment) treatment).getCompound() != null) {
								if (((CompoundTreatment) treatment).getCompound().getCompoundSupplier() != null
										&& ((CompoundTreatment) treatment).getCompound().getCompoundSupplier()
												.getClass() == CompoundSupplier.class) {
									((CompoundTreatment) treatment).getCompound().setCompoundSupplier(null);
								}
								treatments.add(treatment);
							} else {
								treatments.add(treatment);
							}
					}
				}

				IInjury reference = ((IResult) result).getReferenceExperimentalGroup().getInjuryModel();

				if (AnnotationExtractorHelper.isAssignAbleFrom(IInjury.class, reference))
					injuries.add(reference);

				IInjury target = ((IResult) result).getTargetExperimentalGroup().getInjuryModel();

				if (AnnotationExtractorHelper.isAssignAbleFrom(IInjury.class, target))
					injuries.add(target);

				if (((IResult) result).getReferenceExperimentalGroup() instanceof AnalyzedExperimentalGroup)
					for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) ((IResult) result)
							.getReferenceExperimentalGroup()).getMemberDefinedExperimentalGroups()) {
						if (AnnotationExtractorHelper.isAssignAbleFrom(IInjury.class, expGroup.getInjuryModel()))
							injuries.add(expGroup.getInjuryModel());
					}

				if (((IResult) result).getTargetExperimentalGroup() instanceof AnalyzedExperimentalGroup)
					for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) ((IResult) result)
							.getTargetExperimentalGroup()).getMemberDefinedExperimentalGroups()) {
						if (AnnotationExtractorHelper.isAssignAbleFrom(IInjury.class, expGroup.getInjuryModel()))
							injuries.add(expGroup.getInjuryModel());
					}

				if (((IResult) result).getInvestigation() != null) {

					if (((IResult) result).getInvestigation().getInvestigationMethod() != null) {

						IInvestigationMethod investMethod = (((IResult) result).getInvestigation())
								.getInvestigationMethod();

						if (AnnotationExtractorHelper.isAssignAbleFrom(IInvestigationMethod.class, investMethod))
							investigationMethods.add((IInvestigationMethod) investMethod);
					}
				}

				System.out.println("# of Groups: " + groups.size());
				groups.forEach(System.out::println);
				System.out.println("# of treatments: " + treatments.size());
				treatments.forEach(System.out::println);
				System.out.println("# of injuries: " + injuries.size());
				injuries.forEach(System.out::println);
				System.out.println("# of investigationMethods: " + investigationMethods.size());
				investigationMethods.forEach(System.out::println);
				System.out.println("___________________");

				numOfInvestMethods.addAll(investigationMethods);
				numOfInjuries.addAll(injuries);
				numOfTreatments.addAll(treatments);
				numOfExpGroups.addAll(groups);

			}
			System.out.println(results.getKey() + ":" + results.getValue().annotations.size());
			System.out.println("# of Groups: " + numOfExpGroups.size());
			System.out.println("# of treatments: " + numOfTreatments.size());
			System.out.println("# of injuries: " + numOfInjuries.size());
			System.out.println("# of investigationMethods: " + numOfInvestMethods.size());
			System.out.println("###############");

		}

	}

	private static void calculateIInterAnnotatorAgreement(OBIECorpus brigitteCorpus, OBIECorpus danielCorpus) {
		PRF1 prf1 = new PRF1(0, 0, 0);

		for (String docName : brigitteCorpus.getInstances().keySet()) {

			List<IOBIEThing> bR = extractInvestigationMethod(
					brigitteCorpus.getInstances().get(docName).annotations.get(IResult.class), 12).stream()
							.map(i -> i.getThing()).collect(Collectors.toList());

			List<IOBIEThing> dR = extractInvestigationMethod(
					danielCorpus.getInstances().get(docName).annotations.get(IResult.class), 12).stream()
							.map(i -> i.getThing()).collect(Collectors.toList());

			System.out.println(docName);
			System.out.println("brigitte: " + bR.size());
			System.out.println("daniel: " + dR.size());
			PRF1 result = new CartesianSearchEvaluator(true, 1000, true, InvestigationRestriction.noRestrictionInstance,
					7, false).prf1(dR, bR);
			System.out.println(result);
			prf1.add(result);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}

		System.out.println("mean: " + prf1);
	}

	private static void printStuff(OBIECorpus brigitteCorpus) {

		Set<String> dp = new HashSet<>();

		for (Entry<String, Instance> results : brigitteCorpus.getTrainingInstances().entrySet()) {
			// if (!results.getKey().startsWith("Yaz"))
			// continue;

			for (IOBIEThing result : results.getValue().annotations.get(IResult.class)) {
				if (((IResult) result).getReferenceExperimentalGroup() != null
						&& ((IResult) result).getReferenceExperimentalGroup().getOrganismModel() != null) {

					IWeight w = ((IResult) result).getReferenceExperimentalGroup().getOrganismModel().getWeight();

					if (w != null)

						dp.add(results.getKey() + "\t" + w.getCharacterOnset() + "\t" + w.getCharacterOffset() + "\t"
								+ w.getTextMention());

				}
				if (((IResult) result).getTargetExperimentalGroup() != null
						&& ((IResult) result).getTargetExperimentalGroup().getOrganismModel() != null) {

					IWeight w = ((IResult) result).getTargetExperimentalGroup().getOrganismModel().getWeight();
					if (w != null)
						dp.add(results.getKey() + "\t" + w.getCharacterOnset() + "\t" + w.getCharacterOffset() + "\t"
								+ w.getTextMention());

				}
			}
		}

		dp.forEach(System.out::println);

	}

	private static void printWeights(OBIECorpus brigitteCorpus) {

		Set<String> dp = new HashSet<>();

		for (Entry<String, Instance> results : brigitteCorpus.getTrainingInstances().entrySet()) {
			// if (!results.getKey().startsWith("Yaz"))
			// continue;

			for (IOBIEThing result : results.getValue().annotations.get(IResult.class)) {
				if (((IResult) result).getReferenceExperimentalGroup() != null
						&& ((IResult) result).getReferenceExperimentalGroup().getOrganismModel() != null) {

					IWeight w = ((IResult) result).getReferenceExperimentalGroup().getOrganismModel().getWeight();

					if (w != null)

						dp.add(results.getKey() + "\t" + w.getCharacterOnset() + "\t" + w.getCharacterOffset() + "\t"
								+ w.getTextMention());

				}
				if (((IResult) result).getTargetExperimentalGroup() != null
						&& ((IResult) result).getTargetExperimentalGroup().getOrganismModel() != null) {

					IWeight w = ((IResult) result).getTargetExperimentalGroup().getOrganismModel().getWeight();
					if (w != null)
						dp.add(results.getKey() + "\t" + w.getCharacterOnset() + "\t" + w.getCharacterOffset() + "\t"
								+ w.getTextMention());

				}
			}
		}

		dp.forEach(System.out::println);

	}

	private static void printAges(OBIECorpus brigitteCorpus) {

		Set<String> dp = new HashSet<>();

		for (Entry<String, Instance> results : brigitteCorpus.getTrainingInstances().entrySet()) {
			// if (!results.getKey().startsWith("Yaz"))
			// continue;

			for (IOBIEThing result : results.getValue().annotations.get(IResult.class)) {
				if (((IResult) result).getReferenceExperimentalGroup() != null
						&& ((IResult) result).getReferenceExperimentalGroup().getOrganismModel() != null) {

					IAge w = ((IResult) result).getReferenceExperimentalGroup().getOrganismModel().getAge();

					if (w != null)

						dp.add(results.getKey() + "\t" + w.getCharacterOnset() + "\t" + w.getCharacterOffset() + "\t"
								+ w.getTextMention());

				}
				if (((IResult) result).getTargetExperimentalGroup() != null
						&& ((IResult) result).getTargetExperimentalGroup().getOrganismModel() != null) {

					IAge w = ((IResult) result).getTargetExperimentalGroup().getOrganismModel().getAge();
					if (w != null)
						dp.add(results.getKey() + "\t" + w.getCharacterOnset() + "\t" + w.getCharacterOffset() + "\t"
								+ w.getTextMention());

				}
			}
		}

		dp.forEach(System.out::println);

	}

	private static void printDosages(OBIECorpus brigitteCorpus) {

		Set<String> dp = new HashSet<>();

		for (Entry<String, Instance> results : brigitteCorpus.getTrainingInstances().entrySet()) {
			// if (!results.getKey().startsWith("Yaz"))
			// continue;

			for (IOBIEThing result : results.getValue().annotations.get(IResult.class)) {

				if (((IResult) result).getReferenceExperimentalGroup().getTreatmentTypes() != null) {
					//
					for (ITreatment treatment : ((IResult) result).getReferenceExperimentalGroup()
							.getTreatmentTypes()) {

						if (treatment instanceof CompoundTreatment) {
							if (((CompoundTreatment) treatment).getDosage() != null) {
								IDosage d = ((CompoundTreatment) treatment).getDosage();
								dp.add(results.getKey() + "\t" + d.getCharacterOnset() + "\t" + d.getCharacterOffset()
										+ "\t" + d.getTextMention());
							}
						}
					}
				}
				if (((IResult) result).getTargetExperimentalGroup().getTreatmentTypes() != null) {
					//
					for (ITreatment treatment : ((IResult) result).getTargetExperimentalGroup().getTreatmentTypes()) {

						if (treatment instanceof CompoundTreatment) {
							if (((CompoundTreatment) treatment).getDosage() != null) {
								IDosage d = ((CompoundTreatment) treatment).getDosage();
								dp.add(results.getKey() + "\t" + d.getCharacterOnset() + "\t" + d.getCharacterOffset()
										+ "\t" + d.getTextMention());
							}
						}
					}
				}

			}
		}

		dp.forEach(System.out::println);

	}

	/**
	 * Extract training instances for the SCIO-OrganismModel class. IOrganismModel
	 * must be assignable by the given generic type t.
	 * 
	 * @param result
	 * @param t
	 * @return
	 */
	private static Set<TemplateAnnotation> extractAnimalModels(List<IResult> scioAnnotationInstance, final int limit) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<IAnimalModel> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {

			if (r.getReferenceExperimentalGroup() == null)
				continue;
			if (r.getTargetExperimentalGroup() == null)
				continue;

			IOrganismModel referenceOrganismModel = r.getReferenceExperimentalGroup().getOrganismModel();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IOrganismModel.class, referenceOrganismModel))
				annotations.add((IAnimalModel) referenceOrganismModel);

			IAnimalModel targetAnimalModel = (IAnimalModel) r.getTargetExperimentalGroup().getOrganismModel();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IOrganismModel.class, targetAnimalModel))
				annotations.add(targetAnimalModel);

			if (r.getReferenceExperimentalGroup() instanceof AnalyzedExperimentalGroup)
				for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) r.getReferenceExperimentalGroup())
						.getMemberDefinedExperimentalGroups()) {
					if (AnnotationExtractorHelper.isAssignAbleFrom(IOrganismModel.class, expGroup.getOrganismModel()))
						annotations.add((IAnimalModel) expGroup.getOrganismModel());
				}

			if (r.getTargetExperimentalGroup() instanceof AnalyzedExperimentalGroup)
				for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) r.getTargetExperimentalGroup())
						.getMemberDefinedExperimentalGroups()) {
					if (AnnotationExtractorHelper.isAssignAbleFrom(IOrganismModel.class, expGroup.getOrganismModel()))
						annotations.add((IAnimalModel) expGroup.getOrganismModel());
				}

		}
		for (IOrganismModel annotation : annotations) {
			if (annotation == null)
				continue;

			if (internalAnnotations.size() == limit) {
				return new HashSet<>();
			}
			if (!AnnotationExtractorHelper.testLimitToAnnnotationElementsRecursively(annotation, limit)) {
				return new HashSet<>();
			}
			TemplateAnnotation entity = new TemplateAnnotation(IAnimalModel.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

	private static Set<TemplateAnnotation> extractExperimentalGroups(List<IResult> scioAnnotationInstance,
			final int limit) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<IExperimentalGroup> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {

			if (r.getReferenceExperimentalGroup() == null)
				continue;
			if (r.getTargetExperimentalGroup() == null)
				continue;

			IExperimentalGroup referenceOrganismModel = r.getReferenceExperimentalGroup();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IExperimentalGroup.class, referenceOrganismModel))
				annotations.add(referenceOrganismModel);

			IExperimentalGroup targetAnimalModel = r.getTargetExperimentalGroup();

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

			if (internalAnnotations.size() == limit) {
				return new HashSet<>();
			}
			if (!AnnotationExtractorHelper.testLimitToAnnnotationElementsRecursively(annotation, limit)) {
				return new HashSet<>();
			}
			TemplateAnnotation entity = new TemplateAnnotation(IExperimentalGroup.class, annotation);
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
	private static Set<TemplateAnnotation> extractInvestigationMethod(List<IOBIEThing> scioAnnotationInstance,
			final int limit) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<IInvestigationMethod> annotations = new HashSet<>();

		for (IOBIEThing r : scioAnnotationInstance) {

			if (((IResult) r).getInvestigation() == null)
				continue;

			if (((IResult) r).getInvestigation().getInvestigationMethod() == null)
				continue;

			IInvestigationMethod investMethod = ((IResult) r).getInvestigation().getInvestigationMethod();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IInvestigationMethod.class, investMethod))
				annotations.add((IInvestigationMethod) investMethod);

		}
		for (IInvestigationMethod annotation : annotations) {
			if (annotation == null)
				continue;

			if (internalAnnotations.size() == limit) {
				return new HashSet<>();
			}
			if (!AnnotationExtractorHelper.testLimitToAnnnotationElementsRecursively(annotation, limit)) {
				return new HashSet<>();
			}
			TemplateAnnotation entity = new TemplateAnnotation(IInvestigationMethod.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

	private static Set<TemplateAnnotation> extractInjury(List<IResult> scioAnnotationInstance, final int limit) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<IInjury> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {

			if (r.getReferenceExperimentalGroup() == null)
				continue;
			if (r.getTargetExperimentalGroup() == null)
				continue;

			IInjury referenceOrganismModel = r.getReferenceExperimentalGroup().getInjuryModel();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IInjury.class, referenceOrganismModel))
				annotations.add(referenceOrganismModel);

			IInjury targetOrganismModel = r.getTargetExperimentalGroup().getInjuryModel();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IInjury.class, targetOrganismModel))
				annotations.add(targetOrganismModel);

			if (r.getReferenceExperimentalGroup() instanceof AnalyzedExperimentalGroup)
				for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) r.getReferenceExperimentalGroup())
						.getMemberDefinedExperimentalGroups()) {
					if (AnnotationExtractorHelper.isAssignAbleFrom(IInjury.class, expGroup.getInjuryModel()))
						annotations.add(expGroup.getInjuryModel());
				}

			if (r.getTargetExperimentalGroup() instanceof AnalyzedExperimentalGroup)
				for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) r.getTargetExperimentalGroup())
						.getMemberDefinedExperimentalGroups()) {
					if (AnnotationExtractorHelper.isAssignAbleFrom(IInjury.class, expGroup.getInjuryModel()))
						annotations.add(expGroup.getInjuryModel());
				}

		}
		for (IInjury annotation : annotations) {
			if (annotation == null)
				continue;

			if (internalAnnotations.size() == limit) {
				return new HashSet<>();
			}
			if (!AnnotationExtractorHelper.testLimitToAnnnotationElementsRecursively(annotation, limit)) {
				return new HashSet<>();
			}
			TemplateAnnotation entity = new TemplateAnnotation(IInjury.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

	private static Set<TemplateAnnotation> extractTreatment(List<IResult> scioAnnotationInstance, final int limit) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<ITreatment> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {

			if (r.getReferenceExperimentalGroup() != null) {
				for (ITreatment treatment : r.getReferenceExperimentalGroup().getTreatmentTypes()) {
					if (treatment.getClass() == CompoundTreatment.class) {

						if (((CompoundTreatment) treatment).getCompound() != null) {
							if (((CompoundTreatment) treatment).getCompound().getCompoundSupplier() != null
									&& ((CompoundTreatment) treatment).getCompound().getCompoundSupplier()
											.getClass() == CompoundSupplier.class) {
								((CompoundTreatment) treatment).getCompound().setCompoundSupplier(null);
							}
							annotations.add(treatment);
						}
					} else {
						annotations.add(treatment);

					}
				}
			}
			if (r.getTargetExperimentalGroup() != null) {
				for (ITreatment treatment : r.getTargetExperimentalGroup().getTreatmentTypes()) {
					if (treatment.getClass() == CompoundTreatment.class) {

						if (((CompoundTreatment) treatment).getCompound() != null) {
							if (((CompoundTreatment) treatment).getCompound().getCompoundSupplier() != null
									&& ((CompoundTreatment) treatment).getCompound().getCompoundSupplier()
											.getClass() == CompoundSupplier.class) {
								((CompoundTreatment) treatment).getCompound().setCompoundSupplier(null);
							}
							annotations.add(treatment);
						}
					} else {
						annotations.add(treatment);

					}
				}
			}

		}
		for (ITreatment annotation : annotations) {
			if (annotation == null)
				continue;

			if (internalAnnotations.size() == limit) {
				return new HashSet<>();
			}
			if (!AnnotationExtractorHelper.testLimitToAnnnotationElementsRecursively(annotation, limit)) {
				return new HashSet<>();
			}
			TemplateAnnotation entity = new TemplateAnnotation(ITreatment.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

}
