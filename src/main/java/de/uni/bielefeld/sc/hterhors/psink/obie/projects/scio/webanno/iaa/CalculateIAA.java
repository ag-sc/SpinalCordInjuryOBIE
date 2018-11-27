package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.iaa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import de.hterhors.obie.core.OntologyAnalyzer;
import de.hterhors.obie.core.tools.annodb.AnnoDBAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.WebannoAnnotationExtractor;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AgeCategory;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.Annotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.WebAnno3Sentence;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.WebAnno3TSVDocument;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.WebAnno3Token;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.WebannoTSV3Reader;

public class CalculateIAA {

	private static final KappaCategory NEITHER_NOR_CATEGORY = new KappaCategory("NeitherNor");

	private static final String DOCUMENTS[] = { "Nishio et al.tsv", "Özdemir et al.tsv", "Duz et al.tsv" };

	public static final String PAPER_DIRECTORY = "res/webanno/annotatedDocs/trainpaper/";

	private static final int DOCUMENT_INDEX = 2;

	/*
	 * Whether annotated tokens are seen as choice(include) or not (exclude).
	 * 
	 * Removes all annotations on tokens that do NOT exist in both documents.
	 * 
	 */
	private static final boolean INCLUDE_NEITHER_NOR_CATEGORY = false;

	/*
	 * Include all annotated tokens (NOT_ANNOTATED)
	 */
	private static final boolean INCLUDE_EMPTY_ANNOTATED_TOKENS = false;

	public static void main(String[] args) {
		allPapers();
	}

	private static void allPapers() {

		double meanKappa = 0;
		float counter = 0;

		final List<File> documentFiles = Arrays.asList(new File("webanno/raw").listFiles());
		Collections.sort(documentFiles);
		for (int i = 0; i < documentFiles.size(); i++) {
			final List<File> batch = new ArrayList<>();

			final String docPrefix = documentFiles.get(i).getName().split("_")[0];
			for (int j = i; j < documentFiles.size(); j++) {
				if (documentFiles.get(j).getName().split("_")[0].equals(docPrefix)) {
					batch.add(documentFiles.get(j));
				}
			}

			if (batch.size() < 2) {
				// System.out.println("Skipp: " + batch);
				continue;
			}

			// System.out.println(docPrefix);
			// System.out.print("Process: " + docPrefix + "\t");

			final String[] documents = new String[2];
			documents[0] = batch.get(0).getAbsolutePath();
			documents[1] = batch.get(1).getAbsolutePath();
			// documents[0] = PAPER_DIRECTORY + Annotators.Gold + "/" +
			// DOCUMENTS[DOCUMENT_INDEX];

			// for (Annotators annotator : Annotators.values()) {

			// System.out.println("Annotator: " + annotator);
			// documents[1] = PAPER_DIRECTORY + annotator + "/" +
			// DOCUMENTS[DOCUMENT_INDEX];

			Map<KappaSubject, KappaCategory>[] kappaTokenAnnotation = extractKappaAnnotationFromTokens(documents);

//				 Map<KappaSubject, KappaCategory>[] kappaSegmentsAnnotation =
//				 extractKappaAnnotationFromSegments(
//				 documents);
			// List<KappaCategory> kappaCategories =
			// extractKappaCategories(kappaTokenAnnotation);

//				 float kappa = segmentBasedKappa(kappaSegmentsAnnotation);

			float kappa = tokenBasedKappa(kappaTokenAnnotation);

			// float kappa = tokenBasedSCIOClassKappa(kappaTokenAnnotation,
			// OrganismModel.class);

			// float kappa =
			// tokenBasedIndividualCategoryKappa(kappaTokenAnnotation,
			// NNumber.class);

			// kappaCategories.stream().skip(1).forEach(kappacategory -> {

			// float kappa =
			// tokenBasedIndividualCategoryKappa(kappaTokenAnnotation,
			// kappacategory);
			//
			// System.out.println("Kappa: " + kappa);
			// System.out.println("------------");
			// });
			// System.out.println("Kappa: " + kappa);
			System.out.println(kappa);
			// System.out.println("------------");
			// }
			meanKappa += kappa;
			counter++;
		}
		System.out.println(counter);
		System.out.println(meanKappa / counter);
	}

