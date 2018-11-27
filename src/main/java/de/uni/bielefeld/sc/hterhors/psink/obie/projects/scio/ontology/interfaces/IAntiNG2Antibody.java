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
<p>In this study, we demonstrate that acute intraspinal injections of NG2-Ab prevented an acute block of conduction by NG2.
<p>
<p><b>rdfs:label</b>
<p>anti ng2 antibody
<p>
<p><b>rdfs:description</b>
<p>AntiNG2 Antibody is a neutralizing antibody to NG2, a chondroitin sulfate proteoglycan.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1523/JNEUROSCI.4702-12.2013
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=AntiNG2Antibody.class)

@AssignableSubInterfaces(get={})
 public interface IAntiNG2Antibody
 extends IAntibody{

}
