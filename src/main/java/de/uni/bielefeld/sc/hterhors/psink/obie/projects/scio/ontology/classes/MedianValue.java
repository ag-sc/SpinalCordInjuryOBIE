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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/260528009
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C28007
<p>
<p><b>rdfs:label</b>
<p>median value
<p>
<p><b>rdfs:description</b>
<p>Median Value is the value which has an equal number of values greater and less than it.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@SuperRootClasses(get={NumericValue.class, })

@AssignableSubClasses(get={})

@DirectSiblings(get={MedianValue.class, MeanValue.class, })

@DirectInterface(get=IMedianValue.class)
 public class MedianValue implements IMedianValue{

final public static IndividualFactory<MedianValueIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = MedianValueIndividual.class;
static class MedianValueIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public MedianValueIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "MedianValueIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<MedianValueIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final MedianValueIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/MedianValue";
	private Integer characterOffset;
	private Integer characterOnset;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasStandardDeviation")
private IStandardDeviation standardDeviation;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasStandardError")
private IStandardError standardError;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasValue")
@DatatypeProperty
private IValue value;


	public MedianValue(){
this.individual = null;
this.textMention = null;
}
	public MedianValue(String individualURI, String textMention){
this.individual = 
				MedianValue.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public MedianValue(MedianValue medianValue)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = medianValue.individual;
this.characterOffset = medianValue.getCharacterOffset();
this.characterOnset = medianValue.getCharacterOnset();
if(medianValue.getStandardDeviation()!=null)this.standardDeviation = new StandardDeviation((StandardDeviation)medianValue.getStandardDeviation());
if(medianValue.getStandardError()!=null)this.standardError = new StandardError((StandardError)medianValue.getStandardError());
this.textMention = medianValue.getTextMention();
if(medianValue.getValue()!=null)this.value = new Value((Value)medianValue.getValue());
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
MedianValue other = (MedianValue) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (value == null) {
if (other.value!= null)
return false;
} else if (!value.equals(other.value))
return false;
if (standardDeviation == null) {
if (other.standardDeviation!= null)
return false;
} else if (!standardDeviation.equals(other.standardDeviation))
return false;
if (standardError == null) {
if (other.standardError!= null)
return false;
} else if (!standardError.equals(other.standardError))
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
	/**
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=standard+deviation
<p>
<p><b>rdfs:label</b>
<p>has standard deviation
<p>
<p><b>rdfs:description</b>
<p>Property of the

Normal Distribution

Continuous frequency distribution of infinite range. Its properties are as follows: 1, continuous, symmetrical distribution with both tails extending to infinity; 2, arithmetic mean, mode, and median identical; and 3, shape completely determined by the mean and standard deviation.
<p>*/
@Override
	public IStandardDeviation getStandardDeviation(){
		return standardDeviation;}
	/**
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=standard+deviation
<p>
<p><b>rdfs:label</b>
<p>has standard error
<p>
<p><b>rdfs:description</b>
<p>Property of the

Normal Distribution

Continuous frequency distribution of infinite range. Its properties are as follows: 1, continuous, symmetrical distribution with both tails extending to infinity; 2, arithmetic mean, mode, and median identical; and 3, shape completely determined by the mean and standard deviation.
<p>*/
@Override
	public IStandardError getStandardError(){
		return standardError;}
	/***/
@Override
	public String getTextMention(){
		return textMention;}
	/**
<p><b>rdfs:label</b>
<p>has value
<p>*/
@Override
	public IValue getValue(){
		return value;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
result = prime * result + ((this.standardDeviation == null) ? 0 : this.standardDeviation.hashCode());
result = prime * result + ((this.standardError == null) ? 0 : this.standardError.hashCode());
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
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=standard+deviation
<p>
<p><b>rdfs:label</b>
<p>has standard deviation
<p>
<p><b>rdfs:description</b>
<p>Property of the

Normal Distribution

Continuous frequency distribution of infinite range. Its properties are as follows: 1, continuous, symmetrical distribution with both tails extending to infinity; 2, arithmetic mean, mode, and median identical; and 3, shape completely determined by the mean and standard deviation.
<p>*/
@Override
	public MedianValue setStandardDeviation(IStandardDeviation standardDeviation){
		this.standardDeviation = standardDeviation;
return this;}
	/**
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=standard+deviation
<p>
<p><b>rdfs:label</b>
<p>has standard error
<p>
<p><b>rdfs:description</b>
<p>Property of the

Normal Distribution

Continuous frequency distribution of infinite range. Its properties are as follows: 1, continuous, symmetrical distribution with both tails extending to infinity; 2, arithmetic mean, mode, and median identical; and 3, shape completely determined by the mean and standard deviation.
<p>*/
@Override
	public MedianValue setStandardError(IStandardError standardError){
		this.standardError = standardError;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has value
<p>*/
@Override
	public MedianValue setValue(IValue value){
		this.value = value;
return this;}


@Override
public String toString(){
return "MedianValue [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",serialVersionUID="+serialVersionUID+",standardDeviation="+standardDeviation+",standardError="+standardError+",textMention="+textMention+",value="+value+"]";}


}
