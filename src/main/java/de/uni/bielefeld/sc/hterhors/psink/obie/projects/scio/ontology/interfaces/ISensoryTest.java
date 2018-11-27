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
<p>Sensory thresholds can be measured reliably in chondrodystrophoid dogs and are altered by SCI. The differences in sensation among neurologic grades indicate that these techniques can be used to further characterize recovery of SCI dogs.
<p>
<p><b>rdfs:label</b>
<p>sensory test
<p>
<p><b>rdfs:description</b>
<p>Sensory Test is the examination of sensory function as functional investigation method.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1111/jvim.13913
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=SensoryTest.class)

@AssignableSubInterfaces(get={IAdhesiveRemovalTest.class, IHindpawSensationTest.class, })
 public interface ISensoryTest
 extends IFunctionalTest{

}
