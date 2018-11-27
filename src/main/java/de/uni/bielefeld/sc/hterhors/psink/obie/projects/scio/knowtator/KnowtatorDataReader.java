package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.annotation.Obsolete;

import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container.DomainRelationRange;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container.EKnowtatorAnnotator;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container.ExperimentalGroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container.KnowtatorSpan;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container.UniqueAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.tools.CleanEncodingTools;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnalyzedExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.ExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Result;
import edu.stanford.smi.protege.model.Cls;
import edu.stanford.smi.protege.model.KnowledgeBase;
import edu.stanford.smi.protege.model.Project;
import edu.stanford.smi.protege.model.SimpleInstance;
import edu.stanford.smi.protege.model.Slot;
import edu.uchsc.ccp.knowtator.AnnotationUtil;
import edu.uchsc.ccp.knowtator.KnowtatorManager;
import edu.uchsc.ccp.knowtator.KnowtatorProjectUtil;
import edu.uchsc.ccp.knowtator.MentionUtil;
import edu.uchsc.ccp.knowtator.ProjectSettings;
import edu.uchsc.ccp.knowtator.textsource.TextSource;
import edu.uchsc.ccp.knowtator.textsource.TextSourceAccessException;
import edu.uchsc.ccp.knowtator.textsource.TextSourceIterator;
import edu.uchsc.ccp.knowtator.util.ProjectUtil;

/**
 * 
 * @author hterhors
 *
 *         Dec 14, 2016
 */
public class KnowtatorDataReader {

	/*
	 * Those names MUST match the class names / field names.
	 */
	private static final String HAS_INJURY_DEVICE = "hasInjuryDevice";

	private static final String HAS_GROUP_NAME = "hasGroupName";

	private static final String HAS_TREND = "hasTrend";

	private static final String ANALYZED_EXPERIMENTAL_GROUP = AnalyzedExperimentalGroup.class.getSimpleName();

	private static final String HAS_MEMBER = "hasMemberExperimentalGroups";

	private static final String EXPERIMENTAL_GROUP = ExperimentalGroup.class.getSimpleName();

	private static final String RESULT = Result.class.getSimpleName();

	private static final String HAS_TARGET_EXPERIMENTAL_GROUP = "hasTargetExperimentalGroup";

	private static final String HAS_REFERENCE_EXPERIMENTAL_GROUP = "hasReferenceExperimentalGroup";

	/**
	 * The Knowtator project we are dealing with.
	 */
	private static Project project;

	static Set<String> processedIDs = new HashSet<>();

	/**
	 * ID, Set of annotations.
	 */
	static Set<DomainRelationRange> drrs = new HashSet<>();

	/**
	 * mapped DomainClass,mapped RelationType, mapped RangeClass
	 */
	public static Map<UniqueAnnotation, Map<String, Set<UniqueAnnotation>>> data = new HashMap<>();

	/**
	 * mappedClass, Textmention
	 */
	public static Map<UniqueAnnotation, String> dataValues = new HashMap<>();

	/**
	 * mappedClass, Textmention
	 */
	public static Map<UniqueAnnotation, List<KnowtatorSpan>> spanValues = new HashMap<>();

	/**
	 * A list of all Results for each annotator and each paper. Annotator,
	 * Map<Paper, Set<resultID>>
	 */
	public static Map<EKnowtatorAnnotator, Map<String, Set<UniqueAnnotation>>> results = new HashMap<>();

	/**
	 * Annotator, Map<Paper, Set<Annotation>>
	 */
	static Map<EKnowtatorAnnotator, Map<String, List<String>>> annotationAgreementData = new HashMap<>();

	/**
	 * GroupName, ExperimentalGroup
	 */
	static private Map<ExperimentalGroupName, UniqueAnnotation> nameMapping = new HashMap<>();

	/**
	 * Collection of Strings that contains characters with a wrong encoding.
	 */
	static Set<String> nonPrintableStrings = new HashSet<>();

	/**
	 * A mapping between the annotation and the acutal annotation.
	 */
	protected static Map<String, SimpleInstance> annotationMapping = new HashMap<>();

	/**
	 * The current paper name.
	 */
	private static String currentPaper;

	/**
	 * The current annotator.
	 */
	private static EKnowtatorAnnotator currentAnnotator;

	private static Set<String> documentBatches = Arrays.stream(new String[] { "1", "2", "3", "4", "5" })
			.collect(Collectors.toSet());

	/**
	 * A helper variable to determine the depth in a recursive method call.
	 */
	private static int recursiveDepth = 0;

	private static AnnotationUtil annotationUtil;
	private static MentionUtil mentionUtil;

