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
<p>http://purl.bioontology.org/ontology/STY/T008
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C93727
<p>
<p><b>rdfs:label</b>
<p>animal species
<p>
<p><b>rdfs:description</b>
<p>Animal species is the name specifying one of the basic units of biological classification and taxonomic rank that specifies a group of organisms that share similar characteristics and can interbreed with one another to produce fertile offspring.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=AnimalSpecies.class)

@AssignableSubInterfaces(get={IRabbitSpecies.class, IMonkeySpecies.class, IRatSpecies.class, IGuineaPigSpecies.class, ICatSpecies.class, IDogSpecies.class, IMinipigSpecies.class, IMouseSpecies.class, })
 public interface IAnimalSpecies
 extends IOrganismSpecies{

}
