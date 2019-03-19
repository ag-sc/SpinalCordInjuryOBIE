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
import de.hterhors.obie.core.ontology.InvestigationRestriction;
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
<p>spinal central part
<p>
<p><b>rdfs:description</b>
<p>Spinal Central Part is the tissue in the spinal cord which is in the center, i.e. in the area of the central canal and surrounding tissue.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@SuperRootClasses(get={Location.class, })

@AssignableSubClasses(get={})

@DirectSiblings(get={SpinalFiberTract.class, SpinalSubduralArea.class, SpinalDorsalHalf.class, SpinalCentralPart.class, SpinalGrayMatter.class, SpinalLesionSite.class, SpinalVentralHalf.class, SpinalWhiteMatter.class, })

@DirectInterface(get=ISpinalCentralPart.class)
 public class SpinalCentralPart implements ISpinalCentralPart{

final public static IndividualFactory<SpinalCentralPartIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = SpinalCentralPartIndividual.class;
static class SpinalCentralPartIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public SpinalCentralPartIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "SpinalCentralPartIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<SpinalCentralPartIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final SpinalCentralPartIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public SpinalCentralPart setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/SpinalCentralPart";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDepth")
@DatatypeProperty
private IDepth depth;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasDistance")
private IDistance distance;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public SpinalCentralPart(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				SpinalCentralPart.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public SpinalCentralPart(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public SpinalCentralPart(SpinalCentralPart spinalCentralPart)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = spinalCentralPart.individual;
this.investigationRestriction = spinalCentralPart.investigationRestriction;
this.characterOffset = spinalCentralPart.getCharacterOffset();
this.characterOnset = spinalCentralPart.getCharacterOnset();
if(spinalCentralPart.getDepth()!=null)this.depth = new Depth((Depth)spinalCentralPart.getDepth());
if(spinalCentralPart.getDistance()!=null)this.distance = new Distance((Distance)spinalCentralPart.getDistance());
this.textMention = spinalCentralPart.getTextMention();
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
SpinalCentralPart other = (SpinalCentralPart) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (investigationRestriction == null) {
if (other.investigationRestriction!= null)
return false;
} else if (!investigationRestriction.equals(other.investigationRestriction))
return false;
if (distance == null) {
if (other.distance!= null)
return false;
} else if (!distance.equals(other.distance))
return false;
if (depth == null) {
if (other.depth!= null)
return false;
} else if (!depth.equals(other.depth))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
if (characterOffset == null) {
if (other.characterOffset!= null)
return false;
} else if (!characterOffset.equals(other.characterOffset))
return false;
if (textMention == null) {
if (other.textMention!= null)
return false;
} else if (!textMention.equals(other.textMention))
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
<p>has depth
<p>
<p><b>rdfs:comment</b>
<p>Depth is the distance from the dorsal surface of the spinal cord in ventral direction if a substance is injected locally (or a implant is placed).

Some treatment paradigms consist of multiple injections at different depths in the spinal cord. These single injections are not considered single treatments. In order to model these the object property \"hasCompositeCompound\" is used where multiple application protocols with the same substance can be merged to a \"composite compound\" treatment.
<p>*/
@Override
	public IDepth getDepth(){
		return depth;}
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
	public IOBIEThing getThis(){
		return this;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.investigationRestriction == null) ? 0 : this.investigationRestriction.hashCode());
result = prime * result + ((this.distance == null) ? 0 : this.distance.hashCode());
result = prime * result + ((this.depth == null) ? 0 : this.depth.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
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
<p>has depth
<p>
<p><b>rdfs:comment</b>
<p>Depth is the distance from the dorsal surface of the spinal cord in ventral direction if a substance is injected locally (or a implant is placed).

Some treatment paradigms consist of multiple injections at different depths in the spinal cord. These single injections are not considered single treatments. In order to model these the object property \"hasCompositeCompound\" is used where multiple application protocols with the same substance can be merged to a \"composite compound\" treatment.
<p>*/
@Override
	public SpinalCentralPart setDepth(IDepth depth){
		this.depth = depth;
return this;}
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
	public SpinalCentralPart setDistance(IDistance distance){
		this.distance = distance;
return this;}


@Override
public String toString(){
return "SpinalCentralPart [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",depth="+depth+",distance="+distance+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
