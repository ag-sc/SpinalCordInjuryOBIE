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
<p><b>scio:descriptionSource</b>
<p>http://purl.bioontology.org/ontology/MESH/D006120
<p>
<p><b>scio:example</b>
<p>Behavioral and histological characterization of unilateral cervical spinal cord contusion injury in rats.
<p>
<p><b>rdfs:label</b>
<p>grooming observation
<p>
<p><b>rdfs:comment</b>
<p>Grooming behavior is observed.
<p>
<p><b>rdfs:description</b>
<p>Grooming Observation is the assessment of an animal's cleaning and caring for the body surface. This includes preening, the cleaning and oiling of feathers with the bill or of hair with the tongue.
<p>
<p><b>scio:exampleSource</b>
<p>10.1089/neu.2006.23.36
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=GroomingObservation.class)

@AssignableSubInterfaces(get={})
 public interface IGroomingObservation
 extends IObservationOfAnimalBehaviour{

}
