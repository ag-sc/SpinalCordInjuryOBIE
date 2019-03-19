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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/68498002
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68007136
<p>
<p><b>rdfs:label</b>
<p>antibody
<p>
<p><b>rdfs:description</b>
<p>An antibody or immunoglobulin is a multi-subunit protein which functions in immunity. They are produced by B lymphocytes and are comprised of two heavy and two light chains with additional ancillary polypeptide chains depending on their isoforms. The variety of isoforms include monomeric or polymeric forms, and transmembrane forms or secreted forms. They are divided by the amino acid sequence of their heavy chains into five classes and various subclasses.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={IAntiNG2Antibody.class, IAntiCD11dAntibody.class, IAntiNogoAAntibody.class, })

@ImplementationClass(get=Antibody.class)
 public interface IAntibody
 extends IProtein{

}
