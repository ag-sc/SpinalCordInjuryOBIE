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
<p>http://purl.obolibrary.org/obo/OBI_0000708
<p>
<p><b>skos:closeMatch</b>
<p>
<p>
<p><b>rdfs:label</b>
<p>animal care condition
<p>
<p><b>scio:visualizationContainer</b>
<p>Injury_Group
<p>
<p><b>rdfs:description</b>
<p>Animal care condition is a process performed according to an animal care protocol, which specifies the conditions of animal keeping and pre- and postsurgical medical care. Depending on the severity of the injury, medication and special care like e.g. manual bladder voiding is necessary in the postsurgical phase.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IChloralHydrate.class, IGlycopyrrolate.class, IAnaesthetic.class, IPostsurgicalMedication.class, INitrousOxide.class, IFluanisoneMidazolamMixture.class, IAtropineSulfate.class, IIsoflurane.class, IBodyTemperatureMeasurement.class, ISodiumPentobarbital.class, IPostSurgeryCondition.class, ISedative.class, IDiazepam.class, IAntibioticMedication.class, IMedicationDuringSurgery.class, IKeepingCondition.class, IXylazine.class, IThiopentalSodium.class, IHalothane.class, IKetamineAsAnaesthetic.class, })

@ImplementationClass(get=AnimalCareCondition.class)
 public interface IAnimalCareCondition
 extends ISCIOThing{

}
