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
<p>http://purl.obolibrary.org/obo/OBI_0000708
<p>
<p><b>skos:closeMatch</b>
<p>
<p>
<p><b>rdfs:label</b>
<p>animal care condition
<p>
<p><b>scio:visualizationContainer</b>
<p>Injury_Group
<p>
<p><b>rdfs:description</b>
<p>Animal care condition is a process performed according to an animal care protocol, which specifies the conditions of animal keeping and pre- and postsurgical medical care. Depending on the severity of the injury, medication and special care like e.g. manual bladder voiding is necessary in the postsurgical phase.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@SuperRootClasses(get={AnimalCareCondition.class, })

@DirectSiblings(get={})

@AssignableSubClasses(get={KetamineAsAnaesthetic.class, PostSurgeryCondition.class, Halothane.class, Xylazine.class, ChloralHydrate.class, Glycopyrrolate.class, BodyTemperatureMeasurement.class, MedicationDuringSurgery.class, Isoflurane.class, AntibioticMedication.class, FluanisoneMidazolamMixture.class, SodiumPentobarbital.class, ThiopentalSodium.class, Anaesthetic.class, KeepingCondition.class, NitrousOxide.class, AtropineSulfate.class, PostsurgicalMedication.class, Sedative.class, Diazepam.class, })

@DirectInterface(get=IAnimalCareCondition.class)
 public class AnimalCareCondition implements IAnimalCareCondition{

final public static IndividualFactory<AnimalCareConditionIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = AnimalCareConditionIndividual.class;
static class AnimalCareConditionIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public AnimalCareConditionIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "AnimalCareConditionIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<AnimalCareConditionIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final AnimalCareConditionIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/AnimalCareCondition";
	private Integer characterOffset;
	private Integer characterOnset;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public AnimalCareCondition(String individualURI, String textMention){
this.individual = 
				AnimalCareCondition.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public AnimalCareCondition(AnimalCareCondition animalCareCondition)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = animalCareCondition.individual;
this.characterOffset = animalCareCondition.getCharacterOffset();
this.characterOnset = animalCareCondition.getCharacterOnset();
this.textMention = animalCareCondition.getTextMention();
}
	public AnimalCareCondition(){
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
AnimalCareCondition other = (AnimalCareCondition) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
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


@Override
public String toString(){
return "AnimalCareCondition [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
