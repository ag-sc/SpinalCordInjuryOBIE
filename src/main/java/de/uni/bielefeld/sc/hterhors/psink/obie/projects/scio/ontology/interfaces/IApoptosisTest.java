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
<p>http://scai.fraunhofer.de/CSEO#CSEO_00001574
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.obolibrary.org/obo/ERO_0001182
<p>
<p><b>skos:closeMatch</b>
<p>http://www.bioassayontology.org/bao#BAO_0002043
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68017209
<p>
<p><b>scio:example</b>
<p>In addition, neuronal apoptosis was detected 24 hr after injury followed by a profound increase
in ED1-positive inflammatory infiltrates, glial fibrillary acidic protein (GFAP)-positive reactive astrocytes,
and oligodendrocyte apoptosis by 1 week after SCI relative to control.
<p>
<p><b>rdfs:label</b>
<p>apoptosis test
<p>
<p><b>rdfs:description</b>
<p>Apoptosis Test is the histological examination of the mechanisms by which CELL DEATH occurs (compare with NECROSIS and AUTOPHAGOCYTOSIS). Apoptosis is the mechanism responsible for the physiological deletion of cells and appears to be intrinsically programmed. It is characterized by distinctive morphologic changes in the nucleus and cytoplasm, chromatin cleavage at regularly spaced sites, and the endonucleolytic cleavage of genomic DNA; (DNA FRAGMENTATION); at internucleosomal sites. This mode of cell death serves as a balance to mitosis in regulating the size of animal tissues and in mediating pathologic processes associated with tumor growth.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=ApoptosisTest.class)

@AssignableSubInterfaces(get={})
 public interface IApoptosisTest
 extends ISecondaryDegenerationTest{

}
