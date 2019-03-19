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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/75067006
<p>
<p><b>skos:closeMatch</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C139210
<p>
<p><b>scio:example</b>
<p>Whereas performance in the upward-facing orientation reflected forelimb strength (which should not have been affected by a lower thoracic SCI in otherwise healthy animals), performance facing downward measured coordinated hind limb motor function (22, 23, 30).
<p>
<p><b>rdfs:label</b>
<p>forelimb strength test
<p>
<p><b>rdfs:comment</b>
<p>Also known as: Grip Strenght Meter Test
<p>
<p><b>rdfs:description</b>
<p>Forelimb Strength Test or grip strength test is the assessment of hand muscle strength that measures that force with which one holds or grasps.
<p>
<p><b>scio:exampleSource</b>
<p>doi:  10.1073/pnas.0306239101
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=ForelimbStrengthTest.class)
 public interface IForelimbStrengthTest
 extends ILimbMuscleStrengthTest{

}
