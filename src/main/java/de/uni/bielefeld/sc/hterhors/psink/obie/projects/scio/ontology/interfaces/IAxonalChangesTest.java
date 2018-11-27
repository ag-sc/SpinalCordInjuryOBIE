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
<p>axonal changes test
<p>
<p><b>rdfs:description</b>
<p>Axonal Changes Test is the investigation of any changes in axon morphology, physiology or function with histological methods. The axon is a projection of a neuron that conducts electrical impulses away from the neuronal cell body.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=AxonalChangesTest.class)

@AssignableSubInterfaces(get={IAxonalDiebackTest.class, IAxonalDamageTest.class, IAxonalRegenerationTest.class, IAxonalSproutingTest.class, })
 public interface IAxonalChangesTest
 extends INeuronalChangesTest{

}
