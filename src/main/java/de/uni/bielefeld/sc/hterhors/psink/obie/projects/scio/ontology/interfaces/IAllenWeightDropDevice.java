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
<p>New Zealand White rabbits sustained SCI or sham injury via the Allen weight-drop technique.
<p>
<p><b>rdfs:label</b>
<p>allen weight drop device
<p>
<p><b>rdfs:description</b>
<p>Allen Weight Drop Device is an apparatus for accurate targeting and weight drop from specified heights in order to produce  traumatic brain or spinal cord injury.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 16506468
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=AllenWeightDropDevice.class)

@AssignableSubInterfaces(get={})
 public interface IAllenWeightDropDevice
 extends IWeightDrop{

}
