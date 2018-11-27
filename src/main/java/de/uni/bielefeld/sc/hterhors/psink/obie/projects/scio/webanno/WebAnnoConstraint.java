package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno;

import de.hterhors.obie.core.owlreader.container.OntologyClass;
import de.hterhors.obie.core.owlreader.container.OntologySlotData;

public class WebAnnoConstraint {

	public final OntologyClass governor;
	public final OntologyClass dependent;
	public final OntologySlotData label;

	public WebAnnoConstraint(OntologyClass governor, OntologyClass dependent, OntologySlotData label) {
		super();
		this.governor = governor;
		this.dependent = dependent;
		this.label = label;
	}

	@Override
	public String toString() {
		return "Constrain [governor=" + governor + ", dependent=" + dependent + ", label=" + label + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dependent == null) ? 0 : dependent.hashCode());
		result = prime * result + ((governor == null) ? 0 : governor.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		WebAnnoConstraint other = (WebAnnoConstraint) obj;
		if (dependent == null) {
			if (other.dependent != null)
				return false;
		} else if (!dependent.equals(other.dependent))
			return false;
		if (governor == null) {
			if (other.governor != null)
				return false;
		} else if (!governor.equals(other.governor))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

}
