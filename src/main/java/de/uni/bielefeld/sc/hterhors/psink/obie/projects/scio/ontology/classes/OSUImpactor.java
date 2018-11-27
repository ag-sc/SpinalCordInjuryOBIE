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
<p><b>scio:descriptionSource</b>
<p>doi: 10.1038/sc.2014.91
<p>
<p><b>scio:example</b>
<p>With half of the animal's weight suspended, the animal was positioned under the Ohio State University (OSU) Impactor, and the impactor tip was gently lowered to apply a pre-load force of 0.2 kdyn onto the dura.
<p>
<p><b>rdfs:label</b>
<p>osu impactor
<p>
<p><b>rdfs:description</b>
<p>OSU or Ohio State University Impactor is an instrument for accurate and specific weight drop on the exposed spinal cord. The procedure involves laminectomy at the target level and spine stabilization using clamping. Similar to the IH impactor, the OSU device uses a computer feedback-controlled electromagnetic impactor. When triggered, a probe contacts and displaces the cord 30 μm to provide a replicable starting point. Then, the instrument compresses the cord a predetermined distance, generally between 0.8 and 1.1 mm, for a set amount of time, ~4 to 5 ms. The OSU device avoids multiple strikes, as the impounder is actively withdrawn.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.expneurol.2009.11.006
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@SuperRootClasses(get={InjuryDevice.class, })

@AssignableSubClasses(get={})

@DirectInterface(get=IOSUImpactor.class)

@DirectSiblings(get={InfiniteHorizonImpactor.class, NYUImpactor.class, AllenWeightDropDevice.class, MASCISImpactor.class, OSUImpactor.class, UnivOfTriesteImpactor.class, })
 public class OSUImpactor implements IOSUImpactor{

final public static IndividualFactory<OSUImpactorIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = OSUImpactorIndividual.class;
static class OSUImpactorIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public OSUImpactorIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "OSUImpactorIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<OSUImpactorIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final OSUImpactorIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/OSUImpactor";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDistance")
private IDistance distance;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDuration")
private IDuration duration;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasForce")
private IForce force;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasWeight")
private IWeight weight;


	public OSUImpactor(){
this.individual = null;
this.textMention = null;
}
	public OSUImpactor(OSUImpactor oSUImpactor)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = oSUImpactor.individual;
this.characterOffset = oSUImpactor.getCharacterOffset();
this.characterOnset = oSUImpactor.getCharacterOnset();
if(oSUImpactor.getDistance()!=null)this.distance = (IDistance) IOBIEThing.getCloneConstructor(oSUImpactor.getDistance().getClass())	.newInstance(oSUImpactor.getDistance());
if(oSUImpactor.getDuration()!=null)this.duration = (IDuration) IOBIEThing.getCloneConstructor(oSUImpactor.getDuration().getClass())	.newInstance(oSUImpactor.getDuration());
if(oSUImpactor.getForce()!=null)this.force = (IForce) IOBIEThing.getCloneConstructor(oSUImpactor.getForce().getClass())	.newInstance(oSUImpactor.getForce());
this.textMention = oSUImpactor.getTextMention();
if(oSUImpactor.getWeight()!=null)this.weight = (IWeight) IOBIEThing.getCloneConstructor(oSUImpactor.getWeight().getClass())	.newInstance(oSUImpactor.getWeight());
}
	public OSUImpactor(String individualURI, String textMention){
this.individual = 
				OSUImpactor.individualFactory.getIndividualByURI(individualURI);
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
OSUImpactor other = (OSUImpactor) obj;
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
if (duration == null) {
if (other.duration!= null)
return false;
} else if (!duration.equals(other.duration))
return false;
if (force == null) {
if (other.force!= null)
return false;
} else if (!force.equals(other.force))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
if (distance == null) {
if (other.distance!= null)
return false;
} else if (!distance.equals(other.distance))
return false;
if (weight == null) {
if (other.weight!= null)
return false;
} else if (!weight.equals(other.weight))
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
<p>The intact T10 spinal cord was contused with the NYU weight-drop device (from a height of 50 mm).
<p>
<p><b>rdfs:label</b>
<p>has distance
<p>
<p><b>rdfs:comment</b>
<p>Distance describes the physical distance of a weight in a weight drop device with respect to the spinal cord surface and also - in the context of a treatment locus - the distance of the application points in relation to a reference point. Thid can be e.g. 1 mm dorsal from the lesion epicenter. 

Some treatment paradigms consist of multiple injections at different locations in the spinal cord. These single injections are not considered single treatments. In order to model these the object property \"hasCompositeCompound\" is used where multiple application protocols with the same substance can be merged to a \"composite compound\" treatment.
<p>
<p><b>rdfs:description</b>
<p>Measure of spatial distance in µm, mm, cm or other units.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1111/cns.12429
<p>*/
@Override
	public IDistance getDistance(){
		return distance;}
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
<p><b>scio:example</b>
<p>In order to induce SCI, a standard weight-drop method that induced a moderately severe injury (100 g/cm force) at T10 was used.
<p>
<p><b>rdfs:label</b>
<p>has force
<p>
<p><b>rdfs:description</b>
<p>Pertains to the force of e.g. a clip device or an impactor for spinal cord injury or a measured force in a behavioural test.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.jss.2013.02.016
<p>*/
@Override
	public IForce getForce(){
		return force;}
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
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.duration == null) ? 0 : this.duration.hashCode());
result = prime * result + ((this.force == null) ? 0 : this.force.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.distance == null) ? 0 : this.distance.hashCode());
result = prime * result + ((this.weight == null) ? 0 : this.weight.hashCode());
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
<p>The intact T10 spinal cord was contused with the NYU weight-drop device (from a height of 50 mm).
<p>
<p><b>rdfs:label</b>
<p>has distance
<p>
<p><b>rdfs:comment</b>
<p>Distance describes the physical distance of a weight in a weight drop device with respect to the spinal cord surface and also - in the context of a treatment locus - the distance of the application points in relation to a reference point. Thid can be e.g. 1 mm dorsal from the lesion epicenter. 

Some treatment paradigms consist of multiple injections at different locations in the spinal cord. These single injections are not considered single treatments. In order to model these the object property \"hasCompositeCompound\" is used where multiple application protocols with the same substance can be merged to a \"composite compound\" treatment.
<p>
<p><b>rdfs:description</b>
<p>Measure of spatial distance in µm, mm, cm or other units.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1111/cns.12429
<p>*/
@Override
	public OSUImpactor setDistance(IDistance distance){
		this.distance = distance;
return this;}
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
	public OSUImpactor setDuration(IDuration duration){
		this.duration = duration;
return this;}
	/**
<p><b>scio:example</b>
<p>In order to induce SCI, a standard weight-drop method that induced a moderately severe injury (100 g/cm force) at T10 was used.
<p>
<p><b>rdfs:label</b>
<p>has force
<p>
<p><b>rdfs:description</b>
<p>Pertains to the force of e.g. a clip device or an impactor for spinal cord injury or a measured force in a behavioural test.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.jss.2013.02.016
<p>*/
@Override
	public OSUImpactor setForce(IForce force){
		this.force = force;
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
	public OSUImpactor setWeight(IWeight weight){
		this.weight = weight;
return this;}


@Override
public String toString(){
return "OSUImpactor [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",distance="+distance+",duration="+duration+",force="+force+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",weight="+weight+"]";}


}
