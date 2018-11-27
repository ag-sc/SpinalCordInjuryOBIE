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
<p>injury by accident
<p>
<p><b>scio:visualizationContainer</b>
<p>Injury_Group
<p>
<p><b>rdfs:description</b>
<p>Injury By Accident is a process which leads to spinal cord injury in an uncontrolled way. It is not caused by an experimentator on purpose but occurs by circumstances which are uncontrolled like e.g. in an accident. These injuries are characterized by their severity and also by their type.
<p>
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@ImplementationClass(get=InjuryByAccident.class)

@AssignableSubInterfaces(get={})
 public interface IInjuryByAccident
 extends IInjury{

/**
<p><b>rdfs:label</b>
<p>has injury by accident type
<p>
<p><b>rdfs:description</b>
<p>The \"has injury type\" property links the \"Injury by Accident\" class with the injury type. In uncontrolled situations there is usually a mix of crush, dislocation and transection of the spinal cord by e.g. bone parts. Therefore multiple injury types must be considered when describing an uncontrolled spinal cord injury situation.
<p>*/
	public IInjuryByAccident addInjuryByAccidentType(IInjuryByAccidentType injuryByAccidentType);


/**
<p><b>rdfs:label</b>
<p>has injury by accident type
<p>
<p><b>rdfs:description</b>
<p>The \"has injury type\" property links the \"Injury by Accident\" class with the injury type. In uncontrolled situations there is usually a mix of crush, dislocation and transection of the spinal cord by e.g. bone parts. Therefore multiple injury types must be considered when describing an uncontrolled spinal cord injury situation.
<p>*/
	public List<IInjuryByAccidentType> getInjuryByAccidentTypes();


/**
<p><b>rdfs:label</b>
<p>has injury by accident type
<p>
<p><b>rdfs:description</b>
<p>The \"has injury type\" property links the \"Injury by Accident\" class with the injury type. In uncontrolled situations there is usually a mix of crush, dislocation and transection of the spinal cord by e.g. bone parts. Therefore multiple injury types must be considered when describing an uncontrolled spinal cord injury situation.
<p>*/
	public IInjuryByAccident setInjuryByAccidentTypes(List<IInjuryByAccidentType> injuryByAccidentTypes);


}
