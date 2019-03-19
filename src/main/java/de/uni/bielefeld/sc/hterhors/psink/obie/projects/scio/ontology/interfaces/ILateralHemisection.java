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
<p><b>scio:example</b>
<p>Injured animals received a high cervical (C2) lateral hemisection (Hx), which compromises supraspinal input to ipsilateral spinal motoneurons controlling the upper extremities (forelimb) in the adult rat.
<p>
<p><b>rdfs:label</b>
<p>lateral hemisection
<p>
<p><b>rdfs:description</b>
<p>Lateral Hemisection is the partial transection of the lateral aspect of the spinal cord at one side.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1089/neu.2014.3718
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=LateralHemisection.class)
 public interface ILateralHemisection
 extends IPartialTransection{

/**
<p><b>rdfs:label</b>
<p>has direction
<p>*/
	public IDirection getDirection();


/**
<p><b>rdfs:label</b>
<p>has direction
<p>*/
	public ILateralHemisection setDirection(IDirection direction);


}
