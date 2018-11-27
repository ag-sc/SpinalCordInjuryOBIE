package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import de.hterhors.obie.core.tokenizer.RegExTokenizer;
import de.hterhors.obie.core.tokenizer.Tokenization;

/**
 * TODO: HANDMADE!
 */
public class DocumentPassageExtractor {

	class PredefinedPassage {
		/*
		 * Including.
		 */
		final int startLine;
		/*
		 * Excluding.
		 */
		final int endLine;

		final String documentName;
		final EDocumentPassage passageType;

		public PredefinedPassage(int startLine, int endLine, String documentName, EDocumentPassage passageType) {
			this.startLine = startLine;
			this.endLine = endLine;
			this.documentName = documentName;
			this.passageType = passageType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((documentName == null) ? 0 : documentName.hashCode());
			result = prime * result + endLine;
			result = prime * result + ((passageType == null) ? 0 : passageType.hashCode());
			result = prime * result + startLine;
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
			PredefinedPassage other = (PredefinedPassage) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (documentName == null) {
				if (other.documentName != null)
					return false;
			} else if (!documentName.equals(other.documentName))
				return false;
			if (endLine != other.endLine)
				return false;
			if (passageType != other.passageType)
				return false;
			if (startLine != other.startLine)
				return false;
			return true;
		}

		private DocumentPassageExtractor getOuterType() {
			return DocumentPassageExtractor.this;
		}

		@Override
		public String toString() {
			return "PredefinedPassage [startLine=" + startLine + ", endLine=" + endLine + ", documentName="
					+ documentName + ", passageType=" + passageType + "]";
		}

	}

	private RegExTokenizer regexSentenceTokenizer = new RegExTokenizer();
	private Map<EDocumentPassage, PassageTokenization> tokenizedPassages = new HashMap<>();
	private Map<EDocumentPassage, String> fulltextPassages = new HashMap<>();

	private List<Tokenization> tokenizations = new ArrayList<>();
	private List<String> allSentences = new ArrayList<>();

	private String documentName;

	public String getFullDocumentContent() {
		return fullDocumentContent;
	}

	public List<Tokenization> getTokenizations() {
		return tokenizations;
	}

	public void setTokenizations(List<Tokenization> tokenizations) {
		this.tokenizations = tokenizations;
	}

	public List<String> getAllSentences() {
		return allSentences;
	}

	public void setAllSentences(List<String> allSentences) {
		this.allSentences = allSentences;
	}

	class PassageKey {

		final String documentName;
		final EDocumentPassage passage;

		public PassageKey(String documentname, EDocumentPassage passage) {
			super();
			this.documentName = documentname;
			this.passage = passage;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((documentName == null) ? 0 : documentName.hashCode());
			result = prime * result + ((passage == null) ? 0 : passage.hashCode());
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
			PassageKey other = (PassageKey) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (documentName == null) {
				if (other.documentName != null)
					return false;
			} else if (!documentName.equals(other.documentName))
				return false;
			if (passage != other.passage)
				return false;
			return true;
		}

		private DocumentPassageExtractor getOuterType() {
			return DocumentPassageExtractor.this;
		}

		@Override
		public String toString() {
			return "PassageKey [documentName=" + documentName + ", passage=" + passage + "]";
		}

	}

	final Map<PassageKey, PredefinedPassage> predefinedPassages = new HashMap<>();
	private String fullDocumentContent;

	public static void main(String[] args) throws IOException {
		DocumentPassageExtractor documentPassageExtractor = new DocumentPassageExtractor();

		documentPassageExtractor.processDocument("res/psink/corpora/documents", "Waver et al 2005.txt");

		System.out.println(documentPassageExtractor.getResultsContent());

	}

