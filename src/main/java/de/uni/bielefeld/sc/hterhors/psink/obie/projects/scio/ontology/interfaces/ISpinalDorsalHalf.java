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
<p>http://purl.bioontology.org/ontology/RCTV2/7N05100
<p>
<p><b>scio:example</b>
<p>One week after hemisection of the 2nd cervical segment (C2Hx) a suspension of either embryonic (E14) MB cells, fetal spinal cord cells (FSC), or media only (sham) was delivered to the dorsal C3 spinal cord of adult male rats.
<p>
<p><b>rdfs:label</b>
<p>spinal dorsal half
<p>
<p><b>rdfs:description</b>
<p>Spinal Dorsal Half is the spinal tissue from the central canal to the dorsal border of the spinal cord tissue.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.expneurol.2016.01.017
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IDorsalColumn.class, })

@ImplementationClass(get=SpinalDorsalHalf.class)
 public interface ISpinalDorsalHalf
 extends IIntraspinal{

}
