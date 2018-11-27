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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/703421000
<p>
<p><b>scio:descriptionSource</b>
<p>http://purl.bioontology.org/ontology/MESH/D013696
<p>
<p><b>scio:example</b>
<p>An epidural perfusion device was applied to maintain a steady temperature (18 °C) for 120 min with gradual rewarming to 37 °C
<p>
<p><b>rdfs:label</b>
<p>temperature
<p>
<p><b>rdfs:description</b>
<p>Temperature is the property of objects that determines the direction of heat flow when they are placed in direct thermal contact. The temperature is the energy of microscopic motions (vibrational and translational) of the particles of atoms.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26322652
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@DatatypeProperty
@ImplementationClass(get=Temperature.class)

@AssignableSubInterfaces(get={})
 public interface ITemperature
 extends IDatatype, IQudt_Quantity{

}
