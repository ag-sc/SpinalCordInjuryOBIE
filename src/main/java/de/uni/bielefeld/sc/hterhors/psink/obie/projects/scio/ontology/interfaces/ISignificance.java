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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C61040
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C61040
<p>
<p><b>scio:example</b>
<p>We also observed the trend of augmented CST axons at a lower level of transverse spinal cord sections 11–15 mm distal to SCI in the ibuprofen-treated rats, although the difference between ibuprofen and control groups did not reach statistical significance (P<0.05).
<p>
<p><b>rdfs:label</b>
<p>significance
<p>
<p><b>scio:visualizationContainer</b>
<p>Result_Group
<p>
<p><b>rdfs:description</b>
<p>Significance is a concept in statistics, a number that expresses the probability that the result of a given experiment or study could have occurred purely by chance. This number can be a margin of error or it can indicate a confidence level.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={IPositiveSignificance.class, IZeroSignificance.class, })

@ImplementationClass(get=Significance.class)
 public interface ISignificance
 extends ISCIOThing{

/**
<p><b>rdfs:label</b>
<p>has alpha significance  niveau
<p>*/
	public IAlphaSignificanceNiveau getAlphaSignificanceNiveau();


/**
<p><b>scio:example</b>
<p>Significantly increased numbers of both TH-positive and 5-HT-positive axon profiles were detected in PEG-treated animals compared to TX only-controls (J, mean + SEM, one-sided Mann–Whitney U test; ***p ≤ 0.001).
<p>
<p><b>rdfs:label</b>
<p>has p value
<p>
<p><b>rdfs:comment</b>
<p>Property of the \"significance\" of a result which can be either \"yes\" or \"no\". This property points at the p value which was calculated by the author or the p value range for the statistical significance test, e.g. p<0.05.
<p>
<p><b>rdfs:description</b>
<p>The P value, or calculated probability, is the probability of finding the observed, or more extreme, results when the null hypothesis (H0) of a study question is true – the definition of ‘extreme’ depends on how the hypothesis is being tested. P is also described in terms of rejecting H0 when it is actually true, however, it is not a direct probability of this state.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
	public IPValue getPValue();


/**
<p><b>rdfs:label</b>
<p>has alpha significance  niveau
<p>*/
	public ISignificance setAlphaSignificanceNiveau(IAlphaSignificanceNiveau alphaSignificanceNiveau);


/**
<p><b>scio:example</b>
<p>Significantly increased numbers of both TH-positive and 5-HT-positive axon profiles were detected in PEG-treated animals compared to TX only-controls (J, mean + SEM, one-sided Mann–Whitney U test; ***p ≤ 0.001).
<p>
<p><b>rdfs:label</b>
<p>has p value
<p>
<p><b>rdfs:comment</b>
<p>Property of the \"significance\" of a result which can be either \"yes\" or \"no\". This property points at the p value which was calculated by the author or the p value range for the statistical significance test, e.g. p<0.05.
<p>
<p><b>rdfs:description</b>
<p>The P value, or calculated probability, is the probability of finding the observed, or more extreme, results when the null hypothesis (H0) of a study question is true – the definition of ‘extreme’ depends on how the hypothesis is being tested. P is also described in terms of rejecting H0 when it is actually true, however, it is not a direct probability of this state.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
	public ISignificance setPValue(IPValue pValue);


}
