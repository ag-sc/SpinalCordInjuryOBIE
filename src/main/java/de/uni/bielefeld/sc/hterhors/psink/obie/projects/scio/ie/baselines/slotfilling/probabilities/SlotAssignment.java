package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.baselines.slotfilling.probabilities;

import java.util.Map;

public class SlotAssignment implements Comparable<SlotAssignment> {

	public final Map<String, String> slotValues;
	public final double probability;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(probability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((slotValues == null) ? 0 : slotValues.hashCode());
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
		SlotAssignment other = (SlotAssignment) obj;
		if (Double.doubleToLongBits(probability) != Double.doubleToLongBits(other.probability))
			return false;
		if (slotValues == null) {
			if (other.slotValues != null)
				return false;
		} else if (!slotValues.equals(other.slotValues))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DoubleSlot [slotValues=" + slotValues + ", probability=" + probability + "]";
	}

	public SlotAssignment(Map<String, String> slotValues, double probability) {
		super();
		this.slotValues = slotValues;
		this.probability = probability;
	}

	@Override
	public int compareTo(SlotAssignment o) {
		return -Double.compare(probability, o.probability);
	}

}
