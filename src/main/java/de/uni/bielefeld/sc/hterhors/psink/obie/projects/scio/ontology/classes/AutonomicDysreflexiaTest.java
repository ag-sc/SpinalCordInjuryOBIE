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
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=autonomic+dysreflexia
<p>
<p><b>scio:example</b>
<p>The maximum voiding pressure and the number of uninhibited contractions were significantly lower in the group treated with intravesical onabotA than in the SCT-only group. Intravesical onabotA significantly blocked the dysreflexia response (high arterial pressure with bradycardia) induced by CMG after SCT.
<p>
<p><b>rdfs:label</b>
<p>autonomic dysreflexia test
<p>
<p><b>rdfs:description</b>
<p>Autonomic Dysreflexia Test is the examination of a syndrome associated with damage to the spinal cord above the mid thoracic level characterized by a marked increase in the sympathetic response to minor stimuli such as bladder or rectal distention.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1111/j.1464-410X.2011.010362.x
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@DirectSiblings(get={BloodBrainBarrierTest.class, GastricUlcerogenesisTest.class, UrineVoidingTest.class, CardioVascularFunctionTest.class, AutonomicDysreflexiaTest.class, InfectionExamination.class, BodyWeightExamination.class, })

@AssignableSubClasses(get={})

@DirectInterface(get=IAutonomicDysreflexiaTest.class)

@SuperRootClasses(get={InvestigationMethod.class, })
 public class AutonomicDysreflexiaTest implements IAutonomicDysreflexiaTest{

final public static IndividualFactory<AutonomicDysreflexiaTestIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = AutonomicDysreflexiaTestIndividual.class;
static class AutonomicDysreflexiaTestIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public AutonomicDysreflexiaTestIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "AutonomicDysreflexiaTestIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<AutonomicDysreflexiaTestIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final AutonomicDysreflexiaTestIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public AutonomicDysreflexiaTest setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/AutonomicDysreflexiaTest";
	private Integer characterOffset;
	private Integer characterOnset;
	@OntologyModelContent(ontologyName="http://psink.de/scio/hasDuration")
@DatatypeProperty
private IDuration duration;
	@OntologyModelContent(ontologyName="http://psink.de/scio/makesUseOf")
@RelationTypeCollection
private List<IApparatus> makesUseOfApparatus = new ArrayList<>();
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@OntologyModelContent(ontologyName="http://psink.de/scio/testsFor")
@RelationTypeCollection
private List<IFunction> testsForFunctions = new ArrayList<>();
	@TextMention
final private String textMention;


	public AutonomicDysreflexiaTest(AutonomicDysreflexiaTest autonomicDysreflexiaTest)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = autonomicDysreflexiaTest.individual;
this.investigationRestriction = autonomicDysreflexiaTest.investigationRestriction;
this.characterOffset = autonomicDysreflexiaTest.getCharacterOffset();
this.characterOnset = autonomicDysreflexiaTest.getCharacterOnset();
if(autonomicDysreflexiaTest.getDuration()!=null)this.duration = new Duration((Duration)autonomicDysreflexiaTest.getDuration());
for (int j = 0; j < autonomicDysreflexiaTest.getMakesUseOfApparatus().size(); j++) {if (autonomicDysreflexiaTest.getMakesUseOfApparatus().get(j) != null) {makesUseOfApparatus.add((IApparatus) IOBIEThing.getCloneConstructor(autonomicDysreflexiaTest.getMakesUseOfApparatus().get(j).getClass()).newInstance(autonomicDysreflexiaTest.getMakesUseOfApparatus().get(j)));} else {makesUseOfApparatus.add(null);}}
for (int j = 0; j < autonomicDysreflexiaTest.getTestsForFunctions().size(); j++) {if (autonomicDysreflexiaTest.getTestsForFunctions().get(j) != null) {testsForFunctions.add((IFunction) IOBIEThing.getCloneConstructor(autonomicDysreflexiaTest.getTestsForFunctions().get(j).getClass()).newInstance(autonomicDysreflexiaTest.getTestsForFunctions().get(j)));} else {testsForFunctions.add(null);}}
this.textMention = autonomicDysreflexiaTest.getTextMention();
}
	public AutonomicDysreflexiaTest(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public AutonomicDysreflexiaTest(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				AutonomicDysreflexiaTest.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}


	/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
@Override
	public AutonomicDysreflexiaTest addMakesUseOfApparatus(IApparatus apparatus){
		this.makesUseOfApparatus.add(apparatus);
return this;}
	/**
<p><b>rdfs:label</b>
<p>tests for
<p>*/
@Override
	public AutonomicDysreflexiaTest addTestsForFunction(IFunction function){
		this.testsForFunctions.add(function);
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
AutonomicDysreflexiaTest other = (AutonomicDysreflexiaTest) obj;
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
if (testsForFunctions == null) {
if (other.testsForFunctions!= null)
return false;
} else if (!testsForFunctions.equals(other.testsForFunctions))
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
	/**
<p><b>rdfs:label</b>
<p>tests for
<p>*/
@Override
	public List<IFunction> getTestsForFunctions(){
		return testsForFunctions;}
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
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
result = prime * result + ((this.makesUseOfApparatus == null) ? 0 : this.makesUseOfApparatus.hashCode());
result = prime * result + ((this.testsForFunctions == null) ? 0 : this.testsForFunctions.hashCode());
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
	public AutonomicDysreflexiaTest setDuration(IDuration duration){
		this.duration = duration;
return this;}
	/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
@Override
	public AutonomicDysreflexiaTest setMakesUseOfApparatus(List<IApparatus> apparatus){
		if(apparatus==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.makesUseOfApparatus = apparatus;
return this;}
	/**
<p><b>rdfs:label</b>
<p>tests for
<p>*/
@Override
	public AutonomicDysreflexiaTest setTestsForFunctions(List<IFunction> functions){
		if(functions==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.testsForFunctions = functions;
return this;}


@Override
public String toString(){
return "AutonomicDysreflexiaTest [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",duration="+duration+",makesUseOfApparatus="+makesUseOfApparatus+",serialVersionUID="+serialVersionUID+",testsForFunctions="+testsForFunctions+",textMention="+textMention+"]";}


}
