package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hterhors.obie.core.tools.annodb.AnnoDBAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.Annotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.WebAnno3Sentence;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.WebAnno3TSVDocument;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.WebAnno3Token;

public class WebannoAnnotationExtractor {

	private String fullDocument;
	private List<String> document = new ArrayList<>();
	private Map<Integer, AnnoDBAnnotation> annotationFactory = new HashMap<>();

	public WebannoAnnotationExtractor(WebAnno3TSVDocument webAnnoDoc) {

		extractAnnotations(webAnnoDoc);
	}

	private void extractAnnotations(WebAnno3TSVDocument webAnnoDoc) {

		for (int sentenceIndex = 0; sentenceIndex < webAnnoDoc.sentences.size(); sentenceIndex++) {
			WebAnno3Sentence sentence = webAnnoDoc.sentences.get(sentenceIndex);
			final StringBuffer docContent = new StringBuffer();

			WebAnno3Token thisSentenceLastToken = sentence.tokens.get(sentence.tokens.size() - 1);

			WebAnno3Token nextSentenceFirstToken = null;
			if (webAnnoDoc.sentences.size() > sentenceIndex + 1) {
				nextSentenceFirstToken = webAnnoDoc.sentences.get(sentenceIndex + 1).tokens.get(0);
			}

			for (int i = 0; i < sentence.tokens.size(); i++) {

				WebAnno3Token token = sentence.tokens.get(i);
				WebAnno3Token nextToken = sentence.tokens.size() > i + 1 ? sentence.tokens.get(i + 1) : null;

				int gapToNextToken;

				if (nextToken == null) {
					gapToNextToken = 0;
				} else {
					/*
					 * Within a sentence
					 */
					gapToNextToken = nextToken.onset - token.offset;
				}
				String splitter = "";
				for (int j = 0; j < gapToNextToken; j++) {
					splitter += " ";
				}

				docContent.append(token.tokenValue).append(splitter);

				final int onset = token.onset;
				final int offset = token.offset;
				final String tokenValue = token.tokenValue;

				for (Annotation drr : token.drrs) {
					final String classType = drr.annotationTypeOfDomain.getSimpleName();
					final int annotationID = drr.annotationID;

					AnnoDBAnnotation currentAnnotation;
					if (annotationFactory.containsKey(annotationID)) {
						/*
						 * Append tokens if multiple token annotation. add splitter as well
						 */
						currentAnnotation = annotationFactory.get(annotationID);
						currentAnnotation.offset = offset;
						currentAnnotation.tokenValue += tokenValue + splitter;

					} else {
						currentAnnotation = new AnnoDBAnnotation(annotationID, classType, onset, offset,
								tokenValue + splitter, drr.ENumbers, drr.RNumbers);
						annotationFactory.put(annotationID, currentAnnotation);
					}

				}
			}

			if (nextSentenceFirstToken != null) {
				/*
				 * Sentence overlapping
				 */
				int gapToNextSentence = (nextSentenceFirstToken.onset - thisSentenceLastToken.offset);
				String splitter = "";
				for (int j = 0; j < gapToNextSentence; j++) {
					splitter += "\n";
				}
				docContent.append(splitter);
			}
			document.add(docContent.toString());

		}

		fullDocument = "";
		for (String string : document) {
			fullDocument += string;
		}
	}

	public Map<Integer, AnnoDBAnnotation> getAnnotationFactory() {
		return annotationFactory;
	}

	public void setAnnotationFactory(Map<Integer, AnnoDBAnnotation> annotationFactory) {
		this.annotationFactory = annotationFactory;
	}

	public String getFullDocument() {
		return fullDocument;
	}

	public void setFullDocument(String fullDocument) {
		this.fullDocument = fullDocument;
	}

	public List<String> getDocument() {
		return document;
	}

	public void setDocument(List<String> document) {
		this.document = document;
	}

}
