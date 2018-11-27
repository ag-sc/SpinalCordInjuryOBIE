package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;

public class RDFRelatedAnnotation {

	final public String textMention;
	final public int onset;
	final public int offset;
	final public String annotationID;
	final public Triple linkID;
//	final public Class<? extends IOBIEThing> classType;

	public RDFRelatedAnnotation(String textMention, int onset, int offset, String annotationID, Triple linkID
			) {
		super();
		this.textMention = textMention;
		this.onset = onset;
		this.offset = offset;
		this.annotationID = annotationID;
		this.linkID = linkID;
//		this.classType = classType;
	}

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotationID == null) ? 0 : annotationID.hashCode());
		result = prime * result + ((linkID == null) ? 0 : linkID.hashCode());
		result = prime * result + offset;
		result = prime * result + onset;
		result = prime * result + ((textMention == null) ? 0 : textMention.hashCode());
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
		RDFRelatedAnnotation other = (RDFRelatedAnnotation) obj;
		if (annotationID == null) {
			if (other.annotationID != null)
				return false;
		} else if (!annotationID.equals(other.annotationID))
			return false;
		if (linkID == null) {
			if (other.linkID != null)
				return false;
		} else if (!linkID.equals(other.linkID))
			return false;
		if (offset != other.offset)
			return false;
		if (onset != other.onset)
			return false;
		if (textMention == null) {
			if (other.textMention != null)
				return false;
		} else if (!textMention.equals(other.textMention))
			return false;
		return true;
	}

}
