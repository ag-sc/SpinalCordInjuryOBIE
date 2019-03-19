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
<p>https://www.ncbi.nlm.nih.gov/mesh/68009128
<p>
<p><b>scio:example</b>
<p>Such irritation led to increased hindlimb spasticity in pilot studies beginning after the first full week of injections.
<p>
<p><b>rdfs:label</b>
<p>spasticity observation
<p>
<p><b>rdfs:description</b>
<p>Spasticity Observation is the assessment of muscle spasticity in laboratory animals, which is a form of muscle hypertonia associated with upper motor neuron dysfunction. Resistance to passive stretch of a spastic muscle results in minimal initial resistance (a \"free interval\") followed by an incremental increase in muscle tone. Tone increases in proportion to the velocity of stretch. Spasticity is usually accompanied by HYPERREFLEXIA and variable degrees of MUSCLE WEAKNESS. (modified From Adams et al., Principles of Neurology, 6th ed, p54)
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1038/sj.sc.3102057
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=SpasticityObservation.class)

@AssignableSubInterfaces(get={})
 public interface ISpasticityObservation
 extends IObservationOfAnimalBehaviour{

}
