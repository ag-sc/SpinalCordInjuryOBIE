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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/387731002
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=laminectomy
<p>
<p><b>scio:example</b>
<p>38 adult male Sprague-Dawley rats were randomly divided into 5 groups: only laminectomy, laminectomy and trauma, laminectomy trauma and Alpha Lipoic Acid 100 mg/kg IP administration, laminectomy trauma and N-Acetyl Cysteine 300 mg/kg IP administration, and vehicle group (PEG).
<p>
<p><b>rdfs:label</b>
<p>laminectomy
<p>
<p><b>rdfs:description</b>
<p>Laminectomy is a surgical procedure that entails removing all (laminectomy) or part (laminotomy) of selected vertebral lamina to relieve pressure on the SPINAL CORD and/or SPINAL NERVE ROOTS. Vertebral lamina is the thin flattened posterior wall of vertebral arch that forms the vertebral foramen through which pass the spinal cord and nerve roots.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.5137/1019-5149.JTN.14594-15.0
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=Laminectomy.class)
 public interface ILaminectomy
 extends IInjury{

}
