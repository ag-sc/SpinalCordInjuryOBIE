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
<p>Though improved regeneration did not enhance locomotor function, we wanted to further assess integration of the regenerated axons by examining the extent of c-Fos induction in spinal cord caudal to the PNG upon stimulation of spinal cord rostral to the PNG. We found that there was no significant difference in the numbers of c-Fos+ neurons (Fig. 1g).
<p>
<p><b>rdfs:label</b>
<p>neuronal activity test
<p>
<p><b>rdfs:description</b>
<p>Neuronal Activity Test is the investigation of electrophysiological activity of neurons measured with histochemical means, usually antigen marker.
<p>
<p><b>scio:exampleSource</b>
<p>doi:  10.1016/j.expneurol.2014.10.013
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=NeuronalActivityTest.class)

@AssignableSubInterfaces(get={})
 public interface INeuronalActivityTest
 extends INeuronalChangesTest{

}
