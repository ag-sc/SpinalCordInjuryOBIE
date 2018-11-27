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
<p>doi:10.1016/j.surneu.2007.05.056
<p>
<p><b>scio:example</b>
<p>Of these, the TFR in response to tail pinch was present in 16 (41%) cases.
<p>
<p><b>rdfs:label</b>
<p>tail flick reflex test
<p>
<p><b>rdfs:description</b>
<p>Tail Flick Reflex Test or TFR in rats is a classic nociceptive test originally described by D'Amour and Smith, in which pinching of the tail or hind leg produces a withdrawal response. The TFR is a general flexor withdrawal reflex that functions in intact as well as in decerebrated rats.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.surneu.2007.05.056
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=TailFlickReflexTest.class)

@AssignableSubInterfaces(get={})
 public interface ITailFlickReflexTest
 extends IPainTest{

}
