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
<p>stem cell
<p>
<p><b>rdfs:description</b>
<p>Stem cells are undifferentiated cell which can divide and develop into specialized cells.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={IMesenchymalStemCell.class, IUmbilicalCordBloodStemCell.class, IBoneMarrowStemCell.class, })

@ImplementationClass(get=StemCell.class)
 public interface IStemCell
 extends ICell{

/**
<p><b>rdfs:label</b>
<p>has stem cell source type
<p>*/
	public IStemCellSourceType getStemCellSourceType();


/**
<p><b>rdfs:label</b>
<p>has stem cell source type
<p>*/
	public IStemCell setStemCellSourceType(IStemCellSourceType stemCellSourceType);


}
