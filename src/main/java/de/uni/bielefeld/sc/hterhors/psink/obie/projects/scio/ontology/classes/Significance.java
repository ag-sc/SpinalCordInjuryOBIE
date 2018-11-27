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
<p><b>skos:closeMatch</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C61040
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C61040
<p>
<p><b>scio:example</b>
<p>We also observed the trend of augmented CST axons at a lower level of transverse spinal cord sections 11–15 mm distal to SCI in the ibuprofen-treated rats, although the difference between ibuprofen and control groups did not reach statistical significance (P<0.05).
<p>
<p><b>rdfs:label</b>
<p>significance
<p>
<p><b>scio:visualizationContainer</b>
<p>Result_Group
<p>
<p><b>rdfs:description</b>
<p>Significance is a concept in statistics, a number that expresses the probability that the result of a given experiment or study could have occurred purely by chance. This number can be a margin of error or it can indicate a confidence level.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@DirectSiblings(get={})

@DirectInterface(get=ISignificance.class)

@AssignableSubClasses(get={ZeroSignificance.class, PositiveSignificance.class, })

@SuperRootClasses(get={Significance.class, })
 public class Significance implements ISignificance{

final public static IndividualFactory<SignificanceIndividual> individualFactory = new IndividualFactory<>();
final public static Class<? extends AbstractIndividual> individualClassType = SignificanceIndividual.class;
static class SignificanceIndividual extends AbstractIndividual {

	private static final long serialVersionUID = 1L;		public SignificanceIndividual(String namespace, String name) {
			super(namespace, name);
		}

		@Override
		public String toString() {
			return "SignificanceIndividual [name=" + name + ", nameSpace=" + nameSpace + "]";
		}

	}
	public IndividualFactory<SignificanceIndividual> getIndividualFactory() {
		return individualFactory;
	}

	public final SignificanceIndividual individual;
	@Override
	public AbstractIndividual getIndividual() {
		return individual;
	}	final static public String ONTOLOGY_NAME = "http://psink.de/scio/Significance";
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


	public Significance(Significance significance)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException{
this.individual = significance.individual;
if(significance.getAlphaSignificanceNiveau()!=null)this.alphaSignificanceNiveau = new AlphaSignificanceNiveau((AlphaSignificanceNiveau)significance.getAlphaSignificanceNiveau());
this.characterOffset = significance.getCharacterOffset();
this.characterOnset = significance.getCharacterOnset();
if(significance.getPValue()!=null)this.pValue = new PValue((PValue)significance.getPValue());
this.textMention = significance.getTextMention();
}
	public Significance(){
this.individual = null;
this.textMention = null;
}
	public Significance(String individualURI, String textMention){
this.individual = 
				Significance.individualFactory.getIndividualByURI(individualURI);
this.textMention = textMention;
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
Significance other = (Significance) obj;
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
	public Significance setAlphaSignificanceNiveau(IAlphaSignificanceNiveau alphaSignificanceNiveau){
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
	public Significance setPValue(IPValue pValue){
		this.pValue = pValue;
return this;}


@Override
public String toString(){
return "Significance [individual="+individual+",alphaSignificanceNiveau="+alphaSignificanceNiveau+",characterOffset="+characterOffset+",characterOnset="+characterOnset+",pValue="+pValue+",serialVersionUID="+serialVersionUID+",textMention="+textMention+"]";}


}
