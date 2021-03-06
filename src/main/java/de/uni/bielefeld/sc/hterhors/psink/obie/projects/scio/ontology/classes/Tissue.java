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
<p>http://purl.obolibrary.org/obo/UBERON_0000479
<p>
<p><b>scio:descriptionSource</b>
<p>http://purl.obolibrary.org/obo/UBERON_0000479
<p>
<p><b>scio:example</b>
<p>We aimed to investigate whether an innovative growth factor-laden scaffold composed of acellular sciatic nerve (ASN) and brain-derived neurotrophic factor (BDNF) could promote axonal regeneration and functional recovery after spinal cord injury (SCI).
<p>
<p><b>rdfs:label</b>
<p>tissue
<p>
<p><b>rdfs:description</b>
<p>Tissue is a multicellular anatomical structure that consists of many cells of one or a few types, arranged in an extracellular matrix such that their long-range organisation is at least partly a repetition of their short-range organisation.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1371/journal.pone.0042813
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@SuperRootClasses(get={Compound.class, })

@AssignableSubClasses(get={})

@DirectSiblings(get={Virus.class, Tissue.class, Matrix.class, NucleicAcid.class, Conduit.class, Substance.class, Cell.class, Protein.class, })

@DirectInterface(get=ITissue.class)
 public class Tissue implements ITissue{

final public static IndividualFactory<TissueIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = TissueIndividual.class;
static class TissueIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public TissueIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "TissueIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<TissueIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final TissueIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public Tissue setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Tissue";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasCompoundBiologicalRelation")
private ICompoundBiologicalRelation compoundBiologicalRelation;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasSupplier")
private ICompoundSupplier compoundSupplier;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasOrganismSpecies")
private IOrganismSpecies organismSpecies;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTissueSourceLocation")
private IAnatomicalLocation tissueSourceAnatomicalLocation;


	public Tissue(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public Tissue(Tissue tissue)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = tissue.individual;
this.investigationRestriction = tissue.investigationRestriction;
this.characterOffset = tissue.getCharacterOffset();
this.characterOnset = tissue.getCharacterOnset();
if(tissue.getCompoundBiologicalRelation()!=null)this.compoundBiologicalRelation = (ICompoundBiologicalRelation) IOBIEThing.getCloneConstructor(tissue.getCompoundBiologicalRelation().getClass())	.newInstance(tissue.getCompoundBiologicalRelation());
if(tissue.getCompoundSupplier()!=null)this.compoundSupplier = (ICompoundSupplier) IOBIEThing.getCloneConstructor(tissue.getCompoundSupplier().getClass())	.newInstance(tissue.getCompoundSupplier());
if(tissue.getOrganismSpecies()!=null)this.organismSpecies = (IOrganismSpecies) IOBIEThing.getCloneConstructor(tissue.getOrganismSpecies().getClass())	.newInstance(tissue.getOrganismSpecies());
this.textMention = tissue.getTextMention();
if(tissue.getTissueSourceAnatomicalLocation()!=null)this.tissueSourceAnatomicalLocation = (IAnatomicalLocation) IOBIEThing.getCloneConstructor(tissue.getTissueSourceAnatomicalLocation().getClass())	.newInstance(tissue.getTissueSourceAnatomicalLocation());
}
	public Tissue(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				Tissue.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
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
Tissue other = (Tissue) obj;
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
if (compoundSupplier == null) {
if (other.compoundSupplier!= null)
return false;
} else if (!compoundSupplier.equals(other.compoundSupplier))
return false;
if (tissueSourceAnatomicalLocation == null) {
if (other.tissueSourceAnatomicalLocation!= null)
return false;
} else if (!tissueSourceAnatomicalLocation.equals(other.tissueSourceAnatomicalLocation))
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
if (compoundBiologicalRelation == null) {
if (other.compoundBiologicalRelation!= null)
return false;
} else if (!compoundBiologicalRelation.equals(other.compoundBiologicalRelation))
return false;
if (textMention == null) {
if (other.textMention!= null)
return false;
} else if (!textMention.equals(other.textMention))
return false;
if (organismSpecies == null) {
if (other.organismSpecies!= null)
return false;
} else if (!organismSpecies.equals(other.organismSpecies))
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
<p>has compound biological relation
<p>
<p><b>rdfs:description</b>
<p>A cell or tissue implant is defined by its origin as refered to the host organism.
<p>*/
@Override
	public ICompoundBiologicalRelation getCompoundBiologicalRelation(){
		return compoundBiologicalRelation;}
	/**
<p><b>scio:example</b>
<p>All compunds were provided by Dragon Pharmaceuticals.
<p>
<p><b>rdfs:label</b>
<p>has supplier
<p>
<p><b>rdfs:comment</b>
<p>Property of the compound, e.g. the substance applied. It points at the supplier, e.g. a pharmacological company.
<p>*/
@Override
	public ICompoundSupplier getCompoundSupplier(){
		return compoundSupplier;}
	/***/
@Override
	public String getONTOLOGY_NAME(){
		return ONTOLOGY_NAME;}
	/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
@Override
	public IOrganismSpecies getOrganismSpecies(){
		return organismSpecies;}
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
<p>has tissue source location
<p>*/
@Override
	public IAnatomicalLocation getTissueSourceAnatomicalLocation(){
		return tissueSourceAnatomicalLocation;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.investigationRestriction == null) ? 0 : this.investigationRestriction.hashCode());
result = prime * result + ((this.compoundSupplier == null) ? 0 : this.compoundSupplier.hashCode());
result = prime * result + ((this.tissueSourceAnatomicalLocation == null) ? 0 : this.tissueSourceAnatomicalLocation.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.compoundBiologicalRelation == null) ? 0 : this.compoundBiologicalRelation.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.organismSpecies == null) ? 0 : this.organismSpecies.hashCode());
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
<p>has compound biological relation
<p>
<p><b>rdfs:description</b>
<p>A cell or tissue implant is defined by its origin as refered to the host organism.
<p>*/
@Override
	public Tissue setCompoundBiologicalRelation(ICompoundBiologicalRelation compoundBiologicalRelation){
		this.compoundBiologicalRelation = compoundBiologicalRelation;
return this;}
	/**
<p><b>scio:example</b>
<p>All compunds were provided by Dragon Pharmaceuticals.
<p>
<p><b>rdfs:label</b>
<p>has supplier
<p>
<p><b>rdfs:comment</b>
<p>Property of the compound, e.g. the substance applied. It points at the supplier, e.g. a pharmacological company.
<p>*/
@Override
	public Tissue setCompoundSupplier(ICompoundSupplier compoundSupplier){
		this.compoundSupplier = compoundSupplier;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
@Override
	public Tissue setOrganismSpecies(IOrganismSpecies organismSpecies){
		this.organismSpecies = organismSpecies;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has tissue source location
<p>*/
@Override
	public Tissue setTissueSourceAnatomicalLocation(IAnatomicalLocation anatomicalLocation){
		this.tissueSourceAnatomicalLocation = anatomicalLocation;
return this;}


@Override
public String toString(){
return "Tissue [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",compoundBiologicalRelation="+compoundBiologicalRelation+",compoundSupplier="+compoundSupplier+",organismSpecies="+organismSpecies+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",tissueSourceAnatomicalLocation="+tissueSourceAnatomicalLocation+"]";}


}
