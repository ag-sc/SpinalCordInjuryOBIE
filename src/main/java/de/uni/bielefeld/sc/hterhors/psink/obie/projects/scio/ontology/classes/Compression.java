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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C3380
<p>
<p><b>scio:example</b>
<p>We tested our proposal by administering Huperzine A intraperitoneally to male Wistar Albino rats (220-340 gr body weight) after moderate static clip compression (70 gr for 60 sec) of the spinal cord at T7 level.
<p>
<p><b>rdfs:label</b>
<p>compression
<p>
<p><b>rdfs:description</b>
<p>Compression (or crush) of the spinal cord is a process naturally caused by bone fragments, tumors or other pathological conditions. In the experimental spinal cord injury model, compression means a constant force being inflicted on the spinal cord from one or multiple sides simultaneously. This is in contrast to contusion, where a short term force is inflicted on the spinal cord from one side.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26472141
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@DirectInterface(get=ICompression.class)

@AssignableSubClasses(get={})

@DirectSiblings(get={CompleteTransection.class, Compression.class, Contusion.class, Laminectomy.class, ElectrolyticLesion.class, PhotochemicalInjury.class, Dislocation.class, InjuryByAccident.class, PartialTransection.class, Distraction.class, AspirationLesion.class, ChemicalInjury.class, HeatLesion.class, })

