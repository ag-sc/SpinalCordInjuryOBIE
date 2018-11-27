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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/87568004
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68006728
<p>
<p><b>rdfs:label</b>
<p>hormone
<p>
<p><b>rdfs:description</b>
<p>Hormone is a chemical substance having a specific regulatory effect on the activity of a certain organ or organs. The term was originally applied to substances secreted by various endocrine glands and transported in the bloodstream to the target organs. It is sometimes extended to include those substances that are not produced by the endocrine glands but that have similar effects.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=Hormone.class)

@AssignableSubInterfaces(get={I_17BetaEstradiolE2.class, ISteroid.class, IProgesterone.class, IPregnenolone.class, IEstradiolBenzoate.class, IP4.class, IAtorvastatinAT.class, IRecombinantEPORhEpo.class, IEstrogen.class, IMelatonin.class, IPregnenoloneS.class, IDehydroEpiandrosteroneSulfate.class, IAsialoEPO.class, IErythropoietin.class, })
 public interface IHormone
 extends IProtein{

}
