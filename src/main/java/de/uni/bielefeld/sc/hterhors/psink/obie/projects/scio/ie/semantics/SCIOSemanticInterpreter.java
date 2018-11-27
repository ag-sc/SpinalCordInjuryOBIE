package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import de.hterhors.obie.ml.dtinterpreter.IDatatypeInterpretation;
import de.hterhors.obie.ml.dtinterpreter.IDatatypeInterpreter;
import de.hterhors.obie.ml.dtinterpreter.INumericInterpreter;
import de.hterhors.obie.ml.dtinterpreter.IStringInterpreter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Age;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Current;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Depth;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Distance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Dosage;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DosageExtracorporal;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DosageIntracorporal;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Duration;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Force;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Frequency;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Interval;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Length;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.LightIntensity;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.NNumber;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.PValue;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Pressure;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.StandardDeviation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.StandardError;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Temperature;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Thickness;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Volume;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Weight;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

public class SCIOSemanticInterpreter implements IDatatypeInterpreter<ISCIOThing> {

	private static SCIOSemanticInterpreter instance = null;

	public static SCIOSemanticInterpreter getInstance() {

		if (instance == null)
			instance = new SCIOSemanticInterpreter();

		return instance;
	}

	@Override
	public List<IDatatypeInterpretation> getPossibleInterpretations(String textMention) {
		if (textMention == null || textMention.isEmpty())
			return null;
		/**
		 * TODO: Add more.
		 */
		List<IDatatypeInterpretation> interpretations = new ArrayList<>();

		INumericInterpreter semantics1 = new SemanticWeight.Builder().interprete(textMention).build().normalize();
		if (semantics1.exists()) {
			interpretations.add(semantics1);
		}
		INumericInterpreter semantics2 = new SemanticAge.Builder().interprete(textMention).build().normalize();
		if (semantics2.exists()) {
			interpretations.add(semantics2);
		}
		INumericInterpreter semantics3 = new SemanticDosage.Builder().interprete(textMention).build().normalize();
		if (semantics3.exists()) {
			interpretations.add(semantics3);
		}
		INumericInterpreter semantics4 = new SemanticDuration.Builder().interprete(textMention).build().normalize();
		if (semantics4.exists()) {
			interpretations.add(semantics4);
		}
		INumericInterpreter semantics5 = new SemanticForce.Builder().interprete(textMention).build().normalize();
		if (semantics5.exists()) {
			interpretations.add(semantics5);
		}
		INumericInterpreter semantics6 = new SemanticPressure.Builder().interprete(textMention).build().normalize();
		if (semantics6.exists()) {
			interpretations.add(semantics6);
		}
		INumericInterpreter semantics7 = new SemanticVolume.Builder().interprete(textMention).build().normalize();
		if (semantics7.exists()) {
			interpretations.add(semantics7);
		}
		INumericInterpreter semantics8 = new SemanticDistance.Builder().interprete(textMention).build().normalize();
		if (semantics8.exists()) {
			interpretations.add(semantics8);
		}
		INumericInterpreter semantics9 = new SemanticDepth.Builder().interprete(textMention).build().normalize();
		if (semantics9.exists()) {
			interpretations.add(semantics9);
		}
		INumericInterpreter semantics10 = new SemanticThickness.Builder().interprete(textMention).build().normalize();
		if (semantics10.exists()) {
			interpretations.add(semantics10);
		}
		INumericInterpreter semantics11 = new SemanticLength.Builder().interprete(textMention).build().normalize();
		if (semantics11.exists()) {
			interpretations.add(semantics11);
		}
		INumericInterpreter semantics12 = new SemanticTemperature.Builder().interprete(textMention).build().normalize();
		if (semantics12.exists()) {
			interpretations.add(semantics12);
		}
		INumericInterpreter semantics13 = new SemanticNNumber.Builder().interprete(textMention).build().normalize();
		if (semantics13.exists()) {
			interpretations.add(semantics13);
		}
		INumericInterpreter semantics14 = new SemanticPValue.Builder().interprete(textMention).build().normalize();
		if (semantics14.exists()) {
			interpretations.add(semantics14);
		}

		INumericInterpreter semantics15 = new SemanticStandardError.Builder().interprete(textMention).build()
				.normalize();
		if (semantics15.exists()) {
			interpretations.add(semantics15);
		}

		INumericInterpreter semantics16 = new SemanticStandardDeviation.Builder().interprete(textMention).build()
				.normalize();
		if (semantics16.exists()) {
			interpretations.add(semantics16);
		}

		IStringInterpreter semantics17 = new SemanticGroupName.Builder().interprete(textMention).build();
		if (semantics17.exists()) {
			interpretations.add(semantics17);
		}

		INumericInterpreter semantics18 = new SemanticLightIntensity.Builder().interprete(textMention).build();
		if (semantics18.exists()) {
			interpretations.add(semantics18);
		}

		INumericInterpreter semantics19 = new SemanticFrequency.Builder().interprete(textMention).build();
		if (semantics19.exists()) {
			interpretations.add(semantics19);
		}

		return interpretations;
	}

