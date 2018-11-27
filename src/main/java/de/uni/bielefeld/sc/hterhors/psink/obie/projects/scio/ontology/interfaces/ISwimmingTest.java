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
<p>http://purl.obolibrary.org/obo/MMO_0000574
<p>
<p><b>scio:example</b>
<p>Three scorers assessed independently all outcome measures in a blinded fashion. Neurological function was evaluated
24 h after injury and then twice a week (17, 18), as well as by a swimming test (19). In this assessment, a rat was placed in
the center of a round tub of water (40 cm diameter) filled to a depth of 30 cm with a wire mesh ladder attached to the side.
<p>
<p><b>rdfs:label</b>
<p>swimming test
<p>
<p><b>rdfs:description</b>
<p>Swimming Test is the examination of the ability and quality of locomotion during swimming.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>doi:  10.1073/pnas.142287899
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=SwimmingTest.class)

@AssignableSubInterfaces(get={ILouisvilleSwimScale.class, })
 public interface ISwimmingTest
 extends ILocomotorTest{

}
