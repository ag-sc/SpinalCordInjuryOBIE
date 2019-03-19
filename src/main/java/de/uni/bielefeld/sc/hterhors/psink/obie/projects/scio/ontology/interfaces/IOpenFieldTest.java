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
<p>All animals were gentled prior to injury so that they were comfortable being handled and walking in the open field apparatus.
<p>
<p><b>rdfs:label</b>
<p>open field test
<p>
<p><b>rdfs:description</b>
<p>Open Field Test is a functional test for locomotion in an open field where the animal can move freely. There are multiple aspects that can be monitored in this arrangement. Usually, neurologic scales are used to grade the animals locomotor skills.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>doi:  10.1186/1742-2094-10-20
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=OpenFieldTest.class)

@AssignableSubInterfaces(get={})
 public interface IOpenFieldTest
 extends INeurologicScalesTest{

}
