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
<p>physical treatment
<p>
<p><b>rdfs:description</b>
<p>Physical Treatment is a therapeutic intervention for spinal cord injury comprising  temperature, radiation, vibration, movement, electrostimulation or other physical processes.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=PhysicalTreatment.class)

@AssignableSubInterfaces(get={IVoltageApplication.class, ISurgeryTreatment.class, IPhysicalImplantTreatment.class, IRehabilitativeTraining.class, IHypothermicTreatment.class, INormothermicTreatment.class, IEnrichedEnvironment.class, ICurrentApplication.class, IElectromagneticFieldTreatment.class, ITemperatureTreatment.class, IMagneticFieldApplication.class, ITreadmillTraining.class, })
 public interface IPhysicalTreatment
 extends ITreatment{

}
