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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/273948005
<p>
<p><b>scio:example</b>
<p>Female Sprague-Dawley rats (200-250 gm) were anesthetized with chloral hydrate( 360m g/kg,i .p.), and a laminectomy was performed at the T8 vertebral level to expose a 2.8-mm-diameter circle of dura.
<p>
<p><b>rdfs:label</b>
<p>chloral hydrate
<p>
<p><b>rdfs:description</b>
<p>Chloral hydrate is a hypnotic pharmacological drug with sedative and hypnotic effects.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 7965063
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=ChloralHydrate.class)

@AssignableSubInterfaces(get={})
 public interface IChloralHydrate
 extends ISedative{

}
