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
<p>doi:10.1016/j.surneu.2007.05.056
<p>
<p><b>scio:example</b>
<p>Of these, the TFR in response to tail pinch was present in 16 (41%) cases.
<p>
<p><b>rdfs:label</b>
<p>tail flick reflex test
<p>
<p><b>rdfs:description</b>
<p>Tail Flick Reflex Test or TFR in rats is a classic nociceptive test originally described by D'Amour and Smith, in which pinching of the tail or hind leg produces a withdrawal response. The TFR is a general flexor withdrawal reflex that functions in intact as well as in decerebrated rats.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.surneu.2007.05.056
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@DirectInterface(get=ITailFlickReflexTest.class)

@DirectSiblings(get={AvoidanceResponseTest.class, MechanicalAllodyniaTest.class, ThermalHyperalgesiaTest.class, TailFlickReflexTest.class, })

@AssignableSubClasses(get={})

@SuperRootClasses(get={InvestigationMethod.class, })
 public class TailFlickReflexTest implements ITailFlickReflexTest{

final public static IndividualFactory<TailFlickReflexTestIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = TailFlickReflexTestIndividual.class;
static class TailFlickReflexTestIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public TailFlickReflexTestIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "TailFlickReflexTestIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<TailFlickReflexTestIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final TailFlickReflexTestIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public TailFlickReflexTest setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/TailFlickReflexTest";
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


	public TailFlickReflexTest(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}
	public TailFlickReflexTest(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				TailFlickReflexTest.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public TailFlickReflexTest(TailFlickReflexTest tailFlickReflexTest)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = tailFlickReflexTest.individual;
this.investigationRestriction = tailFlickReflexTest.investigationRestriction;
this.characterOffset = tailFlickReflexTest.getCharacterOffset();
this.characterOnset = tailFlickReflexTest.getCharacterOnset();
if(tailFlickReflexTest.getDuration()!=null)this.duration = new Duration((Duration)tailFlickReflexTest.getDuration());
for (int j = 0; j < tailFlickReflexTest.getMakesUseOfApparatus().size(); j++) {if (tailFlickReflexTest.getMakesUseOfApparatus().get(j) != null) {makesUseOfApparatus.add((IApparatus) IOBIEThing.getCloneConstructor(tailFlickReflexTest.getMakesUseOfApparatus().get(j).getClass()).newInstance(tailFlickReflexTest.getMakesUseOfApparatus().get(j)));} else {makesUseOfApparatus.add(null);}}
for (int j = 0; j < tailFlickReflexTest.getTestsForFunctions().size(); j++) {if (tailFlickReflexTest.getTestsForFunctions().get(j) != null) {testsForFunctions.add((IFunction) IOBIEThing.getCloneConstructor(tailFlickReflexTest.getTestsForFunctions().get(j).getClass()).newInstance(tailFlickReflexTest.getTestsForFunctions().get(j)));} else {testsForFunctions.add(null);}}
this.textMention = tailFlickReflexTest.getTextMention();
}


	/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
@Override
	public TailFlickReflexTest addMakesUseOfApparatus(IApparatus apparatus){
		this.makesUseOfApparatus.add(apparatus);
return this;}
	/**
<p><b>rdfs:label</b>
<p>tests for
<p>*/
@Override
	public TailFlickReflexTest addTestsForFunction(IFunction function){
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
TailFlickReflexTest other = (TailFlickReflexTest) obj;
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
	public TailFlickReflexTest setDuration(IDuration duration){
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
	public TailFlickReflexTest setMakesUseOfApparatus(List<IApparatus> apparatus){
		if(apparatus==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.makesUseOfApparatus = apparatus;
return this;}
	/**
<p><b>rdfs:label</b>
<p>tests for
<p>*/
@Override
	public TailFlickReflexTest setTestsForFunctions(List<IFunction> functions){
		if(functions==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.testsForFunctions = functions;
return this;}


@Override
public String toString(){
return "TailFlickReflexTest [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",duration="+duration+",makesUseOfApparatus="+makesUseOfApparatus+",serialVersionUID="+serialVersionUID+",testsForFunctions="+testsForFunctions+",textMention="+textMention+"]";}


}
