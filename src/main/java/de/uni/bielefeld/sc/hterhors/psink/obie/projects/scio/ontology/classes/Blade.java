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
<p>Half of the spinal cord (left side) was then transected at thoracic position (T) 10 with a razor blade.
<p>
<p><b>rdfs:label</b>
<p>blade
<p>
<p><b>rdfs:description</b>
<p>Blade is a class of sharp cutting instruments like razor blades, scalpels etc.
<p>
<p><b>scio:exampleSource</b>
<p>doi:  10.3390/ijms131013484
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@SuperRootClasses(get={InjuryDevice.class, })

@DirectInterface(get=IBlade.class)

@DirectSiblings(get={Scissors.class, Blade.class, })

@AssignableSubClasses(get={})
 public class Blade implements IBlade{

final public static IndividualFactory<BladeIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = BladeIndividual.class;
static class BladeIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public BladeIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "BladeIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<BladeIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final BladeIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Blade";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasLongitude")
private ILength longitudeLength;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasThickness")
private IThickness thickness;


	public Blade(String individualURI, String textMention){
this.individual = 
				Blade.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public Blade(Blade blade)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = blade.individual;
this.characterOffset = blade.getCharacterOffset();
this.characterOnset = blade.getCharacterOnset();
if(blade.getLongitudeLength()!=null)this.longitudeLength = (ILength) IOBIEThing.getCloneConstructor(blade.getLongitudeLength().getClass())	.newInstance(blade.getLongitudeLength());
this.textMention = blade.getTextMention();
if(blade.getThickness()!=null)this.thickness = (IThickness) IOBIEThing.getCloneConstructor(blade.getThickness().getClass())	.newInstance(blade.getThickness());
}
	public Blade(){
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
Blade other = (Blade) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (thickness == null) {
if (other.thickness!= null)
return false;
} else if (!thickness.equals(other.thickness))
return false;
if (longitudeLength == null) {
if (other.longitudeLength!= null)
return false;
} else if (!longitudeLength.equals(other.longitudeLength))
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
<p>has longitude
<p>
<p><b>rdfs:comment</b>
<p>The physical dimension of a blade as an injury device.
<p>*/
@Override
	public ILength getLongitudeLength(){
		return longitudeLength;}
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
<p><b>rdfs:label</b>
<p>has thickness
<p>*/
@Override
	public IThickness getThickness(){
		return thickness;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.thickness == null) ? 0 : this.thickness.hashCode());
result = prime * result + ((this.longitudeLength == null) ? 0 : this.longitudeLength.hashCode());
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
<p>has longitude
<p>
<p><b>rdfs:comment</b>
<p>The physical dimension of a blade as an injury device.
<p>*/
@Override
	public Blade setLongitudeLength(ILength length){
		this.longitudeLength = length;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has thickness
<p>*/
@Override
	public Blade setThickness(IThickness thickness){
		this.thickness = thickness;
return this;}


@Override
public String toString(){
return "Blade [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",longitudeLength="+longitudeLength+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",thickness="+thickness+"]";}


}
