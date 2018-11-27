package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno;

/**
 * A container-Object that holds information about the sentence number of the
 * overall document and the token number of the sentence it appears in.
 * 
 * @author hterhors
 *
 *         Jul 14, 2016
 */
public class WebAnno3TokenOfSentence {

	/**
	 * The number of the sentence in the document.
	 */
	final int sentenceNumber;

	/**
	 * The number of the token in the sentence.
	 */
	final int tokenNumber;

	/**
	 * Creates a new Container to bind a token to a sentence.
	 * 
	 * @param sentenceNumber
	 *            The number of the sentence in the document.
	 * @param tokenNumber
	 *            The number of the token in the sentence.
	 */
	public WebAnno3TokenOfSentence(int sentenceNumber, int tokenNumber) {
		super();
		this.sentenceNumber = sentenceNumber;
		this.tokenNumber = tokenNumber;
	}

	@Override
	public String toString() {
		return "WebAnno3TokenOfSentence [sentenceNumber=" + sentenceNumber + ", tokenNumber=" + tokenNumber + "]";
	}

}
