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
<p>http://purl.bioontology.org/ontology/STY/T025
<p>
<p><b>scio:example</b>
<p>Previous reports from our laboratory have documented the antiinflammatory potential of lovastatin, which was found to block expression of iNOS and proinflammatory cytokines (TNF., IL-1., and IL-6) in activated glial *cells* (microglia and astrocytes) and macrophages in culture (Pahan et al., 1997).
<p>
<p><b>rdfs:label</b>
<p>cell
<p>
<p><b>rdfs:description</b>
<p>Cell is a biological entity used for treatment by transplantation or application to the organism after spinal cord injury, e.g., genetically modified cells, stem cells, etc.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@SuperRootClasses(get={Compound.class, })

@DirectInterface(get=ICell.class)

@DirectSiblings(get={Virus.class, Tissue.class, Matrix.class, NucleicAcid.class, Conduit.class, Substance.class, Cell.class, Protein.class, })

@AssignableSubClasses(get={SchwannCell.class, GlialCell.class, MesenchymalStemCell.class, StemCell.class, UmbilicalCordBloodStemCell.class, ImmuneCell.class, OlfactoryEnsheathingGliaCell.class, MacrophageCell.class, BoneMarrowStemCell.class, })
 public class Cell implements ICell{

final public static IndividualFactory<CellIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = CellIndividual.class;
static class CellIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public CellIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "CellIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<CellIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final CellIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Cell";
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
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTissueSourceLocation")
private IAnatomicalLocation tissueSourceAnatomicalLocation;


	public Cell(String individualURI, String textMention){
this.individual = 
				Cell.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public Cell(){
this.individual = null;
this.textMention = null;
}
	public Cell(Cell cell)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = cell.individual;
this.characterOffset = cell.getCharacterOffset();
this.characterOnset = cell.getCharacterOnset();
if(cell.getCompoundBiologicalRelation()!=null)this.compoundBiologicalRelation = (ICompoundBiologicalRelation) IOBIEThing.getCloneConstructor(cell.getCompoundBiologicalRelation().getClass())	.newInstance(cell.getCompoundBiologicalRelation());
if(cell.getCompoundSupplier()!=null)this.compoundSupplier = (ICompoundSupplier) IOBIEThing.getCloneConstructor(cell.getCompoundSupplier().getClass())	.newInstance(cell.getCompoundSupplier());
for (int j = 0; j < cell.getExperimentalProcedures().size(); j++) {if (cell.getExperimentalProcedures().get(j) != null) {experimentalProcedures.add((IExperimentalProcedure) IOBIEThing.getCloneConstructor(cell.getExperimentalProcedures().get(j).getClass()).newInstance(cell.getExperimentalProcedures().get(j)));} else {experimentalProcedures.add(null);}}
if(cell.getOrganismSpecies()!=null)this.organismSpecies = (IOrganismSpecies) IOBIEThing.getCloneConstructor(cell.getOrganismSpecies().getClass())	.newInstance(cell.getOrganismSpecies());
this.textMention = cell.getTextMention();
if(cell.getTissueSourceAnatomicalLocation()!=null)this.tissueSourceAnatomicalLocation = (IAnatomicalLocation) IOBIEThing.getCloneConstructor(cell.getTissueSourceAnatomicalLocation().getClass())	.newInstance(cell.getTissueSourceAnatomicalLocation());
}


	/**
<p><b>rdfs:label</b>
<p>has experimental procedure
<p>
<p><b>rdfs:description</b>
<p>Mulitple processing steps can be necessary before a cell or tissue can be implanted.
<p>*/
@Override
	public Cell addExperimentalProcedure(IExperimentalProcedure experimentalProcedure){
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
Cell other = (Cell) obj;
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
	public Cell setCompoundBiologicalRelation(ICompoundBiologicalRelation compoundBiologicalRelation){
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
	public Cell setCompoundSupplier(ICompoundSupplier compoundSupplier){
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
	public Cell setExperimentalProcedures(List<IExperimentalProcedure> experimentalProcedures){
		if(experimentalProcedures==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.experimentalProcedures = experimentalProcedures;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
@Override
	public Cell setOrganismSpecies(IOrganismSpecies organismSpecies){
		this.organismSpecies = organismSpecies;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has tissue source location
<p>*/
@Override
	public Cell setTissueSourceAnatomicalLocation(IAnatomicalLocation anatomicalLocation){
		this.tissueSourceAnatomicalLocation = anatomicalLocation;
return this;}


@Override
public String toString(){
return "Cell [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",compoundBiologicalRelation="+compoundBiologicalRelation+",compoundSupplier="+compoundSupplier+",experimentalProcedures="+experimentalProcedures+",organismSpecies="+organismSpecies+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",tissueSourceAnatomicalLocation="+tissueSourceAnatomicalLocation+"]";}


}
