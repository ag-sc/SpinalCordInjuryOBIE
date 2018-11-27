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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C92648
<p>
<p><b>scio:example</b>
<p>We examined the changes in body weight, histopathological changes, apoptosis, and the expressions of apoptosis-related proteins after 14 days and 28 days after transplantation.
<p>
<p><b>rdfs:label</b>
<p>body weight examination
<p>
<p><b>rdfs:description</b>
<p>Body Weight Examination is the record of the subjects body weight.
<p>
<p><b>scio:exampleSource</b>
<p>http://dx.doi.org/10.1155/2015/516215
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=BodyWeightExamination.class)

@AssignableSubInterfaces(get={})
 public interface IBodyWeightExamination
 extends IPhysiologyTest{

}
