package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes;

import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.*;
import java.lang.NoSuchMethodException;
import de.hterhors.obie.core.ontology.interfaces.IDatatype;
import de.hterhors.obie.core.ontology.annotations.SuperRootClasses;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import java.util.HashMap;
import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import java.util.ArrayList;
import org.apache.jena.rdf.model.Model;
import de.hterhors.obie.core.ontology.annotations.AssignableSubInterfaces;
import de.hterhors.obie.core.ontology.annotations.ImplementationClass;
import org.apache.jena.rdf.model.Resource;
import java.util.Map;
import java.lang.InstantiationException;
import java.lang.SecurityException;
import de.hterhors.obie.core.ontology.annotations.DirectSiblings;
import java.lang.IllegalAccessException;
import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.IndividualFactory;
import de.hterhors.obie.core.ontology.annotations.DirectInterface;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import java.lang.IllegalArgumentException;
import de.hterhors.obie.core.ontology.annotations.TextMention;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.jena.rdf.model.ModelFactory;
import de.hterhors.obie.core.ontology.AbstractIndividual;

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

@AssignableSubClasses(get={FunctionalTest.class, GeneExpressionAnalysis.class, CardioVascularFunctionTest.class, AxonalRegenerationTest.class, ManualDexterityTest.class, LouisvilleSwimScale.class, HReflexTest.class, AutonomicDysreflexiaTest.class, AxonalSproutingTest.class, CystVolumeTest.class, FootprintAnalysisTest.class, BBBSubscoreTest.class, AxonalDamageTest.class, ScarringTest.class, ForelimbAsymmetryTest.class, ImagingTest.class, ThermalHyperalgesiaTest.class, NeurologicScalesTest.class, NarrowBeamTest.class, MyelinationTest.class, SpinalCordEvokedPotentialsTest.class, LocomotorTest.class, AvoidanceResponseTest.class, ForelimbStrengthTest.class, MechanicalAllodyniaTest.class, AstrogliosisTest.class, NonNeuronalCellChangesTest.class, OpenFieldTest.class, InclinedPlaneTest.class, SwimmingTest.class, NeurogenesisTest.class, InflammationTest.class, GaitTest.class, ContactPlacingResponseTest.class, SchwannCellChangesTest.class, MotorEvokedPotentialsTest.class, RearingTest.class, SpasticityObservation.class, InfectionExamination.class, MolecularChangesTest.class, SurvivalObservation.class, GaleRatingScoreTest.class, NeuroprotectionTest.class, SinglePelletReachingTest.class, ApoptosisTest.class, SecondaryDegenerationTest.class, AdhesiveRemovalTest.class, SensoryTest.class, LimbMuscleStrengthTest.class, AxonalChangesTest.class, NeuronalActivityTest.class, TailFlickReflexTest.class, ProteinLevelAnalysis.class, BloodBrainBarrierTest.class, PhysiologyTest.class, HindpawSensationTest.class, UrineVoidingTest.class, PainTest.class, ElectrophysiologyTest.class, MortalityObservation.class, AngiogenesisTest.class, LadderRungTest.class, NonFunctionalTest.class, BloodCirculationExamination.class, ToxicityTest.class, BodyWeightExamination.class, NeuronalCellLossTest.class, HistologicalInvestgationTest.class, OligodendrogliaChangesTest.class, ObservationOfAnimalBehaviour.class, BMSTest.class, MotorTest.class, GastricUlcerogenesisTest.class, OxidativeStressTest.class, AxonalDiebackTest.class, LesionVolumeTest.class, TissueSparingTest.class, SomatosensoryEvokedPotentialsTest.class, WalkingAnalysisTest.class, SelfMutilationObservation.class, BBBTest.class, GroomingObservation.class, MotorReflexTest.class, StaircaseTest.class, LethargyObservation.class, HemorrhageTest.class, NeuronalChangesTest.class, SurfaceRightingReflexTest.class, AutomatedGaitAnalysis.class, })

@DirectSiblings(get={})

@SuperRootClasses(get={InvestigationMethod.class, })

