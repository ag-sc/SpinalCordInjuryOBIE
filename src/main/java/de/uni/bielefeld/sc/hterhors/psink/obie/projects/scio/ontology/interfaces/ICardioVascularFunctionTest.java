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
<p>http://purl.bioontology.org/ontology/MEDDRA/10060858
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=cardiovascular+function
<p>
<p><b>scio:example</b>
<p>Pretreatment with atropine prevented changes in MAP, HR and NADPH-d staining suggesting that such modifications result from an increased vagal stimulation.
<p>
<p><b>rdfs:label</b>
<p>cardio vascular function test
<p>
<p><b>rdfs:description</b>
<p>Cardiovascular Function Test is the examination of the physiological phenomena,
processes and properties of the cardiovascular system as a whole or of any of its parts.
<p>
<p><b>scio:exampleSource</b>
<p>DOI: 10.1016/S0304-3940(99)00495-4
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=CardioVascularFunctionTest.class)

@AssignableSubInterfaces(get={IBloodCirculationExamination.class, })
 public interface ICardioVascularFunctionTest
 extends IPhysiologyTest{

}
