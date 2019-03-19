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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C63495
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C63495
<p>
<p><b>rdfs:label</b>
<p>compound
<p>
<p><b>scio:visualizationContainer</b>
<p>Compound_Treatment_Group
<p>
<p><b>rdfs:description</b>
<p>Compound is a substance, which consists of two or more ingredients.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubClasses(get={Water.class, Melatonin.class, RNA.class, VegetableOil.class, Erythropoietin.class, P188.class, NT3Lentivirus.class, DMSO.class, MacrophageCell.class, _17BetaEstradiolE2.class, Pregabalin.class, PregnenoloneS.class, MinocyclineMC.class, Riluzole.class, Pregnenolone.class, NOGOReceptorAntagonist.class, Vehicle.class, Retrovirus.class, Matrix.class, BrainDerivedNeurotrophicFactor.class, Ibuprofen.class, Lipopolysaccharide.class, AntiCD11dAntibody.class, Magnesium.class, MethylprednisoloneMP.class, Cell.class, SC58125.class, PBS.class, Hormone.class, SchwannCell.class, Ethanol.class, Antibody.class, StemCell.class, Pioglitazone.class, UmbilicalCordBloodStemCell.class, LithiumChloride.class, CyclosporineA.class, Lentivirus.class, PolyethyleneGlycolPEG.class, Protein.class, Tetracycline.class, ICI182780.class, Virus.class, GlialCell.class, ChondroitinaseABC.class, Conduit.class, OlfactoryEnsheathingGliaCell.class, ImmuneCell.class, Phenytoine.class, Indomethacin.class, HematoxyLinEosin.class, Clodronate.class, Steroid.class, NucleicAcid.class, Estrogen.class, Saline.class, VimentinAntiSenseDNA.class, EvansBlue.class, AntiNG2Antibody.class, Tissue.class, ArylsulfataseB.class, RingersSolution.class, AsialoEPO.class, Substance.class, AntiNogoAAntibody.class, Neurotrophin3.class, NS398.class, Penicillinase.class, PEGFITC.class, Iloprost.class, AcetylsalicylicAcid.class, BW755C.class, TyrosineHydroxylase.class, AtorvastatinAT.class, P4.class, Celebocid.class, Enzyme.class, MPSS.class, DehydroEpiandrosteroneSulfate.class, Albumin.class, MagnesiumSulfate.class, Mexiletine.class, RecombinantEPORhEpo.class, BoneMarrowStemCell.class, Rolipram.class, Ketamine.class, Methanesulfonamide.class, Darbepoetin.class, MesenchymalStemCell.class, DNA.class, Dipyridamol.class, Poloxamer.class, Inosine.class, EstradiolBenzoate.class, Progesterone.class, })

@SuperRootClasses(get={Compound.class, })

@DirectInterface(get=ICompound.class)

@DirectSiblings(get={})
 public class Compound implements ICompound{

final public static IndividualFactory<CompoundIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = CompoundIndividual.class;
static class CompoundIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public CompoundIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "CompoundIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<CompoundIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final CompoundIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public Compound setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Compound";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasSupplier")
private ICompoundSupplier compoundSupplier;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTissueSourceLocation")
private IAnatomicalLocation tissueSourceAnatomicalLocation;


	public Compound(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				Compound.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public Compound(Compound compound)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = compound.individual;
this.investigationRestriction = compound.investigationRestriction;
this.characterOffset = compound.getCharacterOffset();
this.characterOnset = compound.getCharacterOnset();
if(compound.getCompoundSupplier()!=null)this.compoundSupplier = (ICompoundSupplier) IOBIEThing.getCloneConstructor(compound.getCompoundSupplier().getClass())	.newInstance(compound.getCompoundSupplier());
this.textMention = compound.getTextMention();
if(compound.getTissueSourceAnatomicalLocation()!=null)this.tissueSourceAnatomicalLocation = (IAnatomicalLocation) IOBIEThing.getCloneConstructor(compound.getTissueSourceAnatomicalLocation().getClass())	.newInstance(compound.getTissueSourceAnatomicalLocation());
}
	public Compound(){
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
Compound other = (Compound) obj;
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
<p>All compunds were provided by Dragon Pharmaceuticals.
<p>
<p><b>rdfs:label</b>
<p>has supplier
<p>
<p><b>rdfs:comment</b>
<p>Property of the compound, e.g. the substance applied. It points at the supplier, e.g. a pharmacological company.
<p>*/
@Override
	public Compound setCompoundSupplier(ICompoundSupplier compoundSupplier){
		this.compoundSupplier = compoundSupplier;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has tissue source location
<p>*/
@Override
	public Compound setTissueSourceAnatomicalLocation(IAnatomicalLocation anatomicalLocation){
		this.tissueSourceAnatomicalLocation = anatomicalLocation;
return this;}


@Override
public String toString(){
return "Compound [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",compoundSupplier="+compoundSupplier+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",tissueSourceAnatomicalLocation="+tissueSourceAnatomicalLocation+"]";}


}
