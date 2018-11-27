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
<p>http://purl.bioontology.org/ontology/SNMI/T-A7020
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=grey+matter
<p>
<p><b>scio:example</b>
<p>The results from the diverse measures used (morphological
appearance on sections, immunocytochemistry and western
blotting of neuronal markers) indicate that loss of grey matter
occurs only in the first 24 hours after injury..
<p>
<p><b>rdfs:label</b>
<p>spinal gray matter
<p>
<p><b>rdfs:description</b>
<p>Spinal Gray Matter is the region of the spinal cord that appears darker in color than the other type.  It is composed of neuronal cell bodies, neuropil, glial cells, capillaries but few myelinated nerve fibers.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1371/journal.pone.0012021
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=SpinalGrayMatter.class)

@AssignableSubInterfaces(get={})
 public interface ISpinalGrayMatter
 extends IIntraspinal{

}
