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
<p>http://purl.bioontology.org/ontology/STY/T025
<p>
<p><b>scio:example</b>
<p>Previous reports from our laboratory have documented the antiinflammatory potential of lovastatin, which was found to block expression of iNOS and proinflammatory cytokines (TNF., IL-1., and IL-6) in activated glial *cells* (microglia and astrocytes) and macrophages in culture (Pahan et al., 1997).
<p>
<p><b>rdfs:label</b>
<p>cell
<p>
<p><b>rdfs:description</b>
<p>Cell is a biological entity used for treatment by transplantation or application to the organism after spinal cord injury, e.g., genetically modified cells, stem cells, etc.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={IMesenchymalStemCell.class, IStemCell.class, ISchwannCell.class, IOlfactoryEnsheathingGliaCell.class, IImmuneCell.class, IGlialCell.class, IUmbilicalCordBloodStemCell.class, IMacrophageCell.class, IBoneMarrowStemCell.class, })

@ImplementationClass(get=Cell.class)
 public interface ICell
 extends ICompound{

/**
<p><b>rdfs:label</b>
<p>has experimental procedure
<p>
<p><b>rdfs:description</b>
<p>Mulitple processing steps can be necessary before a cell or tissue can be implanted.
<p>*/
	public ICell addExperimentalProcedure(IExperimentalProcedure experimentalProcedure);


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
<p>has experimental procedure
<p>
<p><b>rdfs:description</b>
<p>Mulitple processing steps can be necessary before a cell or tissue can be implanted.
<p>*/
	public List<IExperimentalProcedure> getExperimentalProcedures();


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
	public ICell setCompoundBiologicalRelation(ICompoundBiologicalRelation compoundBiologicalRelation);


/**
<p><b>rdfs:label</b>
<p>has experimental procedure
<p>
<p><b>rdfs:description</b>
<p>Mulitple processing steps can be necessary before a cell or tissue can be implanted.
<p>*/
	public ICell setExperimentalProcedures(List<IExperimentalProcedure> experimentalProcedures);


/**
<p><b>rdfs:label</b>
<p>has species
<p>*/
	public ICell setOrganismSpecies(IOrganismSpecies organismSpecies);


}
