package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.pdfToText.WordMetric;
import de.hterhors.obie.ml.ner.NERLClassAnnotation;
import de.hterhors.obie.ml.ner.NamedEntityLinkingAnnotations;
import de.hterhors.obie.ml.run.AbstractOBIERunner;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.templates.utils.BinningUtils;
import de.hterhors.obie.ml.variables.OBIEState;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling.StringSimilarityTemplate.Scope;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import factors.Factor;
import factors.FactorScope;
import learning.Vector;

/**
 * Measures the Levenshtein similarity between the annotated surface form and
 * the assigned class name. E.g. "male" to Male vs. "male" to Female.
 * 
 * This class takes into account all annotated surface forms that belongs to the
 * investigated class and takes the highest similarity of all. E.g. if Adult is
 * the investigated class and there are 2 surface forms: "adults" and "mature"
 * the similarity is the maximum of both surface forms.
 * 
 * This is necessary to overcome the problem of distant supervision annotations.
 * 
 * @author hterhors
 *
 * @date May 9, 2017
 */
public class StringSimilarityTemplate extends AbstractOBIETemplate<Scope> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static DecimalFormat DIGIT_FORMAT = new DecimalFormat("#.##");

	private static final int NUMBER_OF_BINS = 25;

	private static Logger log = LogManager.getFormatterLogger(StringSimilarityTemplate.class.getName());

	/**
	 * Similarity bins.
	 */
	final private float[] similarities = BinningUtils.getFloatBins(NUMBER_OF_BINS);

	public StringSimilarityTemplate(AbstractOBIERunner runner) {
		super(runner);
	}

	/**
	 * Factor Scope for these variables
	 * 
	 * @author hterhors
	 *
	 * @date May 9, 2017
	 */
	class Scope extends FactorScope {

		/**
		 * Surface forms of all annotations in the text with the respective class.
		 */
		final Set<String> surfaceForms;
		final String ontologyURI;

		protected Scope(Class<? extends IOBIEThing> entityRootClassType, AbstractOBIETemplate<?> template,
				String className, Set<String> surfaceForms) {
			super(template, className, surfaceForms, entityRootClassType);
			this.ontologyURI = className;
			this.surfaceForms = surfaceForms;
		}

	}

	@Override
	public List<Scope> generateFactorScopes(OBIEState state) {
		List<Scope> factors = new ArrayList<>();
		for (IETmplateAnnotation entity : state.getCurrentIETemplateAnnotations().getAnnotations()) {

			factors.addAll(addFactorRecursive(state.getInstance().getEntityAnnotations(),
					entity.rootClassType, entity.getThing()));

		}
		return factors;
	}

	/**
	 * Adds factors recursively for each class and fields that are part of the
	 * ontology model.
	 * 
	 * @param ner
	 * 
	 * @param entityRootClassType
	 * 
	 * @param scioClass
	 * @return
	 */
	private List<Scope> addFactorRecursive(NamedEntityLinkingAnnotations ner,
			Class<? extends IOBIEThing> entityRootClassType, IOBIEThing scioClass) {
		List<Scope> factors = new ArrayList<>();

		if (scioClass == null)
			return factors;

		if (!scioClass.getClass().isAnnotationPresent(DatatypeProperty.class)) {

			if (ner.containsClassAnnotations(scioClass.getClass())) {
				final String ontologyURI = scioClass.getONTOLOGY_NAME();

				Set<String> surfaceForms = new HashSet<>();
				for (NERLClassAnnotation nera : ner.getClassAnnotations(scioClass.getClass())) {
					surfaceForms.add(nera.text);
				}

				final Set<Class<? extends IOBIEThing>> influencedVariables = new HashSet<>();
				influencedVariables.add(scioClass.getClass());

				factors.add(new Scope(entityRootClassType, this, ontologyURI, surfaceForms));
			}

		}
		/*
		 * Add factors for object type properties.
		 */
		Arrays.stream(scioClass.getClass().getDeclaredFields())
				.filter(f -> (!f.isAnnotationPresent(DatatypeProperty.class)
						&& f.isAnnotationPresent(OntologyModelContent.class)))
				.forEach(field -> {
					field.setAccessible(true);
					try {
						if (field.isAnnotationPresent(RelationTypeCollection.class)) {
							for (IOBIEThing element : (List<IOBIEThing>) field.get(scioClass)) {
								factors.addAll(addFactorRecursive(ner, entityRootClassType, element));
							}
						} else {
							factors.addAll(
									addFactorRecursive(ner, entityRootClassType, (IOBIEThing) field.get(scioClass)));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		return factors;
	}

	@Override
	public void computeFactor(Factor<Scope> factor) {
		Vector featureVector = factor.getFeatureVector();

		final String className = factor.getFactorScope().ontologyURI
				.substring(1 + factor.getFactorScope().ontologyURI.lastIndexOf('/'));
		final Set<String> surfaceForms = factor.getFactorScope().surfaceForms;

		// System.out.println("className = " + className);
		// System.out.println("surfaceForm = " + surfaceForm);

		double maxSimilarity = 0;
		for (String surfaceForm : surfaceForms) {
			maxSimilarity = Math.max(maxSimilarity, WordMetric.levenshteinSimilarity(className, surfaceForm));
		}

		// System.out.println("similarity = " + similarity);

		for (Float bin : similarities) {
			featureVector.set("Max LevenShtein similarity for [" + className + "] < " + DIGIT_FORMAT.format(bin),
					maxSimilarity < bin);
			featureVector.set("Max LevenShtein similarity for [" + className + "] >= " + DIGIT_FORMAT.format(bin),
					maxSimilarity >= bin);
		}

	}

}