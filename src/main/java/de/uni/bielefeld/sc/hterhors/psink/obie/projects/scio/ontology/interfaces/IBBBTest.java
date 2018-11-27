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
<p>At three days following SCI, two investigators blinded to treatment groups assessed open field locomotor functional recovery using the Basso, Beattie, and Bresnahan (BBB) locomotor rating scale
<p>
<p><b>rdfs:label</b>
<p>bbb test
<p>
<p><b>rdfs:description</b>
<p>BBB Test is a scale for locomotion in the rat: Basso-Beattie-Bresnahan locomotor scale. This open field walking score measures recovery of hindlimb movements in rats during free open field locomotion as described by Basso et al.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>doi:  10.1371/journal.pone.0147716
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=BBBTest.class)

@AssignableSubInterfaces(get={})
 public interface IBBBTest
 extends INeurologicScalesTest{

}
