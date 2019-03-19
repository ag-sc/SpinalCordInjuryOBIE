package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hterhors.obie.core.tools.JavaClassNamingTools;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.SlotFillingProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

/**
 * This class reads the annotations from WEbAnno from TSV3 Format and creates a
 * Java-Object. In the current version this reader is not able to parse
 * relations. That means the last two columns in the TSV3 file are ignored!
 * 
 * @author hterhors
 *
 *         Sep 1, 2016
 */
public class WebannoTSV3Reader {

	private static final String RELATION_IDENT = "#T_RL=webanno.custom.SCIORelations";
	private static final String COMMENT_IDENT = "#T_SP=webanno.custom.SCIOComments";
	private static final String E_AND_R_IDENT = "#T_SP=webanno.scio.SCIOEntities|value|expgroup|result";

	private static final String TSV3_COMMENT = "#";
	private static final String WEBANNO_3_TSV_IDENT = TSV3_COMMENT + "FORMAT=WebAnno TSV 3";
	private static final int CLASS_NAME = 3;
	private static int E_NUMBERS = -1;
	private static int R_NUMBERS = -1;
	private static int COMMENT = -1;
	private static int DISCONT = -1;
	private static int DISCONT_DATA = -1;

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		List<String> files = Arrays.asList(new File("webanno/raw/").list());

		Collections.sort(files);

		// final String name = "N180_Mayeur_2013_plamina";
		// final String name = "N156_Kalincik_2010_2_Anna";
		// final String name =
		// "N001_Yoo,%2520Khaled%2520et%2520al.%25202013_plamina";

