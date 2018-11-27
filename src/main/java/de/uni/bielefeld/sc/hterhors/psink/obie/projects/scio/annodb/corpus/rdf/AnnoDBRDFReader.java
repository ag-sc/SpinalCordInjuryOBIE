package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.PortableServer.IMPLICIT_ACTIVATION_POLICY_ID;

import com.opencsv.CSVReader;

import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.annotations.ImplementationClass;
import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.JavaClassNamingTools;
import de.hterhors.obie.core.utils.AnnotationExtractorHelper;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.hterhors.obie.ml.variables.TemplateAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.RDFRelatedAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.Triple;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOOntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SCIOSemanticInterpreter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnalyzedExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Dosage;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DosageExtracorporal;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DosageIntracorporal;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IResult;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

/**
 * // * cd /var/www/html/annodb-interface/ php php/cli_export.php ~/zielordner
 * 
 * @author hterhors
 *
 * @param <R>
 * @date May 24, 2018
 */

public class AnnoDBRDFReader<R extends ISCIOThing> {

	public static final String SCIO_NAMESPACE = "http://psink.de/scio";
	public static final String RDF_TYPE_NAMESPACE = "<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>";
	public static final String DATA_NAMESPACE = "http://scio/data";

	public static final Pattern nameSpaceExtractor = Pattern.compile("(<(http:.*)/([^/]*)>)|(.+)");
	public static final Pattern tripleExtractor = Pattern
			.compile("(<http:.*?/[^/]*?>) (<http:.*?/[^/]*?>) ((<http:.*?/[^/]*?>)|\"(.*?)\") ?\\.");

	/*
	 * This should be the most upper class of interest e.g. OrganismModel, Injury,
	 * Treatment, InvestigationMethod...
	 */
	private static final String PREFIX = SCIOOntologyEnvironment.getInstance().getBasePackage() + "classes.";
	private static final String RDF_LABEL = "<http://www.w3.org/2000/01/rdf-schema#label>";
	/*
	 * Do not read triples with properties that are in this list.
	 */
	private static final Set<String> skipProperties = new HashSet<>(Arrays.asList(RDF_LABEL));

	private static final int ANNOTATION_ID_INDEX = 0;
	private static final int CLASS_TYPE_INDEX = 1;
	private static final int ONSET_INDEX = 2;
	private static final int OFFSET_INDEX = 3;
	private static final int TEXT_MENTION_INDEX = 4;
	private static final int META_INDEX = 5;
	private static final int RDF_LINK_INDEX = 6;

	private static final int INSTANCE_LINK_INDEX = 2;
	private static final int PARENT_INSTANCE_LINK_INDEX = 0;
	private static final int PARENT_RELATION_LINK_INDEX = 1;

	private final Map<String, Map<String, Set<String>>> triples = new HashMap<>();

	private final Map<Triple, RDFRelatedAnnotation> annotations = new HashMap<>();

	private final Set<String> rootDataPoints = new HashSet<>();

	public static void main(String[] args) throws Exception {

		// File annotationFile = new File("scio/annodb/N001 Yoo, Khaled et al.
		// 2013_Jessica.annodb");
		// File rdfFile = new File("scio/annodb/N001 Yoo, Khaled et al.
		// 2013_Jessica.n-triples");

		// File annotationFile = new File("scio/annodb/N131 Boyd
		// 2004_Jessica.annodb");
		// File rdfFile = new File("scio/annodb/N131 Boyd
		// 2004_Jessica.n-triples");

		// File annotationFile = new File("scio/annodb/N136 Centenaro
		// 2011_Jessica.annodb");
		// File rdfFile = new File("scio/annodb/N136 Centenaro
		// 2011_Jessica.n-triples");
		File annotationFile = new File("annodb_05072018/N187 Nash 2002_Jessica.annodb");
		File rdfFile = new File("annodb_05072018/N187 Nash 2002_Jessica.n-triples");
		// File annotationFile = new
		// File("knowtator/gen/brigitte_full25_v62.n-triples");
		// File rdfFile = new
		// File("knowtator/gen/brigitte_full25_v62.n-triples");

		for (IInjury x : new AnnoDBRDFReader<IInjury>(IInjury.class, rdfFile, annotationFile).get()) {
			System.out.println(OBIEClassFormatter.format(x, true));
		}
		// for (IOrganismModel x : new
		// AnnoDBRDFSCIOReader<IOrganismModel>(IOrganismModel.class, rdfFile,
		// annotationFile)
		// .get()) {
		// System.out.println(OBIEFormatter.format(x, true));
		// }

	}

