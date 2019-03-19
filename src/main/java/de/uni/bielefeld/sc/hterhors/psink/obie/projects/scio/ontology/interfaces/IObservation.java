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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C25598
<p>
<p><b>rdfs:label</b>
<p>observation
<p>
<p><b>scio:visualizationContainer</b>
<p>Observation_Group
<p>
<p><b>rdfs:description</b>
<p>Observation is the group of variables, qualitative states and any physical changes during an experiment.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=Observation.class)

@AssignableSubInterfaces(get={})
 public interface IObservation
 extends IEvent{

/**
<p><b>rdfs:label</b>
<p>belongs to
<p>*/
	public IExperimentalGroup getBelongsToExperimentalGroup();


/**
<p><b>rdfs:label</b>
<p>has non numeric value
<p>*/
	public INonNumericValue getNonNumericValue();


/**
<p><b>rdfs:label</b>
<p>has numeric value
<p>
<p><b>rdfs:description</b>
<p>The observation has a quantified numeric value as outcome.
<p>*/
	public INumericValue getNumericValue();


/**
<p><b>rdfs:label</b>
<p>belongs to
<p>*/
	public IObservation setBelongsToExperimentalGroup(IExperimentalGroup belongsToExperimentalGroup);


/**
<p><b>rdfs:label</b>
<p>has non numeric value
<p>*/
	public IObservation setNonNumericValue(INonNumericValue nonNumericValue);


/**
<p><b>rdfs:label</b>
<p>has numeric value
<p>
<p><b>rdfs:description</b>
<p>The observation has a quantified numeric value as outcome.
<p>*/
	public IObservation setNumericValue(INumericValue numericValue);


}
