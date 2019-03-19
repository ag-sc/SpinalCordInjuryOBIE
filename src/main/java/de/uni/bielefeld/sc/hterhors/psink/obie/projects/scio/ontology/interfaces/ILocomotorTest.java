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
<p>Behavioral tests. Basso, Beattie, and Bresnahan (BBB) locomotor scale, grid walking, and footprint analysis were used to evaluate functional recovery.
<p>
<p><b>rdfs:label</b>
<p>locomotor test
<p>
<p><b>rdfs:description</b>
<p>Locomotor Test is the examination of movement or the ability to move from one place or another. It can refer to humans, vertebrate or invertebrate animals, and microorganisms.
<p>
<p><b>scio:exampleSource</b>
<p>DOI: http://dx.doi.org/10.3727/096368912X661373
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={IWalkingAnalysisTest.class, ILadderRungTest.class, ISwimmingTest.class, IFootprintAnalysisTest.class, ILouisvilleSwimScale.class, })

@ImplementationClass(get=LocomotorTest.class)
 public interface ILocomotorTest
 extends IFunctionalTest{

}
