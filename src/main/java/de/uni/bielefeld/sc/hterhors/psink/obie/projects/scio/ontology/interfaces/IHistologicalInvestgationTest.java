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
<p>http://purl.obolibrary.org/obo/OBI_0002564
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.bioontology.org/ontology/SNOMEDCT/394597005
<p>
<p><b>skos:closeMatch</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C16681
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68006653
<p>
<p><b>rdfs:label</b>
<p>histological investgation test
<p>
<p><b>rdfs:description</b>
<p>Histological Investigation Test or Histology is the study of the structure of various tissues of organisms on a microscopic level.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=HistologicalInvestgationTest.class)

@AssignableSubInterfaces(get={ILesionVolumeTest.class, INeuronalActivityTest.class, IOligodendrogliaChangesTest.class, IMyelinationTest.class, INeurogenesisTest.class, IAxonalSproutingTest.class, IAngiogenesisTest.class, IAxonalChangesTest.class, ISchwannCellChangesTest.class, IOxidativeStressTest.class, IAxonalRegenerationTest.class, IApoptosisTest.class, IAstrogliosisTest.class, IHemorrhageTest.class, ITissueSparingTest.class, IAxonalDiebackTest.class, ISecondaryDegenerationTest.class, IToxicityTest.class, ICystVolumeTest.class, INonNeuronalCellChangesTest.class, IInflammationTest.class, INeuroprotectionTest.class, INeuronalCellLossTest.class, IAxonalDamageTest.class, IScarringTest.class, INeuronalChangesTest.class, })
 public interface IHistologicalInvestgationTest
 extends INonFunctionalTest{

}
