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
<p><b>scio:example</b>
<p>An impaction device was developed initially at the University of Trieste (UTS) by modification of a small materials testing unit ..
<p>
<p><b>rdfs:label</b>
<p>univ of trieste impactor
<p>
<p><b>rdfs:description</b>
<p>The University of Trieste or UTS impactor device is used to inflict accurate and specific weight drop on the exposed spinal cord.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1073/pnas.142287899
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=UnivOfTriesteImpactor.class)

@AssignableSubInterfaces(get={})
 public interface IUnivOfTriesteImpactor
 extends IWeightDrop{

}
