package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hterhors.obie.ml.dtinterpreter.AbstractInterpreterBuilder;
import de.hterhors.obie.ml.dtinterpreter.AbstractNumericInterpreter;
import de.hterhors.obie.ml.dtinterpreter.IDoubleUnit;
import de.hterhors.obie.ml.dtinterpreter.IDoubleUnitType;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SemanticForce.EForceUnits.EType;

public class SemanticForce extends AbstractNumericInterpreter   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static public enum EForceUnits implements IDoubleUnit {

		undef(0, 0, EType.ELSE),
		//
		g_mm(1d, 10d, EType.WEIGHT_LENGTH), g_cm(1d, 1d, EType.WEIGHT_LENGTH),
		//
		dyn(1E5d, 1d, EType.NEWTON), kdyn(1E2d, 1d, EType.NEWTON), n(1d, 1d, EType.NEWTON);

		final public double determinatorFactor;
		final public double numeratorFactor;
		final EType type;

		private EForceUnits(double numeratorFactor, double determinatorFactor, EType type) {
			this.numeratorFactor = numeratorFactor;
			this.determinatorFactor = determinatorFactor;
			this.type = type;
		}

		static enum EType implements IDoubleUnitType {

			ELSE("undef"), WEIGHT_LENGTH("g_cm"), NEWTON("n");

			final private String defaultUnit;

			private EType(String defaultUnit) {
				this.defaultUnit = defaultUnit;
			}