		// WebAnno3TSVDocument doc =
		// readWebAnnoTSV3Document("/home/hterhors/Downloads/OpenAccess_PMC3235548.tsv");
		// WebAnno3TSVDocument doc = readWebAnnoTSV3Document("webanno/raw/" +
		// name + ".tsv");
		List<String> comments = new ArrayList<>();
		for (String file : files) {
			if (new File(file).isDirectory())
				continue;

			System.out.println("Current File: " + file);
			WebAnno3TSVDocument doc = readWebAnnoTSV3Document("webanno/raw/" + file);

			// doc.sentences.forEach(System.out::println);
			// System.out.println("---DISCONTS----");
			// doc.disconts.entrySet().forEach(System.out::println);
			// System.out.println("---COMMENTS----");
			// doc.comments.forEach(System.out::println);

			comments.addAll(doc.comments);
			// System.out.println();
			System.out.println("################################");
			// break;
		}
		// comments.forEach(System.out::println);
	}

	public static WebAnno3TSVDocument readWebAnnoTSV3Document(final String documentName) {
		COMMENT = -1;
		DISCONT = -1;
		DISCONT_DATA = -1;
		WebAnno3TSVDocument doc = new WebAnno3TSVDocument();

		try {

			final Map<Integer, WebAnno3Sentence> sentenceFactory = new HashMap<>();

			List<String> lines;
			lines = Files.readAllLines(new File(documentName).toPath());

			if (!lines.get(0).trim().equals(WEBANNO_3_TSV_IDENT)) {
				System.err.println("Given document is not in Webanno TSV3 format! " + lines.get(0));
				System.exit(1);
			}

			/*
			 * Webanno 3 starts annotation counter by 1.
			 */
			int globalAnnotationCounter = 0;

			/*
			 * Start at 5 because of entities and offsets.
			 */
			int coloumnCounter = 5;

			for (String line : lines) {

				if (line.startsWith(RELATION_IDENT)) {
					coloumnCounter += line.split("\\|").length - 1;
					DISCONT = coloumnCounter - 1;
					DISCONT_DATA = coloumnCounter;
					continue;
				}

				if (line.startsWith(COMMENT_IDENT)) {
					coloumnCounter += line.split("\\|").length - 1;
					COMMENT = coloumnCounter - 2;
					continue;
				}

				if (line.startsWith(E_AND_R_IDENT)) {
					coloumnCounter += line.split("\\|").length - 2;
					E_NUMBERS = (coloumnCounter - 1) - 2;
					R_NUMBERS = coloumnCounter - 2;
					continue;
				}

				if (line.startsWith(TSV3_COMMENT))
					continue;

				if (!line.matches("[0-9]+-[0-9]+\t.*"))
					continue;

				if (line.trim().isEmpty())
					continue;
				final String[] data = line.split("\t");

				int sentenceNumber = Integer.parseInt(data[0].split("-")[0]);
				int tokenNumber = Integer.parseInt(data[0].split("-")[1]);

				int onset = Integer.parseInt(data[1].split("-")[0]);
				int offset = Integer.parseInt(data[1].split("-")[1]);

				String tokenValue = data[2];

				WebAnno3TokenOfSentence tokenID = new WebAnno3TokenOfSentence(sentenceNumber, tokenNumber);

				WebAnno3Sentence sentence;
				if (sentenceFactory.containsKey(sentenceNumber)) {
					sentence = sentenceFactory.get(sentenceNumber);
				} else {
					sentence = new WebAnno3Sentence();
					doc.addSentence(sentence);
					sentenceFactory.put(sentenceNumber, sentence);
				}

				WebAnno3Token token = new WebAnno3Token(tokenValue, onset, offset, tokenID);

				try {
					if (COMMENT != -1 && !data[COMMENT].equals("_")) {
						doc.addComment(line);
					}
				} catch (Exception e) {
					System.out.println(line);
					e.printStackTrace();
					System.exit(1);
				}

				final String[] annotedClasses = data[CLASS_NAME].split("\\|");
				final String[] ENumbers = data[E_NUMBERS].split("\\|");
				final String[] RNumbers = data[R_NUMBERS].split("\\|");
				int annotationIndex = 0;
				for (String annotatedClass : annotedClasses) {

					String annotationclassType = annotatedClass.split("\\[", 3)[0];

					if (annotationclassType.equals("_") || annotationclassType.equals("*")) {
						continue;
					}

					int annotationID;

					if (!(annotatedClass.contains("[") && annotatedClass.contains("]"))) {
						globalAnnotationCounter++;
						annotationID = globalAnnotationCounter;
					} else {
						int id = Integer.parseInt(annotatedClass.split("\\[|\\]", 3)[1]);
						annotationID = id;
						globalAnnotationCounter = Math.max(globalAnnotationCounter, id);
					}

					String E = null, R = null;
					if (E_NUMBERS != -1 && ENumbers[annotationIndex].startsWith("E")) {
						E = ENumbers[annotationIndex].replaceAll("\\[[0-9]+\\]", "");
						// System.out.println(
						// ENumbers[annotationIndex] + " with annotation ID = "
						// + annotationID + "-->" + E);
					}

					if (R_NUMBERS != -1 && RNumbers[annotationIndex].startsWith("R")) {
						R = RNumbers[annotationIndex].replaceAll("\\[[0-9]+\\]", "");
						// System.out.println(
						// RNumbers[annotationIndex] + " with annotation ID = "
						// + annotationID + "-->" + R);
					}
					Class<ISCIOThing> annotationTypeOfDomain = reflectClassForName(annotationclassType);

					if (DISCONT != -1 && data.length > DISCONT && data[DISCONT].split("\\|").length > annotationIndex) {

						final String discont = data[DISCONT].split("\\|")[annotationIndex];
						if (discont.equals("discont")) {
							if (data[DISCONT_DATA].split("\\|")[annotationIndex].split("\\[|_|\\]").length > 1) {

								int fromID = Integer.parseInt(
										data[DISCONT_DATA].split("\\|")[annotationIndex].split("\\[|_|\\]")[1]);
								int toID = Integer.parseInt(
										data[DISCONT_DATA].split("\\|")[annotationIndex].split("\\[|_|\\]")[2]);
								/*
								 * TODO: FIXME
								 */
								if (toID == 0) {
									toID = annotationID;
								} else {
									if (annotationID != toID) {
										// System.err.println("DISCONT:
										// annotationID
										// does not match fromID:" + fromID
										// + ", annotationID:" + annotationID +
										// ",
										// to:" + toID);
										// System.exit(1);
									}
								}

								doc.putDiscont(toID, fromID);
							} else {
								System.err.println("Could not read discont annotations..");
								System.err.println(line);
							}
						}
					}

					Annotation drr = new Annotation(annotationID, annotationTypeOfDomain, E, R);
					token.drrs.add(drr);
					annotationIndex++;
				}
				sentence.addToken(token);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (missing)
			System.exit(1);
		return doc;
	}

	static boolean missing = false;

	/**
	 * Checks whether the annotation class is existent in current SCIO.
	 * 
	 * @param className
	 * @return
	 */
	private static Class<ISCIOThing> reflectClassForName(String className) {
		try {

			/**
			 * REMAP From Version 49 to version 58
			 */
			if (className.equals("Recovery"))
				className = "RepeatedMeasureTrend";

			if (className.equals("Timepoint"))
				className = "Duration";

			if (className.equals("Change"))
				className = "ObservedDifference";

			if (className.equals("Increase"))
				className = "FasterIncrease";

			if (className.equals("Decrease"))
				className = "FasterDecrease";

			if (className.equals("NoChange"))
				className = "None";

			if (className.equals("C57BL6MouseModel"))
				className = "C57_BL6_Mouse";

			if (className.equals("LesionSite"))
				className = "SpinalLesionSite";

			if (className.equals("Dorsal"))
				className = "DorsalInjuryArea";

			if (className.equals("ObservationOfBehaviour"))
				className = "ObservationOfAnimalBehaviour";

			if (className.equals("SpragueDawleyRatModel"))
				className = "SpragueDawleyRat";

			if (className.equals("AnimalCare"))
				className = "AnimalCareCondition";

			if (className.equals("GreyMatter"))
				className = "SpinalGrayMatter";

			if (className.equals("Subdural"))
				className = "SpinalSubduralArea";

			if (className.equals("Unilateral"))
				className = "UnilateralInjuryArea";

			if (className.equals("WistarRatModel"))
				className = "WistarRat";

			if (className.equals("Ventral"))
				className = "VentralInjuryArea";

			if (className.equals("WhiteMatter"))
				className = "SpinalWhiteMatter";

			if (className.equals("MedicalExamination"))
				className = "PhysiologyTest";

			if (className.equals("ForelimbHindlimbCoupling"))
				className = "ForelimbHindlimbCouplingAbility";

			if (className.equals("AneuyrismClip"))
				className = "AneurysmClip";

			if (className.equals("SurgicalTreatment"))
				className = "SurgeryTreatment";

			if (className.equals("TreatmentLocation"))
				className = "Location";

			if (className.equals("IntravenousDelivery"))
				className = "DeliveryMethod";

			if (className.equals("FiberTract"))
				className = "SpinalFiberTract";

			if (className.equals("SchwannCellsTest"))
				className = "SchwannCellChangesTest";

			if (className.equals("ElectromagneticField"))
				className = "ElectromagneticFieldTreatment";

			if (className.equals("LongEvansRatModel"))
				className = "LongEvansRat";

			if (className.equals("Complete"))
				className = "CompleteInjuryArea";

			if (className.equals("OligodendrogliaTest"))
				className = "OligodendrogliaChangesTest";

			if (className.equals("DorsalHalf"))
				className = "SpinalDorsalHalf";

			if (className.equals("Longitude"))
				className = "Length";

			if (className.equals("Unit"))
				className = "Qudt_Quantity";

			if (className.equals("CorticoSpinalTract"))
				className = "CorticospinalTract";

			if (className.equals("RubroSpinalTract"))
				className = "RubrospinalTract";

			if (className.equals("ForelimbFineMotorControlAbility"))
				className = "FineMotorControlAbility";

			if (className.equals("IntraperitonealDelivery"))
				className = "DeliveryMethod";

			if (className.equals("SubcutaneousDelivery"))
				className = "SubcutaneousLocation";

			if (className.equals("IntramuscularDelivery"))
				className = "IntramuscularLocation";

			if (className.equals("TailVeinDelivery"))
				className = "TailVeinLocation";

			className = JavaClassNamingTools.normalizeClassName(className);

			return (Class<ISCIOThing>) Class
					.forName(OntologyEnvironment.getInstance().getBasePackage() + "classes." + className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			missing = true;
		}
		return null;
	}
}
