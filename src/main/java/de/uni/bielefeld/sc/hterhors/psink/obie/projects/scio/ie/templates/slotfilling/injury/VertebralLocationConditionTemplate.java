package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling.injury;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.run.AbstractOBIERunner;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.variables.OBIEState;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.slotfilling.injury.VertebralLocationConditionTemplate.Scope;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Vertebrae;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.VertebralArea;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IVertebrae;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IVertebralLocation;
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
public class VertebralLocationConditionTemplate extends AbstractOBIETemplate<Scope> {

	public VertebralLocationConditionTemplate(AbstractOBIERunner runner) {
		super(runner);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String VERTEBRAL_AREA_VALID_ORDINAL = "VertebralAreaValidOrdnial";

	private static final String VERTEBRAL_AREA_SAME_SEGMENT = "VertebralAreaSameSegment";

	private static final String VERTEBRAL_AREA_ORDINAL_DISTANCE_EQ1 = "VertebralAreaOrdinalDistance==1";
	private static final String VERTEBRAL_AREA_ORDINAL_DISTANCE_EQ2 = "VertebralAreaOrdinalDistance==2";
	private static final String VERTEBRAL_AREA_ORDINAL_DISTANCE_EQ3 = "VertebralAreaOrdinalDistance==3";
	private static final String VERTEBRAL_AREA_ORDINAL_DISTANCE_GR3 = "VertebralAreaOrdinalDistance>3";

	private static Logger log = LogManager.getFormatterLogger(VertebralLocationConditionTemplate.class.getName());

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
		for (IETmplateAnnotation entity : state.getCurrentIETemplateAnnotations().getAnnotations()) {

			if (IVertebralLocation.class.isAssignableFrom(entity.getThing().getClass())) {
				factors.addAll(addFactorRecursive(entity.rootClassType, (IVertebralLocation) entity.getThing()));
			} else if (entity.getThing() instanceof IInjury) {
				factors.addAll(addFactorRecursive(entity.rootClassType,
						((IInjury) entity.getThing()).getInjuryVertebralLocation()));
			}

		}
		return factors;
	}

	private List<Scope> addFactorRecursive(Class<? extends IOBIEThing> entityRootClassType,
			IVertebralLocation vertebralLocationInstance) {
		List<Scope> factors = new ArrayList<>();

		if (vertebralLocationInstance == null)
			return factors;

		final Set<Class<? extends IOBIEThing>> influencedVariables = new HashSet<>();

		if (vertebralLocationInstance instanceof VertebralArea) {
			IVertebrae upperVertebrae = ((VertebralArea) vertebralLocationInstance).getUpperVertebrae();
			IVertebrae lowerVertebrae = ((VertebralArea) vertebralLocationInstance).getLowerVertebrae();
			if (upperVertebrae != null && lowerVertebrae != null) {

				final int lowerVertebraeOrdinal = getOrdinal(lowerVertebrae.getIndividual());
				final int upperVertebraeOrdinal = getOrdinal(upperVertebrae.getIndividual());

				addFactor(entityRootClassType, factors, influencedVariables, VERTEBRAL_AREA_VALID_ORDINAL,
						lowerVertebraeOrdinal < upperVertebraeOrdinal);

				addFactor(entityRootClassType, factors, influencedVariables, VERTEBRAL_AREA_SAME_SEGMENT,
						sameSegment(lowerVertebraeOrdinal, upperVertebraeOrdinal));

				addFactor(entityRootClassType, factors, influencedVariables, VERTEBRAL_AREA_ORDINAL_DISTANCE_EQ1,
						(upperVertebraeOrdinal - lowerVertebraeOrdinal) == 1);
				addFactor(entityRootClassType, factors, influencedVariables, VERTEBRAL_AREA_ORDINAL_DISTANCE_EQ2,
						(upperVertebraeOrdinal - lowerVertebraeOrdinal) == 2);
				addFactor(entityRootClassType, factors, influencedVariables, VERTEBRAL_AREA_ORDINAL_DISTANCE_EQ3,
						(upperVertebraeOrdinal - lowerVertebraeOrdinal) >= 3);
				addFactor(entityRootClassType, factors, influencedVariables, VERTEBRAL_AREA_ORDINAL_DISTANCE_GR3,
						(upperVertebraeOrdinal - lowerVertebraeOrdinal) > 3);

			}
		}

		return factors;
	}

	private boolean sameSegment(int lowerVertebraeOrdinal, int upperVertebraeOrdinal) {

		if (lowerVertebraeOrdinal < 4 && upperVertebraeOrdinal < 4)
			return true;

		if (lowerVertebraeOrdinal >= 4 && upperVertebraeOrdinal >= 4 && lowerVertebraeOrdinal < 15
				&& upperVertebraeOrdinal < 15)
			return true;

		if (lowerVertebraeOrdinal >= 15 && upperVertebraeOrdinal >= 15)
			return true;

		return false;
	}

	private int getOrdinal(AbstractIndividual abstractOBIEIndividual) {

		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/L1")))
			return 0;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/L2")))
			return 1;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/L3")))
			return 2;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/L4")))
			return 3;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T1")))
			return 4;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T2")))
			return 5;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T3")))
			return 6;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T4")))
			return 7;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T5")))
			return 8;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T6")))
			return 9;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T7")))
			return 10;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T8")))
			return 11;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T9")))
			return 12;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T10")))
			return 13;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/T11")))
			return 14;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/C1")))
			return 15;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/C2")))
			return 16;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/C3")))
			return 17;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/C4")))
			return 18;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/C5")))
			return 19;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/C6")))
			return 20;
		if (abstractOBIEIndividual.equals(Vertebrae.individualFactory.getIndividualByURI("http://psink.de/scio/C7")))
			return 21;
		return -1;
	}

	private void addFactor(Class<? extends IOBIEThing> entityRootClassType, List<Scope> factors,
			final Set<Class<? extends IOBIEThing>> influencedVariables, String condition, boolean matchesCondition) {
		factors.add(new Scope(entityRootClassType, this, condition, matchesCondition));
	}

	@Override
	public void computeFactor(Factor<Scope> factor) {
		Vector featureVector = factor.getFeatureVector();

		featureVector.set(factor.getFactorScope().condition, factor.getFactorScope().matchesCondition);
		featureVector.set("NOT_" + factor.getFactorScope().condition, !factor.getFactorScope().matchesCondition);

	}

}