			public EForceUnits getDefaultUnit() {
				return EForceUnits.valueOf(defaultUnit);
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

	public final EForceUnits unit;
	public final double meanValue;
	public final boolean unsure;
	final public double fromValue;
	final public double toValue;

	
	private static String digitsName1 = "digitsName1";
	private static String digitsName2 = "digitsName2";
	private static String unitName1 = "unitName1";
	private static String unitName2 = "unitName2";
	private static String unitName3 = "unitName3";
	private static String digitsName3 = "digitsName3";
	private static String unitPattern1 = "(" + BAD_CHAR + "|µ)?(g\\.?)";
	private static String unitPattern2 = "(" + BAD_CHAR + "m|mm|cm|µm)";
	private static String unitPattern3 = "(N|k?dyne?s?)";
	private static String forcePatternName1 = "forcePatternName1";
	private static String forcePatternName2 = "forcePatternName2";

	final static String pattern3GrouName = "pattern3GrouName";
	final static String pattern4GrouName = "pattern4GrouName";
	final static String pattern5GrouName = "pattern5GrouName";

	final private static String p1Numbers1 = "p1Numbers1";
	final private static String p1Numbers2 = "p1Numbers2";
	final private static String p1Unit1 = "p1Unit1";
	final private static String p1Unit2 = "p1Unit2";

	final private static String p2Numbers1 = "p2Numbers1";
	final private static String p2Numbers2 = "p2Numbers2";
	final private static String p2Unit1 = "p2Unit1";

	final private static String p3Numbers1 = "p3Numbers1";
	final private static String p3Unit1 = "p3Unit1";


	private static final String PATTERN_1 = "(?<" + forcePatternName1 + ">(?<" + digitsName1 + ">" + digits
			+ ")(\\s?(?<" + unitName1 + ">" + unitPattern1 + ")" + relationLessConnection + connection + "((?<"
			+ digitsName2 + ">" + digits + ")\\s?)?(?<" + unitName2 + ">" + unitPattern2 + ")))";

	private static final String PATTERN_2 = "(?<" + forcePatternName2 + ">(?<" + digitsName3 + ">" + digits
			+ ")(\\W?(?<" + unitName3 + ">" + unitPattern3 + ")))";

	/**
	 * 100g - 300 g
	 */
	private final static String PATTERN_3 = "(?<" + pattern3GrouName + ">(?<" + p1Numbers1 + ">" + digits + ")"
			+ freeSpaceQuestionMark_ + "(?<" + p1Unit1 + ">" + unitPattern3 + ")" + connection_ + "(?<" + p1Numbers2
			+ ">" + digits + ")" + freeSpaceQuestionMark_ + "(?<" + p1Unit2 + ">" + unitPattern3 + ")?)";

	/**
	 * 100 - 300g
	 */
	private final static String PATTERN_4 = "(?<" + pattern4GrouName + ">(?<" + p2Numbers1 + ">" + digits + ")"
			+ connection_ + "(?<" + p2Numbers2 + ">" + digits + ")" + freeSpaceQuestionMark_ + "(?<" + p2Unit1 + ">"
			+ unitPattern3 + "))";

	/**
	 * 100g +- 300
	 */
	private final static String PATTERN_5 = "(?<" + pattern5GrouName + ">(?<" + p3Numbers1 + ">" + digits + ")"
			+ freeSpaceQuestionMark_ + "(?<" + p3Unit1 + ">" + p1Unit2 + "))";

	public static final Pattern PATTERN = Pattern.compile(PRE_BOUNDS + "(" + PATTERN_1 + "|" + PATTERN_3 + "|"
			+ PATTERN_4 + "|" + PATTERN_5 + "|" + PATTERN_2 + ")" + POST_BOUNDS, PATTERN_BITMASK);

	public SemanticForce(String surfaceForm, EForceUnits unit, double meanValue, boolean unsure, double fromValue,
			double toValue) {
		super(surfaceForm);
		this.unit = unit;
		this.meanValue = meanValue;
		this.unsure = unsure;
		this.fromValue = fromValue;
		this.toValue = toValue;
	}

	public SemanticForce convertTo(EForceUnits toUnit) {
		if (unit.type == toUnit.type) {
			return new SemanticForce(surfaceForm, toUnit, convertValue(meanValue, toUnit), unsure,
					convertValue(fromValue, toUnit), convertValue(toValue, toUnit));
		}
		System.err.println("Can not convert force from: " + unit + " to " + toUnit);
		return this;
	}

	private double convertValue(double value, EForceUnits toUnit) {
		return convertValue(value, unit, toUnit);
	}

	public static double convertValue(double value, EForceUnits fromUnit, EForceUnits toUnit) {
		if (fromUnit.type == toUnit.type)
			return value * (toUnit.numeratorFactor / fromUnit.numeratorFactor)
					* (fromUnit.determinatorFactor / toUnit.determinatorFactor);
		else
			throw new IllegalArgumentException("Can not convert " + fromUnit.type + " to " + toUnit.type);
	}

	public SemanticForce normalize() {

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
	public EForceUnits getUnit() {
		return unit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fromValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(meanValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(toValue);
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
		SemanticForce other = (SemanticForce) obj;
		if (Double.doubleToLongBits(fromValue) != Double.doubleToLongBits(other.fromValue))
			return false;
		if (Double.doubleToLongBits(meanValue) != Double.doubleToLongBits(other.meanValue))
			return false;
		if (Double.doubleToLongBits(toValue) != Double.doubleToLongBits(other.toValue))
			return false;
		if (unit != other.unit)
			return false;
		if (unsure != other.unsure)
			return false;
		return true;
	}

	public static class Builder extends AbstractInterpreterBuilder {
		final public static EForceUnits defaultUnit = EForceUnits.undef;
		final public static float defaultMeanValue = 0;
		final public static float defaultVarianceValue = 0;
		final public static float defaultFromValue = 0;
		final public static float defaultFractionValue = 1;
		final public static boolean defaultUnsureValue = false;
		final public static float defaultToValue = 0;

		/*
		 * Test on http://regexr.com/
		 * 
		 * @formatter:off
		 * 
((\d{1,3}(\.?|,)\d{0,4})(\s?(([^\x20-\x7E]+|µ)?(g\.?))(\sof.{2,5})?\s?(times|per|x|-|[^\x20-\x7E]+)\s?((\d{1,3}(\.?|,)\d{0,4})\s?)?(([^\x20-\x7E]+m|mm|cm|µm))))|((\d{1,3}(\.?|,)\d{0,4})[^\d\w\.,]?((N|k?dyns?))([^\d\w\.,](to|and)[^\d\w\.,]|[^\d\w\.,]?((\+?-)|\+(/|\\)-|±|[^\d\w\.,])[^\d\w\.,]?)(\d{1,3}(\.?|,)\d{0,4})[^\d\w\.,]?((N|k?dyns?))?)|((\d{1,3}(\.?|,)\d{0,4})([^\d\w\.,](to|and)[^\d\w\.,]|[^\d\w\.,]?((\+?-)|\+(/|\\)-|±|[^\d\w\.,])[^\d\w\.,]?)(\d{1,3}(\.?|,)\d{0,4})[^\d\w\.,]?((N|k?dyns?)))|((\d{1,3}(\.?|,)\d{0,4})[^\d\w\.,]?(p1Unit2))|((\d{1,3}(\.?|,)\d{0,4})(\W?((N|k?dyns?)))))
		 * 
		 * @formatter:on
		 * 
		 */
		private String surfaceForm;
		private EForceUnits unit = defaultUnit;
		private double meanValue = defaultMeanValue;
		private double fractionValue = defaultFractionValue;

		private double fromValue = defaultFromValue;
		private double varianceValue = defaultVarianceValue;
		private double toValue = defaultToValue;

		private boolean unsure = defaultUnsureValue;

		public EForceUnits getUnit() {
			return unit;
		}

		public Builder setUnit(EForceUnits unit) {
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

		public double getFromValue() {
			return fromValue;
		}

		public Builder setFromValue(float fromValue) {
			this.fromValue = fromValue;
			return this;
		}

		public double getVarianceValue() {
			return varianceValue;
		}

		public Builder setVarianceValue(float varianceValue) {
			this.varianceValue = varianceValue;
			return this;
		}

		public double getToValue() {
			return toValue;
		}

		public Builder setToValue(float toValue) {
			this.toValue = toValue;
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

		public SemanticForce build() {
			if (meanValue != defaultMeanValue) {
				meanValue = meanValue * (1 / fractionValue);
			} else {
				meanValue = meanValue == defaultMeanValue ? (fromValue + toValue) / 2 : meanValue;
				fromValue = fromValue == defaultFromValue ? (meanValue - varianceValue) : fromValue;
				toValue = toValue == defaultToValue ? (meanValue + varianceValue) : toValue;
			}

			return new SemanticForce(surfaceForm, unit, meanValue, unsure, fromValue, toValue);
		}

		public Builder interprete(final String surfaceForm) {

			Matcher matcher = SemanticForce.PATTERN.matcher(surfaceForm);
			if (!matcher.find())
				return this;

			return fromMatcher(matcher);
		}

		public Builder fromMatcher(final Matcher matcher) {
			try {
				surfaceForm = matcher.group();
				if (surfaceForm.matches(".*" + BAD_CHAR + ".*"))
					unsure = true;
				if (matcher.group(SemanticForce.forcePatternName1) != null) {
					if (matcher.group(SemanticForce.digitsName1) != null)
						meanValue = Double.valueOf(toValue(matcher.group(SemanticForce.digitsName1)));
					if (matcher.group(SemanticForce.digitsName2) != null)
						fractionValue = Double.valueOf(toValue(matcher.group(SemanticForce.digitsName2)));
					if (matcher.group(SemanticForce.unitName1) != null
							&& matcher.group(SemanticForce.unitName2) != null)
						unit = EForceUnits.valueOf(clean(mapVariation(matcher.group(SemanticForce.unitName1) + "_"
								+ matcher.group(SemanticForce.unitName2))));
				} else if (matcher.group(SemanticForce.forcePatternName2) != null) {
					if (matcher.group(SemanticForce.unitName3) != null)
						unit = EForceUnits.valueOf(clean(mapVariation(matcher.group(SemanticForce.unitName3))));
					if (matcher.group(SemanticForce.digitsName3) != null)
						meanValue = Double.valueOf(toValue(matcher.group(SemanticForce.digitsName3)));
				} else if (matcher.group(SemanticForce.pattern3GrouName) != null) {
					double fromValue_ = defaultFromValue;
					if (matcher.group(SemanticForce.p1Unit1) != null)
						unit = EForceUnits.valueOf(mapVariation(matcher.group(SemanticForce.p1Unit1).toLowerCase()));
					if (matcher.group(SemanticForce.p1Numbers1) != null)
						fromValue_ = Double.valueOf(matcher.group(SemanticForce.p1Numbers1));
					if (matcher.group(SemanticForce.p1Numbers2) != null) {
						EForceUnits unit_;
						if (matcher.group(SemanticForce.p1Unit2) != null) {
							unit_ = EForceUnits
									.valueOf(mapVariation(matcher.group(SemanticForce.p1Unit2).toLowerCase()));
						} else {
							unit_ = unit;
						}
						double toValue_ = SemanticForce
								.convertValue(Double.valueOf(matcher.group(SemanticForce.p1Numbers2)), unit_, unit);

						/*
						 * Since there are only positive weights we either set
						 * the variance and mean or from to values.
						 */
						if (toValue_ > fromValue_) {
							toValue = toValue_;
							fromValue = fromValue_;
						} else {
							varianceValue = toValue_;
							meanValue = fromValue_;
						}
					}
				} else if (matcher.group(SemanticForce.pattern4GrouName) != null) {
					double fromValue_ = defaultFromValue;
					if (matcher.group(SemanticForce.p2Unit1) != null)
						unit = EForceUnits.valueOf(mapVariation(matcher.group(SemanticForce.p2Unit1).toLowerCase()));
					if (matcher.group(SemanticForce.p2Numbers1) != null)
						fromValue_ = Double.valueOf(matcher.group(SemanticForce.p2Numbers1));
					if (matcher.group(SemanticForce.p2Numbers2) != null) {
						double toValue_ = Double.valueOf(matcher.group(SemanticForce.p2Numbers2));
						/*
						 * Since there are only positive weights we either set
						 * the variance and mean or from to values.
						 */
						if (toValue_ > fromValue_) {
							toValue = toValue_;
							fromValue = fromValue_;
						} else {
							varianceValue = toValue_;
							meanValue = fromValue_;
						}
					}
				} else if (matcher.group(SemanticForce.pattern5GrouName) != null) {
					if (matcher.group(SemanticForce.p3Unit1) != null)
						unit = EForceUnits.valueOf(mapVariation(matcher.group(SemanticForce.p3Unit1).toLowerCase()));
					if (matcher.group(SemanticForce.p3Numbers1) != null)
						meanValue = Double.valueOf(matcher.group(SemanticForce.p3Numbers1));
				}

				return this;
			} catch (Exception e) {
				throw new IllegalArgumentException(
						"Can not interprete: " + matcher.toString() + ": Error message: " + e.getMessage());
			}
		}

	}

	@Override
	public Pattern getPattern() {
		return PATTERN;
	}

}
