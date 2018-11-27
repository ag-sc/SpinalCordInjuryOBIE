package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes;

import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.*;
import java.lang.NoSuchMethodException;
import de.hterhors.obie.core.ontology.interfaces.IDatatype;
import de.hterhors.obie.core.ontology.annotations.SuperRootClasses;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import java.util.HashMap;
import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import java.util.ArrayList;
import org.apache.jena.rdf.model.Model;
import de.hterhors.obie.core.ontology.annotations.AssignableSubInterfaces;
import de.hterhors.obie.core.ontology.annotations.ImplementationClass;
import org.apache.jena.rdf.model.Resource;
import java.util.Map;
import java.lang.InstantiationException;
import java.lang.SecurityException;
import de.hterhors.obie.core.ontology.annotations.DirectSiblings;
import java.lang.IllegalAccessException;
import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.IndividualFactory;
import de.hterhors.obie.core.ontology.annotations.DirectInterface;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import java.lang.IllegalArgumentException;
import de.hterhors.obie.core.ontology.annotations.TextMention;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.jena.rdf.model.ModelFactory;
import de.hterhors.obie.core.ontology.AbstractIndividual;

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
*Oct 23, 2018
*/

@SuperRootClasses(get={Publication.class, })

@DirectSiblings(get={})

@AssignableSubClasses(get={})

@DirectInterface(get=IPublication.class)
 public class Publication implements IPublication{

final public static IndividualFactory<PublicationIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = PublicationIndividual.class;
static class PublicationIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public PublicationIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "PublicationIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<PublicationIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final PublicationIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Publication";
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasAuthor")
@RelationTypeCollection
private List<IPerson> authorPersons = new ArrayList<>();
	private Integer characterOffset;
	private Integer characterOnset;
	@RelationTypeCollection
@OntologyModelContent(ontologyName="http://psink.de/scio/describes")
private List<IExperiment> describesExperiments = new ArrayList<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasPublicationYear")
@DatatypeProperty
private IPublicationYear publicationYear;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasPubmedID")
private IPubmedID pubmedID;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public Publication(String individualURI, String textMention){
this.individual = 
				Publication.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public Publication(){
this.individual = null;
this.textMention = null;
}
	public Publication(Publication publication)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = publication.individual;
for (int j = 0; j < publication.getAuthorPersons().size(); j++) {if (publication.getAuthorPersons().get(j) != null) {authorPersons.add((IPerson) IOBIEThing.getCloneConstructor(publication.getAuthorPersons().get(j).getClass()).newInstance(publication.getAuthorPersons().get(j)));} else {authorPersons.add(null);}}
this.characterOffset = publication.getCharacterOffset();
this.characterOnset = publication.getCharacterOnset();
for (int j = 0; j < publication.getDescribesExperiments().size(); j++) {if (publication.getDescribesExperiments().get(j) != null) {describesExperiments.add((IExperiment) IOBIEThing.getCloneConstructor(publication.getDescribesExperiments().get(j).getClass()).newInstance(publication.getDescribesExperiments().get(j)));} else {describesExperiments.add(null);}}
if(publication.getPublicationYear()!=null)this.publicationYear = new PublicationYear((PublicationYear)publication.getPublicationYear());
if(publication.getPubmedID()!=null)this.pubmedID = new PubmedID((PubmedID)publication.getPubmedID());
this.textMention = publication.getTextMention();
}


	/**
<p><b>rdfs:label</b>
<p>has author
<p>*/
@Override
	public Publication addAuthorPerson(IPerson person){
		this.authorPersons.add(person);
return this;}
	/**
<p><b>rdfs:label</b>
<p>describes
<p>*/
@Override
	public Publication addDescribesExperiment(IExperiment experiment){
		this.describesExperiments.add(experiment);
return this;}
	/***/
@Override
	public boolean equals(Object obj){
		if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Publication other = (Publication) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (publicationYear == null) {
if (other.publicationYear!= null)
return false;
} else if (!publicationYear.equals(other.publicationYear))
return false;
if (pubmedID == null) {
if (other.pubmedID!= null)
return false;
} else if (!pubmedID.equals(other.pubmedID))
return false;
if (authorPersons == null) {
if (other.authorPersons!= null)
return false;
} else if (!authorPersons.equals(other.authorPersons))
return false;
if (describesExperiments == null) {
if (other.describesExperiments!= null)
return false;
} else if (!describesExperiments.equals(other.describesExperiments))
return false;
if (textMention == null) {
if (other.textMention!= null)
return false;
} else if (!textMention.equals(other.textMention))
return false;
if (characterOffset == null) {
if (other.characterOffset!= null)
return false;
} else if (!characterOffset.equals(other.characterOffset))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
return true;
}
	/**
<p><b>rdfs:label</b>
<p>has author
<p>*/
@Override
	public List<IPerson> getAuthorPersons(){
		return authorPersons;}
	/***/
@Override
	public Integer getCharacterOffset(){
		return characterOffset;}
	/***/
@Override
	public Integer getCharacterOnset(){
		return characterOnset;}
	/**
<p><b>rdfs:label</b>
<p>describes
<p>*/
@Override
	public List<IExperiment> getDescribesExperiments(){
		return describesExperiments;}
	/***/
@Override
	public String getONTOLOGY_NAME(){
		return ONTOLOGY_NAME;}
	/**
<p><b>rdfs:label</b>
<p>has publication year
<p>
<p><b>rdfs:comment</b>
<p>The year of publication.
<p>*/
@Override
	public IPublicationYear getPublicationYear(){
		return publicationYear;}
	/**
<p><b>rdfs:label</b>
<p>has pubmed id
<p>
<p><b>rdfs:comment</b>
<p>The pubmed id of this publication.
<p>*/
@Override
	public IPubmedID getPubmedID(){
		return pubmedID;}
	/***/
@Override
	public Model getRDFModel(String resourceIDPrefix){
		Model model = ModelFactory.createDefaultModel();
Resource group = model.createResource(getResourceName());
model.add(group, model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),model.createResource(ONTOLOGY_NAME));
return model;
}
	/***/
