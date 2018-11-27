package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno.iaa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the onset and offset of an annotation.
 * 
 * @author hterhors
 *
 *         Mar 9, 2017
 */
public class KappaCategory implements Comparable<KappaCategory> {

	final private List<String> categories;

	public String getCategoryString() {
		return categories.stream().reduce("", String::concat);
	}

	public KappaCategory(String category) {

		this.categories = new ArrayList<>();
		this.categories.add(category);
	}

	public KappaCategory append(final String category) {
		this.categories.add(category);
		Collections.sort(categories);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
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
		KappaCategory other = (KappaCategory) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		return true;
	}

	@Override
	public int compareTo(KappaCategory kc) {
		return getCategoryString().compareTo(kc.getCategoryString());
	}

	@Override
	public String toString() {
		return "KappaCategory [categories=" + categories + "]";
	}

}
