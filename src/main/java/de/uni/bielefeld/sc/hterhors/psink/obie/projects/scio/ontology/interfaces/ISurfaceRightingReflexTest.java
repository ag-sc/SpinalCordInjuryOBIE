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
<p>DOI: 10.1097/BRS.0b013e318205e3f7
<p>
<p><b>scio:example</b>
<p>Agmatine-Reduced Collagen Scar Area Accompanied With Surface Righting Reflex Recovery After Complete Transection Spinal Cord Injury
<p>
<p><b>rdfs:label</b>
<p>surface righting reflex test
<p>
<p><b>rdfs:description</b>
<p>Surface Righting Reflex Test is a functional motor reflex test for animals and tests for movement coordination and muscle strength. For mice, the procedure comprises: the mouse is held gently on its back with two fingers holding on either side of the head and two fingers holding the hindquarters of the neck. The mouse is released and the time in seconds for the mice to flip over onto its abdomen with all the four paws touching the surface of the ground is measured.
<p>
<p><b>scio:exampleSource</b>
<p>10.1097/BRS.0b013e318205e3f7
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=SurfaceRightingReflexTest.class)

@AssignableSubInterfaces(get={})
 public interface ISurfaceRightingReflexTest
 extends IMotorReflexTest{

}
