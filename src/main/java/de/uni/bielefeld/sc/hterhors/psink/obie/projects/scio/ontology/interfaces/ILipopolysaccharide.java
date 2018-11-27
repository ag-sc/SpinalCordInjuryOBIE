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
<p>https://www.ncbi.nlm.nih.gov/mesh/68008070
<p>
<p><b>rdfs:label</b>
<p>lipopolysaccharide
<p>
<p><b>rdfs:description</b>
<p>Lipopolysaccharides are lipid-containing polysaccharides which are endotoxins and important group-specific antigens. They are often derived from the cell wall of gram-negative bacteria and induce immunoglobulin secretion. The lipopolysaccharide molecule consists of three parts: LIPID A, core polysaccharide, and O-specific chains (O ANTIGENS). When derived from Escherichia coli, lipopolysaccharides serve as polyclonal B-cell mitogens commonly used in laboratory immunology. (From Dorland, 28th ed)
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Lipopolysaccharide.class)

@AssignableSubInterfaces(get={})
 public interface ILipopolysaccharide
 extends ISubstance{

}
