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
<p>Massive increases of S100beta and FGF-2 were found in reactive astrocytes, not in reactive microglia, in the border and in the white and gray matters of adjacent preserved tissue of the contused spinal cord in the periods studied.
<p>
<p><b>rdfs:label</b>
<p>lesion adjacent tissue
<p>
<p><b>rdfs:description</b>
<p>Lesion Adjacent Tissue is any tissue of the spinal cord in close vicinity to the spinal cord lesion excluding the spinal cord lesion core.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 17244329
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=LesionAdjacentTissue.class)
 public interface ILesionAdjacentTissue
 extends ISpinalCord{

}
