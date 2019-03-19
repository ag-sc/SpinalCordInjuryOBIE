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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C127831
<p>
<p><b>scio:example</b>
<p>In the present study the lower doses of dexamethasone, 0.125-2.0mg, were administered via the subdural infusion for 2 weeks after an epidural balloon crush of the mid-thoracic spinal cord.
<p>
<p><b>rdfs:label</b>
<p>spinal subdural area
<p>
<p><b>rdfs:description</b>
<p>Spinal Subdural Area is the anatomical location between the dura mater and the spinal cord tissue.
<p>
<p><b>scio:exampleSource</b>
<p>http://www.ncbi.nlm.nih.gov/pubmed/26851684
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=SpinalSubduralArea.class)
 public interface ISpinalSubduralArea
 extends IIntraspinal{

}
