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
<p>Behavioural testing of hindlimb function was initiated 3 days after injury using the Basso Beattie Bresnahan locomotor rating scale, and at 1 week using the inclined plane test.
<p>
<p><b>rdfs:label</b>
<p>inclined plane test
<p>
<p><b>rdfs:description</b>
<p>Inclined Plane Test is a functional test for muscle strength of the upper and lower limbs and balance where the animals bevahiour on an inclined plane is tested.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 12805103
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=InclinedPlaneTest.class)

@AssignableSubInterfaces(get={})
 public interface IInclinedPlaneTest
 extends IMotorTest{

/**
<p><b>rdfs:label</b>
<p>has direction
<p>*/
	public IDirection getDirection();


/**
<p><b>rdfs:label</b>
<p>has direction
<p>*/
	public IInclinedPlaneTest setDirection(IDirection direction);


}
