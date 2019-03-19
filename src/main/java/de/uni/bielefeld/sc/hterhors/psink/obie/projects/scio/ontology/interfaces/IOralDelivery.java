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
<p>http://purl.obolibrary.org/obo/OBI_0000952
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=oral+administration
<p>
<p><b>scio:example</b>
<p>PEAP behavior was also reduced in animals administered daily with oral UR13870 (10mg/kg p.o.) and preserved spinal tissue 28 days after SCI.
<p>
<p><b>rdfs:label</b>
<p>oral delivery
<p>
<p><b>rdfs:description</b>
<p>Oral delivery is the giving of drugs, chemicals, or other substances by mouth.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.pain.2014.08.030
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=OralDelivery.class)

@AssignableSubInterfaces(get={})
 public interface IOralDelivery
 extends IDeliveryMethod{

}
