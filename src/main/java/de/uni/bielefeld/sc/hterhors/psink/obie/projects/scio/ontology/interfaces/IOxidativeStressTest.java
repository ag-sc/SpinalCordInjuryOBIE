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
<p>http://www.bioassayontology.org/bao#BAO_0002168
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68018384
<p>
<p><b>scio:example</b>
<p>UA is considered a potent peroxinitrite scavenger shown to be neuroprotective during oxidative stress conditions both in vitro and in vivo.
<p>
<p><b>rdfs:label</b>
<p>oxidative stress test
<p>
<p><b>rdfs:description</b>
<p>Oxidative Stress Test is the histological examination of a disturbance in the prooxidant-antioxidant balance in favor of the former, leading to potential damage. Indicators of oxidative stress include damaged DNA bases, protein oxidation products, and lipid peroxidation products (Sies, Oxidative Stress, 1991, pxv-xvi).

Measurement of Malondialdehyde (MDA) or Myeloperoxidase (MPO) activity is a standard test for oxidative stress.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=OxidativeStressTest.class)

@AssignableSubInterfaces(get={})
 public interface IOxidativeStressTest
 extends ISecondaryDegenerationTest{

}
