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
<p>The mortality rates were, respectively, 5.55 % (2/36) and 13.9 % (5/36) in groups C and D, and there was no significant difference between groups C and D (P = 0.214).
<p>
<p><b>rdfs:label</b>
<p>zero significance
<p>
<p><b>rdfs:description</b>
<p>Zero Significance is the test result of a statistical test which confirms that a null hypothesis can not be rejected and - if two or more groups were compared - the difference between  these groups is not statistically significant, i.e. a certain p value (usually above 0.05) was computed.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1186/s13018-016-0369-y
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=ZeroSignificance.class)
 public interface IZeroSignificance
 extends ISignificance{

}
