package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container;

/**
 * Container to store a Knowtator annotation as unique. Since the Knowtator id
 * is only unique in a single project we need to add the paperID as well as the
 * annotator. In addition this container contains the type of the id as well. *
 * 
 * @author hterhors
 *
 *         Jul 19, 2016
 */
public class UniqueAnnotation {

	/**
	 * The annotator
	 */
	final public EKnowtatorAnnotator annotator;

	/**
	 * The id of the paper the annotation came from.
	 */
	final public String paperID;

	/**
	 * The type of the annotation.
	 */
	final public String classType;

	/**
	 * The project-based unique id of the annotation
	 */
	final public String id;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotator == null) ? 0 : annotator.hashCode());
		result = prime * result + ((classType == null) ? 0 : classType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((paperID == null) ? 0 : paperID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniqueAnnotation other = (UniqueAnnotation) obj;
		if (annotator == null) {
			if (other.annotator != null)
				return false;
		} else if (!annotator.equals(other.annotator))
			return false;
		if (classType == null) {
			if (other.classType != null)
				return false;
		} else if (!classType.equals(other.classType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (paperID == null) {
			if (other.paperID != null)
				return false;
		} else if (!paperID.equals(other.paperID))
			return false;
		return true;
	}

	public UniqueAnnotation(EKnowtatorAnnotator annotator, String paperID, String classType, String id) {
		super();
		this.annotator = annotator;
		this.paperID = paperID;
		this.classType = classType;
		this.id = id;
	}

	@Override
	public String toString() {
		return classType + "(" + id + ")";
	}

}
