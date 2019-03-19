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
<p>Here, we describe a mechanical microconnector system (mMS) to re-adjust the retracted spinal cord stumps. The mMS is a multi-channel system of polymethylmethacrylate (PMMA), designed to fit into the spinal cord tissue gap after transection, with an outlet tubing system to apply negative pressure to the mMS thus sucking the spinal cord stumps into the honeycomb-structured holes.
<p>
<p><b>rdfs:label</b>
<p>physical implant treatment
<p>
<p><b>rdfs:description</b>
<p>Physical Implant Treatment is the therapeutic intervention for spinal cord injury by implanting a device which influences physical attributed of the tissue after spinal cord injury, e.g. implantation of a vertebra stabilizing device.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.biomaterials.2013.09.057
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=PhysicalImplantTreatment.class)
 public interface IPhysicalImplantTreatment
 extends IPhysicalTreatment{

}
