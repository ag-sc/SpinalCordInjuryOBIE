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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/373464007
<p>
<p><b>scio:example</b>
<p>Female Sprague Dawley adult rats (200-220 g; 6-8 weeks of age) were anesthetized with an intraperitoneal injection of 7.5 mg/kg ketamine (Phoenix Pharmaceutical, St. Joseph, MO) and 60 mg/kg xylazine (Phoenix Pharmaceutical).
<p>
<p><b>rdfs:label</b>
<p>ketamine as anaesthetic
<p>
<p><b>rdfs:description</b>
<p>Ketamine as anaesthetic is a substance for pain relief and sedation during anaesthesia. It must be differentiated from Ketamine which is used as a neuroprotective therapeuticum.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1523/JNEUROSCI.0311-05.2005
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=KetamineAsAnaesthetic.class)
 public interface IKetamineAsAnaesthetic
 extends IAnaesthetic{

}
