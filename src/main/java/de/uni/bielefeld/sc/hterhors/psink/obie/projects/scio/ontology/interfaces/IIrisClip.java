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
<p>Compressive injury was produced by transient extradural application of a modified iris clip, which exerts a force of about 95 g on the spinal cord for 1 min.
<p>
<p><b>rdfs:label</b>
<p>iris clip
<p>
<p><b>rdfs:description</b>
<p>Iris Clip is a small surgical instrument used in eye surgery. It is also used for experimental spinal cord injury.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1038/sj.sc.3101878
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=IrisClip.class)

@AssignableSubInterfaces(get={})
 public interface IIrisClip
 extends IClip{

}
