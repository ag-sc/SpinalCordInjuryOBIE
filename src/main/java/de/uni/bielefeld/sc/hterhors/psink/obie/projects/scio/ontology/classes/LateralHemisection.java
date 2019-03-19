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
import de.hterhors.obie.core.ontology.InvestigationRestriction;
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
<p><b>scio:example</b>
<p>Injured animals received a high cervical (C2) lateral hemisection (Hx), which compromises supraspinal input to ipsilateral spinal motoneurons controlling the upper extremities (forelimb) in the adult rat.
<p>
<p><b>rdfs:label</b>
<p>lateral hemisection
<p>
<p><b>rdfs:description</b>
<p>Lateral Hemisection is the partial transection of the lateral aspect of the spinal cord at one side.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1089/neu.2014.3718
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubClasses(get={})

@SuperRootClasses(get={Injury.class, })

@DirectInterface(get=ILateralHemisection.class)

@DirectSiblings(get={VentralHemisection.class, DorsalHemisection.class, LateralHemisection.class, })
 public class LateralHemisection implements ILateralHemisection{

final public static IndividualFactory<LateralHemisectionIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = LateralHemisectionIndividual.class;
static class LateralHemisectionIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public LateralHemisectionIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "LateralHemisectionIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<LateralHemisectionIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final LateralHemisectionIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public LateralHemisection setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/LateralHemisection";
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasAnimalCareCondition")
@RelationTypeCollection
private List<IAnimalCareCondition> animalCareConditions = new ArrayList<>();
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDirection")
private IDirection direction;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasInjuryAnaesthesia")
@RelationTypeCollection
private List<IAnaesthetic> injuryAnaesthesiaAnaesthetics = new ArrayList<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasInjuryArea")
private IInjuryArea injuryArea;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasInjuryDevice")
private IInjuryDevice injuryDevice;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasInjuryIntensity")
private IInjuryIntensity injuryIntensity;
	@RelationTypeCollection
@OntologyModelContent(ontologyName="http://psink.de/scio/hasInjuryPostsurgicalCare")
private List<IAnimalCareCondition> injuryPostsurgicalCareAnimalCareConditions = new ArrayList<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasInjuryLocation")
private IVertebralLocation injuryVertebralLocation;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasMedication")
@RelationTypeCollection
private List<IMedicationDuringSurgery> medicationDuringSurgeries = new ArrayList<>();
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTemporalInterval")
@RelationTypeCollection
private List<ITemporalInterval> temporalIntervals = new ArrayList<>();
	@TextMention
final private String textMention;


	public LateralHemisection(LateralHemisection lateralHemisection)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = lateralHemisection.individual;
this.investigationRestriction = lateralHemisection.investigationRestriction;
for (int j = 0; j < lateralHemisection.getAnimalCareConditions().size(); j++) {if (lateralHemisection.getAnimalCareConditions().get(j) != null) {animalCareConditions.add((IAnimalCareCondition) IOBIEThing.getCloneConstructor(lateralHemisection.getAnimalCareConditions().get(j).getClass()).newInstance(lateralHemisection.getAnimalCareConditions().get(j)));} else {animalCareConditions.add(null);}}
this.characterOffset = lateralHemisection.getCharacterOffset();
this.characterOnset = lateralHemisection.getCharacterOnset();
if(lateralHemisection.getDirection()!=null)this.direction = (IDirection) IOBIEThing.getCloneConstructor(lateralHemisection.getDirection().getClass())	.newInstance(lateralHemisection.getDirection());
for (int j = 0; j < lateralHemisection.getInjuryAnaesthesiaAnaesthetics().size(); j++) {if (lateralHemisection.getInjuryAnaesthesiaAnaesthetics().get(j) != null) {injuryAnaesthesiaAnaesthetics.add((IAnaesthetic) IOBIEThing.getCloneConstructor(lateralHemisection.getInjuryAnaesthesiaAnaesthetics().get(j).getClass()).newInstance(lateralHemisection.getInjuryAnaesthesiaAnaesthetics().get(j)));} else {injuryAnaesthesiaAnaesthetics.add(null);}}
if(lateralHemisection.getInjuryArea()!=null)this.injuryArea = (IInjuryArea) IOBIEThing.getCloneConstructor(lateralHemisection.getInjuryArea().getClass())	.newInstance(lateralHemisection.getInjuryArea());
if(lateralHemisection.getInjuryDevice()!=null)this.injuryDevice = (IInjuryDevice) IOBIEThing.getCloneConstructor(lateralHemisection.getInjuryDevice().getClass())	.newInstance(lateralHemisection.getInjuryDevice());
if(lateralHemisection.getInjuryIntensity()!=null)this.injuryIntensity = (IInjuryIntensity) IOBIEThing.getCloneConstructor(lateralHemisection.getInjuryIntensity().getClass())	.newInstance(lateralHemisection.getInjuryIntensity());
for (int j = 0; j < lateralHemisection.getInjuryPostsurgicalCareAnimalCareConditions().size(); j++) {if (lateralHemisection.getInjuryPostsurgicalCareAnimalCareConditions().get(j) != null) {injuryPostsurgicalCareAnimalCareConditions.add((IAnimalCareCondition) IOBIEThing.getCloneConstructor(lateralHemisection.getInjuryPostsurgicalCareAnimalCareConditions().get(j).getClass()).newInstance(lateralHemisection.getInjuryPostsurgicalCareAnimalCareConditions().get(j)));} else {injuryPostsurgicalCareAnimalCareConditions.add(null);}}
if(lateralHemisection.getInjuryVertebralLocation()!=null)this.injuryVertebralLocation = (IVertebralLocation) IOBIEThing.getCloneConstructor(lateralHemisection.getInjuryVertebralLocation().getClass())	.newInstance(lateralHemisection.getInjuryVertebralLocation());
for (int j = 0; j < lateralHemisection.getMedicationDuringSurgeries().size(); j++) {if (lateralHemisection.getMedicationDuringSurgeries().get(j) != null) {medicationDuringSurgeries.add((IMedicationDuringSurgery) IOBIEThing.getCloneConstructor(lateralHemisection.getMedicationDuringSurgeries().get(j).getClass()).newInstance(lateralHemisection.getMedicationDuringSurgeries().get(j)));} else {medicationDuringSurgeries.add(null);}}
for (int j = 0; j < lateralHemisection.getTemporalIntervals().size(); j++) {if (lateralHemisection.getTemporalIntervals().get(j) != null) {temporalIntervals.add((ITemporalInterval) IOBIEThing.getCloneConstructor(lateralHemisection.getTemporalIntervals().get(j).getClass()).newInstance(lateralHemisection.getTemporalIntervals().get(j)));} else {temporalIntervals.add(null);}}
this.textMention = lateralHemisection.getTextMention();
}
	public LateralHemisection(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				LateralHemisection.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public LateralHemisection(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}


	/**
<p><b>rdfs:label</b>
<p>has animal care condition
<p>*/
@Override
	public LateralHemisection addAnimalCareCondition(IAnimalCareCondition animalCareCondition){
		this.animalCareConditions.add(animalCareCondition);
return this;}
	/**
<p><b>scio:example</b>
<p>The animals were anesthetized by an intraperitoneal (ip) injection of 10 mg/kg xylasine (Bayer Birlesik Alman _Ilac¸ Fabrikalari T.A.S., Istanbul, Turkey) and 50 mg/kg ketamine hydrochloride (Parke Davis, _Istanbul, Turkey).
<p>
<p><b>rdfs:label</b>
<p>has injury anaesthesia
<p>
<p><b>rdfs:comment</b>
<p>Property of injury type. Points at anaesthetic. Type of anasthaesia during spinal cord injury surgery. Given before any procedure is carried out.
<p>*/
@Override
	public LateralHemisection addInjuryAnaesthesiaAnaesthetic(IAnaesthetic anaesthetic){
		this.injuryAnaesthesiaAnaesthetics.add(anaesthetic);
return this;}
	/**
<p><b>scio:example</b>
<p>\"Post-operative care procedures involved providing the
mice with drinking water in the cage as well as both softened
rat chow and regular pellets placed directly in the cage.
Manual expression of the bladder was also required twice
daily. In total, 124 mice were used. Of these, 51 animals were
kept throughout the survival period in the non-temperature
controlled environment, and 73 in the temperature controlled
environment.\"
<p>
<p><b>rdfs:label</b>
<p>has injury postsurgical care
<p>
<p><b>rdfs:comment</b>
<p>Property of injury type. Points at the class postsurgical care. Any treatment given to the animal immedialtely after surgery to insure its survival and compliance.
<p>*/
@Override
	public LateralHemisection addInjuryPostsurgicalCareAnimalCareCondition(IAnimalCareCondition animalCareCondition){
		this.injuryPostsurgicalCareAnimalCareConditions.add(animalCareCondition);
return this;}
	/**
<p><b>rdfs:label</b>
<p>has medication
<p>*/
@Override
	public LateralHemisection addMedicationDuringSurgery(IMedicationDuringSurgery medicationDuringSurgery){
		this.medicationDuringSurgeries.add(medicationDuringSurgery);
return this;}
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public LateralHemisection addTemporalInterval(ITemporalInterval temporalInterval){
		this.temporalIntervals.add(temporalInterval);
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
LateralHemisection other = (LateralHemisection) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (investigationRestriction == null) {
if (other.investigationRestriction!= null)
return false;
} else if (!investigationRestriction.equals(other.investigationRestriction))
return false;
if (temporalIntervals == null) {
if (other.temporalIntervals!= null)
return false;
} else if (!temporalIntervals.equals(other.temporalIntervals))
return false;
if (characterOffset == null) {
if (other.characterOffset!= null)
return false;
} else if (!characterOffset.equals(other.characterOffset))
return false;
if (injuryVertebralLocation == null) {
if (other.injuryVertebralLocation!= null)
return false;
} else if (!injuryVertebralLocation.equals(other.injuryVertebralLocation))
return false;
if (injuryPostsurgicalCareAnimalCareConditions == null) {
if (other.injuryPostsurgicalCareAnimalCareConditions!= null)
return false;
} else if (!injuryPostsurgicalCareAnimalCareConditions.equals(other.injuryPostsurgicalCareAnimalCareConditions))
return false;
if (injuryIntensity == null) {
if (other.injuryIntensity!= null)
return false;
} else if (!injuryIntensity.equals(other.injuryIntensity))
return false;
if (injuryDevice == null) {
if (other.injuryDevice!= null)
return false;
} else if (!injuryDevice.equals(other.injuryDevice))
return false;
if (direction == null) {
if (other.direction!= null)
return false;
} else if (!direction.equals(other.direction))
return false;
if (injuryAnaesthesiaAnaesthetics == null) {
if (other.injuryAnaesthesiaAnaesthetics!= null)
return false;
} else if (!injuryAnaesthesiaAnaesthetics.equals(other.injuryAnaesthesiaAnaesthetics))
return false;
if (animalCareConditions == null) {
if (other.animalCareConditions!= null)
return false;
} else if (!animalCareConditions.equals(other.animalCareConditions))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
if (medicationDuringSurgeries == null) {
if (other.medicationDuringSurgeries!= null)
return false;
} else if (!medicationDuringSurgeries.equals(other.medicationDuringSurgeries))
return false;
if (injuryArea == null) {
if (other.injuryArea!= null)
return false;
} else if (!injuryArea.equals(other.injuryArea))
return false;
if (textMention == null) {
if (other.textMention!= null)
return false;
} else if (!textMention.equals(other.textMention))
return false;
return true;
}
	/**
<p><b>rdfs:label</b>
<p>has animal care condition
<p>*/
@Override
	public List<IAnimalCareCondition> getAnimalCareConditions(){
		return animalCareConditions;}
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
<p>has direction
<p>*/
@Override
	public IDirection getDirection(){
		return direction;}
	/**
<p><b>scio:example</b>
<p>The animals were anesthetized by an intraperitoneal (ip) injection of 10 mg/kg xylasine (Bayer Birlesik Alman _Ilac¸ Fabrikalari T.A.S., Istanbul, Turkey) and 50 mg/kg ketamine hydrochloride (Parke Davis, _Istanbul, Turkey).
<p>
<p><b>rdfs:label</b>
<p>has injury anaesthesia
<p>
<p><b>rdfs:comment</b>
<p>Property of injury type. Points at anaesthetic. Type of anasthaesia during spinal cord injury surgery. Given before any procedure is carried out.
<p>*/
@Override
	public List<IAnaesthetic> getInjuryAnaesthesiaAnaesthetics(){
		return injuryAnaesthesiaAnaesthetics;}
	/**
<p><b>scio:example</b>
<p>The entire right side of the cord was severed from the midline to the far right border of the cord forming a rostral and caudal segment.
<p>
<p><b>rdfs:label</b>
<p>has injury location
<p>
<p><b>rdfs:comment</b>
<p>Property of the injury. Points at the injury area. Refers to the anatomical region of the lesion inside of the spinal cord. This property points at the injury area, which can be \"dorsal\", \"ventral\", \"complete\" etc.
<p>*/
@Override
	public IInjuryArea getInjuryArea(){
		return injuryArea;}
	/**
<p><b>scio:example</b>
<p>\"The rat was then secured to the platform of the IH Impactor
(Precision Systems Instrumentation, Fairfax, VA) using toothed forceps secured to the vertebral elements......Extradural compression of the spinal cord at the vertebral level of T3/4 was achieved using a modified aneurysm clip.\"
<p>
<p><b>rdfs:label</b>
<p>has injury device
<p>
<p><b>rdfs:comment</b>
<p>Property of injury type. Points at injury device. Apparatus or instrument used for spinal cord injury.
<p>*/
@Override
	public IInjuryDevice getInjuryDevice(){
		return injuryDevice;}
	/**
<p><b>scio:example</b>
<p>Extradural compression of the spinal cord at the vertebral level of T3/4 was achieved using a modified aneurysm clip (Joshi and Fehlings, 2002a) with a closing force of 8 g producing mechanical trauma of moderate intensity. The clip was left in place for 1 min and then removed.
<p>
<p><b>rdfs:label</b>
<p>has injury intensity
<p>
<p><b>rdfs:comment</b>
<p>Property of the injury type. Points at the injury intensity class. The severity of the spinal cord lesion as mentioned by the author, i.e. usually mild, moderate or severe. Also applies for other mentions used by the author as \"medium\" or \"light\".
<p>*/
@Override
	public IInjuryIntensity getInjuryIntensity(){
		return injuryIntensity;}
	/**
<p><b>scio:example</b>
<p>\"Post-operative care procedures involved providing the
mice with drinking water in the cage as well as both softened
rat chow and regular pellets placed directly in the cage.
Manual expression of the bladder was also required twice
daily. In total, 124 mice were used. Of these, 51 animals were
kept throughout the survival period in the non-temperature
controlled environment, and 73 in the temperature controlled
environment.\"
<p>
<p><b>rdfs:label</b>
<p>has injury postsurgical care
<p>
<p><b>rdfs:comment</b>
<p>Property of injury type. Points at the class postsurgical care. Any treatment given to the animal immedialtely after surgery to insure its survival and compliance.
<p>*/
@Override
	public List<IAnimalCareCondition> getInjuryPostsurgicalCareAnimalCareConditions(){
		return injuryPostsurgicalCareAnimalCareConditions;}
	/**
<p><b>scio:example</b>
<p>Spinal cord injury was carried out in the mid thoracic region at levels T6-T9.
<p>
<p><b>rdfs:label</b>
<p>has injury height
<p>
<p><b>rdfs:comment</b>
<p>Property of injury type. Points at injury height and injury height detail. Refers to the anatomical region of the spinal cord. For example cervical, thoracic, lumbar etc. .
<p>*/
@Override
	public IVertebralLocation getInjuryVertebralLocation(){
		return injuryVertebralLocation;}
	/**
<p><b>rdfs:label</b>
<p>has medication
<p>*/
@Override
	public List<IMedicationDuringSurgery> getMedicationDuringSurgeries(){
		return medicationDuringSurgeries;}
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
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public List<ITemporalInterval> getTemporalIntervals(){
		return temporalIntervals;}
	/***/
@Override
	public String getTextMention(){
		return textMention;}
	/***/
@Override
	public IOBIEThing getThis(){
		return this;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.investigationRestriction == null) ? 0 : this.investigationRestriction.hashCode());
