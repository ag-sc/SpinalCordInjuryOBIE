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
<p>The spinal cord was injured by cord compression with a 24 g modified aneurysm clip for 1 min, resulting in a moderate SCI.
<p>
<p><b>rdfs:label</b>
<p>aneurysm clip
<p>
<p><b>rdfs:description</b>
<p>Aneurysm clip is a surgical instrument used to treat a balloon-like bulge of an artery wall known as an aneurysm. In experimental spinal cord injury studies these clips are used to inflict compression lesions to the spinal cord.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.biomaterials.2015.12.032
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=AneurysmClip.class)

@AssignableSubInterfaces(get={})
 public interface IAneurysmClip
 extends IClip{

}
