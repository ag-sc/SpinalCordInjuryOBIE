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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/288361006
<p>
<p><b>scio:example</b>
<p>In 12 iSCI patients and matched controls, MEPs (evoked at 20% of maximal voluntary contraction [MVC]) were combined with a comprehensive ankle motor assessment protocol that measured ankle dorsiflexor strength (MVC, manual muscle testing, maximal movement velocity [MMV]), dexterity (the ability to accurately time ankle dorsiflexion movements) and gait (speed, walking aids).
<p>
<p><b>rdfs:label</b>
<p>manual dexterity test
<p>
<p><b>rdfs:description</b>
<p>Manual Dexterity Test is a functional test of skill in performing tasks with the hand.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 18419251
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=ManualDexterityTest.class)

@AssignableSubInterfaces(get={})
 public interface IManualDexterityTest
 extends IMotorTest{

}
