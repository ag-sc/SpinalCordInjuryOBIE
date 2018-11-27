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
<p>trend
<p>
<p><b>scio:visualizationContainer</b>
<p>Result_Group
<p>
<p><b>rdfs:description</b>
<p>Trend is the outcome or result of an investigative test.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IRepeatedMeasureTrend.class, ISingleMeasureTrend.class, })

@ImplementationClass(get=Trend.class)
 public interface ITrend
 extends ISCIOThing{

/**
<p><b>rdfs:label</b>
<p>has difference
<p>*/
	public IObservedDifference getObservedDifference();


/**
<p><b>scio:example</b>
<p>As shown in Figure 1A, female animals treated with E2 were significantly better compared to vehicletreated females at day 7 (p less than 0.5) post-injury, but this difference did not persist.
<p>
<p><b>rdfs:label</b>
<p>has significance
<p>
<p><b>rdfs:comment</b>
<p>Property of the result. It points at the significance information for a result which can be \"yes\" or \"no\".
<p>*/
	public ISignificance getSignificance();


/**
<p><b>rdfs:label</b>
<p>has difference
<p>*/
	public ITrend setObservedDifference(IObservedDifference observedDifference);


/**
<p><b>scio:example</b>
<p>As shown in Figure 1A, female animals treated with E2 were significantly better compared to vehicletreated females at day 7 (p less than 0.5) post-injury, but this difference did not persist.
<p>
<p><b>rdfs:label</b>
<p>has significance
<p>
<p><b>rdfs:comment</b>
<p>Property of the result. It points at the significance information for a result which can be \"yes\" or \"no\".
<p>*/
	public ITrend setSignificance(ISignificance significance);


}
