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
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=neuroprotection
<p>
<p><b>scio:example</b>
<p>Cavity areas significantly decreased and the number of ventral motor neurons significantly increased in the Lav 200 and Lav 400 groups.
<p>
<p><b>rdfs:label</b>
<p>neuroprotection test
<p>
<p><b>rdfs:description</b>
<p>Neuroprotection Test is the examination of the physiological processes and techniques used by the body to prevent neuronal injury and degeneration in the central nervous system following acute disorders or as a result of chronic neurodegenerative diseases.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.3389/fnins.2016.00025
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=NeuroprotectionTest.class)

@AssignableSubInterfaces(get={})
 public interface INeuroprotectionTest
 extends INeuronalChangesTest{

}
