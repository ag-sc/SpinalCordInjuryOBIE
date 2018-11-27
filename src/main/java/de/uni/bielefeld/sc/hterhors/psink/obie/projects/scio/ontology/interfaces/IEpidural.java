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
<p>http://purl.bioontology.org/ontology/MESH/D004824
<p>
<p><b>scio:example</b>
<p>This study aimed at evaluating the effects of epidural stimulation (EpS) over the spinal EUS controlling center (L3) in combination with a serotonergic receptor agonist on EUS relaxation in naive rats and chronic (6-8 wk) T8 SCI rats.
<p>
<p><b>rdfs:label</b>
<p>epidural
<p>
<p><b>rdfs:description</b>
<p>Epidural is the anatomical location distal to the dura mater referred to the spinal cord tissue. Substances injected epidurally must cross the dura to reach the spinal cord tissue.
<p>
<p><b>scio:exampleSource</b>
<p>http://www.ncbi.nlm.nih.gov/pubmed/25694482
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Epidural.class)

@AssignableSubInterfaces(get={})
 public interface IEpidural
 extends IIntrathecal{

}
