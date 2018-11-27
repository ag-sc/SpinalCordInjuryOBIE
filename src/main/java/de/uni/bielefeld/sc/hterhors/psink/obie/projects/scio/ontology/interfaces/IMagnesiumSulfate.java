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
<p>https://www.ncbi.nlm.nih.gov/mesh/68008278
<p>
<p><b>rdfs:label</b>
<p>magnesium sulfate
<p>
<p><b>rdfs:description</b>
<p>Magnesium Sulfate is a small colorless crystal used as an anticonvulsant, a cathartic, and an electrolyte replenisher in the treatment of pre-eclampsia and eclampsia. It causes direct inhibition of action potentials in myometrial muscle cells. Excitation and contraction are uncoupled, which decreases the frequency and force of contractions. (From AMA Drug Evaluations Annual, 1992, p1083)
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=MagnesiumSulfate.class)
 public interface IMagnesiumSulfate
 extends ISubstance{

}
