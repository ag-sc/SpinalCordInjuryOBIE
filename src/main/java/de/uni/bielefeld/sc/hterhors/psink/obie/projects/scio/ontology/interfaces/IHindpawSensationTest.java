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
<p>Sensory threshold (ST) was measured using an electric von Frey anesthesiometer (VFA) in all limbs of 20 normal dogs and 29 dogs with acute thoracolumbar spinal cord injury (SCI) caused by spontaneous intervertebral disc extrusion.
<p>
<p><b>rdfs:label</b>
<p>hindpaw sensation test
<p>
<p><b>rdfs:description</b>
<p>Hindpaw Sensation Test is the examination of sensation threshold in the hindpaws other than pain reception in the animal, measured by behavioural signs of perception and not electrophysiologial means.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.tvjl.2015.07.028
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=HindpawSensationTest.class)

@AssignableSubInterfaces(get={})
 public interface IHindpawSensationTest
 extends ISensoryTest{

}
