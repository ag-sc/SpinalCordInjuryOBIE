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
<p>Skilled reaching an action pattern: stability in rat (Rattus norvegicus) grasping movements as a function of changing food pellet size.
<p>
<p><b>rdfs:label</b>
<p>single pellet reaching test
<p>
<p><b>rdfs:description</b>
<p>Single Pellet Reaching Test is a functional test for skilled forepaw use and gripping. The rat or mouse reaches for pellets with its forepaws and video recordings are analyzed in slow motion.
<p>
<p><b>scio:exampleSource</b>
<p>PMID 11080542
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=SinglePelletReachingTest.class)

@AssignableSubInterfaces(get={})
 public interface ISinglePelletReachingTest
 extends IMotorTest{

}
