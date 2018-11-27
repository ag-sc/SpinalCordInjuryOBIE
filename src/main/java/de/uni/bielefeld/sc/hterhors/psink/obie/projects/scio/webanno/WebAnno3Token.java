package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno;

import java.util.HashSet;
import java.util.Set;

/**
 * A container Object that holds information about a token in WebAnno3-format. A
 * token contains information about its value, its position in the
 * document/sentence and all information about its annotation.
 * 
 * @author hterhors
 *
 *         Jul 14, 2016
 */
public class WebAnno3Token {

	/**
	 * The value of the token.
	 */
	final public String tokenValue;

	/**
	 * The onset of the token.
	 */
	final public int onset;
	/**
	 * The offset of the token in the overall document.
	 */
	final public int offset;

	/**
	 * The identifier of the token within a sentence. E.g. the third token of
	 * the second sentence.
	 */
	final public WebAnno3TokenOfSentence tokenID;

	/**
	 * A Set of annotations that belongs to the token(s).
	 * 
	 * @see WebAnno3Token#type1SurfaceForms
	 */
	final public Set<Annotation> drrs = new HashSet<>();

	/**
	 * Creates a new token.
	 * 
	 * @param tokenValue
	 *            The value of the token.
	 * @param offset
	 *            The offset of the token in the overall document.
	 * @param length
	 *            The length of the token. This is equal to the length of
	 *            tokenValue.
	 * @param annotationIDThe
	 *            number (id) of the annotation in the overall document. If two
	 *            or more tokens share the same annotationNumber then those
	 *            tokens belong to the same annotation.
	 * @param tokenID
	 *            The identifier of the token within a sentence. E.g. the third
	 *            token of the second sentence.
	 *
	 */
	public WebAnno3Token(String tokenValue, int onset, int offset, WebAnno3TokenOfSentence tokenID) {
		this.tokenValue = tokenValue;
		this.onset = onset;
		this.offset = offset;
		this.tokenID = tokenID;
	}

	@Override
	public String toString() {
		return "WebAnno3Token [tokenValue=" + tokenValue + ", onset=" + onset + ", offset=" + offset + ", tokenID="
				+ tokenID + ", drrs=" + drrs + "]";
	}

}
