package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;

import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.corpus.CorpusFileTools;
import de.hterhors.obie.core.tools.corpus.OBIECorpus;
import de.hterhors.obie.core.tools.corpus.OBIECorpus.Instance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf.AnnoDBRDFReader;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf.AnnoDBTextReader;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITreatment;

/**
 * Converts data from anno db into an OBIE readable corpus.
 * 
 * @author hterhors
 *
 * @date Apr 16, 2018
 */
public class AnnoDBTreatmentModelCorpusConverter {
	final static public String exportDate = "10012019";

	public static void main(String[] args) throws Exception {
		
		OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());

		String corpusName = "AnnoDBv" + OntologyEnvironment.getInstance().getOntologyVersion()
				+ "FullTreatmentModel";

		Map<String, Instance> trainingInstances = new HashMap<>();
		Map<String, Instance> developInstances = new HashMap<>();
		Map<String, Instance> testInstances = new HashMap<>();

		Map<String, Set<String>> fileNamesSortbyAnnotator = new HashMap<>();

		final String dir = "annodb/rawData/export_" + exportDate + "/";
		Arrays.stream(new File(dir).list()).forEach(file -> {
			String fileName = FilenameUtils.getBaseName(file);
			final String annotator = fileName.split("_")[1];
			fileName = fileName.split("_")[0];

			fileNamesSortbyAnnotator.putIfAbsent(annotator, new HashSet<>());
			fileNamesSortbyAnnotator.get(annotator).add(fileName);
		});
		final String annotator = "Jessica";
		for (String fileName : fileNamesSortbyAnnotator.get(annotator)) {
		
			if (fileName.contains("N001"))
				continue;

//			if (fileName.contains("N243"))
//				continue;

//			if (fileName.contains("N226"))
//				continue;
//			if (fileName.contains("N183"))
//				continue;
//			if (fileName.contains("N025"))
//				continue;
//			if (fileName.contains("N130"))
//				continue;
//			if (fileName.contains("N031"))
//				continue;
//			if (fileName.contains("N164"))
//				continue;
			if (fileName.contains("N156"))
				continue;
			if (fileName.contains("N076"))
				continue;
			if (fileName.contains("N197"))
				continue;
//			if (fileName.contains("N227"))
//				continue;
			if (fileName.contains("N196"))
				continue;
			if (fileName.contains("N188"))
				continue;
			if (fileName.contains("N021"))
				continue;
			
//			if (fileName.contains("N224"))
//				continue;

//			if (fileName.contains("N223"))
//				continue;
			
			System.out.println(fileName + "...");

			File annotationFile = new File(dir + fileName + "_" + annotator + ".annodb");
			File rdfFile = new File(dir + fileName + "_" + annotator + ".n-triples");

			String documentContent = new AnnoDBTextReader(dir + fileName + "_export.csv").read().getText();

			List<ITreatment> rawData = new ArrayList<>(
					new AnnoDBRDFReader<ITreatment>(ITreatment.class, rdfFile, annotationFile).get());

			final Map<Class<? extends IOBIEThing>, List<IOBIEThing>> results = new HashMap<>();

			results.put(ITreatment.class, new ArrayList<>());

			for (ITreatment treatment : rawData) {

				System.out.println(treatment);
				results.get(ITreatment.class).add(treatment);

			}
			trainingInstances.put(fileName, new Instance(fileName, documentContent, results));

		}

		System.out.println(trainingInstances.size());

		OBIECorpus corpus = new OBIECorpus(trainingInstances, developInstances, testInstances, corpusName,
				OntologyEnvironment.getInstance().getOntologyVersion());

		final String corpusPrefix = "export_" + exportDate + "_";
		final long ontologyVersion = OntologyEnvironment.getInstance().getOntologyVersion();

		final Set<Class<? extends IOBIEThing>> rootClassTypes = new HashSet<>(Arrays.asList(ITreatment.class));

		File file = CorpusFileTools.buildRawCorpusFile(new File("annodb/corpus/"), corpusPrefix, rootClassTypes,
				ontologyVersion);

		corpus.writeRawCorpusData(file);

	}
}
