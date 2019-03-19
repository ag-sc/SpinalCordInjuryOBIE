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
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=reflex+motor
<p>
<p><b>scio:example</b>
<p>To investigate the reflex response to heat-induced stimulus, tail-flick test was monitored in treated animals up to 16 days after SCI.
The single dose of NNLA (60 mg/kg) applied on the 10th day after SCI or Baclofen therapy reduced nNOS expression in α-motoneurons and suppressed symptoms of increased reflex activity.
<p>
<p><b>rdfs:label</b>
<p>motor reflex test
<p>
<p><b>rdfs:description</b>
<p>Motor Reflex Test is the examination of abdominal reflexes, i.e. contractions of the abdominal muscles upon stimulation of the skin (superficial abdominal reflex) or tapping neighboring bony structures (deep abdominal reflex). The superficial reflex may be weak or absent, for example, after a stroke, a sign of upper (suprasegmental) motor neuron lesions. (Stedman, 25th ed and Best and Taylor's Physiological Basis of Medical Practice, 12th ed, p1073)
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.spinee.2014.08.013
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={IContactPlacingResponseTest.class, ISurfaceRightingReflexTest.class, })

@ImplementationClass(get=MotorReflexTest.class)
 public interface IMotorReflexTest
 extends IFunctionalTest{

}
