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
<p>neuronal changes test
<p>
<p><b>rdfs:description</b>
<p>Neuronal Changes Test is the investigation of any alterations in cell morphology, physiology or function of neurons, perfomed with histological methods. Neurons are the basic cellular units of nervous tissue. Each neuron consists of a body, an axon, and dendrites. Their purpose is to receive, conduct, and transmit impulses in the nervous system.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IAxonalChangesTest.class, IAxonalDiebackTest.class, INeuroprotectionTest.class, INeuronalCellLossTest.class, INeuronalActivityTest.class, IAxonalDamageTest.class, INeurogenesisTest.class, IAxonalRegenerationTest.class, IMyelinationTest.class, IAxonalSproutingTest.class, })

@ImplementationClass(get=NeuronalChangesTest.class)
 public interface INeuronalChangesTest
 extends IHistologicalInvestgationTest{

}
