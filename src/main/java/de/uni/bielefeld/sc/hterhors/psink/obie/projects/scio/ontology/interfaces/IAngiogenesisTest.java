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
<p>https://www.ncbi.nlm.nih.gov/mesh/68018919
<p>
<p><b>scio:example</b>
<p>In this study, we found that increased levels of miR-126 promoted angiogenesis, and inhibited leukocyte extravasation into the injured spinal cord, which was concurrent with downregulation of mRNA and protein expression of three validated miR-126 target genes, SPRED1, PIK3R2, and VCAM1.
<p>
<p><b>rdfs:label</b>
<p>angiogenesis test
<p>
<p><b>rdfs:description</b>
<p>Angiogenesis Test is the examination of the development of new blood vessels during the restoration of blood circulation during the healing process with histological methods.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=AngiogenesisTest.class)

@AssignableSubInterfaces(get={})
 public interface IAngiogenesisTest
 extends INonNeuronalCellChangesTest{

}
