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
<p>vertebral area
<p>
<p><b>rdfs:description</b>
<p>Vertebral Area is a spatial location which spans from a higher vertebral bone to a lower vertebral bone. It can comprise vertebrae from different segments, e.g. T10 to L2.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@DirectSiblings(get={VertebralSegment.class, Vertebrae.class, VertebralArea.class, })

@SuperRootClasses(get={Location.class, })

@AssignableSubClasses(get={})

@DirectInterface(get=IVertebralArea.class)
 public class VertebralArea implements IVertebralArea{

final public static IndividualFactory<VertebralAreaIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = VertebralAreaIndividual.class;
static class VertebralAreaIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public VertebralAreaIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "VertebralAreaIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<VertebralAreaIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final VertebralAreaIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public VertebralArea setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/VertebralArea";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasLowerVertebrae")
private IVertebrae lowerVertebrae;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasUpperVertebrae")
private IVertebrae upperVertebrae;


	public VertebralArea(VertebralArea vertebralArea)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = vertebralArea.individual;
this.investigationRestriction = vertebralArea.investigationRestriction;
this.characterOffset = vertebralArea.getCharacterOffset();
this.characterOnset = vertebralArea.getCharacterOnset();
if(vertebralArea.getLowerVertebrae()!=null)this.lowerVertebrae = (IVertebrae) IOBIEThing.getCloneConstructor(vertebralArea.getLowerVertebrae().getClass())	.newInstance(vertebralArea.getLowerVertebrae());
this.textMention = vertebralArea.getTextMention();
if(vertebralArea.getUpperVertebrae()!=null)this.upperVertebrae = (IVertebrae) IOBIEThing.getCloneConstructor(vertebralArea.getUpperVertebrae().getClass())	.newInstance(vertebralArea.getUpperVertebrae());
}
	public VertebralArea(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				VertebralArea.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public VertebralArea(){
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
VertebralArea other = (VertebralArea) obj;
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
if (lowerVertebrae == null) {
if (other.lowerVertebrae!= null)
return false;
} else if (!lowerVertebrae.equals(other.lowerVertebrae))
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
if (upperVertebrae == null) {
if (other.upperVertebrae!= null)
return false;
} else if (!upperVertebrae.equals(other.upperVertebrae))
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
<p>has lower vertebrae
<p>*/
@Override
	public IVertebrae getLowerVertebrae(){
		return lowerVertebrae;}
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
	/**
<p><b>rdfs:label</b>
<p>has upper vertebrae
<p>*/
@Override
	public IVertebrae getUpperVertebrae(){
		return upperVertebrae;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.investigationRestriction == null) ? 0 : this.investigationRestriction.hashCode());
result = prime * result + ((this.lowerVertebrae == null) ? 0 : this.lowerVertebrae.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.upperVertebrae == null) ? 0 : this.upperVertebrae.hashCode());
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
<p>has lower vertebrae
<p>*/
@Override
	public VertebralArea setLowerVertebrae(IVertebrae vertebrae){
		this.lowerVertebrae = vertebrae;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has upper vertebrae
<p>*/
@Override
	public VertebralArea setUpperVertebrae(IVertebrae vertebrae){
		this.upperVertebrae = vertebrae;
return this;}


@Override
public String toString(){
return "VertebralArea [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",lowerVertebrae="+lowerVertebrae+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",upperVertebrae="+upperVertebrae+"]";}


}
