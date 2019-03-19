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
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=Xylazine
<p>
<p><b>scio:example</b>
<p>Female Sprague Dawley adult rats (200-220 g; 6-8 weeks of age) were anesthetized with an intraperitoneal injection of 7.5 mg/kg ketamine (Phoenix Pharmaceutical, St. Joseph, MO) and 60 mg/kg xylazine (Phoenix Pharmaceutical).
<p>
<p><b>rdfs:label</b>
<p>xylazine
<p>
<p><b>rdfs:description</b>
<p>Xylazine is an analog of clonidine, an adrenergic alpha-2 agonist used as a sedative, analgesic and centrally acting muscle relaxant in veterinary medicine.

Year introduced: 1991(1975)
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1523/JNEUROSCI.0311-05.2005
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=Xylazine.class)

@AssignableSubInterfaces(get={})
 public interface IXylazine
 extends IAnaesthetic{

}
