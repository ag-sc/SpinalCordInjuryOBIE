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
<p>http://purl.obolibrary.org/obo/HP_0012824
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.bioontology.org/ontology/SNOMEDCT/246112005
<p>
<p><b>rdfs:label</b>
<p>injury intensity
<p>
<p><b>scio:visualizationContainer</b>
<p>Injury_Group
<p>
<p><b>rdfs:description</b>
<p>Injury Intensity or severity is a measure for the severity of a spinal cord injury. It can be mild, moderate, severe etc..
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=InjuryIntensity.class)
 public interface IInjuryIntensity
 extends ISCIOThing{

}
