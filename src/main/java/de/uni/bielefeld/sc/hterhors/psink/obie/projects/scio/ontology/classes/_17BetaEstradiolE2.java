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
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68004958
<p>
<p><b>rdfs:label</b>
<p>17 beta estradiol e2
<p>
<p><b>rdfs:description</b>
<p>17Beta Estradiol E 2 is the 17-beta-isomer of estradiol, an aromatized C18 steroid with hydroxyl group at 3-beta- and 17-beta-position. Estradiol-17-beta is the most potent form of mammalian estrogenic steroids.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubClasses(get={AtorvastatinAT.class, })

@SuperRootClasses(get={Compound.class, })

@DirectSiblings(get={Steroid.class, Melatonin.class, P4.class, Erythropoietin.class, DehydroEpiandrosteroneSulfate.class, Estrogen.class, _17BetaEstradiolE2.class, PregnenoloneS.class, Pregnenolone.class, RecombinantEPORhEpo.class, AsialoEPO.class, EstradiolBenzoate.class, Progesterone.class, })

@DirectInterface(get=I_17BetaEstradiolE2.class)
 public class _17BetaEstradiolE2 implements I_17BetaEstradiolE2{

final public static IndividualFactory<_17BetaEstradiolE2Individual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = _17BetaEstradiolE2Individual.class;
static class _17BetaEstradiolE2Individual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public _17BetaEstradiolE2Individual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "_17BetaEstradiolE2Individual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<_17BetaEstradiolE2Individual> getIndividualFactory() {
		return individualFactory;
	}

	public final _17BetaEstradiolE2Individual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public _17BetaEstradiolE2 setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/17BetaEstradiolE2";
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


	public _17BetaEstradiolE2(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				_17BetaEstradiolE2.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public _17BetaEstradiolE2(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public _17BetaEstradiolE2(_17BetaEstradiolE2 _17BetaEstradiolE2)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = _17BetaEstradiolE2.individual;
this.investigationRestriction = _17BetaEstradiolE2.investigationRestriction;
this.characterOffset = _17BetaEstradiolE2.getCharacterOffset();
this.characterOnset = _17BetaEstradiolE2.getCharacterOnset();
if(_17BetaEstradiolE2.getCompoundSupplier()!=null)this.compoundSupplier = (ICompoundSupplier) IOBIEThing.getCloneConstructor(_17BetaEstradiolE2.getCompoundSupplier().getClass())	.newInstance(_17BetaEstradiolE2.getCompoundSupplier());
this.textMention = _17BetaEstradiolE2.getTextMention();
if(_17BetaEstradiolE2.getTissueSourceAnatomicalLocation()!=null)this.tissueSourceAnatomicalLocation = (IAnatomicalLocation) IOBIEThing.getCloneConstructor(_17BetaEstradiolE2.getTissueSourceAnatomicalLocation().getClass())	.newInstance(_17BetaEstradiolE2.getTissueSourceAnatomicalLocation());
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
_17BetaEstradiolE2 other = (_17BetaEstradiolE2) obj;
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
	public _17BetaEstradiolE2 setCompoundSupplier(ICompoundSupplier compoundSupplier){
		this.compoundSupplier = compoundSupplier;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has tissue source location
<p>*/
@Override
	public _17BetaEstradiolE2 setTissueSourceAnatomicalLocation(IAnatomicalLocation anatomicalLocation){
		this.tissueSourceAnatomicalLocation = anatomicalLocation;
return this;}


@Override
public String toString(){
return "_17BetaEstradiolE2 [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",compoundSupplier="+compoundSupplier+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",tissueSourceAnatomicalLocation="+tissueSourceAnatomicalLocation+"]";}


}
