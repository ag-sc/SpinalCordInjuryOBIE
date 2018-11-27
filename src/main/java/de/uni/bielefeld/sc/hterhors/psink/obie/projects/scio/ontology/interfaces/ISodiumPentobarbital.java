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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/66843009
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=Sodium+Pentobarbital
<p>
<p><b>scio:example</b>
<p>Rats (275 – 325g) were anesthetized with sodium pentobarbital (67 mg/Kg, I.P.) and a traumatic spinal cord injury was induced by dropping a 10 g weight from 25 mm onto an impounder positioned on the exposed spinal cord at vertebral level T9, producing a moderate injury, as described previously (19,20).
<p>
<p><b>rdfs:label</b>
<p>sodium pentobarbital
<p>
<p><b>rdfs:description</b>
<p>Sodium Pentobarbital is a short-acting barbiturate that is effective as a sedative and hypnotic (but not as an anti-anxiety) agent and is usually given orally. It is prescribed more frequently for sleep induction than for sedation but, like similar agents, may lose its effectiveness by the second week of continued administration. (From AMA Drug Evaluations Annual, 1994, p236)
<p>
<p><b>scio:exampleSource</b>
<p>doi:  10.1002/jmri.22323
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=SodiumPentobarbital.class)

@AssignableSubInterfaces(get={})
 public interface ISodiumPentobarbital
 extends IAnaesthetic{

}
