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
<p><b>scio:example</b>
<p>We here have demonstrated CRMP4 involvement in CSPG-induced inhibitory signaling and nociceptive recovery in Crmp4-/- mice after SCI.
<p>
<p><b>rdfs:label</b>
<p>genetic modification treatment
<p>
<p><b>rdfs:description</b>
<p>Genetic Modification Treatment is a procedure of influencing gene expression of an organism in order to study the effect of a certain molecule.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.mcn.2016.03.006
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=GeneticModificationTreatment.class)
 public interface IGeneticModificationTreatment
 extends IModificationTreatment{

}
