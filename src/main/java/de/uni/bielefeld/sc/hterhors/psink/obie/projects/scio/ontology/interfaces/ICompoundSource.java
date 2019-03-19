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
<p>compound source
<p>
<p><b>scio:visualizationContainer</b>
<p>Compound_Treatment_Group
<p>
<p><b>rdfs:description</b>
<p>Compound source is the origin of a compound applied as treatment for spinal cord injury. It can be a company or the description of the biological source of an implanted biological entity.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@ImplementationClass(get=CompoundSource.class)

@AssignableSubInterfaces(get={ICompoundBiologicalRelation.class, ICompoundSupplier.class, })
 public interface ICompoundSource
 extends ISCIOThing{

}
