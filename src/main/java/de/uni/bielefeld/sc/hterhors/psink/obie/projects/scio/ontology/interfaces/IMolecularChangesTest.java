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
<p>http://purl.bioontology.org/ontology/STY/T063
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.bioontology.org/ontology/SNOMEDCT/84894008
<p>
<p><b>scio:example</b>
<p>The levels of the HIF-1α, Bcl-2, Bax and VEGF proteins were explored using western blotting.
<p>
<p><b>rdfs:label</b>
<p>molecular changes test
<p>
<p><b>rdfs:comment</b>
<p>No annotations are to be carried out with this  class. It merely exists in this ontology for its complete representation of concepts.
<p>
<p><b>rdfs:description</b>
<p>Molecular Changes Test is the investigation of changes of molecular composition or signal pathways or molecular signal function using molecular biology methods.
<p>
<p><b>scio:exampleSource</b>
<p>PMID: 26927342
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=MolecularChangesTest.class)

@AssignableSubInterfaces(get={IGeneExpressionAnalysis.class, IProteinLevelAnalysis.class, })
 public interface IMolecularChangesTest
 extends INonFunctionalTest{

}
