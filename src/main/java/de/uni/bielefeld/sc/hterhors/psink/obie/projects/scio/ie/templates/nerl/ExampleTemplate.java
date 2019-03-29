package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.nerl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.run.AbstractOBIERunner;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import de.hterhors.obie.ml.variables.OBIEState;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.nerl.ExampleTemplate.ExampleScope;
import factors.Factor;
import factors.FactorScope;
import learning.Vector;

/**
 * Example that shows how to implement proper templates. In this example we
 * create bag of word features. <br>
 * <br>
 * The feature generation generally happens in two steps: i) first, the scope of
 * the template including all variables is defined. This is done in the
 * {@link #generateFactorScopes(OBIEState)} method. For that the scope needs to
 * be defined first, see #{@link ExampleScope} class. Note that the system
 * internally caches the feature generation based on the scope. That means, a)
 * expensive operations should be done in the feature generation rather than in
 * the scope definition and b) variables that are used in the scope need to be
 * proper declared in the super constructor for caching. ii) second, if the
 * scope is not cached yet, the features are computed in the
 * {@link #computeFactor(Factor)} method. <br>
 * <br>
 * 
 * 
 * All generated features and their learned weights can be observed in the model
 * folder. Each template is stored in its own file. Each line represents one
 * feature + learned feature weight.
 * 
 * @author hterhors
 *
 */
public class ExampleTemplate extends AbstractOBIETemplate<ExampleScope> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExampleTemplate(AbstractOBIERunner runner) {
		super(runner);
	}

	private static Logger log = LogManager.getFormatterLogger(ExampleTemplate.class.getName());

	/**
	 * The scope of a template defines the variables that can be used for the
	 * feature generation. <br>
	 * <br>
	 * 
	 * <b> Important: Each scope needs the inherit from FactorScope and needs to
	 * call the super method passing all important variables as parameters for
	 * caching. If variables are not passed to the super constructor caching might
	 * not work properly resulting in failure or undetermined behavior! Note that,
	 * when working with multiple super root search types the search type needs to
	 * be a parameter, too. </b>
	 * 
	 * @author hterhors
	 *
	 */
	class ExampleScope extends FactorScope {

		/**
		 * The variable that stores a surface that is used for feature generation later.
		 */
		final public String surfaceForm;

		/**
		 * The variable that stores the corresponding class label.
		 */
		final public String classLabel;

		/**
		 * Constructor of the template scope with the two variables <code>text</code>
		 * and <code>classLabel</code>.
		 * 
		 * @param entityRootClassType the root search type is only needed if working
		 *                            with multiple classes.
		 * @param text                the text of the annotation.
		 * @param classLabel          the classLabel of the annotation.
		 */
		public ExampleScope(Class<? extends IOBIEThing> entityRootClassType, final String classLabel,
				final String text) {
			/**
			 * Good practice is to call super constructor always with the search root class.
			 * TODO: Do not forget to add all variables.
			 */
			super(ExampleTemplate.this, entityRootClassType, classLabel, text);
			this.surfaceForm = text;
			this.classLabel = classLabel;
		}

	}

	@Override
	public List<ExampleScope> generateFactorScopes(OBIEState state) {
		/*
		 * In this example template, we want to create bag of words feature. For that a
		 * factor need to be created for each class annotation that is connected to its
		 * underlying text.
		 */

		/**
		 * The list of factors. One factor for each annotation.
		 */
		final List<ExampleScope> factors = new ArrayList<>();
		/*
		 * Get the current annotations of the state.
		 */
		for (IETmplateAnnotation entity : state.getCurrentIETemplateAnnotations().getAnnotations()) {

			/*
			 * Gets the entity annotation.
			 */
			IOBIEThing entityAnnotation = entity.getThing();

			/*
			 * If the entity annotation should be null continue loop.
			 */
			if (entityAnnotation == null)
				continue;

			final String classLabel = entityAnnotation.getLabel();
			final String surfaceForm = entityAnnotation.getTextMention();

			/*
			 * Add a new factor to the list.
			 */
			factors.add(new ExampleScope(entity.rootClassType, classLabel, surfaceForm));

		}
		return factors;
	}

	@Override
	public void computeFactor(Factor<ExampleScope> factor) {

		/*
		 * This method is called after the factor generation, but only if the factors
		 * were not be cached previously! In this method, we first get the factor scope
		 * and the feature vector and compute features based on the variables of the
		 * scope in order to add them to the feature vector.
		 */

		/**
		 * The scope that was previously created. Here, we have access to all previously
		 * filled variables.
		 */
		final ExampleScope scope = factor.getFactorScope();

		/**
		 * The feature vector to which we can add features.
		 */
		final Vector featureVector = factor.getFeatureVector();

		final String classLabel = scope.classLabel;
		final String surfaceForm = scope.surfaceForm;

		/*
		 * Features are added via the set method. The first feature simply concatenates
		 * the class label and the surface form of the annotation.
		 */
		featureVector.set(classLabel + surfaceForm, true);

		/*
		 * The next set of features concatenates single tokens (split by none-words)
		 * of the surface form with the class label.
		 */

		for (String token : surfaceForm.split("\\W")) {
			featureVector.set(classLabel + token, true);
		}
		

	}

}
