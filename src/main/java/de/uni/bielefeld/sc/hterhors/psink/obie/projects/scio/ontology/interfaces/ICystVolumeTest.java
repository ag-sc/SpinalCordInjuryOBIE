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
<p>http://purl.bioontology.org/ontology/LNC/LA24683-7
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68003560
<p>
<p><b>scio:example</b>
<p>After nanoparticle delivery twice into each rat, the visualized syringomyelic cyst volume significantly decreased from 5.71±0.21 mm3 to 3.23±0.364 mm3 and to 1.48±0.722 mm3.
<p>
<p><b>rdfs:label</b>
<p>cyst volume test
<p>
<p><b>rdfs:description</b>
<p>Cyst Volume Test is the histological examination of any fluid-filled closed cavity or sac that are lined by an EPITHELIUM in the spinal cord. Cysts can be of normal, abnormal, non-neoplastic, or neoplastic tissues.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26486048
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=CystVolumeTest.class)
 public interface ICystVolumeTest
 extends ILesionVolumeTest{

}
