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
<p>Indomethacin, an inhibitor of prostaglandin synthesis attenuates alteration in spinal cord evoked potentials and edema formation after trauma to the spinal cord: an experimental study in the rat.
<p>
<p><b>rdfs:label</b>
<p>spinal cord evoked potentials test
<p>
<p><b>rdfs:description</b>
<p>Spinal Cord Evoked Potentials Test or SCEP test is the examination of electrophysiological signals stimulated and recorded in the spinal cord.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 8450974
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=SpinalCordEvokedPotentialsTest.class)
 public interface ISpinalCordEvokedPotentialsTest
 extends IElectrophysiologyTest{

}
