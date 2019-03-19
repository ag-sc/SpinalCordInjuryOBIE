package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.run.AbstractOBIERunner;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.variables.OBIEState;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling.VarietyTemplate.Scope;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import factors.Factor;
import factors.FactorScope;
import learning.Vector;

/**
 * Captures the variety of properties of two entities in the first level. The
 * first level includes only direct child class types or values in case of
 * Datatype properties.
 * 
 * @author hterhors
 *
 * @date May 18, 2017
 */
public class VarietyTemplate extends AbstractOBIETemplate<Scope> {

	public VarietyTemplate(AbstractOBIERunner runner) {
		super(runner);
	}

	private static Logger log = LogManager.getFormatterLogger(VarietyTemplate.class.getName());

	static class Child {
		final String className;
		final String value;
		final boolean isDataType;

		public Child(String className, String value, boolean isDataType) {
			this.className = className;
			this.value = value;
			this.isDataType = isDataType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((className == null) ? 0 : className.hashCode());
			result = prime * result + (isDataType ? 1231 : 1237);
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Child other = (Child) obj;
			if (className == null) {
				if (other.className != null)
					return false;
			} else if (!className.equals(other.className))
				return false;
			if (isDataType != other.isDataType)
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

	}

	class Scope extends FactorScope {

		private final Class<? extends IOBIEThing> parentClass;
		private final Set<Child>[] childrenOfEntities;

		public Scope(Class<? extends IOBIEThing> entityRootClassType, AbstractOBIETemplate<?> template,
				Class<? extends IOBIEThing> parentClass, Set<Child>[] childrenDatatypesOfEntities) {
			super(template, childrenDatatypesOfEntities, parentClass, entityRootClassType);
			this.childrenOfEntities = childrenDatatypesOfEntities;
			this.parentClass = parentClass;
		}

	}

	@Override
	public List<Scope> generateFactorScopes(OBIEState state) {
		List<Scope> factors = new ArrayList<>();

		final Map<Class<? extends IOBIEThing>, Set<Class<? extends IOBIEThing>>> influencedVariables = new HashMap<>();

		final Map<Class<? extends IOBIEThing>, Integer> countRootClasses = new HashMap<>();
		final Map<Class<? extends IOBIEThing>, Class<? extends IOBIEThing>> entityRootClassTypeMapper = new HashMap<>();

		/*
		 * If there is only one rootClass (e.g. OrganismModel) the entry of the map for
		 * that class should be equal to state.getPredictedResult.getEntities().size();
		 */
		state.getCurrentIETemplateAnnotations().getAnnotations().stream().forEach(a -> {

			countRootClasses.put(a.getThing().getClass(),
					1 + countRootClasses.getOrDefault(a.getThing().getClass(), 0));
			entityRootClassTypeMapper.put(a.getThing().getClass(), a.rootClassType);

		});

		Map<Class<? extends IOBIEThing>, Set<Child>[]> childrenOfEntities = new HashMap<>();
		Map<Class<? extends IOBIEThing>, Integer> indexRootClassCounter = new HashMap<>();

		/*
		 * Initialize for each root class type
		 */
		for (Entry<Class<? extends IOBIEThing>, Integer> ec : countRootClasses.entrySet()) {
			childrenOfEntities.put(ec.getKey(), new HashSet[ec.getValue()]);
			influencedVariables.put(ec.getKey(), new HashSet<>());
		}

		for (IETmplateAnnotation annotation : state.getCurrentIETemplateAnnotations().getAnnotations()) {

			// buildChildrenOfEntitiesRecursive(childrenOfEntities, annotation);

		}

		for (Entry<Class<? extends IOBIEThing>, Integer> ec : countRootClasses.entrySet()) {
			Scope scope = new Scope(entityRootClassTypeMapper.get(ec.getKey()), this, ec.getKey(),
					childrenOfEntities.get(ec.getKey()));
			// System.out.println(ec.getValue() + " - " +
			// scope.childrenOfEntities.length + "-" + scope);
			if (ec.getValue() > 1) {
				factors.add(scope);
			}
		}

		return factors;
	}

