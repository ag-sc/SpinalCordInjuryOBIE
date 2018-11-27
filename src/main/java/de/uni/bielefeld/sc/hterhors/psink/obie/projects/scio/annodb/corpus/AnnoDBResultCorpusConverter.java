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
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf.AnnoDBRDFReader;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf.AnnoDBTextReader;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOOntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IResult;

/**
 * Converts data from anno db into an OBIE readable corpus.
 * 
 * @author hterhors
 *
 * @date Apr 16, 2018
 */
public class AnnoDBResultCorpusConverter {
	final static public String exportDate = "27082018";

	public static void main(String[] args) throws Exception {
		OntologyInitializer.initializeOntology(SCIOOntologyEnvironment.getInstance());

		String corpusName = "AnnoDBv" + SCIOOntologyEnvironment.getInstance().getOntologyVersion() + "Result";

		Map<String, Instance> trainingInstances = new HashMap<>();
		Map<String, Instance> developInstances = new HashMap<>();
		Map<String, Instance> testInstances = new HashMap<>();

		Map<String, Set<String>> fileNamesSortbyAnnotator = new HashMap<>();

		final String dir = "annodb/rawData/annodb_" + exportDate + "/";
		Arrays.stream(new File(dir).list()).forEach(file -> {
			String fileName = FilenameUtils.getBaseName(file);
			final String annotator = fileName.split("_")[1];
			fileName = fileName.split("_")[0];

			fileNamesSortbyAnnotator.putIfAbsent(annotator, new HashSet<>());
			fileNamesSortbyAnnotator.get(annotator).add(fileName);
		});
		final String annotator = "Jessica";
		for (String fileName : fileNamesSortbyAnnotator.get(annotator)) {

			System.out.println(fileName + "...");

			File annotationFile = new File(dir + fileName + "_" + annotator + ".annodb");
			File rdfFile = new File(dir + fileName + "_" + annotator + ".n-triples");

			String documentContent = new AnnoDBTextReader(dir + fileName + "_export.csv").read().getText();

			List<IResult> rawData = new ArrayList<>(new AnnoDBRDFReader(IResult.class, rdfFile, annotationFile).get());

			final Map<Class<? extends IOBIEThing>, List<IOBIEThing>> results = new HashMap<>();

			results.put(IResult.class, new ArrayList<>());

			for (IResult result : rawData) {

				System.out.println(OBIEClassFormatter.format(result));
				results.get(IResult.class).add(result);

			}
			if (!results.isEmpty())
				trainingInstances.put(fileName, new Instance(fileName, documentContent, results));

		}

		System.out.println(trainingInstances.size());

		OBIECorpus corpus = new OBIECorpus(trainingInstances, developInstances, testInstances, corpusName,
				SCIOOntologyEnvironment.getInstance().getOntologyVersion());

		final String corpusPrefix = "annodb_" + exportDate + "_";
		final long ontologyVersion = SCIOOntologyEnvironment.getInstance().getOntologyVersion();

		final Set<Class<? extends IOBIEThing>> rootClassTypes = new HashSet<>(Arrays.asList(IInjury.class));

		File file = CorpusFileTools.buildRawCorpusFile(new File("scio/annodb/corpus/"), corpusPrefix, rootClassTypes,
				ontologyVersion);

		corpus.writeRawCorpusData(file);

	}

}