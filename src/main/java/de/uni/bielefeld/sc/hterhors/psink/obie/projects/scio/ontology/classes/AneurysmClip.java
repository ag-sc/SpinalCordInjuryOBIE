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
<p><b>scio:example</b>
<p>The spinal cord was injured by cord compression with a 24 g modified aneurysm clip for 1 min, resulting in a moderate SCI.
<p>
<p><b>rdfs:label</b>
<p>aneurysm clip
<p>
<p><b>rdfs:description</b>
<p>Aneurysm clip is a surgical instrument used to treat a balloon-like bulge of an artery wall known as an aneurysm. In experimental spinal cord injury studies these clips are used to inflict compression lesions to the spinal cord.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.biomaterials.2015.12.032
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@SuperRootClasses(get={InjuryDevice.class, })

@DirectSiblings(get={AneurysmClip.class, EpiduralClip.class, IrisClip.class, })

@AssignableSubClasses(get={})

@DirectInterface(get=IAneurysmClip.class)
 public class AneurysmClip implements IAneurysmClip{

final public static IndividualFactory<AneurysmClipIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = AneurysmClipIndividual.class;
static class AneurysmClipIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public AneurysmClipIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "AneurysmClipIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<AneurysmClipIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final AneurysmClipIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/AneurysmClip";
	private Integer characterOffset;
	private Integer characterOnset;
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


	public AneurysmClip(AneurysmClip aneurysmClip)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = aneurysmClip.individual;
this.characterOffset = aneurysmClip.getCharacterOffset();
this.characterOnset = aneurysmClip.getCharacterOnset();
if(aneurysmClip.getDuration()!=null)this.duration = (IDuration) IOBIEThing.getCloneConstructor(aneurysmClip.getDuration().getClass())	.newInstance(aneurysmClip.getDuration());
if(aneurysmClip.getForce()!=null)this.force = (IForce) IOBIEThing.getCloneConstructor(aneurysmClip.getForce().getClass())	.newInstance(aneurysmClip.getForce());
this.textMention = aneurysmClip.getTextMention();
if(aneurysmClip.getWeight()!=null)this.weight = (IWeight) IOBIEThing.getCloneConstructor(aneurysmClip.getWeight().getClass())	.newInstance(aneurysmClip.getWeight());
}
	public AneurysmClip(String individualURI, String textMention){
this.individual = 
				AneurysmClip.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public AneurysmClip(){
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
AneurysmClip other = (AneurysmClip) obj;
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
	public AneurysmClip setDuration(IDuration duration){
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
	public AneurysmClip setForce(IForce force){
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
	public AneurysmClip setWeight(IWeight weight){
		this.weight = weight;
return this;}


@Override
public String toString(){
return "AneurysmClip [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",duration="+duration+",force="+force+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",weight="+weight+"]";}


}