	final private Set<R> things = new HashSet<>();

	public AnnoDBRDFReader(Class<? extends IOBIEThing> domainSuperClass, File rdfFile, File annotationFile)
			throws Exception {

//		System.out.println("----------Annotations----------");
		readAnnotations(annotationFile);
//		annotations.entrySet().forEach(System.out::println);

//		System.out.println("----------Triples----------");
		readTriples(rdfFile);
//		triples.entrySet().forEach(System.out::println);

//		System.out.println("----------Root Data Points----------");
		getRootDataPoints(domainSuperClass);
//		rootDataPoints.forEach(System.out::println);

		for (String rootDataPoint : rootDataPoints) {
//			 System.out.println("Root data point: " + rootDataPoint);

			final String object = triples.get(rootDataPoint).get(RDF_TYPE_NAMESPACE).iterator().next();
			/*
			 * TODO: Assume that there is only one rdf#type!
			 */
			final Triple linkedID = new Triple(rootDataPoint, RDF_TYPE_NAMESPACE, object);

			final ISCIOThing dataPoint;

			final RDFRelatedAnnotation annotation = annotations.get(linkedID);

			if (annotation == null) {
				@SuppressWarnings("unchecked")
				Class<ISCIOThing> classType = (Class<ISCIOThing>) Class
						.forName(PREFIX + JavaClassNamingTools.normalizeClassName(getResource(object)));
				dataPoint = classType.newInstance();
			} else {

				Class<ISCIOThing> classType;
//				System.out.println(linkedID);

				String individual = null;
				try {
					/**
					 * TODO: do not try and catch but know through OWLReader or something.
					 */
					/*
					 * Is a class
					 */
					classType = (Class<ISCIOThing>) Class
							.forName(PREFIX + JavaClassNamingTools.normalizeClassName(getResource(linkedID.object)));

				} catch (ClassNotFoundException e) {
					/*
					 * Is an individual
					 */

					individual = linkedID.object.substring(1, linkedID.object.length() - 1);

					classType = getClassTypeForIndividual((Class<ISCIOThing>) domainSuperClass, individual);

				}

				dataPoint = classType.getConstructor(String.class, String.class).newInstance(individual,
						annotation.textMention);
				dataPoint.setCharacterOnset(annotation.onset);
			}
			things.add((R) buildJavaBinRec(dataPoint, rootDataPoint));
		}
		System.out.println("--------------------");

	}

	/**
	 * Extracts the root data point from the triples.
	 * 
	 * @param domainSuperClass
	 */
	private void getRootDataPoints(Class<? extends IOBIEThing> domainSuperClass) {
		for (Entry<String, Map<String, Set<String>>> triple : triples.entrySet()) {
			for (Entry<String, Set<String>> predObj : triple.getValue().entrySet()) {

				if (!predObj.getKey().equals(RDF_TYPE_NAMESPACE))
					continue;

				for (String object : predObj.getValue()) {
					try {
						@SuppressWarnings("unchecked")
						Class<? extends IOBIEThing> objectClassType = (Class<? extends IOBIEThing>) Class
								.forName(PREFIX + getResource(object));
						if (domainSuperClass.isAssignableFrom(objectClassType)) {
							rootDataPoints.add(triple.getKey());
						}
					} catch (ClassNotFoundException e) {
					}

				}
			}
		}
	}

	public Set<R> get() {
		return things;

	}

	/**
	 * Extract training instances for the SCIO-OrganismModel class. IOrganismModel
	 * must be assignable by the given generic type t.
	 * 
	 * @param result
	 * @param t
	 * @return
	 */
	private Set<TemplateAnnotation> extractAnimalModels(List<IResult> scioAnnotationInstance, final int limit) {

		Set<TemplateAnnotation> internalAnnotations = new HashSet<>();

		Set<IOrganismModel> annotations = new HashSet<>();

		for (IResult r : scioAnnotationInstance) {

			if (r.getReferenceExperimentalGroup() == null)
				continue;
			if (r.getTargetExperimentalGroup() == null)
				continue;

			IOrganismModel referenceOrganismModel = r.getReferenceExperimentalGroup().getOrganismModel();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IOrganismModel.class, referenceOrganismModel))
				annotations.add((IOrganismModel) referenceOrganismModel);

