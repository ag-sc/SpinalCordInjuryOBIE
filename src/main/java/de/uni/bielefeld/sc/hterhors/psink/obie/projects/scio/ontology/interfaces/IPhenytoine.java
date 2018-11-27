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
<p>https://www.ncbi.nlm.nih.gov/mesh/68010672
<p>
<p><b>rdfs:label</b>
<p>phenytoine
<p>
<p><b>rdfs:description</b>
<p>Phenytoine is an anticonvulsant that is used to treat a wide variety of seizures. It is also an anti-arrhythmic and a muscle relaxant. The mechanism of therapeutic action is not clear, although several cellular actions have been described including effects on ion channels, active transport, and general membrane stabilization. The mechanism of its muscle relaxant effect appears to involve a reduction in the sensitivity of muscle spindles to stretch. Phenytoin has been proposed for several other therapeutic uses, but its use has been limited by its many adverse effects and interactions with other drugs.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=Phenytoine.class)
 public interface IPhenytoine
 extends ISubstance{

}
