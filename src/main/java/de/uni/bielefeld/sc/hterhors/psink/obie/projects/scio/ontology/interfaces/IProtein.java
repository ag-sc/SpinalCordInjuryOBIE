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
<p>http://purl.obolibrary.org/obo/CHEBI_36080
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68011506
<p>
<p><b>rdfs:label</b>
<p>protein
<p>
<p><b>rdfs:description</b>
<p>Protein is a linear polypeptide that is synthesized on ribosomes and may be further modified, crosslinked, cleaved, or assembled into complex proteins with several subunits. The specific sequence of amino acids determines the shape the polypeptide will take, during protein folding, and the function of the protein.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=Protein.class)

@AssignableSubInterfaces(get={IHormone.class, I_17BetaEstradiolE2.class, IProgesterone.class, IEnzyme.class, IBrainDerivedNeurotrophicFactor.class, INeurotrophin3.class, IAntiNG2Antibody.class, IEstrogen.class, IMelatonin.class, IAlbumin.class, IAsialoEPO.class, IErythropoietin.class, ISteroid.class, IAntiCD11dAntibody.class, IAntibody.class, IArylsulfataseB.class, IPregnenolone.class, IEstradiolBenzoate.class, IPenicillinase.class, IP4.class, IAtorvastatinAT.class, IAntiNogoAAntibody.class, ITyrosineHydroxylase.class, IRecombinantEPORhEpo.class, IPregnenoloneS.class, IChondroitinaseABC.class, IDehydroEpiandrosteroneSulfate.class, INOGOReceptorAntagonist.class, })
 public interface IProtein
 extends ICompound{

}
