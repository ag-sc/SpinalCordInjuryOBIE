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
<p>http://purl.obolibrary.org/obo/CMO_0001515
<p>
<p><b>scio:example</b>
<p>Here we showed that, with the exception of a modest improvement in performance on the Montoya staircase test at 8-10 weeks postinjury, the combinatorial treatment with ghrelin, ibuprofen, C16, and KD did not result in any significant improvements in the rearing test, grooming test, or horizontal ladder.
<p>
<p><b>rdfs:label</b>
<p>rearing test
<p>
<p><b>rdfs:description</b>
<p>Rearing Test is a functional test for forelimb asymmetry. It is normally investigated in a glass cylinder. The forelimb contact to the glass wall is counted. Nevertheless, other setups for measurement of rearing are also possible.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 24658967
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=RearingTest.class)

@AssignableSubInterfaces(get={})
 public interface IRearingTest
 extends IForelimbAsymmetryTest{

}
