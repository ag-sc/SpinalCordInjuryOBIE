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
<p>Following transection of the dorsal corticospinal tract (CST) at thoracic level 8 in adult rats, transient suppression of collagenous scarring in the lesion zone by local application of a potent iron chelator and cyclic adenosine monophosphate resulted in the delay of fibrous scarring.
<p>
<p><b>rdfs:label</b>
<p>scarring test
<p>
<p><b>rdfs:description</b>
<p>Scarring Test is the histological examination of the fibrous tissue that replaces normal tissue during the process of wound healing. After spinal cord injury, a glial scar forms at the lesion penumbra while a fibrous scar forms in its core.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 16367771
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=ScarringTest.class)

@AssignableSubInterfaces(get={})
 public interface IScarringTest
 extends IHistologicalInvestgationTest{

}
