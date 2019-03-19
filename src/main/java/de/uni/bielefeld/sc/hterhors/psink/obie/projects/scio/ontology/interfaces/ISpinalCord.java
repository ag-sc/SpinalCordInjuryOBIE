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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C12464
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68013116
<p>
<p><b>scio:example</b>
<p>Spinal cord slices with either Oregon green 488 ﬂuores-
cence (see above) or Alexa 488-, respectively Alexa 594-, coupled secondary antibodies were analysed using a Nikon Eclipse TE200 ﬂuorescent microscope.
<p>
<p><b>rdfs:label</b>
<p>spinal cord
<p>
<p><b>rdfs:description</b>
<p>Spinal Cord is a cylindrical column of tissue that lies within the vertebral canal. It is composed of white matter and gray matter.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1111/j.1460-9568.2009.06929.x
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=SpinalCord.class)

@AssignableSubInterfaces(get={ISpinalLesionSite.class, ISpinalDorsalHalf.class, ISpinalWhiteMatter.class, IEpidural.class, IIntraspinal.class, IDorsalColumn.class, ICorticospinalTract.class, IAscendingFiberTract.class, ISpinalFiberTract.class, ISpinalGrayMatter.class, IRubrospinalTract.class, ISpinalSubduralArea.class, ISpinalCentralPart.class, ISpinalVentralHalf.class, ILesionAdjacentTissue.class, IIntrathecal.class, })
 public interface ISpinalCord
 extends ICentralNervousSystem{

}
