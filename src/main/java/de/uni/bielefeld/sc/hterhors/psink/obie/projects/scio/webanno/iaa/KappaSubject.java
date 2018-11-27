package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.iaa;

/**
 * Represents the onset and offset of an annotation.
 * 
 * @author hterhors
 *
 *         Mar 9, 2017
 */
public class KappaSubject implements Comparable<KappaSubject> {

	public final int onset;
	public final int offset;

	public KappaSubject(int onset, int offset) {
		this.onset = onset;
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "KappaSubject [onset=" + onset + ", offset=" + offset + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + offset;
		result = prime * result + onset;
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
		KappaSubject other = (KappaSubject) obj;
		if (offset != other.offset)
			return false;
		if (onset != other.onset)
			return false;
		return true;
	}

	@Override
	public int compareTo(KappaSubject o) {
		return Integer.compare(onset, o.onset) == 0 ? Integer.compare(offset, o.offset)
				: Integer.compare(onset, o.onset);
	}

}
