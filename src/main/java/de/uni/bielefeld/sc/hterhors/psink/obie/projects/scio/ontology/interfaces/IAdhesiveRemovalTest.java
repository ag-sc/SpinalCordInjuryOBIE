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
<p>Modified from  doi: 10.1038/nprot.2009.125.
<p>
<p><b>scio:example</b>
<p>Animals were first tested to indicate the presence of a somatosensory asymmetry. This was done by removing the animal from the home cage for the attachment of adhesive stimuli (Avery adhesive backed labels, 113 mm2) to the distal–radial aspect of both forelimbs.
<p>
<p><b>rdfs:label</b>
<p>adhesive removal test
<p>
<p><b>rdfs:description</b>
<p>Adhesive Removal Test or tape removal test is the examination of sensory function by applying adhesive tape on each forepaw or hindpaw of the animal and measuring the time-to-contact and the time-to-remove them. This behavior implies correct paw and mouth sensitivity (time-to-contact) and correct paw coordination (time-to-remove).
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/S0028-3908(00)00005-8
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=AdhesiveRemovalTest.class)
 public interface IAdhesiveRemovalTest
 extends ISensoryTest{

}
