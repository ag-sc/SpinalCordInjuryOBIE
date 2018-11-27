package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.sparql;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.ApoptosisTest;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.BBBTest;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Compression;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Contusion;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.LesionVolumeTest;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ILocomotorTest;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISecondaryDegenerationTest;

public class CompetencyQuestionsSPARQLQueries {

	/**
	 * Name space of properties.
	 */
	public static final String PREDICATE_SLOT = "<http://localhost:8080/%s>";

	/**
	 * Name space for subject and object.
	 */
	public static final String TYPE_SLOT = "<http://localhost:8080/%s>";

	/**
	 * 1. Is a treatment effect on secondary degeneration mainly dependent on injury
	 * type?
	 */
	public static final String COMPETENCY_QUESTION_1 = "SELECT ?judgement ?injuryType WHERE {\n"
			+ statement("?r", "targetGroup", "?targetGroup")
			//
			+ statement("?r", "investigationMethod", "?investMethod")
			//
			+ statement("?r", "judgement", "?j")
			//
			+ statement("?targetGroup", "injuryModel", "?injuryModel")
			//
			+ statement("?injuryModel", "rdf:type", "?injuryType")
			//
			+ statement("?j", "rdf:type", "?judgement")
			//
			+ union("?investMethod", "rdf:type", getSubclasses(ISecondaryDegenerationTest.class)) + "}";

	/**
	 * 2. Is a treatment effect on locomotion mainly dependent on injury type?
	 */

	public static final String COMPETENCY_QUESTION_2 = "SELECT ?judgement ?injuryType WHERE {\n"
			+ statement("?r", "targetGroup", "?targetGroup")
			//
			+ statement("?r", "investigationMethod", "?investMethod")
			//
			+ statement("?r", "judgement", "?j")
			//
			+ statement("?targetGroup", "injuryModel", "?injuryModel")
			//
			+ statement("?injuryModel", "rdf:type", "?injuryType")
			//
			+ statement("?j", "rdf:type", "?judgement")
			//
			+ union("?investMethod", "rdf:type", getSubclasses(ILocomotorTest.class)) + "}";

	/**
	 * 3. Is a treatment effect on secondary degeneration dependent on observation
	 * timepoint and does this depend on the injury type?
	 * 
	 */

	public static final String COMPETENCY_QUESTION_3 = "SELECT ?judgement ?injuryType ?timepointValue WHERE {\n"
			+ statement("?r", "targetGroup", "?targetGroup")
			//
			+ statement("?r", "investigationMethod", "?investMethod")
			//
			+ statement("?r", "judgement", "?j")
			//
			+ statement("?r", "_observations", "?observation")
			//
			+ statement("?observation", "timepoint", "?timepoint")
			//
			+ statement("?timepoint", "hasSCIOValue", "?timepointValue")
			//
			+ statement("?targetGroup", "injuryModel", "?injuryModel")
			//
			+ statement("?injuryModel", "rdf:type", "?injuryType")
			//
			+ statement("?j", "rdf:type", "?judgement")
			//
			+ union("?investMethod", "rdf:type", getSubclasses(ISecondaryDegenerationTest.class)) + "}";

	/**
	 * 4. Is the secondary degeneration dependent on the animals' gender?
	 */
	public static final String COMPETENCY_QUESTION_4 = "SELECT ?judgement ?organismGender WHERE {\n"
			+ statement("?r", "targetGroup", "?tG")
			//
			+ statement("?r", "investigationMethod", "?iM")
			//
			+ union("?iM", "rdf:type", getSubclasses(ISecondaryDegenerationTest.class))
			//
			+ statement("?r", "judgement", "?j")
			//
			+ statement("?j", "rdf:type", "?judgement")
			//
			+ statement("?tG", "organismModel", "?oM")
			//
			+ statement("?oM", "gender", "?oG")
			//
			+ statement("?oG", "rdf:type", "?organismGender") + "}";

	/**
	 * 5. Is there a difference in locomotor outcome between contusion and
	 * compression?
	 */
	@SuppressWarnings("unchecked")
	public static final String COMPETENCY_QUESTION_5 = "SELECT ?judgement ?injuryType  WHERE {\n"
			+ statement("?r", "targetGroup", "?targetGroup")
			//
			+ statement("?r", "investigationMethod", "?investMethod")
			//
			+ statement("?r", "judgement", "?j")
			//
			+ statement("?targetGroup", "injuryModel", "?injuryModel")
			//
			+ statement("?injuryModel", "rdf:type", "?injuryType")
			//
			+ union("?injuryModel", "rdf:type", set(Contusion.class, Compression.class))
			//
			+ statement("?j", "rdf:type", "?judgement")
			//
			+ union("?investMethod", "rdf:type", getSubclasses(ILocomotorTest.class)) + "}";

	/**
	 * 6. Does the timing of the treatment have an effect on secondary degeneration?
	 */

	/**
	 * 7. Does the timing of the treatment have an effect on locomotion?
	 */

	/**
	 * 8. What is the effect of the investigation timepoint on the observed success
	 * in locomotion?
	 */

