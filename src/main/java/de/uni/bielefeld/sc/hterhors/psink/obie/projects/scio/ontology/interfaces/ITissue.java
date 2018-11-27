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
<p>http://purl.obolibrary.org/obo/UBERON_0000479
<p>
<p><b>scio:descriptionSource</b>
<p>http://purl.obolibrary.org/obo/UBERON_0000479
<p>
<p><b>scio:example</b>
<p>We aimed to investigate whether an innovative growth factor-laden scaffold composed of acellular sciatic nerve (ASN) and brain-derived neurotrophic factor (BDNF) could promote axonal regeneration and functional recovery after spinal cord injury (SCI).
<p>
<p><b>rdfs:label</b>
<p>tissue
<p>
<p><b>rdfs:description</b>
<p>Tissue is a multicellular anatomical structure that consists of many cells of one or a few types, arranged in an extracellular matrix such that their long-range organisation is at least partly a repetition of their short-range organisation.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1371/journal.pone.0042813
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Tissue.class)

@AssignableSubInterfaces(get={})
 public interface ITissue
 extends ICompound{

/**
<p><b>rdfs:label</b>
<p>has compound biological relation
<p>
<p><b>rdfs:description</b>
<p>A cell or tissue implant is defined by its origin as refered to the host organism.
<p>*/
	public ICompoundBiologicalRelation getCompoundBiologicalRelation();


/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
	public IOrganismSpecies getOrganismSpecies();


/**
<p><b>rdfs:label</b>
<p>has compound biological relation
<p>
<p><b>rdfs:description</b>
<p>A cell or tissue implant is defined by its origin as refered to the host organism.
<p>*/
	public ITissue setCompoundBiologicalRelation(ICompoundBiologicalRelation compoundBiologicalRelation);


/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
	public ITissue setOrganismSpecies(IOrganismSpecies organismSpecies);


}
