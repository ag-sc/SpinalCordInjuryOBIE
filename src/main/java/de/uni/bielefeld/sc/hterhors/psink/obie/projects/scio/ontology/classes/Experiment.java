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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C42790
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C42790
<p>
<p><b>rdfs:label</b>
<p>experiment
<p>
<p><b>scio:visualizationContainer</b>
<p>Experimental_Design_Group
<p>
<p><b>rdfs:description</b>
<p>Experiment is a coordinated set of actions and observations designed to generate data, with the ultimate goal of discovery or hypothesis testing.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubClasses(get={})

@SuperRootClasses(get={Experiment.class, })

@DirectInterface(get=IExperiment.class)

@DirectSiblings(get={})
 public class Experiment implements IExperiment{

final public static IndividualFactory<ExperimentIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = ExperimentIndividual.class;
static class ExperimentIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public ExperimentIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "ExperimentIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<ExperimentIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final ExperimentIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public Experiment setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Experiment";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasExperimentalMethod")
@RelationTypeCollection
private List<IExperimentalMethod> experimentalMethods = new ArrayList<>();
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasResult")
@RelationTypeCollection
private List<IResult> results = new ArrayList<>();
	final static private long serialVersionUID = 64L;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasStudyDesign")
@RelationTypeCollection
private List<IStudyDesign> studyDesigns = new ArrayList<>();
	@TextMention
final private String textMention;


	public Experiment(Experiment experiment)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = experiment.individual;
this.investigationRestriction = experiment.investigationRestriction;
this.characterOffset = experiment.getCharacterOffset();
this.characterOnset = experiment.getCharacterOnset();
for (int j = 0; j < experiment.getExperimentalMethods().size(); j++) {if (experiment.getExperimentalMethods().get(j) != null) {experimentalMethods.add((IExperimentalMethod) IOBIEThing.getCloneConstructor(experiment.getExperimentalMethods().get(j).getClass()).newInstance(experiment.getExperimentalMethods().get(j)));} else {experimentalMethods.add(null);}}
for (int j = 0; j < experiment.getResults().size(); j++) {if (experiment.getResults().get(j) != null) {results.add((IResult) IOBIEThing.getCloneConstructor(experiment.getResults().get(j).getClass()).newInstance(experiment.getResults().get(j)));} else {results.add(null);}}
for (int j = 0; j < experiment.getStudyDesigns().size(); j++) {if (experiment.getStudyDesigns().get(j) != null) {studyDesigns.add((IStudyDesign) IOBIEThing.getCloneConstructor(experiment.getStudyDesigns().get(j).getClass()).newInstance(experiment.getStudyDesigns().get(j)));} else {studyDesigns.add(null);}}
this.textMention = experiment.getTextMention();
}
	public Experiment(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public Experiment(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				Experiment.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}


	/**
<p><b>rdfs:label</b>
<p>has experimental method
<p>*/
@Override
	public Experiment addExperimentalMethod(IExperimentalMethod experimentalMethod){
		this.experimentalMethods.add(experimentalMethod);
return this;}
	/**
<p><b>rdfs:label</b>
<p>has result
<p>*/
@Override
	public Experiment addResult(IResult result){
		this.results.add(result);
return this;}
	/**
<p><b>rdfs:label</b>
<p>has study design
<p>*/
@Override
	public Experiment addStudyDesign(IStudyDesign studyDesign){
		this.studyDesigns.add(studyDesign);
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
Experiment other = (Experiment) obj;
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
if (results == null) {
if (other.results!= null)
return false;
} else if (!results.equals(other.results))
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
if (experimentalMethods == null) {
if (other.experimentalMethods!= null)
return false;
} else if (!experimentalMethods.equals(other.experimentalMethods))
return false;
if (textMention == null) {
if (other.textMention!= null)
return false;
} else if (!textMention.equals(other.textMention))
return false;
if (studyDesigns == null) {
if (other.studyDesigns!= null)
return false;
} else if (!studyDesigns.equals(other.studyDesigns))
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
<p>has experimental method
<p>*/
@Override
	public List<IExperimentalMethod> getExperimentalMethods(){
		return experimentalMethods;}
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
	/**
<p><b>rdfs:label</b>
<p>has result
<p>*/
@Override
	public List<IResult> getResults(){
		return results;}
	/**
<p><b>rdfs:label</b>
<p>has study design
<p>*/
@Override
	public List<IStudyDesign> getStudyDesigns(){
		return studyDesigns;}
	/***/
@Override
	public String getTextMention(){
		return textMention;}
	/***/
@Override
	public IOBIEThing getThis(){
		return this;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.investigationRestriction == null) ? 0 : this.investigationRestriction.hashCode());
result = prime * result + ((this.results == null) ? 0 : this.results.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.experimentalMethods == null) ? 0 : this.experimentalMethods.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.studyDesigns == null) ? 0 : this.studyDesigns.hashCode());
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
<p>has experimental method
<p>*/
@Override
	public Experiment setExperimentalMethods(List<IExperimentalMethod> experimentalMethods){
		if(experimentalMethods==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.experimentalMethods = experimentalMethods;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has result
<p>*/
@Override
	public Experiment setResults(List<IResult> results){
		if(results==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.results = results;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has study design
<p>*/
@Override
	public Experiment setStudyDesigns(List<IStudyDesign> studyDesigns){
		if(studyDesigns==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.studyDesigns = studyDesigns;
return this;}


@Override
public String toString(){
return "Experiment [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",experimentalMethods="+experimentalMethods+",results="+results+",serialVersionUID="+serialVersionUID+",studyDesigns="+studyDesigns+",textMention="+textMention+"]";}


}
