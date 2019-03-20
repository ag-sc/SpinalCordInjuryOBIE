package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.baselines.slotfilling.probabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import corpus.SampledInstance;
import de.hterhors.obie.core.ontology.InvestigationRestriction;
import de.hterhors.obie.core.ontology.InvestigationRestriction.RestrictedField;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.annotations.ImplementationClass;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.interfaces.IDatatype;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.explorer.utils.ExplorationUtils;
import de.hterhors.obie.ml.run.AbstractOBIERunner;
import de.hterhors.obie.ml.run.DefaultSlotFillingRunner;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.run.param.RunParameter.Builder;
import de.hterhors.obie.ml.variables.InstanceTemplateAnnotations;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.hterhors.obie.ml.variables.OBIEState;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter.SCIOParameterQuickAccess;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Injury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.InvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.OrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Treatment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITreatment;

/**
 * This class helps to calculate the probability of generated states. The
 * probability is based on the model score.
 * 
 * @author hterhors
 *
 * @date Dec 19, 2017
 */
public class CalculatingScoresRunner {

	public final static IInjury keepImportOnAutoImport_I = new Injury();
	public final static IInvestigationMethod keepImportOnAutoImport_IM = new InvestigationMethod();
	public final static IOrganismModel keepImportOnAutoImport_AM = new OrganismModel();
	public final static ITreatment keepImportOnAutoImport_T = new Treatment();

	final private static Class<? extends ISCIOThing> searchType = IOrganismModel.class;

	public static final String type = searchType.getSimpleName().toLowerCase();