	private static KnowtatorMappingProvider mappings = KnowtatorMappingProvider.getInstance();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		read();
	}

	public static void read() throws IOException, FileNotFoundException {
		String dataFileNameForIAA = "scio/knowtator/Knowtator_Class_IAA_full_category.csv";
		/*
		 * Start the conversion of the data from Knowtator to Java-HashMaps.
		 */
		readDataFromKnowtator();

		/*
		 * Resolve missing dependencies
		 */
		resolveMissingDependencies();

		/*
		 * Print the converted data for debugging etc.
		 */
		printConvertedData();

		/*
		 * Creates data to calculate the Inter-Annotator-Agreement (IAA) for the given
		 * annotations in Knowtator between daniel and brigitte.
		 */
		createIAAData(dataFileNameForIAA);

		/*
		 * Create mapping template files. This is not needed anymore since the mapping
		 * is complete.
		 */
		// createMappingTemplateFiles();
	}

	/*
	 * Resolves missing dependencies between classes which occur due to the
	 * different SCIO-version.
	 */
	private static void resolveMissingDependencies() {
		/*
		 * Resolve group names. This is necessary since SCIO-Results and
		 * SCIO-ExperimentalGroups do not have a direct connection. They are rather
		 * connected by sharing the same group name.
		 *
		 * We resolve the issue by inferring a direct connection between Results and
		 * ExperimentalGroups if they have share the same GroupName.
		 */
		resolveGroupNames();

	}

	/**
	 * This method generates new relations between a Result and an
	 * ExperimentalGroup. It uses the nameMapping data to infer these relations.
	 */
	private static void resolveGroupNames() {

		/**
		 * NOTE: If there is more then one ExperimentalGroup which was used as
		 * ReferenceGroup create AnalyzedExperimentalGroup connection and add
		 * ReferenceGroups as member! If there is just one ReferenceGroup add directly
		 * to Result.
		 */

		final Map<UniqueAnnotation, Map<String, Set<UniqueAnnotation>>> hasMembers = new HashMap<>();

		for (Entry<UniqueAnnotation, Map<String, Set<UniqueAnnotation>>> dataPoint : data.entrySet()) {

			final UniqueAnnotation domain = dataPoint.getKey();
			/*
			 * For all Results resolve names.
			 */
			if (domain.classType.equals(RESULT)) {
				/*
				 * Infer ReferenceGroups.
				 */
				Set<UniqueAnnotation> experimentalReferenceRanges = new HashSet<>();
				if (dataPoint.getValue().containsKey(HAS_REFERENCE_EXPERIMENTAL_GROUP)) {
					for (UniqueAnnotation groupName : dataPoint.getValue().get(HAS_REFERENCE_EXPERIMENTAL_GROUP)) {

						final ExperimentalGroupName groupNameMappingKey = new ExperimentalGroupName(groupName.paperID,
								groupName.annotator, dataValues.get(groupName));

						experimentalReferenceRanges.add(nameMapping.getOrDefault(groupNameMappingKey, groupName));
					}

					/*
					 * Remove GroupName Annotations.
					 */
					dataPoint.getValue().get(HAS_REFERENCE_EXPERIMENTAL_GROUP).clear();

					if (experimentalReferenceRanges.size() == 1) {
						/*
						 * Add corresponding ExperimentalGroups
						 */
						dataPoint.getValue().get(HAS_REFERENCE_EXPERIMENTAL_GROUP).addAll(experimentalReferenceRanges);
					} else {

						final UniqueAnnotation analyzedGroupRange = new UniqueAnnotation(domain.annotator,
								domain.paperID, ANALYZED_EXPERIMENTAL_GROUP, "Reference:" + domain.id);

						hasMembers.putIfAbsent(analyzedGroupRange, new HashMap<>());
						hasMembers.get(analyzedGroupRange).putIfAbsent(HAS_MEMBER, new HashSet<>());
						hasMembers.get(analyzedGroupRange).get(HAS_MEMBER).addAll(experimentalReferenceRanges);

						dataPoint.getValue().get(HAS_REFERENCE_EXPERIMENTAL_GROUP).add(analyzedGroupRange);
					}

				}
				/*
				 * Infer TargetGroups.
				 */
				Set<UniqueAnnotation> experimentalTargetMapping = new HashSet<>();
				if (dataPoint.getValue().containsKey(HAS_TARGET_EXPERIMENTAL_GROUP)) {
					for (UniqueAnnotation groupName : dataPoint.getValue().get(HAS_TARGET_EXPERIMENTAL_GROUP)) {
						final ExperimentalGroupName groupNameMappingKey = new ExperimentalGroupName(groupName.paperID,
								groupName.annotator, dataValues.get(groupName));

						experimentalTargetMapping.add(nameMapping.getOrDefault(groupNameMappingKey, groupName));
					}
					/*
					 * Remove GroupName Annotations.
					 */
					dataPoint.getValue().get(HAS_TARGET_EXPERIMENTAL_GROUP).clear();
					if (experimentalTargetMapping.size() == 1) {
						/*
						 * Add corresponding ExperimentalGroups
						 */
						dataPoint.getValue().get(HAS_TARGET_EXPERIMENTAL_GROUP).addAll(experimentalTargetMapping);
					} else {

						final UniqueAnnotation analyzedGroupRange = new UniqueAnnotation(domain.annotator,
								domain.paperID, ANALYZED_EXPERIMENTAL_GROUP, "Target:" + domain.id);

						hasMembers.putIfAbsent(analyzedGroupRange, new HashMap<>());
						hasMembers.get(analyzedGroupRange).putIfAbsent(HAS_MEMBER, new HashSet<>());
						hasMembers.get(analyzedGroupRange).get(HAS_MEMBER).addAll(experimentalTargetMapping);

						dataPoint.getValue().get(HAS_TARGET_EXPERIMENTAL_GROUP).add(analyzedGroupRange);
					}
				}
			}
		}

		/*
		 * Add additionalMember properties...
		 */
		data.putAll(hasMembers);

	}

	/**
	 * Creates a list of mapping files that can be used as templates. All files need
	 * to be filled manually by human knowledge!
	 * 
	 * If the mapping is done once, this method gets Obsolete.
	 * 
	 * @throws FileNotFoundException
	 */
	@Obsolete
	private static void createMappingTemplateFiles() throws FileNotFoundException {
		/*
		 * Create a template file for the direct class mapping.
		 */
		createDirectClassMappingTemplate();

		/*
		 * Create a template file for the complex mapping.
		 */
		createComplexMappingTemplate();

		/*
		 * Create a template file for the character-failure mapping.
		 */
		createCharFailureMappingTemplate();
	}

	/**
	 * Creates a template file for the char-mapping file to map invalid tokens to
	 * its correct character.
	 * 
	 * @throws FileNotFoundException
	 */
	private static void createCharFailureMappingTemplate() throws FileNotFoundException {
		PrintStream printFailures = new PrintStream("scio/knowtator/charMapping.csv");
		List<String> charFailures = new ArrayList<>(nonPrintableStrings);
		Collections.sort(charFailures);
		charFailures.forEach(s -> printFailures.println(s + "\t" + s));
		printFailures.close();
	}

	/**
	 * Prints the converted data to a human readable format.
	 * 
	 * @throws FileNotFoundException
	 */
	private static void printConvertedData() throws FileNotFoundException {

		System.out.println("Size = " + drrs.size() + " :");
		drrs.stream().forEach(System.out::println);
		System.out.println("#END#");
		System.out.println("");
		System.out.println("Relations: ");
		drrs.stream().map(drr -> drr.relationClass).distinct().sorted().forEach(System.out::println);
		System.out.println("#END#");
		System.out.println("");
		System.out.println("Resolved GroupName mapping: ");
		nameMapping.entrySet().forEach(System.out::println);
		System.out.println("#END#");
		System.out.println("");
		System.out.println("Data: ");
		data.entrySet().forEach(System.out::println);
		System.out.println("#END#");
		System.out.println("");
		System.out.println("Data mention values: ");
		dataValues.entrySet().forEach(System.out::println);
		System.out.println("#END#");
		System.out.println("");
		System.out.println("Data spans: ");
		spanValues.entrySet().forEach(System.out::println);
		System.out.println("#END#");
		System.out.println("");
		System.out.println("Result ids: ");
		results.entrySet().forEach(System.out::println);

		writeConvertedResultsAsStringToFile();

	}

	/**
	 * Writes well formatted SCIO-Result objects to a file. Results that are not
	 * valid are printed to the Std.error.
	 * 
	 * @throws FileNotFoundException
	 */
	private static void writeConvertedResultsAsStringToFile() throws FileNotFoundException {

		PrintStream printResults = new PrintStream("scio/knowtator/gen/results");

		recursiveDepth = 0;

		for (EKnowtatorAnnotator annotator : results.keySet()) {
			for (String paper : results.get(annotator).keySet()) {
				for (UniqueAnnotation result : results.get(annotator).get(paper)) {
					if (data.containsKey(result))
						if (isValidResult(result)) {
							printResults.println("######" + annotator + "######");
							printResults.println("######" + paper + "######");
							printDataNice(printResults, result);
							printResults.println("#######################");
							printResults.println();
						} else {
							System.err.println("######" + annotator + "######");
							System.err.println("######" + paper + "######");
							printDataNice(System.err, result);
							System.err.println("#######################");
							System.err.println();
						}
				}
			}
		}
		printResults.close();
	}

	/**
	 * Creates a template file for the direct mapping of an old SCIO-Class to the
	 * new SCIO-Class.
	 * 
	 * @throws FileNotFoundException
	 */
	private static void createDirectClassMappingTemplate() throws FileNotFoundException {
		PrintStream psClasses = new PrintStream("scio/knowtator/knowtator_scioClassesMapping_template.csv");
		Stream.concat(drrs.stream().map(drr -> drr.domainValue + "\t" + drr.domainClass),
				drrs.stream().map(drr -> drr.rangeValue + "\t" + drr.rangeClass)).distinct().sorted()
				.forEach(psClasses::println);
		psClasses.close();
	}

	/**
	 * Creates a template file for the complex mapping of an old SCIO-DRR to the new
	 * SCIO-DRR.
	 * 
	 * @throws FileNotFoundException
	 */
	private static void createComplexMappingTemplate() throws FileNotFoundException {
		PrintStream ps = new PrintStream("scio/knowtator/knowtator_scioComplexMapping_template.csv");
		ps.println(
				"DomainValue\tRangeValue\tOldScioDomain\tOldScioRelation\tOldScioRange\tNewScioDomain\tNewScioRelation\tNewScioRange\tUnsure");
		drrs.stream().map(drr -> getComplexMappingRepresentation(drr)).sorted().distinct().filter(l -> !l.isEmpty())
				.forEach(ps::println);
		ps.close();
	}

	/**
	 * Creates data to calculate the Inter-Annotator-Agreement between brigitte and
	 * daniel. The data can be used in an R-Script provided by Matthias Hartung.
	 * 
	 * The data contains information on annotation-document level.
	 */
	private static void createIAAData(final String fileName) {

		/*
		 * Read brigittes annotations. Each annotations contains the paperID and the
		 * annotation.
		 */
		List<String> brigittesAnnoations = new ArrayList<>();
		for (String paperKey : annotationAgreementData.get(EKnowtatorAnnotator.Brigitte).keySet()) {
			for (String annotation : annotationAgreementData.get(EKnowtatorAnnotator.Brigitte).get(paperKey)) {
				brigittesAnnoations.add(paperKey + "-" + annotation);

			}
		}

		/*
		 * Read daniels annotations. Each annotations contains the paperID and the
		 * annotation.
		 */
		List<String> danielsAnnoations = new ArrayList<>();
		for (String paperKey : annotationAgreementData.get(EKnowtatorAnnotator.Daniel).keySet()) {
			for (String annotation : annotationAgreementData.get(EKnowtatorAnnotator.Daniel).get(paperKey)) {
				danielsAnnoations.add(paperKey + "-" + annotation);
			}
		}

		/*
		 * Get a list of agreed annotations. (Paper specific)
		 */
		List<String> agreedAnnotations = new ArrayList<>(brigittesAnnoations);
		agreedAnnotations.retainAll(danielsAnnoations);

		final int agreement = agreedAnnotations.size();
		System.out.println("agreement = " + agreement);

		/*
		 * Get the list of brigittes annotations that were missing by daniel.
		 */
		List<String> brigittesAnnotationRest = new ArrayList<>(brigittesAnnoations);
		brigittesAnnotationRest.removeAll(danielsAnnoations);
		final int brigitteRest = brigittesAnnotationRest.size();

		/*
		 * Get the list of daniel annotations that were missing by brigitte.
		 */
		List<String> danielsAnnotationRest = new ArrayList<>(danielsAnnoations);
		danielsAnnotationRest.removeAll(brigittesAnnoations);
		final int danielsRest = danielsAnnotationRest.size();

		System.out.println("brigittesRest = " + brigitteRest);
		System.out.println("danielsRest = " + danielsRest);

		/*
		 * Print IAA data as CSV
		 */
		try {
			PrintStream ps = new PrintStream(fileName);

			ps.println("#Brigitte;#Daniel");
			for (int i = 0; i < agreedAnnotations.size(); i++) {
				ps.println(agreedAnnotations.get(i).split("-", 2)[1] + ";" + agreedAnnotations.get(i).split("-", 2)[1]);
			}
			for (int i = 0; i < brigittesAnnotationRest.size(); i++) {
				ps.println(brigittesAnnotationRest.get(i).split("-", 2)[1] + ";NONE");
			}
			for (int i = 0; i < danielsAnnotationRest.size(); i++) {
				ps.println("NONE;" + danielsAnnotationRest.get(i).split("-", 2)[1]);
			}

			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if the result for the given result-id conforms to some important
	 * rules.
	 * 
	 * @param resultID the id of the result.
	 * @return
	 */
	public static boolean isValidResult(UniqueAnnotation resultID) {

		boolean isValid = true;

		// isValid &= hasTrend(resultID);
		// isValid &= hasValidReferenceGroup(resultID);
		// isValid &= hasValidTargetGroup(resultID);

		return isValid;
	}

	/**
	 * Checks if the result has a valid TargetGroup. This might be wrong if the
	 * GroupName resolving was wrong or incomplete.
	 * 
	 * @param result
	 * @return
	 */
	private static boolean hasValidTargetGroup(UniqueAnnotation result) {
		return data.get(result).containsKey(HAS_TARGET_EXPERIMENTAL_GROUP)
				&& data.get(result).get(HAS_TARGET_EXPERIMENTAL_GROUP).stream().map(g -> g.classType)
						.allMatch(e -> e.equals(EXPERIMENTAL_GROUP));
	}

	/**
	 * Checks if the result has a valid ReferenceGroup. This might be wrong if the
	 * GroupName resolving was wrong or incomplete.
	 * 
	 * @param result
	 * @return
	 */
	private static boolean hasValidReferenceGroup(UniqueAnnotation result) {
		return data.get(result).containsKey(HAS_REFERENCE_EXPERIMENTAL_GROUP)
				&& data.get(result).get(HAS_REFERENCE_EXPERIMENTAL_GROUP).stream().map(g -> g.classType)
						.allMatch(e -> e.equals(EXPERIMENTAL_GROUP));
	}

	/**
	 * Checks if the Result has a Trend. If not the Result has no meaning.
	 * 
	 * @param result
	 * @return
	 */
	private static boolean hasTrend(UniqueAnnotation result) {
		return data.get(result).containsKey(HAS_TREND);
	}

	/**
	 * Finds a valid mapping for a given old SCIO-DRR. This could either be a
	 * complex mapping or each component on its own.
	 * 
	 * @param drr the old SCIO-DRR
	 * @return the mapping with the new classes and the new relation in DRR-format.
	 */
	private static DomainRelationRange mapDataPoint(DomainRelationRange drr) {
		if (mappings.obsoletRelations
				.contains(new DomainRelationRange(drr.domainClass, "", drr.relationClass, drr.rangeClass, "")))
			return null;

		DomainRelationRange drrComplexMap = mappings.mapComplex(drr);

		boolean complexMap = !(drrComplexMap == drr);
		if (complexMap) {
			return drrComplexMap;
		} else {
			return new DomainRelationRange(mappings.mapClass(drr.domainClass), drr.domainValue,
					mappings.mapRelation(drr.relationClass), mappings.mapClass(drr.rangeClass), drr.rangeValue);
		}
	}

	/**
	 * Finds a valid mapping for a given old SCIO-DRR. This could either be a
	 * complex mapping or each component on its own.
	 * 
	 * @param drr the old SCIO-DRR
	 * @return the mapping with the new classes and the new relation in printable
	 *         String format.
	 */
	private static String getComplexMappingRepresentation(DomainRelationRange drr) {

		/*
		 * Activate for new Data
		 */
		// if (scioComplexMapping.containsKey(drr)) {
		// return "";
		// }

		/*
		 * If the DRR was marked as obsolete return empty String.
		 */
		if (mappings.obsoletRelations
				.contains(new DomainRelationRange(drr.domainClass, "", drr.relationClass, drr.rangeClass, "")))
			return "";

		/*
		 * Try to complex-map the old SCIO-DRR.
		 */
		DomainRelationRange drrComplexMap = mappings.mapComplex(drr);

		/*
		 * If the objects after complex mapping is equal to the mapping before there was
		 * no complex mapping.
		 */
		boolean complexMap = !(drrComplexMap == drr);

		/*
		 * If saveMapping is true the mapping can be treated as correct.
		 */
		boolean saveMapping = true;

		saveMapping &= complexMap || mappings.scioClassMapping.containsKey(drrComplexMap.domainClass);
		saveMapping &= complexMap || mappings.scioRelationMapping.containsKey(drrComplexMap.relationClass);
		saveMapping &= complexMap || mappings.scioClassMapping.containsKey(drrComplexMap.rangeClass);

		/*
		 * Build the output with all mappings.
		 */
		StringBuffer line = new StringBuffer();
		line.append(drr.domainValue);
		line.append("\t");
		line.append(drr.rangeValue);
		line.append("\t");
		line.append(drr.domainClass);
		line.append("\t");
		line.append(drr.relationClass);
		line.append("\t");
		line.append(drr.rangeClass);
		line.append("\t");
		line.append(mappings.mapClass(drrComplexMap.domainClass));
		line.append("\t");
		line.append(mappings.mapRelation(drrComplexMap.relationClass));
		line.append("\t");
		line.append(mappings.mapClass(drrComplexMap.rangeClass));
		line.append(saveMapping ? "" : "\t??");
		return line.toString();
	}

	/**
	 * Returns n offset to print depending on the recursiveDepth.
	 * 
	 * @return an Tab-containing String with a specific length.
	 */
	private static String tabs() {
		String x = "";
		for (int i = 0; i < recursiveDepth; i++) {
			x += "\t";
		}
		return x;
	}

	/**
	 * Recursive method that prints data (Map of Maps) well formatted.
	 * 
	 * @param printResults
	 * @param key
	 */
	private static void printDataNice(final PrintStream printResults, final UniqueAnnotation key) {
		printResults.println(tabs() + key + " ( " + dataValues.get(key) + " )" + " ( " + spanValues.get(key) + " )");
		recursiveDepth++;
		if (data.containsKey(key))
			for (Entry<String, Set<UniqueAnnotation>> q : data.get(key).entrySet()) {
				printResults.println(tabs() + q.getKey());
				recursiveDepth++;
				for (UniqueAnnotation k2 : q.getValue()) {
					printDataNice(printResults, k2);
				}
				recursiveDepth--;
			}
		recursiveDepth--;
	}

	/**
	 * Starts the conversion process.
	 * 
	 * Loops over all annotators batches and papers.
	 */
	private static void readDataFromKnowtator() {

		for (EKnowtatorAnnotator annotator : EKnowtatorAnnotator.values()) {

			currentAnnotator = annotator;

			annotationAgreementData.put(currentAnnotator, new HashMap<>());

			final String annotatorName = currentAnnotator.name().toLowerCase();

			for (String batchName : documentBatches) {
				try {

					final String projectFileName = "scio/knowtator/res/annotations/" + annotatorName + batchName
							+ "/project/SCIO4.25.pprj";

					/*
					 * Open the project
					 */
					KnowtatorDataReader.project = ProjectUtil.openProject(projectFileName);

					prepareAndIterate(annotatorName, batchName);

				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		}

	}

	/**
	 * Prints the knowtator project to an IOB file.
	 * 
	 * @param out       The stream to print to.
	 * @param className The name to use for B and I.
	 * @throws TextSourceAccessException
	 */
	public static void prepareAndIterate(String annotator, String batch) throws TextSourceAccessException {

		KnowtatorManager knowtatorManager = initializeKnowtatorProject();
		annotationUtil = knowtatorManager.getAnnotationUtil();
		mentionUtil = knowtatorManager.getMentionUtil();

		/*
		 * Get text collection from project.
		 */
		TextSourceIterator textSourceIterator = ProjectSettings.getRecentTextSourceCollection(project).iterator();

		/*
		 * Iterate over all texts in the project
		 */
		while (textSourceIterator.hasNext()) {
			final TextSource textSource = textSourceIterator.next();

			/*
			 * Print working header with useful information.
			 */
			printWorkingHeader(annotator, batch, annotationUtil, textSource);

			if (!textSource.getName().replaceAll(".txt", "").isEmpty()) {

				initPaperDependedVariables(textSource);

				if (annotationUtil.getAnnotations(textSource) != null) {
					convertAnnotations(textSource);
				} else {
					System.out.println("WARN!!!!! Empty Annotationset detected!!!!");
				}
			}
		}
	}

	/**
	 * Prints a working header to the console with useful information about the
	 * current process.
	 * 
	 * @param annotator
	 * @param batch
	 * @param annotationUtil
	 * @param textSource
	 * @throws TextSourceAccessException
	 */
	private static void printWorkingHeader(String annotator, String batch, final AnnotationUtil annotationUtil,
			final TextSource textSource) throws TextSourceAccessException {
		final String pmid = textSource.getText().substring(0, textSource.getText().indexOf('\n'));
		int num = annotationUtil.getAnnotations(textSource) == null ? 0
				: annotationUtil.getAnnotations(textSource).size();
		System.out.println("Working on " + textSource.getName() + " with PMID " + pmid + " and " + num
				+ " annotations for" + annotator + " in batch " + batch);
	}

	/**
	 * Initialize all variables that a depended for a specific paper and annotator.
	 * 
	 * @param textSource
	 */
	private static void initPaperDependedVariables(final TextSource textSource) {
		currentPaper = textSource.getName();
		results.putIfAbsent(currentAnnotator, new HashMap<>());
		results.get(currentAnnotator).putIfAbsent(currentPaper, new HashSet<>());
		annotationAgreementData.get(currentAnnotator).put(currentPaper, new ArrayList<>());
	}

	/**
	 * Initialize the Knowledgebase for Knowtator to retrieve all needed
	 * information. This method returns the KnowtatorManager that can be used to
	 * access all Knowtator utils.
	 * 
	 * @return the knowtatorManager
	 */
	private static KnowtatorManager initializeKnowtatorProject() {
		KnowledgeBase kb = project.getKnowledgeBase();
		KnowtatorProjectUtil kpu = new KnowtatorProjectUtil(kb);
		KnowtatorManager knowtatorManager = new KnowtatorManager(kpu);
		return knowtatorManager;
	}

	public static void convertAnnotations(TextSource textSource) throws TextSourceAccessException {
		/*
		 * Get all annotations from paper.
		 */
		List<SimpleInstance> annotations = new ArrayList<SimpleInstance>(annotationUtil.getAnnotations(textSource));

		/*
		 * Sort annotations by the number of related annotations in the document. FIXME:
		 * This is some kind of hacking to get the root annotations.
		 */
		Collections.sort(annotations, new Comparator<SimpleInstance>() {

			public int compare(SimpleInstance o1, SimpleInstance o2) {
				return -Integer.compare(annotationUtil.getRelatedAnnotations(o1).size(),
						annotationUtil.getRelatedAnnotations(o2).size());
			}
		});

		/*
		 * Clear mapping between the annotation and the actual annotation.
		 */
		annotationMapping = new HashMap<>();
		/*
		 * Create a mapping between the actual annotation and its id. Since we lose all
		 * information about the annotation in the next process we need to store all
		 * annotations somehow. This mapping is used to retrieve the spans later on.
		 */
		for (SimpleInstance annotation : annotations) {
			SimpleInstance mention = annotationUtil.getMention(annotation);
			annotationMapping.put(mention.getName(), annotation);
		}

		/*
		 * For all sorted annotatations (root-annotations first) build deep mapping.
		 */
		for (SimpleInstance annotation : annotations) {

			SimpleInstance mention = annotationUtil.getMention(annotation);
			if (mentionUtil.isClassMention(mention)) {
				Cls mentionCls = mentionUtil.getMentionCls(mention);
				/*
				 * Add annotation to IAA-data.
				 */
				annotationAgreementData.get(currentAnnotator).get(currentPaper).add(mentionCls.getName());

				final String ID = getPaperAndAnnotatorDependendID(mention);

				/*
				 * Annotations are sorted by their number of related subannotations. In this way
				 * we get the most complex classes first. E.g. Trend and ExperimentalGroups. We
				 * then store each processed mention-ID. In that way we prevent the system from
				 * processing smaller subsets of a complex mention.
				 */
				if (!processedIDs.contains(ID)) {
					processedIDs.add(ID);
					System.out.println("###" + mentionCls.getName() + " " + mention.getName());

					/*
					 * Start deep mapping of the root annotation. This method recursively calls
					 * itself.
					 */
					deepMapping(mention);
				}
			}
		}
	}

	/**
	 * Entry point of the recursive deepMapping procedure. Deep because its
	 * recursive :P
	 * 
	 * @param domainMention
	 */
	private static void deepMapping(SimpleInstance domainMention) {
		deepMapping(domainMention, null, null);
	}

	/**
	 * Recursively called method!
	 * 
	 * @param annotationMapping
	 * @param rangeMention
	 * @param domainMention
	 * @param relationMention
	 */
	private static void deepMapping(SimpleInstance rangeMention, SimpleInstance domainMention,
			SimpleInstance relationMention) {
		/*
		 * Increase depth for logging.
		 */
		recursiveDepth++;

		/*
		 * Prevent recursive relations (happens in Brigitte batch 4)
		 */
		if (!rangeMention.equals(domainMention)) {
			if (mentionUtil.isClassMention(rangeMention)) {
				/*
				 * If the annotation is from type ClassMmention, which basically means it is a
				 * class and not a relation.
				 */
				deepClassMentionMapping(rangeMention, domainMention, relationMention);
			} else if (mentionUtil.isSlotMention(rangeMention)) {
				/*
				 * If the annotation is from type slotMention, which basically means it is a
				 * relation and not a class.
				 */
				handleSlotMentionMapping(rangeMention, domainMention);
			}
		}
		/*
		 * Decrease depth for logging.
		 */
		recursiveDepth--;
	}

	private static void deepClassMentionMapping(SimpleInstance rangeAnnotation, SimpleInstance domainMention,
			SimpleInstance relationMention) {

		/*
		 * Convert the mention into the actual Knowtator-Class.
		 */
		Cls rangeCls = mentionUtil.getMentionCls(rangeAnnotation);
		Cls domainCls = mentionUtil.getMentionCls(domainMention);

		/*
		 * Add ID to prevent double calculations.
		 */
		processedIDs.add(getPaperAndAnnotatorDependendID(rangeAnnotation));

		/*
		 * If the domain range and relation exists, start mapping from old SCIO-DRR to
		 * new SCIO-DRR.
		 */
		if (domainCls != null && relationMention != null && rangeCls != null) {

			/*
			 * Get relation between domain and range.
			 */
			final Slot relation = mentionUtil.getSlotMentionSlot(relationMention);

			/*
			 * Data to build current DRR.
			 */
			final String domainValue = CleanEncodingTools.getCleanBrowserText(domainMention);
			final String rangeValue = CleanEncodingTools.getCleanBrowserText(rangeAnnotation);
			final String knowtatorRelationID = relation.getName();
			final String knowtatorDomainID = domainCls.getName();
			final String knowtatorRangeID = rangeCls.getName();

			final DomainRelationRange oldScioDRR = new DomainRelationRange(knowtatorDomainID, domainValue,
					knowtatorRelationID, knowtatorRangeID, rangeValue);

			/*
			 * Add to data.
			 */
			drrs.add(oldScioDRR);

			/*
			 * Map old SCIO-DRR to new SCIO-DRR.
			 */
			DomainRelationRange newScioDRR = mapDataPoint(oldScioDRR);

			/*
			 * Can only be null if the DRR was marked as obsolete.
			 */
			if (newScioDRR != null) {

				/*
				 * Give as argument so the code can be used again.
				 */
				final String remapProperty = "injury device detail";

				try {

					/*
					 * The knowtatorID of the current domain annotation.
					 */
					final String domainID = domainMention.getName();

					/*
					 * Create new unique Annotation for the domain.
					 */
					UniqueAnnotation domainUniqueAnnotation = new UniqueAnnotation(currentAnnotator, currentPaper,
							newScioDRR.domainClass, domainID);

					/*
					 * Relation of the new SCIO-DRR
					 */
					final String relationType = newScioDRR.relationClass;

					/*
					 * The knowtatorID of the current range annotation.
					 */
					final String rangeID = rangeAnnotation.getName();

					/*
					 * Create new unique Annotation for the range.
					 */
					final UniqueAnnotation rangeUniqueAnnotation = new UniqueAnnotation(currentAnnotator, currentPaper,
							newScioDRR.rangeClass, rangeID);

					/*
					 * Handle some remaining issue by human designed extra rules!
					 */
					if (oldScioDRR.relationClass.equals(remapProperty)) {
						domainUniqueAnnotation = ruleRemapClass(domainUniqueAnnotation);
					}
					if (newScioDRR.domainClass.equals(EXPERIMENTAL_GROUP)) {
						ruleExperimentalGroup(domainValue, rangeValue, domainUniqueAnnotation, relationType);
					}
					if (newScioDRR.domainClass.equals(RESULT)) {
						ruleResult(domainUniqueAnnotation);
					}
					System.out.println("#####" + rangeUniqueAnnotation);

					/*
					 * Collect the current mapped dataPoint (Annotation)
					 */
					collectDataPoint(rangeAnnotation, domainMention, domainValue, rangeValue, domainUniqueAnnotation,
							relationType, rangeUniqueAnnotation);

					/*
					 * Collect further dataPoints if specified in the complex mapping file.
					 */
					if (mappings.scioAddAdditionalMappingForComplex.containsKey(oldScioDRR)) {
						collectAdditionalDataPoints(rangeAnnotation, domainMention, rangeValue, oldScioDRR);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		System.out.println(tabs() + "M-Range: " + rangeCls.getName() + " - " + rangeAnnotation.getName());
		System.out.println(tabs() + "M-Text: " + CleanEncodingTools.getCleanBrowserText(rangeAnnotation));
		System.out.println(
				tabs() + "M-Spans: " + annotationUtil.getSpans(annotationMapping.get(rangeAnnotation.getName())));

		/*
		 * If the class has properties call deepMapping recursively with all
		 * SlotMentions. Now the SlotMention is the range the current range is the
		 * domain.
		 */
		Collection<SimpleInstance> slotMentions = mentionUtil.getSlotMentions(rangeAnnotation);

		if (!slotMentions.isEmpty())
			System.out.println(tabs() + "M-Relations:");

		for (SimpleInstance slotMention : slotMentions) {
			if (mentionUtil.hasSlotValue(slotMention)) {
				System.out.println(tabs() + "M-Domain: " + rangeCls.getName() + " - "
						+ CleanEncodingTools.getCleanBrowserText(rangeAnnotation));
				deepMapping(slotMention, rangeAnnotation, relationMention);
			}
		}
	}

	public static SimpleInstance currentID;

	/**
	 * Collect additional DRR that are mentioned in the complex mapping file. This
	 * might happen if two Classes are directly connected in the old SCIO but nor in
	 * the new SCIo or v.v. In those cases we need to add a new bridge connection
	 * which are specified in the complex mapping file.
	 * 
	 * @param rangeMention
	 * @param domainMention
	 * @param rangeValue
	 * @param oldScioDRR
	 */
	private static void collectAdditionalDataPoints(SimpleInstance rangeMention, SimpleInstance domainMention,
			final String rangeValue, DomainRelationRange oldScioDRR) {

		for (DomainRelationRange additionalDrr : KnowtatorMappingProvider
				.getInstance().scioAddAdditionalMappingForComplex.get(oldScioDRR)) {

			if (additionalDrr.relationClass.equals("hasCompound")) {
				currentID = domainMention;
			}

			/*
			 * Create new unique Annotation for the domain.
			 */

			final UniqueAnnotation additionalDomainUniqueAnnotation;

			/*
			 * TODO: If additional drr's domain is the range of the current relation take
			 * rangeMention's ID.
			 */

			if (additionalDrr.relationClass.equals("hasCompoundSupplier")) {
				additionalDomainUniqueAnnotation = new UniqueAnnotation(currentAnnotator, currentPaper,
						additionalDrr.domainClass, currentID.getName());
			} else if (
			// additionalDrr.domainClass.equals("SuppliedCompound")
			// ||
			additionalDrr.domainClass.equals("CompoundTreatment") || additionalDrr.domainClass.equals("RatModel")
					|| additionalDrr.domainClass.equals("MouseModel") || additionalDrr.domainClass.equals("Thoracic")) {
				additionalDomainUniqueAnnotation = new UniqueAnnotation(currentAnnotator, currentPaper,
						additionalDrr.domainClass, rangeMention.getName());
			} else {
				additionalDomainUniqueAnnotation = new UniqueAnnotation(currentAnnotator, currentPaper,
						additionalDrr.domainClass, domainMention.getName());
			}

			/*
			 * Relation of the new SCIO-DRR
			 */
			final String relationType = additionalDrr.relationClass;

			/*
			 * Create new unique Annotation for the range.
			 */
			final UniqueAnnotation additionalRangeUniqueAnnotation = new UniqueAnnotation(currentAnnotator,
					currentPaper, additionalDrr.rangeClass, domainMention.getName());

			if (additionalDomainUniqueAnnotation.classType.equals(RESULT))
				ruleResult(additionalDomainUniqueAnnotation);

			data.putIfAbsent(additionalDomainUniqueAnnotation, new HashMap<>());
			data.get(additionalDomainUniqueAnnotation).putIfAbsent(relationType, new HashSet<>());
			data.get(additionalDomainUniqueAnnotation).get(relationType).add(additionalRangeUniqueAnnotation);
			dataValues.putIfAbsent(additionalRangeUniqueAnnotation, rangeValue);

			final List<KnowtatorSpan> extendedRangeSpans = annotationUtil
					.getSpans(annotationMapping.get(rangeMention.getName())).stream()
					.map(s -> new KnowtatorSpan(s.getStart(), s.getEnd())).collect(Collectors.toList());
			spanValues.putIfAbsent(additionalRangeUniqueAnnotation, extendedRangeSpans);
		}
	}

	/**
	 * Collect the standard complex mapped annotation.
	 * 
	 * @param rangeMention
	 * @param domainMention
	 * @param domainValue
	 * @param rangeValue
	 * @param domainUniqueAnnotation
	 * @param relationType
	 * @param rangeUniqueAnnotation
	 */
	private static void collectDataPoint(SimpleInstance rangeMention, SimpleInstance domainMention,
			final String domainValue, final String rangeValue, UniqueAnnotation domainUniqueAnnotation,
			final String relationType, final UniqueAnnotation rangeUniqueAnnotation) {
		data.putIfAbsent(domainUniqueAnnotation, new HashMap<>());
		data.get(domainUniqueAnnotation).putIfAbsent(relationType, new HashSet<>());
		data.get(domainUniqueAnnotation).get(relationType).add(rangeUniqueAnnotation);
		dataValues.putIfAbsent(domainUniqueAnnotation, domainValue);
		dataValues.putIfAbsent(rangeUniqueAnnotation, rangeValue);

		final List<KnowtatorSpan> domainSpans = annotationUtil.getSpans(annotationMapping.get(domainMention.getName()))
				.stream().map(s -> new KnowtatorSpan(s.getStart(), s.getEnd())).collect(Collectors.toList());
		spanValues.putIfAbsent(domainUniqueAnnotation, domainSpans);

		final List<KnowtatorSpan> rangeSpans = annotationUtil.getSpans(annotationMapping.get(rangeMention.getName()))
				.stream().map(s -> new KnowtatorSpan(s.getStart(), s.getEnd())).collect(Collectors.toList());
		spanValues.putIfAbsent(rangeUniqueAnnotation, rangeSpans);
	}

	/**
	 * If the class is a Result, add its ID to the resultIds for later iterating
	 * over all Results.
	 * 
	 * @param domainAnnotation
	 */
	private static void ruleResult(UniqueAnnotation domainAnnotation) {
		results.get(currentAnnotator).get(currentPaper).add(domainAnnotation);
	}

	/**
	 * If the Class is a ExperimentalGroup then add all names to the nameMapping
	 * data for later resolving and inferring of new connections between Result and
	 * ExperimentalGroups.
	 * 
	 * @param domainValue
	 * @param rangeValue
	 * @param domainClsID
	 * @param relationClsID
	 */
	private static void ruleExperimentalGroup(final String domainValue, final String rangeValue,
			UniqueAnnotation domainClsID, final String relationClsID) {
		/*
		 * Add explicit groupNames
		 */
		if (relationClsID.equals(HAS_GROUP_NAME)) {

			final String groupNameValue = rangeValue;
			final ExperimentalGroupName groupNameMappingKey = new ExperimentalGroupName(currentPaper, currentAnnotator,
					groupNameValue);

			nameMapping.put(groupNameMappingKey, domainClsID);
		}
		/*
		 * Add implicit name of the group
		 */
		final String groupNameValue = domainValue;
		final ExperimentalGroupName groupNameMappingKey = new ExperimentalGroupName(currentPaper, currentAnnotator,
				groupNameValue);

		nameMapping.put(groupNameMappingKey, domainClsID);
	}

	/**
	 * If the domain contains the relation "injury device detail" which is only
	 * available in the old SCIO map that relation to hasInjuryDevice.
	 * 
	 * @param domainClsID
	 * @return
	 */
	private static UniqueAnnotation ruleRemapClass(UniqueAnnotation domainClsID) {
		if (data.containsKey(domainClsID) && data.get(domainClsID).containsKey(HAS_INJURY_DEVICE))
			domainClsID = new ArrayList<>(data.get(domainClsID).get(HAS_INJURY_DEVICE)).get(0);
		return domainClsID;
	}

	/**
	 * 
	 * Handles a SlotClass relation of a class in knowtator. A Slot can be seen as a
	 * property of a class.
	 * 
	 * @param relationMention
	 * @param domainMention
	 */
	private static void handleSlotMentionMapping(SimpleInstance relationMention, SimpleInstance domainMention) {

		/*
		 * If the mention is not from type complexSlotMention skip the mention. This
		 * should not happen!
		 */
		if (!mentionUtil.isComplexSlotMention(relationMention)) {
			System.out.println(tabs() + "S-Can not handle mention: " + relationMention);
			return;
		}

		/*
		 * Get relation between domain and range.
		 */
		Slot relation = mentionUtil.getSlotMentionSlot(relationMention);

		System.out.println(tabs() + "S-Relation type: " + relation.getName());

		/*
		 * Get all slotValues for the range class. If there is at least one value, map
		 * it.
		 */
		Collection<Object> slotValues = mentionUtil.getSlotMentionValues(relationMention);
		if (slotValues == null) {
			return;
		}

		for (Object slotValue : slotValues) {
			/*
			 * Cast object.
			 */
			SimpleInstance rangeMention = (SimpleInstance) slotValue;

			/*
			 * If class is a leaf-class in the deep mapping (size == 0) map leaf-class. If
			 * not call method recursively.
			 */
			if (mentionUtil.isClassMention(rangeMention) && mentionUtil.getSlotMentions(rangeMention).size() == 0) {
				/*
				 * Convert the mention into the actual Knowtator-Class.
				 */
				Cls rangeCls = mentionUtil.getMentionCls(rangeMention);
				Cls domainCls = mentionUtil.getMentionCls(domainMention);
				/*
				 * Add ID to prevent double calculations.
				 */
				processedIDs.add(getPaperAndAnnotatorDependendID(rangeMention));

				System.out.println(tabs() + "S-Range =" + rangeCls.getName() + " - " + rangeMention.getName());
				System.out.println(tabs() + "S-Text: " + CleanEncodingTools.getCleanBrowserText(rangeMention));
				System.out.println(
						tabs() + "S-Spans: " + annotationUtil.getSpans(annotationMapping.get(rangeMention.getName())));

				/*
				 * If the domain range and relation exists, start mapping from old SCIO-DRR to
				 * new SCIO-DRR.
				 */
				if (domainCls != null && relation != null && rangeCls != null) {
					/*
					 * Data to build current DRR.
					 */
					final String domainValue = CleanEncodingTools.getCleanBrowserText(domainMention);
					final String rangeValue = CleanEncodingTools.getCleanBrowserText(rangeMention);
					final String knowtatorRelationID = relation.getName();
					final String knowtatorDomainID = domainCls.getName();
					final String knowtatorRangeID = rangeCls.getName();

					final DomainRelationRange oldScioDRR = new DomainRelationRange(knowtatorDomainID, domainValue,
							knowtatorRelationID, knowtatorRangeID, rangeValue);

					/*
					 * Add to data.
					 */
					drrs.add(oldScioDRR);

					/*
					 * Map old SCIO-DRR to new SCIO-DRR.
					 */
					DomainRelationRange newScioDRR = mapDataPoint(oldScioDRR);

					if (newScioDRR != null) {

						/*
						 * Give as argument so the code can be used again.
						 */
						final String remapProperty = "treatment timing";

						try {
							/*
							 * The knowtatorID of the current domain annotation.
							 */
							final String domainID = domainMention.getName();

							/*
							 * Create new unique Annotation for the domain.
							 */
							UniqueAnnotation domainUniqueAnnotation = new UniqueAnnotation(currentAnnotator,
									currentPaper, newScioDRR.domainClass, domainID);

							/*
							 * Relation of the new SCIO-DRR
							 */
							final String relationType = newScioDRR.relationClass;

							/*
							 * The knowtatorID of the current range annotation.
							 */
							final String rangeID = rangeMention.getName();

							/*
							 * Create new unique Annotation for the range.
							 */
							final UniqueAnnotation rangeUniqueAnnotation = new UniqueAnnotation(currentAnnotator,
									currentPaper, newScioDRR.rangeClass, rangeID);

							/*
							 * Handle some remaining issue by human designed extra rules!
							 */
							if (oldScioDRR.relationClass.equals(remapProperty)) {
								domainUniqueAnnotation = ruleRemapClass(domainUniqueAnnotation);
							}

							if (newScioDRR.domainClass.equals(EXPERIMENTAL_GROUP)) {
								ruleExperimentalGroup(domainValue, rangeValue, domainUniqueAnnotation, relationType);
							}

							if (newScioDRR.domainClass.equals(RESULT))
								ruleResult(domainUniqueAnnotation);

							/*
							 * Add span for leaf classes.
							 */
							final UniqueAnnotation rangeMentionAnnotation = new UniqueAnnotation(currentAnnotator,
									currentPaper, newScioDRR.rangeClass, rangeMention.getName());

							final List<KnowtatorSpan> domainSpans = annotationUtil
									.getSpans(annotationMapping.get(rangeMention.getName())).stream()
									.map(s -> new KnowtatorSpan(s.getStart(), s.getEnd())).collect(Collectors.toList());
							spanValues.putIfAbsent(rangeMentionAnnotation, domainSpans);

							/*
							 * Collect the current mapped dataPoint (Annotation)
							 */
							collectDataPoint(relationMention, domainMention, domainValue, rangeValue,
									domainUniqueAnnotation, relationType, rangeUniqueAnnotation);

							/*
							 * Collect further dataPoints if specified in the complex mapping file.
							 */
							if (mappings.scioAddAdditionalMappingForComplex.containsKey(oldScioDRR)) {
								collectAdditionalDataPoints(relationMention, domainMention, rangeValue, oldScioDRR);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Skip drr: " + oldScioDRR);
					}
				}
			} else {
				deepMapping(rangeMention, domainMention, relationMention);
			}
		}

	}

	/**
	 * Generates a new ID which depends on the annotator and the paper. This is
	 * necessary since IDs are not project-crossing unique.
	 * 
	 * @param rangeMention
	 * @return the new unique ID.
	 */
	private static String getPaperAndAnnotatorDependendID(SimpleInstance rangeMention) {
		return currentPaper + currentAnnotator + rangeMention.getName();
	}
}
