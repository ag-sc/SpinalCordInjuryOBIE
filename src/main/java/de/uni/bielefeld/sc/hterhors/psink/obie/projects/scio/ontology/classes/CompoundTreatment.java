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
<p>http://purl.obolibrary.org/obo/OBI_0000951
<p>
<p><b>rdfs:label</b>
<p>compound treatment
<p>
<p><b>scio:visualizationContainer</b>
<p>Compound_Treatment_Group
<p>
<p><b>rdfs:description</b>
<p>Compound Treatment is a therapeutic intervention for spinal cord injury which includes the application of a substance, cell, implant etc. which is either applied locally or systemically.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@SuperRootClasses(get={Treatment.class, })

@DirectSiblings(get={CompoundTreatment.class, ModificationTreatment.class, PhysicalTreatment.class, })

@AssignableSubClasses(get={})

@DirectInterface(get=ICompoundTreatment.class)
 public class CompoundTreatment implements ICompoundTreatment{

final public static IndividualFactory<CompoundTreatmentIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = CompoundTreatmentIndividual.class;
static class CompoundTreatmentIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public CompoundTreatmentIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "CompoundTreatmentIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<CompoundTreatmentIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final CompoundTreatmentIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public CompoundTreatment setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/CompoundTreatment";
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasApplicationInstrument")
private IApplicationInstrument applicationInstrument;
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasCompound")
private ICompound compound;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDeliveryMethod")
private IDeliveryMethod deliveryMethod;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDirection")
@RelationTypeCollection
private List<IDirection> directions = new ArrayList<>();
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasDosage")
private IDosage dosage;
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
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasSuppliedCompositeCompound")
private ICompound suppliedCompositeCompound;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasTemporalInterval")
@RelationTypeCollection
private List<ITemporalInterval> temporalIntervals = new ArrayList<>();
	@TextMention
final private String textMention;


	public CompoundTreatment(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				CompoundTreatment.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public CompoundTreatment(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public CompoundTreatment(CompoundTreatment compoundTreatment)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = compoundTreatment.individual;
this.investigationRestriction = compoundTreatment.investigationRestriction;
if(compoundTreatment.getApplicationInstrument()!=null)this.applicationInstrument = (IApplicationInstrument) IOBIEThing.getCloneConstructor(compoundTreatment.getApplicationInstrument().getClass())	.newInstance(compoundTreatment.getApplicationInstrument());
this.characterOffset = compoundTreatment.getCharacterOffset();
this.characterOnset = compoundTreatment.getCharacterOnset();
if(compoundTreatment.getCompound()!=null)this.compound = (ICompound) IOBIEThing.getCloneConstructor(compoundTreatment.getCompound().getClass())	.newInstance(compoundTreatment.getCompound());
if(compoundTreatment.getDeliveryMethod()!=null)this.deliveryMethod = (IDeliveryMethod) IOBIEThing.getCloneConstructor(compoundTreatment.getDeliveryMethod().getClass())	.newInstance(compoundTreatment.getDeliveryMethod());
for (int j = 0; j < compoundTreatment.getDirections().size(); j++) {if (compoundTreatment.getDirections().get(j) != null) {directions.add((IDirection) IOBIEThing.getCloneConstructor(compoundTreatment.getDirections().get(j).getClass()).newInstance(compoundTreatment.getDirections().get(j)));} else {directions.add(null);}}
if(compoundTreatment.getDosage()!=null)this.dosage = new Dosage((Dosage)compoundTreatment.getDosage());
if(compoundTreatment.getDuration()!=null)this.duration = new Duration((Duration)compoundTreatment.getDuration());
if(compoundTreatment.getFrequency()!=null)this.frequency = new Frequency((Frequency)compoundTreatment.getFrequency());
if(compoundTreatment.getInterval()!=null)this.interval = new Interval((Interval)compoundTreatment.getInterval());
if(compoundTreatment.getLocation()!=null)this.location = (ILocation) IOBIEThing.getCloneConstructor(compoundTreatment.getLocation().getClass())	.newInstance(compoundTreatment.getLocation());
if(compoundTreatment.getSuppliedCompositeCompound()!=null)this.suppliedCompositeCompound = (ICompound) IOBIEThing.getCloneConstructor(compoundTreatment.getSuppliedCompositeCompound().getClass())	.newInstance(compoundTreatment.getSuppliedCompositeCompound());
for (int j = 0; j < compoundTreatment.getTemporalIntervals().size(); j++) {if (compoundTreatment.getTemporalIntervals().get(j) != null) {temporalIntervals.add((ITemporalInterval) IOBIEThing.getCloneConstructor(compoundTreatment.getTemporalIntervals().get(j).getClass()).newInstance(compoundTreatment.getTemporalIntervals().get(j)));} else {temporalIntervals.add(null);}}
this.textMention = compoundTreatment.getTextMention();
}


	/**
<p><b>rdfs:label</b>
<p>has direction
<p>*/
@Override
	public CompoundTreatment addDirection(IDirection direction){
		this.directions.add(direction);
return this;}
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public CompoundTreatment addTemporalInterval(ITemporalInterval temporalInterval){
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
CompoundTreatment other = (CompoundTreatment) obj;
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
if (dosage == null) {
if (other.dosage!= null)
return false;
} else if (!dosage.equals(other.dosage))
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
if (suppliedCompositeCompound == null) {
if (other.suppliedCompositeCompound!= null)
return false;
} else if (!suppliedCompositeCompound.equals(other.suppliedCompositeCompound))
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
if (compound == null) {
if (other.compound!= null)
return false;
} else if (!compound.equals(other.compound))
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
<p><b>rdfs:label</b>
<p>has compound
<p>
<p><b>rdfs:comment</b>
<p>A compound treatment has usually one compound and this is characterized by its type, dosage, anatomical location and instrument of application. 

If an experimental group is treated with a combinatorial approach as implantation of a cell and injection of a substance, then 2 treatments are associated with this experimental group.

Multiple timepoints can be assigned as treatment timepoint for one treatment, if the other properties of the treatment stay the same, i.e. dosage, delivery method, anatomical location and instrument of application. 
If one or more of these properties are changed, e.g. different doses of a substance are applied at different timepoints, then these paradigms are modeled as individual treatments. This means, dosage X at day 1 is treatment 1, dosage Y at day 2 is treatment 2.

Some combinatorial approaches consist of indivisible units like Schwann cell seeded guidance channels which are implanted as one unit. In order to model this approach, the property \"has composite compound\" is used.
<p>*/
@Override
	public ICompound getCompound(){
		return compound;}
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
<p>For alginate-hydrogel (ALG) preparation, a 2% (w/v) solution of alginate (Pronova UP LVM; NovaMatrix) in 150 mM sodium chloride (NaCl) was filtered with a sterile syringe filter.
<p>
<p><b>rdfs:label</b>
<p>has dosage
<p>
<p><b>rdfs:comment</b>
<p>Property of anaesthetic, postsurgical medication and compound. Points at supporting class \"Dosage\". Information about concentration of a substance or solution of e.g. cells. It can apply for a treatment substance or an anaesthetic or even an outcome measure if e.g. body fluid is investigated.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
@Override
	public IDosage getDosage(){
		return dosage;}
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
<p>has supplied composite compound
<p>
<p><b>rdfs:comment</b>
<p>Some combinatorial approaches consist of indivisible units like Schwann cell seeded guidance channels which are implanted as one unit. In order to model this approach, the property \"has composite compound\" is used.
<p>*/
@Override
	public ICompound getSuppliedCompositeCompound(){
		return suppliedCompositeCompound;}
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
result = prime * result + ((this.dosage == null) ? 0 : this.dosage.hashCode());
result = prime * result + ((this.temporalIntervals == null) ? 0 : this.temporalIntervals.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.suppliedCompositeCompound == null) ? 0 : this.suppliedCompositeCompound.hashCode());
result = prime * result + ((this.location == null) ? 0 : this.location.hashCode());
result = prime * result + ((this.deliveryMethod == null) ? 0 : this.deliveryMethod.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.applicationInstrument == null) ? 0 : this.applicationInstrument.hashCode());
result = prime * result + ((this.directions == null) ? 0 : this.directions.hashCode());
result = prime * result + ((this.interval == null) ? 0 : this.interval.hashCode());
result = prime * result + ((this.compound == null) ? 0 : this.compound.hashCode());
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
	public CompoundTreatment setApplicationInstrument(IApplicationInstrument applicationInstrument){
		this.applicationInstrument = applicationInstrument;
return this;}
	/***/
@Override
	public void setCharacterOnset(Integer onset){
		this.characterOnset = onset;
 this.characterOffset = onset + textMention.length();}
	/**
<p><b>rdfs:label</b>
<p>has compound
<p>
<p><b>rdfs:comment</b>
<p>A compound treatment has usually one compound and this is characterized by its type, dosage, anatomical location and instrument of application. 

If an experimental group is treated with a combinatorial approach as implantation of a cell and injection of a substance, then 2 treatments are associated with this experimental group.

Multiple timepoints can be assigned as treatment timepoint for one treatment, if the other properties of the treatment stay the same, i.e. dosage, delivery method, anatomical location and instrument of application. 
If one or more of these properties are changed, e.g. different doses of a substance are applied at different timepoints, then these paradigms are modeled as individual treatments. This means, dosage X at day 1 is treatment 1, dosage Y at day 2 is treatment 2.

Some combinatorial approaches consist of indivisible units like Schwann cell seeded guidance channels which are implanted as one unit. In order to model this approach, the property \"has composite compound\" is used.
<p>*/
@Override
	public CompoundTreatment setCompound(ICompound compound){
		this.compound = compound;
return this;}
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
	public CompoundTreatment setDeliveryMethod(IDeliveryMethod deliveryMethod){
		this.deliveryMethod = deliveryMethod;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has direction
<p>*/
@Override
	public CompoundTreatment setDirections(List<IDirection> directions){
		if(directions==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.directions = directions;
return this;}
	/**
<p><b>scio:example</b>
<p>For alginate-hydrogel (ALG) preparation, a 2% (w/v) solution of alginate (Pronova UP LVM; NovaMatrix) in 150 mM sodium chloride (NaCl) was filtered with a sterile syringe filter.
<p>
<p><b>rdfs:label</b>
<p>has dosage
<p>
<p><b>rdfs:comment</b>
<p>Property of anaesthetic, postsurgical medication and compound. Points at supporting class \"Dosage\". Information about concentration of a substance or solution of e.g. cells. It can apply for a treatment substance or an anaesthetic or even an outcome measure if e.g. body fluid is investigated.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
@Override
	public CompoundTreatment setDosage(IDosage dosage){
		this.dosage = dosage;
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
	public CompoundTreatment setDuration(IDuration duration){
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
	public CompoundTreatment setFrequency(IFrequency frequency){
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
	public CompoundTreatment setInterval(IInterval interval){
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
	public CompoundTreatment setLocation(ILocation location){
		this.location = location;
return this;}
	/**
<p><b>rdfs:label</b>
<p>has supplied composite compound
<p>
<p><b>rdfs:comment</b>
<p>Some combinatorial approaches consist of indivisible units like Schwann cell seeded guidance channels which are implanted as one unit. In order to model this approach, the property \"has composite compound\" is used.
<p>*/
@Override
	public CompoundTreatment setSuppliedCompositeCompound(ICompound compound){
		this.suppliedCompositeCompound = compound;
return this;}
	/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
@Override
	public CompoundTreatment setTemporalIntervals(List<ITemporalInterval> temporalIntervals){
		if(temporalIntervals==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.temporalIntervals = temporalIntervals;
return this;}


@Override
public String toString(){
return "CompoundTreatment [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",applicationInstrument="+applicationInstrument+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",compound="+compound+",deliveryMethod="+deliveryMethod+",directions="+directions+",dosage="+dosage+",duration="+duration+",frequency="+frequency+",interval="+interval+",location="+location+",serialVersionUID="+serialVersionUID+",suppliedCompositeCompound="+suppliedCompositeCompound+",temporalIntervals="+temporalIntervals+",textMention="+textMention+"]";}


}
