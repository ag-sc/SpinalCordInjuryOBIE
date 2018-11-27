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
<p>http://purl.bioontology.org/ontology/CSP/2049-9515
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68002490
<p>
<p><b>scio:example</b>
<p>For analysis of Fluoro-Gold-traced CPCs, brain and thoracic spinal cord were removed and postﬁxed in 4% paraformaldehyde for 24 h, then cryopreserved for 48 h in 30% sucrose.
<p>
<p><b>rdfs:label</b>
<p>central nervous system
<p>
<p><b>rdfs:description</b>
<p>Central Nervous System is an anatomical location comprising the brain, spinal cord, and meninges.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 16367771
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={ISpinalLesionSite.class, ISpinalDorsalHalf.class, ISpinalWhiteMatter.class, IEpidural.class, IBrain.class, IIntraspinal.class, IDorsalColumn.class, ICorticospinalTract.class, IAscendingFiberTract.class, ISpinalFiberTract.class, ISpinalCord.class, ISpinalGrayMatter.class, IRubrospinalTract.class, ISpinalSubduralArea.class, ISpinalCentralPart.class, ISpinalVentralHalf.class, ILesionAdjacentTissue.class, IIntrathecal.class, })

@ImplementationClass(get=CentralNervousSystem.class)
 public interface ICentralNervousSystem
 extends IAnatomicalLocation{

}
