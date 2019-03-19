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
<p><b>scio:descriptionSource</b>
<p>https://en.wikipedia.org/wiki/Miniature_pig
<p>
<p><b>scio:example</b>
<p>Using our previously characterized porcine model of SCI, we subjected animals to resonance vibration (5.7±0.46 Hz) or no vibration for a period of 1.5 or 3.0 h.
<p>
<p><b>rdfs:label</b>
<p>minipig model
<p>
<p><b>rdfs:description</b>
<p>Minipig Model is an animal that is amenable to experimentation.  A miniature pig (also mini pig, or micro pig, or teacup pig) is a breed of pig developed and used for medical research or for use as a pet. Miniature pigs weigh between 75 pounds (34 kg) to 150 pounds (68 kg) when fully grown, while farm pigs may weigh more than 700 pounds (320 kg). They were first used for medical research in Europe before being introduced to the United States in the 1980s.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1089/neu.2014.3707
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=MinipigModel.class)
 public interface IMinipigModel
 extends IAnimalModel{

}
