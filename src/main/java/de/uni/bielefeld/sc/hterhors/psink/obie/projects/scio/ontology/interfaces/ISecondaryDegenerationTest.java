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
<p>Notably, this treatment resulted in a significant reduction of secondary tissue loss and functional deficit.
<p>
<p><b>rdfs:label</b>
<p>secondary degeneration test
<p>
<p><b>rdfs:description</b>
<p>Secondary Degeneration Test is the histological examination of the process of degeneration of tissue after the initial impact. This process can last for several days or weeks after spinal cord injury.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 14637115
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=SecondaryDegenerationTest.class)

@AssignableSubInterfaces(get={ILesionVolumeTest.class, IToxicityTest.class, IOxidativeStressTest.class, IApoptosisTest.class, ICystVolumeTest.class, IHemorrhageTest.class, ITissueSparingTest.class, })
 public interface ISecondaryDegenerationTest
 extends IHistologicalInvestgationTest{

}
