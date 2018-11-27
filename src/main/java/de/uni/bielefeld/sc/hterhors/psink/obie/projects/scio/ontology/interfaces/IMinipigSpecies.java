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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C77107
<p>
<p><b>rdfs:label</b>
<p>minipig species
<p>
<p><b>rdfs:description</b>
<p>Minipig Species is a family of  miniature pigs (also mini pig, or micro pig, or teacup pig) which is a breed of pig developed and used for medical research or for use as a pet. Miniature pigs weigh between 75 pounds (34 kg) to 150 pounds (68 kg) when fully grown, while farm pigs may weigh more than 700 pounds (320 kg). They were first used for medical research in Europe before being introduced to the United States in the 1980s.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=MinipigSpecies.class)

@AssignableSubInterfaces(get={})
 public interface IMinipigSpecies
 extends IAnimalSpecies{

}
