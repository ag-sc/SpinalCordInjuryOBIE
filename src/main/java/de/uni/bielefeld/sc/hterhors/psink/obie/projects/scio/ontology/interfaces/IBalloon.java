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
<p><b>rdfs:label</b>
<p>balloon
<p>
<p><b>rdfs:description</b>
<p>Balloon is an injury device inserted into the epidural space and inflated by saline or air to cause a graded spinal cord injury without damaging surrounding tissue.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=Balloon.class)

@AssignableSubInterfaces(get={IFogartyBalloonCatheter.class, })
 public interface IBalloon
 extends IInjuryDevice{

/**
<p><b>scio:example</b>
<p>In order to induce SCI, a standard weight-drop method that induced a moderately severe injury (100 g/cm force) at T10 was used.
<p>
<p><b>rdfs:label</b>
<p>has force
<p>
<p><b>rdfs:description</b>
<p>Pertains to the force of e.g. a clip device or an impactor for spinal cord injury or a measured force in a behavioural test.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.jss.2013.02.016
<p>*/
	public IForce getForce();


/**
<p><b>rdfs:label</b>
<p>has pressure
<p>*/
	public IPressure getPressure();


/**
<p><b>rdfs:label</b>
<p>has volume
<p>*/
	public IVolume getVolume();


/**
<p><b>scio:example</b>
<p>In order to induce SCI, a standard weight-drop method that induced a moderately severe injury (100 g/cm force) at T10 was used.
<p>
<p><b>rdfs:label</b>
<p>has force
<p>
<p><b>rdfs:description</b>
<p>Pertains to the force of e.g. a clip device or an impactor for spinal cord injury or a measured force in a behavioural test.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.jss.2013.02.016
<p>*/
	public IBalloon setForce(IForce force);


/**
<p><b>rdfs:label</b>
<p>has pressure
<p>*/
	public IBalloon setPressure(IPressure pressure);


/**
<p><b>rdfs:label</b>
<p>has volume
<p>*/
	public IBalloon setVolume(IVolume volume);


}
