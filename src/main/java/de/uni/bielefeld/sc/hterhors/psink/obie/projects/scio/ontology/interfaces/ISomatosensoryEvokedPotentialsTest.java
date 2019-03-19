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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/102975002
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=somatosensory+evoked+potential
<p>
<p><b>scio:example</b>
<p>Accordingly, the activity of the neuronal populations recorded at specific thalamic locations that correspond to the forepaw and hindpaw circuits was recorded under control conditions and immediately after thoracic SCI. The results demonstrate that peripheral inputs from both extremities overlap on neuronal populations in the somatosensory thalamus.
<p>
<p><b>rdfs:label</b>
<p>somatosensory evoked potentials test
<p>
<p><b>rdfs:description</b>
<p>Somatosensory Evoked Potentials Test or SSEP test is the examination of the electric response evoked in the cerebral cortex by stimulation along afferent pathways from peripheral nerves to cerebrum.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.nbd.2015.12.003
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=SomatosensoryEvokedPotentialsTest.class)
 public interface ISomatosensoryEvokedPotentialsTest
 extends IElectrophysiologyTest{

}
