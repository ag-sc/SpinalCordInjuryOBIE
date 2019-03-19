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
import de.hterhors.obie.core.ontology.InvestigationRestriction;
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
<p>http://doe-generated-ontology.com/OntoAD#C0220931
<p>
<p><b>rdfs:label</b>
<p>rehabilitative training
<p>
<p><b>rdfs:description</b>
<p>Rehabilitative Training is a therapeutic intervention for spinal cord injury by physical exercise.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@SuperRootClasses(get={Treatment.class, })

@DirectSiblings(get={RehabilitativeTraining.class, PhysicalImplantTreatment.class, TemperatureTreatment.class, ElectromagneticFieldTreatment.class, SurgeryTreatment.class, })

@DirectInterface(get=IRehabilitativeTraining.class)

@AssignableSubClasses(get={TreadmillTraining.class, EnrichedEnvironment.class, })
 public class RehabilitativeTraining implements IRehabilitativeTraining{

final public static IndividualFactory<RehabilitativeTrainingIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = RehabilitativeTrainingIndividual.class;
static class RehabilitativeTrainingIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public RehabilitativeTrainingIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "RehabilitativeTrainingIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<RehabilitativeTrainingIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final RehabilitativeTrainingIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public RehabilitativeTraining setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/RehabilitativeTraining";
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasApplicationInstrument")
private IApplicationInstrument applicationInstrument;
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDeliveryMethod")
private IDeliveryMethod deliveryMethod;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDirection")
@RelationTypeCollection
private List<IDirection> directions = new ArrayList<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDuration")
@DatatypeProperty
private IDuration duration;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasFrequency")
private IFrequency frequency;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasInterval")
private IInterval interval;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasLocation")
private ILocation location;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTemporalInterval")
@RelationTypeCollection
private List<ITemporalInterval> temporalIntervals = new ArrayList<>();
	@TextMention
final private String textMention;


	public RehabilitativeTraining(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				RehabilitativeTraining.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public RehabilitativeTraining(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public RehabilitativeTraining(RehabilitativeTraining rehabilitativeTraining)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = rehabilitativeTraining.individual;
this.investigationRestriction = rehabilitativeTraining.investigationRestriction;
if(rehabilitativeTraining.getApplicationInstrument()!=null)this.applicationInstrument = (IApplicationInstrument) IOBIEThing.getCloneConstructor(rehabilitativeTraining.getApplicationInstrument().getClass())	.newInstance(rehabilitativeTraining.getApplicationInstrument());
this.characterOffset = rehabilitativeTraining.getCharacterOffset();
this.characterOnset = rehabilitativeTraining.getCharacterOnset();
if(rehabilitativeTraining.getDeliveryMethod()!=null)this.deliveryMethod = (IDeliveryMethod) IOBIEThing.getCloneConstructor(rehabilitativeTraining.getDeliveryMethod().getClass())	.newInstance(rehabilitativeTraining.getDeliveryMethod());
for (int j = 0; j < rehabilitativeTraining.getDirections().size(); j++) {if (rehabilitativeTraining.getDirections().get(j) != null) {directions.add((IDirection) IOBIEThing.getCloneConstructor(rehabilitativeTraining.getDirections().get(j).getClass()).newInstance(rehabilitativeTraining.getDirections().get(j)));} else {directions.add(null);}}
if(rehabilitativeTraining.getDuration()!=null)this.duration = new Duration((Duration)rehabilitativeTraining.getDuration());
if(rehabilitativeTraining.getFrequency()!=null)this.frequency = new Frequency((Frequency)rehabilitativeTraining.getFrequency());
if(rehabilitativeTraining.getInterval()!=null)this.interval = new Interval((Interval)rehabilitativeTraining.getInterval());
if(rehabilitativeTraining.getLocation()!=null)this.location = (ILocation) IOBIEThing.getCloneConstructor(rehabilitativeTraining.getLocation().getClass())	.newInstance(rehabilitativeTraining.getLocation());
for (int j = 0; j < rehabilitativeTraining.getTemporalIntervals().size(); j++) {if (rehabilitativeTraining.getTemporalIntervals().get(j) != null) {temporalIntervals.add((ITemporalInterval) IOBIEThing.getCloneConstructor(rehabilitativeTraining.getTemporalIntervals().get(j).getClass()).newInstance(rehabilitativeTraining.getTemporalIntervals().get(j)));} else {temporalIntervals.add(null);}}
this.textMention = rehabilitativeTraining.getTextMention();
}


	/**
<p><b>rdfs:label</b>
<p>has direction
<p>*/
@Override
	public RehabilitativeTraining addDirection(IDirection direction){
		this.directions.add(direction);
return this;}
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public RehabilitativeTraining addTemporalInterval(ITemporalInterval temporalInterval){
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
RehabilitativeTraining other = (RehabilitativeTraining) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (investigationRestriction == null) {
if (other.investigationRestriction!= null)
return false;
} else if (!investigationRestriction.equals(other.investigationRestriction))
return false;
if (duration == null) {
if (other.duration!= null)
return false;
} else if (!duration.equals(other.duration))
return false;
if (temporalIntervals == null) {
if (other.temporalIntervals!= null)
return false;
} else if (!temporalIntervals.equals(other.temporalIntervals))
return false;
if (characterOffset == null) {
if (other.characterOffset!= null)
return false;
} else if (!characterOffset.equals(other.characterOffset))
return false;
if (location == null) {
if (other.location!= null)
return false;
} else if (!location.equals(other.location))
return false;
if (deliveryMethod == null) {
if (other.deliveryMethod!= null)
return false;
} else if (!deliveryMethod.equals(other.deliveryMethod))
return false;
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
return false;
if (applicationInstrument == null) {
if (other.applicationInstrument!= null)
return false;
} else if (!applicationInstrument.equals(other.applicationInstrument))
return false;
if (directions == null) {
if (other.directions!= null)
return false;
} else if (!directions.equals(other.directions))
return false;
if (interval == null) {
if (other.interval!= null)
return false;
} else if (!interval.equals(other.interval))
return false;
if (textMention == null) {
if (other.textMention!= null)
return false;
} else if (!textMention.equals(other.textMention))
return false;
if (frequency == null) {
if (other.frequency!= null)
return false;
} else if (!frequency.equals(other.frequency))
return false;
return true;
}
	/**
<p><b>scio:example</b>
<p>...physiological saline for the vehicle-treated group was administered by an intraperitoneal injection using a syringe immediately after trauma.
<p>
<p><b>rdfs:label</b>
<p>has application instrument
<p>
<p><b>rdfs:comment</b>
<p>Property of the treatment type. Points at the application instrument. This is the instrument for application of therapy or anaesthesia, e.g. syringe, capsule, but also hypothermia blanked, electrodes etc.
<p>*/
@Override
	public IApplicationInstrument getApplicationInstrument(){
		return applicationInstrument;}
	/***/
@Override
	public Integer getCharacterOffset(){
		return characterOffset;}
	/***/
@Override
	public Integer getCharacterOnset(){
		return characterOnset;}
	/**
<p><b>scio:example</b>
<p>...physiological saline for the vehicle-treated group was administered by an intraperitoneal injection using a syringe immediately after trauma.
<p>
<p><b>rdfs:label</b>
<p>has delivery method
<p>
<p><b>rdfs:comment</b>
<p>Property of anaesthetic and compound. Points at the supporting class \"Delivery\". This is the route of administration of medication or other substances (e.g. oral, subcutaneous).
<p>
<p><b>rdfs:description</b>
<p>Route of administration of medication, cells implants or other therapeutical substances.
<p>*/
@Override
	public IDeliveryMethod getDeliveryMethod(){
		return deliveryMethod;}
	/**
<p><b>rdfs:label</b>
<p>has direction
<p>*/
@Override
	public List<IDirection> getDirections(){
		return directions;}
	/**
<p><b>scio:example</b>
<p>A weight of 50 g was applied statically to the T9 of spinal cord for 5 min.
<p>
<p><b>rdfs:label</b>
<p>has duration
<p>
<p><b>rdfs:description</b>
<p>Timing of injury process, i.e. if compression is applied for several seconds.
<p>
<p><b>scio:exampleSource</b>
<p>DOI 10.1007/s12031-015-0564-z
<p>*/
@Override
	public IDuration getDuration(){
		return duration;}
	/**
<p><b>rdfs:label</b>
<p>has frequency
<p>
<p><b>rdfs:comment</b>
<p>Frequency is the number of ocurrences of a repeating event per unit time. For example, \"every 12 hours for one week\". Frequency refers to \"every 12 hours\".
<p>*/
@Override
	public IFrequency getFrequency(){
		return frequency;}
	/**
<p><b>rdfs:label</b>
<p>has interval
<p>
<p><b>rdfs:comment</b>
<p>The interval refers to a definite length of time marked off by two instances. For example, \"every 12 hours for one week\". Interval refers to \"one week\".
<p>*/
@Override
	public IInterval getInterval(){
		return interval;}
	/**
<p><b>scio:example</b>
<p>Lesion areas from sections containing the central canal were outlined using Image Pro software and lesion size calculated for statistical analysis.
<p>
<p><b>rdfs:label</b>
<p>has location
<p>
<p><b>rdfs:comment</b>
<p>Property of the investigation method type \"non-functional\" test. This points at the anatomical location of the tissue investigated in the test, e.g. if a histological method is applied.

Multiple anatomical locations can be used for investigation and pooled in the outcome  measure of an experiment, e.g. if tissue from thoracic level 3, 4 and 5 are used for axon quantification.
<p>*/
@Override
	public ILocation getLocation(){
		return location;}
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
	public IOBIEThing getThis(){
		return this;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.investigationRestriction == null) ? 0 : this.investigationRestriction.hashCode());
result = prime * result + ((this.duration == null) ? 0 : this.duration.hashCode());
result = prime * result + ((this.temporalIntervals == null) ? 0 : this.temporalIntervals.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.location == null) ? 0 : this.location.hashCode());
result = prime * result + ((this.deliveryMethod == null) ? 0 : this.deliveryMethod.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.applicationInstrument == null) ? 0 : this.applicationInstrument.hashCode());
result = prime * result + ((this.directions == null) ? 0 : this.directions.hashCode());
result = prime * result + ((this.interval == null) ? 0 : this.interval.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.frequency == null) ? 0 : this.frequency.hashCode());
return result;}
	/***/
