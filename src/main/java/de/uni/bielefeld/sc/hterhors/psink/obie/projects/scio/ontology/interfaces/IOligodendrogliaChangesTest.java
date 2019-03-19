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
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=oligodendroglia
<p>
<p><b>scio:example</b>
<p>Oligodendroglial apoptosis occurs along degenerating axons and is associated with FAS and p75 expression following spinal cord injury in the rat.
<p>
<p><b>rdfs:label</b>
<p>oligodendroglia changes test
<p>
<p><b>rdfs:description</b>
<p>Oligodendroglia Changes Test or Oligocyte Changes Test is the examination of any histological alterations in a class of large neuroglial (macroglial) cells in the central nervous system. Oligodendroglia may be called interfascicular, perivascular, or perineuronal according to their location. They form the insulating myelin sheath of axons in the central nervous system.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=OligodendrogliaChangesTest.class)
 public interface IOligodendrogliaChangesTest
 extends INonNeuronalCellChangesTest{

}
