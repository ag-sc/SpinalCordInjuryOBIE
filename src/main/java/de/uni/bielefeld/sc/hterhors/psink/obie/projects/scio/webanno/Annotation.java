package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno;

import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

/**
 * Container for a Domain-Relation-Range
 * 
 * @author hterhors
 *
 *         Jul 14, 2016
 */
public class Annotation {

	/**
	 * The number (id) of the annotation in the overall document. If two or more
	 * tokens share the same annotationNumber then those tokens belong to the
	 * same annotation.
	 */
	final public int annotationID;

	/**
	 * The annotation type of the token that specifies the domain.
	 */
	final public Class<ISCIOThing> annotationTypeOfDomain;

	/**
	 * Enumber
	 */
	final public String ENumbers;

	/**
	 * Rnumber
	 */
	final public String RNumbers;

	public Annotation(int annotationID, Class<ISCIOThing> annotationTypeOfDomain, String eNumbers, String rNumbers) {
		this.annotationID = annotationID;
		this.annotationTypeOfDomain = annotationTypeOfDomain;
		ENumbers = eNumbers;
		RNumbers = rNumbers;
	}

	@Override
	public String toString() {
		return "Annotation [annotationID=" + annotationID + ", annotationTypeOfDomain=" + annotationTypeOfDomain
				+ ", ENumbers=" + ENumbers + ", RNumbers=" + RNumbers + "]";
	}

}
