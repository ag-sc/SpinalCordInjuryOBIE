package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;

import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

public class BatchConvertAnnoDBToJavaBin {

	public static void main(String[] args) throws Exception {

		Map<String, Set<String>> fileNamesSortbyAnnotator = new HashMap<>();

		final String dir = "scio/annodb/";
		Arrays.stream(new File(dir).list()).forEach(file -> {
			final String fileName = FilenameUtils.getBaseName(file);
			final String annotator = fileName.split("_")[1];
			fileNamesSortbyAnnotator.putIfAbsent(annotator, new HashSet<>());
			fileNamesSortbyAnnotator.get(annotator).add(fileName);
		});

		List<ISCIOThing> dataCollection = new ArrayList<>();

		for (String fileName : fileNamesSortbyAnnotator.get("Jessica")) {
			System.out.println(fileName);
			File annotationFile = new File(dir + fileName + ".annodb");
			File rdfFile = new File(dir + fileName + ".n-triples");
			AnnoDBRDFReader<IOrganismModel> reader = new AnnoDBRDFReader<>(IOrganismModel.class, rdfFile,
					annotationFile);
			dataCollection.addAll(reader.get());
			for (ISCIOThing iscioThing : reader.get()) {
				System.out.println(OBIEClassFormatter.format(iscioThing, true));
			}
		}

		System.out.println(dataCollection.size());
		dataCollection.forEach(l -> System.out.println(OBIEClassFormatter.format(l, true)));
	}

}
