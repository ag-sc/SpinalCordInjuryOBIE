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
<p>https://www.ncbi.nlm.nih.gov/mesh/68016650
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68011092
<p>
<p><b>rdfs:label</b>
<p>pegfitc
<p>
<p><b>rdfs:description</b>
<p>PEG FITC or Polyethylene glycol coupled to Fluorescein-5-isothiocyanate is a polymer of ethylene oxide and water, or its ethers. They vary in consistency from liquid to solid depending on the molecular weight indicated by a number following the name. They are used as surfactants, dispersing agents, solvents, ointment and suppository bases, vehicles, and tablet excipients. Some specific groups are nonoxynols, octoxynols amd poloxamers. 
PEG is coupled to FITC, a fluorescent probe capable of being conjugated to tissue and proteins. It is used as a label in fluorescent antibody staining procedures as well as protein- and amino acid-binding techniques.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=PEGFITC.class)
 public interface IPEGFITC
 extends ISubstance{

}
