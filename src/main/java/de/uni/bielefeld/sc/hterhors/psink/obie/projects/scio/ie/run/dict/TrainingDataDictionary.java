package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.dict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVReader;

import de.hterhors.obie.ml.ner.dictionary.AbstractDictionary;
import de.hterhors.obie.ml.ner.dictionary.DictionaryEntry;
import de.hterhors.obie.ml.ner.dictionary.IDictionary;

public class TrainingDataDictionary extends AbstractDictionary {

	private final Map<String, Set<DictionaryEntry>> entries = new HashMap<>();

	public TrainingDataDictionary(final File dictFile) {
		super(null);
		try {

			final CSVReader reader = new CSVReader(new BufferedReader(new FileReader(dictFile)), '\t');

			final Iterator<String[]> it = reader.iterator();

			for (Iterator<String[]> line = it; it.hasNext();) {
				final String[] data = line.next();

				final String name = data[0];

				for (String syn : data[1].split("\\|")) {
					entries.putIfAbsent(name, new HashSet<>());
					entries.get(name).add(toDictionaryEntry(name, syn));
				}

			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public List<IDictionary> getSubDictionaries() {
		return Collections.emptyList();
	}

	@Override
	public Map<String, Set<DictionaryEntry>> getEntries() {
		return entries;
	}

}
