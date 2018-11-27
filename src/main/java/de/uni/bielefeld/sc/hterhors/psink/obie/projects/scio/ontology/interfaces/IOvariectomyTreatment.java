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
<p>The aim of the present study was to determine whether administration of GnRH improves locomotor activity, urinary function and neurofilament (NFs) protein expression after spinal cord injury (SCI) in ovariectomized rats.
<p>
<p><b>rdfs:label</b>
<p>ovariectomy treatment
<p>
<p><b>rdfs:description</b>
<p>Ovariectomy Treatment is the surgical removal of one or both ovaries in order to influence the outcome after spinal cord injury.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.neulet.2012.03.052.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=OvariectomyTreatment.class)

@AssignableSubInterfaces(get={})
 public interface IOvariectomyTreatment
 extends IModificationTreatment{

}
