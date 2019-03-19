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
<p>analyzed experimental group
<p>
<p><b>rdfs:description</b>
<p>Analyzed Experimental Group is the subgroup of an experimental group which is analyzed in the experiment - it can differ from the Defined Experimental Group as it was described before data analysis.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@SuperRootClasses(get={ExperimentalGroup.class, })

@DirectSiblings(get={DefinedExperimentalGroup.class, AnalyzedExperimentalGroup.class, })

@AssignableSubClasses(get={})

@DirectInterface(get=IAnalyzedExperimentalGroup.class)
 public class AnalyzedExperimentalGroup implements IAnalyzedExperimentalGroup{

final public static IndividualFactory<AnalyzedExperimentalGroupIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = AnalyzedExperimentalGroupIndividual.class;
static class AnalyzedExperimentalGroupIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public AnalyzedExperimentalGroupIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "AnalyzedExperimentalGroupIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<AnalyzedExperimentalGroupIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final AnalyzedExperimentalGroupIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public AnalyzedExperimentalGroup setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/AnalyzedExperimentalGroup";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasConstraint")
@RelationTypeCollection
private List<IConstraint> constraints = new ArrayList<>();
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasGroupName")
@RelationTypeCollection
private List<IGroupName> groupNames = new ArrayList<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasGroupNumber")
@DatatypeProperty
private IGroupNumber groupNumber;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasInjuryModel")
private IInjury injuryModel;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasMember")
@RelationTypeCollection
private List<IDefinedExperimentalGroup> memberDefinedExperimentalGroups = new ArrayList<>();
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasNNumber")
private INNumber nNumber;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasOrganismModel")
private IOrganismModel organismModel;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasTotalPopulationSize")
private ITotalPopulationSize totalPopulationSize;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTreatmentType")
@RelationTypeCollection
private List<ITreatment> treatmentTypes = new ArrayList<>();


	public AnalyzedExperimentalGroup(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public AnalyzedExperimentalGroup(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				AnalyzedExperimentalGroup.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public AnalyzedExperimentalGroup(AnalyzedExperimentalGroup analyzedExperimentalGroup)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = analyzedExperimentalGroup.individual;
this.investigationRestriction = analyzedExperimentalGroup.investigationRestriction;
this.characterOffset = analyzedExperimentalGroup.getCharacterOffset();
this.characterOnset = analyzedExperimentalGroup.getCharacterOnset();
for (int j = 0; j < analyzedExperimentalGroup.getConstraints().size(); j++) {if (analyzedExperimentalGroup.getConstraints().get(j) != null) {constraints.add((IConstraint) IOBIEThing.getCloneConstructor(analyzedExperimentalGroup.getConstraints().get(j).getClass()).newInstance(analyzedExperimentalGroup.getConstraints().get(j)));} else {constraints.add(null);}}
for (int j = 0; j < analyzedExperimentalGroup.getGroupNames().size(); j++) {if (analyzedExperimentalGroup.getGroupNames().get(j) != null) {groupNames.add((IGroupName) IOBIEThing.getCloneConstructor(analyzedExperimentalGroup.getGroupNames().get(j).getClass()).newInstance(analyzedExperimentalGroup.getGroupNames().get(j)));} else {groupNames.add(null);}}
if(analyzedExperimentalGroup.getGroupNumber()!=null)this.groupNumber = new GroupNumber((GroupNumber)analyzedExperimentalGroup.getGroupNumber());
if(analyzedExperimentalGroup.getInjuryModel()!=null)this.injuryModel = (IInjury) IOBIEThing.getCloneConstructor(analyzedExperimentalGroup.getInjuryModel().getClass())	.newInstance(analyzedExperimentalGroup.getInjuryModel());
for (int j = 0; j < analyzedExperimentalGroup.getMemberDefinedExperimentalGroups().size(); j++) {if (analyzedExperimentalGroup.getMemberDefinedExperimentalGroups().get(j) != null) {memberDefinedExperimentalGroups.add((IDefinedExperimentalGroup) IOBIEThing.getCloneConstructor(analyzedExperimentalGroup.getMemberDefinedExperimentalGroups().get(j).getClass()).newInstance(analyzedExperimentalGroup.getMemberDefinedExperimentalGroups().get(j)));} else {memberDefinedExperimentalGroups.add(null);}}
if(analyzedExperimentalGroup.getNNumber()!=null)this.nNumber = new NNumber((NNumber)analyzedExperimentalGroup.getNNumber());
if(analyzedExperimentalGroup.getOrganismModel()!=null)this.organismModel = (IOrganismModel) IOBIEThing.getCloneConstructor(analyzedExperimentalGroup.getOrganismModel().getClass())	.newInstance(analyzedExperimentalGroup.getOrganismModel());
this.textMention = analyzedExperimentalGroup.getTextMention();
if(analyzedExperimentalGroup.getTotalPopulationSize()!=null)this.totalPopulationSize = new TotalPopulationSize((TotalPopulationSize)analyzedExperimentalGroup.getTotalPopulationSize());
for (int j = 0; j < analyzedExperimentalGroup.getTreatmentTypes().size(); j++) {if (analyzedExperimentalGroup.getTreatmentTypes().get(j) != null) {treatmentTypes.add((ITreatment) IOBIEThing.getCloneConstructor(analyzedExperimentalGroup.getTreatmentTypes().get(j).getClass()).newInstance(analyzedExperimentalGroup.getTreatmentTypes().get(j)));} else {treatmentTypes.add(null);}}
}


	/**
<p><b>rdfs:label</b>
<p>has constraint
<p>
<p><b>rdfs:description</b>
<p>A constraint defines the property/properties the organisms of an analyzed experimental group have which makes them different from the total population of the experimental group.
<p>*/
@Override
	public AnalyzedExperimentalGroup addConstraint(IConstraint constraint){
		this.constraints.add(constraint);
return this;}
	/**
<p><b>rdfs:label</b>
<p>has group name
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with synonyms in a scientific text, e.g. control group ('control') versus treated group ('treated').
<p>*/
@Override
	public AnalyzedExperimentalGroup addGroupName(IGroupName groupName){
		this.groupNames.add(groupName);
return this;}
	/**
<p><b>rdfs:label</b>
<p>has member
<p>*/
@Override
	public AnalyzedExperimentalGroup addMemberDefinedExperimentalGroup(IDefinedExperimentalGroup definedExperimentalGroup){
		this.memberDefinedExperimentalGroups.add(definedExperimentalGroup);
return this;}
	/**
<p><b>rdfs:label</b>
<p>has treatment type
<p>*/
@Override
	public AnalyzedExperimentalGroup addTreatmentType(ITreatment treatment){
		this.treatmentTypes.add(treatment);
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
AnalyzedExperimentalGroup other = (AnalyzedExperimentalGroup) obj;
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
if (memberDefinedExperimentalGroups == null) {
if (other.memberDefinedExperimentalGroups!= null)
return false;
} else if (!memberDefinedExperimentalGroups.equals(other.memberDefinedExperimentalGroups))
return false;
if (groupNumber == null) {
if (other.groupNumber!= null)
return false;
} else if (!groupNumber.equals(other.groupNumber))
return false;
if (characterOffset == null) {
if (other.characterOffset!= null)
return false;
} else if (!characterOffset.equals(other.characterOffset))
return false;
if (groupNames == null) {
if (other.groupNames!= null)
return false;
} else if (!groupNames.equals(other.groupNames))
return false;
if (organismModel == null) {
if (other.organismModel!= null)
return false;
} else if (!organismModel.equals(other.organismModel))
return false;
if (constraints == null) {
if (other.constraints!= null)
return false;
} else if (!constraints.equals(other.constraints))
return false;
if (treatmentTypes == null) {
if (other.treatmentTypes!= null)
return false;
} else if (!treatmentTypes.equals(other.treatmentTypes))
return false;
if (nNumber == null) {
if (other.nNumber!= null)
return false;
} else if (!nNumber.equals(other.nNumber))
return false;
if (injuryModel == null) {
if (other.injuryModel!= null)
return false;
} else if (!injuryModel.equals(other.injuryModel))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
if (totalPopulationSize == null) {
if (other.totalPopulationSize!= null)
return false;
} else if (!totalPopulationSize.equals(other.totalPopulationSize))
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
<p>has constraint
<p>
<p><b>rdfs:description</b>
<p>A constraint defines the property/properties the organisms of an analyzed experimental group have which makes them different from the total population of the experimental group.
<p>*/
@Override
	public List<IConstraint> getConstraints(){
		return constraints;}
	/**
<p><b>rdfs:label</b>
<p>has group name
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with synonyms in a scientific text, e.g. control group ('control') versus treated group ('treated').
<p>*/
@Override
	public List<IGroupName> getGroupNames(){
		return groupNames;}
	/**
<p><b>rdfs:label</b>
<p>has group number
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with numbers in a scientific text, e.g. control group (group 1) versus treated group (group 2).
<p>*/
@Override
	public IGroupNumber getGroupNumber(){
		return groupNumber;}
	/**
<p><b>rdfs:label</b>
<p>has injury model
<p>*/
@Override
	public IInjury getInjuryModel(){
		return injuryModel;}
	/**
<p><b>rdfs:label</b>
<p>has member
<p>*/
@Override
	public List<IDefinedExperimentalGroup> getMemberDefinedExperimentalGroups(){
		return memberDefinedExperimentalGroups;}
	/**
<p><b>scio:example</b>
<p>Both animal groups (“TX” vs. “PEG”) initially consisted of N = 14 rats each.
<p>
<p><b>rdfs:label</b>
<p>has N number
<p>
<p><b>rdfs:description</b>
<p>Integer representing the number of animals per group, per result or per statistical analysis.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
@Override
	public INNumber getNNumber(){
		return nNumber;}
	/***/
@Override
	public String getONTOLOGY_NAME(){
		return ONTOLOGY_NAME;}
	/**
<p><b>rdfs:label</b>
<p>has organism model
<p>*/
@Override
	public IOrganismModel getOrganismModel(){
		return organismModel;}
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
<p>has total population size
<p>*/
@Override
	public ITotalPopulationSize getTotalPopulationSize(){
		return totalPopulationSize;}
	/**
<p><b>rdfs:label</b>
<p>has treatment type
<p>*/
@Override
	public List<ITreatment> getTreatmentTypes(){
		return treatmentTypes;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.investigationRestriction == null) ? 0 : this.investigationRestriction.hashCode());
result = prime * result + ((this.memberDefinedExperimentalGroups == null) ? 0 : this.memberDefinedExperimentalGroups.hashCode());
result = prime * result + ((this.groupNumber == null) ? 0 : this.groupNumber.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.groupNames == null) ? 0 : this.groupNames.hashCode());
result = prime * result + ((this.organismModel == null) ? 0 : this.organismModel.hashCode());
result = prime * result + ((this.constraints == null) ? 0 : this.constraints.hashCode());
result = prime * result + ((this.treatmentTypes == null) ? 0 : this.treatmentTypes.hashCode());
result = prime * result + ((this.nNumber == null) ? 0 : this.nNumber.hashCode());
result = prime * result + ((this.injuryModel == null) ? 0 : this.injuryModel.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.totalPopulationSize == null) ? 0 : this.totalPopulationSize.hashCode());
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
<p>has constraint
<p>
<p><b>rdfs:description</b>
<p>A constraint defines the property/properties the organisms of an analyzed experimental group have which makes them different from the total population of the experimental group.
<p>*/
@Override
	public AnalyzedExperimentalGroup setConstraints(List<IConstraint> constraints){
		if(constraints==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.constraints = constraints;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has group name
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with synonyms in a scientific text, e.g. control group ('control') versus treated group ('treated').
<p>*/
@Override
	public AnalyzedExperimentalGroup setGroupNames(List<IGroupName> groupNames){
		if(groupNames==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.groupNames = groupNames;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has group number
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with numbers in a scientific text, e.g. control group (group 1) versus treated group (group 2).
<p>*/
@Override
	public AnalyzedExperimentalGroup setGroupNumber(IGroupNumber groupNumber){
		this.groupNumber = groupNumber;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has injury model
<p>*/
@Override
	public AnalyzedExperimentalGroup setInjuryModel(IInjury injury){
		this.injuryModel = injury;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has member
<p>*/
@Override
	public AnalyzedExperimentalGroup setMemberDefinedExperimentalGroups(List<IDefinedExperimentalGroup> definedExperimentalGroups){
		if(definedExperimentalGroups==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.memberDefinedExperimentalGroups = definedExperimentalGroups;
return this;}
	/**
<p><b>scio:example</b>
<p>Both animal groups (“TX” vs. “PEG”) initially consisted of N = 14 rats each.
<p>
<p><b>rdfs:label</b>
<p>has N number
<p>
<p><b>rdfs:description</b>
<p>Integer representing the number of animals per group, per result or per statistical analysis.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
@Override
	public AnalyzedExperimentalGroup setNNumber(INNumber nNumber){
		this.nNumber = nNumber;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has organism model
<p>*/
@Override
	public AnalyzedExperimentalGroup setOrganismModel(IOrganismModel organismModel){
		this.organismModel = organismModel;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has total population size
<p>*/
@Override
	public AnalyzedExperimentalGroup setTotalPopulationSize(ITotalPopulationSize totalPopulationSize){
		this.totalPopulationSize = totalPopulationSize;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has treatment type
<p>*/
@Override
	public AnalyzedExperimentalGroup setTreatmentTypes(List<ITreatment> treatments){
		if(treatments==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.treatmentTypes = treatments;
return this;}


@Override
public String toString(){
return "AnalyzedExperimentalGroup [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",constraints="+constraints+",groupNames="+groupNames+",groupNumber="+groupNumber+",injuryModel="+injuryModel+",memberDefinedExperimentalGroups="+memberDefinedExperimentalGroups+",nNumber="+nNumber+",organismModel="+organismModel+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",totalPopulationSize="+totalPopulationSize+",treatmentTypes="+treatmentTypes+"]";}


}
