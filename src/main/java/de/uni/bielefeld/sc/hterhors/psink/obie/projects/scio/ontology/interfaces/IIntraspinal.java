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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/360179007
<p>
<p><b>rdfs:label</b>
<p>intraspinal
<p>
<p><b>rdfs:description</b>
<p>Intraspinal is an anatomical location inside the central nervous tissue within the vertebral column.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={ISpinalLesionSite.class, IRubrospinalTract.class, ISpinalSubduralArea.class, ISpinalDorsalHalf.class, ISpinalWhiteMatter.class, IDorsalColumn.class, ICorticospinalTract.class, ISpinalCentralPart.class, IAscendingFiberTract.class, ISpinalFiberTract.class, ISpinalVentralHalf.class, ISpinalGrayMatter.class, })

@ImplementationClass(get=Intraspinal.class)
 public interface IIntraspinal
 extends ISpinalCord{

}
