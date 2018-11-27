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
<p>https://www.ncbi.nlm.nih.gov/mesh/68007249
<p>
<p><b>scio:example</b>
<p>Activated inflammation (evidenced by increased levels of IL-1β, TNF-α, and MPO but decreased levels of IL-10) caused by SCI was noted
<p>
<p><b>rdfs:label</b>
<p>inflammation test
<p>
<p><b>rdfs:description</b>
<p>Inflammation Test is the histological examination of a pathological process characterized by injury or destruction of tissues caused by a variety of cytologic and chemical reactions involving cells of the immune system.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.tjog.2015.12.009
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=InflammationTest.class)

@AssignableSubInterfaces(get={})
 public interface IInflammationTest
 extends INonNeuronalCellChangesTest{

}
