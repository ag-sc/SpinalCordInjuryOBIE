package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.annotations.SuperRootClasses;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.dtinterpreter.IDatatypeInterpretation;
import de.hterhors.obie.ml.dtinterpreter.INumericInterpreter;
import de.hterhors.obie.ml.dtinterpreter.IStringInterpreter;
import de.hterhors.obie.ml.dtinterpreter.IUnit;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.utils.ReflectionUtils;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.hterhors.obie.ml.variables.OBIEState;
import de.hterhors.obie.ml.variables.TemplateAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SCIOSemanticInterpreter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.SemanticNumericDataTypeTemplate.Scope;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;
import factors.Factor;
import factors.FactorScope;
import learning.Vector;

/**
 * Captures the semantics of datatype properties.
 * 
 * Converts raw input text (surface form) of annotations into interpretable
 * format. Checks whether the value of the data type property is within the
 * range of the mean. The mean is pre-calculated over the training data.
 * 
 * @author hterhors
 *
 * @date May 12, 2017
 */
public class SemanticNumericDataTypeTemplate extends AbstractOBIETemplate<Scope> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger log = LogManager.getFormatterLogger(SemanticNumericDataTypeTemplate.class.getName());

	// final private static String GREATER_OR_EQUAL_TEMPLATE = "Mean_%s_of_%s >=
	// %s %s";
	// final private static String LESS_THEN_TEMPLATE = "Mean_%s_of_%s < %s %s";
	final private static String MEAN_STD_DEVIATION_TEMPLATE = "%s of %s is within %s x std deviation(%s) of mean(%s) unit(%s)";
	final private static String NOT_MEAN_STD_DEVIATION_TEMPLATE = "%s of %s is NOT within %s x std deviation (%s) of mean(%s) unit(%s)";

	/**
	 * Parent class type, property class type, unit, value
	 */
	final private Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, Double>>> stdDeviations;
	final private Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, Double>>> meanValues;

	private final AbstractOBIETemplate<?> thisTemplate;

	public SemanticNumericDataTypeTemplate(RunParameter parameter, List<OBIEInstance> train) {
		super(parameter);
		this.thisTemplate = this;

		Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>>> values = extractDataTypeValuesFromTrainingDataRec(
				train);

		this.meanValues = calculateMeanValues(values);
		this.stdDeviations = calculateStandardDeviations(this.meanValues, values);

		log.info("Mean values with standard deviation:");
		for (Entry<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, Double>>> parent : this.meanValues
				.entrySet()) {
			for (Entry<Class<? extends IOBIEThing>, Map<IUnit, Double>> property : parent.getValue().entrySet()) {
				for (Entry<IUnit, Double> unit : property.getValue().entrySet()) {
					log.info(parent.getKey().getSimpleName() + " -> " + property.getKey().getSimpleName() + " = "
							+ unit.getValue() + " +- "
							+ this.stdDeviations.get(parent.getKey()).get(property.getKey()).get(unit.getKey()) + " "
							+ unit.getKey());
				}
			}
		}
	}

	/**
	 * This method calculates the standard deviation for all data type properties.
	 * For that it makes use of the pre-calculated mean values!
	 * 
	 * @param meanValues
	 * 
	 * @param values
	 */
	private Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, Double>>> calculateStandardDeviations(
			Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, Double>>> meanValues,
			Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>>> values) {

		Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, Double>>> stdDeviations = new HashMap<>();

		for (Entry<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>>> parents : values
				.entrySet()) {

			final Class<? extends IOBIEThing> parentClassType = parents.getKey();
			stdDeviations.put(parentClassType, new HashMap<>());

			for (Entry<Class<? extends IOBIEThing>, Map<IUnit, Double>> properties : meanValues.get(parentClassType)
					.entrySet()) {
				final Class<? extends IOBIEThing> propertyClassType = properties.getKey();
				stdDeviations.get(parentClassType).put(propertyClassType, new HashMap<>());

				for (Entry<IUnit, Double> units : properties.getValue().entrySet()) {

					final IUnit unit = units.getKey();
					final double meanValue = units.getValue();

					double variance = 0;
					for (Double value : values.get(parentClassType).get(propertyClassType).get(unit)) {
						variance += Math.pow(meanValue - value, 2);
					}
					stdDeviations.get(parentClassType).get(propertyClassType).put(unit,
							Math.sqrt(variance / values.get(parentClassType).get(propertyClassType).get(unit).size()));
				}
			}
		}
		return stdDeviations;
	}

	/**
	 * Calculates the mean values for all data type properties. To do that, it first
	 * calculates the sum for all data type properties which is used to calculate
	 * the mean in a second step.
	 * 
	 * @param values
	 * @return
	 */
	private Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, Double>>> calculateMeanValues(
			Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>>> values) {

		final Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, Double>>> sumValues = new HashMap<>();
		final Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, Double>>> meanValues = new HashMap<>();

		/*
		 * Calculate the sums.
		 */
		for (Entry<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>>> parents : values
				.entrySet()) {
			final Class<? extends IOBIEThing> parentClassType = parents.getKey();
			sumValues.putIfAbsent(parentClassType, new HashMap<>());

			for (Entry<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>> properties : parents.getValue()
					.entrySet()) {
				final Class<? extends IOBIEThing> propertyClassType = properties.getKey();
				sumValues.get(parentClassType).putIfAbsent(propertyClassType, new HashMap<>());

				for (Entry<IUnit, List<Double>> units : properties.getValue().entrySet()) {
					final IUnit unit = units.getKey();

					for (Double meanValue : units.getValue()) {
						sumValues.get(parentClassType).get(propertyClassType).put(unit,
								sumValues.get(parentClassType).get(propertyClassType).getOrDefault(unit, 0D)
										+ meanValue);
					}
				}
			}
		}

		/*
		 * Calculate the mean.
		 */
		for (Entry<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>>> parents : values
				.entrySet()) {
			final Class<? extends IOBIEThing> parentClassType = parents.getKey();
			meanValues.putIfAbsent(parentClassType, new HashMap<>());

			for (Entry<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>> properties : parents.getValue()
					.entrySet()) {
				final Class<? extends IOBIEThing> propertyClassType = properties.getKey();
				meanValues.get(parentClassType).putIfAbsent(propertyClassType, new HashMap<>());

				for (Entry<IUnit, List<Double>> units : properties.getValue().entrySet()) {
					final IUnit unit = units.getKey();

					meanValues.get(parentClassType).get(propertyClassType).put(unit,
							sumValues.get(parentClassType).get(propertyClassType).get(unit) / units.getValue().size());
				}
			}
		}
		return meanValues;
	}

	/**
	 * Extracts all data type values from the given training data set. Each value is
	 * directly semantically interpreted and normalized.
	 * 
	 * @param train the training data to extract the data type values from.
	 * @return a map of data type values for each property, stored in a list.
	 */
	private Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>>> extractDataTypeValuesFromTrainingDataRec(
			List<OBIEInstance> train) {
		Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>>> values = new HashMap<>();

		for (OBIEInstance internalInstance : train) {
			for (TemplateAnnotation internalAnnotation : internalInstance.getGoldAnnotation()
					.getTemplateAnnotations()) {
				collectDataTypes(values, null, internalAnnotation.getThing());
			}
		}
		return values;

	}

	private void collectDataTypes(
			Map<Class<? extends IOBIEThing>, Map<Class<? extends IOBIEThing>, Map<IUnit, List<Double>>>> values,
			Class<? extends IOBIEThing> parentClassType, IOBIEThing obieClass) {

		if (obieClass == null)
			return;

		if (parentClassType != null && obieClass.getClass().isAnnotationPresent(DatatypeProperty.class)) {

			/**
			 * TODO: FIX FOR Different Types
			 */
			final IDatatypeInterpretation semantics = SCIOSemanticInterpreter.getInstance()
					.interpret((Class<? extends ISCIOThing>) obieClass.getClass(), obieClass.getTextMention());

			/*
			 * Only for Numeric data type Values.
			 */
			if (semantics instanceof INumericInterpreter) {

				if (semantics != null && semantics.exists()) {

					IUnit unit = ((INumericInterpreter) semantics).getUnit();

					values.putIfAbsent(parentClassType, new HashMap<>());
					values.get(parentClassType).putIfAbsent(obieClass.getClass(), new HashMap<>());
					values.get(parentClassType).get(obieClass.getClass()).putIfAbsent(unit, new ArrayList<>());
					values.get(parentClassType).get(obieClass.getClass()).get(unit)
							.add(((INumericInterpreter) semantics.normalize()).getMeanValue());

					final Class<? extends IOBIEThing>[] rootClassTypes = parentClassType
							.getAnnotation(SuperRootClasses.class).get();

					for (Class<? extends IOBIEThing> rootClassType : rootClassTypes) {
						values.putIfAbsent(rootClassType, new HashMap<>());
						values.get(rootClassType).putIfAbsent(obieClass.getClass(), new HashMap<>());
						values.get(rootClassType).get(obieClass.getClass()).putIfAbsent(unit, new ArrayList<>());
						values.get(rootClassType).get(obieClass.getClass()).get(unit)
								.add(((INumericInterpreter) semantics.normalize()).getMeanValue());
					}
				}
			}
		}

		ReflectionUtils.getSlots(obieClass.getClass()).forEach(field -> {
			try {
				if (field.isAnnotationPresent(RelationTypeCollection.class)) {
					for (IOBIEThing element : (List<IOBIEThing>) field.get(obieClass)) {
						collectDataTypes(values, obieClass.getClass(), element);
					}
				} else {
					collectDataTypes(values, obieClass.getClass(), (IOBIEThing) field.get(obieClass));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	class Scope extends FactorScope {

		final Class<? extends IOBIEThing> parentScioClass;
		final Class<? extends IOBIEThing> scioClass;
		final String surfaceForm;

		public Scope(Class<? extends IOBIEThing> entityRootClassType, Class<? extends IOBIEThing> parentClassName,
				Class<? extends IOBIEThing> className, final String surfaceForm) {
			super(thisTemplate, parentClassName, className, surfaceForm, entityRootClassType);
			this.scioClass = className;
			this.parentScioClass = parentClassName;
			this.surfaceForm = surfaceForm;
		}

	}

	@Override
	public List<Scope> generateFactorScopes(OBIEState state) {
		List<Scope> factors = new ArrayList<>();

		for (TemplateAnnotation entity : state.getCurrentTemplateAnnotations().getTemplateAnnotations()) {
			factors.addAll(addFactorRecursive(entity.rootClassType, entity.getThing()));
		}

		return factors;
	}

	private List<Scope> addFactorRecursive(final Class<? extends IOBIEThing> rootClassType, IOBIEThing scioClass) {
		return addFactorRecursive(rootClassType, null, scioClass);
	}

	private List<Scope> addFactorRecursive(final Class<? extends IOBIEThing> rootClassType,
			final Class<? extends IOBIEThing> parentClassType, IOBIEThing obieClass) {
		List<Scope> factors = new ArrayList<>();

		if (obieClass == null)
			return factors;

		final Set<Class<? extends IOBIEThing>> influencedVariables = new HashSet<>();
		// influencedVariables.add(instance.getClass());

		/**
		 * parentClassType != null prevents this template from working for data type
		 * properties which are root classes. This may effect NER. This can be changed
		 * without problems.
		 */
		if (parentClassType != null && obieClass.getClass().isAnnotationPresent(DatatypeProperty.class)) {

			final String surfaceForm = obieClass.getTextMention();

			if (surfaceForm != null) {
				factors.add(new Scope(rootClassType, parentClassType, obieClass.getClass(), surfaceForm));
			}
			return factors;
		}

		/*
		 * Add factors for object type properties.
		 */
		Arrays.stream(obieClass.getClass().getDeclaredFields())
				.filter(f -> f.isAnnotationPresent(OntologyModelContent.class)).forEach(field -> {
					field.setAccessible(true);
					try {
						if (field.isAnnotationPresent(RelationTypeCollection.class)) {
							for (IOBIEThing element : (List<IOBIEThing>) field.get(obieClass)) {
								factors.addAll(addFactorRecursive(rootClassType, obieClass.getClass(), element));
							}
						} else {
							factors.addAll(addFactorRecursive(rootClassType, obieClass.getClass(),
									(IOBIEThing) field.get(obieClass)));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		return factors;
	}

	@Override
	public void computeFactor(Factor<Scope> factor) {
		Vector featureVector = factor.getFeatureVector();

		final IDatatypeInterpretation semantics = SCIOSemanticInterpreter.getInstance().interpret(
				(Class<? extends ISCIOThing>) factor.getFactorScope().scioClass, factor.getFactorScope().surfaceForm);
		/*
		 * Only for Numeric data type Values.
		 */

		if (semantics instanceof IStringInterpreter)
			return;

		addFeatures(factor.getFactorScope().parentScioClass, factor.getFactorScope().scioClass, featureVector,
				(INumericInterpreter) semantics);

		final Class<? extends IOBIEThing>[] rootClassTypes = factor.getFactorScope().parentScioClass
				.getAnnotation(SuperRootClasses.class).get();

		for (Class<? extends IOBIEThing> rootClassType : rootClassTypes) {
			addFeatures(rootClassType, factor.getFactorScope().scioClass, featureVector,
					(INumericInterpreter) semantics);
		}
		// for (final double level : levels) {
		//
		// final boolean greaterOrEqual = semantics.getMeanValue() >= level;
		//
		// featureVector.set(String.format(GREATER_OR_EQUAL_TEMPLATE, className,
		// parentClassName, level,
		// semantics.getUnitName()), greaterOrEqual);
		//
		// featureVector.set(
		// String.format(LESS_THEN_TEMPLATE, className, parentClassName, level,
		// semantics.getUnitName()),
		// !greaterOrEqual);
		//
		// }

	}

	// public static void main(String[] args) {
	//
	// final double meanValue = 200;
	//
	// final double stdDeviation = 20;
	// final double v = 2;
	// for (int i = 4; i >= 1; i--) {
	//
	// boolean within = Math.abs(v - meanValue) <= i * stdDeviation;
	//
	// /**
	// * Add only the feature which is the farthest away from mean.
	// */
	// if (!within) {
	// System.out.println(
	// String.format(NOT_MEAN_STD_DEVIATION_TEMPLATE, "Weight", "Rat", i,
	// stdDeviation, meanValue, "g")
	// + " -> " + !within);
	// break;
	// }
	//
	// }
	// for (int i = 1; i <= 4; i++) {
	//
	// boolean within = Math.abs(v - meanValue) <= i * stdDeviation;
	//
	// /**
	// * Add only the feature which is the nearest to the mean.
	// */
	// if (within) {
	// System.out.println(
	// String.format(MEAN_STD_DEVIATION_TEMPLATE, "Weight", "Rat", i,
	// stdDeviation, meanValue, "g")
	// + "->" + within);
	// break;
	// }
	// }
	//
	// }

	private void addFeatures(Class<? extends IOBIEThing> parentClassType, Class<? extends IOBIEThing> propertyClassType,
			Vector featureVector, final INumericInterpreter semantics) {
		final String parentClassName = parentClassType.getSimpleName();
		final String className = propertyClassType.getSimpleName();

		if (meanValues.containsKey(parentClassType)) {
			final IUnit unit = semantics.getUnit();
			final double meanValue = this.meanValues.getOrDefault(parentClassType, new HashMap<>())
					.getOrDefault(propertyClassType, new HashMap<>()).getOrDefault(unit, 0D);

			final double stdDeviation = this.stdDeviations.getOrDefault(parentClassType, new HashMap<>())
					.getOrDefault(propertyClassType, new HashMap<>()).getOrDefault(unit, 0D);

			for (int i = 4; i >= 1; i--) {

				boolean within = Math.abs(semantics.getMeanValue() - meanValue) <= i * stdDeviation;

				/**
				 * Add only the feature which is the farthest away from mean.
				 */
				if (!within) {
					featureVector.set(String.format(NOT_MEAN_STD_DEVIATION_TEMPLATE, className, parentClassName, i,
							stdDeviation, meanValue, semantics.getUnit().getName()), !within);
					// System.out.println(
					// String.format(NOT_MEAN_STD_DEVIATION_TEMPLATE,
					// className,parentClassName, i, stdDeviation, meanValue,
					// semantics.getUnit().getName())
					// + " -> " + !within);
					break;
				}

			}
			for (int i = 1; i <= 4; i++) {

				boolean within = Math.abs(semantics.getMeanValue() - meanValue) <= i * stdDeviation;

				/**
				 * Add only the feature which is the nearest to the mean.
				 */
				if (within) {
					featureVector.set(String.format(MEAN_STD_DEVIATION_TEMPLATE, className, parentClassName, i,
							stdDeviation, meanValue, semantics.getUnit().getName()), within);
					// System.out.println(
					// String.format(MEAN_STD_DEVIATION_TEMPLATE, className,
					// parentClassName, i, stdDeviation, meanValue,
					// semantics.getUnit().getName())
					// + "->" + within);
					break;
				}
			}

		}
	}

}
