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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/386205007
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68004594
<p>
<p><b>scio:example</b>
<p>Accordingly, the activity of the neuronal populations recorded at specific thalamic locations that correspond to the forepaw and hindpaw circuits was recorded under control conditions and immediately after thoracic SCI. The results demonstrate that peripheral inputs from both extremities overlap on neuronal populations in the somatosensory thalamus.
<p>
<p><b>rdfs:label</b>
<p>electrophysiology test
<p>
<p><b>rdfs:description</b>
<p>Electrophysiology Test is a test investigating the generation and behavior of electrical charges in living organisms particularly the nervous system and the effects of electricity on living organisms.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26706597
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=ElectrophysiologyTest.class)

@AssignableSubInterfaces(get={ISpinalCordEvokedPotentialsTest.class, IHReflexTest.class, ISomatosensoryEvokedPotentialsTest.class, IMotorEvokedPotentialsTest.class, })
 public interface IElectrophysiologyTest
 extends IFunctionalTest{

}
