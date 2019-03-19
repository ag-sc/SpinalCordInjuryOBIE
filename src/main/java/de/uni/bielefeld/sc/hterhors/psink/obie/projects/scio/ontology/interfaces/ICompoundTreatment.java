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
<p>http://purl.obolibrary.org/obo/OBI_0000951
<p>
<p><b>rdfs:label</b>
<p>compound treatment
<p>
<p><b>scio:visualizationContainer</b>
<p>Compound_Treatment_Group
<p>
<p><b>rdfs:description</b>
<p>Compound Treatment is a therapeutic intervention for spinal cord injury which includes the application of a substance, cell, implant etc. which is either applied locally or systemically.
<p>
*
* @author hterhors
*
*
*Mar 19, 2019
*/

@AssignableSubInterfaces(get={})

@ImplementationClass(get=CompoundTreatment.class)
 public interface ICompoundTreatment
 extends ITreatment{

/**
<p><b>rdfs:label</b>
<p>has compound
<p>
<p><b>rdfs:comment</b>
<p>A compound treatment has usually one compound and this is characterized by its type, dosage, anatomical location and instrument of application. 

If an experimental group is treated with a combinatorial approach as implantation of a cell and injection of a substance, then 2 treatments are associated with this experimental group.

Multiple timepoints can be assigned as treatment timepoint for one treatment, if the other properties of the treatment stay the same, i.e. dosage, delivery method, anatomical location and instrument of application. 
If one or more of these properties are changed, e.g. different doses of a substance are applied at different timepoints, then these paradigms are modeled as individual treatments. This means, dosage X at day 1 is treatment 1, dosage Y at day 2 is treatment 2.

Some combinatorial approaches consist of indivisible units like Schwann cell seeded guidance channels which are implanted as one unit. In order to model this approach, the property \"has composite compound\" is used.
<p>*/
	public ICompound getCompound();


/**
<p><b>scio:example</b>
<p>For alginate-hydrogel (ALG) preparation, a 2% (w/v) solution of alginate (Pronova UP LVM; NovaMatrix) in 150 mM sodium chloride (NaCl) was filtered with a sterile syringe filter.
<p>
<p><b>rdfs:label</b>
<p>has dosage
<p>
<p><b>rdfs:comment</b>
<p>Property of anaesthetic, postsurgical medication and compound. Points at supporting class \"Dosage\". Information about concentration of a substance or solution of e.g. cells. It can apply for a treatment substance or an anaesthetic or even an outcome measure if e.g. body fluid is investigated.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
	public IDosage getDosage();


/**
<p><b>rdfs:label</b>
<p>has supplied composite compound
<p>
<p><b>rdfs:comment</b>
<p>Some combinatorial approaches consist of indivisible units like Schwann cell seeded guidance channels which are implanted as one unit. In order to model this approach, the property \"has composite compound\" is used.
<p>*/
	public ICompound getSuppliedCompositeCompound();


/**
<p><b>rdfs:label</b>
<p>has compound
<p>
<p><b>rdfs:comment</b>
<p>A compound treatment has usually one compound and this is characterized by its type, dosage, anatomical location and instrument of application. 

If an experimental group is treated with a combinatorial approach as implantation of a cell and injection of a substance, then 2 treatments are associated with this experimental group.

Multiple timepoints can be assigned as treatment timepoint for one treatment, if the other properties of the treatment stay the same, i.e. dosage, delivery method, anatomical location and instrument of application. 
If one or more of these properties are changed, e.g. different doses of a substance are applied at different timepoints, then these paradigms are modeled as individual treatments. This means, dosage X at day 1 is treatment 1, dosage Y at day 2 is treatment 2.

Some combinatorial approaches consist of indivisible units like Schwann cell seeded guidance channels which are implanted as one unit. In order to model this approach, the property \"has composite compound\" is used.
<p>*/
	public ICompoundTreatment setCompound(ICompound compound);


/**
<p><b>scio:example</b>
<p>For alginate-hydrogel (ALG) preparation, a 2% (w/v) solution of alginate (Pronova UP LVM; NovaMatrix) in 150 mM sodium chloride (NaCl) was filtered with a sterile syringe filter.
<p>
<p><b>rdfs:label</b>
<p>has dosage
<p>
<p><b>rdfs:comment</b>
<p>Property of anaesthetic, postsurgical medication and compound. Points at supporting class \"Dosage\". Information about concentration of a substance or solution of e.g. cells. It can apply for a treatment substance or an anaesthetic or even an outcome measure if e.g. body fluid is investigated.
<p>
<p><b>scio:exampleSource</b>
<p>doi:10.1016/j.nbd.2014.03.018
<p>*/
	public ICompoundTreatment setDosage(IDosage dosage);


/**
<p><b>rdfs:label</b>
<p>has supplied composite compound
<p>
<p><b>rdfs:comment</b>
<p>Some combinatorial approaches consist of indivisible units like Schwann cell seeded guidance channels which are implanted as one unit. In order to model this approach, the property \"has composite compound\" is used.
<p>*/
	public ICompoundTreatment setSuppliedCompositeCompound(ICompound suppliedCompositeCompound);


}
