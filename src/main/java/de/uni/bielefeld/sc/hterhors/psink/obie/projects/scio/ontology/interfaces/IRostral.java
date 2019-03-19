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
<p>http://purl.org/sig/ont/fma/fma74540
<p>
<p><b>scio:example</b>
<p>One week after injury, 2 times 106 SCs in 6 mul DMEM-F12 medium were injected into the contused area. Immediately after SC grafting, 0.25 mul of either endotoxin-free sterile saline or 50 mM db-cAMP was injected into the spinal cord on either side of the midline, both rostral and caudal to the SC graft at a depth of 0.5 mm.
<p>
<p><b>rdfs:label</b>
<p>rostral
<p>
<p><b>rdfs:description</b>
<p>Rostral is the anatomical direction to the head.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1038/nm1056
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=Rostral.class)
 public interface IRostral
 extends IDirection{

}
