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
<p>Half of the spinal cord (left side) was then transected at thoracic position (T) 10 with a razor blade.
<p>
<p><b>rdfs:label</b>
<p>blade
<p>
<p><b>rdfs:description</b>
<p>Blade is a class of sharp cutting instruments like razor blades, scalpels etc.
<p>
<p><b>scio:exampleSource</b>
<p>doi:  10.3390/ijms131013484
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=Blade.class)
 public interface IBlade
 extends ICuttingDevice{

/**
<p><b>rdfs:label</b>
<p>has longitude
<p>
<p><b>rdfs:comment</b>
<p>The physical dimension of a blade as an injury device.
<p>*/
	public ILength getLongitudeLength();


/**
<p><b>rdfs:label</b>
<p>has thickness
<p>*/
	public IThickness getThickness();


/**
<p><b>rdfs:label</b>
<p>has longitude
<p>
<p><b>rdfs:comment</b>
<p>The physical dimension of a blade as an injury device.
<p>*/
	public IBlade setLongitudeLength(ILength longitudeLength);


/**
<p><b>rdfs:label</b>
<p>has thickness
<p>*/
	public IBlade setThickness(IThickness thickness);


}