	@Override
	public IDatatypeInterpretation interpret(Class<? extends ISCIOThing> classType, Matcher matcher) {

		IDatatypeInterpretation semantics = null;
		if (Weight.class == classType) {
			semantics = new SemanticWeight.Builder().interprete(matcher.group()).build().normalize();
		} else if (Age.class == classType) {
			semantics = new SemanticAge.Builder().interprete(matcher.group()).build().normalize();
		} else if (Dosage.class == classType) {
			semantics = new SemanticDosage.Builder().interprete(matcher.group()).build().normalize();
		} else if (Duration.class == classType) {
			semantics = new SemanticDuration.Builder().interprete(matcher.group()).build().normalize();
		} else if (Force.class == classType) {
			semantics = new SemanticForce.Builder().interprete(matcher.group()).build().normalize();
		} else if (Pressure.class == classType) {
			semantics = new SemanticPressure.Builder().interprete(matcher.group()).build().normalize();
		} else if (Volume.class == classType) {
			semantics = new SemanticVolume.Builder().interprete(matcher.group()).build().normalize();
		} else if (Distance.class == classType) {
			semantics = new SemanticDistance.Builder().interprete(matcher.group()).build().normalize();
		} else if (Depth.class == classType) {
			semantics = new SemanticDepth.Builder().interprete(matcher.group()).build().normalize();
		} else if (Thickness.class == classType) {
			semantics = new SemanticThickness.Builder().interprete(matcher.group()).build().normalize();
		} else if (Length.class == classType) {
			semantics = new SemanticLength.Builder().interprete(matcher.group()).build().normalize();
		} else if (Temperature.class == classType) {
			semantics = new SemanticTemperature.Builder().interprete(matcher.group()).build().normalize();
		} else if (NNumber.class == classType) {
			semantics = new SemanticNNumber.Builder().interprete(matcher.group()).build().normalize();
		} else if (PValue.class == classType) {
			semantics = new SemanticPValue.Builder().interprete(matcher.group()).build().normalize();
		} else if (StandardError.class == classType) {
			semantics = new SemanticStandardError.Builder().interprete(matcher.group()).build().normalize();
		} else if (StandardDeviation.class == classType) {
			semantics = new SemanticStandardDeviation.Builder().interprete(matcher.group()).build().normalize();
		} else if (GroupName.class == classType) {
			semantics = new SemanticGroupName.Builder().interprete(matcher.group()).build();
		} else if (LightIntensity.class == classType) {
			semantics = new SemanticLightIntensity.Builder().interprete(matcher.group()).build();
		} else if (Frequency.class == classType) {
			semantics = new SemanticFrequency.Builder().interprete(matcher.group()).build();
		} else {
			throw new IllegalArgumentException("Unknown data type for: " + classType.getSimpleName());
		}

		if (semantics != null && semantics.exists()) {
			return semantics;
		}
		return semantics;
	}
	// @Override
	// public ISemanticNumericDataType interpret(Class<? extends ISCIOThing>
	// classType,
	// Matcher matcher) {
	//
	// ISemanticNumericDataType semantics = null;
	// if (Weight.class == classType) {
	// semantics = new
	// SemanticWeight.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Age.class == classType) {
	// semantics = new
	// SemanticAge.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Dosage.class == classType) {
	// semantics = new
	// SemanticDosage.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Duration.class == classType) {
	// semantics = new
	// SemanticDuration.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Force.class == classType) {
	// semantics = new
	// SemanticForce.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Pressure.class == classType) {
	// semantics = new
	// SemanticPressure.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Volume.class == classType) {
	// semantics = new
	// SemanticVolume.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Distance.class == classType) {
	// semantics = new
	// SemanticDistance.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Depth.class == classType) {
	// semantics = new
	// SemanticDepth.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Thickness.class == classType) {
	// semantics = new
	// SemanticThickness.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Length.class == classType) {
	// semantics = new
	// SemanticLength.Builder().fromMatcher(matcher).build().normalize();
	// } else if (Temperature.class == classType) {
	// semantics = new
	// SemanticTemperature.Builder().fromMatcher(matcher).build().normalize();
	// } else if (NNumber.class == classType) {
	// semantics = new
	// SemanticNNumber.Builder().fromMatcher(matcher).build().normalize();
	// } else if (PValue.class == classType) {
	// semantics = new
	// SemanticPValue.Builder().fromMatcher(matcher).build().normalize();
	// } else if (StandardError.class == classType) {
	// semantics = new
	// SemanticStandardError.Builder().fromMatcher(matcher).build().normalize();
	// } else if (StandardDeviation.class == classType) {
	// semantics = new
	// SemanticStandardDeviation.Builder().fromMatcher(matcher).build().normalize();
	// } else {
	// throw new IllegalArgumentException("Unknown data type for: " +
	// classType.getSimpleName());
	// }
	//
	// if (semantics != null && semantics.exists()) {
	// return semantics;
	// }
	// return semantics;
	// }

