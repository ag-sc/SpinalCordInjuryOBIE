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
<p>In the present study, we demonstrate that reduction of glutamate-mediated exitotoxicity via intraperitoneal administration of INI-0602 in the microenvironment of the injured spinal cord elicited neurobehavioral recovery and extensive suppression of glial scar formation by reducing secondary tissue damage.
<p>
<p><b>rdfs:label</b>
<p>toxicity test
<p>
<p><b>rdfs:description</b>
<p>Toxicity Test is the histological examination of toxic processes in the context of secondary degeneration after spinal cord injury.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1089/neu.2013.3223
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=ToxicityTest.class)

@AssignableSubInterfaces(get={})
 public interface IToxicityTest
 extends ISecondaryDegenerationTest{

}
