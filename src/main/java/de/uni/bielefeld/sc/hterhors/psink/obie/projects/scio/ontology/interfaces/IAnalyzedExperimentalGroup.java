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
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=AnalyzedExperimentalGroup.class)
 public interface IAnalyzedExperimentalGroup
 extends IExperimentalGroup{

/**
<p><b>rdfs:label</b>
<p>has constraint
<p>
<p><b>rdfs:description</b>
<p>A constraint defines the property/properties the organisms of an analyzed experimental group have which makes them different from the total population of the experimental group.
<p>*/
	public IAnalyzedExperimentalGroup addConstraint(IConstraint constraint);


/**
<p><b>rdfs:label</b>
<p>has member
<p>*/
	public IAnalyzedExperimentalGroup addMemberDefinedExperimentalGroup(IDefinedExperimentalGroup definedExperimentalGroup);


/**
<p><b>rdfs:label</b>
<p>has constraint
<p>
<p><b>rdfs:description</b>
<p>A constraint defines the property/properties the organisms of an analyzed experimental group have which makes them different from the total population of the experimental group.
<p>*/
	public List<IConstraint> getConstraints();


/**
<p><b>rdfs:label</b>
<p>has member
<p>*/
	public List<IDefinedExperimentalGroup> getMemberDefinedExperimentalGroups();


/**
<p><b>rdfs:label</b>
<p>has constraint
<p>
<p><b>rdfs:description</b>
<p>A constraint defines the property/properties the organisms of an analyzed experimental group have which makes them different from the total population of the experimental group.
<p>*/
	public IAnalyzedExperimentalGroup setConstraints(List<IConstraint> constraints);


/**
<p><b>rdfs:label</b>
<p>has member
<p>*/
	public IAnalyzedExperimentalGroup setMemberDefinedExperimentalGroups(List<IDefinedExperimentalGroup> memberDefinedExperimentalGroups);


}
