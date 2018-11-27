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
<p>https://www.ncbi.nlm.nih.gov/mesh/68020442
<p>
<p><b>rdfs:label</b>
<p>poloxamer
<p>
<p><b>rdfs:description</b>
<p>Poloxamer is a nonionic polyoxyethylene-polyoxypropylene block co-polymer with the general formula HO(C2H4O)a(-C3H6O)b(C2H4O)aH. It is available in different grades which vary from liquids to solids. It is used as an emulsifying agent, solubilizing agent, surfactant, and wetting agent for antibiotics. Poloxamer is also used in ointment and suppository bases and as a tablet binder or coater. (Martindale The Extra Pharmacopoeia, 31st ed)
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Poloxamer.class)

@AssignableSubInterfaces(get={IP188.class, })
 public interface IPoloxamer
 extends ISubstance{

}
