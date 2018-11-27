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
<p>http://purl.obolibrary.org/obo/CHEBI_16991
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68004247
<p>
<p><b>rdfs:label</b>
<p>dna
<p>
<p><b>rdfs:description</b>
<p>DNA or desoxyribonucleic acid is a deoxyribonucleotide polymer that is the primary genetic material of all cells. Eukaryotic and prokaryotic organisms normally contain DNA in a double-stranded state, yet several important biological processes transiently involve single-stranded regions. DNA, which consists of a polysugar-phosphate backbone possessing projections of purines (adenine and guanine) and pyrimidines (thymine and cytosine), forms a double helix that is held together by hydrogen bonds between these purines and pyrimidines (adenine to thymine and guanine to cytosine).
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=DNA.class)

@AssignableSubInterfaces(get={IVimentinAntiSenseDNA.class, })
 public interface IDNA
 extends INucleicAcid{

}
