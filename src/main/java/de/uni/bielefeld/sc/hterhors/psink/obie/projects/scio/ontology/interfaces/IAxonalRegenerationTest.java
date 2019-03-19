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
<p>http://purl.obolibrary.org/obo/HP_0003450
<p>
<p><b>scio:example</b>
<p>Even after complete chronic transection, the PEG-bridge allowed long-distance axon regeneration through the grafted area and for, at least, 1cm beyond the lesion/graft border.
<p>
<p><b>rdfs:label</b>
<p>axonal regeneration test
<p>
<p><b>rdfs:description</b>
<p>Axonal Regeneration Test is the investigation of outgrowth of an injured axon over a long distance, measured with histological methods. Usually stated in the text as \"axonal regeneration\" or \"axonal regrowth\". This is in contrast to axon sparing or axon sprouting which could also stand for the growth of unlesioned axons or the formation of new collaterals.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.nbd.2014.03.018
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=AxonalRegenerationTest.class)

@AssignableSubInterfaces(get={})
 public interface IAxonalRegenerationTest
 extends IAxonalChangesTest{

}
