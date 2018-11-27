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
<p>substance
<p>
<p><b>rdfs:description</b>
<p>Substance is a chemical compound apllied for a treatment, other than nucleic acid or a protein.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IBW755C.class, IP188.class, IMagnesiumSulfate.class, IEthanol.class, INS398.class, IWater.class, ICelebocid.class, IDarbepoetin.class, IDMSO.class, IPregabalin.class, IPEGFITC.class, ISC58125.class, IPoloxamer.class, IInosine.class, IMexiletine.class, IKetamine.class, IIbuprofen.class, IRiluzole.class, IRingersSolution.class, ICyclosporineA.class, IEvansBlue.class, IAcetylsalicylicAcid.class, IIndomethacin.class, IMethanesulfonamide.class, IPBS.class, IMagnesium.class, ILipopolysaccharide.class, IMinocyclineMC.class, IMPSS.class, ITetracycline.class, IVegetableOil.class, IPolyethyleneGlycolPEG.class, IPioglitazone.class, IRolipram.class, IIloprost.class, IClodronate.class, IVehicle.class, IHematoxyLinEosin.class, ILithiumChloride.class, IDipyridamol.class, ISaline.class, IPhenytoine.class, IMethylprednisoloneMP.class, IICI182780.class, })

@ImplementationClass(get=Substance.class)
 public interface ISubstance
 extends ICompound{

}
