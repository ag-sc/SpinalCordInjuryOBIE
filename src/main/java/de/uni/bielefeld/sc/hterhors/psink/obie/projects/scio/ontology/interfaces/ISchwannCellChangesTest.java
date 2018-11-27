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
<p>https://www.ncbi.nlm.nih.gov/mesh/68012583
<p>
<p><b>scio:example</b>
<p>As revealed by electron microscopy, bundles of regenerating axons within the matrix area received myelin ensheathment from Schwann cells.
<p>
<p><b>rdfs:label</b>
<p>schwann cell changes test
<p>
<p><b>rdfs:description</b>
<p>Schwann Cell Changes Test is the histological examination of alterations in the neuroglial cells of the peripheral nervous system which form the insulating myelin sheaths of peripheral axons. After spinal cord injury, these cells can migrate into the lesion area or beyond this.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.nbd.2014.03.018
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=SchwannCellChangesTest.class)

@AssignableSubInterfaces(get={})
 public interface ISchwannCellChangesTest
 extends INonNeuronalCellChangesTest{

}
