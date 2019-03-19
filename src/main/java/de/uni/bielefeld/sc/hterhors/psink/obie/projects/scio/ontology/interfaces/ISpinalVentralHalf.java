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
<p>We provide a detailed protocol for multi-segmental, intraspinal transplantation of NPCs into the cervical spinal cord ventral gray matter of neurodegenerative models such as SOD1(G93A) mice and rats, as well as spinal cord injured rats and mice (11).
<p>
<p><b>rdfs:label</b>
<p>spinal ventral half
<p>
<p><b>rdfs:description</b>
<p>Spinal Ventral Half is the spinal tissue from the central canal to the ventral border of the spinal cord tissue.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.3791/3069
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=SpinalVentralHalf.class)
 public interface ISpinalVentralHalf
 extends IIntraspinal{

}