	private static void trainPaper() {
		try {

			final String[] documents = new String[2];

			documents[0] = PAPER_DIRECTORY + Annotators.Gold + "/" + DOCUMENTS[DOCUMENT_INDEX];

			for (Annotators annotator : Annotators.values()) {

				// System.out.println("Annotator: " + annotator);
				documents[1] = PAPER_DIRECTORY + annotator + "/" + DOCUMENTS[DOCUMENT_INDEX];

				Map<KappaSubject, KappaCategory>[] kappaTokenAnnotation = extractKappaAnnotationFromTokens(documents);
				Map<KappaSubject, KappaCategory>[] kappaSegmentsAnnotation = extractKappaAnnotationFromSegments(
						documents);
				List<KappaCategory> kappaCategories = extractKappaCategories(kappaTokenAnnotation);

				// float kappa = segmentBasedKappa(kappaSegmentsAnnotation);

				// float kappa = tokenBasedKappa(kappaTokenAnnotation);

				float kappa = tokenBasedSCIOClassKappa(kappaTokenAnnotation, AgeCategory.class);

				// float kappa =
				// tokenBasedIndividualCategoryKappa(kappaTokenAnnotation,
				// AgeCategory.class);

				// kappaCategories.stream().skip(1).forEach(kappacategory -> {
				//
				// float kappa =
				// tokenBasedIndividualCategoryKappa(kappaTokenAnnotation,
				// kappacategory);
				//
				// System.out.println("Kappa: " + kappa);
				// System.out.println("------------");
				// });
				// System.out.println("Kappa: " + kappa);
				System.out.println(kappa);
				// System.out.println("------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Calculates the Fleiss Kappa for a complex SCIO Class with all possible
	 * subclasses and properties, traversing the ontology tree from.
	 * 
	 * @param documents
	 * @param scioClass
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static float tokenBasedSCIOClassKappa(Map<KappaSubject, KappaCategory>[] kappaAnnotation,
			Class<? extends ISCIOThing> scioClass) throws ClassNotFoundException, IOException {

		List<KappaSubject> kappaSubjects = extractKappaSubjects(kappaAnnotation);
		/*
		 * FleissKappa for individual categories. Skip first (NeitherNor)
		 */

		// System.out.println("---" + scioClass.getSimpleName() + "---");
		/*
		 * FleissKappa for specific categories.
		 */
		Set<KappaCategory> keepCategories = OntologyAnalyzer.getRelatedClassTypesUnderRoot(scioClass).stream()
				.map(sc -> new KappaCategory(sc.getSimpleName())).collect(Collectors.toSet());

		// keepCategories.forEach(c -> System.out.println("\t" +
		// c.getCategoryString()));

		return calculateReducedKappa(kappaAnnotation, kappaSubjects, keepCategories);

	}

	private static float tokenBasedIndividualCategoryKappa(Map<KappaSubject, KappaCategory>[] kappaAnnotation,
			Class<? extends ISCIOThing> scioClass) {

		return tokenBasedIndividualCategoryKappa(kappaAnnotation, new KappaCategory(scioClass.getSimpleName()));
	}

	private static float tokenBasedIndividualCategoryKappa(Map<KappaSubject, KappaCategory>[] kappaAnnotation,
			KappaCategory keepCategory) {

		Set<KappaCategory> keepCategories = new HashSet<>();
		List<KappaSubject> kappaSubjects = extractKappaSubjects(kappaAnnotation);
		/*
		 * FleissKappa for individual categories. Skip first (NeitherNor)
		 */

		System.out.println("---" + keepCategory + "---");

		keepCategories.add(keepCategory);
		/*
		 * FleissKappa for specific categories.
		 */

		return calculateReducedKappa(kappaAnnotation, kappaSubjects, keepCategories);
	}

	private static float tokenBasedKappa(Map<KappaSubject, KappaCategory>[] kappaAnnotation) {

		// System.out.println("---All categories, token wise---");
		List<KappaCategory> kappaCategories = extractKappaCategories(kappaAnnotation);

		List<KappaSubject> kappaSubjects = extractKappaSubjects(kappaAnnotation);

		/*
		 * FleissKappa for all tokens and categories.
		 */
		int[][] kappaMatrix = buildKappaMatrix(kappaAnnotation, kappaCategories, kappaSubjects);

		if (!INCLUDE_EMPTY_ANNOTATED_TOKENS)
			kappaMatrix = reduceEmptyCategoryLines(kappaMatrix, kappaAnnotation.length);

		// System.out.println("Filtered matrix: ");
		// System.out.println("****************");
		// for (int[] is : kappaMatrix) {
		// System.out.println(Arrays.toString(is));
		// }
		// System.out.println("****************");

		return FleissKappa.computeKappa(kappaMatrix);

	}

	/**
	 * Calculates the Fleiss Kappa for all annotations in the given documents on
	 * segment level.
	 * 
	 * @param documents
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static float segmentBasedKappa(Map<KappaSubject, KappaCategory>[] kappaAnnotation) {

		System.out.println("---All categories, segment wise---");

		List<KappaCategory> kappaCategories = extractKappaCategories(kappaAnnotation);

		List<KappaSubject> kappaSubjects = extractKappaSubjects(kappaAnnotation);

		/*
		 * FleissKappa
		 */
		int[][] kappaMatrix = buildKappaMatrix(kappaAnnotation, kappaCategories, kappaSubjects);
		return FleissKappa.computeKappa(kappaMatrix);

	}

	private static float calculateReducedKappa(Map<KappaSubject, KappaCategory>[] reducedKappaAnnotation,
			List<KappaSubject> kappaSubjects, Set<KappaCategory> keepCategories) {

		Map<KappaSubject, KappaCategory>[] filteredKappaAnnotation = reduceAnnotationsByCategoriesUnion(
				reducedKappaAnnotation, keepCategories);

		List<KappaCategory> keepKappaCategories = extractKappaCategories(filteredKappaAnnotation);

		System.out.println("keepKappaCategories = " + keepKappaCategories);

		int[][] filteredKappaMatrix = buildKappaMatrix(filteredKappaAnnotation, keepKappaCategories, kappaSubjects);

		if (!INCLUDE_EMPTY_ANNOTATED_TOKENS)
			filteredKappaMatrix = reduceEmptyCategoryLines(filteredKappaMatrix, reducedKappaAnnotation.length);

		System.out.println("Filtered matrix: ");
		System.out.println("****************");
		for (int[] is : filteredKappaMatrix) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("****************");

		return FleissKappa.computeKappa(filteredKappaMatrix);

	}

	// /**
	// * Calculates the Fleiss Kappa on the full data.
	// *
	// * @param kappaAnnotation
	// * @param kappaCategories
	// * @param kappaSubjects
	// * @return
	// * @throws IOException
	// * @throws ClassNotFoundException
	// */
	// private static int[][] calculateKappaMatrix(Map<KappaSubject,
	// KappaCategory>[] kappaAnnotation,
	// List<KappaCategory> kappaCategories, List<KappaSubject> kappaSubjects) {
	// int[][] kappaMatrix = ;
	// return kappaMatrix;
	// }

	/**
	 * This method filters all KappaSubjects from the annotations where all
	 * annotators selected the NEITHER_NOR_CATEGORY class.
	 * 
	 * this method has only effect after reducing annotations by categories.
	 * 
	 * @see #reduceAnnotationsByCategories
	 * 
	 * @param kappaMatrixNoNeitherNor
	 * @param numOfAnnotators
	 * @return
	 */
	private static int[][] reduceEmptyCategoryLines(int[][] kappaMatrixNoNeitherNor, final int numOfAnnotators) {

		List<Integer> keepLines = new ArrayList<>();
		for (int i = 0; i < kappaMatrixNoNeitherNor.length; i++) {
			/*
			 * Keep lines where not all annotators said NeitherNorCategory.
			 */
			if (kappaMatrixNoNeitherNor[i][0] != numOfAnnotators) {
				keepLines.add(i);
			}
		}
		int[][] filteredMatrix = new int[keepLines.size()][];

		for (int i = 0; i < keepLines.size(); i++) {
			filteredMatrix[i] = kappaMatrixNoNeitherNor[keepLines.get(i)].clone();
		}

		return filteredMatrix;
	}

	/**
	 * Filters all KappaCategories that are not within the keepCategories parameter
	 * list. All other annotations are collected in the NEITHER_NOR_CATEGORY class.
	 * 
	 * This method can be used to calculate the Fleiss Kappa for individual
	 * categories.
	 * 
	 * This filter method filters on the second array of Fleiss Kappa matrix!
	 * 
	 * @see#reduceEmptyCategoryLines
	 * 
	 * @param kappaAnnotation
	 * @param keepCategories
	 * @return
	 */
	private static Map<KappaSubject, KappaCategory>[] reduceAnnotationsByCategoriesUnion(
			Map<KappaSubject, KappaCategory>[] kappaAnnotation, Set<KappaCategory> keepCategories) {
		Map<KappaSubject, KappaCategory>[] filteredKappaAnnotation = new HashMap[kappaAnnotation.length];

		for (int i = 0; i < kappaAnnotation.length; i++) {

			filteredKappaAnnotation[i] = new HashMap<>();
			for (Entry<KappaSubject, KappaCategory> map : kappaAnnotation[i].entrySet()) {

				if ((INCLUDE_NEITHER_NOR_CATEGORY && map.getValue().equals(NEITHER_NOR_CATEGORY))
						|| keepCategories.contains(map.getValue())) {
					filteredKappaAnnotation[i].put(map.getKey(), map.getValue());
				}
			}

		}
		return filteredKappaAnnotation;
	}

	/**
	 * Filters all KappaCategories that are not within the keepCategories parameter
	 * list. All other annotations are collected in the NEITHER_NOR_CATEGORY class.
	 * 
	 * This method can be used to calculate the Fleiss Kappa for individual
	 * categories.
	 * 
	 * This filter method filters on the second array of Fleiss Kappa matrix!
	 * 
	 * @see#reduceEmptyCategoryLines
	 * 
	 * @param kappaAnnotation
	 * @param keepCategories
	 * @return
	 */
	private static Map<KappaSubject, KappaCategory>[] reduceAnnotationsByCategoriesIntersection(
			Map<KappaSubject, KappaCategory>[] kappaAnnotation, Set<KappaCategory> keepCategories) {

		Map<KappaSubject, KappaCategory>[] filteredKappaAnnotation = new HashMap[kappaAnnotation.length];

		for (int i = 0; i < kappaAnnotation.length; i++) {

			filteredKappaAnnotation[i] = new HashMap<>();
			for (Entry<KappaSubject, KappaCategory> annotation : kappaAnnotation[i].entrySet()) {

				include: {
					if ((INCLUDE_NEITHER_NOR_CATEGORY && annotation.getValue().equals(NEITHER_NOR_CATEGORY))
							|| keepCategories.contains(annotation.getValue())) {

						for (int l = 0; l < kappaAnnotation.length; l++) {
							if (kappaAnnotation[l].containsKey(annotation))
								/*
								 * Jump of include
								 */
								break include;
						}

						filteredKappaAnnotation[i].put(annotation.getKey(), annotation.getValue());
					}
				}
			}

		}
		return filteredKappaAnnotation;
	}

	private static Map<KappaSubject, KappaCategory>[] reduceAnnotationsByCategoriesIntersection(
			Map<KappaSubject, KappaCategory>[] kappaAnnotation) {

		Map<KappaSubject, KappaCategory>[] filteredKappaAnnotation = new HashMap[kappaAnnotation.length];

		for (int i = 0; i < kappaAnnotation.length; i++) {

			filteredKappaAnnotation[i] = new HashMap<>();
			for (Entry<KappaSubject, KappaCategory> annotation : kappaAnnotation[i].entrySet()) {

				include: {
					if (!annotation.getValue().equals(NEITHER_NOR_CATEGORY)
							|| (INCLUDE_NEITHER_NOR_CATEGORY && annotation.getValue().equals(NEITHER_NOR_CATEGORY))) {

						for (int l = 0; l < kappaAnnotation.length; l++) {
							if (!kappaAnnotation[l].containsKey(annotation.getKey()))
								/*
								 * Jump of include
								 */
								break include;
						}

						filteredKappaAnnotation[i].put(annotation.getKey(), annotation.getValue());
					}
				}
			}

		}
		return filteredKappaAnnotation;
	}

	/**
	 * Builds the Fleiss Kappa matrix given a set of annotations of documents.
	 * 
	 * @param kappaAnnotation
	 * @param kappaCategories
	 * @param kappaSubjects
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static int[][] buildKappaMatrix(Map<KappaSubject, KappaCategory>[] kappaAnnotation,
			List<KappaCategory> kappaCategories, List<KappaSubject> kappaSubjects) {

		//
		// System.out.println(kappaCategories);
		// System.out.println(kappaAnnotation[0]);
		// System.out.println(kappaAnnotation[1]);

		/*
		 * kappaSubject, Class
		 */
		int[][] matrix = new int[kappaSubjects.size()][kappaCategories.size()];

		int kappaSubjectIndex = 0;
		/*
		 * For each subject.
		 */
		for (KappaSubject subject : kappaSubjects) {
			/*
			 * Sum over all annotators.
			 */
			for (int j = 0; j < kappaAnnotation.length; j++) {

				/*
				 * Check if subject was annotated by annotator.
				 */
				if (kappaAnnotation[j].containsKey(subject)) {
					/*
					 * Add 1 to index of class that was annotated.
					 */
					matrix[kappaSubjectIndex][kappaCategories.indexOf(kappaAnnotation[j].get(subject))]++;
				} else {
					/*
					 * If not, add 1 to class NeitherNor.
					 */
					matrix[kappaSubjectIndex][0]++;
				}

			}
			kappaSubjectIndex++;
		}
		// System.out.println("Full matrix: ");
		// System.out.println("****************");
		// for (int[] is : matrix) {
		// System.out.println(Arrays.toString(is));
		// }
		// System.out.println("****************");
		// System.out.println();
		// System.out.println();
		return matrix;
	}

	/**
	 * Extract all annotations from the given documents by segments (not token
	 * based). For each document a single array entry is created which stores a map
	 * of a KappaSubject (Token offset and onset) and the annotated
	 * KappaCategory(SCIOCLass).
	 * 
	 * @param documents
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static Map<KappaSubject, KappaCategory>[] extractKappaAnnotationFromTokens(final String[] documents) {
		Map<KappaSubject, KappaCategory>[] kappaAnnotation = new HashMap[documents.length];

		/*
		 * Convert annotations to kappa subjects
		 */
		for (int i = 0; i < documents.length; i++) {
			kappaAnnotation[i] = buildKappaAnnotationsByTokens(WebannoTSV3Reader.readWebAnnoTSV3Document(documents[i]));
		}

		kappaAnnotation = reduceAnnotationsByCategoriesIntersection(kappaAnnotation);

		// for (Map<KappaSubject, KappaCategory> map : kappaAnnotation) {
		// map.entrySet().forEach(System.out::println);
		// System.out.println("#######");
		// }

		return kappaAnnotation;
	}

