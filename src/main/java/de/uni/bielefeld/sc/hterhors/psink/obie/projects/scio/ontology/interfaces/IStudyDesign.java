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
<p>http://www.ebi.ac.uk/efo/EFO_0001426
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.obolibrary.org/obo/OBI_0500000
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C15320
<p>
<p><b>rdfs:label</b>
<p>study design
<p>
<p><b>scio:visualizationContainer</b>
<p>Experimental_Design_Group
<p>
<p><b>rdfs:description</b>
<p>Study Design is a plan detailing how a study will be performed in order to represent the phenomenon under examination, to answer the research questions that have been asked, and defining the methods of data analysis. Study design is driven by research hypothesis being posed, study subject/population/sample available, logistics/resources: technology, support, networking, collaborative support, etc.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={IExperimentalProcedure.class, IInVitroExperimentalProcedure.class, IExperimentalMethod.class, })

@ImplementationClass(get=StudyDesign.class)
 public interface IStudyDesign
 extends ISCIOThing{

}
