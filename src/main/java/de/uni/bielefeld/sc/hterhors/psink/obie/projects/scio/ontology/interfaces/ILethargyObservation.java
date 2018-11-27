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
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=lethargy
<p>
<p><b>scio:example</b>
<p>All rats appeared lethargic for the entire duration of riluzole treatment.
<p>
<p><b>rdfs:label</b>
<p>lethargy observation
<p>
<p><b>rdfs:description</b>
<p>Lethargy Observation is the assessment of a general state of sluggishness, listless, or uninterested, with being tired, and having difficulty concentrating and doing simple tasks. For laboratory animals the observation of lack of motion and explorative behaviour is often a sign for lethargy.
<p>
<p><b>scio:exampleSource</b>
<p>doi:  10.1089/neu.2012.2622
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=LethargyObservation.class)

@AssignableSubInterfaces(get={})
 public interface ILethargyObservation
 extends IObservationOfAnimalBehaviour{

}
