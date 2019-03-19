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
<p>https://www.ncbi.nlm.nih.gov/mesh/?term=astrogliosis
<p>
<p><b>scio:example</b>
<p>Both pioglitazone and rosiglitazone (1.5 mg/kg i.p.; four doses at 5 min and 12, 24, and 48 h) significantly decreased the lesion size (by 57 to 68%, p .<0.05), motor neuron loss (by 3- to 10-fold, p .<0.05), myelin loss (by 66 to 75%, p < 0.05), astrogliosis (by 46 to 61%, p <0.05), and microglial activation (by 59 to 78%, p .<0.05) after SCI.
<p>
<p><b>rdfs:label</b>
<p>astrogliosis test
<p>
<p><b>rdfs:description</b>
<p>Astrogliosis Test or Gliosis Test is the examination of the production of a dense fibrous network of neuroglia with histological methods; includes astrocytosis, which is a proliferation of astrocytes in the area of a degenerative lesion.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=AstrogliosisTest.class)
 public interface IAstrogliosisTest
 extends INonNeuronalCellChangesTest{

}