	/**
	 * Builds Kappa Annotations on token level given the annotations from a
	 * document.
	 * 
	 * @param webAnno3TSVDocument
	 * @return
	 */
	private static Map<KappaSubject, KappaCategory> buildKappaAnnotationsByTokens(
			WebAnno3TSVDocument webAnno3TSVDocument) {
		Map<KappaSubject, KappaCategory> kappaAnnotation = new HashMap<>();

		for (WebAnno3Sentence sentence : webAnno3TSVDocument.getSentences()) {
			for (WebAnno3Token token : sentence.getTokens()) {

				final KappaSubject kappaSubject = new KappaSubject(token.onset, token.offset);

				for (Annotation a : token.drrs) {
					final KappaCategory category = new KappaCategory(a.annotationTypeOfDomain.getSimpleName());

					if (kappaAnnotation.containsKey(kappaSubject)) {
						/*
						 * Conjunction of scioClasses for same annotation.
						 */
						kappaAnnotation.put(kappaSubject,
								kappaAnnotation.get(kappaSubject).append(category.getCategoryString()));
					} else {
						kappaAnnotation.put(kappaSubject, category);
					}
				}

				if (INCLUDE_NEITHER_NOR_CATEGORY)
					if (token.drrs.isEmpty())
						kappaAnnotation.put(kappaSubject, NEITHER_NOR_CATEGORY);
			}
		}

		return kappaAnnotation;
	}