	@Override
	public IDatatypeInterpretation interpret(Class<? extends ISCIOThing> classType, final String textMention) {

		final IDatatypeInterpretation semantics;
		if (textMention == null || textMention.isEmpty())
			return null;

		if (Weight.class == classType) {
			semantics = new SemanticWeight.Builder().interprete(textMention).build().normalize();
		} else if (Age.class == classType) {
			semantics = new SemanticAge.Builder().interprete(textMention).build().normalize();
		} else if (LightIntensity.class == classType) {
			semantics = new SemanticLightIntensity.Builder().interprete(textMention).build().normalize();
		} else if (Dosage.class == classType) {
			semantics = new SemanticDosage.Builder().interprete(textMention).build().normalize();
		} else if (DosageExtracorporal.class == classType) {
			semantics = new SemanticDosage.Builder().interprete(textMention).build().normalize();
		} else if (DosageIntracorporal.class == classType) {
			semantics = new SemanticDosage.Builder().interprete(textMention).build().normalize();
		} else if (Duration.class == classType) {
			semantics = new SemanticDuration.Builder().interprete(textMention).build().normalize();
		} else if (Force.class == classType) {
			semantics = new SemanticForce.Builder().interprete(textMention).build().normalize();
		} else if (Pressure.class == classType) {
			semantics = new SemanticPressure.Builder().interprete(textMention).build().normalize();
		} else if (Volume.class == classType) {
			semantics = new SemanticVolume.Builder().interprete(textMention).build().normalize();
		} else if (Distance.class == classType) {
			semantics = new SemanticDistance.Builder().interprete(textMention).build().normalize();
		} else if (Depth.class == classType) {
			semantics = new SemanticDepth.Builder().interprete(textMention).build().normalize();
		} else if (Thickness.class == classType) {
			semantics = new SemanticThickness.Builder().interprete(textMention).build().normalize();
		} else if (Length.class == classType) {
			semantics = new SemanticLength.Builder().interprete(textMention).build().normalize();
		} else if (Temperature.class == classType) {
			semantics = new SemanticTemperature.Builder().interprete(textMention).build().normalize();
		} else if (NNumber.class == classType) {
			semantics = new SemanticNNumber.Builder().interprete(textMention).build().normalize();
		} else if (PValue.class == classType) {
			semantics = new SemanticPValue.Builder().interprete(textMention).build().normalize();
		} else if (StandardError.class == classType) {
			semantics = new SemanticStandardError.Builder().interprete(textMention).build().normalize();
		} else if (StandardDeviation.class == classType) {
			semantics = new SemanticStandardDeviation.Builder().interprete(textMention).build().normalize();
		} else if (GroupName.class == classType) {
			semantics = new SemanticGroupName.Builder().interprete(textMention).build();
		} else if (Frequency.class == classType) {
			semantics = new SemanticFrequency.Builder().interprete(textMention).build();

			/**
			 * TODO: BUILD SEMANTIC INTs for ...:
			 */
		} else if (Interval.class == classType) {
			semantics = new SemanticDuration.Builder().interprete(textMention).build();
		} else if (Current.class == classType) {
			semantics = new SemanticPressure.Builder().interprete(textMention).build();
		} else {
			throw new IllegalArgumentException(
					"Unknown data type for(" + textMention + "): " + classType.getSimpleName());
		}
		return semantics;
	}

}
