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
<p>There were significant differences in FA when compared to the SCI/PPy/I vs SCI group (p < 0.05).
<p>
<p><b>rdfs:label</b>
<p>positive significance
<p>
<p><b>rdfs:description</b>
<p>Positive Significance is the test result of a statistical test which confirms that a null hypothesis could be rejected and - if two or more groups were compared - the difference between  these groups is statistically significant, i.e. a certain p value (usually below 0.05) was computed.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.spinee.2016.02.012
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=PositiveSignificance.class)

@AssignableSubInterfaces(get={})
 public interface IPositiveSignificance
 extends ISignificance{

}
