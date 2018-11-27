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
<p><b>rdfs:label</b>
<p>person
<p>
<p><b>scio:visualizationContainer</b>
<p>Experimental_Design_Group
<p>
<p><b>rdfs:description</b>
<p>Person is the author of a published study.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@DirectSiblings(get={})

@AssignableSubClasses(get={})

@SuperRootClasses(get={Person.class, })

@DirectInterface(get=IPerson.class)
 public class Person implements IPerson{

final public static IndividualFactory<PersonIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = PersonIndividual.class;
static class PersonIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public PersonIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "PersonIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<PersonIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final PersonIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Person";
	private Integer characterOffset;
	private Integer characterOnset;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasName")
private IName name;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public Person(){
this.individual = null;
this.textMention = null;
}
	public Person(Person person)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = person.individual;
this.characterOffset = person.getCharacterOffset();
this.characterOnset = person.getCharacterOnset();
if(person.getName()!=null)this.name = new Name((Name)person.getName());
this.textMention = person.getTextMention();
}
	public Person(String individualURI, String textMention){
this.individual = 
				Person.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
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
Person other = (Person) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (name == null) {
if (other.name!= null)
return false;
} else if (!name.equals(other.name))
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
<p>has name
<p>
<p><b>rdfs:comment</b>
<p>The name of this person.
<p>*/
@Override
	public IName getName(){
		return name;}
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
result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
<p>has name
<p>
<p><b>rdfs:comment</b>
<p>The name of this person.
<p>*/
@Override
	public Person setName(IName name){
		this.name = name;
return this;}


@Override
public String toString(){
return "Person [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",name="+name+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
