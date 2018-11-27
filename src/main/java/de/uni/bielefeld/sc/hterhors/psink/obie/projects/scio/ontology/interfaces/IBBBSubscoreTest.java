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
<p>We found that neither erythropoietin nor darbepoetin led to improved behavioral recovery over saline controls, with no significant differences observed in BBB scores, BBB subscores, footfall errors on horizontal ladder testing, width of hindlimb base of support, or threshold for paw withdrawal on sensory testing.
<p>
<p><b>rdfs:label</b>
<p>bbb subscore test
<p>
<p><b>rdfs:description</b>
<p>BBB Subscore Test is a system to rate single locomotion abilities in a 7-point scale originating from the Basso-Beattie-Bresnahan locomotor scale.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.expneurol.2007.12.013
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=BBBSubscoreTest.class)

@AssignableSubInterfaces(get={})
 public interface IBBBSubscoreTest
 extends INeurologicScalesTest{

}
