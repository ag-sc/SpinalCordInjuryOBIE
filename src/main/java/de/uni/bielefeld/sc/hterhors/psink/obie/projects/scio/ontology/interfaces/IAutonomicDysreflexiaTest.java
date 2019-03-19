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
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=autonomic+dysreflexia
<p>
<p><b>scio:example</b>
<p>The maximum voiding pressure and the number of uninhibited contractions were significantly lower in the group treated with intravesical onabotA than in the SCT-only group. Intravesical onabotA significantly blocked the dysreflexia response (high arterial pressure with bradycardia) induced by CMG after SCT.
<p>
<p><b>rdfs:label</b>
<p>autonomic dysreflexia test
<p>
<p><b>rdfs:description</b>
<p>Autonomic Dysreflexia Test is the examination of a syndrome associated with damage to the spinal cord above the mid thoracic level characterized by a marked increase in the sympathetic response to minor stimuli such as bladder or rectal distention.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1111/j.1464-410X.2011.010362.x
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=AutonomicDysreflexiaTest.class)

@AssignableSubInterfaces(get={})
 public interface IAutonomicDysreflexiaTest
 extends IPhysiologyTest{

}