@Override
	public String getResourceName(){
		if (resourceFactory.containsKey(this)) {
return ISCIOThing.RDF_MODEL_NAMESPACE + resourceFactory.get(this);
} else {
final String resourceName = getClass().getSimpleName() + "_" + resourceFactory.size();
resourceFactory.put(this, resourceName);
return ISCIOThing.RDF_MODEL_NAMESPACE + resourceName;}
}
	/***/
@Override
	public String getTextMention(){
		return textMention;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.publicationYear == null) ? 0 : this.publicationYear.hashCode());
result = prime * result + ((this.pubmedID == null) ? 0 : this.pubmedID.hashCode());
result = prime * result + ((this.authorPersons == null) ? 0 : this.authorPersons.hashCode());
result = prime * result + ((this.describesExperiments == null) ? 0 : this.describesExperiments.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
return result;}
	/***/
@Override
	public boolean isEmpty(){
		boolean isEmpty = true;
return false;}
	/**
<p><b>rdfs:label</b>
<p>has author
<p>*/
@Override
	public Publication setAuthorPersons(List<IPerson> persons){
		if(persons==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.authorPersons = persons;
return this;}
	/***/
@Override
	public void setCharacterOnset(Integer onset){
		this.characterOnset = onset;
 this.characterOffset = onset + textMention.length();}
	/**
<p><b>rdfs:label</b>
<p>describes
<p>*/
@Override
	public Publication setDescribesExperiments(List<IExperiment> experiments){
		if(experiments==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.describesExperiments = experiments;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has publication year
<p>
<p><b>rdfs:comment</b>
<p>The year of publication.
<p>*/
@Override
	public Publication setPublicationYear(IPublicationYear publicationYear){
		this.publicationYear = publicationYear;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has pubmed id
<p>
<p><b>rdfs:comment</b>
<p>The pubmed id of this publication.
<p>*/
@Override
	public Publication setPubmedID(IPubmedID pubmedID){
		this.pubmedID = pubmedID;
return this;}


@Override
public String toString(){
return "Publication [individual="+individual+",authorPersons="+authorPersons+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",describesExperiments="+describesExperiments+",publicationYear="+publicationYear+",pubmedID="+pubmedID+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
