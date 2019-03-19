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
<p>http://purl.obolibrary.org/obo/ERO_0000806
<p>
<p><b>scio:example</b>
<p>Adult female Sprague Dawley rats (~230 g) received a moderate contusion to the thoracic (T9-T10) spinal cord, using the MASCIS impactor device.
<p>
<p><b>rdfs:label</b>
<p>mascis impactor
<p>
<p><b>rdfs:description</b>
<p>MASCIS Impactor or Multicenter Animal Spinal Cord Injury Study (MASCIS) impactor is an istrument for accurate and specific weight drop on the exposed spinal cord.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26896212
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=MASCISImpactor.class)

@AssignableSubInterfaces(get={})
 public interface IMASCISImpactor
 extends IWeightDrop{

}
