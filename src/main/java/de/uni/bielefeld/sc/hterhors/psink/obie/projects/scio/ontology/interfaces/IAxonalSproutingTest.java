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
<p>http://regenbase.org/ontology#RB_0000320
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.obolibrary.org/obo/GO_0048668
<p>
<p><b>rdfs:label</b>
<p>axonal sprouting test
<p>
<p><b>rdfs:description</b>
<p>Axonal Sprouting Test is the investigation of axonal outgrowth with histological methods, which is different from long-distance axonal regeneration. The process of axonal sprouting results in reformation of a growth cone by the tip of an injured axon, or in collateral sprouting of an injured or uninjured axon. Collateral sprouting is the process in which outgrowths develop from the shafts of existing axons.
Long distance axonal sprouting is defined as axonal regeneration.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=AxonalSproutingTest.class)
 public interface IAxonalSproutingTest
 extends IAxonalChangesTest{

}
