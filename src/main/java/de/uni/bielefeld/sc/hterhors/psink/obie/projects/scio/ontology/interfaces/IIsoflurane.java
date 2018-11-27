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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/66492008
<p>
<p><b>scio:example</b>
<p>Mice were anesthetized with isoflurane and the spinal cord was exposed at T10.
<p>
<p><b>rdfs:label</b>
<p>isoflurane
<p>
<p><b>rdfs:description</b>
<p>Isoflurane is a liquid which is evaporated as a halogenated ether gas for inhalation anaesthesia.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/S0896-6273(02)01005-X
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Isoflurane.class)

@AssignableSubInterfaces(get={})
 public interface IIsoflurane
 extends IAnaesthetic{

}
