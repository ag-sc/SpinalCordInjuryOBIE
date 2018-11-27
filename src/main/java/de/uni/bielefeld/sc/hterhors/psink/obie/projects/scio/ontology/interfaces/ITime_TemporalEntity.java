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
<p><b>rdfs:description</b>
<p>Temporal Entity is a temporal interval or instant.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IEvent.class, IRehabilitativeTraining.class, IEnrichedEnvironment.class, IModificationTreatment.class, IElectromagneticFieldTreatment.class, IGeneticModificationTreatment.class, IPhotochemicalInjury.class, IAspirationLesion.class, IPartialTransection.class, IInjury.class, IInjuryByAccident.class, INormothermicTreatment.class, ILateralHemisection.class, ITreadmillTraining.class, IHeatLesion.class, ICompleteTransection.class, IPhysicalTreatment.class, IInvestigation.class, IVoltageApplication.class, ISurgeryTreatment.class, ICompoundTreatment.class, IVentralHemisection.class, ILaminectomy.class, IElectrolyticLesion.class, ICurrentApplication.class, IContusion.class, IDislocation.class, ICompression.class, IDorsalHemisection.class, ITreatment.class, IPhysicalImplantTreatment.class, IHypothermicTreatment.class, IDistraction.class, ITemperatureTreatment.class, ITemporalInterval.class, IChemicalInjury.class, IMagneticFieldApplication.class, IOvariectomyTreatment.class, IObservation.class, })

@ImplementationClass(get=Time_TemporalEntity.class)
 public interface ITime_TemporalEntity
 extends ISCIOThing{

}