			IOrganismModel targetAnimalModel = (IOrganismModel) r.getTargetExperimentalGroup().getOrganismModel();

			if (AnnotationExtractorHelper.isAssignAbleFrom(IOrganismModel.class, targetAnimalModel))
				annotations.add(targetAnimalModel);

			if (r.getReferenceExperimentalGroup() instanceof AnalyzedExperimentalGroup)
				for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) r.getReferenceExperimentalGroup())
						.getMemberDefinedExperimentalGroups()) {
					if (AnnotationExtractorHelper.isAssignAbleFrom(IOrganismModel.class, expGroup.getOrganismModel()))
						annotations.add((IOrganismModel) expGroup.getOrganismModel());
				}

			if (r.getTargetExperimentalGroup() instanceof AnalyzedExperimentalGroup)
				for (IExperimentalGroup expGroup : ((AnalyzedExperimentalGroup) r.getTargetExperimentalGroup())
						.getMemberDefinedExperimentalGroups()) {
					if (AnnotationExtractorHelper.isAssignAbleFrom(IOrganismModel.class, expGroup.getOrganismModel()))
						annotations.add((IOrganismModel) expGroup.getOrganismModel());
				}

		}
		for (IOrganismModel annotation : annotations) {
			if (annotation == null)
				continue;

			if (internalAnnotations.size() == limit) {
				return new HashSet<>();
			}
			if (!AnnotationExtractorHelper.testLimitToAnnnotationElementsRecursively(annotation, limit)) {
				return new HashSet<>();
			}
			TemplateAnnotation entity = new TemplateAnnotation(IOrganismModel.class, annotation);
			internalAnnotations.add(entity);
		}
		return internalAnnotations;
	}

	private void readAnnotations(File annotationFile) throws IOException {
		// System.out.println(annotationFile);
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(annotationFile));
			String[] line;
			while ((line = reader.readNext()) != null) {

				if (line.length == 1 && line[0].isEmpty() || line[0].startsWith("#"))
					continue;

				if (!line[RDF_LINK_INDEX].trim().isEmpty()) {

					final Matcher m = tripleExtractor.matcher(line[RDF_LINK_INDEX]);
					while (m.find()) {
						final String subject = m.group(1);
						final String predicate = m.group(2);
						final String object = m.group(5) == null ? m.group(4) : m.group(5);
//
//							Class<? extends IOBIEThing> classType = (Class<? extends IOBIEThing>) Class
//									.forName(PREFIX + line[CLASS_TYPE_INDEX].trim());

						final Triple linkID = new Triple(subject, predicate, object);
						annotations.put(linkID, new RDFRelatedAnnotation(line[TEXT_MENTION_INDEX].trim(),
								Integer.parseInt(line[ONSET_INDEX].trim()), Integer.parseInt(line[OFFSET_INDEX].trim()),
								line[ANNOTATION_ID_INDEX].trim(), linkID));

					}
				} else {
					/*
					 * No RDF related annotation found.
					 */
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	private ISCIOThing buildJavaBinRec(final ISCIOThing object, String subject) throws Exception {
		/*
		 * Read rdf type separately to create new instance.
		 */

		// System.out.println("object: " + object.getClass().getSimpleName() +
		// ":: " + rdfName);
		for (Entry<String, Set<String>> props : triples.get(subject).entrySet()) {
			// System.out.println("props: " + props);

			/*
			 * Do not read root rdf-type again.
			 */
			if (props.getKey().equals(RDF_TYPE_NAMESPACE))
				continue;
//			final 
			String slotOntologyName = getOntologyName(props.getKey());

			/**
			 * QUICK FIX:
			 */

			if (slotOntologyName.equals("http://psink.de/scio/hasTreatmentLocation"))
				slotOntologyName = "http://psink.de/scio/hasLocation";

//			System.out.println(ontologyName);

			final Field f = getFieldByOntologyName(object.getClass().getDeclaredFields(), slotOntologyName);
			if (f == null)
				System.out.println(slotOntologyName + " in " + object.getClass().getSimpleName());
			f.setAccessible(true);

			/*
			 * Get all values.
			 */
			List<ISCIOThing> values = extractValuesFromPredicates(subject, f, props);
//			System.out.println("object: " + object.getClass().getSimpleName() + ":: " + rdfName);
//			System.out.println("props = " + props);
			if (props.getValue().size() != 0) {

				if (f.isAnnotationPresent(RelationTypeCollection.class)) {
					/*
					 * WARN! TYPE check.
					 */
					f.set(object, values);
				} else {
					if (props.getValue().size() > 1) {
						System.out.println("oject: " + object + "values: ");
						values.forEach(System.out::println);
						throw new IllegalArgumentException("Can not add list of objetcs to non-OneToMany property.");
					} else {
						/*
						 * If there is only one object
						 */
						f.set(object, values.get(0));
					}
				}
			} else {
				/*
				 * No data available.
				 */
			}
		}
		return object;
	}

	/**
	 * Remove the triples < > symbols.
	 * 
	 * @param key
	 * @return
	 */
	private String getOntologyName(String key) {
		return key.substring(1, key.length() - 1);
	}

	/**
	 * Get the filed of that ontology class with the given ontolgy name of the
	 * property.
	 * 
	 * @param fields
	 * @param fullName
	 * @return
	 */
	private Field getFieldByOntologyName(Field[] fields, String fullName) {
		for (Field field : fields) {
			if (!field.isAnnotationPresent(OntologyModelContent.class))
				continue;
			if (field.getAnnotation(OntologyModelContent.class).ontologyName().equals(fullName))
				return field;
		}
		return null;
	}

	private List<ISCIOThing> extractValuesFromPredicates(String subject, Field slot,
			Entry<String, Set<String>> predicates) throws Exception {
		List<ISCIOThing> predicateValues = new ArrayList<>();

		for (String object : predicates.getValue()) {
			// System.out.println("object = " + object);
			final String nameSpace = getNameSpace(object);

			if (object.isEmpty()) {
				throw new IllegalStateException("Object of triple is empty!");
			}

			final Triple linkedID = new Triple(subject, predicates.getKey(), object);

			if (nameSpace == null) {
				// System.out.println(linkedID);
				final ISCIOThing dataTypeThing = toDatatypeValue(slot, linkedID);
				predicateValues.add(dataTypeThing);
			} else if (nameSpace.equals(SCIO_NAMESPACE)) {
				ISCIOThing instanceThing = toInstanceValue(slot, linkedID);
				predicateValues.add(instanceThing);
			} else if (nameSpace.equals(DATA_NAMESPACE)) {
				ISCIOThing scioDataThing = toDataPointValue(slot, linkedID);
				predicateValues.add(buildJavaBinRec(scioDataThing, linkedID.object));
			}

		}
		return predicateValues;
	}

	/**
	 * Converts the given object string into a data point class. This class is
	 * filled recursively.
	 * 
	 * @param object
	 * @param linkedID
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private ISCIOThing toDataPointValue(Field slot, Triple linkedID) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		System.out.println(slot + "--" + linkedID);

		/*
		 * Data point
		 */
		final String objectType = triples.get(linkedID.object).get(RDF_TYPE_NAMESPACE).iterator().next();

		@SuppressWarnings("unchecked")
		final Class<ISCIOThing> dataClassType = (Class<ISCIOThing>) Class
				.forName(PREFIX + JavaClassNamingTools.normalizeClassName(getResource(objectType)));

		final String individual = null;

		ISCIOThing scioDataThing;
		if (annotations.containsKey(linkedID)) {
			scioDataThing = dataClassType.getConstructor(String.class, String.class).newInstance(individual,
					annotations.get(linkedID).textMention);
			scioDataThing.setCharacterOnset(annotations.get(linkedID).onset);
//			scioDataThing.setCharacterOffset(annotations.get(linkedID).offset);
		} else {
			scioDataThing = dataClassType.newInstance();
		}
		return scioDataThing;
	}

	@SuppressWarnings("unchecked")
	private ISCIOThing toInstanceValue(Field slot, final Triple linkedID)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		System.out.println(slot + "--" + linkedID);

		/*
		 * Ontology type
		 */

		Class<ISCIOThing> scioClassType;
		String individual = null;
		try {
			/**
			 * TODO: do not try and catch but know through OWLReader or something.
			 */
			/*
			 * Is a class
			 */
			scioClassType = (Class<ISCIOThing>) Class
					.forName(PREFIX + JavaClassNamingTools.normalizeClassName(getResource(linkedID.object)));
		} catch (ClassNotFoundException e) {
			/*
			 * Is an individual
			 */

			individual = linkedID.object.substring(1, linkedID.object.length() - 1);

			if (slot.isAnnotationPresent(RelationTypeCollection.class)) {

				Class<? extends IOBIEThing> slotSuperType = ((Class<? extends IOBIEThing>) ((ParameterizedType) slot
						.getGenericType()).getActualTypeArguments()[0]);

				scioClassType = getClassTypeForIndividual(
						(Class<ISCIOThing>) slotSuperType.getAnnotation(ImplementationClass.class).get(), individual);
			} else {

				scioClassType = getClassTypeForIndividual(
						(Class<ISCIOThing>) slot.getType().getAnnotation(ImplementationClass.class).get(), individual);
			}

		}

		ISCIOThing instanceThing;
		final String textmention;
		if (annotations.containsKey(linkedID)) {
			textmention = annotations.get(linkedID).textMention;
		} else {
			textmention = null;
		}
		instanceThing = scioClassType.getConstructor(String.class, String.class).newInstance(individual, textmention);

		if (annotations.containsKey(linkedID))
			instanceThing.setCharacterOnset(annotations.get(linkedID).onset);

		return instanceThing;
	}

	private Class<ISCIOThing> getClassTypeForIndividual(Class<ISCIOThing> scioClassType, String individual)
			throws InstantiationException, IllegalAccessException {

		if (scioClassType.newInstance().getIndividualFactory().getIndividualURIs().contains(individual)) {

		} else {

			for (Class<? extends IOBIEThing> asssc : scioClassType.getAnnotation(AssignableSubClasses.class).get()) {

				if (asssc.newInstance().getIndividualFactory().getIndividualURIs().contains(individual)) {
					scioClassType = (Class<ISCIOThing>) asssc;
					break;

				}
			}

		}
		return scioClassType;
	}

	private ISCIOThing toDatatypeValue(Field slot, final Triple linkedID)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		System.out.println(slot + "--" + linkedID);
		/*
		 * Data type Property
		 */
		@SuppressWarnings("unchecked")
		Class<? extends ISCIOThing> dataTypeClassType = (Class<? extends ISCIOThing>) slot.getType()
				.getAnnotation(ImplementationClass.class).get();

		/*
		 * TODO: quick fix
		 */
		if (dataTypeClassType.equals(DosageIntracorporal.class) || dataTypeClassType.equals(DosageExtracorporal.class))
			dataTypeClassType = Dosage.class;

		final ISCIOThing dataTypeThing = dataTypeClassType.getConstructor(String.class, String.class)
				.newInstance(getSemantics(dataTypeClassType, linkedID.object), linkedID.object);

		if (annotations.containsKey(linkedID)) {
			dataTypeThing.setCharacterOnset(annotations.get(linkedID).onset);
//			dataTypeThing.setCharacterOffset(annotations.get(linkedID).offset);
		}
		return dataTypeThing;
	}

	private String getNameSpace(String uri) {

		if (uri.isEmpty()) {
			throw new IllegalStateException("Value of property is empty!");
		}

		Matcher m = nameSpaceExtractor.matcher(uri);
		m.find();
		return m.group(4) == null ? m.group(2) : null;
	}

	private String getResource(String uri) {
		Matcher m = nameSpaceExtractor.matcher(uri);
		m.find();
		return m.group(4) == null ? m.group(3) : m.group(4);
	}

	private String getSemantics(Class<? extends ISCIOThing> classType, String textMention) {
		return SCIOSemanticInterpreter.getInstance().interpret(classType, textMention).asFormattedString();
	}

	/**
	 * Checks and reads triple from a file.
	 * 
	 * @param inputFile
	 * @throws IOException
	 */
	private void readTriples(File inputFile) throws IOException {

		Files.readAllLines(inputFile.toPath()).stream().forEach(l -> {
			Matcher m = tripleExtractor.matcher(l);
			if (m.find()) {

				String domain = m.group(1);
				String property = m.group(2);

				if (!skipProperties.contains(property)) {

					// Group 4 is the value of the data type property WITHOUT "
					String range = m.group(5) == null ? m.group(4) : m.group(5);
					triples.putIfAbsent(domain, new HashMap<>());
					triples.get(domain).putIfAbsent(property, new HashSet<>());
					triples.get(domain).get(property).add(range);

				}
			}

		});
	}

}
