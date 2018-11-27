package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hterhors.obie.ml.dtinterpreter.AbstractInterpreterBuilder;
import de.hterhors.obie.ml.dtinterpreter.AbstractStringInterpreter;
import de.hterhors.obie.ml.dtinterpreter.IDatatypeInterpretation;

/**
 * TODO: Implement
 * 
 * @author hterhors
 *
 * @date Apr 12, 2018
 */
public class SemanticGroupName extends AbstractStringInterpreter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final static String pattern1GrouName = "pattern1GroupName";

	final static String freeSpace_ = "[^\\d\\w\\.,]";
	final static String freeSpaceQuestionMark_ = freeSpace_ + "?";

	/**
	 * n = 5
	 */
	final static String pattern1_ = "#####";

	public final static Pattern PATTERN = Pattern
			.compile("(?<" + pattern1GrouName + ">" + pattern1_ + ")" + POST_BOUNDS, PATTERN_BITMASK);

	private SemanticGroupName(String surfaceForm) {
		super(surfaceForm);
	}

	@Override
	public String asFormattedString() {
		return surfaceForm;
	}

	public static class Builder extends AbstractInterpreterBuilder {

		public String surfaceForm;

		public String getSurfaceForm() {
			return surfaceForm;
		}

		public Builder setSurfaceForm(String surfaceForm) {
			this.surfaceForm = surfaceForm;
			return this;
		}

		public SemanticGroupName build() {
			return new SemanticGroupName(surfaceForm);
		}

		public Builder interprete(final String surfaceForm) {
			/**
			 * TODO: Implement
			 */
			this.surfaceForm = surfaceForm;
			// Matcher matcher = SemanticGroupName.PATTERN.matcher(surfaceForm);
			// if (!matcher.find())
			return this;
			//
			// return fromMatcher(matcher);
		}

		public Builder fromMatcher(final Matcher matcher) {

			surfaceForm = matcher.group();

			return this;
		}
	}

	@Override
	public Pattern getPattern() {
		return PATTERN;
	}

	@Override
	public IDatatypeInterpretation normalize() {
		return this;
	}

	@Override
	public String toString() {
		return "SemanticGroupName [surfaceForm=" + surfaceForm + "]";
	}

}
