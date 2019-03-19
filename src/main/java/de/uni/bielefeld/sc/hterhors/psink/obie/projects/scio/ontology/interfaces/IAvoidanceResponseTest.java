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
<p>http://purl.obolibrary.org/obo/VT_0010528
<p>
<p><b>scio:descriptionSource</b>
<p>http://purl.obolibrary.org/obo/VT_0010528
<p>
<p><b>scio:example</b>
<p>Likewise, at 6 weeks PEG-, MgSO4-, and saline-treated control animals showed 3.5 +/- 0.4, 2.8 +/- 0.9, and 5.0 +/- 0.5
avoidance responses to at-level touch, respectively.
<p>
<p><b>rdfs:label</b>
<p>avoidance response test
<p>
<p><b>rdfs:description</b>
<p>Avoidance Response Test is the examination of any measurable or observable characteristic related to the actions or reactions of an organism pertaining to the ability to associate a previously neutral stimulus with an unpleasant or punishing stimulus so that the animal learns to avoid the previously neutral stimulus.
<p>
<p><b>scio:exampleSource</b>
<p>DOI: 10.1002/jnr.21283
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=AvoidanceResponseTest.class)
 public interface IAvoidanceResponseTest
 extends IPainTest{

}
