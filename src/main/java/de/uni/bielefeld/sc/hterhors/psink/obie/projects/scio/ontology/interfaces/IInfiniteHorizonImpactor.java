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
<p>Contusion damage to the spinal cord at the 11th vertebra was performed by IH (Infinite Horizon) impactor, which applied a pressure of 50 kdyn.
<p>
<p><b>rdfs:label</b>
<p>infinite horizon impactor
<p>
<p><b>rdfs:comment</b>
<p>Former OSU impactor
<p>
<p><b>rdfs:description</b>
<p>Infinite Horizon Impactor is an instrument for accurate and specific weight drop on the exposed spinal cord.
force: 100-200 kdyn (100-150 kdyn corresponds to mild-moderate injury, 150-200 kdyn to moderate-severe injury)
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.3390/ijms160715785
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=InfiniteHorizonImpactor.class)
 public interface IInfiniteHorizonImpactor
 extends IWeightDrop{

}
