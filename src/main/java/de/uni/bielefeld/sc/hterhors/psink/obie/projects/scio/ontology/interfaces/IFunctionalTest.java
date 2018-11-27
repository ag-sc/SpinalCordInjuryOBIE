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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/89521000
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.bioontology.org/ontology/SNOMEDCT/81375008
<p>
<p><b>rdfs:label</b>
<p>functional test
<p>
<p><b>rdfs:description</b>
<p>Functional Test or physical assessment is an experimental investigation method which tests for normal or impaired physiological function of the living organism.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IBodyWeightExamination.class, IMechanicalAllodyniaTest.class, IMotorTest.class, ILouisvilleSwimScale.class, IWalkingAnalysisTest.class, IManualDexterityTest.class, IElectrophysiologyTest.class, ILimbMuscleStrengthTest.class, IBMSTest.class, ISwimmingTest.class, IInfectionExamination.class, IHReflexTest.class, ISomatosensoryEvokedPotentialsTest.class, ISensoryTest.class, IBloodCirculationExamination.class, IBBBTest.class, IOpenFieldTest.class, IAvoidanceResponseTest.class, IHindpawSensationTest.class, IInclinedPlaneTest.class, INeurologicScalesTest.class, ISpinalCordEvokedPotentialsTest.class, ILadderRungTest.class, IFootprintAnalysisTest.class, ISinglePelletReachingTest.class, IAdhesiveRemovalTest.class, IThermalHyperalgesiaTest.class, IPhysiologyTest.class, IGaitTest.class, ISurfaceRightingReflexTest.class, ITailFlickReflexTest.class, IMotorReflexTest.class, IGaleRatingScoreTest.class, IStaircaseTest.class, IUrineVoidingTest.class, IContactPlacingResponseTest.class, IBloodBrainBarrierTest.class, IGastricUlcerogenesisTest.class, IRearingTest.class, ILocomotorTest.class, IForelimbAsymmetryTest.class, IMotorEvokedPotentialsTest.class, ICardioVascularFunctionTest.class, INarrowBeamTest.class, IPainTest.class, IForelimbStrengthTest.class, IAutomatedGaitAnalysis.class, IAutonomicDysreflexiaTest.class, IBBBSubscoreTest.class, })

@ImplementationClass(get=FunctionalTest.class)
 public interface IFunctionalTest
 extends IInvestigationMethod{

/**
<p><b>rdfs:label</b>
<p>tests for
<p>*/
	public IFunctionalTest addTestsForFunction(IFunction function);


/**
<p><b>scio:example</b>
<p>A weight of 50 g was applied statically to the T9 of spinal cord for 5 min.
<p>
<p><b>rdfs:label</b>
<p>has duration
<p>
<p><b>rdfs:description</b>
<p>Timing of injury process, i.e. if compression is applied for several seconds.
<p>
<p><b>scio:exampleSource</b>
<p>DOI 10.1007/s12031-015-0564-z
<p>*/
	public IDuration getDuration();


/**
<p><b>rdfs:label</b>
<p>tests for
<p>*/
	public List<IFunction> getTestsForFunctions();


/**
<p><b>scio:example</b>
<p>A weight of 50 g was applied statically to the T9 of spinal cord for 5 min.
<p>
<p><b>rdfs:label</b>
<p>has duration
<p>
<p><b>rdfs:description</b>
<p>Timing of injury process, i.e. if compression is applied for several seconds.
<p>
<p><b>scio:exampleSource</b>
<p>DOI 10.1007/s12031-015-0564-z
<p>*/
	public IFunctionalTest setDuration(IDuration duration);


/**
<p><b>rdfs:label</b>
<p>tests for
<p>*/
	public IFunctionalTest setTestsForFunctions(List<IFunction> testsForFunctions);


}
