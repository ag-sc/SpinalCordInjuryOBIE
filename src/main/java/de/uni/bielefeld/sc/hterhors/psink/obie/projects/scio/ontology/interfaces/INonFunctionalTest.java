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
<p><b>rdfs:label</b>
<p>non functional test
<p>
<p><b>rdfs:description</b>
<p>Non-functional Test is the Investigation method which is performed with tissue, liquids or organs of the subject but does not require it's functionality. In most cases this test is applied after the subjects death as for histological investigation methods. It can also comprise detection of molecules in the living organism's body liquids.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=NonFunctionalTest.class)

@AssignableSubInterfaces(get={ILesionVolumeTest.class, INeuronalActivityTest.class, IOligodendrogliaChangesTest.class, IMyelinationTest.class, INeurogenesisTest.class, IHistologicalInvestgationTest.class, IAxonalSproutingTest.class, IProteinLevelAnalysis.class, IAngiogenesisTest.class, IAxonalChangesTest.class, ISchwannCellChangesTest.class, IOxidativeStressTest.class, IMolecularChangesTest.class, IAxonalRegenerationTest.class, IApoptosisTest.class, IAstrogliosisTest.class, IHemorrhageTest.class, ITissueSparingTest.class, IGeneExpressionAnalysis.class, IAxonalDiebackTest.class, ISecondaryDegenerationTest.class, IToxicityTest.class, ICystVolumeTest.class, INonNeuronalCellChangesTest.class, IInflammationTest.class, INeuroprotectionTest.class, INeuronalCellLossTest.class, IAxonalDamageTest.class, IScarringTest.class, INeuronalChangesTest.class, })
 public interface INonFunctionalTest
 extends IInvestigationMethod{

/**
<p><b>scio:example</b>
<p>Lesion areas from sections containing the central canal were outlined using Image Pro software and lesion size calculated for statistical analysis.
<p>
<p><b>rdfs:label</b>
<p>has location
<p>
<p><b>rdfs:comment</b>
<p>Property of the investigation method type \"non-functional\" test. This points at the anatomical location of the tissue investigated in the test, e.g. if a histological method is applied.

Multiple anatomical locations can be used for investigation and pooled in the outcome  measure of an experiment, e.g. if tissue from thoracic level 3, 4 and 5 are used for axon quantification.
<p>*/
	public INonFunctionalTest addLocation(ILocation location);


/**
<p><b>scio:example</b>
<p>Lesion areas from sections containing the central canal were outlined using Image Pro software and lesion size calculated for statistical analysis.
<p>
<p><b>rdfs:label</b>
<p>has location
<p>
<p><b>rdfs:comment</b>
<p>Property of the investigation method type \"non-functional\" test. This points at the anatomical location of the tissue investigated in the test, e.g. if a histological method is applied.

Multiple anatomical locations can be used for investigation and pooled in the outcome  measure of an experiment, e.g. if tissue from thoracic level 3, 4 and 5 are used for axon quantification.
<p>*/
	public List<ILocation> getLocations();


/**
<p><b>scio:example</b>
<p>Lesion areas from sections containing the central canal were outlined using Image Pro software and lesion size calculated for statistical analysis.
<p>
<p><b>rdfs:label</b>
<p>has location
<p>
<p><b>rdfs:comment</b>
<p>Property of the investigation method type \"non-functional\" test. This points at the anatomical location of the tissue investigated in the test, e.g. if a histological method is applied.

Multiple anatomical locations can be used for investigation and pooled in the outcome  measure of an experiment, e.g. if tissue from thoracic level 3, 4 and 5 are used for axon quantification.
<p>*/
	public INonFunctionalTest setLocations(List<ILocation> locations);


}
