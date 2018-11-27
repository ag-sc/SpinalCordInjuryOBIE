package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.nel.regex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.ml.ner.regex.BasicRegExPattern;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticAge;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticDepth;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticDistance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticDosage;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticDuration;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticForce;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticLength;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticLightIntensity;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticNNumber;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticPValue;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticPressure;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticStandardDeviation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticStandardError;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticTemperature;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticThickness;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticVolume;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticWeight;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Age;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AgeCategory;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Compound;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CompoundTreatment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Depth;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Distance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Dosage;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Duration;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Force;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Gender;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GuineaPigModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GuineaPigSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.KeepingCondition;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Length;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.LightIntensity;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MouseModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MouseSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.NNumber;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.NYUImpactor;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.PValue;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.PostSurgeryCondition;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Pressure;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RatModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RatSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.StandardDeviation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.StandardError;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Temperature;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Thickness;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.UnivOfTriesteImpactor;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Volume;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Weight;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ICompound;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

public class SCIORegExPattern extends BasicRegExPattern<ISCIOThing> {

	private static final Set<String> SCIO_STOP_WORDS = new HashSet<>(Arrays.asList());

	/*
	 * Rats
	 */

	private static Pattern RAT_MODEL_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "(albino.?)?rats?" + POST_BOUNDS,
			PATTERN_BITMASK);

	private static Pattern LONG_EVANS_RAT_MODEL_PATTERN_1 = Pattern.compile(
			PRE_BOUNDS + buildRegExpr("long", "evans", new String[] { "rats?" }, "strains?") + POST_BOUNDS,
			PATTERN_BITMASK);

	private static Pattern SPRAGUE_DAWLEY_RAT_MODEL_PATTERN_1 = Pattern.compile(PRE_BOUNDS
			+ buildRegExpr("sprague", "dawley", new String[] { "albino.?rats?", "rats?" }, "strains?") + POST_BOUNDS,
			PATTERN_BITMASK);

	private static Pattern WISTAR_RAT_MODEL_PATTERN_1 = Pattern.compile(
			PRE_BOUNDS + buildRegExpr("wistar", new String[] { "albino", "rats?" }, "strains?") + POST_BOUNDS,
			PATTERN_BITMASK);

	/*
	 * Mice
	 */

	private static Pattern MOUSE_MODEL_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "(albino.?)?(mouse|mice)" + POST_BOUNDS,
			PATTERN_BITMASK);

	private static Pattern CD1_MOUSE_MODEL_PATTERN_1 = Pattern.compile(
			PRE_BOUNDS + buildRegExpr("cd.?2?", new String[] { "albino", "mouse", "mice" }, "strains?") + POST_BOUNDS,
			PATTERN_BITMASK);

	private static Pattern CD2_MOUSE_MODEL_PATTERN_1 = Pattern.compile(
			PRE_BOUNDS + buildRegExpr("cd.?1?", new String[] { "albino", "mouse", "mice" }, "strains?") + POST_BOUNDS,
			PATTERN_BITMASK);

	private static Pattern BALB_C_MOUSE_PATTERN_1 = Pattern.compile(
			PRE_BOUNDS + buildRegExpr("balb(.?c?)?", new String[] { "mouse", "mice" }, "strains?") + POST_BOUNDS,
			PATTERN_BITMASK);

	private static Pattern C57_BL6_MOUSE_PATTERN_1 = Pattern.compile(
			PRE_BOUNDS + buildRegExpr("c57", "bl.6\\w?", new String[] { "mouse", "mice" }, "strains?") + POST_BOUNDS,
			PATTERN_BITMASK);

	/*
	 * Guinea Pig
	 */
	private static Pattern GUINEA_PIG_MODEL_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "guinea(.?pigs?)?" + POST_BOUNDS,
			PATTERN_BITMASK);

	private static Pattern HARTLEY_GUINEA_PIG_PATTERN_1 = Pattern.compile(
			PRE_BOUNDS + buildRegExpr("hartley", new String[] { "guinea", "pigs?" }, "strains?") + POST_BOUNDS,
			PATTERN_BITMASK);

	/*
	 * Gender
	 */
	private static Pattern GENDER_MALE_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "male" + POST_BOUNDS, PATTERN_BITMASK);
	private static Pattern GENDER_FEMALE_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "female" + POST_BOUNDS,
			PATTERN_BITMASK);
	private static Pattern GENDER_MIXED_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "mixed" + POST_BOUNDS,
			PATTERN_BITMASK);

	/*
	 * AgeCategory
	 */

	private static Pattern AGE_CATEGORY_ADULT_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "(mature|adult)" + POST_BOUNDS,
			PATTERN_BITMASK);
	private static Pattern AGE_CATEGORY_YOUNG_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "young" + POST_BOUNDS,
			PATTERN_BITMASK);

	private static Pattern AGE_CATEGORY_AGED_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "aged" + POST_BOUNDS,
			PATTERN_BITMASK);

	private static final Set<Pattern> DOSAGE_REG_EXP = new HashSet<>(Arrays.asList(SemanticDosage.PATTERN));

	private static final Set<Pattern> DURATION_REG_EXP = new HashSet<>(Arrays.asList(SemanticDuration.PATTERN));

	private static final Set<Pattern> DEPTH_REG_EXP = new HashSet<>(Arrays.asList(SemanticDepth.PATTERN));

	private static final Set<Pattern> DISTANCE_REG_EXP = new HashSet<>(Arrays.asList(SemanticDistance.PATTERN));

	private static final Set<Pattern> FORCE_REG_EXP = new HashSet<>(Arrays.asList(SemanticForce.PATTERN));

	private static final Set<Pattern> PRESSURE_REG_EXP = new HashSet<>(Arrays.asList(SemanticPressure.PATTERN));

	private static final Set<Pattern> LENGTH_REG_EXP = new HashSet<>(Arrays.asList(SemanticLength.PATTERN));

	private static final Set<Pattern> THICKNESS_REG_EXP = new HashSet<>(Arrays.asList(SemanticThickness.PATTERN));

	private static final Set<Pattern> TEMPERATURE_REG_EXP = new HashSet<>(Arrays.asList(SemanticTemperature.PATTERN));

	private static final Set<Pattern> NNUMBER_REG_EXP = new HashSet<>(Arrays.asList(SemanticNNumber.PATTERN));

	private static final Set<Pattern> PVALUE_REG_EXP = new HashSet<>(Arrays.asList(SemanticPValue.PATTERN));

	private static final Set<Pattern> STDERR_REG_EXP = new HashSet<>(Arrays.asList(SemanticStandardError.PATTERN));

	private static final Set<Pattern> STDDEV_REG_EXP = new HashSet<>(Arrays.asList(SemanticStandardDeviation.PATTERN));

	private static final Set<Pattern> VOLUME_REG_EXP = new HashSet<>(Arrays.asList(SemanticVolume.PATTERN));

	private static final Set<Pattern> AGE_REG_EXP = new HashSet<>(Arrays.asList(SemanticAge.PATTERN));

	private static final Set<Pattern> WEIGHT_REG_EXP = new HashSet<>(Arrays.asList(SemanticWeight.PATTERN));

	private static final Set<Pattern> LIGHT_INTENSE_REG_EXP = new HashSet<>(
			Arrays.asList(SemanticLightIntensity.PATTERN));

	private static final Set<Pattern> CD1_MOUSE_MODEL_REG_EXP = new HashSet<>(Arrays.asList(CD1_MOUSE_MODEL_PATTERN_1));

	private static final Set<Pattern> CD2_MOUSE_MODEL_REG_EXP = new HashSet<>(Arrays.asList(CD2_MOUSE_MODEL_PATTERN_1));

	private static final Set<Pattern> BALB_C_MOUSE_MODEL_REG_EXP = new HashSet<>(Arrays.asList(BALB_C_MOUSE_PATTERN_1));

	private static final Set<Pattern> C57_BL6_MOUSE_MODEL_REG_EXP = new HashSet<>(
			Arrays.asList(C57_BL6_MOUSE_PATTERN_1));

	private static final Set<Pattern> GUINEA_PIG_MODEL_REG_EXP = new HashSet<>(
			Arrays.asList(GUINEA_PIG_MODEL_PATTERN_1));

	private static final Set<Pattern> HARTLEY_GUINEA_PIG_REG_EXP = new HashSet<>(
			Arrays.asList(HARTLEY_GUINEA_PIG_PATTERN_1));

	private static final Set<Pattern> SPRAGUE_DAWLEY_RAT_REG_EXP = new HashSet<>(
			Arrays.asList(SPRAGUE_DAWLEY_RAT_MODEL_PATTERN_1));

	private static final Set<Pattern> WISTAR_RAT_REG_EXP = new HashSet<>(Arrays.asList(WISTAR_RAT_MODEL_PATTERN_1));

	private static final Set<Pattern> RAT_MODEL_REG_EXP = new HashSet<>(Arrays.asList(RAT_MODEL_PATTERN_1));

	private static final Set<Pattern> MOUSE_MODEL_REG_EXP = new HashSet<>(Arrays.asList(MOUSE_MODEL_PATTERN_1));

	private static final Set<Pattern> GENDER_FEMALE_REG_EXP = new HashSet<>(Arrays.asList(GENDER_FEMALE_PATTERN_1));

	private static final Set<Pattern> GENDER_MALE_REG_EXP = new HashSet<>(Arrays.asList(GENDER_MALE_PATTERN_1));

	private static final Set<Pattern> GENDER_MIXED_REG_EXP = new HashSet<>(Arrays.asList(GENDER_MIXED_PATTERN_1));

	private static final Set<Pattern> AGE_CATEGORY_ADULT_REG_EXP = new HashSet<>(
			Arrays.asList(AGE_CATEGORY_ADULT_PATTERN_1));

	private static final Set<Pattern> AGE_CATEGORY_YOUNG_REG_EXP = new HashSet<>(
			Arrays.asList(AGE_CATEGORY_YOUNG_PATTERN_1));

	private static final Set<Pattern> AGE_CATEGORY_AGED_REG_EXP = new HashSet<>(
			Arrays.asList(AGE_CATEGORY_AGED_PATTERN_1));

	private static final Set<Pattern> LONG_EVANS_RAT_REG_EXP = new HashSet<>(
			Arrays.asList(LONG_EVANS_RAT_MODEL_PATTERN_1));

	/**
	 * TREATMENTS
	 */
	private final Set<Pattern> COMPOUND_REG_EXP;

	/**
	 * INYURIES
	 */
	private static final Pattern NYUIMPACTOR_PATTERN_1 = Pattern
			.compile(PRE_BOUNDS + "new.york(.university)?(.impactor)?" + POST_BOUNDS, PATTERN_BITMASK);

	private static final Set<Pattern> NYUIMPACTOR_REG_EXP = new HashSet<>(Arrays.asList(NYUIMPACTOR_PATTERN_1));

	private static final Pattern BLADDER_EXPRESSION_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "bladders" + POST_BOUNDS,
			PATTERN_BITMASK);

	private static final Set<Pattern> BLADDER_EXPRESSION_REG_EXP = new HashSet<>(
			Arrays.asList(BLADDER_EXPRESSION_PATTERN_1));

	private static final Pattern NUTRITION_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "food" + POST_BOUNDS,
			PATTERN_BITMASK);

	private static final Set<Pattern> NUTRITION_REG_EXP = new HashSet<>(Arrays.asList(NUTRITION_PATTERN_1));

	private static final Pattern HYDRATION_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "water" + POST_BOUNDS,
			PATTERN_BITMASK);

	private static final Set<Pattern> HYDRATION_REG_EXP = new HashSet<>(Arrays.asList(HYDRATION_PATTERN_1));

	private static final Pattern UTSIMPACTOR_PATTERN_1 = Pattern.compile(PRE_BOUNDS + "UTS(.?impactor)?" + POST_BOUNDS,
			PATTERN_BITMASK);

	private static final Pattern UTSIMPACTOR_PATTERN_2 = Pattern
			.compile(PRE_BOUNDS + "university.of.trieste?(.impactor)?" + POST_BOUNDS, PATTERN_BITMASK);

	private static final Set<Pattern> UTSIMPACTOR_REG_EXP = new HashSet<>(
			Arrays.asList(UTSIMPACTOR_PATTERN_1, UTSIMPACTOR_PATTERN_2));

	public SCIORegExPattern() {
		COMPOUND_REG_EXP = patternForCompounds();
	}

	private Map<Class<? extends ISCIOThing>, Set<Pattern>> handMadepatternForClasses = null;

	private Map<AbstractIndividual, Set<Pattern>> handMadepatternForIndividuals = null;

	public Map<Class<? extends ISCIOThing>, Set<Pattern>> getHandMadePatternForClasses() {

		if (handMadepatternForClasses != null) {
			return handMadepatternForClasses;
		}
		/*
		 * AnimalModel
		 */
		handMadepatternForClasses = new HashMap<Class<? extends ISCIOThing>, Set<Pattern>>();
		handMadepatternForClasses.put(MouseModel.class, SCIORegExPattern.MOUSE_MODEL_REG_EXP);
		handMadepatternForClasses.put(GuineaPigModel.class, SCIORegExPattern.GUINEA_PIG_MODEL_REG_EXP);
		handMadepatternForClasses.put(RatModel.class, SCIORegExPattern.RAT_MODEL_REG_EXP);
		/*
		 * Treatment
		 */
		handMadepatternForClasses.put(CompoundTreatment.class, COMPOUND_REG_EXP);
		handMadepatternForClasses.put(Compound.class, COMPOUND_REG_EXP);

		/*
		 * injury
		 */
		handMadepatternForClasses.put(NYUImpactor.class, SCIORegExPattern.NYUIMPACTOR_REG_EXP);
		handMadepatternForClasses.put(UnivOfTriesteImpactor.class, SCIORegExPattern.UTSIMPACTOR_REG_EXP);

		/*
		 * Datatype Properties
		 */
		handMadepatternForClasses.put(Age.class, SCIORegExPattern.AGE_REG_EXP);
		handMadepatternForClasses.put(Weight.class, SCIORegExPattern.WEIGHT_REG_EXP);
		handMadepatternForClasses.put(Dosage.class, SCIORegExPattern.DOSAGE_REG_EXP);
		handMadepatternForClasses.put(Duration.class, SCIORegExPattern.DURATION_REG_EXP);
		handMadepatternForClasses.put(Depth.class, SCIORegExPattern.DEPTH_REG_EXP);
		handMadepatternForClasses.put(Distance.class, SCIORegExPattern.DISTANCE_REG_EXP);
		handMadepatternForClasses.put(Force.class, SCIORegExPattern.FORCE_REG_EXP);
		handMadepatternForClasses.put(Volume.class, SCIORegExPattern.VOLUME_REG_EXP);
		handMadepatternForClasses.put(Pressure.class, SCIORegExPattern.PRESSURE_REG_EXP);
		handMadepatternForClasses.put(Length.class, SCIORegExPattern.LENGTH_REG_EXP);
		handMadepatternForClasses.put(Thickness.class, SCIORegExPattern.THICKNESS_REG_EXP);
		handMadepatternForClasses.put(Temperature.class, SCIORegExPattern.TEMPERATURE_REG_EXP);
		handMadepatternForClasses.put(NNumber.class, SCIORegExPattern.NNUMBER_REG_EXP);
		handMadepatternForClasses.put(PValue.class, SCIORegExPattern.PVALUE_REG_EXP);
		handMadepatternForClasses.put(StandardError.class, SCIORegExPattern.STDERR_REG_EXP);
		handMadepatternForClasses.put(StandardDeviation.class, SCIORegExPattern.STDDEV_REG_EXP);
		handMadepatternForClasses.put(LightIntensity.class, SCIORegExPattern.LIGHT_INTENSE_REG_EXP);
		return handMadepatternForClasses;
	}

	public Map<AbstractIndividual, Set<Pattern>> getHandMadePatternForIndividuals() {

		if (handMadepatternForIndividuals != null) {
			return handMadepatternForIndividuals;
		}
		/*
		 * AnimalModel
		 */
		handMadepatternForIndividuals = new HashMap<AbstractIndividual, Set<Pattern>>();
		handMadepatternForIndividuals.put(
				MouseSpecies.individualFactory.getIndividualByURI("http://psink.de/scio/CD1_Mouse"),
				SCIORegExPattern.CD1_MOUSE_MODEL_REG_EXP);
		handMadepatternForIndividuals.put(
				MouseSpecies.individualFactory.getIndividualByURI("http://psink.de/scio/CD2_Mouse"),
				SCIORegExPattern.CD2_MOUSE_MODEL_REG_EXP);
		handMadepatternForIndividuals.put(
				MouseSpecies.individualFactory.getIndividualByURI("http://psink.de/scio/BALB_C_Mouse"),
				SCIORegExPattern.BALB_C_MOUSE_MODEL_REG_EXP);
		handMadepatternForIndividuals.put(
				MouseSpecies.individualFactory.getIndividualByURI("http://psink.de/scio/C57_BL6_Mouse"),
				SCIORegExPattern.C57_BL6_MOUSE_MODEL_REG_EXP);
		handMadepatternForIndividuals.put(
				GuineaPigSpecies.individualFactory.getIndividualByURI("http://psink.de/scio/HartleyGuineaPig"),
				SCIORegExPattern.HARTLEY_GUINEA_PIG_REG_EXP);
		handMadepatternForIndividuals.put(
				RatSpecies.individualFactory.getIndividualByURI("http://psink.de/scio/WistarRat"),
				SCIORegExPattern.WISTAR_RAT_REG_EXP);
		handMadepatternForIndividuals.put(
				RatSpecies.individualFactory.getIndividualByURI("http://psink.de/scio/SpragueDawleyRat"),
				SCIORegExPattern.SPRAGUE_DAWLEY_RAT_REG_EXP);
		handMadepatternForIndividuals.put(
				RatSpecies.individualFactory.getIndividualByURI("http://psink.de/scio/LongEvansRat"),
				SCIORegExPattern.LONG_EVANS_RAT_REG_EXP);
		handMadepatternForIndividuals.put(Gender.individualFactory.getIndividualByURI("http://psink.de/scio/Female"),
				SCIORegExPattern.GENDER_FEMALE_REG_EXP);
		handMadepatternForIndividuals.put(Gender.individualFactory.getIndividualByURI("http://psink.de/scio/Male"),
				SCIORegExPattern.GENDER_MALE_REG_EXP);
		handMadepatternForIndividuals.put(Gender.individualFactory.getIndividualByURI("http://psink.de/scio/Mixed"),
				SCIORegExPattern.GENDER_MIXED_REG_EXP);
		handMadepatternForIndividuals.put(
				AgeCategory.individualFactory.getIndividualByURI("http://psink.de/scio/Adult"),
				SCIORegExPattern.AGE_CATEGORY_ADULT_REG_EXP);
		handMadepatternForIndividuals.put(
				AgeCategory.individualFactory.getIndividualByURI("http://psink.de/scio/Young"),
				SCIORegExPattern.AGE_CATEGORY_YOUNG_REG_EXP);
		handMadepatternForIndividuals.put(AgeCategory.individualFactory.getIndividualByURI("http://psink.de/scio/Aged"),
				SCIORegExPattern.AGE_CATEGORY_AGED_REG_EXP);
		/*
		 * Treatment
		 */

		/*
		 * injury
		 */
		handMadepatternForIndividuals.put(
				PostSurgeryCondition.individualFactory.getIndividualByURI("http://psink.de/scio/BladderExpression"),
				SCIORegExPattern.BLADDER_EXPRESSION_REG_EXP);
		handMadepatternForIndividuals.put(
				KeepingCondition.individualFactory.getIndividualByURI("http://psink.de/scio/Nutrition"),
				SCIORegExPattern.NUTRITION_REG_EXP);
		handMadepatternForIndividuals.put(
				KeepingCondition.individualFactory.getIndividualByURI("http://psink.de/scio/Hydration"),
				SCIORegExPattern.HYDRATION_REG_EXP);

		return handMadepatternForIndividuals;
	}

	private Set<Pattern> patternForCompounds() {

		Set<Pattern> pattern = new HashSet<>();

		for (Set<Pattern> compoundClassPattern : autoGeneratePatternForClasses(ICompound.class).values()) {
			pattern.addAll(compoundClassPattern);
		}
		return pattern;
	}

	@Override
	public Set<String> getAdditionalStopWords() {
		return SCIO_STOP_WORDS;
	}

	@Override
	public int getMinTokenlength() {
		return 3;
	}

}
