package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hterhors.obie.ml.dtinterpreter.AbstractInterpreterBuilder;
import de.hterhors.obie.ml.dtinterpreter.AbstractNumericInterpreter;
import de.hterhors.obie.ml.dtinterpreter.ISingleUnit;

public class SemanticStandardError extends AbstractNumericInterpreter {
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

	/**
	 * +- 0.55
	 */
	final static String pattern1_ = "(" + BAD_CHAR + "|(\\+?-)|\\+(/|\\\\)-|±)" + freeSpace_ + "?(?<" + numGroup + ">"
			+ numbers_ + ")";

	public final static Pattern PATTERN = Pattern
			.compile("(?<" + pattern1GrouName + ">" + pattern1_ + ")" + POST_BOUNDS, PATTERN_BITMASK);

	final public double value;

	private SemanticStandardError(String surfaceForm, double value) {
		super(surfaceForm);
		this.value = value;
	}

	public SemanticStandardError normalize() {
		return this;
	}

	@Override
	public String asFormattedString() {
		return String.valueOf(value);
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

		/*
		 * Test on http://regexr.com/
		 * 
		 * @formatter:off
		 * @formatter:on
		 * 
		 */
		public String surfaceForm;
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

		public SemanticStandardError build() {
			return new SemanticStandardError(surfaceForm, value);
		}

		public Builder interprete(final String surfaceForm) {
			Matcher matcher = SemanticStandardError.PATTERN.matcher(surfaceForm);
			if (!matcher.find())
				return this;

			return fromMatcher(matcher);
		}

		public Builder fromMatcher(final Matcher matcher) {

			surfaceForm = matcher.group();

			if (matcher.group(SemanticStandardError.pattern1GrouName) != null) {
				if (matcher.group(SemanticStandardError.numGroup) != null)
					value = Double.valueOf(matcher.group(SemanticStandardError.numGroup));
			}
			return this;
		}
	}

	@Override
	public Pattern getPattern() {
		return PATTERN;
	}

}