	private void fillWithPredefinedInformation() {
		String documentName;

		/*
		 * Batch 1
		 */
		documentName = "Ates el al.txt";
		addInfo(7, 21, documentName, EDocumentPassage.ABSTRACT);
		addInfo(64, 189, documentName, EDocumentPassage.METHODS);
		addInfo(192, 258, documentName, EDocumentPassage.RESULTS);

		documentName = "Bohnert et al.txt";
		addInfo(5, 28, documentName, EDocumentPassage.ABSTRACT);
		addInfo(87, 322, documentName, EDocumentPassage.METHODS);
		addInfo(325, 516, documentName, EDocumentPassage.RESULTS);

		documentName = "Thomas et al.txt";
		addInfo(6, 49, documentName, EDocumentPassage.ABSTRACT);
		addInfo(91, 240, documentName, EDocumentPassage.METHODS);
		addInfo(244, 287, documentName, EDocumentPassage.RESULTS);

		documentName = "Wells et al.txt";
		addInfo(8, 42, documentName, EDocumentPassage.ABSTRACT);
		addInfo(106, 243, documentName, EDocumentPassage.METHODS);
		addInfo(246, 355, documentName, EDocumentPassage.RESULTS);

		documentName = "Swartz et al.txt";
		addInfo(8, 19, documentName, EDocumentPassage.ABSTRACT);
		addInfo(53, 225, documentName, EDocumentPassage.METHODS);
		addInfo(228, 314, documentName, EDocumentPassage.RESULTS);

		/*
		 * Batch 2
		 */
		documentName = "Mann et al.txt";
		addInfo(17, 40, documentName, EDocumentPassage.ABSTRACT);
		addInfo(117, 236, documentName, EDocumentPassage.METHODS);
		addInfo(240, 317, documentName, EDocumentPassage.RESULTS);

		documentName = "Pannu et al.txt";
		addInfo(9, 40, documentName, EDocumentPassage.ABSTRACT);
		addInfo(124, 265, documentName, EDocumentPassage.METHODS);
		addInfo(268, 480, documentName, EDocumentPassage.RESULTS);

		documentName = "Wiseman et al.txt";
		addInfo(10, 31, documentName, EDocumentPassage.ABSTRACT);
		addInfo(93, 205, documentName, EDocumentPassage.METHODS);
		addInfo(209, 250, documentName, EDocumentPassage.RESULTS);

		/*
		 * Batch3
		 */
		documentName = "Fumagalli et al.txt";
		addInfo(8, 25, documentName, EDocumentPassage.ABSTRACT);
		addInfo(106, 258, documentName, EDocumentPassage.METHODS);
		addInfo(261, 386, documentName, EDocumentPassage.RESULTS);

		documentName = "Kontogeorgakos 2009.txt";
		addInfo(7, 45, documentName, EDocumentPassage.ABSTRACT);
		addInfo(104, 161, documentName, EDocumentPassage.METHODS);
		addInfo(165, 219, documentName, EDocumentPassage.RESULTS);

		documentName = "Pinzon et al 2008.txt";
		addInfo(7, 20, documentName, EDocumentPassage.ABSTRACT);
		addInfo(62, 213, documentName, EDocumentPassage.METHODS);
		addInfo(216, 303, documentName, EDocumentPassage.RESULTS);

		documentName = "Saganova et al 2008.txt";
		addInfo(7, 15, documentName, EDocumentPassage.ABSTRACT);
		addInfo(49, 132, documentName, EDocumentPassage.METHODS);
		addInfo(132, 256, documentName, EDocumentPassage.RESULTS);

		documentName = "Yazihan et al 2008.txt";
		addInfo(7, 27, documentName, EDocumentPassage.ABSTRACT);
		addInfo(103, 170, documentName, EDocumentPassage.METHODS);
		addInfo(172, 223, documentName, EDocumentPassage.RESULTS);

		documentName = "Yune et al 2004.txt";
		addInfo(8, 29, documentName, EDocumentPassage.ABSTRACT);
		addInfo(128, 440, documentName, EDocumentPassage.METHODS);
		addInfo(443, 642, documentName, EDocumentPassage.RESULTS);

		/*
		 * Batch 4
		 */
		documentName = "Ditor et al 2007.txt";
		addInfo(6, 42, documentName, EDocumentPassage.ABSTRACT);
		addInfo(126, 285, documentName, EDocumentPassage.METHODS);
		addInfo(288, 534, documentName, EDocumentPassage.RESULTS);

		documentName = "Gorio et al 2005.txt";
		addInfo(7, 31, documentName, EDocumentPassage.ABSTRACT);
		addInfo(120, 221, documentName, EDocumentPassage.METHODS);
		addInfo(223, 346, documentName, EDocumentPassage.RESULTS);

		documentName = "Guth et al 1994.txt";
		addInfo(5, 23, documentName, EDocumentPassage.ABSTRACT);
		addInfo(58, 140, documentName, EDocumentPassage.METHODS);
		addInfo(143, 251, documentName, EDocumentPassage.RESULTS);

		documentName = "Guven et al 1999.txt";
		addInfo(14, 46, documentName, EDocumentPassage.ABSTRACT);
		addInfo(107, 146, documentName, EDocumentPassage.METHODS);
		addInfo(150, 158, documentName, EDocumentPassage.RESULTS);

		documentName = "Süzer et al 1999.txt";
		addInfo(11, 28, documentName, EDocumentPassage.ABSTRACT);
		addInfo(73, 159, documentName, EDocumentPassage.METHODS);
		addInfo(162, 213, documentName, EDocumentPassage.RESULTS);

		/*
		 * Batch 5
		 */
		documentName = "Fee et al 2007 Version 2.txt";
		addInfo(7, 14, documentName, EDocumentPassage.ABSTRACT);
		addInfo(302, 446, documentName, EDocumentPassage.METHODS);
		addInfo(78, 175, documentName, EDocumentPassage.RESULTS);

		documentName = "Gok et al 2007.txt";
		addInfo(6, 19, documentName, EDocumentPassage.ABSTRACT);
		addInfo(66, 151, documentName, EDocumentPassage.METHODS);
		addInfo(154, 195, documentName, EDocumentPassage.RESULTS);

		documentName = "Okutan et al 2007.txt";
		addInfo(8, 19, documentName, EDocumentPassage.ABSTRACT);
		addInfo(53, 178, documentName, EDocumentPassage.METHODS);
		addInfo(180, 228, documentName, EDocumentPassage.RESULTS);

		documentName = "Ritz et al 2008.txt";
		addInfo(10, 29, documentName, EDocumentPassage.ABSTRACT);
		addInfo(546, 706, documentName, EDocumentPassage.METHODS);
		addInfo(155, 355, documentName, EDocumentPassage.RESULTS);

		documentName = "Waver et al 2005.txt";
		addInfo(10, 41, documentName, EDocumentPassage.ABSTRACT);
		addInfo(141, 316, documentName, EDocumentPassage.METHODS);
		addInfo(319, 566, documentName, EDocumentPassage.RESULTS);

	}

