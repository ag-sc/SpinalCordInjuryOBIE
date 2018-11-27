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
<p>Intraperitoneal treatment with MnTBAP + nitro-L-arginine significantly reduced motoneuron and cell loss and apoptosis in the gray and white matter compared with the vehicle-treated group.
<p>
<p><b>rdfs:label</b>
<p>neuronal cell loss test
<p>
<p><b>rdfs:description</b>
<p>Neuronal Cell Loss Test is the examination of failure of neuroprotection, meaning the decrease in number of neruons.
<p>
<p><b>scio:exampleSource</b>
<p>doi:  10.1186/1471-2202-14-146
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=NeuronalCellLossTest.class)

@AssignableSubInterfaces(get={})
 public interface INeuronalCellLossTest
 extends INeuronalChangesTest{

}
