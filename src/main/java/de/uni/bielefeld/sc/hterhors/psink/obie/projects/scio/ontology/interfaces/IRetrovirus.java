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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/77622001
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68012190
<p>
<p><b>rdfs:label</b>
<p>retrovirus
<p>
<p><b>rdfs:description</b>
<p>Retrovirus is a family of RNA viruses that infects birds and mammals and encodes the enzyme reverse transcriptase. The family contains seven genera: DELTARETROVIRUS; LENTIVIRUS; RETROVIRUSES TYPE B, MAMMALIAN; ALPHARETROVIRUS; GAMMARETROVIRUS; RETROVIRUSES TYPE D; and SPUMAVIRUS. A key feature of retrovirus biology is the synthesis of a DNA copy of the genome which is integrated into cellular DNA. After integration it is sometimes not expressed but maintained in a latent state (PROVIRUSES).
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={INT3Lentivirus.class, ILentivirus.class, })

@ImplementationClass(get=Retrovirus.class)
 public interface IRetrovirus
 extends IVirus{

}
