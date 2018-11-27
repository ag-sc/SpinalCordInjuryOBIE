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
<p>mesenchymal stem cell
<p>
<p><b>rdfs:description</b>
<p>Mesenchymal stem cells are stem cells which originate from connective tissue cells. They are multipotent stromal cells giving rise to multiple different cell types.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@SuperRootClasses(get={Compound.class, })

@DirectInterface(get=IMesenchymalStemCell.class)

@DirectSiblings(get={MesenchymalStemCell.class, UmbilicalCordBloodStemCell.class, BoneMarrowStemCell.class, })

@AssignableSubClasses(get={})
 public class MesenchymalStemCell implements IMesenchymalStemCell{

final public static IndividualFactory<MesenchymalStemCellIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = MesenchymalStemCellIndividual.class;
static class MesenchymalStemCellIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public MesenchymalStemCellIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "MesenchymalStemCellIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<MesenchymalStemCellIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final MesenchymalStemCellIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/MesenchymalStemCell";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasCompoundBiologicalRelation")
private ICompoundBiologicalRelation compoundBiologicalRelation;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasSupplier")
private ICompoundSupplier compoundSupplier;
	@RelationTypeCollection
@OntologyModelContent(ontologyName="http://psink.de/scio/hasExperimentalProcedure")
private List<IExperimentalProcedure> experimentalProcedures = new ArrayList<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasOrganismSpecies")
private IOrganismSpecies organismSpecies;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasStemCellSourceType")
private IStemCellSourceType stemCellSourceType;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTissueSourceLocation")
private IAnatomicalLocation tissueSourceAnatomicalLocation;


	public MesenchymalStemCell(String individualURI, String textMention){
this.individual = 
				MesenchymalStemCell.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public MesenchymalStemCell(){
this.individual = null;
this.textMention = null;
}
	public MesenchymalStemCell(MesenchymalStemCell mesenchymalStemCell)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = mesenchymalStemCell.individual;
this.characterOffset = mesenchymalStemCell.getCharacterOffset();
this.characterOnset = mesenchymalStemCell.getCharacterOnset();
if(mesenchymalStemCell.getCompoundBiologicalRelation()!=null)this.compoundBiologicalRelation = (ICompoundBiologicalRelation) IOBIEThing.getCloneConstructor(mesenchymalStemCell.getCompoundBiologicalRelation().getClass())	.newInstance(mesenchymalStemCell.getCompoundBiologicalRelation());
if(mesenchymalStemCell.getCompoundSupplier()!=null)this.compoundSupplier = (ICompoundSupplier) IOBIEThing.getCloneConstructor(mesenchymalStemCell.getCompoundSupplier().getClass())	.newInstance(mesenchymalStemCell.getCompoundSupplier());
for (int j = 0; j < mesenchymalStemCell.getExperimentalProcedures().size(); j++) {if (mesenchymalStemCell.getExperimentalProcedures().get(j) != null) {experimentalProcedures.add((IExperimentalProcedure) IOBIEThing.getCloneConstructor(mesenchymalStemCell.getExperimentalProcedures().get(j).getClass()).newInstance(mesenchymalStemCell.getExperimentalProcedures().get(j)));} else {experimentalProcedures.add(null);}}
if(mesenchymalStemCell.getOrganismSpecies()!=null)this.organismSpecies = (IOrganismSpecies) IOBIEThing.getCloneConstructor(mesenchymalStemCell.getOrganismSpecies().getClass())	.newInstance(mesenchymalStemCell.getOrganismSpecies());
if(mesenchymalStemCell.getStemCellSourceType()!=null)this.stemCellSourceType = (IStemCellSourceType) IOBIEThing.getCloneConstructor(mesenchymalStemCell.getStemCellSourceType().getClass())	.newInstance(mesenchymalStemCell.getStemCellSourceType());
this.textMention = mesenchymalStemCell.getTextMention();
if(mesenchymalStemCell.getTissueSourceAnatomicalLocation()!=null)this.tissueSourceAnatomicalLocation = (IAnatomicalLocation) IOBIEThing.getCloneConstructor(mesenchymalStemCell.getTissueSourceAnatomicalLocation().getClass())	.newInstance(mesenchymalStemCell.getTissueSourceAnatomicalLocation());
}


	/**
<p><b>rdfs:label</b>
<p>has experimental procedure
<p>
<p><b>rdfs:description</b>
<p>Mulitple processing steps can be necessary before a cell or tissue can be implanted.
<p>*/
@Override
	public MesenchymalStemCell addExperimentalProcedure(IExperimentalProcedure experimentalProcedure){
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
MesenchymalStemCell other = (MesenchymalStemCell) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
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
if (compoundBiologicalRelation == null) {
if (other.compoundBiologicalRelation!= null)
return false;
} else if (!compoundBiologicalRelation.equals(other.compoundBiologicalRelation))
return false;
if (experimentalProcedures == null) {
if (other.experimentalProcedures!= null)
return false;
} else if (!experimentalProcedures.equals(other.experimentalProcedures))
return false;
if (stemCellSourceType == null) {
if (other.stemCellSourceType!= null)
return false;
} else if (!stemCellSourceType.equals(other.stemCellSourceType))
return false;
if (organismSpecies == null) {
if (other.organismSpecies!= null)
return false;
} else if (!organismSpecies.equals(other.organismSpecies))
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
	/**
<p><b>rdfs:label</b>
<p>has stem cell source type
<p>*/
@Override
	public IStemCellSourceType getStemCellSourceType(){
		return stemCellSourceType;}
	/***/
@Override
	public String getTextMention(){
		return textMention;}
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
result = prime * result + ((this.compoundSupplier == null) ? 0 : this.compoundSupplier.hashCode());
result = prime * result + ((this.tissueSourceAnatomicalLocation == null) ? 0 : this.tissueSourceAnatomicalLocation.hashCode());
result = prime * result + ((this.compoundBiologicalRelation == null) ? 0 : this.compoundBiologicalRelation.hashCode());
result = prime * result + ((this.experimentalProcedures == null) ? 0 : this.experimentalProcedures.hashCode());
result = prime * result + ((this.stemCellSourceType == null) ? 0 : this.stemCellSourceType.hashCode());
result = prime * result + ((this.organismSpecies == null) ? 0 : this.organismSpecies.hashCode());
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
<p>has compound biological relation
<p>
<p><b>rdfs:description</b>
<p>A cell or tissue implant is defined by its origin as refered to the host organism.
<p>*/
@Override
	public MesenchymalStemCell setCompoundBiologicalRelation(ICompoundBiologicalRelation compoundBiologicalRelation){
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
	public MesenchymalStemCell setCompoundSupplier(ICompoundSupplier compoundSupplier){
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
	public MesenchymalStemCell setExperimentalProcedures(List<IExperimentalProcedure> experimentalProcedures){
		if(experimentalProcedures==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.experimentalProcedures = experimentalProcedures;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
@Override
	public MesenchymalStemCell setOrganismSpecies(IOrganismSpecies organismSpecies){
		this.organismSpecies = organismSpecies;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has stem cell source type
<p>*/
@Override
	public MesenchymalStemCell setStemCellSourceType(IStemCellSourceType stemCellSourceType){
		this.stemCellSourceType = stemCellSourceType;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has tissue source location
<p>*/
@Override
	public MesenchymalStemCell setTissueSourceAnatomicalLocation(IAnatomicalLocation anatomicalLocation){
		this.tissueSourceAnatomicalLocation = anatomicalLocation;
return this;}


@Override
public String toString(){
return "MesenchymalStemCell [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",compoundBiologicalRelation="+compoundBiologicalRelation+",compoundSupplier="+compoundSupplier+",experimentalProcedures="+experimentalProcedures+",organismSpecies="+organismSpecies+",serialVersionUID="+serialVersionUID+",stemCellSourceType="+stemCellSourceType+",textMention="+textMention+",tissueSourceAnatomicalLocation="+tissueSourceAnatomicalLocation+"]";}


}
