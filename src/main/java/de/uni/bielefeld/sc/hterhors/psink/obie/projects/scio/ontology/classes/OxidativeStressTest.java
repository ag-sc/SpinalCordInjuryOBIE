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
<p>http://www.bioassayontology.org/bao#BAO_0002168
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68018384
<p>
<p><b>scio:example</b>
<p>UA is considered a potent peroxinitrite scavenger shown to be neuroprotective during oxidative stress conditions both in vitro and in vivo.
<p>
<p><b>rdfs:label</b>
<p>oxidative stress test
<p>
<p><b>rdfs:description</b>
<p>Oxidative Stress Test is the histological examination of a disturbance in the prooxidant-antioxidant balance in favor of the former, leading to potential damage. Indicators of oxidative stress include damaged DNA bases, protein oxidation products, and lipid peroxidation products (Sies, Oxidative Stress, 1991, pxv-xvi).

Measurement of Malondialdehyde (MDA) or Myeloperoxidase (MPO) activity is a standard test for oxidative stress.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@DirectSiblings(get={HemorrhageTest.class, ApoptosisTest.class, OxidativeStressTest.class, LesionVolumeTest.class, TissueSparingTest.class, ToxicityTest.class, })

@DirectInterface(get=IOxidativeStressTest.class)

@AssignableSubClasses(get={})

@SuperRootClasses(get={InvestigationMethod.class, })
 public class OxidativeStressTest implements IOxidativeStressTest{

final public static IndividualFactory<OxidativeStressTestIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = OxidativeStressTestIndividual.class;
static class OxidativeStressTestIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public OxidativeStressTestIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "OxidativeStressTestIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<OxidativeStressTestIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final OxidativeStressTestIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public OxidativeStressTest setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/OxidativeStressTest";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasLocation")
@RelationTypeCollection
private List<ILocation> locations = new ArrayList<>();
	@OntologyModelContent(ontologyName="http://psink.de/scio/makesUseOf")
@RelationTypeCollection
private List<IApparatus> makesUseOfApparatus = new ArrayList<>();
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public OxidativeStressTest(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public OxidativeStressTest(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				OxidativeStressTest.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public OxidativeStressTest(OxidativeStressTest oxidativeStressTest)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = oxidativeStressTest.individual;
this.investigationRestriction = oxidativeStressTest.investigationRestriction;
this.characterOffset = oxidativeStressTest.getCharacterOffset();
this.characterOnset = oxidativeStressTest.getCharacterOnset();
for (int j = 0; j < oxidativeStressTest.getLocations().size(); j++) {if (oxidativeStressTest.getLocations().get(j) != null) {locations.add((ILocation) IOBIEThing.getCloneConstructor(oxidativeStressTest.getLocations().get(j).getClass()).newInstance(oxidativeStressTest.getLocations().get(j)));} else {locations.add(null);}}
for (int j = 0; j < oxidativeStressTest.getMakesUseOfApparatus().size(); j++) {if (oxidativeStressTest.getMakesUseOfApparatus().get(j) != null) {makesUseOfApparatus.add((IApparatus) IOBIEThing.getCloneConstructor(oxidativeStressTest.getMakesUseOfApparatus().get(j).getClass()).newInstance(oxidativeStressTest.getMakesUseOfApparatus().get(j)));} else {makesUseOfApparatus.add(null);}}
this.textMention = oxidativeStressTest.getTextMention();
}


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
	public OxidativeStressTest addLocation(ILocation location){
		this.locations.add(location);
return this;}
	/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
@Override
	public OxidativeStressTest addMakesUseOfApparatus(IApparatus apparatus){
		this.makesUseOfApparatus.add(apparatus);
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
OxidativeStressTest other = (OxidativeStressTest) obj;
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
if (makesUseOfApparatus == null) {
if (other.makesUseOfApparatus!= null)
return false;
} else if (!makesUseOfApparatus.equals(other.makesUseOfApparatus))
return false;
if (characterOffset == null) {
if (other.characterOffset!= null)
return false;
} else if (!characterOffset.equals(other.characterOffset))
return false;
if (locations == null) {
if (other.locations!= null)
return false;
} else if (!locations.equals(other.locations))
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
	public List<ILocation> getLocations(){
		return locations;}
	/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
@Override
	public List<IApparatus> getMakesUseOfApparatus(){
		return makesUseOfApparatus;}
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
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.makesUseOfApparatus == null) ? 0 : this.makesUseOfApparatus.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.locations == null) ? 0 : this.locations.hashCode());
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
	public OxidativeStressTest setLocations(List<ILocation> locations){
		if(locations==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.locations = locations;
return this;}
	/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
@Override
	public OxidativeStressTest setMakesUseOfApparatus(List<IApparatus> apparatus){
		if(apparatus==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.makesUseOfApparatus = apparatus;
return this;}


@Override
public String toString(){
return "OxidativeStressTest [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",locations="+locations+",makesUseOfApparatus="+makesUseOfApparatus+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
