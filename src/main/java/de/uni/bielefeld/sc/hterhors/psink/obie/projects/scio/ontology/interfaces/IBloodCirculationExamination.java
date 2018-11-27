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
<p>http://purl.obolibrary.org/obo/CMO_0000195
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68001775
<p>
<p><b>scio:example</b>
<p>SCBF was measured in the ischemic penumbra zone surrounding the trauma epicenter using contrast-enhanced ultrasonography.
<p>
<p><b>rdfs:label</b>
<p>blood circulation examination
<p>
<p><b>rdfs:description</b>
<p>Blood Circulation Examnation is the assessment of the movement of the blood as it is pumped through the cardiovascular system.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1007/s00586-013-3086-9
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=BloodCirculationExamination.class)

@AssignableSubInterfaces(get={})
 public interface IBloodCirculationExamination
 extends ICardioVascularFunctionTest{

}
