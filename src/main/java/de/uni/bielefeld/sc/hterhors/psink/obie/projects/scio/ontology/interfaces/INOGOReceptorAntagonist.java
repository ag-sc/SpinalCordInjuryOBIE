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
<p>http://regenbase.org/ontology#RB_0000220
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.tocris.com/products/nogo-66-1-40_1984
<p>
<p><b>rdfs:label</b>
<p>NOGO receptor antagonist
<p>
<p><b>rdfs:description</b>
<p>NOGO receptor antagonist is a peptide fragment corresponding to residues 1 - 40 of Nogo-66, the domain of the myelin protein Nogo that inhibits axonal outgrowth. Acts as a competitive antagonist at the Nogo-66 receptor (NgR); blocks Nogo-66- and CNS myelin-induced inhibition of axonal growth, but does not reduce myelin-associated glycoprotein (MAG) inhibition of neurite outgrowth in vitro. Promotes regeneration of hemisected spinal axons and locomotor recovery following spinal injury in vivo.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=NOGOReceptorAntagonist.class)

@AssignableSubInterfaces(get={})
 public interface INOGOReceptorAntagonist
 extends IProtein{

}
