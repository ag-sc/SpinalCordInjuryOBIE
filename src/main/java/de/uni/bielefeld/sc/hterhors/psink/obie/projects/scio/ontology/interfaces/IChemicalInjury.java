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
<p><b>rdfs:label</b>
<p>chemical injury
<p>
<p><b>rdfs:description</b>
<p>Chemical Innjury or chemical spinal cord injury is a process leading to a lesion or damage to the spinal cord using a photochemical dye and illumination.
<p>
<p><b>scio:clinicalTerm</b>
<p>false
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=ChemicalInjury.class)

@AssignableSubInterfaces(get={})
 public interface IChemicalInjury
 extends IInjury{

/**
<p><b>rdfs:label</b>
<p>has chemical compound
<p>*/
	public IChemicalInjury addChemicalCompound(ICompound compound);


/**
<p><b>rdfs:label</b>
<p>has chemical compound
<p>*/
	public List<ICompound> getChemicalCompounds();


/**
<p><b>rdfs:label</b>
<p>has chemical compound
<p>*/
	public IChemicalInjury setChemicalCompounds(List<ICompound> chemicalCompounds);


}
