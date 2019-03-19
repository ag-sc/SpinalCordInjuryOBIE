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
<p>An epidural perfusion device was applied to maintain a steady temperature (18 °C) for 120 min with gradual rewarming to 37 °C
<p>
<p><b>rdfs:label</b>
<p>temperature treatment
<p>
<p><b>rdfs:description</b>
<p>Temperature Treatment is the procedure of modifying body temperature in order to save spinal cord tissue from damage or indurce processes leading to recovery.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26322652
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=TemperatureTreatment.class)

@AssignableSubInterfaces(get={IHypothermicTreatment.class, INormothermicTreatment.class, })
 public interface ITemperatureTreatment
 extends IPhysicalTreatment{

/**
<p><b>scio:example</b>
<p>An epidural perfusion device was applied to maintain a steady temperature (18 °C) for 120 min with gradual rewarming to 37 °C
<p>
<p><b>rdfs:label</b>
<p>has temperature
<p>
<p><b>rdfs:comment</b>
<p>Property of the specific class \"Physical\" treatment with \"Temperature\". This points at \"degree temperature\".
<p>
<p><b>rdfs:description</b>
<p>Temperature, unit is Celsius or Fahrenheit.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26322652
<p>*/
	public ITemperature getTemperature();


/**
<p><b>scio:example</b>
<p>An epidural perfusion device was applied to maintain a steady temperature (18 °C) for 120 min with gradual rewarming to 37 °C
<p>
<p><b>rdfs:label</b>
<p>has temperature
<p>
<p><b>rdfs:comment</b>
<p>Property of the specific class \"Physical\" treatment with \"Temperature\". This points at \"degree temperature\".
<p>
<p><b>rdfs:description</b>
<p>Temperature, unit is Celsius or Fahrenheit.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26322652
<p>*/
	public ITemperatureTreatment setTemperature(ITemperature temperature);


}
