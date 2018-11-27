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
<p>https://www.ncbi.nlm.nih.gov/mesh/68006470
<p>
<p><b>scio:example</b>
<p>Our data show that E2 attenuated BSCB permeability and hemorrhage and reduced the infiltration of neutrophils and macorphages after SCI.
<p>
<p><b>rdfs:label</b>
<p>hemorrhage test
<p>
<p><b>rdfs:description</b>
<p>Hemorrhage Test is the histological examination of bleeding or escape of blood from a vessel.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1210/en.2014-1832
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=HemorrhageTest.class)

@AssignableSubInterfaces(get={})
 public interface IHemorrhageTest
 extends ISecondaryDegenerationTest{

}