	/**
	 * 9. Is there a correlation between lesion volume and apoptosis?
	 */
	@SuppressWarnings("unchecked")
	public static final String COMPETENCY_QUESTION_9 = "SELECT ?judgement ?investigationMethod WHERE {\n"
			+ statement("?r", "targetGroup", "?targetGroup")
			//
			+ statement("?r", "investigationMethod", "?iM")
			//
			+ statement("?iM", "rdf:type", "?investigationMethod")
			//
			+ statement("?r", "judgement", "?j")
			//
			+ statement("?targetGroup", "injuryModel", "?injuryModel")
			//
			+ statement("?injuryModel", "rdf:type", "?injuryType")
			//
			+ statement("?j", "rdf:type", "?judgement")
			//
			+ union("?iM", "rdf:type", set(LesionVolumeTest.class, ApoptosisTest.class)) + "}";

	/**
	 * 10. Is there a correlation between BBB (does the BBB reach a plateau of 8 or
	 * 11 or 13) and secondary degeneration?
	 */
	@SuppressWarnings("unchecked")
	public static final String COMPETENCY_QUESTION_10 = "SELECT ?judgement ?numericValue ?investigationMethod WHERE {\n"
			+ statement("?r", "targetGroup", "?targetGroup")
			//
			+ statement("?r", "investigationMethod", "?iM")
			//
			+ statement("?iM", "rdf:type", "?investigationMethod")
			//
			+ statement("?r", "judgement", "?j")
			//
			+ statement("?r", "_observations", "?observation")
			//
			+ statement("?observation", "numericValue", "?nV")
			//
			+ statement("?nV", "hasSCIOValue", "?numericValue")
			//
			+ statement("?j", "rdf:type", "?judgement")
			//
			+ union("?iM", "rdf:type",
					appendSet(BBBTest.class,
							(Class<? extends IOBIEThing>[]) getSubclasses(ISecondaryDegenerationTest.class)
									.toArray(new Class[getSubclasses(ISecondaryDegenerationTest.class).size()])))
			+ "}";

	/**
	 * 11. Is there a correlation between axonal regeneration and locomotor
	 * recovery?
	 */

	@SuppressWarnings("unchecked")
	private static Set<Class<? extends IOBIEThing>> set(Class<? extends IOBIEThing>... classes) {
		return new HashSet<>(Arrays.asList(classes));
	}

	@SuppressWarnings("unchecked")
	private static Set<Class<? extends IOBIEThing>> appendSet(Class<? extends IOBIEThing> c,
			Class<? extends IOBIEThing>... classes) {
		Set<Class<? extends IOBIEThing>> ret = new HashSet<>(Arrays.asList(classes));
		ret.add(c);
		return ret;
	}

	private static String statement(final String subject, final String predicate, final String object) {

		StringBuffer line = new StringBuffer();
		line.append(typeParameter(subject));
		line.append(" ");
		line.append(predicateParameter(predicate));
		line.append(" ");
		line.append(typeParameter(object));
		line.append(".\n");
		return line.toString();

	}

	/**
	 * Returns all scio-subclasses of the given scio-superclass.
	 * 
	 * @param superClass
	 * @return a set of scio-classes
	 */
	private static Set<Class<? extends IOBIEThing>> getSubclasses(Class<? extends IOBIEThing> superClass) {
		// return OntologyAnalyzer.getInstance().getAllSubClassesOf(superClass);
		return new HashSet<>(Arrays.asList(superClass.getAnnotation(AssignableSubClasses.class).get()));
	}

	private static String union(final String subject, final String predicate,
			final Set<Class<? extends IOBIEThing>> objects) {
		StringBuffer line = new StringBuffer();

		boolean addUnion = false;
		for (Class<? extends IOBIEThing> scioClass : objects) {
			if (addUnion)
				line.append("UNION");
			line.append("{");
			line.append(typeParameter(subject));
			line.append(" ");
			line.append(predicateParameter(predicate));
			line.append(" ");
			line.append(typeParameter(scioClass.getSimpleName()));
			line.append(".} \n");
			addUnion = true;
		}
		return line.toString();

	}

	private static String statement(final String subject, final String predicate,
			final Class<? extends IOBIEThing> object) {
		return statement(subject, predicate, object.getSimpleName());
	}

	private static String statement(final String subject, final Class<? extends IOBIEThing> predicate, String object) {
		return statement(subject, lower(predicate.getSimpleName()), object);

	}

	private static String lower(final String scioClass) {
		return Character.toLowerCase(scioClass.charAt(0)) + scioClass.substring(1);
	}

	private static String typeParameter(final String parameter) {
		return parameter.startsWith("?") ? parameter : typeSlot(parameter);
	}

	private static String predicateParameter(final String parameter) {
		if (parameter.equals("rdf:type")) {
			return "<http://www.w3.org/2000/01/rdf-schema#:type>";
		} else {
			return parameter.startsWith("?") ? parameter : predicateSlot(parameter);
		}

	}

	private static String typeSlot(String parameter) {
		return String.format(TYPE_SLOT, parameter);
	}

	private static String predicateSlot(String parameter) {
		return String.format(PREDICATE_SLOT, parameter);
	}

}
