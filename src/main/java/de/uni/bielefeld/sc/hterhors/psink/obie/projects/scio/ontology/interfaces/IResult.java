package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces;

import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.IndividualFactory;
import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.annotations.AssignableSubInterfaces;
import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.annotations.DirectInterface;
import de.hterhors.obie.core.ontology.annotations.DirectSiblings;
import de.hterhors.obie.core.ontology.annotations.ImplementationClass;
import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.annotations.SuperRootClasses;
import de.hterhors.obie.core.ontology.annotations.TextMention;
import de.hterhors.obie.core.ontology.interfaces.IDatatype;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
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
*Oct 23, 2018
*/

@ImplementationClass(get=Result.class)

@AssignableSubInterfaces(get={})
 public interface IResult
 extends ISCIOThing{

/**
<p><b>rdfs:label</b>
<p>has observation
<p>*/
	public IResult addObservation(IObservation observation);


/**
<p><b>rdfs:label</b>
<p>has investigation
<p>*/
	public IInvestigation getInvestigation();


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
	public IJudgement getJudgement();


/**
<p><b>rdfs:label</b>
<p>has observation
<p>*/
	public List<IObservation> getObservations();


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
	public IExperimentalGroup getReferenceExperimentalGroup();


/**
<p><b>rdfs:label</b>
<p>has statistical test
<p>*/
	public IStatisticalTest getStatisticalTest();


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
	public IExperimentalGroup getTargetExperimentalGroup();


/**
<p><b>rdfs:label</b>
<p>has trend
<p>*/
	public ITrend getTrend();


/**
<p><b>rdfs:label</b>
<p>has investigation
<p>*/
	public IResult setInvestigation(IInvestigation investigation);


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
	public IResult setJudgement(IJudgement judgement);


/**
<p><b>rdfs:label</b>
<p>has observation
<p>*/
	public IResult setObservations(List<IObservation> observations);


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
	public IResult setReferenceExperimentalGroup(IExperimentalGroup referenceExperimentalGroup);


/**
<p><b>rdfs:label</b>
<p>has statistical test
<p>*/
	public IResult setStatisticalTest(IStatisticalTest statisticalTest);


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
	public IResult setTargetExperimentalGroup(IExperimentalGroup targetExperimentalGroup);


/**
<p><b>rdfs:label</b>
<p>has trend
<p>*/
	public IResult setTrend(ITrend trend);


}
