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
<p>http://purl.obolibrary.org/obo/OBI_0000426
<p>
<p><b>scio:descriptionSource</b>
<p>http://purl.obolibrary.org/obo/OBI_0000426
<p>
<p><b>rdfs:label</b>
<p>injection delivery
<p>
<p><b>rdfs:description</b>
<p>Injection is process which aims at introducing a compound or a mixture into a material entity (either biological entity or instrument) by relying on devices such as syringe or injector connection, attached or forced into a vascular system (veins of an organism or tubes of a machine) or in a tissue.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=InjectionDelivery.class)

@AssignableSubInterfaces(get={})
 public interface IInjectionDelivery
 extends IDeliveryMethod{

}
