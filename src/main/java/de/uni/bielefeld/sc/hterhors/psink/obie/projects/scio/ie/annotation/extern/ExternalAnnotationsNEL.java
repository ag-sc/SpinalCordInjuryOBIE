package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.annotation.extern;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;

import de.hterhors.obie.core.OntologyAnalyzer;
import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.IndividualFactory;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.core.ontology.ReflectionUtils;
import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.JavaClassNamingTools;
import de.hterhors.obie.ml.dtinterpreter.IDatatypeInterpretation;
import de.hterhors.obie.ml.dtinterpreter.IDatatypeInterpreter;
import de.hterhors.obie.ml.ner.INamedEntitityLinker;
import de.hterhors.obie.ml.ner.NERLClassAnnotation;
import de.hterhors.obie.ml.ner.NERLIndividualAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.RDFRelatedAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;

/**
 * Loads annotations from an external resource.
 * 
 * @author hterhors
 *
 * @param <T>
 */
public class ExternalAnnotationsNEL<T extends IOBIEThing> implements INamedEntitityLinker {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final private File externalResourceDir;
	final private Class<? extends IOBIEThing> clazz;
	final private IDatatypeInterpreter<T> interpreter;
	final private Set<Class<? extends IOBIEThing>> classTypes;
	final private String annotator = "system";

	public ExternalAnnotationsNEL(Class<? extends T> clazz, IDatatypeInterpreter<T> interpreter,
			final File externalResource) throws Exception {
		this.externalResourceDir = externalResource;
		this.clazz = clazz;
		this.interpreter = interpreter;
		this.classTypes = OntologyAnalyzer.getRelatedClassTypesUnderRoot(clazz);
	}

	public static final Pattern nameSpaceExtractor = Pattern.compile("(<(http:.*)/([^/]*)>)|(.+)");

	private static final String PREFIX = OntologyEnvironment.getInstance().getBasePackage() + "classes.";

	@Override
	public Map<Class<? extends IOBIEThing>, Set<NERLClassAnnotation>> annotateClasses(String instanceName,
			String content) {
		try {

			Map<Class<? extends IOBIEThing>, Set<NERLClassAnnotation>> annotations = new HashMap<>();

			File annotationFile = new File(externalResourceDir + instanceName + "_" + annotator + ".annodb");

			for (RDFRelatedAnnotation rdfRelatedAnnotation : readAnnotations(annotationFile)) {

				final String className = rdfRelatedAnnotation.annotationID;

				try {
					/*
					 * Is a class
					 */
					@SuppressWarnings("unchecked")
					final Class<? extends T> dataClassType = (Class<? extends T>) Class
							.forName(PREFIX + JavaClassNamingTools.normalizeClassName(className));

					if (!classTypes.contains(dataClassType))
						continue;

					annotations.putIfAbsent(dataClassType, new HashSet<>());

					boolean dt = dataClassType.isAnnotationPresent(DatatypeProperty.class);

					final IDatatypeInterpretation semanticInterpretation;

					if (dt) {
						semanticInterpretation = interpreter.interpret(dataClassType, rdfRelatedAnnotation.textMention);
					} else {
						semanticInterpretation = null;
					}

					NERLClassAnnotation e = new NERLClassAnnotation(rdfRelatedAnnotation.textMention,
							rdfRelatedAnnotation.onset, dataClassType, semanticInterpretation);
					annotations.get(dataClassType).add(e);
				} catch (ClassNotFoundException e) {
					/*
					 * Is an individual
					 */
				}

			}
			return annotations;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<AbstractIndividual, Set<NERLIndividualAnnotation>> annotateIndividuals(String instanceName,
			String content) {
		try {
			Map<AbstractIndividual, Set<NERLIndividualAnnotation>> annotations = new HashMap<>();
			File annotationFile = new File(externalResourceDir + instanceName + "_" + annotator + ".annodb");

			for (RDFRelatedAnnotation rdfRelatedAnnotation : readAnnotations(annotationFile)) {

				final String individualName = rdfRelatedAnnotation.annotationID;

				/*
				 * Is an individual
				 */

				for (Class<? extends IOBIEThing> classType : OntologyAnalyzer.getRelatedClassTypesUnderRoot(clazz)) {
					try {
						if (classType.isAnnotationPresent(DatatypeProperty.class)) {
							continue;
						}

						@SuppressWarnings("unchecked")
						final Collection<AbstractIndividual> individuals = ((IndividualFactory<AbstractIndividual>) ReflectionUtils
								.getAccessibleFieldByName(classType, OntologyInitializer.INDIVIDUAL_FACTORY_FIELD_NAME)
								.get(null)).getIndividuals();

						for (AbstractIndividual individual : individuals) {

							if (individual.name.equals(individualName)) {

								NERLIndividualAnnotation a = new NERLIndividualAnnotation(
										rdfRelatedAnnotation.textMention, rdfRelatedAnnotation.onset, individual);

								annotations.putIfAbsent(individual, new HashSet<>());

								annotations.get(individual).add(a);
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
			return annotations;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<RDFRelatedAnnotation> readAnnotations(File annotationFile) throws IOException {
		CSVReader reader = null;

		List<RDFRelatedAnnotation> ret = new ArrayList<>();
		try {
			reader = new CSVReader(new FileReader(annotationFile));
			String[] line;
			while ((line = reader.readNext()) != null) {

				if (line.length == 1 && line[0].isEmpty() || line[0].startsWith("#"))
					continue;

				final String subject = line[1].trim();
				final int onset = Integer.parseInt(line[2].trim());
				final String text = line[4].trim();

				ret.add(new RDFRelatedAnnotation(text, onset, 0, subject, null));

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				reader.close();
		}
		return ret;
	}

}
