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
<p>http://regenbase.org/ontology#RB_0008021
<p>
<p><b>scio:example</b>
<p>Cortical and subcortical lesions impair skilled walking in the ladder rung walking test: a new task to evaluate fore- and hindlimb stepping, placing, and co-ordination.
<p>
<p><b>rdfs:label</b>
<p>ladder rung test
<p>
<p><b>rdfs:comment</b>
<p>or \"GridWalk\"
<p>
<p><b>rdfs:description</b>
<p>Ladder Rung Test is an examination procedure where the animals walk over a horizontal ladder and missteps are counted and/or rated.
Tests for fore- and hindlimb stepping, fine motor control, foot placing accuracy, 
sensory motor coordination .
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>PMID 11992668
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=LadderRungTest.class)
 public interface ILadderRungTest
 extends ILocomotorTest{

}