	/**
	 * Extract all annotations from the given documents by segments (not token
	 * based). For each document a single array entry is created which stores a map
	 * of a KappaSubject (Annotation offset and onset) and the annotated
	 * KappaCategory(SCIOCLass).
	 * 
	 * @param documents
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static Map<KappaSubject, KappaCategory>[] extractKappaAnnotationFromSegments(final String[] documents) {
		Map<KappaSubject, KappaCategory>[] kappaAnnotation = new HashMap[documents.length];

		/*
		 * Convert annotations to kappa subjects
		 */
		for (int i = 0; i < documents.length; i++) {
			WebannoAnnotationExtractor annotations = new WebannoAnnotationExtractor(
					WebannoTSV3Reader.readWebAnnoTSV3Document(documents[i]));
			kappaAnnotation[i] = buildKappaAnnotationsBySegments(annotations);
		}
		return kappaAnnotation;
	}

	/**
	 * Extracts all Kappa categories (SCIOClasses) that are possible given the
	 * documents.
	 * 
	 * @param kappaAnnotation
	 * @return
	 */
	private static List<KappaCategory> extractKappaCategories(Map<KappaSubject, KappaCategory>[] kappaAnnotation) {
		/*
		 * Extract possible class values and sort. Add class NeitherNor.
		 */
		Set<KappaCategory> possibleClasses = new HashSet<>();
		for (int i = 0; i < kappaAnnotation.length; i++) {
			possibleClasses.addAll(kappaAnnotation[i].values().stream().collect(Collectors.toSet()));
		}

		if (INCLUDE_NEITHER_NOR_CATEGORY)
			possibleClasses.remove(NEITHER_NOR_CATEGORY);

		List<KappaCategory> sortedPossibleClasses = new ArrayList<>(possibleClasses);
		Collections.sort(sortedPossibleClasses);

		if (INCLUDE_NEITHER_NOR_CATEGORY)
			sortedPossibleClasses.add(0, NEITHER_NOR_CATEGORY);

		return sortedPossibleClasses;
	}

	/**
	 * Extracts all Kappa subjects (Annotations offset and onset) from the set of
	 * documents.
	 * 
	 * @param kappaAnnotation
	 * @return
	 */
	private static List<KappaSubject> extractKappaSubjects(Map<KappaSubject, KappaCategory>[] kappaAnnotation) {
		/*
		 * Extract Kappa subjects (annotation spans).
		 */
		Set<KappaSubject> allAnnotations = new HashSet<>();

		for (int i = 0; i < kappaAnnotation.length; i++) {
			allAnnotations.addAll(kappaAnnotation[i].keySet());
		}

		List<KappaSubject> sortedKappaSubjects = new ArrayList<>(allAnnotations);
		Collections.sort(sortedKappaSubjects);
		return sortedKappaSubjects;
	}

	/**
	 * Builds segment based Kappa annotations given the annotations from a document.
	 * 
	 * @param annotations
	 * @return
	 */
	private static Map<KappaSubject, KappaCategory> buildKappaAnnotationsBySegments(
			WebannoAnnotationExtractor annotations) {
		Map<KappaSubject, KappaCategory> kappaAnnotation = new HashMap<>();
		for (AnnoDBAnnotation a : annotations.getAnnotationFactory().values()) {

			final KappaSubject kappaSubject = new KappaSubject(a.onset, a.offset);
			if (kappaAnnotation.containsKey(kappaSubject)) {
				/*
				 * Conjunction of scioClasses for same annotation.
				 */
				kappaAnnotation.put(kappaSubject, kappaAnnotation.get(kappaSubject).append(a.classType));
			} else {
				kappaAnnotation.put(kappaSubject, new KappaCategory(a.classType));
			}

		}
		return kappaAnnotation;
	}

}