@Override
	public boolean isEmpty(){
		boolean isEmpty = true;
return false;}
	/**
<p><b>scio:example</b>
<p>...physiological saline for the vehicle-treated group was administered by an intraperitoneal injection using a syringe immediately after trauma.
<p>
<p><b>rdfs:label</b>
<p>has application instrument
<p>
<p><b>rdfs:comment</b>
<p>Property of the treatment type. Points at the application instrument. This is the instrument for application of therapy or anaesthesia, e.g. syringe, capsule, but also hypothermia blanked, electrodes etc.
<p>*/
@Override
	public RehabilitativeTraining setApplicationInstrument(IApplicationInstrument applicationInstrument){
		this.applicationInstrument = applicationInstrument;
return this;}
	/***/
@Override
	public void setCharacterOnset(Integer onset){
		this.characterOnset = onset;
 this.characterOffset = onset + textMention.length();}
	/**
<p><b>scio:example</b>
<p>...physiological saline for the vehicle-treated group was administered by an intraperitoneal injection using a syringe immediately after trauma.
<p>
<p><b>rdfs:label</b>
<p>has delivery method
<p>
<p><b>rdfs:comment</b>
<p>Property of anaesthetic and compound. Points at the supporting class \"Delivery\". This is the route of administration of medication or other substances (e.g. oral, subcutaneous).
<p>
<p><b>rdfs:description</b>
<p>Route of administration of medication, cells implants or other therapeutical substances.
<p>*/
@Override
	public RehabilitativeTraining setDeliveryMethod(IDeliveryMethod deliveryMethod){
		this.deliveryMethod = deliveryMethod;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has direction
<p>*/
@Override
	public RehabilitativeTraining setDirections(List<IDirection> directions){
		if(directions==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.directions = directions;
return this;}
	/**
<p><b>scio:example</b>
<p>A weight of 50 g was applied statically to the T9 of spinal cord for 5 min.
<p>
<p><b>rdfs:label</b>
<p>has duration
<p>
<p><b>rdfs:description</b>
<p>Timing of injury process, i.e. if compression is applied for several seconds.
<p>
<p><b>scio:exampleSource</b>
<p>DOI 10.1007/s12031-015-0564-z
<p>*/
@Override
	public RehabilitativeTraining setDuration(IDuration duration){
		this.duration = duration;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has frequency
<p>
<p><b>rdfs:comment</b>
<p>Frequency is the number of ocurrences of a repeating event per unit time. For example, \"every 12 hours for one week\". Frequency refers to \"every 12 hours\".
<p>*/
@Override
	public RehabilitativeTraining setFrequency(IFrequency frequency){
		this.frequency = frequency;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has interval
<p>
<p><b>rdfs:comment</b>
<p>The interval refers to a definite length of time marked off by two instances. For example, \"every 12 hours for one week\". Interval refers to \"one week\".
<p>*/
@Override
	public RehabilitativeTraining setInterval(IInterval interval){
		this.interval = interval;
return this;}
	/**
<p><b>scio:example</b>
<p>Lesion areas from sections containing the central canal were outlined using Image Pro software and lesion size calculated for statistical analysis.
<p>
<p><b>rdfs:label</b>
<p>has location
<p>
<p><b>rdfs:comment</b>
<p>Property of the investigation method type \"non-functional\" test. This points at the anatomical location of the tissue investigated in the test, e.g. if a histological method is applied.

Multiple anatomical locations can be used for investigation and pooled in the outcome  measure of an experiment, e.g. if tissue from thoracic level 3, 4 and 5 are used for axon quantification.
<p>*/
@Override
	public RehabilitativeTraining setLocation(ILocation location){
		this.location = location;
return this;}
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public RehabilitativeTraining setTemporalIntervals(List<ITemporalInterval> temporalIntervals){
		if(temporalIntervals==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.temporalIntervals = temporalIntervals;
return this;}


@Override
public String toString(){
return "RehabilitativeTraining [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",applicationInstrument="+applicationInstrument+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",deliveryMethod="+deliveryMethod+",directions="+directions+",duration="+duration+",frequency="+frequency+",interval="+interval+",location="+location+",serialVersionUID="+serialVersionUID+",temporalIntervals="+temporalIntervals+",textMention="+textMention+"]";}


}