@DirectInterface(get=IInvestigationMethod.class)
 public class InvestigationMethod implements IInvestigationMethod{

final public static IndividualFactory<InvestigationMethodIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = InvestigationMethodIndividual.class;
static class InvestigationMethodIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public InvestigationMethodIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "InvestigationMethodIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<InvestigationMethodIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final InvestigationMethodIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/InvestigationMethod";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/makesUseOf")
@RelationTypeCollection
private List<IApparatus> makesUseOfApparatus = new ArrayList<>();
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public InvestigationMethod(String individualURI, String textMention){
this.individual = 
				InvestigationMethod.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public InvestigationMethod(){
this.individual = null;
this.textMention = null;
}
	public InvestigationMethod(InvestigationMethod investigationMethod)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = investigationMethod.individual;
this.characterOffset = investigationMethod.getCharacterOffset();
this.characterOnset = investigationMethod.getCharacterOnset();
for (int j = 0; j < investigationMethod.getMakesUseOfApparatus().size(); j++) {if (investigationMethod.getMakesUseOfApparatus().get(j) != null) {makesUseOfApparatus.add((IApparatus) IOBIEThing.getCloneConstructor(investigationMethod.getMakesUseOfApparatus().get(j).getClass()).newInstance(investigationMethod.getMakesUseOfApparatus().get(j)));} else {makesUseOfApparatus.add(null);}}
this.textMention = investigationMethod.getTextMention();
}


	/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
@Override
	public InvestigationMethod addMakesUseOfApparatus(IApparatus apparatus){
		this.makesUseOfApparatus.add(apparatus);
return this;}
	/***/
@Override
	public boolean equals(Object obj){
		if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
InvestigationMethod other = (InvestigationMethod) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (makesUseOfApparatus == null) {
if (other.makesUseOfApparatus!= null)
return false;
} else if (!makesUseOfApparatus.equals(other.makesUseOfApparatus))
return false;
if (textMention == null) {
if (other.textMention!= null)
return false;
} else if (!textMention.equals(other.textMention))
return false;
if (characterOffset == null) {
if (other.characterOffset!= null)
return false;
} else if (!characterOffset.equals(other.characterOffset))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
return true;
}
	/***/
@Override
	public Integer getCharacterOffset(){
		return characterOffset;}
	/***/
@Override
	public Integer getCharacterOnset(){
		return characterOnset;}
	/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
@Override
	public List<IApparatus> getMakesUseOfApparatus(){
		return makesUseOfApparatus;}
	/***/
@Override
	public String getONTOLOGY_NAME(){
		return ONTOLOGY_NAME;}
	/***/
@Override
	public Model getRDFModel(String resourceIDPrefix){
		Model model = ModelFactory.createDefaultModel();
Resource group = model.createResource(getResourceName());
model.add(group, model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),model.createResource(ONTOLOGY_NAME));
return model;
}
	/***/
@Override
	public String getResourceName(){
		if (resourceFactory.containsKey(this)) {
return ISCIOThing.RDF_MODEL_NAMESPACE + resourceFactory.get(this);
} else {
final String resourceName = getClass().getSimpleName() + "_" + resourceFactory.size();
resourceFactory.put(this, resourceName);
return ISCIOThing.RDF_MODEL_NAMESPACE + resourceName;}
}
	/***/
@Override
	public String getTextMention(){
		return textMention;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.makesUseOfApparatus == null) ? 0 : this.makesUseOfApparatus.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
return result;}
	/***/
@Override
	public boolean isEmpty(){
		boolean isEmpty = true;
return false;}
	/***/
@Override
	public void setCharacterOnset(Integer onset){
		this.characterOnset = onset;
 this.characterOffset = onset + textMention.length();}
	/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
@Override
	public InvestigationMethod setMakesUseOfApparatus(List<IApparatus> apparatus){
		if(apparatus==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.makesUseOfApparatus = apparatus;
return this;}


@Override
public String toString(){
return "InvestigationMethod [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",makesUseOfApparatus="+makesUseOfApparatus+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
