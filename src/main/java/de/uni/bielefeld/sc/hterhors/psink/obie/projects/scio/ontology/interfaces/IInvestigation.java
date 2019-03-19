package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces;

import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.IndividualFactory;
import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.annotations.AssignableSubInterfaces;
import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.annotations.DirectInterface;
import de.hterhors.obie.core.ontology.annotations.DirectSiblings;
import de.hterhors.obie.core.ontology.annotations.ImplementationClass;
import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.annotations.SuperRootClasses;
import de.hterhors.obie.core.ontology.annotations.TextMention;
import de.hterhors.obie.core.ontology.interfaces.IDatatype;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
/**
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=Investigation.class)

@AssignableSubInterfaces(get={})
 public interface IInvestigation
 extends IEvent{

/**
<p><b>scio:example</b>
<p>For behavioral testing, we used a ‘motor function scale’18 that is a slight modification of the ‘motor score’ of Gale et al.
<p>
<p><b>rdfs:label</b>
<p>has investigation method
<p>
<p><b>rdfs:comment</b>
<p>Property of the result (trend). It points at the \"Investigation Method Type\", which is the laboratory test or experimental method used to investigate the effect of a treatment after spinal cord injury.
<p>*/
	public IInvestigationMethod getInvestigationMethod();


/**
<p><b>scio:example</b>
<p>For behavioral testing, we used a ‘motor function scale’18 that is a slight modification of the ‘motor score’ of Gale et al.
<p>
<p><b>rdfs:label</b>
<p>has investigation method
<p>
<p><b>rdfs:comment</b>
<p>Property of the result (trend). It points at the \"Investigation Method Type\", which is the laboratory test or experimental method used to investigate the effect of a treatment after spinal cord injury.
<p>*/
	public IInvestigation setInvestigationMethod(IInvestigationMethod investigationMethod);


}
