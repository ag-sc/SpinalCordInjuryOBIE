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
<p>http://purl.org/net/OCRe/study_design.owl#OCRE100075
<p>
<p><b>scio:example</b>
<p>Prior to surgery, rats of the lesioned treated (n = 9, Fig. 7A) and lesioned control groups (n = 7, Fig. 7B) showed a low proportion of irregular walking patterns reaching 2.3 ± 1.0% and 0.7 ± 0.7%, respectively.
<p>
<p><b>rdfs:label</b>
<p>experimental group
<p>
<p><b>scio:visualizationContainer</b>
<p>Experimental_Group
<p>
<p><b>rdfs:description</b>
<p>Experimental group is a set of individuals of defined organism model, injury model and treatment model in the context of a study.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1111/j.1460-9568.2005.04495.x
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@SuperRootClasses(get={ExperimentalGroup.class, })

@AssignableSubClasses(get={DefinedExperimentalGroup.class, AnalyzedExperimentalGroup.class, })

@DirectSiblings(get={})

@DirectInterface(get=IExperimentalGroup.class)
 public class ExperimentalGroup implements IExperimentalGroup{

final public static IndividualFactory<ExperimentalGroupIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = ExperimentalGroupIndividual.class;
static class ExperimentalGroupIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public ExperimentalGroupIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "ExperimentalGroupIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<ExperimentalGroupIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final ExperimentalGroupIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/ExperimentalGroup";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasGroupName")
@DatatypeProperty
@RelationTypeCollection
private List<IGroupName> groupNames = new ArrayList<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasGroupNumber")
@DatatypeProperty
private IGroupNumber groupNumber;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasInjuryModel")
private IInjury injuryModel;
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
	@RelationTypeCollection
@OntologyModelContent(ontologyName="http://psink.de/scio/hasTreatmentType")
private List<ITreatment> treatmentTypes = new ArrayList<>();


	public ExperimentalGroup(){
this.individual = null;
this.textMention = null;
}
	public ExperimentalGroup(ExperimentalGroup experimentalGroup)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = experimentalGroup.individual;
this.characterOffset = experimentalGroup.getCharacterOffset();
this.characterOnset = experimentalGroup.getCharacterOnset();
for (int j = 0; j < experimentalGroup.getGroupNames().size(); j++) {if (experimentalGroup.getGroupNames().get(j) != null) {groupNames.add((IGroupName) IOBIEThing.getCloneConstructor(experimentalGroup.getGroupNames().get(j).getClass()).newInstance(experimentalGroup.getGroupNames().get(j)));} else {groupNames.add(null);}}
if(experimentalGroup.getGroupNumber()!=null)this.groupNumber = new GroupNumber((GroupNumber)experimentalGroup.getGroupNumber());
if(experimentalGroup.getInjuryModel()!=null)this.injuryModel = (IInjury) IOBIEThing.getCloneConstructor(experimentalGroup.getInjuryModel().getClass())	.newInstance(experimentalGroup.getInjuryModel());
if(experimentalGroup.getNNumber()!=null)this.nNumber = new NNumber((NNumber)experimentalGroup.getNNumber());
if(experimentalGroup.getOrganismModel()!=null)this.organismModel = (IOrganismModel) IOBIEThing.getCloneConstructor(experimentalGroup.getOrganismModel().getClass())	.newInstance(experimentalGroup.getOrganismModel());
this.textMention = experimentalGroup.getTextMention();
if(experimentalGroup.getTotalPopulationSize()!=null)this.totalPopulationSize = new TotalPopulationSize((TotalPopulationSize)experimentalGroup.getTotalPopulationSize());
for (int j = 0; j < experimentalGroup.getTreatmentTypes().size(); j++) {if (experimentalGroup.getTreatmentTypes().get(j) != null) {treatmentTypes.add((ITreatment) IOBIEThing.getCloneConstructor(experimentalGroup.getTreatmentTypes().get(j).getClass()).newInstance(experimentalGroup.getTreatmentTypes().get(j)));} else {treatmentTypes.add(null);}}
}
	public ExperimentalGroup(String individualURI, String textMention){
this.individual = 
				ExperimentalGroup.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}


	/**
<p><b>rdfs:label</b>
<p>has group name
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with synonyms in a scientific text, e.g. control group ('control') versus treated group ('treated').
<p>*/
@Override
	public ExperimentalGroup addGroupName(IGroupName groupName){
		this.groupNames.add(groupName);
return this;}
	/**
<p><b>rdfs:label</b>
<p>has treatment type
<p>*/
@Override
	public ExperimentalGroup addTreatmentType(ITreatment treatment){
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
ExperimentalGroup other = (ExperimentalGroup) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (nNumber == null) {
if (other.nNumber!= null)
return false;
} else if (!nNumber.equals(other.nNumber))
return false;
if (groupNames == null) {
if (other.groupNames!= null)
return false;
} else if (!groupNames.equals(other.groupNames))
return false;
if (groupNumber == null) {
if (other.groupNumber!= null)
return false;
} else if (!groupNumber.equals(other.groupNumber))
return false;
if (totalPopulationSize == null) {
if (other.totalPopulationSize!= null)
return false;
} else if (!totalPopulationSize.equals(other.totalPopulationSize))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
if (organismModel == null) {
if (other.organismModel!= null)
return false;
} else if (!organismModel.equals(other.organismModel))
return false;
if (injuryModel == null) {
if (other.injuryModel!= null)
return false;
} else if (!injuryModel.equals(other.injuryModel))
return false;
if (treatmentTypes == null) {
if (other.treatmentTypes!= null)
return false;
} else if (!treatmentTypes.equals(other.treatmentTypes))
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
result = prime * result + ((this.nNumber == null) ? 0 : this.nNumber.hashCode());
result = prime * result + ((this.groupNames == null) ? 0 : this.groupNames.hashCode());
result = prime * result + ((this.groupNumber == null) ? 0 : this.groupNumber.hashCode());
result = prime * result + ((this.totalPopulationSize == null) ? 0 : this.totalPopulationSize.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.organismModel == null) ? 0 : this.organismModel.hashCode());
result = prime * result + ((this.injuryModel == null) ? 0 : this.injuryModel.hashCode());
result = prime * result + ((this.treatmentTypes == null) ? 0 : this.treatmentTypes.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
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
<p>has group name
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with synonyms in a scientific text, e.g. control group ('control') versus treated group ('treated').
<p>*/
@Override
	public ExperimentalGroup setGroupNames(List<IGroupName> groupNames){
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
	public ExperimentalGroup setGroupNumber(IGroupNumber groupNumber){
		this.groupNumber = groupNumber;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has injury model
<p>*/
@Override
	public ExperimentalGroup setInjuryModel(IInjury injury){
		this.injuryModel = injury;
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
	public ExperimentalGroup setNNumber(INNumber nNumber){
		this.nNumber = nNumber;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has organism model
<p>*/
@Override
	public ExperimentalGroup setOrganismModel(IOrganismModel organismModel){
		this.organismModel = organismModel;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has total population size
<p>*/
@Override
	public ExperimentalGroup setTotalPopulationSize(ITotalPopulationSize totalPopulationSize){
		this.totalPopulationSize = totalPopulationSize;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has treatment type
<p>*/
@Override
	public ExperimentalGroup setTreatmentTypes(List<ITreatment> treatments){
		if(treatments==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.treatmentTypes = treatments;
return this;}


@Override
public String toString(){
return "ExperimentalGroup [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",groupNames="+groupNames+",groupNumber="+groupNumber+",injuryModel="+injuryModel+",nNumber="+nNumber+",organismModel="+organismModel+",serialVersionUID="+serialVersionUID+",textMention="+textMention+",totalPopulationSize="+totalPopulationSize+",treatmentTypes="+treatmentTypes+"]";}


}
