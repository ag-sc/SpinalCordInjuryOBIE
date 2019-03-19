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
<p><b>skos:closeMatch</b>
<p>http://purl.org/sig/ont/fma/fma50707
<p>
<p><b>scio:example</b>
<p>The spinal cord was prepared for tissue evaluation in week 8.
<p>
<p><b>rdfs:label</b>
<p>anatomical location
<p>
<p><b>rdfs:description</b>
<p>Anatomical Location is the region in the body where something can be found, applied, a test is conducted or tissue is taken from.
<p>
<p><b>scio:exampleSource</b>
<p>DOI: 10.1186/s13287-016-0295-2
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={ISpinalLesionSite.class, IExtremity.class, ISpinalDorsalHalf.class, ISpinalWhiteMatter.class, IEpidural.class, IBrain.class, IIntraspinal.class, IDorsalColumn.class, ICorticospinalTract.class, IAscendingFiberTract.class, ISpinalFiberTract.class, ISpinalCord.class, ISpinalGrayMatter.class, ICentralNervousSystem.class, IRubrospinalTract.class, ISpinalSubduralArea.class, ISpinalCentralPart.class, ISpinalVentralHalf.class, ILesionAdjacentTissue.class, IIntrathecal.class, })

@ImplementationClass(get=AnatomicalLocation.class)
 public interface IAnatomicalLocation
 extends ILocation{

/**
<p><b>rdfs:label</b>
<p>has depth
<p>
<p><b>rdfs:comment</b>
<p>Depth is the distance from the dorsal surface of the spinal cord in ventral direction if a substance is injected locally (or a implant is placed).

Some treatment paradigms consist of multiple injections at different depths in the spinal cord. These single injections are not considered single treatments. In order to model these the object property \"hasCompositeCompound\" is used where multiple application protocols with the same substance can be merged to a \"composite compound\" treatment.
<p>*/
	public IDepth getDepth();


/**
<p><b>scio:example</b>
<p>The intact T10 spinal cord was contused with the NYU weight-drop device (from a height of 50 mm).
<p>
<p><b>rdfs:label</b>
<p>has distance
<p>
<p><b>rdfs:comment</b>
<p>Distance describes the physical distance of a weight in a weight drop device with respect to the spinal cord surface and also - in the context of a treatment locus - the distance of the application points in relation to a reference point. Thid can be e.g. 1 mm dorsal from the lesion epicenter. 

Some treatment paradigms consist of multiple injections at different locations in the spinal cord. These single injections are not considered single treatments. In order to model these the object property \"hasCompositeCompound\" is used where multiple application protocols with the same substance can be merged to a \"composite compound\" treatment.
<p>
<p><b>rdfs:description</b>
<p>Measure of spatial distance in µm, mm, cm or other units.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1111/cns.12429
<p>*/
	public IDistance getDistance();


/**
<p><b>rdfs:label</b>
<p>has depth
<p>
<p><b>rdfs:comment</b>
<p>Depth is the distance from the dorsal surface of the spinal cord in ventral direction if a substance is injected locally (or a implant is placed).

Some treatment paradigms consist of multiple injections at different depths in the spinal cord. These single injections are not considered single treatments. In order to model these the object property \"hasCompositeCompound\" is used where multiple application protocols with the same substance can be merged to a \"composite compound\" treatment.
<p>*/
	public IAnatomicalLocation setDepth(IDepth depth);


/**
<p><b>scio:example</b>
<p>The intact T10 spinal cord was contused with the NYU weight-drop device (from a height of 50 mm).
<p>
<p><b>rdfs:label</b>
<p>has distance
<p>
<p><b>rdfs:comment</b>
<p>Distance describes the physical distance of a weight in a weight drop device with respect to the spinal cord surface and also - in the context of a treatment locus - the distance of the application points in relation to a reference point. Thid can be e.g. 1 mm dorsal from the lesion epicenter. 

Some treatment paradigms consist of multiple injections at different locations in the spinal cord. These single injections are not considered single treatments. In order to model these the object property \"hasCompositeCompound\" is used where multiple application protocols with the same substance can be merged to a \"composite compound\" treatment.
<p>
<p><b>rdfs:description</b>
<p>Measure of spatial distance in µm, mm, cm or other units.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1111/cns.12429
<p>*/
	public IAnatomicalLocation setDistance(IDistance distance);


}