	public DocumentPassageExtractor() {
		fillWithPredefinedInformation();
	}

	public static String readDocumentsContent(String documentName) {

		try {
			String documentContent = "";
			BufferedReader b;
			b = new BufferedReader(new FileReader(new File(documentName)));

			String l;
			while ((l = b.readLine()) != null) {
				documentContent += l + "\n";
			}

			b.close();
			return documentContent;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void addInfo(int startLine, int endLine, String documentName, EDocumentPassage passageType) {
		predefinedPassages.put(new PassageKey(documentName, passageType),
				new PredefinedPassage(startLine, endLine, documentName, passageType));
	}

	public void processDocument(final String directory, final String documentName) {
		this.documentName = documentName;

		fullDocumentContent = readDocumentsContent(directory + "/" + documentName);
		allSentences = extractSentences(fullDocumentContent);
		tokenizations = regexSentenceTokenizer.tokenize(allSentences);

		for (Entry<PassageKey, PredefinedPassage> predefinedPassage : predefinedPassages.entrySet()) {

			if (!predefinedPassage.getKey().documentName.equals(documentName))
				continue;

			String passageContent = getPassageContent(fullDocumentContent, predefinedPassage.getValue());

			fulltextPassages.put(predefinedPassage.getKey().passage, passageContent);
			List<String> passageSentences = extractSentences(passageContent);
			List<Tokenization> passageTokenizations = regexSentenceTokenizer.tokenize(passageSentences);
			int absoluteStartOffset = getPassageStartOffset(fullDocumentContent, predefinedPassage.getValue());
			tokenizedPassages.put(predefinedPassage.getKey().passage,
					new PassageTokenization(passageTokenizations, passageContent, absoluteStartOffset));
		}

	}

	public static List<String> extractSentences(final String document) {

		BreakIterator sentenceBoundary = BreakIterator.getSentenceInstance(Locale.ENGLISH);
		sentenceBoundary.setText(document);
		List<Integer> sentenceOffsets = new ArrayList<>();
		List<String> sentences = new ArrayList<>();
		int start = sentenceBoundary.first();
		for (int end = sentenceBoundary.next(); end != BreakIterator.DONE; start = end, end = sentenceBoundary.next()) {
			sentenceOffsets.add(end);
			sentences.add(document.substring(start, end).replaceAll("\n", " "));
		}
		return sentences;

	}

	private int getPassageStartOffset(String fullDocumentContent, PredefinedPassage value) {

		String[] lines = fullDocumentContent.split("\n");
		int offset = 0;
		for (int line = 0; line < value.startLine; line++) {
			offset += lines[line].length() + 1;// plus one for line break.
		}
		return offset;
	}

	private String getPassageContent(String fullDocumentContent, PredefinedPassage value) {
		StringBuffer content = new StringBuffer();
		for (String line : Arrays.copyOfRange(fullDocumentContent.split("\n"), value.startLine, value.endLine)) {
			content.append(line).append("\n");
		}

		return content.toString();
	}

	public PassageTokenization getTokenizedContent(EDocumentPassage passage) {
		return tokenizedPassages.get(passage);
	}

	public PassageTokenization getAbstractTokenizedContent() {
		return tokenizedPassages.get(EDocumentPassage.ABSTRACT);
	}

	public PassageTokenization getMethodsTokenizedContent() {
		return tokenizedPassages.get(EDocumentPassage.METHODS);
	}

	public PassageTokenization getResultsTokenizedContent() {
		return tokenizedPassages.get(EDocumentPassage.RESULTS);
	}

	public String getContent(EDocumentPassage passage) {
		return fulltextPassages.get(passage);
	}

	public String getAbstractContent() {
		return fulltextPassages.get(EDocumentPassage.ABSTRACT);
	}

	public String getMethodsContent() {
		return fulltextPassages.get(EDocumentPassage.METHODS);
	}

	public String getResultsContent() {
		return fulltextPassages.get(EDocumentPassage.RESULTS);
	}

}
