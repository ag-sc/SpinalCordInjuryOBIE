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
<p>http://regenbase.org/ontology#RB_0008021
<p>
<p><b>scio:example</b>
<p>Cortical and subcortical lesions impair skilled walking in the ladder rung walking test: a new task to evaluate fore- and hindlimb stepping, placing, and co-ordination.
<p>
<p><b>rdfs:label</b>
<p>ladder rung test
<p>
<p><b>rdfs:comment</b>
<p>or \"GridWalk\"
<p>
<p><b>rdfs:description</b>
<p>Ladder Rung Test is an examination procedure where the animals walk over a horizontal ladder and missteps are counted and/or rated.
Tests for fore- and hindlimb stepping, fine motor control, foot placing accuracy, 
sensory motor coordination .
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
<p><b>scio:exampleSource</b>
<p>PMID 11992668
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubClasses(get={})

@DirectSiblings(get={LadderRungTest.class, FootprintAnalysisTest.class, SwimmingTest.class, WalkingAnalysisTest.class, })

@SuperRootClasses(get={InvestigationMethod.class, })

@DirectInterface(get=ILadderRungTest.class)
 public class LadderRungTest implements ILadderRungTest{

final public static IndividualFactory<LadderRungTestIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = LadderRungTestIndividual.class;
static class LadderRungTestIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public LadderRungTestIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "LadderRungTestIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<LadderRungTestIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final LadderRungTestIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}
	@Override
	public InvestigationRestriction getInvestigationRestriction() {
		return investigationRestriction;
	}
	@Override
	public LadderRungTest setInvestigationRestriction(InvestigationRestriction investigationRestriction ) {
		this.investigationRestriction = investigationRestriction;
 return this;	}public InvestigationRestriction investigationRestriction;	final static public String ONTOLOGY_NAME = "http://psink.de/scio/LadderRungTest";
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


	public LadderRungTest(String individualURI, InvestigationRestriction investigationRestriction, String textMention){
this.individual = 
				LadderRungTest.individualFactory.getIndividualByURI(individualURI);
this.investigationRestriction = investigationRestriction==null?InvestigationRestriction.noRestrictionInstance:investigationRestriction;
this.textMention = textMention;
}
	public LadderRungTest(LadderRungTest ladderRungTest)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = ladderRungTest.individual;
this.investigationRestriction = ladderRungTest.investigationRestriction;
this.characterOffset = ladderRungTest.getCharacterOffset();
this.characterOnset = ladderRungTest.getCharacterOnset();
if(ladderRungTest.getDuration()!=null)this.duration = new Duration((Duration)ladderRungTest.getDuration());
for (int j = 0; j < ladderRungTest.getMakesUseOfApparatus().size(); j++) {if (ladderRungTest.getMakesUseOfApparatus().get(j) != null) {makesUseOfApparatus.add((IApparatus) IOBIEThing.getCloneConstructor(ladderRungTest.getMakesUseOfApparatus().get(j).getClass()).newInstance(ladderRungTest.getMakesUseOfApparatus().get(j)));} else {makesUseOfApparatus.add(null);}}
for (int j = 0; j < ladderRungTest.getTestsForFunctions().size(); j++) {if (ladderRungTest.getTestsForFunctions().get(j) != null) {testsForFunctions.add((IFunction) IOBIEThing.getCloneConstructor(ladderRungTest.getTestsForFunctions().get(j).getClass()).newInstance(ladderRungTest.getTestsForFunctions().get(j)));} else {testsForFunctions.add(null);}}
this.textMention = ladderRungTest.getTextMention();
}
	public LadderRungTest(){
this.individual = null;
this.investigationRestriction = InvestigationRestriction.noRestrictionInstance;
this.textMention = null;
}


	/**
<p><b>rdfs:label</b>
<p>makes use of
<p>
<p><b>rdfs:description</b>
<p>This property relates the investigation method to the experimental apparatus used.
<p>*/
@Override
	public LadderRungTest addMakesUseOfApparatus(IApparatus apparatus){
		this.makesUseOfApparatus.add(apparatus);
return this;}
	/**
<p><b>rdfs:label</b>
<p>tests for
<p>*/
@Override
	public LadderRungTest addTestsForFunction(IFunction function){
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
LadderRungTest other = (LadderRungTest) obj;
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
	public LadderRungTest setDuration(IDuration duration){
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
	public LadderRungTest setMakesUseOfApparatus(List<IApparatus> apparatus){
		if(apparatus==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.makesUseOfApparatus = apparatus;
return this;}
	/**
<p><b>rdfs:label</b>
<p>tests for
<p>*/
@Override
	public LadderRungTest setTestsForFunctions(List<IFunction> functions){
		if(functions==null){throw new IllegalArgumentException("Can not set list objects to null.");}this.testsForFunctions = functions;
return this;}


@Override
public String toString(){
return "LadderRungTest [individual="+individual+",investigationRestriction="+investigationRestriction.summarize()+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",duration="+duration+",makesUseOfApparatus="+makesUseOfApparatus+",serialVersionUID="+serialVersionUID+",testsForFunctions="+testsForFunctions+",textMention="+textMention+"]";}


}
