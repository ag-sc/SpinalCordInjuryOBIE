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
<p>https://www.ncbi.nlm.nih.gov/mesh/68014554
<p>
<p><b>scio:example</b>
<p>The novel combination treatment allows for remarkably lengthy regeneration of certain subtypes of brainstem and propriospinal axons across the injury site and is followed by markedly improved urinary function.
<p>
<p><b>rdfs:label</b>
<p>urine voiding test
<p>
<p><b>rdfs:description</b>
<p>Urine Voiding Test or Urination Test is the examination of the discharge of urine, liquid waste processed by the kidney, from the body.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1523/JNEUROSCI.1116-12.2013
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=UrineVoidingTest.class)

@AssignableSubInterfaces(get={})
 public interface IUrineVoidingTest
 extends IPhysiologyTest{

}
