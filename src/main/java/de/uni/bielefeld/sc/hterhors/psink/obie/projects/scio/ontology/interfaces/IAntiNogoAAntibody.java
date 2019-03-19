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
<p>https://www.ncbi.nlm.nih.gov/mesh/67403669
<p>
<p><b>rdfs:label</b>
<p>anti nogo a antibody
<p>
<p><b>rdfs:description</b>
<p>AntiNOGO Antibody is an antibody to the Nogo protein.
Nogo protein is a neurite growth inhibitor restricting the structural plasticity and regeneration of nerve fibers in the adult vertebrate CNS; Nogo-66 refers to the 66-residue extracellular domain; has been sequenced.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=AntiNogoAAntibody.class)

@AssignableSubInterfaces(get={})
 public interface IAntiNogoAAntibody
 extends IAntibody{

}
