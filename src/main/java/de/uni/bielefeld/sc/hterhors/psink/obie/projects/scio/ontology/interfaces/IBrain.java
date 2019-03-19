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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C12439
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68001921
<p>
<p><b>scio:example</b>
<p>Retrograde axonal Fluoro-Gold tracing of pyramidal neurons in
layer V of primary somatosensory cortex projecting into the dorsal CST revealed a remarkable rescue effect of the scar-suppressing treatment in the cortical area of Bregma -1.1 to - 2.1 mm.
<p>
<p><b>rdfs:label</b>
<p>brain
<p>
<p><b>rdfs:description</b>
<p>Brain is the part of the central nervous system that is contained within the skull.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 16367771
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=Brain.class)
 public interface IBrain
 extends ICentralNervousSystem{

}
