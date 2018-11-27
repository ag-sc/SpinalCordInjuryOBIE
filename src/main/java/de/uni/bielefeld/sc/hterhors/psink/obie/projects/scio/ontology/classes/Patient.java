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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/116154003
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C16960
<p>
<p><b>rdfs:label</b>
<p>patient
<p>
<p><b>rdfs:description</b>
<p>Patient is a person who receives medical attention, care, or treatment, or who is registered with medical professional or institution with the purpose to receive medical care when necessary.
<p>
<p><b>scio:clinicalTerm</b>
<p>true
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@DirectSiblings(get={AnimalModel.class, Patient.class, })

@AssignableSubClasses(get={})

@SuperRootClasses(get={OrganismModel.class, })

@DirectInterface(get=IPatient.class)
 public class Patient implements IPatient{

final public static IndividualFactory<PatientIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = PatientIndividual.class;
static class PatientIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public PatientIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "PatientIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<PatientIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final PatientIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Patient";
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasAge")
private IAge age;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasAgeCategory")
private IAgeCategory ageCategory;
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasGender")
private IGender gender;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasOrganismSpecies")
private IOrganismSpecies organismSpecies;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasWeight")
private IWeight weight;


	public Patient(String individualURI, String textMention){
this.individual = 
				Patient.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public Patient(Patient patient)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = patient.individual;
if(patient.getAge()!=null)this.age = (IAge) IOBIEThing.getCloneConstructor(patient.getAge().getClass())	.newInstance(patient.getAge());
if(patient.getAgeCategory()!=null)this.ageCategory = (IAgeCategory) IOBIEThing.getCloneConstructor(patient.getAgeCategory().getClass())	.newInstance(patient.getAgeCategory());
this.characterOffset = patient.getCharacterOffset();
this.characterOnset = patient.getCharacterOnset();
if(patient.getGender()!=null)this.gender = (IGender) IOBIEThing.getCloneConstructor(patient.getGender().getClass())	.newInstance(patient.getGender());
if(patient.getOrganismSpecies()!=null)this.organismSpecies = (IOrganismSpecies) IOBIEThing.getCloneConstructor(patient.getOrganismSpecies().getClass())	.newInstance(patient.getOrganismSpecies());
this.textMention = patient.getTextMention();
if(patient.getWeight()!=null)this.weight = (IWeight) IOBIEThing.getCloneConstructor(patient.getWeight().getClass())	.newInstance(patient.getWeight());
}
	public Patient(){
this.individual = null;
this.textMention = null;
}


	/***/
@Override
	public boolean equals(Object obj){
		if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Patient other = (Patient) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (gender == null) {
if (other.gender!= null)
return false;
} else if (!gender.equals(other.gender))
return false;
if (ageCategory == null) {
if (other.ageCategory!= null)
return false;
} else if (!ageCategory.equals(other.ageCategory))
return false;
if (organismSpecies == null) {
if (other.organismSpecies!= null)
return false;
} else if (!organismSpecies.equals(other.organismSpecies))
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
if (age == null) {
if (other.age!= null)
return false;
} else if (!age.equals(other.age))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
if (weight == null) {
if (other.weight!= null)
return false;
} else if (!weight.equals(other.weight))
return false;
return true;
}
	/**
<p><b>rdfs:label</b>
<p>has age
<p>*/
@Override
	public IAge getAge(){
		return age;}
	/**
<p><b>scio:example</b>
<p>Three groups of male Sprague-Dawley rats, including young (40 days), mature (5-6 months) and old (28-29 months) were spinally hemisected at the L1 level.
<p>
<p><b>rdfs:label</b>
<p>has age category
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal type. Points at the animal age. Age of the animal at time of injury, young or adult or aged.
<p>
<p><b>rdfs:description</b>
<p>Specific age stated in days weeks, months or years.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26024702
<p>*/
@Override
	public IAgeCategory getAgeCategory(){
		return ageCategory;}
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
<p>Adult male Wistar albino rats weighing 200–250 g were used in this study.
<p>
<p><b>rdfs:label</b>
<p>has gender
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal type. Points at the animal gender. It can be female, male or mixed gender group of animals.
<p>*/
@Override
	public IGender getGender(){
		return gender;}
	/***/
@Override
	public String getONTOLOGY_NAME(){
		return ONTOLOGY_NAME;}
	/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
@Override
	public IOrganismSpecies getOrganismSpecies(){
		return organismSpecies;}
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
	/**
<p><b>scio:example</b>
<p>After laminectomy, the vertebral column was stabilized with clamps and a 10 g rod was dropped from a 12.5 mm height over the exposed spinal cord and the compression maintained for 5 seconds.
<p>
<p><b>rdfs:label</b>
<p>has weight
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal or of an injury device detail. Points at the supporting class \"weight\" which can be in g, mg etc.
<p>
<p><b>rdfs:description</b>
<p>Any weight measured in µg, g or other units.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26896212
<p>*/
@Override
	public IWeight getWeight(){
		return weight;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.gender == null) ? 0 : this.gender.hashCode());
result = prime * result + ((this.ageCategory == null) ? 0 : this.ageCategory.hashCode());
result = prime * result + ((this.organismSpecies == null) ? 0 : this.organismSpecies.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.age == null) ? 0 : this.age.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.weight == null) ? 0 : this.weight.hashCode());
return result;}
	/***/
@Override
	public boolean isEmpty(){
		boolean isEmpty = true;
return false;}
	/**
<p><b>rdfs:label</b>
<p>has age
<p>*/
@Override
	public Patient setAge(IAge age){
		this.age = age;
return this;}
	/**
<p><b>scio:example</b>
<p>Three groups of male Sprague-Dawley rats, including young (40 days), mature (5-6 months) and old (28-29 months) were spinally hemisected at the L1 level.
<p>
<p><b>rdfs:label</b>
<p>has age category
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal type. Points at the animal age. Age of the animal at time of injury, young or adult or aged.
<p>
<p><b>rdfs:description</b>
<p>Specific age stated in days weeks, months or years.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26024702
<p>*/
@Override
	public Patient setAgeCategory(IAgeCategory ageCategory){
		this.ageCategory = ageCategory;
return this;}
	/***/
@Override
	public void setCharacterOnset(Integer onset){
		this.characterOnset = onset;
 this.characterOffset = onset + textMention.length();}
	/**
<p><b>scio:example</b>
<p>Adult male Wistar albino rats weighing 200–250 g were used in this study.
<p>
<p><b>rdfs:label</b>
<p>has gender
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal type. Points at the animal gender. It can be female, male or mixed gender group of animals.
<p>*/
@Override
	public Patient setGender(IGender gender){
		this.gender = gender;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
@Override
	public Patient setOrganismSpecies(IOrganismSpecies organismSpecies){
		this.organismSpecies = organismSpecies;
return this;}
	/**
<p><b>scio:example</b>
<p>After laminectomy, the vertebral column was stabilized with clamps and a 10 g rod was dropped from a 12.5 mm height over the exposed spinal cord and the compression maintained for 5 seconds.
<p>
<p><b>rdfs:label</b>
<p>has weight
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal or of an injury device detail. Points at the supporting class \"weight\" which can be in g, mg etc.
<p>
<p><b>rdfs:description</b>
<p>Any weight measured in µg, g or other units.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26896212
<p>*/
@Override
	public Patient setWeight(IWeight weight){
		this.weight = weight;
return this;}


@Override
public String toString(){
return "Patient [individual="+individual+",age="+age+",ageCategory="+ageCategory+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",gender="+gender+",organismSpecies="+organismSpecies+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",weight="+weight+"]";}


}
