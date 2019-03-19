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
<p>https://www.ncbi.nlm.nih.gov/mesh/68055495
<p>
<p><b>scio:example</b>
<p>With NT3-chitosan, endogenous NSCs and their progenies were effectively activated and attracted to migrate into the NT3-chitosan tubes and subsequently differentiate into neurons, which matured to form a nascent functional synaptic network.
<p>
<p><b>rdfs:label</b>
<p>neurogenesis test
<p>
<p><b>rdfs:description</b>
<p>Neurogenesis Test is the examination of formation of neurons which involves the differentiation and division of stem cells in which one or both of the daughter cells become neurons.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1073/pnas.1510194112
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=NeurogenesisTest.class)
 public interface INeurogenesisTest
 extends INeuronalChangesTest{

}
