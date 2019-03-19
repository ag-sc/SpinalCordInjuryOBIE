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
<p>location
<p>
<p><b>scio:visualizationContainer</b>
<p>Location_Group
<p>
<p><b>rdfs:description</b>
<p>Location is a spatial region or named place. It is further a position, site, or point in space where something can be found.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={ISpinalLesionSite.class, ISpinalDorsalHalf.class, ISpinalWhiteMatter.class, IVertebrae.class, IBrain.class, IVertebralSegment.class, IVertebralLocation.class, IIntraspinal.class, ICorticospinalTract.class, IAscendingFiberTract.class, ISpinalCord.class, ISpinalGrayMatter.class, ICentralNervousSystem.class, IRubrospinalTract.class, ISpinalSubduralArea.class, ISpinalCentralPart.class, ISpinalVentralHalf.class, ILesionAdjacentTissue.class, IIntrathecal.class, IExtremity.class, IEpidural.class, IDorsalColumn.class, ISpinalFiberTract.class, IAnatomicalLocation.class, ISubstanceApplicationLocation.class, IVertebralArea.class, })

@ImplementationClass(get=Location.class)
 public interface ILocation
 extends ISCIOThing{

}