	public void buildChildrenOfEntitiesRecursive(Map<Class<? extends IOBIEThing>, Set<Child>[]> childrenOfEntities,
			IETmplateAnnotation annotation,
			Map<Class<? extends IOBIEThing>, Set<Class<? extends IOBIEThing>>> indexRootClassCounter) {
		// final IOBIEThing entityScioClass = annotation.getScioClass();
		//
		// final int index =
		// indexRootClassCounter.getOrDefault(entityScioClass.getClass(), 0);
		//
		// indexRootClassCounter.put(entityScioClass.getClass(), 1 + index);
		//
		// childrenOfEntities.get(entityScioClass.getClass())[index] = new
		// HashSet<>();
		//
		// /*
		// * TODO: Define active learning variables for cardinality of root
		// * classes.
		// */
		// //
		// influencedVariables.get(entityClass.getScioClass().getClass()).add(entityClass.getScioClass().getClass());
		//
		// final String surfaceForm = entityScioClass.getTextMention();
		//
		// if (surfaceForm == null)
		// return factors;
		//
		// /*
		// * Add factors for object type properties.
		// */
		// Arrays.stream(entityScioClass.getClass().getDeclaredFields())
		// .filter(f ->
		// f.isAnnotationPresent(OntologyModelContent.class)).forEach(field -> {
		// field.setAccessible(true);
		// try {
		// if (field.isAnnotationPresent(OneToManyRelation.class)) {
		// /**
		// * TODO: Integrate lists.
		// */
		// } else {
		//
		// final IOBIEThing childClass = (IOBIEThing)
		// field.get(entityScioClass);
		//
		// if (childClass != null) {
		// if
		// (childClass.getClass().isAnnotationPresent(DataTypeProperty.class))
		// /*
		// * FIXME: GetTextMention should be getValue,
		// * but as value always equals to text
		// * mention this works here.
		// */
		// childrenOfEntities.get(entityScioClass.getClass())[index].add(new
		// Child(
		// childClass.getClass().getSimpleName(), childClass.getTextMention(),
		// true));
		// else
		// childrenOfEntities.get(entityScioClass.getClass())[index]
		// .add(new Child(childClass.getClass().getSimpleName(), null, false));
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// });

	}

	@Override
	public void computeFactor(Factor<Scope> factor) {
		Vector featureVector = factor.getFeatureVector();

		Set<String> differentChildrenNames = new HashSet<>();
		Set<String> differentChildren = new HashSet<>();
		for (int i = 0; i < factor.getFactorScope().childrenOfEntities.length; i++) {
			Set<Child> tmp = new HashSet<>(factor.getFactorScope().childrenOfEntities[i]);
			for (int j = 0; j < factor.getFactorScope().childrenOfEntities.length; j++) {
				if (i == j)
					continue;
				tmp.removeAll(factor.getFactorScope().childrenOfEntities[j]);
			}
			differentChildrenNames.addAll(tmp.stream().map(f -> f.className).collect(Collectors.toList()));
			differentChildren.addAll(tmp.stream().map(f -> {
				if (f.isDataType)
					return f.value;
				else
					return f.className;
			}).collect(Collectors.toList()));
		}
		/**
		 * CHECKME: Is it better to take parent class instead of direct class type?
		 * 
		 * Male vs. Gender (More general)
		 */
		featureVector.set("Number of annotations = " + factor.getFactorScope().childrenOfEntities.length
				+ ", number of different children for " + factor.getFactorScope().parentClass.getSimpleName() + " = "
				+ (differentChildren.size()), true);
		// / factor.getFactorScope().childrenOfEntities.length)

		List<String> sortedDifferences = new ArrayList<>(differentChildrenNames);
		Collections.sort(sortedDifferences);

		featureVector.set("Number of annotations = " + factor.getFactorScope().childrenOfEntities.length
				+ ", different children for " + factor.getFactorScope().parentClass.getSimpleName() + " = "
				+ sortedDifferences, true);

		// featureVector.set("Size of different children for " +
		// factor.getFactorScope().parentClass.getSimpleName()
		// + " = " + differentChildren, true);

		// System.out.println("differentChildren = " + differentChildren);

		// System.out.println("SCOPEEEE" + " :: " +
		// Arrays.toString(factor.getFactorScope().childrenClassTypesOfEntities));

	}

}
