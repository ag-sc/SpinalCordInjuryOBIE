package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hterhors.obie.ml.dtinterpreter.AbstractInterpreterBuilder;
import de.hterhors.obie.ml.dtinterpreter.AbstractNumericInterpreter;
import de.hterhors.obie.ml.dtinterpreter.IDoubleUnit;
import de.hterhors.obie.ml.dtinterpreter.IDoubleUnitType;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticDosage.EDosagesUnits.EType;

public class SemanticDosage extends AbstractNumericInterpreter {

	public static void main(String[] args) {

		System.out.println(new SemanticDosage("1 mg", EDosagesUnits.mg, 1D, false).convertTo(EDosagesUnits.µg));
		System.out.println(new SemanticDosage("1 mg", EDosagesUnits.mg, 1D, false).convertTo(EDosagesUnits.g));
		System.out.println();
		System.out.println(new SemanticDosage("1 ml", EDosagesUnits.ml, 1D, false).convertTo(EDosagesUnits.µl));
		System.out.println(new SemanticDosage("1 ml", EDosagesUnits.ml, 1D, false).convertTo(EDosagesUnits.cm3));
		System.out.println(new SemanticDosage("1 ml", EDosagesUnits.ml, 1D, false).convertTo(EDosagesUnits.l));

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final static private double E6 = 1000000D;
	final static private double E3 = 1000D;

	static public enum EDosagesUnits implements IDoubleUnit {

		undef(0D, 0D, EType.ELSE),
		//
		percentage(1D, 1D, EType.PERCENT),
		//
		µg(E3, 1D, EType.WEIGHT), mg(1D, 1D, EType.WEIGHT), g(1D / E3, 1D, EType.WEIGHT),
		//
		µl(E3, 1D, EType.VOLUME), cm3(1D, 1D, EType.VOLUME), ml(1D, 1D, EType.VOLUME), l(1D / E3, 1D, EType.VOLUME),
		//
		iu(1D, 1D, EType.UNIT),
		//
		mm(1D, 1D, EType.MOL),
		//
		iu_kg(1D, 1D / E3, EType.UNIT_WEIGHT), iu_g(1D, 1D, EType.UNIT_WEIGHT), iu_mg(1D, E3, EType.UNIT_WEIGHT),
		iu_µg(1D, E6, EType.UNIT_WEIGHT), miu_µg(E3, E6, EType.UNIT_WEIGHT),
		//
		iu_kg_bw(1D, 1D / E3, EType.UNIT_WEIGHT_BW), iu_g_bw(1D, 1D, EType.UNIT_WEIGHT_BW),
		iu_mg_bw(1D, E3, EType.UNIT_WEIGHT_BW), iu_µg_bw(1D, E6, EType.UNIT_WEIGHT_BW),
		//
		iu_ml(1D, 1D, EType.UNIT_VOLUME), iu_µl(1D, E3, EType.UNIT_VOLUME), iu_l(1D, 1 / E3, EType.UNIT_VOLUME),
		miu_ml(E3, 1D, EType.UNIT_VOLUME), miu_µl(E3, E3, EType.UNIT_VOLUME),
		//
		iu_day(1D, 1D, EType.UNIT_TIME), µiu_day(E6, 1D, EType.UNIT_TIME),
		//
		mg_h(1D, 1D, EType.WEIGHT_TIME), mg_day(1D, 1D / 24D, EType.WEIGHT_TIME), µg_h(E3, 1D, EType.WEIGHT_TIME),
		µg_day(E3, 1D / 24D, EType.WEIGHT_TIME), g_h(1D / E3, 1D, EType.WEIGHT_TIME),
		g_day(1D / E3, 1D / 24D, EType.WEIGHT_TIME),
		//
		µmol_kg(1D, 1D, EType.MOL_WEIGHT),
		//
		µl_ml(1D, 1D, EType.VOLUME_VOLUME),
		//
		mmol_l(1D, 1D, EType.MOL_VOLUME), µmol_l(E3, 1D, EType.MOL_VOLUME), mol_l(1D / E3, 1D, EType.MOL_VOLUME),
		//
		cfu_ml(1D, 1D, EType.CFU_WEIGHT),
		//
		µl_kg(E3, 1D / E3, EType.VOLUME_WEIGHT), ml_g(1D, 1D, EType.VOLUME_WEIGHT),
		ml_kg(1D, 1D / E3, EType.VOLUME_WEIGHT), µl_g(E3, 1D, EType.VOLUME_WEIGHT),
		//
		µl_kg_bw(E3, 1D / E3, EType.VOLUME_WEIGHT_BW), ml_g_bw(1D, 1D, EType.VOLUME_WEIGHT_BW),
		ml_mg_bw(1D, E3, EType.VOLUME_WEIGHT_BW), ml_kg_bw(1D, 1D / E3, EType.VOLUME_WEIGHT_BW),
		µl_g_bw(E3, 1D, EType.VOLUME_WEIGHT_BW),
		//
		µl_h(E3, 1D, EType.VOLUME_TIME), ml_h(1D, 1D, EType.VOLUME_TIME), l_h(1D / E3, 1D, EType.VOLUME_TIME),
		l_min(1 / E3, 60D, EType.VOLUME_TIME), µl_day(E3, 1 / 24D, EType.VOLUME_TIME),
		ml_day(1D, 1 / 24D, EType.VOLUME_TIME),
		//
		µg_ml(E3, 1D, EType.WEIGHT_VOLUME), µg_l(E3, 1D / E3, EType.WEIGHT_VOLUME), mg_ml(1D, 1D, EType.WEIGHT_VOLUME),
		mg_l(1D, 1D / E3, EType.WEIGHT_VOLUME), g_ml(1 / E3, 1D, EType.WEIGHT_VOLUME),
		g_l(1D / E3, 1d / E3, EType.WEIGHT_VOLUME), mg_µl(1D, E3, EType.WEIGHT_VOLUME),
		µg_µl(E3, E3, EType.WEIGHT_VOLUME),
		//
		µg_kg(E3, 1D / E3, EType.WEIGHT_WEIGHT), mg_g(E3, 1D, EType.WEIGHT_WEIGHT), g_g(1D, 1D, EType.WEIGHT_WEIGHT),
		mg_kg(E3, 1D / E3, EType.WEIGHT_WEIGHT), g_kg(1D, 1D / E3, EType.WEIGHT_WEIGHT),
		g_mg(1D, E3, EType.WEIGHT_WEIGHT), µg_mg(E6, E3, EType.WEIGHT_WEIGHT),
		//
		µg_kg_bw(E6, 1D / E3, EType.WEIGHT_WEIGHT_BW), mg_g_bw(E3, 1D, EType.WEIGHT_WEIGHT_BW),
		g_g_bw(1D, 1D, EType.WEIGHT_WEIGHT_BW), mg_kg_bw(E3, 1D / E3, EType.WEIGHT_WEIGHT_BW),
		g_kg_bw(1D, 1D / E3, EType.WEIGHT_WEIGHT_BW), mg_mg_bw(E3, E3, EType.WEIGHT_WEIGHT_BW);

		final public double determinatorFactor;
		final public double numeratorFactor;
		final EType type;

		private EDosagesUnits(double numeratorFactor, double determinatorFactor, EType type) {
			this.numeratorFactor = numeratorFactor;
			this.determinatorFactor = determinatorFactor;
			this.type = type;
		}

		static enum EType implements IDoubleUnitType {
			ELSE("undef"), PERCENT("percentage"), WEIGHT("mg"), VOLUME("ml"), UNIT("iu"), MOL("mm"),
			//
			UNIT_WEIGHT("iu_g"), WEIGHT_WEIGHT("g_g"), WEIGHT_VOLUME("mg_ml"), VOLUME_TIME("ml_h"), WEIGHT_TIME("mg_h"),
			VOLUME_WEIGHT("ml_g"), UNIT_VOLUME("iu_ml"), VOLUME_VOLUME("µl_ml"), UNIT_WEIGHT_BW("iu_g_bw"),
			WEIGHT_WEIGHT_BW("g_g_bw"), VOLUME_WEIGHT_BW("ml_g_bw"), MOL_WEIGHT("µmol_kg"), MOL_VOLUME("mmol_l"),
			CFU_WEIGHT("cfu_ml"), UNIT_TIME("iu_day");

			final private String defaultUnitName;

			private EType(String defaultUnit) {
				this.defaultUnitName = defaultUnit;
			}

			public EDosagesUnits getDefaultUnit() {
				return EDosagesUnits.valueOf(defaultUnitName);
			}

		}

		@Override
		public IDoubleUnitType getType() {
			return type;
		}

		@Override
		public double getNumeratorFactor() {
			return numeratorFactor;
		}

		@Override
		public double getDeterminatorFactor() {
			return determinatorFactor;
		}

		@Override
		public String getName() {
			return this.name();
		}
	}

	public final EDosagesUnits unit;
	public final double meanValue;
	public final boolean unsure;
	final private static String connection = "\\s?(\\/|per|in|" + BAD_CHAR + ")\\s?";
	final private static String relationLessConnection = "(\\sof.{2,5})?";

	private static String bodyWeightGN = "ofBW";
	private static String digitsName1 = "digitsName1";
	private static String digitsName2 = "digitsName2";
	private static String unitName1 = "unitName1";
	private static String unitName2 = "unitName2";
	private static String unitName3 = "unitName3";
	private static String digitsName3 = "digitsName3";
	private static String unitPattern1 = "(" + BAD_CHAR + "|µ|m)?(u(nits?)?|g|%|l|cfu|mol|cm3|kg|i?( |\\.)?u\\.?)";
	private static String unitPattern2 = "(" + BAD_CHAR + "|µ|m)?(h(ours?)?|k?g|l|%|cm3|day)";
	private static String unitPattern3 = "(i?u|(µ|" + BAD_CHAR + ")l|ml|mm|l|%|cm3|(µ|" + BAD_CHAR + ")g|mg|g)";
	private static String dosagePatternName1 = "dosagePatternName1";
	private static String dosagePatternName2 = "dosagePatternName2";

	private static final String PATTERN_1 = "(?<" + dosagePatternName1 + ">(?<" + digitsName1 + ">" + digits
			+ ")(\\s?(?<" + unitName1 + ">" + unitPattern1 + ")" + relationLessConnection + connection + "((?<"
			+ digitsName2 + ">" + digits + ")\\s?)?(?<" + unitName2 + ">" + unitPattern2 + ")(?<" + bodyWeightGN
			+ ">(\\W|\\Wof\\W)?((body\\Wweight)|bw))?))";

	private static final String PATTERN_2 = "(?<" + dosagePatternName2 + ">(?<" + digitsName3 + ">" + digits
			+ ")(\\W?(?<" + unitName3 + ">" + unitPattern3 + ")))";

	public static final Pattern PATTERN = Pattern
			.compile(PRE_BOUNDS + "(" + PATTERN_1 + "|" + PATTERN_2 + ")" + POST_BOUNDS, PATTERN_BITMASK);

	public SemanticDosage(String surfaceForm, EDosagesUnits unit, double meanValue, boolean unsure) {
		super(surfaceForm);
		this.unit = unit;
		this.meanValue = meanValue;
		this.unsure = unsure;
	}

	public SemanticDosage convertTo(EDosagesUnits toUnit) {
		if (unit.type == toUnit.type) {
			return new SemanticDosage(surfaceForm, toUnit, convertValue(meanValue, toUnit), unsure);
		}
		System.err.println("Can not convert dosage from: " + unit + " to " + toUnit);
		return this;
	}

	private double convertValue(double value, EDosagesUnits toUnit) {
		return convertValue(value, unit, toUnit);
	}

	public SemanticDosage normalize() {

		if (unit.type != EType.ELSE) {
			return convertTo(unit.type.getDefaultUnit());
		}
		return this;
	}

	@Override
	public double getMeanValue() {
		return meanValue;
	}

	@Override
	public String toString() {
		return "SemanticDosage [surfaceForm=" + surfaceForm + ", unit=" + unit + ", meanValue=" + meanValue
				+ ", unsure=" + unsure + "]";
	}

	@Override
	public String asFormattedString() {
		return DECIMAL_FORMAT.format(meanValue) + " " + unit.name().replaceFirst("_", "/");
	}

	@Override
	public EDosagesUnits getUnit() {
		return unit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(meanValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + (unsure ? 1231 : 1237);
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
		SemanticDosage other = (SemanticDosage) obj;
		if (Double.doubleToLongBits(meanValue) != Double.doubleToLongBits(other.meanValue))
			return false;
		if (unit != other.unit)
			return false;
		if (unsure != other.unsure)
			return false;
		return true;
	}

	public static class Builder extends AbstractInterpreterBuilder {
		final public static EDosagesUnits defaultUnit = EDosagesUnits.undef;
		final public static float defaultMeanValue = 0;
		final public static float defaultFractionValue = 1;
		final public static boolean defaultUnsureValue = false;

		/*
		 * Test on http://regexr.com/
		 * 
		 * @formatter:off
		 * 
		 * \b((\d(\.?|,)\d{0,4})(\W?((([^\x20-\x7E]+|µ|m)?(u(nits)?|g|l|kg|i\W?u\.?)?)\W
		 * ?(\/|per|in|[^\x20-\x7E]+)\W?((\d(\.?|,)\d{0,4}\W?)?((\W|µ|m)?(h(our)?|kg|g|l
		 * |day))))))|((\d(\.?|,)\d{0,4})(\W?(IU)))\b
		 * 
		 * @formatter:on
		 * 
		 */
		private String surfaceForm;
		private EDosagesUnits unit = defaultUnit;
		private double meanValue = defaultMeanValue;
		private double fractionValue = defaultFractionValue;

		private boolean unsure = defaultUnsureValue;

		public EDosagesUnits getUnit() {
			return unit;
		}

		public Builder setUnit(EDosagesUnits unit) {
			this.unit = unit;
			return this;
		}

		public boolean isUnsure() {
			return unsure;
		}

		public Builder setUnsure(boolean unsure) {
			this.unsure = unsure;
			return this;
		}

		public double getMeanValue() {
			return meanValue;
		}

		public Builder setMeanValue(double meanValue) {
			this.meanValue = meanValue;
			return this;
		}

		public String getSurfaceForm() {
			return surfaceForm;
		}

		public Builder setSurfaceForm(String surfaceForm) {
			this.surfaceForm = surfaceForm;
			return this;
		}

		public SemanticDosage build() {
			meanValue = meanValue * (1 / fractionValue);
			return new SemanticDosage(surfaceForm, unit, meanValue, unsure);
		}

		public Builder interprete(final String surfaceForm) {
			Matcher matcher = SemanticDosage.PATTERN.matcher(surfaceForm);
			if (!matcher.find()) {
				return this;
			}

			return fromMatcher(matcher);
		}

		public Builder fromMatcher(final Matcher matcher) {
			try {
				surfaceForm = matcher.group();
				if (surfaceForm.matches(".*" + BAD_CHAR + ".*"))
					unsure = true;
				if (matcher.group(SemanticDosage.dosagePatternName1) != null) {
					if (matcher.group(SemanticDosage.digitsName1) != null)
						meanValue = Double.valueOf(toValue(matcher.group(SemanticDosage.digitsName1)));
					if (matcher.group(SemanticDosage.digitsName2) != null)
						fractionValue = Double.valueOf(toValue(matcher.group(SemanticDosage.digitsName2)));
					if (matcher.group(SemanticDosage.unitName1) != null
							&& matcher.group(SemanticDosage.unitName2) != null)
						unit = EDosagesUnits.valueOf(mapVariation(clean(
								matcher.group(SemanticDosage.unitName1) + "_" + matcher.group(SemanticDosage.unitName2)
										+ (matcher.group(SemanticDosage.bodyWeightGN) == null ? "" : "_bw"))));
				} else if (matcher.group(SemanticDosage.dosagePatternName2) != null) {
					if (matcher.group(SemanticDosage.unitName3) != null)
						unit = EDosagesUnits.valueOf(mapVariation(clean(matcher.group(SemanticDosage.unitName3))));
					if (matcher.group(SemanticDosage.digitsName3) != null)
						meanValue = Double.valueOf(toValue(matcher.group(SemanticDosage.digitsName3)));
				}
				return this;
			} catch (Exception e) {
				surfaceForm = null;
				System.err.println("Can not read " + matcher.group() + " from string: " + matcher.toString()
						+ ": Error message: " + e.getMessage());
				// throw new IllegalArgumentException("Can not read " +
				// matcher.group() + " from string: "
				// + matcher.toString() + ": Error message: " + e.getMessage());
			}
			return this;
		}

	}

	@Override
	public Pattern getPattern() {
		return PATTERN;
	}

}
