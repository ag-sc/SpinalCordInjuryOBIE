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
<p>electromagnetic field treatment
<p>
<p><b>rdfs:description</b>
<p>Electromagnetic Field Treatment is the therapeutic intervention for spinal cord injury using an electromagnetic field usually by external or implanted electrodes.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IVoltageApplication.class, ICurrentApplication.class, IMagneticFieldApplication.class, })

@ImplementationClass(get=ElectromagneticFieldTreatment.class)
 public interface IElectromagneticFieldTreatment
 extends IPhysicalTreatment{

/**
<p><b>rdfs:label</b>
<p>has current
<p>*/
	public ICurrent getCurrent();


/**
<p><b>rdfs:label</b>
<p>has electric field strength
<p>*/
	public IElectricFieldStrength getElectricFieldStrength();


/**
<p><b>rdfs:label</b>
<p>has voltage
<p>*/
	public IVoltage getVoltage();


/**
<p><b>rdfs:label</b>
<p>has current
<p>*/
	public IElectromagneticFieldTreatment setCurrent(ICurrent current);


/**
<p><b>rdfs:label</b>
<p>has electric field strength
<p>*/
	public IElectromagneticFieldTreatment setElectricFieldStrength(IElectricFieldStrength electricFieldStrength);


/**
<p><b>rdfs:label</b>
<p>has voltage
<p>*/
	public IElectromagneticFieldTreatment setVoltage(IVoltage voltage);


}
