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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/373492002
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.bioontology.org/ontology/SNOMEDCT/373476007
<p>
<p><b>scio:example</b>
<p>The animals were anesthetized with Dormicum [midazolam, 0.6 mg per 100 gm body weight (bw), i.p.; Roche, Basel, Switzerland] and Hypnorm (fentanyl, 0.02 mg per 100 gm bw, i.p.; Janssen-Cilag, Beerse, Belgium).
<p>
<p><b>rdfs:label</b>
<p>fluanisone midazolam mixture
<p>
<p><b>rdfs:description</b>
<p>Fluanisone Midazolam Mixture is a typical sedative mixture for anaesthesia induction and maintenance containing the two components fluanisone and midazolam.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 11331396
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@DirectInterface(get=IFluanisoneMidazolamMixture.class)

@AssignableSubClasses(get={})

@DirectSiblings(get={KetamineAsAnaesthetic.class, ThiopentalSodium.class, SodiumPentobarbital.class, NitrousOxide.class, Halothane.class, Xylazine.class, Isoflurane.class, Diazepam.class, FluanisoneMidazolamMixture.class, })

@SuperRootClasses(get={AnimalCareCondition.class, })
 public class FluanisoneMidazolamMixture implements IFluanisoneMidazolamMixture{

final public static IndividualFactory<FluanisoneMidazolamMixtureIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = FluanisoneMidazolamMixtureIndividual.class;
static class FluanisoneMidazolamMixtureIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public FluanisoneMidazolamMixtureIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "FluanisoneMidazolamMixtureIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<FluanisoneMidazolamMixtureIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final FluanisoneMidazolamMixtureIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public FluanisoneMidazolamMixture setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/FluanisoneMidazolamMixture";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDeliveryMethod")
private IDeliveryMethod deliveryMethod;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasDosage")
private IDosage dosage;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public FluanisoneMidazolamMixture(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public FluanisoneMidazolamMixture(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				FluanisoneMidazolamMixture.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public FluanisoneMidazolamMixture(FluanisoneMidazolamMixture fluanisoneMidazolamMixture)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = fluanisoneMidazolamMixture.individual;
this.investigationRestriction = fluanisoneMidazolamMixture.investigationRestriction;
this.characterOffset = fluanisoneMidazolamMixture.getCharacterOffset();
this.characterOnset = fluanisoneMidazolamMixture.getCharacterOnset();
if(fluanisoneMidazolamMixture.getDeliveryMethod()!=null)this.deliveryMethod = (IDeliveryMethod) IOBIEThing.getCloneConstructor(fluanisoneMidazolamMixture.getDeliveryMethod().getClass())	.newInstance(fluanisoneMidazolamMixture.getDeliveryMethod());
if(fluanisoneMidazolamMixture.getDosage()!=null)this.dosage = new Dosage((Dosage)fluanisoneMidazolamMixture.getDosage());
this.textMention = fluanisoneMidazolamMixture.getTextMention();
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
FluanisoneMidazolamMixture other = (FluanisoneMidazolamMixture) obj;
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
if (dosage == null) {
if (other.dosage!= null)
return false;
} else if (!dosage.equals(other.dosage))
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
	public IOBIEThing getThis(){
		return this;}
	/***/
@Override
	public int hashCode(){
		final int prime = 31;
int result = 1;
result = prime * result + ((this.individual == null) ? 0 : this.individual.hashCode());
result = prime * result + ((this.investigationRestriction == null) ? 0 : this.investigationRestriction.hashCode());
result = prime * result + ((this.dosage == null) ? 0 : this.dosage.hashCode());
result = prime * result + ((this.deliveryMethod == null) ? 0 : this.deliveryMethod.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
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
	public FluanisoneMidazolamMixture setDeliveryMethod(IDeliveryMethod deliveryMethod){
		this.deliveryMethod = deliveryMethod;
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
	public FluanisoneMidazolamMixture setDosage(IDosage dosage){
		this.dosage = dosage;
return this;}


@Override
public String toString(){
return "FluanisoneMidazolamMixture [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",deliveryMethod="+deliveryMethod+",dosage="+dosage+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
