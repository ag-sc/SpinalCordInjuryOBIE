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
<p><b>scio:example</b>
<p>High-Impact, Self-Motivated Training Within an Enriched Environment With Single Animal Tracking Dose-Dependently Promotes Motor Skill Acquisition and Functional Recovery.
<p>
<p><b>rdfs:label</b>
<p>enriched environment
<p>
<p><b>rdfs:description</b>
<p>Housing in an enriched environment to increase natural movement of the animals.
<p>
<p><b>rdfs:description</b>
<p>Enriched Environment is a setting for experimental animal after spinal cord injury in order to increase their physical activity by providing them stimuli to move and play in their home cages or housing.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>10.1177/1545968314520721
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=EnrichedEnvironment.class)

@AssignableSubInterfaces(get={})
 public interface IEnrichedEnvironment
 extends IRehabilitativeTraining{

}
