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
<p>As revealed by electron microscopy, bundles of regenerating axons within the matrix area received myelin ensheathment from Schwann cells.
<p>
<p><b>rdfs:label</b>
<p>myelination test
<p>
<p><b>rdfs:description</b>
<p>Myelination Test is the investigation the process in which myelin sheaths are formed and maintained around neurons. Oligodendrocytes in the brain and spinal cord and Schwann cells in the peripheral nervous system wrap axons with compact layers of their plasma membrane. Adjacent myelin segments are separated by a non-myelinated stretch of axon called a node of Ranvier.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.nbd.2014.03.018
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=MyelinationTest.class)

@AssignableSubInterfaces(get={})
 public interface IMyelinationTest
 extends INeuronalChangesTest{

}
