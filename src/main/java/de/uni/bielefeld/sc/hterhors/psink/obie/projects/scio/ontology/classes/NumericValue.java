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
<p>numeric value
<p>
<p><b>scio:visualizationContainer</b>
<p>Observation_Group
<p>
<p><b>rdfs:description</b>
<p>Numeric Value is the measured quantitative value in an experiment.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@DirectSiblings(get={})

@SuperRootClasses(get={NumericValue.class, })

@AssignableSubClasses(get={MedianValue.class, MeanValue.class, })

@DirectInterface(get=INumericValue.class)
 public class NumericValue implements INumericValue{

final public static IndividualFactory<NumericValueIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = NumericValueIndividual.class;
static class NumericValueIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public NumericValueIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "NumericValueIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<NumericValueIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final NumericValueIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/NumericValue";
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


	public NumericValue(NumericValue numericValue)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = numericValue.individual;
this.characterOffset = numericValue.getCharacterOffset();
this.characterOnset = numericValue.getCharacterOnset();
if(numericValue.getStandardDeviation()!=null)this.standardDeviation = new StandardDeviation((StandardDeviation)numericValue.getStandardDeviation());
if(numericValue.getStandardError()!=null)this.standardError = new StandardError((StandardError)numericValue.getStandardError());
this.textMention = numericValue.getTextMention();
if(numericValue.getValue()!=null)this.value = new Value((Value)numericValue.getValue());
}
	public NumericValue(){
this.individual = null;
this.textMention = null;
}
	public NumericValue(String individualURI, String textMention){
this.individual = 
				NumericValue.individualFactory.getIndividualByURI(individualURI);
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
NumericValue other = (NumericValue) obj;
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
	public NumericValue setStandardDeviation(IStandardDeviation standardDeviation){
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
	public NumericValue setStandardError(IStandardError standardError){
		this.standardError = standardError;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has value
<p>*/
@Override
	public NumericValue setValue(IValue value){
		this.value = value;
return this;}


@Override
public String toString(){
return "NumericValue [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",serialVersionUID="+serialVersionUID+",standardDeviation="+standardDeviation+",standardError="+standardError+",textMention="+textMention+",value="+value+"]";}


}
