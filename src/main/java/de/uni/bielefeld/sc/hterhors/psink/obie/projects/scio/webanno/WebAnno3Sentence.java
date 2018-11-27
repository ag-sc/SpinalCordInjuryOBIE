package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno;

import java.util.ArrayList;
import java.util.List;

/**
 * A WebAnno3Sentence contains a list of WebAnno3Tokens that appear in the
 * sentence.
 * 
 * @author hterhors
 *
 *         Jul 14, 2016
 */
public class WebAnno3Sentence {

	/**
	 * A List of WebAnno3Tokens that are contained in this Sentence.
	 */
	final public List<WebAnno3Token> tokens = new ArrayList<>();

	public WebAnno3Sentence() {
	}

	public List<WebAnno3Token> getTokens() {
		return tokens;
	}

	public void addToken(WebAnno3Token token) {
		tokens.add(token);
	}

	@Override
	public String toString() {
		return "WebAnno3Sentence [tokens=" + tokens + "]";
	}

}
