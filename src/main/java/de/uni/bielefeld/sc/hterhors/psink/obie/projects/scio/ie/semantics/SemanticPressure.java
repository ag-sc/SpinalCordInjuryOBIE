package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hterhors.obie.ml.dtinterpreter.AbstractInterpreterBuilder;
import de.hterhors.obie.ml.dtinterpreter.AbstractNumericInterpreter;
import de.hterhors.obie.ml.dtinterpreter.IDatatypeInterpretation;
import de.hterhors.obie.ml.dtinterpreter.IDoubleUnit;
import de.hterhors.obie.ml.dtinterpreter.IDoubleUnitType;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticPressure.EPressureUnits.EType;

public class SemanticPressure extends AbstractNumericInterpreter implements IDatatypeInterpretation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static public enum EPressureUnits implements IDoubleUnit {

		undef(0, 0, EType.ELSE),
		//
		µl_min(1000d, 1d, EType.VOLUME_TIME), ml_min(1d, 1d, EType.VOLUME_TIME), l_min(1d / 1000d, 1d,
				EType.VOLUME_TIME),
		//
		bar(1d, 1d, EType.PRESSURE);

		final public double determinatorFactor;
		final public double numeratorFactor;
		final EType type;

		private EPressureUnits(double numeratorFactor, double determinatorFactor, EType type) {
			this.numeratorFactor = numeratorFactor;
			this.determinatorFactor = determinatorFactor;
			this.type = type;
		}

		static enum EType implements IDoubleUnitType {

			ELSE("undef"), VOLUME_TIME("ml_min"), PRESSURE("bar");

			final private String defaultUnit;

			private EType(String defaultUnit) {
				this.defaultUnit = defaultUnit;
			}

