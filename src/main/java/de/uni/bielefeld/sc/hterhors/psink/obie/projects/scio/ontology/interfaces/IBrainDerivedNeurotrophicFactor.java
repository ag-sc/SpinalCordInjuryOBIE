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
<p>http://regenbase.org/ontology#RB_0000006
<p>
<p><b>scio:descriptionSource</b>
<p>http://purl.bioontology.org/ontology/MESH/D019208
<p>
<p><b>rdfs:label</b>
<p>brain derived neurotrophic factor
<p>
<p><b>rdfs:description</b>
<p>Brain derived neurotrophic factor or BDNF is a member of the nerve growth factor family of trophic factors. In the brain BDNF has a trophic action on retinal, cholinergic, and dopaminergic neurons, and in the peripheral nervous system it acts on both motor and sensory neurons. (From Kendrew, The Encyclopedia of Molecular Biology, 1994)
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=BrainDerivedNeurotrophicFactor.class)

@AssignableSubInterfaces(get={})
 public interface IBrainDerivedNeurotrophicFactor
 extends IProtein{

}
