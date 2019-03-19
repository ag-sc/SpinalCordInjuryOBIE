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
<p><b>skos:closeMatch</b>
<p>false
<p>
<p><b>scio:example</b>
<p>A 2-French Fogarty catheter is inserted into the dorsal epidural space through a small hole made in T10 vertebral arch, advanced cranially to T8-9 spinal level, and inflated for 5 min.
<p>
<p><b>rdfs:label</b>
<p>fogarty balloon catheter
<p>
<p><b>rdfs:description</b>
<p>Fogarty Balloon Catheter is a special balloon catheter device to induce compression injury to the spinal cord.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 11780869
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubClasses(get={})

@DirectSiblings(get={FogartyBalloonCatheter.class, })

@SuperRootClasses(get={InjuryDevice.class, })

@DirectInterface(get=IFogartyBalloonCatheter.class)
 public class FogartyBalloonCatheter implements IFogartyBalloonCatheter{

final public static IndividualFactory<FogartyBalloonCatheterIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = FogartyBalloonCatheterIndividual.class;
static class FogartyBalloonCatheterIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public FogartyBalloonCatheterIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "FogartyBalloonCatheterIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<FogartyBalloonCatheterIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final FogartyBalloonCatheterIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public FogartyBalloonCatheter setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/FogartyBalloonCatheter";
	private Integer characterOffset;
	private Integer characterOnset;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasForce")
private IForce force;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasPressure")
private IPressure pressure;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasVolume")
@DatatypeProperty
private IVolume volume;


	public FogartyBalloonCatheter(FogartyBalloonCatheter fogartyBalloonCatheter)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = fogartyBalloonCatheter.individual;
this.investigationRestriction = fogartyBalloonCatheter.investigationRestriction;
this.characterOffset = fogartyBalloonCatheter.getCharacterOffset();
this.characterOnset = fogartyBalloonCatheter.getCharacterOnset();
if(fogartyBalloonCatheter.getForce()!=null)this.force = new Force((Force)fogartyBalloonCatheter.getForce());
if(fogartyBalloonCatheter.getPressure()!=null)this.pressure = new Pressure((Pressure)fogartyBalloonCatheter.getPressure());
this.textMention = fogartyBalloonCatheter.getTextMention();
if(fogartyBalloonCatheter.getVolume()!=null)this.volume = new Volume((Volume)fogartyBalloonCatheter.getVolume());
}
	public FogartyBalloonCatheter(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				FogartyBalloonCatheter.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public FogartyBalloonCatheter(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
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
FogartyBalloonCatheter other = (FogartyBalloonCatheter) obj;
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
if (pressure == null) {
if (other.pressure!= null)
return false;
} else if (!pressure.equals(other.pressure))
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
if (characterOffset == null) {
if (other.characterOffset!= null)
return false;
} else if (!characterOffset.equals(other.characterOffset))
return false;
if (volume == null) {
if (other.volume!= null)
return false;
} else if (!volume.equals(other.volume))
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
	/**
<p><b>rdfs:label</b>
<p>has pressure
<p>*/
@Override
	public IPressure getPressure(){
		return pressure;}
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
	/**
<p><b>rdfs:label</b>
<p>has volume
<p>*/
@Override
	public IVolume getVolume(){
		return volume;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.investigationRestriction == null) ? 0 : this.investigationRestriction.hashCode());
result = prime * result + ((this.pressure == null) ? 0 : this.pressure.hashCode());
result = prime * result + ((this.force == null) ? 0 : this.force.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.volume == null) ? 0 : this.volume.hashCode());
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
	public FogartyBalloonCatheter setForce(IForce force){
		this.force = force;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has pressure
<p>*/
@Override
	public FogartyBalloonCatheter setPressure(IPressure pressure){
		this.pressure = pressure;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has volume
<p>*/
@Override
	public FogartyBalloonCatheter setVolume(IVolume volume){
		this.volume = volume;
return this;}


@Override
public String toString(){
return "FogartyBalloonCatheter [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",force="+force+",pressure="+pressure+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",volume="+volume+"]";}


}
