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
<p><b>skos:closeMatch</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C25598
<p>
<p><b>rdfs:label</b>
<p>observation
<p>
<p><b>scio:visualizationContainer</b>
<p>Observation_Group
<p>
<p><b>rdfs:description</b>
<p>Observation is the group of variables, qualitative states and any physical changes during an experiment.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@SuperRootClasses(get={Observation.class, })

@DirectSiblings(get={})

@AssignableSubClasses(get={})

@DirectInterface(get=IObservation.class)
 public class Observation implements IObservation{

final public static IndividualFactory<ObservationIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = ObservationIndividual.class;
static class ObservationIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public ObservationIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "ObservationIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<ObservationIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final ObservationIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Observation";
	@OntologyModelContent(ontologyName="http://psink.de/scio/belongsTo")
private IExperimentalGroup belongsToExperimentalGroup;
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasNonNumericValue")
@DatatypeProperty
private INonNumericValue nonNumericValue;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasNumericValue")
private INumericValue numericValue;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@RelationTypeCollection
@OntologyModelContent(ontologyName="http://psink.de/scio/hasTemporalInterval")
private List<ITemporalInterval> temporalIntervals = new ArrayList<>();
	@TextMention
final private String textMention;


	public Observation(String individualURI, String textMention){
this.individual = 
				Observation.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public Observation(Observation observation)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = observation.individual;
if(observation.getBelongsToExperimentalGroup()!=null)this.belongsToExperimentalGroup = (IExperimentalGroup) IOBIEThing.getCloneConstructor(observation.getBelongsToExperimentalGroup().getClass())	.newInstance(observation.getBelongsToExperimentalGroup());
this.characterOffset = observation.getCharacterOffset();
this.characterOnset = observation.getCharacterOnset();
if(observation.getNonNumericValue()!=null)this.nonNumericValue = new NonNumericValue((NonNumericValue)observation.getNonNumericValue());
if(observation.getNumericValue()!=null)this.numericValue = (INumericValue) IOBIEThing.getCloneConstructor(observation.getNumericValue().getClass())	.newInstance(observation.getNumericValue());
for (int j = 0; j < observation.getTemporalIntervals().size(); j++) {if (observation.getTemporalIntervals().get(j) != null) {temporalIntervals.add((ITemporalInterval) IOBIEThing.getCloneConstructor(observation.getTemporalIntervals().get(j).getClass()).newInstance(observation.getTemporalIntervals().get(j)));} else {temporalIntervals.add(null);}}
this.textMention = observation.getTextMention();
}
	public Observation(){
this.individual = null;
this.textMention = null;
}


	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public Observation addTemporalInterval(ITemporalInterval temporalInterval){
		this.temporalIntervals.add(temporalInterval);
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
Observation other = (Observation) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (temporalIntervals == null) {
if (other.temporalIntervals!= null)
return false;
} else if (!temporalIntervals.equals(other.temporalIntervals))
return false;
if (numericValue == null) {
if (other.numericValue!= null)
return false;
} else if (!numericValue.equals(other.numericValue))
return false;
if (nonNumericValue == null) {
if (other.nonNumericValue!= null)
return false;
} else if (!nonNumericValue.equals(other.nonNumericValue))
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
if (belongsToExperimentalGroup == null) {
if (other.belongsToExperimentalGroup!= null)
return false;
} else if (!belongsToExperimentalGroup.equals(other.belongsToExperimentalGroup))
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
<p>belongs to
<p>*/
@Override
	public IExperimentalGroup getBelongsToExperimentalGroup(){
		return belongsToExperimentalGroup;}
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
<p>has non numeric value
<p>*/
@Override
	public INonNumericValue getNonNumericValue(){
		return nonNumericValue;}
	/**
<p><b>rdfs:label</b>
<p>has numeric value
<p>
<p><b>rdfs:description</b>
<p>The observation has a quantified numeric value as outcome.
<p>*/
@Override
	public INumericValue getNumericValue(){
		return numericValue;}
	/***/
@Override
	public String getONTOLOGY_NAME(){
		return ONTOLOGY_NAME;}
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
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public List<ITemporalInterval> getTemporalIntervals(){
		return temporalIntervals;}
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
result = prime * result + ((this.temporalIntervals == null) ? 0 : this.temporalIntervals.hashCode());
result = prime * result + ((this.numericValue == null) ? 0 : this.numericValue.hashCode());
result = prime * result + ((this.nonNumericValue == null) ? 0 : this.nonNumericValue.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.belongsToExperimentalGroup == null) ? 0 : this.belongsToExperimentalGroup.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
return result;}
	/***/
@Override
	public boolean isEmpty(){
		boolean isEmpty = true;
return false;}
	/**
<p><b>rdfs:label</b>
<p>belongs to
<p>*/
@Override
	public Observation setBelongsToExperimentalGroup(IExperimentalGroup experimentalGroup){
		this.belongsToExperimentalGroup = experimentalGroup;
return this;}
	/***/
@Override
	public void setCharacterOnset(Integer onset){
		this.characterOnset = onset;
 this.characterOffset = onset + textMention.length();}
	/**
<p><b>rdfs:label</b>
<p>has non numeric value
<p>*/
@Override
	public Observation setNonNumericValue(INonNumericValue nonNumericValue){
		this.nonNumericValue = nonNumericValue;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has numeric value
<p>
<p><b>rdfs:description</b>
<p>The observation has a quantified numeric value as outcome.
<p>*/
@Override
	public Observation setNumericValue(INumericValue numericValue){
		this.numericValue = numericValue;
return this;}
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public Observation setTemporalIntervals(List<ITemporalInterval> temporalIntervals){
		if(temporalIntervals==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.temporalIntervals = temporalIntervals;
return this;}


@Override
public String toString(){
return "Observation [individual="+individual+",belongsToExperimentalGroup="+belongsToExperimentalGroup+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",nonNumericValue="+nonNumericValue+",numericValue="+numericValue+",serialVersionUID="+serialVersionUID+",temporalIntervals="+temporalIntervals+",textMention="+textMention+"]";}


}
