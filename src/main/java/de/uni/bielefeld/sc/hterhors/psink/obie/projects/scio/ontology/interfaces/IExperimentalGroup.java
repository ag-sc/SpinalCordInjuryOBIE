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
<p>http://purl.org/net/OCRe/study_design.owl#OCRE100075
<p>
<p><b>scio:example</b>
<p>Prior to surgery, rats of the lesioned treated (n = 9, Fig. 7A) and lesioned control groups (n = 7, Fig. 7B) showed a low proportion of irregular walking patterns reaching 2.3 ± 1.0% and 0.7 ± 0.7%, respectively.
<p>
<p><b>rdfs:label</b>
<p>experimental group
<p>
<p><b>scio:visualizationContainer</b>
<p>Experimental_Group
<p>
<p><b>rdfs:description</b>
<p>Experimental group is a set of individuals of defined organism model, injury model and treatment model in the context of a study.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1111/j.1460-9568.2005.04495.x
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={IDefinedExperimentalGroup.class, IAnalyzedExperimentalGroup.class, })

@ImplementationClass(get=ExperimentalGroup.class)
 public interface IExperimentalGroup
 extends ISCIOThing{

/**
<p><b>rdfs:label</b>
<p>has group name
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with synonyms in a scientific text, e.g. control group ('control') versus treated group ('treated').
<p>*/
	public IExperimentalGroup addGroupName(IGroupName groupName);


/**
<p><b>rdfs:label</b>
<p>has treatment type
<p>*/
	public IExperimentalGroup addTreatmentType(ITreatment treatment);


/**
<p><b>rdfs:label</b>
<p>has group name
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with synonyms in a scientific text, e.g. control group ('control') versus treated group ('treated').
<p>*/
	public List<IGroupName> getGroupNames();


/**
<p><b>rdfs:label</b>
<p>has group number
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with numbers in a scientific text, e.g. control group (group 1) versus treated group (group 2).
<p>*/
	public IGroupNumber getGroupNumber();


/**
<p><b>rdfs:label</b>
<p>has injury model
<p>*/
	public IInjury getInjuryModel();


/**
<p><b>scio:example</b>
<p>Both animal groups (“TX” vs. “PEG”) initially consisted of N = 14 rats each.
<p>
<p><b>rdfs:label</b>
<p>has N number
<p>
<p><b>rdfs:description</b>
<p>Integer representing the number of animals per group, per result or per statistical analysis.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
	public INNumber getNNumber();


/**
<p><b>rdfs:label</b>
<p>has organism model
<p>*/
	public IOrganismModel getOrganismModel();


/**
<p><b>rdfs:label</b>
<p>has total population size
<p>*/
	public ITotalPopulationSize getTotalPopulationSize();


/**
<p><b>rdfs:label</b>
<p>has treatment type
<p>*/
	public List<ITreatment> getTreatmentTypes();


/**
<p><b>rdfs:label</b>
<p>has group name
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with synonyms in a scientific text, e.g. control group ('control') versus treated group ('treated').
<p>*/
	public IExperimentalGroup setGroupNames(List<IGroupName> groupNames);


/**
<p><b>rdfs:label</b>
<p>has group number
<p>
<p><b>rdfs:description</b>
<p>Experimental groups are often described with numbers in a scientific text, e.g. control group (group 1) versus treated group (group 2).
<p>*/
	public IExperimentalGroup setGroupNumber(IGroupNumber groupNumber);


/**
<p><b>rdfs:label</b>
<p>has injury model
<p>*/
	public IExperimentalGroup setInjuryModel(IInjury injuryModel);


/**
<p><b>scio:example</b>
<p>Both animal groups (“TX” vs. “PEG”) initially consisted of N = 14 rats each.
<p>
<p><b>rdfs:label</b>
<p>has N number
<p>
<p><b>rdfs:description</b>
<p>Integer representing the number of animals per group, per result or per statistical analysis.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
	public IExperimentalGroup setNNumber(INNumber nNumber);


/**
<p><b>rdfs:label</b>
<p>has organism model
<p>*/
	public IExperimentalGroup setOrganismModel(IOrganismModel organismModel);


/**
<p><b>rdfs:label</b>
<p>has total population size
<p>*/
	public IExperimentalGroup setTotalPopulationSize(ITotalPopulationSize totalPopulationSize);


/**
<p><b>rdfs:label</b>
<p>has treatment type
<p>*/
	public IExperimentalGroup setTreatmentTypes(List<ITreatment> treatmentTypes);


}
