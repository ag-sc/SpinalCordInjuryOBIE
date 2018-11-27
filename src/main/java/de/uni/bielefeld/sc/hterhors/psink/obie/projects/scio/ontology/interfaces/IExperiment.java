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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C42790
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C42790
<p>
<p><b>rdfs:label</b>
<p>experiment
<p>
<p><b>scio:visualizationContainer</b>
<p>Experimental_Design_Group
<p>
<p><b>rdfs:description</b>
<p>Experiment is a coordinated set of actions and observations designed to generate data, with the ultimate goal of discovery or hypothesis testing.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Experiment.class)

@AssignableSubInterfaces(get={})
 public interface IExperiment
 extends ISCIOThing{

/**
<p><b>rdfs:label</b>
<p>has experimental method
<p>*/
	public IExperiment addExperimentalMethod(IExperimentalMethod experimentalMethod);


/**
<p><b>rdfs:label</b>
<p>has result
<p>*/
	public IExperiment addResult(IResult result);


/**
<p><b>rdfs:label</b>
<p>has study design
<p>*/
	public IExperiment addStudyDesign(IStudyDesign studyDesign);


/**
<p><b>rdfs:label</b>
<p>has experimental method
<p>*/
	public List<IExperimentalMethod> getExperimentalMethods();


/**
<p><b>rdfs:label</b>
<p>has result
<p>*/
	public List<IResult> getResults();


/**
<p><b>rdfs:label</b>
<p>has study design
<p>*/
	public List<IStudyDesign> getStudyDesigns();


/**
<p><b>rdfs:label</b>
<p>has experimental method
<p>*/
	public IExperiment setExperimentalMethods(List<IExperimentalMethod> experimentalMethods);


/**
<p><b>rdfs:label</b>
<p>has result
<p>*/
	public IExperiment setResults(List<IResult> results);


/**
<p><b>rdfs:label</b>
<p>has study design
<p>*/
	public IExperiment setStudyDesigns(List<IStudyDesign> studyDesigns);


}
