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
<p>http://purl.bioontology.org/ontology/STY/T051
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.bioontology.org/ontology/LNC/LP94957-5
<p>
<p><b>scio:descriptionSource</b>
<p>http://purl.org/net/OCRe/OCRe.owl#OCRE400004
<p>
<p><b>rdfs:label</b>
<p>event
<p>
<p><b>rdfs:description</b>
<p>Event is a processual entity that is a maximally connected spatiotemporal whole and has bona fide beginnings and endings corresponding to real discontinuities.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubClasses(get={Compression.class, MagneticFieldApplication.class, EnrichedEnvironment.class, Injury.class, Contusion.class, Laminectomy.class, ModificationTreatment.class, ElectrolyticLesion.class, PhotochemicalInjury.class, Dislocation.class, VentralHemisection.class, InjuryByAccident.class, DorsalHemisection.class, OvariectomyTreatment.class, PhysicalImplantTreatment.class, TemperatureTreatment.class, HypothermicTreatment.class, AspirationLesion.class, ChemicalInjury.class, HeatLesion.class, CompleteTransection.class, CurrentApplication.class, CompoundTreatment.class, RehabilitativeTraining.class, NormothermicTreatment.class, PhysicalTreatment.class, TreadmillTraining.class, VoltageApplication.class, Treatment.class, Distraction.class, PartialTransection.class, Observation.class, Investigation.class, GeneticModificationTreatment.class, ElectromagneticFieldTreatment.class, SurgeryTreatment.class, LateralHemisection.class, })

@SuperRootClasses(get={Event.class, })

@DirectInterface(get=IEvent.class)

@DirectSiblings(get={})
 public class Event implements IEvent{

final public static IndividualFactory<EventIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = EventIndividual.class;
static class EventIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public EventIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "EventIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<EventIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final EventIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public Event setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Event";
	private Integer characterOffset;
	private Integer characterOnset;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTemporalInterval")
@RelationTypeCollection
private List<ITemporalInterval> temporalIntervals = new ArrayList<>();
	@TextMention
final private String textMention;


	public Event(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public Event(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				Event.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public Event(Event event)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = event.individual;
this.investigationRestriction = event.investigationRestriction;
this.characterOffset = event.getCharacterOffset();
this.characterOnset = event.getCharacterOnset();
for (int j = 0; j < event.getTemporalIntervals().size(); j++) {if (event.getTemporalIntervals().get(j) != null) {temporalIntervals.add((ITemporalInterval) IOBIEThing.getCloneConstructor(event.getTemporalIntervals().get(j).getClass()).newInstance(event.getTemporalIntervals().get(j)));} else {temporalIntervals.add(null);}}
this.textMention = event.getTextMention();
}


	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public Event addTemporalInterval(ITemporalInterval temporalInterval){
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
Event other = (Event) obj;
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
if (characterOnset == null) {
if (other.characterOnset!= null)
return false;
} else if (!characterOnset.equals(other.characterOnset))
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
if (textMention == null) {
if (other.textMention!= null)
return false;
} else if (!textMention.equals(other.textMention))
return false;
return true;
}
	/***/
@Override
	public Integer getCharacterOffset(){
		return characterOffset;}
	/***/
@Override
	public Integer getCharacterOnset(){
		return characterOnset;}
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
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.temporalIntervals == null) ? 0 : this.temporalIntervals.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
return result;}
	/***/
@Override
	public boolean isEmpty(){
		boolean isEmpty = true;
return false;}
	/***/
@Override
	public void setCharacterOnset(Integer onset){
		this.characterOnset = onset;
 this.characterOffset = onset + textMention.length();}
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public Event setTemporalIntervals(List<ITemporalInterval> temporalIntervals){
		if(temporalIntervals==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.temporalIntervals = temporalIntervals;
return this;}


@Override
public String toString(){
return "Event [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",serialVersionUID="+serialVersionUID+",temporalIntervals="+temporalIntervals+",textMention="+textMention+"]";}


}
