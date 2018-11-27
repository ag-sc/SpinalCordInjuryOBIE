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
<p>doi:10.1016/S0006-8993(00)02778-5
<p>
<p><b>scio:example</b>
<p>Motor function was assessed with the BBB locomotor rating scale and a contact plantar placement task.
<p>
<p><b>rdfs:label</b>
<p>contact placing response test
<p>
<p><b>rdfs:description</b>
<p>Contact Placing Response Test is the examination of a reflex elicited by lightly touching the skin of the dorsal side of the foot without joint displacement. The animal responds by lifting the hind leg and placing it upon the obstacle.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.expneurol.2013.12.019
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=ContactPlacingResponseTest.class)

@AssignableSubInterfaces(get={})
 public interface IContactPlacingResponseTest
 extends IMotorReflexTest{

}
