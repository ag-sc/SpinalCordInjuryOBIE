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
<p>http://purl.bioontology.org/ontology/STY/T034
<p>
<p><b>rdfs:label</b>
<p>result
<p>
<p><b>scio:visualizationContainer</b>
<p>Result_Group
<p>
<p><b>rdfs:description</b>
<p>Result is the outcome of an experiment and represents the findings of a study. The recorded value of the outcome of some test. There can be more than one result per publication.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubClasses(get={})

@DirectInterface(get=IResult.class)

@SuperRootClasses(get={Result.class, })

@DirectSiblings(get={})
 public class Result implements IResult{

final public static IndividualFactory<ResultIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = ResultIndividual.class;
static class ResultIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public ResultIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "ResultIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<ResultIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final ResultIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public Result setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Result";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasInvestigation")
private IInvestigation investigation;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasJudgement")
private IJudgement judgement;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasObservation")
@RelationTypeCollection
private List<IObservation> observations = new ArrayList<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasReferenceGroup")
private IExperimentalGroup referenceExperimentalGroup;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasStatisticalTest")
private IStatisticalTest statisticalTest;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTargetGroup")
private IExperimentalGroup targetExperimentalGroup;
	@TextMention
final private String textMention;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTrend")
private ITrend trend;


	public Result(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				Result.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public Result(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public Result(Result result)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = result.individual;
this.investigationRestriction = result.investigationRestriction;
this.characterOffset = result.getCharacterOffset();
this.characterOnset = result.getCharacterOnset();
if(result.getInvestigation()!=null)this.investigation = (IInvestigation) IOBIEThing.getCloneConstructor(result.getInvestigation().getClass())	.newInstance(result.getInvestigation());
if(result.getJudgement()!=null)this.judgement = (IJudgement) IOBIEThing.getCloneConstructor(result.getJudgement().getClass())	.newInstance(result.getJudgement());
for (int j = 0; j < result.getObservations().size(); j++) {if (result.getObservations().get(j) != null) {observations.add((IObservation) IOBIEThing.getCloneConstructor(result.getObservations().get(j).getClass()).newInstance(result.getObservations().get(j)));} else {observations.add(null);}}
if(result.getReferenceExperimentalGroup()!=null)this.referenceExperimentalGroup = (IExperimentalGroup) IOBIEThing.getCloneConstructor(result.getReferenceExperimentalGroup().getClass())	.newInstance(result.getReferenceExperimentalGroup());
if(result.getStatisticalTest()!=null)this.statisticalTest = (IStatisticalTest) IOBIEThing.getCloneConstructor(result.getStatisticalTest().getClass())	.newInstance(result.getStatisticalTest());
if(result.getTargetExperimentalGroup()!=null)this.targetExperimentalGroup = (IExperimentalGroup) IOBIEThing.getCloneConstructor(result.getTargetExperimentalGroup().getClass())	.newInstance(result.getTargetExperimentalGroup());
this.textMention = result.getTextMention();
if(result.getTrend()!=null)this.trend = (ITrend) IOBIEThing.getCloneConstructor(result.getTrend().getClass())	.newInstance(result.getTrend());
}


	/**
<p><b>rdfs:label</b>
<p>has observation
<p>*/
@Override
	public Result addObservation(IObservation observation){
		this.observations.add(observation);
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
Result other = (Result) obj;
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
if (investigation == null) {
if (other.investigation!= null)
return false;
} else if (!investigation.equals(other.investigation))
return false;
if (statisticalTest == null) {
if (other.statisticalTest!= null)
return false;
} else if (!statisticalTest.equals(other.statisticalTest))
return false;
if (referenceExperimentalGroup == null) {
if (other.referenceExperimentalGroup!= null)
return false;
} else if (!referenceExperimentalGroup.equals(other.referenceExperimentalGroup))
return false;
if (characterOffset == null) {
if (other.characterOffset!= null)
return false;
} else if (!characterOffset.equals(other.characterOffset))
return false;
if (targetExperimentalGroup == null) {
if (other.targetExperimentalGroup!= null)
return false;
} else if (!targetExperimentalGroup.equals(other.targetExperimentalGroup))
return false;
if (judgement == null) {
if (other.judgement!= null)
return false;
} else if (!judgement.equals(other.judgement))
return false;
if (trend == null) {
if (other.trend!= null)
return false;
} else if (!trend.equals(other.trend))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
if (observations == null) {
if (other.observations!= null)
return false;
} else if (!observations.equals(other.observations))
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
<p>has investigation
<p>*/
@Override
	public IInvestigation getInvestigation(){
		return investigation;}
	/**
<p><b>scio:example</b>
<p>\"Some improvements were noted in the vehicle-treated mice over the
next week, which then plateaued; however, minocyclinetreated
mice continued to show improvements in hindlimb
function throughout the survival period.\"
<p>
<p><b>rdfs:label</b>
<p>has judgement
<p>
<p><b>rdfs:comment</b>
<p>Property of the result, which can be a \"positive\" or a \"negative\" effect of a treatment, as stated by author, or \"no effect\", which means that no difference between groups was observed.
<p>*/
@Override
	public IJudgement getJudgement(){
		return judgement;}
	/***/
@Override
	public String getONTOLOGY_NAME(){
		return ONTOLOGY_NAME;}
	/**
<p><b>rdfs:label</b>
<p>has observation
<p>*/
@Override
	public List<IObservation> getObservations(){
		return observations;}
	/***/
@Override
	public Model getRDFModel(String resourceIDPrefix){
		Model model = ModelFactory.createDefaultModel();
Resource group = model.createResource(getResourceName());
model.add(group, model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),model.createResource(ONTOLOGY_NAME));
return model;
}
	/**
<p><b>scio:example</b>
<p>The locomotor recovery for the 5-infusion group was significantly greater than for the SALINE GROUP ( p<0.0001) and the 2-INFUSION GROUP ( p<0.0056).
<p>
<p><b>rdfs:label</b>
<p>has reference group
<p>
<p><b>rdfs:description</b>
<p>A result is obtained from the comparison of two groups, usually the treated and the control group. The reference setup represents the group, which is used for comparison to a target group of interest.
<p>*/
@Override
	public IExperimentalGroup getReferenceExperimentalGroup(){
		return referenceExperimentalGroup;}
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
<p>has statistical test
<p>*/
@Override
	public IStatisticalTest getStatisticalTest(){
		return statisticalTest;}
	/**
<p><b>scio:example</b>
<p>The locomotor recovery for the 5-INFUSION GROUP was significantly greater than for the saline group ( p<0.0001) and the 2-infusion group ( p<0.0056).
<p>
<p><b>rdfs:label</b>
<p>has target group
<p>
<p><b>rdfs:description</b>
<p>A result is obtained from the comparison of two groups, usually the treated and the control group. The target setup represents the focus group, which is compared to a reference group.
<p>*/
@Override
	public IExperimentalGroup getTargetExperimentalGroup(){
		return targetExperimentalGroup;}
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
<p>has trend
<p>*/
@Override
	public ITrend getTrend(){
		return trend;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.investigationRestriction == null) ? 0 : this.investigationRestriction.hashCode());
result = prime * result + ((this.investigation == null) ? 0 : this.investigation.hashCode());
result = prime * result + ((this.statisticalTest == null) ? 0 : this.statisticalTest.hashCode());
result = prime * result + ((this.referenceExperimentalGroup == null) ? 0 : this.referenceExperimentalGroup.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.targetExperimentalGroup == null) ? 0 : this.targetExperimentalGroup.hashCode());
result = prime * result + ((this.judgement == null) ? 0 : this.judgement.hashCode());
result = prime * result + ((this.trend == null) ? 0 : this.trend.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.observations == null) ? 0 : this.observations.hashCode());
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
<p>has investigation
<p>*/
@Override
	public Result setInvestigation(IInvestigation investigation){
		this.investigation = investigation;
return this;}
	/**
<p><b>scio:example</b>
<p>\"Some improvements were noted in the vehicle-treated mice over the
next week, which then plateaued; however, minocyclinetreated
mice continued to show improvements in hindlimb
function throughout the survival period.\"
<p>
<p><b>rdfs:label</b>
<p>has judgement
<p>
<p><b>rdfs:comment</b>
<p>Property of the result, which can be a \"positive\" or a \"negative\" effect of a treatment, as stated by author, or \"no effect\", which means that no difference between groups was observed.
<p>*/
@Override
	public Result setJudgement(IJudgement judgement){
		this.judgement = judgement;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has observation
<p>*/
@Override
	public Result setObservations(List<IObservation> observations){
		if(observations==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.observations = observations;
return this;}
	/**
<p><b>scio:example</b>
<p>The locomotor recovery for the 5-infusion group was significantly greater than for the SALINE GROUP ( p<0.0001) and the 2-INFUSION GROUP ( p<0.0056).
<p>
<p><b>rdfs:label</b>
<p>has reference group
<p>
<p><b>rdfs:description</b>
<p>A result is obtained from the comparison of two groups, usually the treated and the control group. The reference setup represents the group, which is used for comparison to a target group of interest.
<p>*/
@Override
	public Result setReferenceExperimentalGroup(IExperimentalGroup experimentalGroup){
		this.referenceExperimentalGroup = experimentalGroup;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has statistical test
<p>*/
@Override
	public Result setStatisticalTest(IStatisticalTest statisticalTest){
		this.statisticalTest = statisticalTest;
return this;}
	/**
<p><b>scio:example</b>
<p>The locomotor recovery for the 5-INFUSION GROUP was significantly greater than for the saline group ( p<0.0001) and the 2-infusion group ( p<0.0056).
<p>
<p><b>rdfs:label</b>
<p>has target group
<p>
<p><b>rdfs:description</b>
<p>A result is obtained from the comparison of two groups, usually the treated and the control group. The target setup represents the focus group, which is compared to a reference group.
<p>*/
@Override
	public Result setTargetExperimentalGroup(IExperimentalGroup experimentalGroup){
		this.targetExperimentalGroup = experimentalGroup;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has trend
<p>*/
@Override
	public Result setTrend(ITrend trend){
		this.trend = trend;
return this;}


@Override
public String toString(){
return "Result [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",investigation="+investigation+",judgement="+judgement+",observations="+observations+",referenceExperimentalGroup="+referenceExperimentalGroup+",serialVersionUID="+serialVersionUID+",statisticalTest="+statisticalTest+",targetExperimentalGroup="+targetExperimentalGroup+",textMention="+textMention+",trend="+trend+"]";}


}
