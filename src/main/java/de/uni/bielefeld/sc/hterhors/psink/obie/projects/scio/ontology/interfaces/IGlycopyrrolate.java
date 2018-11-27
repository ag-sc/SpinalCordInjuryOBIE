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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/22168005
<p>
<p><b>scio:example</b>
<p>Rats were premedicated with an anti-cholinergic drug, glycopyrrolate
(0.03 mg/ml, s.c.; Sabex) and a mixture of medetomidine hydrochloride (0.3
mg/kg, i.p.; Damitor; Novartis Animal Health) and buprenorphine (0.05 mg/kg, i.p.; Buprenex; Reckitt Benckiser Pharmaceuticals).
<p>
<p><b>rdfs:label</b>
<p>glycopyrrolate
<p>
<p><b>rdfs:description</b>
<p>Glycopyrrolate is a synthetic anticholinergic used as an antispasmodic, decreases tracheal and bronchial secretions.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1523/JNEUROSCI.2908-11.2012
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=Glycopyrrolate.class)
 public interface IGlycopyrrolate
 extends IMedicationDuringSurgery{

}
