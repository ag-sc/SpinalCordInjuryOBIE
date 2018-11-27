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
<p>injury device
<p>
<p><b>scio:visualizationContainer</b>
<p>Injury_Device_Group
<p>
<p><b>rdfs:description</b>
<p>Injury Device is an apparatus or instrument used for injury of the spinal cord in an experimental study.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IMASCISImpactor.class, IInfiniteHorizonImpactor.class, IAneurysmClip.class, IScissors.class, IEpiduralClip.class, IBlade.class, IFogartyBalloonCatheter.class, IDistractorDevices.class, IAllenWeightDropDevice.class, IForceps.class, IIrisClip.class, INYUImpactor.class, IOSUImpactor.class, IWeightDrop.class, IUnivOfTriesteImpactor.class, ICuttingDevice.class, IBalloon.class, IClip.class, })

@ImplementationClass(get=InjuryDevice.class)
 public interface IInjuryDevice
 extends ISCIOThing{

}
