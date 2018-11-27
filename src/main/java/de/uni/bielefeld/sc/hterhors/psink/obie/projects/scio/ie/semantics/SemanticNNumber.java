package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hterhors.obie.ml.dtinterpreter.AbstractInterpreterBuilder;
import de.hterhors.obie.ml.dtinterpreter.AbstractNumericInterpreter;
import de.hterhors.obie.ml.dtinterpreter.ISingleUnit;

public class SemanticNNumber extends AbstractNumericInterpreter {
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

	final static String pattern1GroupName = "pattern1GroupName";
	final static String pattern2GroupName = "pattern2GroupName";

	final static String freeSpace_ = "[^\\d\\w\\.,]";
	final static String freeSpaceQuestionMark_ = freeSpace_ + "?";

	/**
	 * These are units like rats, animals, etc...
	 */
	final static String fakeUnits = "("+freeSpaceQuestionMark_+"(mice|rats?|animals?))";

	final private static String numGroup1 = "numGroup1";
	final private static String numGroup2 = "numGroup2";

	final private static String writtenNumGroup1 = "writtenNumGroup1";
	final private static String writtenNumGroup2 = "writtenNumGroup2";

	final static String numbers1_ = "((?<" + numGroup1 + ">\\d+)|(?<" + writtenNumGroup1 + ">" + writtenNumbers + "))";
	final static String numbers2_ = "((?<" + numGroup2 + ">\\d+)|(?<" + writtenNumGroup2 + ">" + writtenNumbers + "))";

	/**
	 * n = 5
	 */
	final static String pattern1_ = "n" + freeSpaceQuestionMark_ + "(" + BAD_CHAR + "|=)" + freeSpaceQuestionMark_
			+ numbers1_;

	/**
	 * 18 rats
	 */
	final static String pattern2_ = numbers2_ + fakeUnits;

	public final static Pattern PATTERN = Pattern.compile(PRE_BOUNDS + "(?<" + pattern1GroupName + ">" + pattern1_
			+ ")|" + "(?<" + pattern2GroupName + ">" + pattern2_ + ")" + POST_BOUNDS, PATTERN_BITMASK);

	final public int value;

	private SemanticNNumber(String surfaceForm, int value) {
		super(surfaceForm);
		this.value = value;
	}

	public SemanticNNumber normalize() {
		return this;
	}

	@Override
	public String asFormattedString() {
		return "n = " + value;
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
		 * (n[^\d\w\.,]?([^\x20-\x7E]+|=)[^\d\w\.,]?((\d+)))|(((\d+))[^\d\w\.,]?(rats?|animals?)?)(\b|(?= ))
		 * @formatter:on
		 * 
		 */
		public String surfaceForm;
		private int value = defaultValue;

		public String getSurfaceForm() {
			return surfaceForm;
		}

		public Builder setSurfaceForm(String surfaceForm) {
			this.surfaceForm = surfaceForm;
			return this;
		}

		public int getValue() {
			return value;
		}

		public Builder setValue(int value) {
			this.value = value;
			return this;
		}

		public SemanticNNumber build() {
			return new SemanticNNumber(surfaceForm, value);
		}

		public Builder interprete(final String surfaceForm) {
			Matcher matcher = SemanticNNumber.PATTERN.matcher(surfaceForm);
			if (!matcher.find())
				return this;

			return fromMatcher(matcher);
		}

		public Builder fromMatcher(final Matcher matcher) {

			surfaceForm = matcher.group();
			if (matcher.group(SemanticNNumber.pattern1GroupName) != null) {
				if (matcher.group(SemanticNNumber.numGroup1) != null)
					value = Integer.parseInt(matcher.group(SemanticNNumber.numGroup1));
				else if (matcher.group(SemanticNNumber.writtenNumGroup1) != null)
					value = (int) mapWrittenNumbertoInt(matcher.group(SemanticNNumber.writtenNumGroup1));
			}
			if (matcher.group(SemanticNNumber.pattern2GroupName) != null) {
				if (matcher.group(SemanticNNumber.numGroup2) != null)
					value = Integer.parseInt(matcher.group(SemanticNNumber.numGroup2));
				else if (matcher.group(SemanticNNumber.writtenNumGroup2) != null)
					value = (int) mapWrittenNumbertoInt(matcher.group(SemanticNNumber.writtenNumGroup2));

			}
			return this;
		}

		@Override
		public String toString() {
			return "Builder [surfaceForm=" + surfaceForm + ", value=" + value + "]";
		}

	}

	@Override
	public String toString() {
		return "SemanticNNumber [value=" + value + "]";
	}

	@Override
	public Pattern getPattern() {
		return PATTERN;
	}

}