@SuperRootClasses(get={Injury.class, })
 public class Compression implements ICompression{

final public static IndividualFactory<CompressionIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = CompressionIndividual.class;
static class CompressionIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public CompressionIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "CompressionIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<CompressionIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final CompressionIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Compression";
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasAnimalCareCondition")
@RelationTypeCollection
private List<IAnimalCareCondition> animalCareConditions = new ArrayList<>();
	private Integer characterOffset;
	private Integer characterOnset;
	@RelationTypeCollection
@OntologyModelContent(ontologyName="http://psink.de/scio/hasInjuryAnaesthesia")
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
	@RelationTypeCollection
@OntologyModelContent(ontologyName="http://psink.de/scio/hasMedication")
private List<IMedicationDuringSurgery> medicationDuringSurgeries = new ArrayList<>();
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@RelationTypeCollection
@OntologyModelContent(ontologyName="http://psink.de/scio/hasTemporalInterval")
private List<ITemporalInterval> temporalIntervals = new ArrayList<>();
	@TextMention
final private String textMention;


	public Compression(String individualURI, String textMention){
this.individual = 
				Compression.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public Compression(Compression compression)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = compression.individual;
for (int j = 0; j < compression.getAnimalCareConditions().size(); j++) {if (compression.getAnimalCareConditions().get(j) != null) {animalCareConditions.add((IAnimalCareCondition) IOBIEThing.getCloneConstructor(compression.getAnimalCareConditions().get(j).getClass()).newInstance(compression.getAnimalCareConditions().get(j)));} else {animalCareConditions.add(null);}}
this.characterOffset = compression.getCharacterOffset();
this.characterOnset = compression.getCharacterOnset();
for (int j = 0; j < compression.getInjuryAnaesthesiaAnaesthetics().size(); j++) {if (compression.getInjuryAnaesthesiaAnaesthetics().get(j) != null) {injuryAnaesthesiaAnaesthetics.add((IAnaesthetic) IOBIEThing.getCloneConstructor(compression.getInjuryAnaesthesiaAnaesthetics().get(j).getClass()).newInstance(compression.getInjuryAnaesthesiaAnaesthetics().get(j)));} else {injuryAnaesthesiaAnaesthetics.add(null);}}
if(compression.getInjuryArea()!=null)this.injuryArea = (IInjuryArea) IOBIEThing.getCloneConstructor(compression.getInjuryArea().getClass())	.newInstance(compression.getInjuryArea());
if(compression.getInjuryDevice()!=null)this.injuryDevice = (IInjuryDevice) IOBIEThing.getCloneConstructor(compression.getInjuryDevice().getClass())	.newInstance(compression.getInjuryDevice());
if(compression.getInjuryIntensity()!=null)this.injuryIntensity = (IInjuryIntensity) IOBIEThing.getCloneConstructor(compression.getInjuryIntensity().getClass())	.newInstance(compression.getInjuryIntensity());
for (int j = 0; j < compression.getInjuryPostsurgicalCareAnimalCareConditions().size(); j++) {if (compression.getInjuryPostsurgicalCareAnimalCareConditions().get(j) != null) {injuryPostsurgicalCareAnimalCareConditions.add((IAnimalCareCondition) IOBIEThing.getCloneConstructor(compression.getInjuryPostsurgicalCareAnimalCareConditions().get(j).getClass()).newInstance(compression.getInjuryPostsurgicalCareAnimalCareConditions().get(j)));} else {injuryPostsurgicalCareAnimalCareConditions.add(null);}}
if(compression.getInjuryVertebralLocation()!=null)this.injuryVertebralLocation = (IVertebralLocation) IOBIEThing.getCloneConstructor(compression.getInjuryVertebralLocation().getClass())	.newInstance(compression.getInjuryVertebralLocation());
for (int j = 0; j < compression.getMedicationDuringSurgeries().size(); j++) {if (compression.getMedicationDuringSurgeries().get(j) != null) {medicationDuringSurgeries.add((IMedicationDuringSurgery) IOBIEThing.getCloneConstructor(compression.getMedicationDuringSurgeries().get(j).getClass()).newInstance(compression.getMedicationDuringSurgeries().get(j)));} else {medicationDuringSurgeries.add(null);}}
for (int j = 0; j < compression.getTemporalIntervals().size(); j++) {if (compression.getTemporalIntervals().get(j) != null) {temporalIntervals.add((ITemporalInterval) IOBIEThing.getCloneConstructor(compression.getTemporalIntervals().get(j).getClass()).newInstance(compression.getTemporalIntervals().get(j)));} else {temporalIntervals.add(null);}}
this.textMention = compression.getTextMention();
}
	public Compression(){
this.individual = null;
this.textMention = null;
}


	/**
<p><b>rdfs:label</b>
<p>has animal care condition
<p>*/
@Override
	public Compression addAnimalCareCondition(IAnimalCareCondition animalCareCondition){
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
	public Compression addInjuryAnaesthesiaAnaesthetic(IAnaesthetic anaesthetic){
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
	public Compression addInjuryPostsurgicalCareAnimalCareCondition(IAnimalCareCondition animalCareCondition){
		this.injuryPostsurgicalCareAnimalCareConditions.add(animalCareCondition);
return this;}
	/**
<p><b>rdfs:label</b>
<p>has medication
<p>*/
@Override
	public Compression addMedicationDuringSurgery(IMedicationDuringSurgery medicationDuringSurgery){
		this.medicationDuringSurgeries.add(medicationDuringSurgery);
return this;}
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public Compression addTemporalInterval(ITemporalInterval temporalInterval){
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
Compression other = (Compression) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (temporalIntervals == null) {
if (other.temporalIntervals!= null)
return false;
} else if (!temporalIntervals.equals(other.temporalIntervals))
return false;
if (injuryArea == null) {
if (other.injuryArea!= null)
return false;
} else if (!injuryArea.equals(other.injuryArea))
return false;
if (injuryAnaesthesiaAnaesthetics == null) {
if (other.injuryAnaesthesiaAnaesthetics!= null)
return false;
} else if (!injuryAnaesthesiaAnaesthetics.equals(other.injuryAnaesthesiaAnaesthetics))
return false;
if (injuryIntensity == null) {
if (other.injuryIntensity!= null)
return false;
} else if (!injuryIntensity.equals(other.injuryIntensity))
return false;
if (injuryVertebralLocation == null) {
if (other.injuryVertebralLocation!= null)
return false;
} else if (!injuryVertebralLocation.equals(other.injuryVertebralLocation))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
if (animalCareConditions == null) {
if (other.animalCareConditions!= null)
return false;
} else if (!animalCareConditions.equals(other.animalCareConditions))
return false;
if (injuryDevice == null) {
if (other.injuryDevice!= null)
return false;
} else if (!injuryDevice.equals(other.injuryDevice))
return false;
if (medicationDuringSurgeries == null) {
if (other.medicationDuringSurgeries!= null)
return false;
} else if (!medicationDuringSurgeries.equals(other.medicationDuringSurgeries))
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
if (injuryPostsurgicalCareAnimalCareConditions == null) {
if (other.injuryPostsurgicalCareAnimalCareConditions!= null)
return false;
} else if (!injuryPostsurgicalCareAnimalCareConditions.equals(other.injuryPostsurgicalCareAnimalCareConditions))
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
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.temporalIntervals == null) ? 0 : this.temporalIntervals.hashCode());
result = prime * result + ((this.injuryArea == null) ? 0 : this.injuryArea.hashCode());
result = prime * result + ((this.injuryAnaesthesiaAnaesthetics == null) ? 0 : this.injuryAnaesthesiaAnaesthetics.hashCode());
result = prime * result + ((this.injuryIntensity == null) ? 0 : this.injuryIntensity.hashCode());
result = prime * result + ((this.injuryVertebralLocation == null) ? 0 : this.injuryVertebralLocation.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.animalCareConditions == null) ? 0 : this.animalCareConditions.hashCode());
result = prime * result + ((this.injuryDevice == null) ? 0 : this.injuryDevice.hashCode());
result = prime * result + ((this.medicationDuringSurgeries == null) ? 0 : this.medicationDuringSurgeries.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.injuryPostsurgicalCareAnimalCareConditions == null) ? 0 : this.injuryPostsurgicalCareAnimalCareConditions.hashCode());
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
	public Compression setAnimalCareConditions(List<IAnimalCareCondition> animalCareConditions){
		if(animalCareConditions==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.animalCareConditions = animalCareConditions;
return this;}
	/***/
@Override
	public void setCharacterOnset(Integer onset){
		this.characterOnset = onset;
 this.characterOffset = onset + textMention.length();}
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
	public Compression setInjuryAnaesthesiaAnaesthetics(List<IAnaesthetic> anaesthetics){
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
	public Compression setInjuryArea(IInjuryArea injuryArea){
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
	public Compression setInjuryDevice(IInjuryDevice injuryDevice){
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
	public Compression setInjuryIntensity(IInjuryIntensity injuryIntensity){
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
	public Compression setInjuryPostsurgicalCareAnimalCareConditions(List<IAnimalCareCondition> animalCareConditions){
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
	public Compression setInjuryVertebralLocation(IVertebralLocation vertebralLocation){
		this.injuryVertebralLocation = vertebralLocation;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has medication
<p>*/
@Override
	public Compression setMedicationDuringSurgeries(List<IMedicationDuringSurgery> medicationDuringSurgeries){
		if(medicationDuringSurgeries==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.medicationDuringSurgeries = medicationDuringSurgeries;
return this;}
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public Compression setTemporalIntervals(List<ITemporalInterval> temporalIntervals){
		if(temporalIntervals==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.temporalIntervals = temporalIntervals;
return this;}


@Override
public String toString(){
return "Compression [individual="+individual+",animalCareConditions="+animalCareConditions+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",injuryAnaesthesiaAnaesthetics="+injuryAnaesthesiaAnaesthetics+",injuryArea="+injuryArea+",injuryDevice="+injuryDevice+",injuryIntensity="+injuryIntensity+",injuryPostsurgicalCareAnimalCareConditions="+injuryPostsurgicalCareAnimalCareConditions+",injuryVertebralLocation="+injuryVertebralLocation+",medicationDuringSurgeries="+medicationDuringSurgeries+",serialVersionUID="+serialVersionUID+",temporalIntervals="+temporalIntervals+",textMention="+textMention+"]";}


}
