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
<p>https://www.ncbi.nlm.nih.gov/mesh/68001812
<p>
<p><b>scio:example</b>
<p>RA attenuated BSCB permeability and decreased the loss of tight junction (TJ) molecules such as P120, β-catenin, Occludin and Claudin5 after injury in vivo as well as in Brain Microvascular Endothelial Cells (BMECs).
<p>
<p><b>rdfs:label</b>
<p>blood brain barrier test
<p>
<p><b>rdfs:description</b>
<p>Blood Brain Barrier Test is the examination of the functionality of the blood brain barrier, a structure surrounding the central nervous system, consisting of specialized non-fenestrated tightly-joined endothelial cells with tight junctions that form a transport barrier for certain substances between the cerebral capillaries and the brain tissue.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.7150/ijbs.13229
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=BloodBrainBarrierTest.class)

@AssignableSubInterfaces(get={})
 public interface IBloodBrainBarrierTest
 extends IPhysiologyTest{

}
