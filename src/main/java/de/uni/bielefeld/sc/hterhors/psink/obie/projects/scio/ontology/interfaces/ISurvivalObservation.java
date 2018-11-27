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
<p>http://www.ebi.ac.uk/efo/EFO_0000638
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68013534
<p>
<p><b>scio:example</b>
<p>All animals survived in group 1. However, the mortality rates in group 2 were 25% and in group 3, 50%, respectively, which mirrors the severity of the trauma.
<p>
<p><b>rdfs:label</b>
<p>survival observation
<p>
<p><b>rdfs:description</b>
<p>Survival Observation is the assessment of continuance of life or existence especially under adverse conditions. A measurement of the survival rate for a group of individuals suffering from a disease.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 10898365
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=SurvivalObservation.class)

@AssignableSubInterfaces(get={})
 public interface ISurvivalObservation
 extends IObservationOfAnimalBehaviour{

}
