package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;

import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.corpus.CorpusFileTools;
import de.hterhors.obie.core.tools.corpus.OBIECorpus;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOOntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IResult;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

/**
 * Creates a pre annotated document in WebAnnoTsv3-format given the annotated
 * results from Knowtator. NOTE: So far only annotations that are involved in a
 * valid result is converted. E.g: in brigittes first corpus in paper "Wells et
 * al" the term "Male" is annotated but not linked to the animal as gender. In
 * that case the annotations is NOT part of the result, thus it is not converted
 * to Webanno.
 * 
 * @author hterhors
 *
 *         Aug 30, 2016
 */

public class CreatePreAnnotatedDocument {

	private static final String SENTENCE_PREFIX = "Sentence";
	private static OBIECorpus SCIOCorpus;

	static Map<String, List<Container>> cache = new HashMap<>();
	static Map<String, Set<String>> classAnnotations = new HashMap<>();
	static Map<String, List<String>> relationAnnotations = new HashMap<>();

	static Map<String, List<String>> offsets = new HashMap<>();
	private static Map<String, Integer> idMapping = new HashMap<>();

	public static void main(String[] args)
			throws IOException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException {

		String annotator = "daniel";

		final String corpusPrefix = "knowtator_" + annotator + "_";
		final long ontologyVersion = SCIOOntologyEnvironment.getInstance().getOntologyVersion();

		final Set<Class<? extends IOBIEThing>> rootClassTypes = new HashSet<>(Arrays.asList(IResult.class));

		File file = CorpusFileTools.buildRawCorpusFile(new File("scio/knowtator/corpus/"), corpusPrefix, rootClassTypes,
				ontologyVersion);

		SCIOCorpus = OBIECorpus.readRawCorpusData(file);

		for (String fileName : SCIOCorpus.getTrainingInstances().keySet()) {

			// if (!fileName.equals("Wells et al"))
			// continue;

			try {

				String document = null;
				int batch = 0;
				for (int i = 1; i < 6; i++) {

					try {
						String plaintextDocumentName = "res/knowtator/annotations/" + annotator + i + "/txt/" + fileName
								+ ".txt";
						document = readDocument(plaintextDocumentName);
						System.out.println(fileName + " found in " + i);
						batch = i;
						/*
						 * FIXME: Dirty hack to check in which folder the file is....
						 */
						break;

					} catch (Exception e) {
						System.out.println(fileName + " not in " + i);
					}
				}
				idMapping = new HashMap<>();
				cache = new HashMap<>();
				classAnnotations = new HashMap<>();
				relationAnnotations = new HashMap<>();
				offsets = new HashMap<>();

				BreakIterator sentenceBoundary = BreakIterator.getSentenceInstance(Locale.ENGLISH);
				sentenceBoundary.setText(document);
				List<Integer> sentenceOffsets = new ArrayList<>();
				List<String> sentences = new ArrayList<>();
				int start = sentenceBoundary.first();
				for (int end = sentenceBoundary.next(); end != BreakIterator.DONE; start = end, end = sentenceBoundary
						.next()) {
					sentenceOffsets.add(end);
					sentences.add(document.substring(start, end).replaceAll("\n", " "));
				}

				final String header = "#FORMAT=WebAnno TSV 3\n#T_SP=webanno.scio.SCIOEntities|value|expgroup|result";

				BreakIterator boundary = BreakIterator.getWordInstance();
				boundary.setText(document);

				Map<String, List<String>> offsetMapping = buildOffsetMapping(boundary, sentenceOffsets, document,
						fileName);

				buildAnnotations(boundary, sentenceOffsets, sentences, offsetMapping, document, fileName);

				PrintStream ps = new PrintStream(new File(
						"gen/knowtator/v36/" + annotator + "_batch_" + batch + "_class_only_" + fileName + ".tsv"));

				ps.println(header);
				printAnnotations(ps, boundary, sentenceOffsets, sentences, offsetMapping, document);

				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static int mapID(final String knowtatorID) {

		if (!idMapping.containsKey(knowtatorID)) {
			int currentID = idMapping.values().stream().max(Integer::compare).orElse(0).intValue();
			idMapping.put(knowtatorID, currentID + 1);
		}

		final int id = idMapping.get(knowtatorID);

		return id;
	}

	private static Map<String, List<String>> buildOffsetMapping(BreakIterator boundary, List<Integer> sentenceOffsets,
			String source, String fileName) throws IllegalArgumentException, IllegalAccessException {

		final Map<String, List<String>> mapping = new HashMap<>();

		int start = boundary.first();
		int prevSentenceIndex = 0;
		int countTokensInSentence = 0;

		Container annotationContainer = new Container();

		for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

			List<Container> annotationContainers = new ArrayList<>();

			final int sentenceIndex = 1 + getSentenceIndex(sentenceOffsets, end);

			if (sentenceIndex != prevSentenceIndex) {
				prevSentenceIndex = sentenceIndex;
				countTokensInSentence = 0;
			}

			String text = source.substring(start, end);
			if (text.trim().isEmpty()) {
				continue;
			}

			final String cacheKey = start + "-" + end;

			if (cache.containsKey(cacheKey)) {
				annotationContainers = cache.get(cacheKey);
			} else {

				for (IOBIEThing result : SCIOCorpus.getTrainingInstances().get(fileName).annotations
						.get(IResult.class)) {
					annotationContainers
							.addAll(getAnnotationsForSpan((ISCIOThing) result, start, end, null, null, null));
				}

				cache.put(cacheKey, annotationContainers);
			}
			countTokensInSentence++;

			// System.out.println(start + ":" + end + " " + text + ", " +
			// annotationContainers.size());

			for (int i = 0; i < annotationContainers.size(); i++) {
				annotationContainer = annotationContainers.get(i);

				final int annotationID = mapID(
						annotationContainer.classAnnotationName + annotationContainer.annotationID);

				final String sentenceToken = prevSentenceIndex + "-" + countTokensInSentence;
				final String charachter = String.valueOf(start);

				mapping.putIfAbsent(charachter, new ArrayList<>());

				if (!mapping.get(charachter).contains(sentenceToken))
					mapping.get(charachter).add(sentenceToken);

				mapping.putIfAbsent(SENTENCE_PREFIX + sentenceToken, new ArrayList<>());

				if (!mapping.get(SENTENCE_PREFIX + sentenceToken).contains(String.valueOf(annotationID)))
					mapping.get(SENTENCE_PREFIX + sentenceToken).add(String.valueOf(annotationID));

			}
		}

		return mapping;
	}

	private static String readDocument(String plaintextDocumentName) throws FileNotFoundException, IOException {
		String document = "";
		BufferedReader b = new BufferedReader(new FileReader(new File(plaintextDocumentName)));

		String l;
		while ((l = b.readLine()) != null) {
			document += l + "\n";
		}

		b.close();
		return document;
	}

	public static void buildAnnotations(BreakIterator boundary, List<Integer> sentenceOffsets, List<String> sentences,
			Map<String, List<String>> offsetMapping, String source, String fileName)
			throws IllegalArgumentException, IllegalAccessException {

		int start = boundary.first();
		int countTokensInSentence = 0;
		int prevSentenceIndex = 0;

		String prevAnnotationID = null;
		for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

			List<Container> annotationContainers = new ArrayList<>();
			/*
			 * Add one since index starts with 1.
			 */
			final int sentenceIndex = 1 + getSentenceIndex(sentenceOffsets, end);

			if (sentenceIndex != prevSentenceIndex) {
				prevSentenceIndex = sentenceIndex;
				countTokensInSentence = 0;
			}

			String text = source.substring(start, end);

			if (text.trim().isEmpty()) {
				continue;
			}

			boolean consequtiveAnnotation = false;
			Container annotationContainer = new Container();

			String classAnnotation = "";
			String relationAnnotation = "";
			String domainOnOffSet = "";

			final String cacheKey = start + "-" + end;

			if (cache.containsKey(cacheKey)) {
				annotationContainers = cache.get(cacheKey);
			} else {
				for (IOBIEThing result : SCIOCorpus.getTrainingInstances().get(fileName).annotations
						.get(IResult.class)) {

					annotationContainers
							.addAll(getAnnotationsForSpan((ISCIOThing) result, start, end, null, null, null));

				}
				cache.put(cacheKey, annotationContainers);
			}

			final Set<String> processedIDs = new HashSet<>();
			int annotationIndex = 0;
			for (int i = 0; i < annotationContainers.size(); i++) {

				annotationContainer = annotationContainers.get(i);

				if (processedIDs.contains(annotationContainer.annotationID)) {
					continue;
				}

				processedIDs.add(annotationContainer.annotationID);

				if (prevAnnotationID == null || !prevAnnotationID.equals(annotationContainer.annotationID)) {
					consequtiveAnnotation = true;
				}

				prevAnnotationID = annotationContainer.annotationID;

				final int annotationID = mapID(
						annotationContainer.classAnnotationName + annotationContainer.annotationID);

				String key = sentenceIndex + "-" + countTokensInSentence + "\t" + start + "-" + end + "\t" + text;

				classAnnotations.putIfAbsent(key, new HashSet<>());
				relationAnnotations.putIfAbsent(key, new ArrayList<>());
				offsets.putIfAbsent(key, new ArrayList<>());

				classAnnotation = annotationContainer.classAnnotationName == null ? ""
						: annotationContainer.classAnnotationName + "[" + annotationID + "]";

				relationAnnotation = !consequtiveAnnotation || annotationContainer.relationAnnotation == null ? "_"
						: (annotationContainer.relationAnnotation);
				domainOnOffSet = !consequtiveAnnotation || annotationContainer.relationAnnotation == null ? "_"
						: mapCharOffsetToSentenceToken(annotationIndex, offsetMapping,
								annotationContainer.charOnsetDomainAnnotation, annotationID);

				classAnnotations.get(key).add(classAnnotation);
				relationAnnotations.get(key).add(relationAnnotation);
				offsets.get(key).add(domainOnOffSet);

				annotationIndex++;
			}
			countTokensInSentence++;
		}
	}

	public static void printAnnotations(PrintStream ps, BreakIterator boundary, List<Integer> sentenceOffsets,
			List<String> sentences, Map<String, List<String>> offsetMapping, String source)
			throws IllegalArgumentException, IllegalAccessException {

		int start = boundary.first();
		int countTokensInSentence = 0;
		int prevSentenceIndex = 0;

		for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
			/*
			 * Add one since index starts with 1.
			 */
			final int sentenceIndex = 1 + getSentenceIndex(sentenceOffsets, end);

			if (sentenceIndex != prevSentenceIndex) {
				prevSentenceIndex = sentenceIndex;
				countTokensInSentence = 0;
				ps.println();
				ps.println("#Text=" + sentences.get(sentenceIndex - 1));
			}

			String text = source.substring(start, end);

			if (text.trim().isEmpty()) {
				continue;
			}

			String classAnnotation = "";
			String relationAnnotation = "";
			String domainOnOffSet = "";

			String key = sentenceIndex + "-" + countTokensInSentence + "\t" + start + "-" + end + "\t" + text;

			Set<String> single = new HashSet<>();

			if (classAnnotations.containsKey(key)) {
				String split = "";
				for (String string : classAnnotations.get(key)) {
					if (single.contains(string.split("\\[")[0]))
						continue;
					classAnnotation += split;
					classAnnotation += string;
					single.add(string.split("\\[")[0]);
					split = "|";
				}
			} else {
				classAnnotation = "_";
			}
			if (relationAnnotations.containsKey(key)) {
				for (int i = 0; i < relationAnnotations.get(key).size() - 1; i++) {
					relationAnnotation += relationAnnotations.get(key).get(i);
					relationAnnotation += "|";
				}
				relationAnnotation += relationAnnotations.get(key).get(relationAnnotations.get(key).size() - 1);
			} else {
				relationAnnotation = "_";
			}
			if (offsets.containsKey(key)) {
				for (int i = 0; i < offsets.get(key).size() - 1; i++) {
					domainOnOffSet += offsets.get(key).get(i);
					domainOnOffSet += "|";
				}
				domainOnOffSet += offsets.get(key).get(offsets.get(key).size() - 1);
			} else {
				domainOnOffSet = "_";
			}
			countTokensInSentence++;
			/*
			 * Replace dots with 0 ... Why? Because Webanno tsv3 thats why...
			 */
			if (text.equals(".")) {
				text = "0";
			}

			// ps.println(sentenceIndex + "-" + countTokensInSentence + "\t" +
			// start + "-" + end + "\t" + text + "\t"
			// + classAnnotation + "\t" + relationAnnotation + "\t" +
			// domainOnOffSet);
			ps.println(sentenceIndex + "-" + countTokensInSentence + "\t" + start + "-" + end + "\t" + text + "\t"
					+ classAnnotation + "\t" + "_" + "\t" + "_");
		}

	}

