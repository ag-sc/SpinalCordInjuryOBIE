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
<p><b>skos:closeMatch</b>
<p>http://localhost/plosthes.2017-1#7782
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=motor+evoked+potential
<p>
<p><b>scio:example</b>
<p>MEPs were elicited by applying constant current anodal stimuli to the sensorimotor cortex with the responses recorded from microelectrodes in the spinal cord at T-10.
<p>
<p><b>rdfs:label</b>
<p>motor evoked potentials test
<p>
<p><b>rdfs:description</b>
<p>Motor Evoked Potentials Test or MEP test is the examination of the electrical response evoked in a muscle or motor nerve by electrical or magnetic stimulation. Common methods of stimulation are by transcranial electrical and transcranial electric stimulation. It is often used for monitoring during neurosurgery.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 3808252
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=MotorEvokedPotentialsTest.class)
 public interface IMotorEvokedPotentialsTest
 extends IElectrophysiologyTest{

}
