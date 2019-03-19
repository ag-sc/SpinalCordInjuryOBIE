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
<p>doi: 10.1038/sc.2014.91
<p>
<p><b>scio:example</b>
<p>With half of the animal's weight suspended, the animal was positioned under the Ohio State University (OSU) Impactor, and the impactor tip was gently lowered to apply a pre-load force of 0.2 kdyn onto the dura.
<p>
<p><b>rdfs:label</b>
<p>osu impactor
<p>
<p><b>rdfs:description</b>
<p>OSU or Ohio State University Impactor is an instrument for accurate and specific weight drop on the exposed spinal cord. The procedure involves laminectomy at the target level and spine stabilization using clamping. Similar to the IH impactor, the OSU device uses a computer feedback-controlled electromagnetic impactor. When triggered, a probe contacts and displaces the cord 30 μm to provide a replicable starting point. Then, the instrument compresses the cord a predetermined distance, generally between 0.8 and 1.1 mm, for a set amount of time, ~4 to 5 ms. The OSU device avoids multiple strikes, as the impounder is actively withdrawn.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.expneurol.2009.11.006
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=OSUImpactor.class)
 public interface IOSUImpactor
 extends IWeightDrop{

}
