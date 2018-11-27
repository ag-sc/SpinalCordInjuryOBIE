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
<p><b>rdfs:description</b>
<p>Temporal Entity is a temporal interval or instant.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@DirectInterface(get=ITime_TemporalEntity.class)

@SuperRootClasses(get={Time_TemporalEntity.class, })

@DirectSiblings(get={})

@AssignableSubClasses(get={Compression.class, MagneticFieldApplication.class, EnrichedEnvironment.class, Injury.class, Contusion.class, Laminectomy.class, ModificationTreatment.class, ElectrolyticLesion.class, PhotochemicalInjury.class, Dislocation.class, VentralHemisection.class, InjuryByAccident.class, DorsalHemisection.class, OvariectomyTreatment.class, PhysicalImplantTreatment.class, TemperatureTreatment.class, HypothermicTreatment.class, AspirationLesion.class, ChemicalInjury.class, HeatLesion.class, CompleteTransection.class, CurrentApplication.class, CompoundTreatment.class, RehabilitativeTraining.class, NormothermicTreatment.class, PhysicalTreatment.class, TreadmillTraining.class, VoltageApplication.class, Treatment.class, Distraction.class, PartialTransection.class, Observation.class, Investigation.class, Event.class, GeneticModificationTreatment.class, ElectromagneticFieldTreatment.class, TemporalInterval.class, SurgeryTreatment.class, LateralHemisection.class, })
 public class Time_TemporalEntity implements ITime_TemporalEntity{

final public static IndividualFactory<Time_TemporalEntityIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = Time_TemporalEntityIndividual.class;
static class Time_TemporalEntityIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public Time_TemporalEntityIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "Time_TemporalEntityIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<Time_TemporalEntityIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final Time_TemporalEntityIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://www.w3.org/2006/time#TemporalEntity";
	private Integer characterOffset;
	private Integer characterOnset;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public Time_TemporalEntity(String individualURI, String textMention){
this.individual = 
				Time_TemporalEntity.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public Time_TemporalEntity(Time_TemporalEntity time_TemporalEntity)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = time_TemporalEntity.individual;
this.characterOffset = time_TemporalEntity.getCharacterOffset();
this.characterOnset = time_TemporalEntity.getCharacterOnset();
this.textMention = time_TemporalEntity.getTextMention();
}
	public Time_TemporalEntity(){
this.individual = null;
this.textMention = null;
}


	/***/
@Override
	public boolean equals(Object obj){
		if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Time_TemporalEntity other = (Time_TemporalEntity) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
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
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
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


@Override
public String toString(){
return "Time_TemporalEntity [individual="+individual+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
