package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces;

import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.IndividualFactory;
import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.annotations.AssignableSubInterfaces;
import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.annotations.DirectInterface;
import de.hterhors.obie.core.ontology.annotations.DirectSiblings;
import de.hterhors.obie.core.ontology.annotations.ImplementationClass;
import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.annotations.SuperRootClasses;
import de.hterhors.obie.core.ontology.annotations.TextMention;
import de.hterhors.obie.core.ontology.interfaces.IDatatype;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
/**
<p><b>skos:closeMatch</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C43622
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.codamono.com/biointerchange/gfvo#ExperimentalMethod
<p>
<p><b>rdfs:label</b>
<p>investigation method
<p>
<p><b>scio:visualizationContainer</b>
<p>Investigation_Method_Group
<p>
<p><b>rdfs:description</b>
<p>Investigation Method is a procedure that yields an experimental outcome (result). Experimental methods can be in vivo, in vitro or in silico procedures that are well described and can be referenced.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IGroomingObservation.class, IBodyWeightExamination.class, IMechanicalAllodyniaTest.class, INeuronalActivityTest.class, IOligodendrogliaChangesTest.class, IMyelinationTest.class, INeurogenesisTest.class, IMotorTest.class, IAxonalSproutingTest.class, IProteinLevelAnalysis.class, ILouisvilleSwimScale.class, IWalkingAnalysisTest.class, IAxonalChangesTest.class, ISelfMutilationObservation.class, IMolecularChangesTest.class, IManualDexterityTest.class, IAxonalRegenerationTest.class, IAstrogliosisTest.class, IElectrophysiologyTest.class, IHemorrhageTest.class, ILimbMuscleStrengthTest.class, IBMSTest.class, IImagingTest.class, IObservationOfAnimalBehaviour.class, IMortalityObservation.class, ISwimmingTest.class, IToxicityTest.class, IInfectionExamination.class, IHReflexTest.class, ISomatosensoryEvokedPotentialsTest.class, ISensoryTest.class, INonFunctionalTest.class, IBloodCirculationExamination.class, INonNeuronalCellChangesTest.class, IBBBTest.class, IOpenFieldTest.class, IAvoidanceResponseTest.class, IHindpawSensationTest.class, IFunctionalTest.class, IInclinedPlaneTest.class, IScarringTest.class, ISpasticityObservation.class, INeuronalChangesTest.class, ILethargyObservation.class, INeurologicScalesTest.class, ISpinalCordEvokedPotentialsTest.class, ILesionVolumeTest.class, ILadderRungTest.class, IFootprintAnalysisTest.class, ISinglePelletReachingTest.class, IAdhesiveRemovalTest.class, IThermalHyperalgesiaTest.class, IPhysiologyTest.class, IGaitTest.class, IHistologicalInvestgationTest.class, ISurfaceRightingReflexTest.class, ITailFlickReflexTest.class, IAngiogenesisTest.class, IMotorReflexTest.class, IGaleRatingScoreTest.class, ISchwannCellChangesTest.class, IOxidativeStressTest.class, IApoptosisTest.class, IStaircaseTest.class, IUrineVoidingTest.class, ITissueSparingTest.class, IGeneExpressionAnalysis.class, IContactPlacingResponseTest.class, IAxonalDiebackTest.class, IBloodBrainBarrierTest.class, ISecondaryDegenerationTest.class, IGastricUlcerogenesisTest.class, IRearingTest.class, ILocomotorTest.class, ICystVolumeTest.class, IForelimbAsymmetryTest.class, IMotorEvokedPotentialsTest.class, ICardioVascularFunctionTest.class, INarrowBeamTest.class, IPainTest.class, ISurvivalObservation.class, IForelimbStrengthTest.class, IInflammationTest.class, INeuroprotectionTest.class, INeuronalCellLossTest.class, IAxonalDamageTest.class, IAutomatedGaitAnalysis.class, IAutonomicDysreflexiaTest.class, IBBBSubscoreTest.class, })

@ImplementationClass(get=InvestigationMethod.class)
 public interface IInvestigationMethod
 extends ISCIOThing{

/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
	public IInvestigationMethod addMakesUseOfApparatus(IApparatus apparatus);


/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
	public List<IApparatus> getMakesUseOfApparatus();


/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
	public IInvestigationMethod setMakesUseOfApparatus(List<IApparatus> makesUseOfApparatus);


}
