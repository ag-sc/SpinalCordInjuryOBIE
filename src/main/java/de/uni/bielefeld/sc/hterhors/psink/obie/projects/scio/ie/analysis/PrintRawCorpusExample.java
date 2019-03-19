package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.analysis;

import java.util.ArrayList;
import java.util.Collections;
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

/**
 * This class contains example code for loading the raw corpus file and printing
 * the first instances. This corpus is NOT used in the ML framework. Before
 * this, we need to convert the raw corpus into a bigram corpus using the
 * BigramCorpusCreator.
 * 
 * Doing this the corpus is enriched with information provided by a specified
 * Named Entity Recognition and Linking Tool.
 * 
 * @author hterhors
 *
 * @See BigramCorpusCreator
 */
public class PrintRawCorpusExample {

	public static void main(String[] args) {

		/**
		 * Load the raw corpus from file system. This corpus contains only the document
		 * content and annotations of the template but NO named entity recognition and
		 * linking annotations!
		 */
		final OBIECorpus rawCorpus = OBIECorpus
				.readRawCorpusData(EntityRecognitionProjectEnvironment.getInstance().getRawCorpusFile());

		Map<String, Set<String>> dict = new HashMap<>();

		for (Instance instance : rawCorpus.getInstances().values()) {

//			System.out.println("________" + instance.name + "________");
//			System.out.println(instance.content);
//			System.out.println("____________Template Annotation(s)____________");

			for (List<IOBIEThing> templateAnnotations : instance.annotations.values()) {
				for (IOBIEThing templateAnnotation : templateAnnotations) {
//					System.out.println(OBIEClassFormatter.format(templateAnnotation, true));

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
						dict.putIfAbsent(templateAnnotation.getONTOLOGY_NAME(), new HashSet<>());
						dict.get(templateAnnotation.getONTOLOGY_NAME()).add(templateAnnotation.getTextMention());

						for (String w : templateAnnotation.getClass().getSimpleName()
								.split(BasicRegExPattern.CAMEL_CASE_SPLIT_PATTERN)) {

							w = w.replaceAll(BasicRegExPattern.SPECIAL_CHARS, "");
							if (BasicRegExPattern.STOP_WORDS.contains(w.toLowerCase()))
								continue;

							dict.get(templateAnnotation.getONTOLOGY_NAME()).add(w);

						}
					}

					final List<Integer> charPositions = new ArrayList<>();

					templateAnnotation.getInvestigatedSlots().forEach(slot -> {
						if (slot != null)
							if (slot.isMultiValueSlot) {
								for (IOBIEThing listObject : slot.getMultiValues()) {
									charPositions.add(listObject.getCharacterOnset());
								}
							} else {
								if (slot.getSingleValue() != null)
									charPositions.add(slot.getSingleValue().getCharacterOnset());
							}
					});

					if (charPositions.isEmpty())
						continue;

					Collections.sort(charPositions);
//					System.out.println(charPositions);

					final int dist = charPositions.get(charPositions.size() - 1).intValue()
							- charPositions.get(0).intValue();
					final int avgDistance = dist / charPositions.size();
//					System.out.println(dist);
//					System.out.println(avgDistance);
				}

			}

		}

		for (Entry<String, Set<String>> string : dict.entrySet()) {

			System.out.print(string.getKey());
			for (String string2 : string.getValue()) {
				System.out.print("\t" + string2);
			}
			System.out.println();
		}

	}
}