	private static int getSentenceIndex(List<Integer> sentenceOffsets, int end) {

		for (int i = 0; i < sentenceOffsets.size(); i++) {
			if (sentenceOffsets.get(i) >= end)
				return i--;
		}

		return -1;
	}

	private static String mapCharOffsetToSentenceToken(final int index, Map<String, List<String>> offsetMapping,
			Integer domainStart, int rangeAnnotationIndex) {

		final String offset = String.valueOf(domainStart);
		List<String> senoffs = offsetMapping.get(offset);
		if (senoffs == null) {
			senoffs = offsetMapping.get(String.valueOf(domainStart + 1));
			System.out.println(offset + " : PULS ONE");
			if (senoffs == null) {
				senoffs = offsetMapping.get(String.valueOf(domainStart - 1));
				System.out.println(offset + " : MINUS ONE");
			}
		}

		if (senoffs == null) {
			System.out.println(offset);
			System.out.println(offsetMapping);
		}

		Collections.sort(senoffs);
		String senOff = senoffs.get(Math.min(index, senoffs.size() - 1));

		String x = senOff + "[" + offsetMapping.get(SENTENCE_PREFIX + senOff).get(0) + "_" + rangeAnnotationIndex + "]";

		return x;
	}

	private static List<Container> getAnnotationsForSpan(ISCIOThing result, int start, int end,
			final Field relationField, final Integer domainStart, final Integer domainEnd)
			throws IllegalArgumentException, IllegalAccessException {
		// System.out.println("result:" + result);
		List<Container> annotationContainers = new ArrayList<>();

		if (result == null)
			return annotationContainers;

		Integer onset = result.getCharacterOnset();
		Integer offset = result.getCharacterOffset();

		if (offset != null && onset != null) {

			// System.out.println("Start: " + start + " : " + onset + " : " +
			// "End: " + end + " : " + offset + ", "
			// + result.getMention());

			if ((start >= onset && end <= offset) || (start) == onset.longValue() || (end == offset.longValue())) {

				Container container = new Container();
				container.classAnnotationName = result.getClass().getSimpleName();

				container.charOnsetAnnotation = onset;
				container.charOffsetOfAnnotation = offset;
				if (domainEnd != null && domainStart != null && relationField != null) {
					container.charOnsetDomainAnnotation = domainStart;
					container.charOffsetOfDomainAnnotation = domainEnd;
					/**
					 * TODO: SOLVE ISSUE: Field does not know about the real name in the ontology.
					 */
					// container.relationAnnotation =
					// OntologyClassField.getPropertyName(relationField.getName());
					throw new NotImplementedException(
							"Field does not know about the real name in the ontology.");
				}
				/**
				 * TODO:SOLVE ISSUE SCIOThings do not have an annotationID anymore, how to tell
				 * whether two discont. annotations belong to each other?
				 */

//				container.annotationID = result.getAnnotationID();
				annotationContainers.add(container);
				throw new NotImplementedException(
						"SCIOThings do not have an annotationID anymore, how to tell whether two discont. annotations belong to each other?");

			}
		}

		final Field[] fields = result.getClass().getDeclaredFields();
		// System.out.println("fields: ");
		for (Field field : fields) {
			// System.out.println("Field: " + field.getName());
			field.setAccessible(true);
			if (field.isAnnotationPresent(OntologyModelContent.class)) {
				try {
					if ((field.get(result) instanceof List)) {
						// System.out.println("List Field:");
						List<ISCIOThing> things;
						things = (List<ISCIOThing>) field.get(result);

						for (ISCIOThing IPSINKThing : things) {
							annotationContainers.addAll(getAnnotationsForSpan(IPSINKThing, start, end, field,
									result.getCharacterOnset(), result.getCharacterOffset()));
						}

					} else if ((field.get(result) instanceof ISCIOThing)) {
						// System.out.println("Normal Field:");
						ISCIOThing thing;
						thing = (ISCIOThing) field.get(result);
						annotationContainers.addAll(getAnnotationsForSpan(thing, start, end, field,
								result.getCharacterOnset(), result.getCharacterOffset()));
					} else if ((field.get(result) instanceof String)) {
						// System.out.println("String Field:");
					}

				} catch (ClassCastException e) {
					e.printStackTrace();
				}

			} else {
				// System.out.println("TRANSIENT ANNOTATION : " +
				// field.getName());
			}
			// System.out.println("Done : " + field.getName());
		}
		return annotationContainers;
	}

}
