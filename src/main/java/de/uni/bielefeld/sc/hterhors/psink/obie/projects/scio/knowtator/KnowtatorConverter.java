package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator;

//import static de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.KnowtatorDataReader.data;
//import static de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.KnowtatorDataReader.dataValues;
//import static de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.KnowtatorDataReader.results;
//import static de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.KnowtatorDataReader.spanValues;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.JavaClassNamingTools;
import de.hterhors.obie.core.tools.corpus.CorpusFileTools;
import de.hterhors.obie.core.tools.corpus.OBIECorpus;
import de.hterhors.obie.core.tools.corpus.OBIECorpus.Instance;
import de.hterhors.obie.core.utils.ToStringFormatter;
import de.hterhors.obie.ml.dtinterpreter.IDatatypeInterpretation;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.SlotFillingProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SCIOSemanticInterpreter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container.EKnowtatorAnnotator;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container.KnowtatorSpan;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container.UniqueAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Compression;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Experiment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.ExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GuineaPigModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MouseModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Publication;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Result;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IResult;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

/**
 * Converts the Knowtator-Annotations into the current SCIO Java-Classes.
 * 
 * 
 * @author hterhors
 *
 *         Jul 19, 2016
 */
@Deprecated
public class KnowtatorConverter {
//
//	/**
//	 * The annotation-corpus of the first annotator brigitte.
//	 */
//	private Map<String, List<IResult>> brigitteSCIOCorpus = new HashMap<>();
//
//	/**
//	 * The annotation-corpus of the second annotator daniel.
//	 */
//	private Map<String, List<IResult>> danielSCIOCorpus = new HashMap<>();
//
//	public static void main(String[] args) throws IOException {
//		new KnowtatorConverter();
//	}
//
//	public KnowtatorConverter() throws FileNotFoundException, IOException {
//		/*
//		 * Initialize and convert all Knowtator annotations into java
//		 * HashMap-constructs. We use static imports to get all requiered data from the
//		 * conversion.
//		 */
//		KnowtatorDataReader.read();
//		convert();
//
//		writeDataAsJavaBinaryToFile(danielSCIOCorpus, EKnowtatorAnnotator.Daniel);
//		writeDataAsJavaBinaryToFile(brigitteSCIOCorpus, EKnowtatorAnnotator.Brigitte);
//
//		writeDataAsRDFToFile(danielSCIOCorpus, EKnowtatorAnnotator.Daniel);
//		writeDataAsRDFToFile(brigitteSCIOCorpus, EKnowtatorAnnotator.Brigitte);
//
//		writeDataAsPlainTextToFile(danielSCIOCorpus, EKnowtatorAnnotator.Daniel);
//		writeDataAsPlainTextToFile(brigitteSCIOCorpus, EKnowtatorAnnotator.Brigitte);
//
//	}
//
//	private void writeDataAsPlainTextToFile(Map<String, List<IResult>> SCIOCorpus, final EKnowtatorAnnotator annotator)
//			throws FileNotFoundException {
//
//		PrintStream ps = new PrintStream("scio/knowtator/gen/" + annotator.name().toLowerCase() + ".txt");
//
//		SCIOCorpus.values().stream().flatMap(l -> l.stream()).map(r -> ToStringFormatter.formatString(r.toString()))
//				.forEach(ps::println);
//
//		ps.close();
//	}
//
//	private void writeDataAsRDFToFile(Map<String, List<IResult>> SCIOCorpus, final EKnowtatorAnnotator annotator)
//			throws FileNotFoundException {
//
//		Model model = ModelFactory.createDefaultModel();
//
//		for (String publicationID : SCIOCorpus.keySet()) {
//			Publication publication = new Publication();
//			publication.addDescribesExperiment(new Experiment());
//			for (IResult result : SCIOCorpus.get(publicationID)) {
//				publication.getDescribesExperiments().get(0).addResult(result);
//			}
//			System.out.println("publicationID = " + publicationID);
//			model.add(publication.getRDFModel(publicationID));
//		}
//		RDFDataMgr.write(new BufferedOutputStream(
//				new FileOutputStream(new File("scio/knowtator/gen/" + annotator.name().toLowerCase() + "_full25_v"
//						+ OntologyEnvironment.getInstance().getOntologyVersion() + "."
//						+ Lang.NT.getName().toLowerCase()))),
//				model, Lang.NT);
//	}
//
//	private void writeDataAsJavaBinaryToFile(Map<String, List<IResult>> SCIOCorpus,
//			final EKnowtatorAnnotator annotator) {
//
//		Map<String, Instance> instanceCorpus = new HashMap<>();
//
//		for (Entry<String, List<IResult>> iterable_element : SCIOCorpus.entrySet()) {
//
//			String content = readContent(iterable_element.getKey());
//
//			Map<Class<? extends IOBIEThing>, List<IOBIEThing>> m = new HashMap<>();
//
//			for (IResult ir : iterable_element.getValue()) {
//				m.get(IResult.class).add(ir);
//			}
//
//			instanceCorpus.put(iterable_element.getKey(), new Instance(iterable_element.getKey(), content, m));
//		}
//
//		final String corpusPrefix = "knowtator";
//		final long ontologyVersion = OntologyEnvironment.getInstance().getOntologyVersion();
//
//		final Set<Class<? extends IOBIEThing>> rootClassTypes = new HashSet<>(Arrays.asList(IOrganismModel.class));
//
//		final File file = CorpusFileTools.buildRawCorpusFile(new File("scio/knowtator/corpora/"), corpusPrefix,
//				rootClassTypes, ontologyVersion);
//
//		new OBIECorpus(instanceCorpus, new HashMap<>(), new HashMap<>(), annotator.name().toLowerCase(),
//				OntologyEnvironment.getInstance().getOntologyVersion()).writeRawCorpusData(file);
//
//	}
//
//	private String readContent(String key) {
//
//		System.out.println("Read content for: " + key);
//
//		try {
//			BufferedReader br = new BufferedReader(
//					new InputStreamReader(new FileInputStream(new File("scio/texts/" + key)), "utf-8"));
//
//			String content = "";
//			String line = "";
//			while ((line = br.readLine()) != null) {
//				content += line + " ";
//			}
//			br.close();
//			System.out.println("Content: " + content);
//
//			return content.trim();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	/**
//	 * Increase offset and onset for all annotations after position: 32247.
//	 * 
//	 * I manually added a space char between 'male' and 'Wistar' in Ritz paper.
//	 * position: 32247 I manually added a space char between 'a' and 'microvessel'
//	 * in Ritz paper. position: 32885
//	 * 
//	 */
//	boolean FIX_RITZ_OFFSET_ERROR = false;
//
//	/**
//	 * The animal species is not annotated.
//	 */
//	boolean FIX_BOHNERT_HARTLY_SPECIES_ERROR = false;
//
//	/**
//	 * The animal geder is not annotated.
//	 */
//	boolean FIX_WELLS_MALE_ERROR = false;
//
//	/**
//	 * The [compression c]lip is annotated.
//	 */
//	boolean FIX_PINZON_COMPRESSION_C_ERROR = false;
//
//	/**
//	 * Converts the Knowtator-Data which are stored in HashMaps into
//	 * SCIO-Java-Classes using JavaReflection.
//	 * 
//	 * This method stores all SCIOAnnotations in brigitteSCIOCorpus or
//	 * danielSCIOCorpus.
//	 */
//	private void convert() {
//		for (EKnowtatorAnnotator annotator : results.keySet()) {
//
//			for (String paper : results.get(annotator).keySet()) {
//
//				brigitteSCIOCorpus.putIfAbsent(paper, new ArrayList<>());
//				danielSCIOCorpus.putIfAbsent(paper, new ArrayList<>());
//
//				FIX_RITZ_OFFSET_ERROR = annotator == EKnowtatorAnnotator.Brigitte
//						&& paper.equals("Ritz et al 2008.txt");
//				FIX_BOHNERT_HARTLY_SPECIES_ERROR = annotator == EKnowtatorAnnotator.Brigitte
//						&& paper.equals("Bohnert et al.txt");
//				FIX_WELLS_MALE_ERROR = annotator == EKnowtatorAnnotator.Brigitte && paper.equals("Wells et al.txt");
//				FIX_PINZON_COMPRESSION_C_ERROR = annotator == EKnowtatorAnnotator.Brigitte
//						&& paper.equals("Pinzon et al 2008.txt");
//
//				for (UniqueAnnotation result : results.get(annotator).get(paper)) {
//					if (data.containsKey(result)) {
//
//						boolean isValid = KnowtatorDataReader.isValidResult(result);
//						log = false;
//						final Result SCIOAnnotation = build(result, isValid);
//						if (SCIOAnnotation == null) {
//							System.err.println("Could not process result: " + result);
//							continue;
//						}
//						System.out.println("###RESULT::: " + OBIEClassFormatter.format(SCIOAnnotation));
//						System.out.println("-------------------------");
//						if (annotator == EKnowtatorAnnotator.Brigitte) {
//							brigitteSCIOCorpus.get(paper).add(SCIOAnnotation);
//						} else if (annotator == EKnowtatorAnnotator.Daniel) {
//							danielSCIOCorpus.get(paper).add(SCIOAnnotation);
//						}
//					}
//				}
//			}
//		}
//	}
//
//	/**
//	 * Entry point of the recursive method call. Returns null if any error occurs on
//	 * Java-Reflection.
//	 * 
//	 * @param resultID the root-ID from the current result.
//	 * @return a complete SCIO-Result-Object build from the data.
//	 * 
//	 */
//	private Result build(UniqueAnnotation resultID, final boolean isValid) {
//
//		try {
//			return (Result) fillData(resultID, isValid);
//		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * Creates a new SCIO-Object for the given keyID and calls it self to fill all
//	 * class-fields of the created class.
//	 * 
//	 * @param key the keyID of HashMap -data to build the corresponding SCIO-Object.
//	 * @return
//	 * @throws NoSuchFieldException
//	 * @throws SecurityException
//	 * @throws IllegalArgumentException
//	 * @throws IllegalAccessException
//	 */
//	private ISCIOThing fillData(final UniqueAnnotation key, final boolean isValid)
//			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
//
//		/*
//		 * Create ISCIOThing for key. E.g. this could be a Result, ExperimentalGroup,
//		 * WistarRatModel ...
//		 */
//		ISCIOThing c = reflectClassByName(key);
//		/*
//		 * If there is no such existing Class return null and break recursive call.
//		 */
//		if (c == null)
//			return null;
//		/*
//		 * If there is no further data available for the generated ISCIOThing return the
//		 * empty class.
//		 */
//		if (!data.containsKey(key)) {
//			// System.out.println("No additional data available for " + key);
//			return c;
//		}
//
//		if (FIX_PINZON_COMPRESSION_C_ERROR && c.getClass().getSimpleName().equals(Compression.class.getSimpleName())) {
//			Field f = getField(c, "textMention");
//			f.setAccessible(true);
//			f.set(c, "compression");
//
//			Field offsetValue = c.getClass().getDeclaredField("characterOffset");
//			offsetValue.setAccessible(true);
//			offsetValue.set(c, new Long(c.getCharacterOffset() - 2));
//		}
//
//		if (FIX_BOHNERT_HARTLY_SPECIES_ERROR
//				&& c.getClass().getSimpleName().equals(GuineaPigModel.class.getSimpleName())) {
//			Field f = getField(c, "organismSpecies");
//			f.setAccessible(true);
//			/**
//			 * TODO: HartlyGuineaPig is no more a java class but a Species with an
//			 * individual of that type. This needs to be fixed here if working with that
//			 * code.
//			 */
////			f.set(c, new HartleyGuineaPig("FIXED_BUG_ID_0", "Hartley strain"));
//			throw new NotImplementedException(
//					"HartlyGuineaPig is no more a java class but a Species with an individual of that type. This needs to be fixed here if working with that code.");
//		}
//
//		if (FIX_WELLS_MALE_ERROR && c.getClass().getSimpleName().equals(MouseModel.class.getSimpleName())) {
//			Field f = getField(c, "gender");
//			f.setAccessible(true);
//			/**
//			 * TODO: Male is no more a java class but a Gender with an individual of that
//			 * type. This needs to be fixed here if working with that code.
//			 */
//			throw new NotImplementedException(
//					"Male is no more a java class but a Gender with an individual of that type. This needs to be fixed here if working with that code.");
////			f.set(c, new Male("FIXED_BUG_ID_1", "Male"));
//		}
//		/*
//		 * For each entry in the HashMap create the corresponding field in the
//		 * ISCIOThing-Class. A RatModel for instance may have fields like, Weight, Age
//		 * etc...
//		 */
//		// if (c.getClass() == CompoundTreatment.class || c.getClass() ==
//		// SuppliedCompound.class) {
//		// System.out.println("Start : " + key + " : " +
//		// SCIOClassFormatter.format(c));
//		// }
//
//		for (Entry<String, Set<UniqueAnnotation>> q : data.get(key).entrySet()) {
//			// System.out.println("Add: " + q.getValue().size() + " to data.");
//			// q.getValue().forEach(System.out::println);
//			// System.out.println("------------------------");
//			// q.getValue().forEach(System.out::println);
//			// System.out.println("------------------------");
//			final String property = q.getKey();
//
//			/*
//			 * Get the name of the field using the name-generating-method that was used to
//			 * auto generate SCIO-Classes.
//			 */
//			final String fieldName = JavaClassNamingTools.getVariableName(property);
//
//			// if (c.getClass() == CompoundTreatment.class || c.getClass() ==
//			// SuppliedCompound.class) {
//			// System.out.println("Class = " + key + " : " +
//			// SCIOClassFormatter.format(c));
//			// System.out.println("Add property = " + fieldName);
//			// }
//
//			// if (fieldName.equals("compound")) {
//			// System.out.println("Compounds:");
//			// q.getValue().forEach(System.out::println);
//			// }
//
//			Field field = getField(c, fieldName);
//			/*
//			 * If the class does not contain the field skip current field and print error!
//			 * This case should not occur if SCIO and the Knowtator-Reader is up-to-date.
//			 */
//			if (field == null) {
//				System.err.println("No such field: " + fieldName + " in " + c.getClass().getSimpleName());
//				continue;
//			}
//
//			field.setAccessible(true);
//
//			/*
//			 * If field could successfully determined from the class, set values to field.
//			 */
//			assignValueToField(c, q.getValue(), field, isValid);
//
//		}
//		// if (log || c.getClass() == CompoundTreatment.class || c.getClass() ==
//		// SuppliedCompound.class) {
//		// System.out.println("Class after adding all properties = " + key + " :
//		// " + SCIOClassFormatter.format(c));
//		// }
//
//		return c;
//
//	}
//
//	static boolean log = false;
//
//	/**
//	 * Assign the correct value to a given field. Determines of the field is a list
//	 * or not etc.
//	 * 
//	 * @param c     the ISCIOThing class type.
//	 * @param q     the values for the field.
//	 * @param field the field.
//	 * @throws NoSuchFieldException
//	 * @throws IllegalAccessException
//	 */
//	private void assignValueToField(ISCIOThing c, Set<UniqueAnnotation> q, Field field, final boolean isValid)
//			throws NoSuchFieldException, IllegalAccessException {
//
//		/**
//		 * CHECKME: QUICKFIX: Experimental Groups are the same as GroupNames in
//		 * Knowtator. Its difficult to handle this in java. so remove all GroupNames,
//		 * they are not used anyway in this dataset...
//		 */
//
//		// if (c.getClass() == ExperimentalGroup.class &&
//		// field.getName().equals("groupNames")) {
//		// System.out.println(c.getClass().getSimpleName() + ": " + q);
//		// for (UniqueAnnotation k2 : q) {
//		// final ISCIOThing d = fillData(k2, isValid);
//		// System.out.println(d);
//		// }
//		// System.out.println("#####");
//		// return;
//		// }
//
//		if (q.size() == 1) {
//			for (UniqueAnnotation k2 : q) {
//				final ISCIOThing d = fillData(k2, isValid);
//
//				try {
//					/*
//					 * Try to set a list object
//					 */
//
//					boolean add = true;
//					if (c.getClass() == ExperimentalGroup.class) {
//						System.out.println("Assign Value to field: " + field);
//						System.out.println(d);
//						if (d.getClass() == ExperimentalGroup.class) {
//							add = false;
//						}
//					}
//					if (add)
//						field.set(c, d);
//					// if (c.getClass() == CompoundTreatment.class ||
//					// c.getClass() == SuppliedCompound.class)
//					// System.out.println("Assigned Value to field: " +
//					// SCIOClassFormatter.format(c, true));
//				} catch (IllegalArgumentException iae) {
//					if (!d.getClass().getSimpleName().equals(GroupName.class.getSimpleName())) {
//						// System.err.println(
//						// "Field is of type list. Put " + d.getResourceName() +
//						// " into single element list: "
//						// + field.getName() + " for " +
//						// c.getClass().getSimpleName());
//						System.err.println("Could not set " + d.getClass().getSimpleName() + " in "
//								+ c.getClass().getSimpleName() + " try as list...");
//						try {
//							field.set(c, Arrays.asList(new ISCIOThing[] { d }));
//						} catch (IllegalArgumentException e) {
//							System.out.println("Type in List: " + d + " can not be set. Set value to null.");
//							e.printStackTrace();
//							field.set(c, null);
//						}
//
//					} else {
//						field.set(c, new ArrayList<>());
//					}
//				}
//			}
//		} else {
//			final Set<ISCIOThing> l = new HashSet<>();
//			ISCIOThing empty = null;
//			for (UniqueAnnotation k2 : q) {
//				ISCIOThing sc = fillData(k2, isValid);
//				if (sc != null && !sc.isEmpty())
//					l.add(sc);
//				else {
//					empty = sc;
//					System.err.println("Null or Empty " + (sc == null ? "null" : sc.getClass().getSimpleName())
//							+ ". Did not add to list.");
//				}
//			}
//			/*
//			 * Add empty class if all classes where empty.
//			 */
//			if (l.size() == 0)
//				l.add(empty);
//			try {
//				boolean add = true;
//				if (c.getClass() == ExperimentalGroup.class) {
//					System.out.println("Assign Value to field: " + field);
//					System.out.println(l);
//					if (new ArrayList<>(l).get(0).getClass() == ExperimentalGroup.class) {
//						add = false;
//					}
//				}
//
//				/*
//				 * Try to set a list object
//				 */
//				if (add)
//					field.set(c, new ArrayList<>(l));
//			} catch (IllegalArgumentException iae) {
//				// System.err.println("Field is not a list: " + l + " does not
//				// fit into " + field.getName() + " for "
//				// + c.getClass().getSimpleName());
//				try {
//					field.set(c, new ArrayList<>(l).get(0));
//					if (l.size() != 1)
//						System.err.println("WARN! Could not add as list. Take first of : " + l.size()
//								+ " but maybe thats not correct!");
//					l.forEach(System.err::println);
//				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
//					field.set(c, null);
//				}
//			}
//		}
//	}
//
//	/**
//	 * Retrieves the actual field for the given name in the given ISCIOThing class.
//	 * 
//	 * @param c         the ISCIOThing class type.
//	 * @param fieldName the name of the field.
//	 * @return the field with the corresponding fieldName.
//	 */
//	private Field getField(ISCIOThing c, final String fieldName) {
//		Field field;
//		try {
//			/*
//			 * Try if the class contains the field with the name.
//			 */
//			field = c.getClass().getDeclaredField(fieldName);
//		} catch (NoSuchFieldException nsfe) {
//			try {
//				/*
//				 * If not try with an additional "s" for lists and sets.
//				 */
//				field = c.getClass().getDeclaredField(fieldName + "s");
//			} catch (NoSuchFieldException ex) {
//				field = null;
//			}
//		}
//		return field;
//	}
//
//	/**
//	 * Try to find a corresponding SCIO-Class that corresponds to the Object in the
//	 * data for the given key.
//	 * 
//	 * @param key of the class.
//	 * @return
//	 */
//	private ISCIOThing reflectClassByName(final UniqueAnnotation key) {
//
//		ISCIOThing id = null;
//		try {
//			id = (ISCIOThing) Class.forName(
//					OntologyEnvironment.getInstance().OBIE_CLASSES_PACKAGE_NAME + key.classType.trim())
//					.newInstance();
//
//			/*
//			 * If reflection was successful fill standard fields like, value, mention and
//			 * character offsets.
//			 */
//			final String mention;
//			/*
//			 * Each SCIO-Class has the mention Field.
//			 */
//			if (dataValues.containsKey(key)) {
//				mention = dataValues.get(key);
//			} else {
//				mention = null;
//			}
//			Field annotationIDField = id.getClass().getDeclaredField("annotationID");
//			annotationIDField.setAccessible(true);
//			annotationIDField.set(id,
//					key.paperID + "-" + key.annotator.name() + "-" + key.id.replaceAll("SCIO4.25_Instance_", ""));
//
//			if (mention != null) {
//
//				Field mentionField = id.getClass().getDeclaredField("textMention");
//				mentionField.setAccessible(true);
//				mentionField.set(id, mention);
//
//				if (id.getClass().isAnnotationPresent(DatatypeProperty.class)) {
//
//					/*
//					 * Only SCIO-Classes that are inferred by a OWL-DatatypeProperty have the value
//					 * field. ( If the Property was not explicitly set in OWL.
//					 */
//					Field valueField = id.getClass().getDeclaredField("semanticValue");
//					valueField.setAccessible(true);
//					String value = mention;
//					System.out.println("mention = " + mention);
//					IDatatypeInterpretation dt = SCIOSemanticInterpreter.getInstance().interpret(id.getClass(),
//							mention);
//					System.out.println("interpretation: " + dt);
//
//					if (dt != null) {
//						value = dt.asFormattedString();
//					}
//					System.out.println("#" + id.getClass().getSimpleName() + ": " + mention + " -> " + value);
//
//					valueField.set(id, value);
//
//				}
//
//			}
//			/*
//			 * Get corresponding spanValues for the key.
//			 */
//			final List<KnowtatorSpan> spans = spanValues.get(key);
//
//			if (spans != null) {
//
//				/*
//				 * Fill fields if spans exist.
//				 */
//				for (KnowtatorSpan knowtatorSpan : spans) {
//
//					Field offsetValue = id.getClass().getDeclaredField("characterOffset");
//					offsetValue.setAccessible(true);
//					long addToOffset = 0;
//					if (FIX_RITZ_OFFSET_ERROR && knowtatorSpan.onset >= 32247) {
//						addToOffset++;
//					}
//					if (FIX_RITZ_OFFSET_ERROR && knowtatorSpan.onset >= 32884 - addToOffset) {
//						addToOffset++;
//					}
//					offsetValue.set(id, new Long(knowtatorSpan.offset + addToOffset));
//
//					Field onsetValue = id.getClass().getDeclaredField("characterOnset");
//					onsetValue.setAccessible(true);
//					onsetValue.set(id, new Long(knowtatorSpan.onset + addToOffset));
//
//				}
//			}
//
//			return id;
//
//		} catch (ClassCastException | ClassNotFoundException | InstantiationException | IllegalAccessException
//				| IllegalArgumentException | SecurityException e) {
//			e.printStackTrace();
//			System.err.println("Could not map class name: " + key);
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}

}
