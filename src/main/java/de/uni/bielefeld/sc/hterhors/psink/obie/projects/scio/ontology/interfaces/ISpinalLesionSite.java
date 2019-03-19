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
<p>http://regenbase.org/ontology#RB_0008005
<p>
<p><b>scio:example</b>
<p>However, AST applied immediately after lesion enhanced the density of axon proﬁles in the resulting secondary ﬁbrous scar region (Fig. 2D–H) for all axon populations analysed (Fig. 3A and B)
<p>
<p><b>rdfs:label</b>
<p>spinal lesion site
<p>
<p><b>rdfs:description</b>
<p>Spinal Lesion Site is the tissue from the spinal cord injury lesion core (possibly including adjacent tissue).
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1111/j.1460-9568.2009.06929.x
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=SpinalLesionSite.class)

@AssignableSubInterfaces(get={})
 public interface ISpinalLesionSite
 extends IIntraspinal{

}
