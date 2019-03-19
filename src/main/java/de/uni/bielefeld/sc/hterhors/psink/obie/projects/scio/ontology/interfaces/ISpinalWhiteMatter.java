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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/279436006
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.bioontology.org/ontology/RCD/Xa15J
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68066127
<p>
<p><b>scio:example</b>
<p>MBP staining was quantified by counting MBP immunoreactive myelin rings in a 100 μm × 100 μm area of the same four white matter regions.
<p>
<p><b>rdfs:label</b>
<p>spinal white matter
<p>
<p><b>rdfs:description</b>
<p>Spinal White Matter is the region of the spinal cord that appears lighter in color than the other type, thr gray matter. It mainly consists of myelinated nerve fibers and contains few neuronal cell bodies or dendrites.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.neuroscience.2013.12.024
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=SpinalWhiteMatter.class)

@AssignableSubInterfaces(get={})
 public interface ISpinalWhiteMatter
 extends IIntraspinal{

}
