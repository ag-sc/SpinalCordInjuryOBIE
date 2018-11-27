package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.variables.OBIEState;
import de.hterhors.obie.ml.variables.TemplateAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.AnimalModelConditionTemplate.Scope;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CatModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CatSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DogModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DogSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GuineaPigModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GuineaPigSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MinipigModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MinipigSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MonkeyModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MonkeySpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MouseModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MouseSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RabbitModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RabbitSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RatModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RatSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismSpecies;
import factors.Factor;
import factors.FactorScope;
import learning.Vector;

/**
 * This template is specifically designed for AnimalModel(s) (OrganismModel). It
 * captures dependencies between properties and single properties within an
 * animal model such as: species is highly depended on the assigned type.
 * Species-property is never empty and so on...
 * 
 * @author hterhors
 *
 * @date Apr 18, 2018
 */
public class AnimalModelConditionTemplate extends AbstractOBIETemplate<Scope> implements Serializable {

	public AnimalModelConditionTemplate(RunParameter parameter) {
		super(parameter);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TYPE_OF_ANIMAL_MODEL_MATCHES_SPECIES = "TypeOfAnimalModelMatchesSpecies";
	private static final String SPECIES_SLOT_IS_NOT_EMPTY = "SpeciesSlotIsNotEmpty";
	private static Logger log = LogManager.getFormatterLogger(AnimalModelConditionTemplate.class.getName());

	class Scope extends FactorScope {

		final String condition;
		final boolean matchesCondition;

		public Scope(Class<? extends IOBIEThing> entityRootClassType, AbstractOBIETemplate<?> template,
				final String condition, final boolean matchesCondition) {
			super(template, entityRootClassType, condition, matchesCondition);
			this.condition = condition;
			this.matchesCondition = matchesCondition;
		}

	}

	@Override
	public List<Scope> generateFactorScopes(OBIEState state) {
		List<Scope> factors = new ArrayList<>();
		for (TemplateAnnotation entity : state.getCurrentTemplateAnnotations().getTemplateAnnotations()) {

			if (!IOrganismModel.class.isAssignableFrom(entity.getThing().getClass()))
				continue;

			factors.addAll(addFactorRecursive(entity.rootClassType, (IOrganismModel) entity.getThing()));

		}
		return factors;
	}

	private List<Scope> addFactorRecursive(Class<? extends IOBIEThing> entityRootClassType,
			IOrganismModel organismModelInstance) {
		List<Scope> factors = new ArrayList<>();

		if (organismModelInstance == null)
			return factors;

		if (organismModelInstance.getOrganismSpecies() != null)
			addFactor(entityRootClassType, factors, TYPE_OF_ANIMAL_MODEL_MATCHES_SPECIES, matchesTypeSpeciesCondition(
					organismModelInstance.getClass(), organismModelInstance.getOrganismSpecies().getClass()));

		addFactor(entityRootClassType, factors, SPECIES_SLOT_IS_NOT_EMPTY,
				organismModelInstance.getOrganismSpecies() != null);

		return factors;
	}

	private boolean matchesTypeSpeciesCondition(final Class<? extends IOrganismModel> type,
			final Class<? extends IOrganismSpecies> species) {

		if (RatSpecies.class.isAssignableFrom(species) && RatModel.class.isAssignableFrom(type)) {
			return true;
		} else if (MouseSpecies.class.isAssignableFrom(species) && MouseModel.class.isAssignableFrom(type)) {
			return true;
		} else if (GuineaPigSpecies.class.isAssignableFrom(species) && GuineaPigModel.class.isAssignableFrom(type)) {
			return true;
		} else if (RabbitSpecies.class.isAssignableFrom(species) && RabbitModel.class.isAssignableFrom(type)) {
			return true;
		} else if (CatSpecies.class.isAssignableFrom(species) && CatModel.class.isAssignableFrom(type)) {
			return true;
		} else if (DogSpecies.class.isAssignableFrom(species) && DogModel.class.isAssignableFrom(type)) {
			return true;
		} else if (MinipigSpecies.class.isAssignableFrom(species) && MinipigModel.class.isAssignableFrom(type)) {
			return true;
		} else if (MonkeySpecies.class.isAssignableFrom(species) && MonkeyModel.class.isAssignableFrom(type)) {
			return true;
		}

		return false;
	}

	private void addFactor(Class<? extends IOBIEThing> entityRootClassType, List<Scope> factors, String condition,
			boolean matchesCondition) {
		factors.add(new Scope(entityRootClassType, this, condition, matchesCondition));
	}

	@Override
	public void computeFactor(Factor<Scope> factor) {
		Vector featureVector = factor.getFeatureVector();

		featureVector.set(factor.getFactorScope().condition, factor.getFactorScope().matchesCondition);
		featureVector.set("NOT_" + factor.getFactorScope().condition, !factor.getFactorScope().matchesCondition);

	}

}
