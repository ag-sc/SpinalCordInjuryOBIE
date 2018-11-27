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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/262696004
<p>
<p><b>scio:example</b>
<p>Adult female Sprague Dawley rats (~230 g) received a moderate contusion to the thoracic (T9-T10) spinal cord, using the MASCIS impactor device.
<p>
<p><b>rdfs:label</b>
<p>contusion
<p>
<p><b>rdfs:description</b>
<p>Contusion is a process which leads to spinal cord lesion by inflicting mechanical force on the spinal cord from one side for a short moment.

\"Contusion devices are designed to inflict a transient, acute injury to the spinal cord. The category includes weight-drop apparatuses,electromagnetic impactors and a recently described air gun device.\"doi:10.1038/sc.2014.91
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26896212
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Contusion.class)

@AssignableSubInterfaces(get={})
 public interface IContusion
 extends IInjury{

}
