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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C3380
<p>
<p><b>scio:example</b>
<p>We tested our proposal by administering Huperzine A intraperitoneally to male Wistar Albino rats (220-340 gr body weight) after moderate static clip compression (70 gr for 60 sec) of the spinal cord at T7 level.
<p>
<p><b>rdfs:label</b>
<p>compression
<p>
<p><b>rdfs:description</b>
<p>Compression (or crush) of the spinal cord is a process naturally caused by bone fragments, tumors or other pathological conditions. In the experimental spinal cord injury model, compression means a constant force being inflicted on the spinal cord from one or multiple sides simultaneously. This is in contrast to contusion, where a short term force is inflicted on the spinal cord from one side.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26472141
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Compression.class)

@AssignableSubInterfaces(get={})
 public interface ICompression
 extends IInjury{

}
