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
<p>trend
<p>
<p><b>scio:visualizationContainer</b>
<p>Result_Group
<p>
<p><b>rdfs:description</b>
<p>Trend is the outcome or result of an investigative test.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@DirectInterface(get=ITrend.class)

@SuperRootClasses(get={Trend.class, })

@DirectSiblings(get={})

@AssignableSubClasses(get={RepeatedMeasureTrend.class, SingleMeasureTrend.class, })
 public class Trend implements ITrend{

final public static IndividualFactory<TrendIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = TrendIndividual.class;
static class TrendIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public TrendIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "TrendIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<TrendIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final TrendIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Trend";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDifference")
private IObservedDifference observedDifference;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasSignificance")
private ISignificance significance;
	@TextMention
final private String textMention;


	public Trend(String individualURI, String textMention){
this.individual = 
				Trend.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public Trend(Trend trend)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = trend.individual;
this.characterOffset = trend.getCharacterOffset();
this.characterOnset = trend.getCharacterOnset();
if(trend.getObservedDifference()!=null)this.observedDifference = (IObservedDifference) IOBIEThing.getCloneConstructor(trend.getObservedDifference().getClass())	.newInstance(trend.getObservedDifference());
if(trend.getSignificance()!=null)this.significance = (ISignificance) IOBIEThing.getCloneConstructor(trend.getSignificance().getClass())	.newInstance(trend.getSignificance());
this.textMention = trend.getTextMention();
}
	public Trend(){
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
Trend other = (Trend) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (observedDifference == null) {
if (other.observedDifference!= null)
return false;
} else if (!observedDifference.equals(other.observedDifference))
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
if (significance == null) {
if (other.significance!= null)
return false;
} else if (!significance.equals(other.significance))
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
	/**
<p><b>rdfs:label</b>
<p>has difference
<p>*/
@Override
	public IObservedDifference getObservedDifference(){
		return observedDifference;}
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
<p><b>scio:example</b>
<p>As shown in Figure 1A, female animals treated with E2 were significantly better compared to vehicletreated females at day 7 (p less than 0.5) post-injury, but this difference did not persist.
<p>
<p><b>rdfs:label</b>
<p>has significance
<p>
<p><b>rdfs:comment</b>
<p>Property of the result. It points at the significance information for a result which can be \"yes\" or \"no\".
<p>*/
@Override
	public ISignificance getSignificance(){
		return significance;}
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
result = prime * result + ((this.observedDifference == null) ? 0 : this.observedDifference.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.significance == null) ? 0 : this.significance.hashCode());
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
<p>has difference
<p>*/
@Override
	public Trend setObservedDifference(IObservedDifference observedDifference){
		this.observedDifference = observedDifference;
return this;}
	/**
<p><b>scio:example</b>
<p>As shown in Figure 1A, female animals treated with E2 were significantly better compared to vehicletreated females at day 7 (p less than 0.5) post-injury, but this difference did not persist.
<p>
<p><b>rdfs:label</b>
<p>has significance
<p>
<p><b>rdfs:comment</b>
<p>Property of the result. It points at the significance information for a result which can be \"yes\" or \"no\".
<p>*/
@Override
	public Trend setSignificance(ISignificance significance){
		this.significance = significance;
return this;}


@Override
public String toString(){
return "Trend [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",observedDifference="+observedDifference+",serialVersionUID="+serialVersionUID+",significance="+significance+",textMention="+textMention+"]";}


}
