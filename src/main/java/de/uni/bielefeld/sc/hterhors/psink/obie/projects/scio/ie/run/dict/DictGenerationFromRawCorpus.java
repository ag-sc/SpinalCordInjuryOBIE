package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.dict;

import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.corpus.OBIECorpus;
import de.hterhors.obie.core.tools.corpus.OBIECorpus.Instance;
import de.hterhors.obie.ml.ner.regex.BasicRegExPattern;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.EntityRecognitionProjectEnvironment;

public class DictGenerationFromRawCorpus {

	public static void main(String[] args) throws Exception {

		/**
		 * Load the raw corpus from file system. This corpus contains only the document
		 * content and annotations of the template but NO named entity recognition and
		 * linking annotations!
		 */
		final OBIECorpus rawCorpus = OBIECorpus
				.readRawCorpusData(EntityRecognitionProjectEnvironment.getInstance().getRawCorpusFile());

		Map<String, Set<String>> dict = new HashMap<>();

		String dictFileName = "dictionaries/organismModel.dict";
		PrintStream dictPs = new PrintStream(new File(dictFileName));
		for (Instance instance : rawCorpus.getInstances().values()) {

			for (List<IOBIEThing> templateAnnotations : instance.annotations.values()) {
				for (IOBIEThing templateAnnotation : templateAnnotations) {

					if (templateAnnotation != null && templateAnnotation.getIndividual() != null) {
						dict.putIfAbsent(templateAnnotation.getIndividual().getURI(), new HashSet<>());
						dict.get(templateAnnotation.getIndividual().getURI()).add(templateAnnotation.getTextMention());
						for (String w : templateAnnotation.getIndividual().name
								.split(BasicRegExPattern.CAMEL_CASE_SPLIT_PATTERN)) {

							w = w.replaceAll(BasicRegExPattern.SPECIAL_CHARS, "");
							if (BasicRegExPattern.STOP_WORDS.contains(w.toLowerCase()))
								continue;

							dict.get(templateAnnotation.getIndividual().getURI()).add(w);

						}
					} else {
//						dict.putIfAbsent(templateAnnotation.getONTOLOGY_NAME(), new HashSet<>());
//						dict.get(templateAnnotation.getONTOLOGY_NAME()).add(templateAnnotation.getTextMention());
//
//						for (String w : templateAnnotation.getClass().getSimpleName()
//								.split(BasicRegExPattern.CAMEL_CASE_SPLIT_PATTERN)) {
//
//							w = w.replaceAll(BasicRegExPattern.SPECIAL_CHARS, "");
//							if (BasicRegExPattern.STOP_WORDS.contains(w.toLowerCase()))
//								continue;
//
//							dict.get(templateAnnotation.getONTOLOGY_NAME()).add(w);
//						}
					}

				}

			}

		}

		for (Entry<String, Set<String>> string : dict.entrySet()) {
			StringBuffer bf = new StringBuffer();

			bf.append(string.getKey() + "\t");
			for (String string2 : string.getValue()) {
				bf.append(string2 + "|");
			}
			bf.delete(bf.length() - 1, bf.length());
			dictPs.println(bf);
		}
		dictPs.close();

	}
}
