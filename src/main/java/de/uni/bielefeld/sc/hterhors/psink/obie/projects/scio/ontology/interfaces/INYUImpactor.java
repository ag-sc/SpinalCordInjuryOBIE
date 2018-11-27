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
<p>doi: 10.1038/sc.2014.91
<p>
<p><b>scio:example</b>
<p>Adult Wistar rats (n = 6) underwent traumatic thoracic cord contusion by an NYU impactor.
<p>
<p><b>rdfs:label</b>
<p>nyu impactor
<p>
<p><b>rdfs:description</b>
<p>NYU Impactor or New York University (NYU) impactor is an instrument for accurate and specific weight drop on the exposed spinal cord.The injury procedure involves performing a laminectomy at the targeted level and stabilization of the spinal cord by means of clamps. A rod of specific weight, usually 10 g, is dropped from a precise height above the surface of the cord to induce SCI of defined severity. Key parameters such as height, time, velocity upon impact and cord compression are recorded digitally that enable experiments to be analyzed and discarded if out of desired range.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26931783
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=NYUImpactor.class)

@AssignableSubInterfaces(get={})
 public interface INYUImpactor
 extends IWeightDrop{

}
