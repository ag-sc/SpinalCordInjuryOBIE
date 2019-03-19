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
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C63495
<p>
<p><b>scio:descriptionSource</b>
<p>http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#C63495
<p>
<p><b>rdfs:label</b>
<p>compound
<p>
<p><b>scio:visualizationContainer</b>
<p>Compound_Treatment_Group
<p>
<p><b>rdfs:description</b>
<p>Compound is a substance, which consists of two or more ingredients.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=Compound.class)

@AssignableSubInterfaces(get={I_17BetaEstradiolE2.class, IProgesterone.class, INS398.class, IDarbepoetin.class, IPEGFITC.class, IInosine.class, IMexiletine.class, IUmbilicalCordBloodStemCell.class, IMacrophageCell.class, IIbuprofen.class, INT3Lentivirus.class, IEstrogen.class, IIndomethacin.class, IMelatonin.class, IPBS.class, IMethanesulfonamide.class, IMagnesium.class, IErythropoietin.class, ISteroid.class, IMinocyclineMC.class, IMPSS.class, IMesenchymalStemCell.class, ILipopolysaccharide.class, IAntiCD11dAntibody.class, ITetracycline.class, IArylsulfataseB.class, IVegetableOil.class, IPenicillinase.class, IPolyethyleneGlycolPEG.class, IDNA.class, IVimentinAntiSenseDNA.class, IRetrovirus.class, IPioglitazone.class, IRolipram.class, IIloprost.class, ITyrosineHydroxylase.class, IRecombinantEPORhEpo.class, IOlfactoryEnsheathingGliaCell.class, IDipyridamol.class, ISaline.class, IPregnenoloneS.class, IChondroitinaseABC.class, INOGOReceptorAntagonist.class, IRNA.class, IBW755C.class, IHormone.class, IP188.class, IEnzyme.class, IMagnesiumSulfate.class, IWater.class, IEthanol.class, ICelebocid.class, IDMSO.class, IVirus.class, IPregabalin.class, ISC58125.class, IPoloxamer.class, IBrainDerivedNeurotrophicFactor.class, INeurotrophin3.class, IKetamine.class, IRiluzole.class, IAntiNG2Antibody.class, INucleicAcid.class, ICyclosporineA.class, IRingersSolution.class, IEvansBlue.class, ISchwannCell.class, IAcetylsalicylicAcid.class, IAlbumin.class, IAsialoEPO.class, ISubstance.class, IStemCell.class, IImmuneCell.class, IAntibody.class, ILentivirus.class, IPregnenolone.class, IEstradiolBenzoate.class, IConduit.class, IP4.class, IAtorvastatinAT.class, IAntiNogoAAntibody.class, ICell.class, IBoneMarrowStemCell.class, IClodronate.class, IVehicle.class, IMatrix.class, IHematoxyLinEosin.class, ITissue.class, ILithiumChloride.class, IGlialCell.class, IProtein.class, IPhenytoine.class, IDehydroEpiandrosteroneSulfate.class, IMethylprednisoloneMP.class, IICI182780.class, })
 public interface ICompound
 extends ISCIOThing{

/**
<p><b>scio:example</b>
<p>All compunds were provided by Dragon Pharmaceuticals.
<p>
<p><b>rdfs:label</b>
<p>has supplier
<p>
<p><b>rdfs:comment</b>
<p>Property of the compound, e.g. the substance applied. It points at the supplier, e.g. a pharmacological company.
<p>*/
	public ICompoundSupplier getCompoundSupplier();


/**
<p><b>rdfs:label</b>
<p>has tissue source location
<p>*/
	public IAnatomicalLocation getTissueSourceAnatomicalLocation();


/**
<p><b>scio:example</b>
<p>All compunds were provided by Dragon Pharmaceuticals.
<p>
<p><b>rdfs:label</b>
<p>has supplier
<p>
<p><b>rdfs:comment</b>
<p>Property of the compound, e.g. the substance applied. It points at the supplier, e.g. a pharmacological company.
<p>*/
	public ICompound setCompoundSupplier(ICompoundSupplier compoundSupplier);


/**
<p><b>rdfs:label</b>
<p>has tissue source location
<p>*/
	public ICompound setTissueSourceAnatomicalLocation(IAnatomicalLocation tissueSourceAnatomicalLocation);


}
