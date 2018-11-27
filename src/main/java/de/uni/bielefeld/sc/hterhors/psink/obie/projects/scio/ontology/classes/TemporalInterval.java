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
<p>temporal interval
<p>
<p><b>scio:visualizationContainer</b>
<p>Observation_Group
<p>
<p><b>rdfs:description</b>
<p>Temporal Interval is a measured time instance in any unit (minutes, hours, days etc.).
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@SuperRootClasses(get={TemporalInterval.class, })

@DirectSiblings(get={})

@AssignableSubClasses(get={})

@DirectInterface(get=ITemporalInterval.class)
 public class TemporalInterval implements ITemporalInterval{

final public static IndividualFactory<TemporalIntervalIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = TemporalIntervalIndividual.class;
static class TemporalIntervalIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public TemporalIntervalIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "TemporalIntervalIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<TemporalIntervalIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final TemporalIntervalIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/TemporalInterval";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDuration")
private IDuration duration;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasEventAfter")
private IEvent eventAfter;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasEventBefore")
private IEvent eventBefore;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public TemporalInterval(){
this.individual = null;
this.textMention = null;
}
	public TemporalInterval(TemporalInterval temporalInterval)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = temporalInterval.individual;
this.characterOffset = temporalInterval.getCharacterOffset();
this.characterOnset = temporalInterval.getCharacterOnset();
if(temporalInterval.getDuration()!=null)this.duration = (IDuration) IOBIEThing.getCloneConstructor(temporalInterval.getDuration().getClass())	.newInstance(temporalInterval.getDuration());
if(temporalInterval.getEventAfter()!=null)this.eventAfter = (IEvent) IOBIEThing.getCloneConstructor(temporalInterval.getEventAfter().getClass())	.newInstance(temporalInterval.getEventAfter());
if(temporalInterval.getEventBefore()!=null)this.eventBefore = (IEvent) IOBIEThing.getCloneConstructor(temporalInterval.getEventBefore().getClass())	.newInstance(temporalInterval.getEventBefore());
this.textMention = temporalInterval.getTextMention();
}
	public TemporalInterval(String individualURI, String textMention){
this.individual = 
				TemporalInterval.individualFactory.getIndividualByURI(individualURI);
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
TemporalInterval other = (TemporalInterval) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (eventBefore == null) {
if (other.eventBefore!= null)
return false;
} else if (!eventBefore.equals(other.eventBefore))
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
if (duration == null) {
if (other.duration!= null)
return false;
} else if (!duration.equals(other.duration))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
if (eventAfter == null) {
if (other.eventAfter!= null)
return false;
} else if (!eventAfter.equals(other.eventAfter))
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
@Override
	public IDuration getDuration(){
		return duration;}
	/**
<p><b>rdfs:label</b>
<p>has event after
<p>*/
@Override
	public IEvent getEventAfter(){
		return eventAfter;}
	/**
<p><b>rdfs:label</b>
<p>has event before
<p>*/
@Override
	public IEvent getEventBefore(){
		return eventBefore;}
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
result = prime * result + ((this.eventBefore == null) ? 0 : this.eventBefore.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.duration == null) ? 0 : this.duration.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.eventAfter == null) ? 0 : this.eventAfter.hashCode());
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
@Override
	public TemporalInterval setDuration(IDuration duration){
		this.duration = duration;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has event after
<p>*/
@Override
	public TemporalInterval setEventAfter(IEvent event){
		this.eventAfter = event;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has event before
<p>*/
@Override
	public TemporalInterval setEventBefore(IEvent event){
		this.eventBefore = event;
return this;}


@Override
public String toString(){
return "TemporalInterval [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",duration="+duration+",eventAfter="+eventAfter+",eventBefore="+eventBefore+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
