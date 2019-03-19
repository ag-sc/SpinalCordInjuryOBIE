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
<p>false
<p>
<p><b>scio:example</b>
<p>A 2-French Fogarty catheter is inserted into the dorsal epidural space through a small hole made in T10 vertebral arch, advanced cranially to T8-9 spinal level, and inflated for 5 min.
<p>
<p><b>rdfs:label</b>
<p>fogarty balloon catheter
<p>
<p><b>rdfs:description</b>
<p>Fogarty Balloon Catheter is a special balloon catheter device to induce compression injury to the spinal cord.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 11780869
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=FogartyBalloonCatheter.class)

@AssignableSubInterfaces(get={})
 public interface IFogartyBalloonCatheter
 extends IBalloon{

}
