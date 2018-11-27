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
<p><b>scio:descriptionSource</b>
<p>https://en.wikipedia.org/wiki/Fulvestrant
<p>
<p><b>rdfs:label</b>
<p>ici182780
<p>
<p><b>rdfs:description</b>
<p>ICI 182780 or fulvestrant, sold under the trade name Faslodex among others, is a medication used to treat hormone receptor (HR)-positive metastatic breast cancer in postmenopausal women with disease progression as well as HR-positive, HER2-negative advanced breast cancer in combination with palbociclib in women with disease progression after endocrine therapy. It is given by injection into a muscle.

Fulvestrant is a selective estrogen receptor degrader (SERD) and was first-in-class to be approved. It works by binding to the estrogen receptor and destabilizing it, causing the cell's normal protein degradation processes to destroy it.

Fulvestrant was approved for medical use in the United States in 2002.
(Wikipedia)
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=ICI182780.class)

@AssignableSubInterfaces(get={})
 public interface IICI182780
 extends ISubstance{

}