			public EPressureUnits getDefaultUnit() {
				return EPressureUnits.valueOf(defaultUnit);
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

	public final EPressureUnits unit;
	public final double meanValue;
	public final boolean unsure;
	final private static String writtenNumbers = PRE_BOUNDS
			+ "(one|two|three|four|five|six|seven|eight|nine|ten|eleven|twelve|thirteen|forteen|fifteen)";
	final private static String digits = "\\d{1,3}(\\.?|,)\\d{0,4}";
	final private static String connection = "\\s?(\\/|per|in|times|x|" + BAD_CHAR + ")\\s?";
	final private static String relationLessConnection = "(\\sof.{2,5})?";

	private static String digitsName1 = "digitsName1";
	private static String digitsName2 = "digitsName2";
	private static String unitName1 = "unitName1";
	private static String unitName2 = "unitName2";
	private static String unitName3 = "unitName3";
	private static String digitsName3 = "digitsName3";
	private static String unitPattern1 = "(" + BAD_CHAR + "|µ|m)?(l\\.?))";
	private static String unitPattern2 = "(min)";
	private static String unitPattern3 = "(bars?)";
	private static String dosagePatternName1 = "dosagePatternName1";
	private static String dosagePatternName2 = "dosagePatternName2";

	private static final String PATTERN_1 = "(?<" + dosagePatternName1 + ">(?<" + digitsName1 + ">" + digits
			+ ")(\\s?(?<" + unitName1 + ">" + unitPattern1 + ")" + relationLessConnection + connection + "((?<"
			+ digitsName2 + ">" + digits + ")\\s?)?(?<" + unitName2 + ">" + unitPattern2 + "))";

	private static final String PATTERN_2 = "(?<" + dosagePatternName2 + ">(?<" + digitsName3 + ">" + digits
			+ ")(\\W?(?<" + unitName3 + ">" + unitPattern3 + ")))";

	public static final Pattern PATTERN = Pattern
			.compile(PRE_BOUNDS + "(" + PATTERN_1 + "|" + PATTERN_2 + ")" + POST_BOUNDS, PATTERN_BITMASK);

	public SemanticPressure(String surfaceForm, EPressureUnits unit, double meanValue, boolean unsure) {
		super(surfaceForm);
		this.unit = unit;
		this.meanValue = meanValue;
		this.unsure = unsure;
	}

	public SemanticPressure convertTo(EPressureUnits toUnit) {
		if (unit.type == toUnit.type) {
			return new SemanticPressure(surfaceForm, toUnit, convertValue(meanValue, toUnit), unsure);
		}
		System.err.println("Can not convert dosage from: " + unit + " to " + toUnit);
		return this;
	}

	private double convertValue(double value, EPressureUnits toUnit) {
		return convertValue(value, unit, toUnit);
	}

	public static double convertValue(double value, EPressureUnits fromUnit, EPressureUnits toUnit) {
		if (fromUnit.type == toUnit.type)
			return value * (toUnit.numeratorFactor / fromUnit.numeratorFactor)
					* (fromUnit.determinatorFactor / toUnit.determinatorFactor);
		else
			throw new IllegalArgumentException("Can not convert " + fromUnit.type + " to " + toUnit.type);
	}

	public SemanticPressure normalize() {

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
		return "SemanticPressure [surfaceForm=" + surfaceForm + ", unit=" + unit + ", meanValue=" + meanValue
				+ ", unsure=" + unsure + "]";
	}

	@Override
	public String asFormattedString() {
		return DECIMAL_FORMAT.format(meanValue) + " " + unit.name().replaceFirst("_", "/");
	}

	@Override
	public EPressureUnits getUnit() {
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
		SemanticPressure other = (SemanticPressure) obj;
		if (Double.doubleToLongBits(meanValue) != Double.doubleToLongBits(other.meanValue))
			return false;
		if (unit != other.unit)
			return false;
		if (unsure != other.unsure)
			return false;
		return true;
	}

	public static class Builder extends AbstractInterpreterBuilder {
		final public static EPressureUnits defaultUnit = EPressureUnits.undef;
		final public static float defaultMeanValue = 0;
		final public static float defaultFractionValue = 1;
		final public static boolean defaultUnsureValue = false;

		/*
		 * Test on http://regexr.com/
		 * 
		 * @formatter:off
		 * 
		 * 
		 * @formatter:on
		 * 
		 */
		private String surfaceForm;
		private EPressureUnits unit = defaultUnit;
		private double meanValue = defaultMeanValue;
		private double fractionValue = defaultFractionValue;

		private boolean unsure = defaultUnsureValue;

		public EPressureUnits getUnit() {
			return unit;
		}

		public Builder setUnit(EPressureUnits unit) {
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

		public SemanticPressure build() {
			meanValue = meanValue * (1 / fractionValue);
			return new SemanticPressure(surfaceForm, unit, meanValue, unsure);
		}

		public Builder interprete(final String surfaceForm) {

			Matcher matcher = SemanticPressure.PATTERN.matcher(surfaceForm);
			if (!matcher.find())
				return this;

			return fromMatcher(matcher);
		}

		public Builder fromMatcher(final Matcher matcher) {
			try {
				surfaceForm = matcher.group();
				if (surfaceForm.matches(".*" + BAD_CHAR + ".*"))
					unsure = true;
				if (matcher.group(SemanticPressure.dosagePatternName1) != null) {
					if (matcher.group(SemanticPressure.digitsName1) != null)
						meanValue = Double.valueOf(toValue(matcher.group(SemanticPressure.digitsName1)));
					if (matcher.group(SemanticPressure.digitsName2) != null)
						fractionValue = Double.valueOf(toValue(matcher.group(SemanticPressure.digitsName2)));
					if (matcher.group(SemanticPressure.unitName1) != null
							&& matcher.group(SemanticPressure.unitName2) != null)
						unit = EPressureUnits.valueOf(clean(mapVariation(matcher.group(SemanticPressure.unitName1) + "_"
								+ matcher.group(SemanticPressure.unitName2))));
				} else if (matcher.group(SemanticPressure.dosagePatternName2) != null) {
					if (matcher.group(SemanticPressure.unitName3) != null)
						unit = EPressureUnits.valueOf(clean(mapVariation(matcher.group(SemanticPressure.unitName3))));
					if (matcher.group(SemanticPressure.digitsName3) != null)
						meanValue = Double.valueOf(toValue(matcher.group(SemanticPressure.digitsName3)));
				}
				return this;
			} catch (Exception e) {
				throw new IllegalArgumentException("Can not read dosage from string: " + matcher.toString()
						+ ": Error message: " + e.getMessage());
			}
		}

	}

	@Override
	public Pattern getPattern() {
		return PATTERN;
	}

}
