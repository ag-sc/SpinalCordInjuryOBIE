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
<p>http://purl.obolibrary.org/obo/MMO_0000361
<p>
<p><b>scio:example</b>
<p>Transformation of nonfunctional spinal circuits into functional states after the loss of brain input
<p>
<p><b>rdfs:label</b>
<p>treadmill training
<p>
<p><b>rdfs:description</b>
<p>Treadmill Training is a rehabilitative training for enhancement of recovery by movement on a treadmill.
<p>
<p><b>scio:exampleSource</b>
<p>10.1038/nn.2401
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=TreadmillTraining.class)

@AssignableSubInterfaces(get={})
 public interface ITreadmillTraining
 extends IRehabilitativeTraining{

}
