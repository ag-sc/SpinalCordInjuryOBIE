package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hterhors.obie.ml.dtinterpreter.AbstractInterpreterBuilder;
import de.hterhors.obie.ml.dtinterpreter.AbstractNumericInterpreter;
import de.hterhors.obie.ml.dtinterpreter.ISingleUnit;

public class SemanticPValue extends AbstractNumericInterpreter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static public enum ENNumberUnits implements ISingleUnit {

		undef;

		public static ENNumberUnits getDefault() {
			return undef;
		}

		@Override
		public double getFactor() {
			return 1;
		}

		@Override
		public String getName() {
			return this.name();
		}

	}

	final static String pattern1GrouName = "pattern1GrouName";

	final static String numbers_ = "((\\d+\\.\\d+)|\\d+)";
	final static String freeSpace_ = "[^\\d\\w\\.,]";
	final static String freeSpaceQuestionMark_ = freeSpace_ + "?";

	final private static String numGroup = "numGroup";

	private static String operatorGroup = "operatorGroup";

	/**
	 * n = 5
	 */
	final static String pattern1_ = "p" + freeSpace_ + "?(?<" + operatorGroup + ">" + BAD_CHAR + "|>|<)" + freeSpace_
			+ "?(?<" + numGroup + ">" + numbers_ + ")";

	public final static Pattern PATTERN = Pattern
			.compile("(?<" + pattern1GrouName + ">" + pattern1_ + ")" + POST_BOUNDS, PATTERN_BITMASK);

	final public double value;

	final public String comparitiveOperator;
	final public boolean unsure;

	private SemanticPValue(String surfaceForm, double value, String comparitiveOperator, boolean unsure) {
		super(surfaceForm);
		this.value = value;
		this.unsure = unsure;
		this.comparitiveOperator = comparitiveOperator;
	}

	public SemanticPValue normalize() {
		return this;
	}

	@Override
	public String asFormattedString() {
		return "p " + (unsure ? "?" : comparitiveOperator) + " " + value;
	}

	@Override
	public ISingleUnit getUnit() {
		return ENNumberUnits.undef;
	}

	@Override
	public double getMeanValue() {
		return value;
	}

	public static class Builder extends AbstractInterpreterBuilder {

		final public static int defaultValue = 0;
		final public static String defaultComparitiveOperator = null;
		final public static boolean defaultUnsure = false;

		/*
		 * Test on http://regexr.com/
		 * 
		 * @formatter:off
		 * @formatter:on
		 * 
		 */
		public String surfaceForm;
		public String comparitiveOperator = defaultComparitiveOperator;
		public boolean unsure = defaultUnsure;

		private double value = defaultValue;

		public String getSurfaceForm() {
			return surfaceForm;
		}

		public Builder setSurfaceForm(String surfaceForm) {
			this.surfaceForm = surfaceForm;
			return this;
		}

		public double getValue() {
			return value;
		}

		public Builder setValue(int fromValue) {
			this.value = fromValue;
			return this;
		}

		public String getComparitiveOperator() {
			return comparitiveOperator;
		}

		public Builder setComparitiveOperator(String comparitiveOperator) {
			this.comparitiveOperator = comparitiveOperator;
			return this;
		}

		public boolean isUnsure() {
			return unsure;
		}

		public Builder setUnsure(boolean unsure) {
			this.unsure = unsure;
			return this;
		}

		public SemanticPValue build() {
			return new SemanticPValue(surfaceForm, value, comparitiveOperator, unsure);
		}

		public Builder interprete(final String surfaceForm) {
			Matcher matcher = SemanticPValue.PATTERN.matcher(surfaceForm);
			if (!matcher.find())
				return this;

			return fromMatcher(matcher);
		}

		public Builder fromMatcher(final Matcher matcher) {

			surfaceForm = matcher.group();

			if (matcher.group(SemanticPValue.pattern1GrouName) != null) {
				if (matcher.group(SemanticPValue.numGroup) != null)
					value = Double.valueOf(matcher.group(SemanticPValue.numGroup));
				if (matcher.group(SemanticPValue.operatorGroup) != null)
					comparitiveOperator = matcher.group(SemanticPValue.operatorGroup);

				if (!(comparitiveOperator.equals("<") || comparitiveOperator.equals(">"))) {
					unsure = true;
				}

			}
			return this;
		}
	}

	@Override
	public Pattern getPattern() {
		return PATTERN;
	}

}
