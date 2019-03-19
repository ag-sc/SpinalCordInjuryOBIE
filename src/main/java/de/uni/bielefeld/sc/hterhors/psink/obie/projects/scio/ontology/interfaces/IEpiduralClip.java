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
<p>The spinal cord injury was made at T10 level by the epidural clip compression method.
<p>
<p><b>rdfs:label</b>
<p>epidural clip
<p>
<p><b>rdfs:description</b>
<p>Epidural Clip is a surgical instrument used to inflict a compression injury to the spinal cord. The clipping device is not further specified. It is placed epidurally to inflict the spinal cord lesion.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 8861702
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=EpiduralClip.class)
 public interface IEpiduralClip
 extends IClip{

}
