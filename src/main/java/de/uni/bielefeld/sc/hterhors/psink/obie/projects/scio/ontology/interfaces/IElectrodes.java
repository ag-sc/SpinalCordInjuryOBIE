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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/16470007
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68004567
<p>
<p><b>scio:example</b>
<p>SCI rats were instrumented with chronic FES electrodes in the hindlimb muscles and were divided into two groups: (a) FES therapy and (b) sedentary.
<p>
<p><b>rdfs:label</b>
<p>electrodes
<p>
<p><b>rdfs:description</b>
<p>Electrodes are surgically placed electric conductors through which electric stimulation is delivered to or electrical activity is recorded from a specific point inside the body.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1179/2045772313Y.0000000117
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Electrodes.class)

@AssignableSubInterfaces(get={})
 public interface IElectrodes
 extends IApplicationInstrument{

}
