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
<p>http://purl.bioontology.org/ontology/SNOMEDCT/11713004
<p>
<p><b>scio:descriptionSource</b>
<p>https://www.ncbi.nlm.nih.gov/mesh/68014867
<p>
<p><b>rdfs:label</b>
<p>water
<p>
<p><b>rdfs:description</b>
<p>Water is a clear, odorless, tasteless liquid that is essential for most animal and plant life and is an excellent solvent for many substances. The chemical formula is hydrogen oxide (H2O). (McGraw-Hill Dictionary of Scientific and Technical Terms, 4th ed)
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=Water.class)
 public interface IWater
 extends IVehicle{

}
