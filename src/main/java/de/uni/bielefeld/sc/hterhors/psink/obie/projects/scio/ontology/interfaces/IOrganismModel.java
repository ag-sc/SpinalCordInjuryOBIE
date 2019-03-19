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
<p><b>rdfs:label</b>
<p>organism model
<p>
<p><b>scio:visualizationContainer</b>
<p>Organism_Group
<p>
<p><b>rdfs:description</b>
<p>Organism Model is the subject of an experiment in research which represents the population of similar organisms.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=OrganismModel.class)

@AssignableSubInterfaces(get={IRabbitModel.class, IGuineaPigModel.class, IMinipigModel.class, IAnimalModel.class, IMouseModel.class, IDogModel.class, IMonkeyModel.class, IPatient.class, IRatModel.class, ICatModel.class, })
 public interface IOrganismModel
 extends ISCIOThing{

/**
<p><b>rdfs:label</b>
<p>has age
<p>*/
	public IAge getAge();


/**
<p><b>scio:example</b>
<p>Three groups of male Sprague-Dawley rats, including young (40 days), mature (5-6 months) and old (28-29 months) were spinally hemisected at the L1 level.
<p>
<p><b>rdfs:label</b>
<p>has age category
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal type. Points at the animal age. Age of the animal at time of injury, young or adult or aged.
<p>
<p><b>rdfs:description</b>
<p>Specific age stated in days weeks, months or years.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26024702
<p>*/
	public IAgeCategory getAgeCategory();


/**
<p><b>scio:example</b>
<p>Adult male Wistar albino rats weighing 200–250 g were used in this study.
<p>
<p><b>rdfs:label</b>
<p>has gender
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal type. Points at the animal gender. It can be female, male or mixed gender group of animals.
<p>*/
	public IGender getGender();


/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
	public IOrganismSpecies getOrganismSpecies();


/**
<p><b>scio:example</b>
<p>After laminectomy, the vertebral column was stabilized with clamps and a 10 g rod was dropped from a 12.5 mm height over the exposed spinal cord and the compression maintained for 5 seconds.
<p>
<p><b>rdfs:label</b>
<p>has weight
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal or of an injury device detail. Points at the supporting class \"weight\" which can be in g, mg etc.
<p>
<p><b>rdfs:description</b>
<p>Any weight measured in µg, g or other units.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26896212
<p>*/
	public IWeight getWeight();


/**
<p><b>rdfs:label</b>
<p>has age
<p>*/
	public IOrganismModel setAge(IAge age);


/**
<p><b>scio:example</b>
<p>Three groups of male Sprague-Dawley rats, including young (40 days), mature (5-6 months) and old (28-29 months) were spinally hemisected at the L1 level.
<p>
<p><b>rdfs:label</b>
<p>has age category
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal type. Points at the animal age. Age of the animal at time of injury, young or adult or aged.
<p>
<p><b>rdfs:description</b>
<p>Specific age stated in days weeks, months or years.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26024702
<p>*/
	public IOrganismModel setAgeCategory(IAgeCategory ageCategory);


/**
<p><b>scio:example</b>
<p>Adult male Wistar albino rats weighing 200–250 g were used in this study.
<p>
<p><b>rdfs:label</b>
<p>has gender
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal type. Points at the animal gender. It can be female, male or mixed gender group of animals.
<p>*/
	public IOrganismModel setGender(IGender gender);


/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
	public IOrganismModel setOrganismSpecies(IOrganismSpecies organismSpecies);


/**
<p><b>scio:example</b>
<p>After laminectomy, the vertebral column was stabilized with clamps and a 10 g rod was dropped from a 12.5 mm height over the exposed spinal cord and the compression maintained for 5 seconds.
<p>
<p><b>rdfs:label</b>
<p>has weight
<p>
<p><b>rdfs:comment</b>
<p>Property of the animal or of an injury device detail. Points at the supporting class \"weight\" which can be in g, mg etc.
<p>
<p><b>rdfs:description</b>
<p>Any weight measured in µg, g or other units.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26896212
<p>*/
	public IOrganismModel setWeight(IWeight weight);


}
