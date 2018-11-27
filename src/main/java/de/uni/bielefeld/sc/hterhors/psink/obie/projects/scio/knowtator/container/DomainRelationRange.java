package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container;

/**
 * This container is used to translate old SCIO relations into the new SCIO. A
 * mapping file maps the five values of this container to 5 new values using a
 * comprehensive mapping file!
 * 
 * This container holds information about a relation between a domain and a
 * range. next to the relation, it contains the type and the actual
 * mention-value of the domain, range respectively.
 * 
 * NOTE: It is crucial to store the mention information, since a translation to
 * the actual SCIO-Class may depend on the mention as well.
 * 
 * @author hterhors
 *
 *         Jul 19, 2016
 */
public class DomainRelationRange implements Comparable<DomainRelationRange> {

	/**
	 * The type of the domain.
	 */
	final public String domainClass;
	/**
	 * The mention-value of the domain.
	 */
	final public String domainValue;

	/**
	 * The relation between the domain and the value.
	 */
	final public String relationClass;

	/**
	 * The typ of the range.
	 */
	final public String rangeClass;

	/**
	 * The mention-value of the range.
	 */
	final public String rangeValue;

	public DomainRelationRange(String domainClass, String domainValue, String relationClass, String rangeClass,
			String rangeValue) {
		this.domainClass = domainClass;
		this.domainValue = domainValue;
		this.relationClass = relationClass;
		this.rangeClass = rangeClass;
		this.rangeValue = rangeValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainClass == null) ? 0 : domainClass.hashCode());
		result = prime * result + ((domainValue == null) ? 0 : domainValue.hashCode());
		result = prime * result + ((rangeClass == null) ? 0 : rangeClass.hashCode());
		result = prime * result + ((rangeValue == null) ? 0 : rangeValue.hashCode());
		result = prime * result + ((relationClass == null) ? 0 : relationClass.hashCode());
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
		DomainRelationRange other = (DomainRelationRange) obj;
		if (domainClass == null) {
			if (other.domainClass != null)
				return false;
		} else if (!domainClass.equals(other.domainClass))
			return false;
		if (domainValue == null) {
			if (other.domainValue != null)
				return false;
		} else if (!domainValue.equals(other.domainValue))
			return false;
		if (rangeClass == null) {
			if (other.rangeClass != null)
				return false;
		} else if (!rangeClass.equals(other.rangeClass))
			return false;
		if (rangeValue == null) {
			if (other.rangeValue != null)
				return false;
		} else if (!rangeValue.equals(other.rangeValue))
			return false;
		if (relationClass == null) {
			if (other.relationClass != null)
				return false;
		} else if (!relationClass.equals(other.relationClass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DomainRelationRange [domainClass=" + domainClass + "(" + domainValue + "), relationClass="
				+ relationClass + ", rangeClass=" + rangeClass + "(" + rangeValue + ")]";
	}

	@Override
	public int compareTo(DomainRelationRange o) {
		return this.domainClass.compareTo(o.domainClass);
	}

}
