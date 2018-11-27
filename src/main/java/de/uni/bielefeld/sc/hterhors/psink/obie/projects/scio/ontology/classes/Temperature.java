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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/703421000
<p>
<p><b>scio:descriptionSource</b>
<p>http://purl.bioontology.org/ontology/MESH/D013696
<p>
<p><b>scio:example</b>
<p>An epidural perfusion device was applied to maintain a steady temperature (18 °C) for 120 min with gradual rewarming to 37 °C
<p>
<p><b>rdfs:label</b>
<p>temperature
<p>
<p><b>rdfs:description</b>
<p>Temperature is the property of objects that determines the direction of heat flow when they are placed in direct thermal contact. The temperature is the energy of microscopic motions (vibrational and translational) of the particles of atoms.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26322652
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@DirectInterface(get=ITemperature.class)

@DirectSiblings(get={})

@DatatypeProperty
@SuperRootClasses(get={Temperature.class, })

@AssignableSubClasses(get={})
 public class Temperature implements ITemperature{

	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Temperature";
	private Integer characterOffset;
	private Integer characterOnset;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final private String semanticValue;
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public Temperature(){
this.semanticValue = null;
this.textMention = null;
}
	public Temperature(Temperature temperature){
this.characterOffset = temperature.getCharacterOffset();
this.characterOnset = temperature.getCharacterOnset();
this.semanticValue = temperature.getSemanticValue();
this.textMention = temperature.getTextMention();
}
	public Temperature(String semanticValue, String textMention){
this.semanticValue = semanticValue;
this.textMention = textMention;
}
	public Temperature(String semanticValue){
this.semanticValue = semanticValue;
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
Temperature other = (Temperature) obj;
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
if (semanticValue == null) {
if (other.semanticValue!= null)
return false;
} else if (!semanticValue.equals(other.semanticValue))
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
	/***/
@Override
	public String getSemanticValue(){
		return semanticValue;}
	/***/
@Override
	public String getTextMention(){
		return textMention;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.semanticValue == null) ? 0 : this.semanticValue.hashCode());
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


@Override
public String toString(){
return "Temperature [characterOffset="+characterOffset+",characterOnset="+characterOnset+",semanticValue="+semanticValue+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
