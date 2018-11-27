package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container;

/**
 * This container is used to map the groupNameValue to its corresponding
 * ExperimentalGroup.
 * 
 * It is necessary since, Results and ExperimentalGroups do not share a direct
 * connection in Knowtator, they are rather connected trough the GroupName.
 * 
 * Since Annotations in Knowtator are project-based unique it is crucial to
 * store the paperID and the annotator as well.
 * 
 * @author hterhors
 *
 *         Jul 19, 2016
 */
public class ExperimentalGroupName {

	/**
	 * The id of the paper.
	 */
	final public String paperID;
	/**
	 * The annotator of the annotation.
	 */
	final public EKnowtatorAnnotator annotator;

	/**
	 * The groupNameValue of the annotation that connects an ExerimentalGroup.
	 */
	final public String groupNameValue;

	public ExperimentalGroupName(String paper, EKnowtatorAnnotator annotator, String groupNameValue) {
		this.paperID = paper;
		this.annotator = annotator;
		this.groupNameValue = groupNameValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotator == null) ? 0 : annotator.hashCode());
		result = prime * result + ((paperID == null) ? 0 : paperID.hashCode());
		result = prime * result + ((groupNameValue == null) ? 0 : groupNameValue.hashCode());
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
		ExperimentalGroupName other = (ExperimentalGroupName) obj;
		if (annotator == null) {
			if (other.annotator != null)
				return false;
		} else if (!annotator.equals(other.annotator))
			return false;
		if (paperID == null) {
			if (other.paperID != null)
				return false;
		} else if (!paperID.equals(other.paperID))
			return false;
		if (groupNameValue == null) {
			if (other.groupNameValue != null)
				return false;
		} else if (!groupNameValue.equals(other.groupNameValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroupNameMappingKey [paper=" + paperID + ", annotator=" + annotator + ", groupNameValue="
				+ groupNameValue + "]";
	}

}
