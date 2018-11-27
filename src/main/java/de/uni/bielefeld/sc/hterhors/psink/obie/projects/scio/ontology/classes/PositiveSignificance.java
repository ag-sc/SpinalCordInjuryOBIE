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
<p><b>scio:example</b>
<p>There were significant differences in FA when compared to the SCI/PPy/I vs SCI group (p < 0.05).
<p>
<p><b>rdfs:label</b>
<p>positive significance
<p>
<p><b>rdfs:description</b>
<p>Positive Significance is the test result of a statistical test which confirms that a null hypothesis could be rejected and - if two or more groups were compared - the difference between  these groups is statistically significant, i.e. a certain p value (usually below 0.05) was computed.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.spinee.2016.02.012
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@DirectInterface(get=IPositiveSignificance.class)

@AssignableSubClasses(get={})

@SuperRootClasses(get={Significance.class, })

@DirectSiblings(get={ZeroSignificance.class, PositiveSignificance.class, })
 public class PositiveSignificance implements IPositiveSignificance{

final public static IndividualFactory<PositiveSignificanceIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = PositiveSignificanceIndividual.class;
static class PositiveSignificanceIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public PositiveSignificanceIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "PositiveSignificanceIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<PositiveSignificanceIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final PositiveSignificanceIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/PositiveSignificance";
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasAlphaSignificanceNiveau")
private IAlphaSignificanceNiveau alphaSignificanceNiveau;
	private Integer characterOffset;
	private Integer characterOnset;
	@DatatypeProperty
@OntologyModelContent(ontologyName="http://psink.de/scio/hasPValue")
private IPValue pValue;
	final static private Map<IOBIEThing, String> resourceFactory = new HashMap<>();
	final static private long serialVersionUID = 64L;
	@TextMention
final private String textMention;


	public PositiveSignificance(String individualURI, String textMention){
this.individual = 
				PositiveSignificance.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
}
	public PositiveSignificance(PositiveSignificance positiveSignificance)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = positiveSignificance.individual;
if(positiveSignificance.getAlphaSignificanceNiveau()!=null)this.alphaSignificanceNiveau = new AlphaSignificanceNiveau((AlphaSignificanceNiveau)positiveSignificance.getAlphaSignificanceNiveau());
this.characterOffset = positiveSignificance.getCharacterOffset();
this.characterOnset = positiveSignificance.getCharacterOnset();
if(positiveSignificance.getPValue()!=null)this.pValue = new PValue((PValue)positiveSignificance.getPValue());
this.textMention = positiveSignificance.getTextMention();
}
	public PositiveSignificance(){
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
PositiveSignificance other = (PositiveSignificance) obj;
if (individual == null) {
if (other.individual!= null)
return false;
} else if (!individual.equals(other.individual))
return false;
if (pValue == null) {
if (other.pValue!= null)
return false;
} else if (!pValue.equals(other.pValue))
return false;
if (alphaSignificanceNiveau == null) {
if (other.alphaSignificanceNiveau!= null)
return false;
} else if (!alphaSignificanceNiveau.equals(other.alphaSignificanceNiveau))
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
	/**
<p><b>rdfs:label</b>
<p>has alpha significance  niveau
<p>*/
@Override
	public IAlphaSignificanceNiveau getAlphaSignificanceNiveau(){
		return alphaSignificanceNiveau;}
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
	/**
<p><b>scio:example</b>
<p>Significantly increased numbers of both TH-positive and 5-HT-positive axon profiles were detected in PEG-treated animals compared to TX only-controls (J, mean + SEM, one-sided Mann–Whitney U test; ***p ≤ 0.001).
<p>
<p><b>rdfs:label</b>
<p>has p value
<p>
<p><b>rdfs:comment</b>
<p>Property of the \"significance\" of a result which can be either \"yes\" or \"no\". This property points at the p value which was calculated by the author or the p value range for the statistical significance test, e.g. p<0.05.
<p>
<p><b>rdfs:description</b>
<p>The P value, or calculated probability, is the probability of finding the observed, or more extreme, results when the null hypothesis (H0) of a study question is true – the definition of ‘extreme’ depends on how the hypothesis is being tested. P is also described in terms of rejecting H0 when it is actually true, however, it is not a direct probability of this state.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
@Override
	public IPValue getPValue(){
		return pValue;}
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
result = prime * result + ((this.pValue == null) ? 0 : this.pValue.hashCode());
result = prime * result + ((this.alphaSignificanceNiveau == null) ? 0 : this.alphaSignificanceNiveau.hashCode());
result = prime * result + ((this.textMention == null) ? 0 : this.textMention.hashCode());
result = prime * result + ((this.characterOffset == null) ? 0 : this.characterOffset.hashCode());
result = prime * result + ((this.characterOnset == null) ? 0 : this.characterOnset.hashCode());
return result;}
	/***/
@Override
	public boolean isEmpty(){
		boolean isEmpty = true;
return false;}
	/**
<p><b>rdfs:label</b>
<p>has alpha significance  niveau
<p>*/
@Override
	public PositiveSignificance setAlphaSignificanceNiveau(IAlphaSignificanceNiveau alphaSignificanceNiveau){
		this.alphaSignificanceNiveau = alphaSignificanceNiveau;
return this;}
	/***/
@Override
	public void setCharacterOnset(Integer onset){
		this.characterOnset = onset;
 this.characterOffset = onset + textMention.length();}
	/**
<p><b>scio:example</b>
<p>Significantly increased numbers of both TH-positive and 5-HT-positive axon profiles were detected in PEG-treated animals compared to TX only-controls (J, mean + SEM, one-sided Mann–Whitney U test; ***p ≤ 0.001).
<p>
<p><b>rdfs:label</b>
<p>has p value
<p>
<p><b>rdfs:comment</b>
<p>Property of the \"significance\" of a result which can be either \"yes\" or \"no\". This property points at the p value which was calculated by the author or the p value range for the statistical significance test, e.g. p<0.05.
<p>
<p><b>rdfs:description</b>
<p>The P value, or calculated probability, is the probability of finding the observed, or more extreme, results when the null hypothesis (H0) of a study question is true – the definition of ‘extreme’ depends on how the hypothesis is being tested. P is also described in terms of rejecting H0 when it is actually true, however, it is not a direct probability of this state.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
@Override
	public PositiveSignificance setPValue(IPValue pValue){
		this.pValue = pValue;
return this;}


@Override
public String toString(){
return "PositiveSignificance [individual="+individual+",alphaSignificanceNiveau="+alphaSignificanceNiveau+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",pValue="+pValue+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
