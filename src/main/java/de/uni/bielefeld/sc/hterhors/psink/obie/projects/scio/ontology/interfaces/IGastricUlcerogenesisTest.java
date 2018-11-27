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
<p>https://www.ncbi.nlm.nih.gov/mesh/68014456
<p>
<p><b>scio:example</b>
<p>We used cervical spinal cord transection (CCT) in the rat to model these ulcers and examined the effect of core body temperature and vascular volume on gastric ulcerogenesis.
<p>
<p><b>rdfs:label</b>
<p>gastric ulcerogenesis test
<p>
<p><b>rdfs:description</b>
<p>Gastric Ulcerogenesis Test is the observation of the formation of ulcers in the stomach. Ulcer is a lesion on the surface of the skin or a mucous surface, produced by the sloughing of inflammatory necrotic tissue.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 16240212
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=GastricUlcerogenesisTest.class)

@AssignableSubInterfaces(get={})
 public interface IGastricUlcerogenesisTest
 extends IPhysiologyTest{

}
