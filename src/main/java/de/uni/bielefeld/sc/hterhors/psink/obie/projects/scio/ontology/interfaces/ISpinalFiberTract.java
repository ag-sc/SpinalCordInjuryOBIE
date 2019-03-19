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
<p>http://purl.org/sig/ont/fma/fma75683
<p>
<p><b>scio:example</b>
<p>Even at this early time-point the RST revealed signiﬁcantly
higher densities in AST animals than under control conditions, and CST axons showed a clear trend towards more prominent in-growth into the secondary than the primary scar ...
<p>
<p><b>rdfs:label</b>
<p>spinal fiber tract
<p>
<p><b>rdfs:description</b>
<p>Spinal Fiber Tract comprises a bundle of neuronal projections inside the spinal cord.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1111/j.1460-9568.2009.06929.x
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={IRubrospinalTract.class, ICorticospinalTract.class, IAscendingFiberTract.class, })

@ImplementationClass(get=SpinalFiberTract.class)
 public interface ISpinalFiberTract
 extends IIntraspinal{

}