result = prime * result + ((this.temporalIntervals == null) ? 0 : this.temporalIntervals.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.injuryVertebralLocation == null) ? 0 : this.injuryVertebralLocation.hashCode());
result = prime * result + ((this.injuryPostsurgicalCareAnimalCareConditions == null) ? 0 : this.injuryPostsurgicalCareAnimalCareConditions.hashCode());
result = prime * result + ((this.injuryIntensity == null) ? 0 : this.injuryIntensity.hashCode());
result = prime * result + ((this.injuryDevice == null) ? 0 : this.injuryDevice.hashCode());
result = prime * result + ((this.direction == null) ? 0 : this.direction.hashCode());
result = prime * result + ((this.injuryAnaesthesiaAnaesthetics == null) ? 0 : this.injuryAnaesthesiaAnaesthetics.hashCode());
result = prime * result + ((this.animalCareConditions == null) ? 0 : this.animalCareConditions.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.medicationDuringSurgeries == null) ? 0 : this.medicationDuringSurgeries.hashCode());
result = prime * result + ((this.injuryArea == null) ? 0 : this.injuryArea.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
return result;}
	/***/
@Override
	public boolean isEmpty(){
		boolean isEmpty = true;
return false;}
	/**
<p><b>rdfs:label</b>
<p>has animal care condition
<p>*/
@Override
	public LateralHemisection setAnimalCareConditions(List<IAnimalCareCondition> animalCareConditions){
		if(animalCareConditions==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.animalCareConditions = animalCareConditions;
return this;}
	/***/
@Override
	public void setCharacterOnset(Integer onset){
		this.characterOnset = onset;
 this.characterOffset = onset + textMention.length();}
	/**
<p><b>rdfs:label</b>
<p>has direction
<p>*/
@Override
	public LateralHemisection setDirection(IDirection direction){
		this.direction = direction;
return this;}
	/**
<p><b>scio:example</b>
<p>The animals were anesthetized by an intraperitoneal (ip) injection of 10 mg/kg xylasine (Bayer Birlesik Alman _Ilac¸ Fabrikalari T.A.S., Istanbul, Turkey) and 50 mg/kg ketamine hydrochloride (Parke Davis, _Istanbul, Turkey).
<p>
<p><b>rdfs:label</b>
<p>has injury anaesthesia
<p>
<p><b>rdfs:comment</b>
<p>Property of injury type. Points at anaesthetic. Type of anasthaesia during spinal cord injury surgery. Given before any procedure is carried out.
<p>*/
@Override
	public LateralHemisection setInjuryAnaesthesiaAnaesthetics(List<IAnaesthetic> anaesthetics){
		if(anaesthetics==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.injuryAnaesthesiaAnaesthetics = anaesthetics;
return this;}
	/**
<p><b>scio:example</b>
<p>The entire right side of the cord was severed from the midline to the far right border of the cord forming a rostral and caudal segment.
<p>
<p><b>rdfs:label</b>
<p>has injury location
<p>
<p><b>rdfs:comment</b>
<p>Property of the injury. Points at the injury area. Refers to the anatomical region of the lesion inside of the spinal cord. This property points at the injury area, which can be \"dorsal\", \"ventral\", \"complete\" etc.
<p>*/
@Override
	public LateralHemisection setInjuryArea(IInjuryArea injuryArea){
		this.injuryArea = injuryArea;
return this;}
	/**
<p><b>scio:example</b>
<p>\"The rat was then secured to the platform of the IH Impactor
(Precision Systems Instrumentation, Fairfax, VA) using toothed forceps secured to the vertebral elements......Extradural compression of the spinal cord at the vertebral level of T3/4 was achieved using a modified aneurysm clip.\"
<p>
<p><b>rdfs:label</b>
<p>has injury device
<p>
<p><b>rdfs:comment</b>
<p>Property of injury type. Points at injury device. Apparatus or instrument used for spinal cord injury.
<p>*/
@Override
	public LateralHemisection setInjuryDevice(IInjuryDevice injuryDevice){
		this.injuryDevice = injuryDevice;
return this;}
	/**
<p><b>scio:example</b>
<p>Extradural compression of the spinal cord at the vertebral level of T3/4 was achieved using a modified aneurysm clip (Joshi and Fehlings, 2002a) with a closing force of 8 g producing mechanical trauma of moderate intensity. The clip was left in place for 1 min and then removed.
<p>
<p><b>rdfs:label</b>
<p>has injury intensity
<p>
<p><b>rdfs:comment</b>
<p>Property of the injury type. Points at the injury intensity class. The severity of the spinal cord lesion as mentioned by the author, i.e. usually mild, moderate or severe. Also applies for other mentions used by the author as \"medium\" or \"light\".
<p>*/
@Override
	public LateralHemisection setInjuryIntensity(IInjuryIntensity injuryIntensity){
		this.injuryIntensity = injuryIntensity;
return this;}
	/**
<p><b>scio:example</b>
<p>\"Post-operative care procedures involved providing the
mice with drinking water in the cage as well as both softened
rat chow and regular pellets placed directly in the cage.
Manual expression of the bladder was also required twice
daily. In total, 124 mice were used. Of these, 51 animals were
kept throughout the survival period in the non-temperature
controlled environment, and 73 in the temperature controlled
environment.\"
<p>
<p><b>rdfs:label</b>
<p>has injury postsurgical care
<p>
<p><b>rdfs:comment</b>
<p>Property of injury type. Points at the class postsurgical care. Any treatment given to the animal immedialtely after surgery to insure its survival and compliance.
<p>*/
@Override
	public LateralHemisection setInjuryPostsurgicalCareAnimalCareConditions(List<IAnimalCareCondition> animalCareConditions){
		if(animalCareConditions==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.injuryPostsurgicalCareAnimalCareConditions = animalCareConditions;
return this;}
	/**
<p><b>scio:example</b>
<p>Spinal cord injury was carried out in the mid thoracic region at levels T6-T9.
<p>
<p><b>rdfs:label</b>
<p>has injury height
<p>
<p><b>rdfs:comment</b>
<p>Property of injury type. Points at injury height and injury height detail. Refers to the anatomical region of the spinal cord. For example cervical, thoracic, lumbar etc. .
<p>*/
@Override
	public LateralHemisection setInjuryVertebralLocation(IVertebralLocation vertebralLocation){
		this.injuryVertebralLocation = vertebralLocation;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has medication
<p>*/
@Override
	public LateralHemisection setMedicationDuringSurgeries(List<IMedicationDuringSurgery> medicationDuringSurgeries){
		if(medicationDuringSurgeries==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.medicationDuringSurgeries = medicationDuringSurgeries;
return this;}
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public LateralHemisection setTemporalIntervals(List<ITemporalInterval> temporalIntervals){
		if(temporalIntervals==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.temporalIntervals = temporalIntervals;
return this;}


@Override
public String toString(){
return "LateralHemisection [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",animalCareConditions="+animalCareConditions+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",direction="+direction+",injuryAnaesthesiaAnaesthetics="+injuryAnaesthesiaAnaesthetics+",injuryArea="+injuryArea+",injuryDevice="+injuryDevice+",injuryIntensity="+injuryIntensity+",injuryPostsurgicalCareAnimalCareConditions="+injuryPostsurgicalCareAnimalCareConditions+",injuryVertebralLocation="+injuryVertebralLocation+",medicationDuringSurgeries="+medicationDuringSurgeries+",serialVersionUID="+serialVersionUID+",temporalIntervals="+temporalIntervals+",textMention="+textMention+"]";}


}
