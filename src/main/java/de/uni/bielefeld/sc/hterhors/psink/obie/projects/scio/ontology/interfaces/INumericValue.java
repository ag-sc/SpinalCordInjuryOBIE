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
<p>numeric value
<p>
<p><b>scio:visualizationContainer</b>
<p>Observation_Group
<p>
<p><b>rdfs:description</b>
<p>Numeric Value is the measured quantitative value in an experiment.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=NumericValue.class)

@AssignableSubInterfaces(get={IMedianValue.class, IMeanValue.class, })
 public interface INumericValue
 extends ISCIOThing{

/**
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=standard+deviation
<p>
<p><b>rdfs:label</b>
<p>has standard deviation
<p>
<p><b>rdfs:description</b>
<p>Property of the

Normal Distribution

Continuous frequency distribution of infinite range. Its properties are as follows: 1, continuous, symmetrical distribution with both tails extending to infinity; 2, arithmetic mean, mode, and median identical; and 3, shape completely determined by the mean and standard deviation.
<p>*/
	public IStandardDeviation getStandardDeviation();


/**
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=standard+deviation
<p>
<p><b>rdfs:label</b>
<p>has standard error
<p>
<p><b>rdfs:description</b>
<p>Property of the

Normal Distribution

Continuous frequency distribution of infinite range. Its properties are as follows: 1, continuous, symmetrical distribution with both tails extending to infinity; 2, arithmetic mean, mode, and median identical; and 3, shape completely determined by the mean and standard deviation.
<p>*/
	public IStandardError getStandardError();


/**
<p><b>rdfs:label</b>
<p>has value
<p>*/
	public IValue getValue();


/**
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=standard+deviation
<p>
<p><b>rdfs:label</b>
<p>has standard deviation
<p>
<p><b>rdfs:description</b>
<p>Property of the

Normal Distribution

Continuous frequency distribution of infinite range. Its properties are as follows: 1, continuous, symmetrical distribution with both tails extending to infinity; 2, arithmetic mean, mode, and median identical; and 3, shape completely determined by the mean and standard deviation.
<p>*/
	public INumericValue setStandardDeviation(IStandardDeviation standardDeviation);


/**
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=standard+deviation
<p>
<p><b>rdfs:label</b>
<p>has standard error
<p>
<p><b>rdfs:description</b>
<p>Property of the

Normal Distribution

Continuous frequency distribution of infinite range. Its properties are as follows: 1, continuous, symmetrical distribution with both tails extending to infinity; 2, arithmetic mean, mode, and median identical; and 3, shape completely determined by the mean and standard deviation.
<p>*/
	public INumericValue setStandardError(IStandardError standardError);


/**
<p><b>rdfs:label</b>
<p>has value
<p>*/
	public INumericValue setValue(IValue value);


}
