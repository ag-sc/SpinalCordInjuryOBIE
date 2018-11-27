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
<p>http://purl.bioontology.org/ontology/MESH/D016373
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68018076
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68014746
<p>
<p><b>rdfs:label</b>
<p>vimentin anti sense dna
<p>
<p><b>rdfs:description</b>
<p>Vimentin Antisense DNA is the anti-sense cyclic DNA for Vimentin which is an intermediate filament protein found in most differentiating cells, in cells grown in tissue culture, and in certain fully differentiated cells. Its insolubility suggests that it serves a structural function in the cytoplasm. MW 52,000. 
A complementary DNA is a single-stranded complementary DNA synthesized from an RNA template by the action of RNA-dependent DNA polymerase. cDNA (i.e., complementary DNA, not circular DNA, not C-DNA) is used in a variety of molecular cloning experiments as well as serving as a specific hybridization probe.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=VimentinAntiSenseDNA.class)

@AssignableSubInterfaces(get={})
 public interface IVimentinAntiSenseDNA
 extends IDNA{

}
