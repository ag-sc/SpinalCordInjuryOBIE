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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/388185005
<p>
<p><b>scio:example</b>
<p>Briefly, 38 male Sprague–Dawley rats (275–325 g; Charles River Breeding Laboratories) were anesthetized with 2% halothane in 70% N02/30% O2.
<p>
<p><b>rdfs:label</b>
<p>nitrous oxide
<p>
<p><b>rdfs:description</b>
<p>Nitrous oxide or laughing gas is a substance used as anaesthetic.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/S0028-3908(00)00005-8
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=NitrousOxide.class)

@AssignableSubInterfaces(get={})
 public interface INitrousOxide
 extends IAnaesthetic{

}
