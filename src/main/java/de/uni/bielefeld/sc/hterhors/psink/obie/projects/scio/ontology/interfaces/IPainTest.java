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
<p>http://ontologies.dbmi.pitt.edu/edda/StudyDesigns.owl#pain_assessment
<p>
<p><b>rdfs:label</b>
<p>pain test
<p>
<p><b>rdfs:description</b>
<p>Pain Test are scales, questionnaires, tests, and other methods used to assess pain severity and duration in patients or experimental animals to aid in diagnosis, therapy, and physiological studies. [MeSH 2014_2014_02_10].
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IMechanicalAllodyniaTest.class, IAvoidanceResponseTest.class, IThermalHyperalgesiaTest.class, ITailFlickReflexTest.class, })

@ImplementationClass(get=PainTest.class)
 public interface IPainTest
 extends IFunctionalTest{

}
