package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container;

/**
 * This container holds information about a span of an annotation.
 * 
 * @author hterhors
 *
 *         Jul 19, 2016
 */
public class KnowtatorSpan {

	/**
	 * The onset of the annotation.
	 */
	final public long onset;
	/**
	 * The offset of the annotation.
	 */
	final public long offset;

	public KnowtatorSpan(long onset, long offset) {
		super();
		this.onset = onset;
		this.offset = offset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (offset ^ (offset >>> 32));
		result = prime * result + (int) (onset ^ (onset >>> 32));
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
		KnowtatorSpan other = (KnowtatorSpan) obj;
		if (offset != other.offset)
			return false;
		if (onset != other.onset)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KnowtatorSpan [onset=" + onset + ", offset=" + offset + "]";
	}

}
