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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/74237004
<p>
<p><b>scio:example</b>
<p>Spinal cord contusion surgeries were performed under pentobarbital (50-70 mg/kg) anesthesia and prophylactic administration of atropine sulfate (0.8 mg/kg).
<p>
<p><b>rdfs:label</b>
<p>atropine sulfate
<p>
<p><b>rdfs:description</b>
<p>Atropine sulfate is a medication applied to stabilize the heart rate during surgery.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 17474317
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=AtropineSulfate.class)

@AssignableSubInterfaces(get={})
 public interface IAtropineSulfate
 extends IMedicationDuringSurgery{

}