	public static void main(String[] args) {
		try {

			OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());

			psSingle = new PrintStream(new File("baseline/probabilities/" + type + "_single_scores.csv"));
			psDouble = new PrintStream(new File("baseline/probabilities/" + type + "_double_scores.csv"));

			Class<? extends IOBIEThing> classType = searchType.getAnnotation(ImplementationClass.class).get();
			List<Set<RestrictedField>> restrictFieldsList = InvestigationRestriction.getFieldRestrictionCombinations(
					classType, InvestigationRestriction.getMainSingleFields(classType));

			trainAll(restrictFieldsList);

			RunParameter parameter = SCIOParameterQuickAccess.getREParameter().build();
			AbstractOBIERunner runner = new DefaultSlotFillingRunner(parameter, false);

			CalculatingScoresRunner.exploreClassesWithoutTextualEvidence = runner
					.getParameter().exploreClassesWithoutTextualEvidence;

			for (OBIEInstance trainingInstance : runner.corpusProvider.getTestCorpus().getInternalInstances()) {
				predictInstance(trainingInstance, restrictFieldsList);
			}

			psSingle.close();
			psDouble.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The search type defines the root class type to sample. This should be the
	 * same as the corpus type or ontological below. I.e. the corpus thpe might be
	 * OrganismModel, but you could still search only or RatModels.
	 *
	 * However, usually the search type is the same as the corpus type.
	 *
	 */

	static PrintStream psSingle;
	static PrintStream psDouble;

	public final static int version = 10;

	public static Set<Class<? extends IOBIEThing>> exploreClassesWithoutTextualEvidence;

	public static RunParameter getTrainingParameter(InvestigationRestriction investigationRestrictions) {

		Builder paramBuilder = SCIOParameterQuickAccess.getREParameter();
		paramBuilder.setDefaultTrainInvestigationRestriction(investigationRestrictions);
		paramBuilder.setDefaultTestInvestigationRestriction(investigationRestrictions);
		paramBuilder.setMultiThreading(true);
//		paramBuilder.setEpochs(10);
//		paramBuilder.setOptimizer(new SGD(0.05, 0, 0.001, false));

		return paramBuilder.build();
	}

	public static RunParameter getPredictingParameter(
			Map<Class<? extends IOBIEThing>, List<IOBIEThing>> initializationObjects,
			InvestigationRestriction propertyRestrictions) {

		Builder paramBuilder = SCIOParameterQuickAccess.getREParameter();
		paramBuilder.setDefaultTrainInvestigationRestriction(propertyRestrictions);
		paramBuilder.setDefaultTestInvestigationRestriction(propertyRestrictions);
		paramBuilder.setInitializationObjects(initializationObjects);
		paramBuilder.setMultiThreading(true);
//		paramBuilder.setEpochs(15);
//		paramBuilder.setOptimizer(new SGD(0.05, 0, 0.001, false));

		return paramBuilder.build();
	}

	private static void trainAll(List<Set<RestrictedField>> restrictFieldsList)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, Exception {

		/**
		 * Train only type
		 */
		InvestigationRestriction typeRestrictions = new InvestigationRestriction(new HashSet<>(), true);
		System.out.println("SamplingRestriction: " + typeRestrictions);
		RunParameter p = getTrainingParameter(typeRestrictions);
		System.out.println("Parameter: " + p);
		AbstractOBIERunner runner = new DefaultSlotFillingRunner(p, false);
		runner.train();

		/**
		 * Train type and fields
		 */
		for (Set<RestrictedField> restrictFields : restrictFieldsList) {

			if (restrictFields.size() == 1) {
				/*
				 * Train fields and class type
				 */
				InvestigationRestriction propertyRestrictions = new InvestigationRestriction(restrictFields, true);
				System.out.println("SamplingRestriction: " + propertyRestrictions);

				p = getTrainingParameter(propertyRestrictions);
				System.out.println("Parameter: " + p);

//				runner = new DefaultSlotFillingRunner(p);
				runner.clean(p);
				runner.train();
				System.out.println("##############");

			}
			/*
			 * Train fields only
			 */
			InvestigationRestriction propertyRestrictions = new InvestigationRestriction(searchType, restrictFields);
			System.out.println("SamplingRestriction: " + propertyRestrictions);

			p = getTrainingParameter(propertyRestrictions);
			System.out.println("Parameter: " + p);

//			runner = new DefaultSlotFillingRunner(p);

			runner.clean(p);
			runner.train();
			System.out.println("##############");
		}
	}

	private static void predictInstance(OBIEInstance instance, List<Set<RestrictedField>> restrictFieldsList)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, Exception {

		/*
		 * Predict only classes
		 */
		InvestigationRestriction typeRestrictions = new InvestigationRestriction(new HashSet<>(), true);
		System.out.println("SamplingRestriction: " + typeRestrictions);
		Map<Class<? extends IOBIEThing>, List<IOBIEThing>> initializationObjects;
		List<IOBIEThing> initObjectList;
		RunParameter p;
		AbstractOBIERunner runner;

		List<Class<? extends IOBIEThing>> listOftypes = new ArrayList<>(Arrays.asList(searchType
				.getAnnotation(ImplementationClass.class).get().getAnnotation(AssignableSubClasses.class).get()));
		listOftypes.add(searchType.getAnnotation(ImplementationClass.class).get());

		for (Class<? extends IOBIEThing> classType : listOftypes) {

			initializationObjects = new HashMap<>();
			initObjectList = new ArrayList<>();
			IOBIEThing initObject = classType.newInstance();
			initObjectList.add(initObject);
			initializationObjects.put(searchType, initObjectList);

			p = getPredictingParameter(initializationObjects, typeRestrictions);

			System.out.println("Parameter: " + p);

			System.out.println(initObject);

			runner = new DefaultSlotFillingRunner(p, false);

			runner.loadModel();

			for (SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState> sampledInstance : runner
					.testInstance(instance)) {

				System.out.println(sampledInstance.getInstance().getName() + " ->  "
						+ initObject.getClass().getSimpleName() + " = " + (sampledInstance.getState().getModelScore()));
				psSingle.println(sampledInstance.getInstance().getName() + "\t" + "type" + "\t"
						+ initObject.getClass().getSimpleName() + "\t" + (sampledInstance.getState().getModelScore()));
			}
			System.out.println("##############");
		}

		/*
		 * predict classes and fields
		 */
		for (Set<RestrictedField> restrictFields : restrictFieldsList) {
			System.out.println("restrictFields: " + restrictFields);

			if (restrictFields.size() == 1) {

				/*
				 * Predict single fields and class type
				 */
				for (Class<? extends IOBIEThing> classType : searchType.getAnnotation(ImplementationClass.class).get()
						.getAnnotation(AssignableSubClasses.class).get()) {

					List<Field> fields = toRestrictingFields(restrictFields, classType);

					List<List<IOBIEThing>> instances = toRestrictedInstances(instance, fields);

					for (int i = 0; i < instances.get(0).size(); i++) {
						IOBIEThing initObject = classType.newInstance();
						IOBIEThing value = instances.get(0).get(i);
						try {
							if (fields.get(0).isAnnotationPresent(RelationTypeCollection.class)) {
								if (value == null) {
									fields.get(0).set(initObject, new ArrayList<>());
								} else {
									fields.get(0).set(initObject, new ArrayList<>(Arrays.asList(value)));
								}
							} else {
								fields.get(0).set(initObject, value);
							}
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							continue;
						}

						initializationObjects = new HashMap<>();
						initObjectList = new ArrayList<>();
						initObjectList.add(initObject);
						initializationObjects.put(searchType, initObjectList);

						boolean investClassTypes = true;
						runner = evaluate(initializationObjects, restrictFields, initObject, investClassTypes);

						for (SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState> sampledInstance : runner
								.testInstance(instance)) {

							String v = value == null ? "null"
									: value.getClass().isAnnotationPresent(DatatypeProperty.class)
											? ((IDatatype) value).getInterpretedValue()
											: value.getClass().getSimpleName();

							System.out.println(sampledInstance.getInstance().getName() + " -> "
									+ initObject.getClass().getSimpleName() + " + " + v + " = "
									+ (sampledInstance.getState().getModelScore()));

							psDouble.println(sampledInstance.getInstance().getName() + "\t" + "type" + "\t"
									+ initObject.getClass().getSimpleName() + "\t" + fields.get(0).getName() + "\t" + v
									+ "\t" + (sampledInstance.getState().getModelScore()));
						}
						System.out.println("##############");
					}

				}

				Class<? extends IOBIEThing> classType = searchType.getAnnotation(ImplementationClass.class).get();

				List<Field> fields = toRestrictingFields(restrictFields, classType);

				List<List<IOBIEThing>> instances = toRestrictedInstances(instance, fields);
				/*
				 * Predict single fields
				 */
				for (int i = 0; i < instances.get(0).size(); i++) {
					IOBIEThing initObject = classType.newInstance();
					IOBIEThing value = instances.get(0).get(i);
					try {
						if (fields.get(0).isAnnotationPresent(RelationTypeCollection.class)) {
							if (value == null) {
								fields.get(0).set(initObject, new ArrayList<>());
							} else {
								fields.get(0).set(initObject, new ArrayList<>(Arrays.asList(value)));
							}
						} else {
							fields.get(0).set(initObject, value);
						}
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
						continue;
					}
					initializationObjects = new HashMap<>();
					initObjectList = new ArrayList<>();
					initObjectList.add(initObject);
					initializationObjects.put(searchType, initObjectList);

					runner = evaluate(initializationObjects, restrictFields, initObject, false);

					for (SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState> sampledInstance : runner
							.testInstance(instance)) {

						String v = value == null ? "null"
								: value.getClass().isAnnotationPresent(DatatypeProperty.class)
										? ((IDatatype) value).getInterpretedValue()
										: value.getClass().getSimpleName();

						System.out.println(sampledInstance.getInstance().getName() + " -> " + v + " = "
								+ (sampledInstance.getState().getModelScore()));

						psSingle.println(sampledInstance.getInstance().getName() + "\t" + fields.get(0).getName() + "\t"
								+ v + "\t" + (sampledInstance.getState().getModelScore()));
					}
					System.out.println("##############");

				}
			} else {
				/*
				 * Predict double fields
				 */
				Class<? extends IOBIEThing> classType = searchType.getAnnotation(ImplementationClass.class).get();

				List<Field> restrictingFields = toRestrictingFields(restrictFields, classType);

				List<List<IOBIEThing>> candidates = toRestrictedInstances(instance, restrictingFields);

				for (int i = 0; i < candidates.get(0).size(); i++) {
					IOBIEThing initObject = classType.newInstance();
					IOBIEThing value1 = candidates.get(0).get(i);
					try {

						if (restrictingFields.get(0).isAnnotationPresent(RelationTypeCollection.class)) {
							if (value1 == null) {
								restrictingFields.get(0).set(initObject, new ArrayList<>());
							} else {
								restrictingFields.get(0).set(initObject, new ArrayList<>(Arrays.asList(value1)));
							}
						} else {
							restrictingFields.get(0).set(initObject, value1);
						}

					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
						continue;
					}
					for (int j = 0; j < candidates.get(1).size(); j++) {
						IOBIEThing value2 = candidates.get(1).get(j);
						try {

							if (restrictingFields.get(1).isAnnotationPresent(RelationTypeCollection.class)) {
								if (value2 == null) {
									restrictingFields.get(1).set(initObject, new ArrayList<>());
								} else {
									restrictingFields.get(1).set(initObject, new ArrayList<>(Arrays.asList(value2)));
								}
							} else {
								restrictingFields.get(1).set(initObject, value2);
							}

						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							continue;
						}
						initializationObjects = new HashMap<>();
						initObjectList = new ArrayList<>();
						initObjectList.add(initObject);
						initializationObjects.put(searchType, initObjectList);

						runner = evaluate(initializationObjects, restrictFields, initObject, false);

						for (SampledInstance<OBIEInstance, InstanceTemplateAnnotations, OBIEState> sampledInstance : runner
								.testInstance(instance)) {

							String v1 = value1 == null ? "null"
									: value1.getClass().isAnnotationPresent(DatatypeProperty.class)
											? ((IDatatype) value1).getInterpretedValue()
											: value1.getClass().getSimpleName();
							String v2 = value2 == null ? "null"
									: value2.getClass().isAnnotationPresent(DatatypeProperty.class)
											? ((IDatatype) value2).getInterpretedValue()
											: value2.getClass().getSimpleName();

							System.out.println(sampledInstance.getInstance().getName() + " -> " + v1 + " + " + v2
									+ " = " + (sampledInstance.getState().getModelScore()));
							psDouble.println(
									sampledInstance.getInstance().getName() + "\t" + restrictingFields.get(0).getName()
											+ "\t" + v1 + "\t" + restrictingFields.get(1).getName() + "\t" + v2 + "\t"
											+ (sampledInstance.getState().getModelScore()));
						}
						System.out.println("##############");
					}
				}
			}
		}

	}

	private static AbstractOBIERunner evaluate(Map<Class<? extends IOBIEThing>, List<IOBIEThing>> initializationObjects,
			Set<RestrictedField> restrictFields, IOBIEThing initObject, boolean investClasstype)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, Exception {
		RunParameter p;
		AbstractOBIERunner runner;
		System.out.println(initObject);
		InvestigationRestriction propertyRestrictions = new InvestigationRestriction(restrictFields, investClasstype);
		System.out.println("SamplingRestriction: " + propertyRestrictions);

		p = getPredictingParameter(initializationObjects, propertyRestrictions);
		System.out.println("Parameter: " + p);

		runner = new DefaultSlotFillingRunner(p, false);

		runner.loadModel();
		return runner;
	}

	/**
	 * Adds all possible candidates for the fields. A list of instances where fields
	 * are filled.
	 * 
	 * @param instance
	 * @param fields
	 * @return
	 */
	private static List<List<IOBIEThing>> toRestrictedInstances(OBIEInstance instance, List<Field> fields) {
		List<List<IOBIEThing>> instances = new ArrayList<>(fields.size());

		for (int i = 0; i < fields.size(); i++) {
			/*
			 * TODO: Make this dependable from exploration style.
			 */
			List<IOBIEThing> l = new ArrayList<>(ExplorationUtils.getCandidates(instance,
					(Class<? extends IOBIEThing>) fields.get(i).getType(), exploreClassesWithoutTextualEvidence, true,
					true, InvestigationRestriction.noRestrictionInstance));
			l.add(null);

			instances.add(l);
		}
		return instances;
	}

	private static List<Field> toRestrictingFields(Set<RestrictedField> restrictFields,
			Class<? extends IOBIEThing> classType) {
		List<Field> fields = restrictFields.stream().map(fName -> {
			try {
				Field f = classType.getDeclaredField(fName.fieldName);
				f.setAccessible(true);
				return f;
			} catch (NoSuchFieldException | SecurityException e) {
				/**
				 * this occurs quite often as we add all sub fields to the restrictions. But not
				 * all subfields are in every class.
				 */
			}
			return null;
		}).filter(f -> f != null).collect(Collectors.toList());
		return fields;
	}

	private static Map<String, Map<List<String>, Map<List<String>, Double>>> readDoubleProbabilitiesFromFile(
			final String fileName) throws IOException, ClassNotFoundException {
		Map<String, Map<List<String>, Map<List<String>, Double>>> doubleScores = new HashMap<>();

		BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));

		String line = "";
		while ((line = br.readLine()) != null) {

			String data[] = line.split("\t");

			final String docName = data[0];
			final String fieldName1 = data[1];
			final String value1 = data[2];
			final String fieldName2 = data[3];
			final String value2 = data[4];
			final double score = Double.parseDouble(data[5]);

			List<String> fieldNames = new ArrayList<String>(Arrays.asList(fieldName1, fieldName2));
			List<String> values = new ArrayList<String>(Arrays.asList(value1, value2));

			doubleScores.putIfAbsent(docName, new HashMap<>());
			doubleScores.get(docName).putIfAbsent(fieldNames, new HashMap<>());
			doubleScores.get(docName).get(fieldNames).put(values, score);

		}
		br.close();
		return doubleScores;
	}

}
