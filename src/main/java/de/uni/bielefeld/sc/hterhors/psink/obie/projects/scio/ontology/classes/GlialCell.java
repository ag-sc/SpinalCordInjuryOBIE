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
<p>glial cell
<p>
<p><b>rdfs:description</b>
<p>Glial cell is a non-neuronal cell in the nervous system with multiple different functions as maintaining homeostasis, forming myelin, and providing support and protection for neurons.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubClasses(get={SchwannCell.class, OlfactoryEnsheathingGliaCell.class, })

@SuperRootClasses(get={Compound.class, })

@DirectSiblings(get={GlialCell.class, StemCell.class, ImmuneCell.class, })

@DirectInterface(get=IGlialCell.class)
 public class GlialCell implements IGlialCell{

final public static IndividualFactory<GlialCellIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = GlialCellIndividual.class;
static class GlialCellIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public GlialCellIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "GlialCellIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<GlialCellIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final GlialCellIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public GlialCell setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/GlialCell";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasCompoundBiologicalRelation")
private ICompoundBiologicalRelation compoundBiologicalRelation;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasSupplier")
private ICompoundSupplier compoundSupplier;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasExperimentalProcedure")
@RelationTypeCollection
private List<IExperimentalProcedure> experimentalProcedures = new ArrayList<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasOrganismSpecies")
private IOrganismSpecies organismSpecies;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTissueSourceLocation")
private IAnatomicalLocation tissueSourceAnatomicalLocation;


	public GlialCell(GlialCell glialCell)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = glialCell.individual;
this.investigationRestriction = glialCell.investigationRestriction;
this.characterOffset = glialCell.getCharacterOffset();
this.characterOnset = glialCell.getCharacterOnset();
if(glialCell.getCompoundBiologicalRelation()!=null)this.compoundBiologicalRelation = (ICompoundBiologicalRelation) IOBIEThing.getCloneConstructor(glialCell.getCompoundBiologicalRelation().getClass())	.newInstance(glialCell.getCompoundBiologicalRelation());
if(glialCell.getCompoundSupplier()!=null)this.compoundSupplier = (ICompoundSupplier) IOBIEThing.getCloneConstructor(glialCell.getCompoundSupplier().getClass())	.newInstance(glialCell.getCompoundSupplier());
for (int j = 0; j < glialCell.getExperimentalProcedures().size(); j++) {if (glialCell.getExperimentalProcedures().get(j) != null) {experimentalProcedures.add((IExperimentalProcedure) IOBIEThing.getCloneConstructor(glialCell.getExperimentalProcedures().get(j).getClass()).newInstance(glialCell.getExperimentalProcedures().get(j)));} else {experimentalProcedures.add(null);}}
if(glialCell.getOrganismSpecies()!=null)this.organismSpecies = (IOrganismSpecies) IOBIEThing.getCloneConstructor(glialCell.getOrganismSpecies().getClass())	.newInstance(glialCell.getOrganismSpecies());
this.textMention = glialCell.getTextMention();
if(glialCell.getTissueSourceAnatomicalLocation()!=null)this.tissueSourceAnatomicalLocation = (IAnatomicalLocation) IOBIEThing.getCloneConstructor(glialCell.getTissueSourceAnatomicalLocation().getClass())	.newInstance(glialCell.getTissueSourceAnatomicalLocation());
}
	public GlialCell(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				GlialCell.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public GlialCell(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}


	/**
<p><b>rdfs:label</b>
<p>has experimental procedure
<p>
<p><b>rdfs:description</b>
<p>Mulitple processing steps can be necessary before a cell or tissue can be implanted.
<p>*/
@Override
	public GlialCell addExperimentalProcedure(IExperimentalProcedure experimentalProcedure){
		this.experimentalProcedures.add(experimentalProcedure);
return this;}
	/***/
@Override
	public boolean equals(Object obj){
		if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
GlialCell other = (GlialCell) obj;
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
if (experimentalProcedures == null) {
if (other.experimentalProcedures!= null)
return false;
} else if (!experimentalProcedures.equals(other.experimentalProcedures))
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
	/**
<p><b>rdfs:label</b>
<p>has experimental procedure
<p>
<p><b>rdfs:description</b>
<p>Mulitple processing steps can be necessary before a cell or tissue can be implanted.
<p>*/
@Override
	public List<IExperimentalProcedure> getExperimentalProcedures(){
		return experimentalProcedures;}
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
result = prime * result + ((this.experimentalProcedures == null) ? 0 : this.experimentalProcedures.hashCode());
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
	public GlialCell setCompoundBiologicalRelation(ICompoundBiologicalRelation compoundBiologicalRelation){
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
	public GlialCell setCompoundSupplier(ICompoundSupplier compoundSupplier){
		this.compoundSupplier = compoundSupplier;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has experimental procedure
<p>
<p><b>rdfs:description</b>
<p>Mulitple processing steps can be necessary before a cell or tissue can be implanted.
<p>*/
@Override
	public GlialCell setExperimentalProcedures(List<IExperimentalProcedure> experimentalProcedures){
		if(experimentalProcedures==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.experimentalProcedures = experimentalProcedures;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
@Override
	public GlialCell setOrganismSpecies(IOrganismSpecies organismSpecies){
		this.organismSpecies = organismSpecies;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has tissue source location
<p>*/
@Override
	public GlialCell setTissueSourceAnatomicalLocation(IAnatomicalLocation anatomicalLocation){
		this.tissueSourceAnatomicalLocation = anatomicalLocation;
return this;}


@Override
public String toString(){
return "GlialCell [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",compoundBiologicalRelation="+compoundBiologicalRelation+",compoundSupplier="+compoundSupplier+",experimentalProcedures="+experimentalProcedures+",organismSpecies="+organismSpecies+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",tissueSourceAnatomicalLocation="+tissueSourceAnatomicalLocation+"]";}


}
