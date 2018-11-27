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
<p>http://uri.neuinfo.org/nif/nifstd/nlx_inv_090911
<p>
<p><b>scio:descriptionSource</b>
<p>http://uri.neuinfo.org/nif/nifstd/nlx_inv_090911
<p>
<p><b>scio:example</b>
<p>The spinal mESC-NPCs were intrathecally transplanted into the lesion area of the spinal cord around T10-T11 at 21 days after SCI.
<p>
<p><b>rdfs:label</b>
<p>intrathecal
<p>
<p><b>rdfs:description</b>
<p>Intrathecal is an anatomical location inside the spinal canal (the canal in successive vertebrae through which the spinal cord passes-Wordnet definition) . For example, intrathecal immunoglobulin production means production of this substance in the spinal cord; intrathecal injection is an injection into the the spinal canal (intrathecal space surrounding the spinal cord), as in a spinal anaesthesia or in chemotherapy or pain management applications.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.3727/096368915X689460
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Intrathecal.class)

@AssignableSubInterfaces(get={IEpidural.class, })
 public interface IIntrathecal
 extends ISpinalCord{

}
