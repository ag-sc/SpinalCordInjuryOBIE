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
<p>vertebral area
<p>
<p><b>rdfs:description</b>
<p>Vertebral Area is a spatial location which spans from a higher vertebral bone to a lower vertebral bone. It can comprise vertebrae from different segments, e.g. T10 to L2.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=VertebralArea.class)

@AssignableSubInterfaces(get={})
 public interface IVertebralArea
 extends IVertebralLocation{

/**
<p><b>rdfs:label</b>
<p>has lower vertebrae
<p>*/
	public IVertebrae getLowerVertebrae();


/**
<p><b>rdfs:label</b>
<p>has upper vertebrae
<p>*/
	public IVertebrae getUpperVertebrae();


/**
<p><b>rdfs:label</b>
<p>has lower vertebrae
<p>*/
	public IVertebralArea setLowerVertebrae(IVertebrae lowerVertebrae);


/**
<p><b>rdfs:label</b>
<p>has upper vertebrae
<p>*/
	public IVertebralArea setUpperVertebrae(IVertebrae upperVertebrae);


}
