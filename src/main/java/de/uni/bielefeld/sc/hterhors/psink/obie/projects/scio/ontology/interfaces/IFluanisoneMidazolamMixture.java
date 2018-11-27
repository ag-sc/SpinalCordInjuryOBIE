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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/373492002
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.bioontology.org/ontology/SNOMEDCT/373476007
<p>
<p><b>scio:example</b>
<p>The animals were anesthetized with Dormicum [midazolam, 0.6 mg per 100 gm body weight (bw), i.p.; Roche, Basel, Switzerland] and Hypnorm (fentanyl, 0.02 mg per 100 gm bw, i.p.; Janssen-Cilag, Beerse, Belgium).
<p>
<p><b>rdfs:label</b>
<p>fluanisone midazolam mixture
<p>
<p><b>rdfs:description</b>
<p>Fluanisone Midazolam Mixture is a typical sedative mixture for anaesthesia induction and maintenance containing the two components fluanisone and midazolam.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 11331396
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=FluanisoneMidazolamMixture.class)

@AssignableSubInterfaces(get={})
 public interface IFluanisoneMidazolamMixture
 extends IAnaesthetic{

}
