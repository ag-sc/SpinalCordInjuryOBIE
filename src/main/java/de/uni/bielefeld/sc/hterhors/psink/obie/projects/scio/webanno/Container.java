package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno;

public class Container {

	public String classAnnotationName;
	public String relationAnnotation;
	public Integer charOffsetOfDomainAnnotation;
	public Integer charOnsetDomainAnnotation;
	public Integer charOffsetOfAnnotation;
	public Integer charOnsetAnnotation;
	public String annotationID;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotationID == null) ? 0 : annotationID.hashCode());
		result = prime * result + ((charOffsetOfAnnotation == null) ? 0 : charOffsetOfAnnotation.hashCode());
		result = prime * result
				+ ((charOffsetOfDomainAnnotation == null) ? 0 : charOffsetOfDomainAnnotation.hashCode());
		result = prime * result + ((charOnsetAnnotation == null) ? 0 : charOnsetAnnotation.hashCode());
		result = prime * result + ((charOnsetDomainAnnotation == null) ? 0 : charOnsetDomainAnnotation.hashCode());
		result = prime * result + ((classAnnotationName == null) ? 0 : classAnnotationName.hashCode());
		result = prime * result + ((relationAnnotation == null) ? 0 : relationAnnotation.hashCode());
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
		Container other = (Container) obj;
		if (annotationID == null) {
			if (other.annotationID != null)
				return false;
		} else if (!annotationID.equals(other.annotationID))
			return false;
		if (charOffsetOfAnnotation == null) {
			if (other.charOffsetOfAnnotation != null)
				return false;
		} else if (!charOffsetOfAnnotation.equals(other.charOffsetOfAnnotation))
			return false;
		if (charOffsetOfDomainAnnotation == null) {
			if (other.charOffsetOfDomainAnnotation != null)
				return false;
		} else if (!charOffsetOfDomainAnnotation.equals(other.charOffsetOfDomainAnnotation))
			return false;
		if (charOnsetAnnotation == null) {
			if (other.charOnsetAnnotation != null)
				return false;
		} else if (!charOnsetAnnotation.equals(other.charOnsetAnnotation))
			return false;
		if (charOnsetDomainAnnotation == null) {
			if (other.charOnsetDomainAnnotation != null)
				return false;
		} else if (!charOnsetDomainAnnotation.equals(other.charOnsetDomainAnnotation))
			return false;
		if (classAnnotationName == null) {
			if (other.classAnnotationName != null)
				return false;
		} else if (!classAnnotationName.equals(other.classAnnotationName))
			return false;
		if (relationAnnotation == null) {
			if (other.relationAnnotation != null)
				return false;
		} else if (!relationAnnotation.equals(other.relationAnnotation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Container [classAnnotationName=" + classAnnotationName + ", relationAnnotation=" + relationAnnotation
				+ ", charOffsetOfDomainAnnotation=" + charOffsetOfDomainAnnotation + ", charOnsetDomainAnnotation="
				+ charOnsetDomainAnnotation + ", charOffsetOfAnnotation=" + charOffsetOfAnnotation
				+ ", charOnsetAnnotation=" + charOnsetAnnotation + ", annotationID=" + annotationID + "]";
	}

}
