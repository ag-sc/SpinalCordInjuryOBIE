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
<p>Sensorimotor Experience Influences Recovery of Forelimb Abilities but Not Tissue Loss after Focal Cortical Compression in Adult Rats
<p>
<p><b>rdfs:label</b>
<p>forelimb asymmetry test
<p>
<p><b>rdfs:description</b>
<p>Forelimb Asymmetry Test is the examination of preference of one forelimb of an animal during rearing, usually in a glass cylinder.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>DOI: 10.1371/journal.pone.0016726
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=ForelimbAsymmetryTest.class)

@AssignableSubInterfaces(get={IRearingTest.class, })
 public interface IForelimbAsymmetryTest
 extends IMotorTest{

}
