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
<p>http://www.co-ode.org/ontologies/galen#Extremity
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68005121
<p>
<p><b>scio:example</b>
<p>The ability for OEG to facilitate regeneration was analyzed electrophysiologically by transcranially stimulating the brainstem and recording motor evoked potentials (MEP) with chronically implanted intramuscular EMG electrodes in the soleus and tibalis anterior with and without intrathecal injections of noradrenergic, serotonergic, and glycinergic receptor antagonists.
<p>
<p><b>rdfs:label</b>
<p>extremity
<p>
<p><b>rdfs:description</b>
<p>Extremity is a projection of the body such as hand and foot which is the target tissue of neuronal innervation.
<p>
<p><b>scio:exampleSource</b>
<p>doi: 10.1016/j.expneurol.2011.01.007
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=Extremity.class)
 public interface IExtremity
 extends IAnatomicalLocation{

}
