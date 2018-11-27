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
<p>After ventral hemisection, postural control did not recover, whereas after dorsal or lateral hemisection it did.
<p>
<p><b>rdfs:label</b>
<p>ventral hemisection
<p>
<p><b>rdfs:description</b>
<p>Ventral Hemisection is the partial transection of the spinal cord at the ventral side, leaving the dorsal spinal tracts intact.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1152/jn.00009.2008
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=VentralHemisection.class)

@AssignableSubInterfaces(get={})
 public interface IVentralHemisection
 extends IPartialTransection{

}
