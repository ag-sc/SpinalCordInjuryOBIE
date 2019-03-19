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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/260672003
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C42677
<p>
<p><b>rdfs:label</b>
<p>direction
<p>
<p><b>rdfs:description</b>
<p>Direction is the spatial relation between something and the course along which it points or moves.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={IRight.class, ICaudal.class, ILeft.class, IRostral.class, })

@ImplementationClass(get=Direction.class)
 public interface IDirection
 extends ISpatialDimensions{

/**
<p><b>rdfs:label</b>
<p>relative to
<p>*/
	public ILocation getRelativeToLocation();


/**
<p><b>rdfs:label</b>
<p>relative to
<p>*/
	public IDirection setRelativeToLocation(ILocation relativeToLocation);


}
