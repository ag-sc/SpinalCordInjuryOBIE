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
<p>The effect of spinal canal narrowing and the timing of decompression after a spinal cord injury were evaluated using a rat model.
<p>
<p><b>rdfs:label</b>
<p>surgery treatment
<p>
<p><b>rdfs:description</b>
<p>Surgery Treatment is a surgical procedure as therapeutic intervention for spinal cord injury as e.g. decompression surgery.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 10472095
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=SurgeryTreatment.class)

@AssignableSubInterfaces(get={})
 public interface ISurgeryTreatment
 extends IPhysicalTreatment{

}
