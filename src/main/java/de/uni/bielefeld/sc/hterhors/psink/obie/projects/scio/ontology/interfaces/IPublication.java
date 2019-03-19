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
<p>publication
<p>
<p><b>scio:visualizationContainer</b>
<p>Experimental_Design_Group
<p>
<p><b>rdfs:description</b>
<p>Publication comprises any information about a scientific article.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=Publication.class)

@AssignableSubInterfaces(get={})
 public interface IPublication
 extends ISCIOThing{

/**
<p><b>rdfs:label</b>
<p>has author
<p>*/
	public IPublication addAuthorPerson(IPerson person);


/**
<p><b>rdfs:label</b>
<p>describes
<p>*/
	public IPublication addDescribesExperiment(IExperiment experiment);


/**
<p><b>rdfs:label</b>
<p>has author
<p>*/
	public List<IPerson> getAuthorPersons();


/**
<p><b>rdfs:label</b>
<p>describes
<p>*/
	public List<IExperiment> getDescribesExperiments();


/**
<p><b>rdfs:label</b>
<p>has publication year
<p>
<p><b>rdfs:comment</b>
<p>The year of publication.
<p>*/
	public IPublicationYear getPublicationYear();


/**
<p><b>rdfs:label</b>
<p>has pubmed id
<p>
<p><b>rdfs:comment</b>
<p>The pubmed id of this publication.
<p>*/
	public IPubmedID getPubmedID();


/**
<p><b>rdfs:label</b>
<p>has author
<p>*/
	public IPublication setAuthorPersons(List<IPerson> authorPersons);


/**
<p><b>rdfs:label</b>
<p>describes
<p>*/
	public IPublication setDescribesExperiments(List<IExperiment> describesExperiments);


/**
<p><b>rdfs:label</b>
<p>has publication year
<p>
<p><b>rdfs:comment</b>
<p>The year of publication.
<p>*/
	public IPublication setPublicationYear(IPublicationYear publicationYear);


/**
<p><b>rdfs:label</b>
<p>has pubmed id
<p>
<p><b>rdfs:comment</b>
<p>The pubmed id of this publication.
<p>*/
	public IPublication setPubmedID(IPubmedID pubmedID);


}
