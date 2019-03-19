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
<p>http://purl.bioontology.org/ontology/STY/T051
<p>
<p><b>skos:closeMatch</b>
<p>http://purl.bioontology.org/ontology/LNC/LP94957-5
<p>
<p><b>scio:descriptionSource</b>
<p>http://purl.org/net/OCRe/OCRe.owl#OCRE400004
<p>
<p><b>rdfs:label</b>
<p>event
<p>
<p><b>rdfs:description</b>
<p>Event is a processual entity that is a maximally connected spatiotemporal whole and has bona fide beginnings and endings corresponding to real discontinuities.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=Event.class)

@AssignableSubInterfaces(get={IRehabilitativeTraining.class, IEnrichedEnvironment.class, IModificationTreatment.class, IElectromagneticFieldTreatment.class, IGeneticModificationTreatment.class, IPhotochemicalInjury.class, IAspirationLesion.class, IPartialTransection.class, IInjury.class, IInjuryByAccident.class, INormothermicTreatment.class, ILateralHemisection.class, ITreadmillTraining.class, IHeatLesion.class, ICompleteTransection.class, IPhysicalTreatment.class, IInvestigation.class, IVoltageApplication.class, ISurgeryTreatment.class, ICompoundTreatment.class, IVentralHemisection.class, ILaminectomy.class, IElectrolyticLesion.class, ICurrentApplication.class, IContusion.class, IDislocation.class, ICompression.class, IDorsalHemisection.class, ITreatment.class, IPhysicalImplantTreatment.class, IHypothermicTreatment.class, IDistraction.class, ITemperatureTreatment.class, IChemicalInjury.class, IMagneticFieldApplication.class, IOvariectomyTreatment.class, IObservation.class, })
 public interface IEvent
 extends ITime_TemporalEntity{

/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
	public IEvent addTemporalInterval(ITemporalInterval temporalInterval);


/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
	public List<ITemporalInterval> getTemporalIntervals();


/**
<p><b>rdfs:label</b>
<p>temporal interval
<p>*/
	public IEvent setTemporalIntervals(List<ITemporalInterval> temporalIntervals);


}
