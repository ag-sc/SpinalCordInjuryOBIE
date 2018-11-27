package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebAnno3TSVDocument {

	/**
	 * A list of WebAnno3Sentences that each holds a list of Webanno3Tokens.
	 */
	final public List<WebAnno3Sentence> sentences = new ArrayList<>();

	/**
	 * A map containing all discontinuous annotations. each key value pair
	 * represents one discont. annotations. Key and Value are annotationIDs.
	 * 
	 * Key is toID (the later id) and Value is fromID;
	 */
	final public Map<Integer, Integer> disconts = new HashMap<>();

	/**
	 * A set of comments extracted from the document.
	 */
	final public List<String> comments = new ArrayList<>();

	public WebAnno3TSVDocument() {
	}

	public List<WebAnno3Sentence> getSentences() {
		return sentences;
	}

	public void addSentence(WebAnno3Sentence sentence) {
		sentences.add(sentence);
	}

	@Override
	public String toString() {
		return "WebAnno3TSVDocument [sentences=" + sentences + "]";
	}

	public void addComment(String comment) {
		comments.add(comment);
	}

	public void putDiscont(int toID, int fromID) {
		Integer prevValue = null;
		if ((prevValue = disconts.put(toID, fromID)) != null) {
			System.err
					.println("Double entry for discontinuous annotation found: " + fromID + " for value: " + prevValue);
		}
	}

}
