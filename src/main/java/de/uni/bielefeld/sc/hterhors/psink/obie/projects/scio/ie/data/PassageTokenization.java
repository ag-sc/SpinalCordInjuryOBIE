package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.data;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.tokenizer.Tokenization;

public class PassageTokenization {

	private static Logger log = LogManager.getFormatterLogger(PassageTokenization.class.getName());

	public List<Tokenization> tokens;
	public String originalPassage;
	public int absoluteStartOffset;
	public int absoluteEndOffset;

	public PassageTokenization(List<Tokenization> tokens, String originalPassage, int absoluteStartOffset) {
		this.tokens = tokens;
		this.originalPassage = originalPassage;
		this.absoluteStartOffset = absoluteStartOffset;
		this.absoluteEndOffset = absoluteStartOffset + originalPassage.length();
	}

	@Override
	public String toString() {
		return "Tokenization [" + absoluteStartOffset + "-" + absoluteEndOffset + ": " + originalPassage + "\n\t"
				+ tokens + "]";
	}

}
