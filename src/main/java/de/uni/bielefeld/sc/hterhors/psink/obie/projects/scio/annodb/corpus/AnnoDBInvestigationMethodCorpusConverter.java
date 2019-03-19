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
import de.hterhors.obie.ml.explorer.utils.ExplorationUtils;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf.AnnoDBRDFReader;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf.AnnoDBTextReader;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnimalModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnimalSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CatModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CatSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DogModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DogSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GuineaPigModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GuineaPigSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MinipigModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MinipigSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MonkeyModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MonkeySpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MouseModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MouseSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RabbitModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RabbitSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RatModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.RatSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;

/**
 * Converts data from anno db into an OBIE readable corpus.
 * 
 * @author hterhors
 *
 * @date Apr 16, 2018
 */
public class AnnoDBInvestigationMethodCorpusConverter {
	final static public String exportDate = "10012019";

	public static void main(String[] args) throws Exception {

		OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());

		String corpusName = "AnnoDBv" + OntologyEnvironment.getInstance().getOntologyVersion() + "FullOrgModel";

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

			if (fileName.contains("N224"))
				continue;

			if (fileName.contains("N223"))
				continue;

			System.out.println(fileName + "...");

			File annotationFile = new File(dir + fileName + "_" + annotator + ".annodb");
			File rdfFile = new File(dir + fileName + "_" + annotator + ".n-triples");

			String documentContent = new AnnoDBTextReader(dir + fileName + "_export.csv").read().getText();

			AnnoDBRDFReader<IInvestigationMethod> reader = new AnnoDBRDFReader<>(IInvestigationMethod.class, rdfFile,
					annotationFile);

			List<IInvestigationMethod> rawData = new ArrayList<>(reader.get());

			final Map<Class<? extends IOBIEThing>, List<IOBIEThing>> results = new HashMap<>();

			results.put(IInvestigationMethod.class, new ArrayList<>());

			for (IInvestigationMethod model : rawData) {

				results.get(IInvestigationMethod.class).add(model);

			}

			if (!results.isEmpty()) {

				trainingInstances.put(fileName, new Instance(fileName, documentContent, results));

			} else {
				System.out.println("Empty for: " + fileName);
			}

		}
		System.out.println(trainingInstances.size());

		OBIECorpus corpus = new OBIECorpus(trainingInstances, developInstances, testInstances, corpusName,
				OntologyEnvironment.getInstance().getOntologyVersion());

		final String corpusPrefix = "export_" + exportDate + "_";
		final long ontologyVersion = OntologyEnvironment.getInstance().getOntologyVersion();

		final Set<Class<? extends IOBIEThing>> rootClassTypes = new HashSet<>(
				Arrays.asList(IInvestigationMethod.class));

		File file = CorpusFileTools.buildRawCorpusFile(new File("annodb/corpus/"), corpusPrefix, rootClassTypes,
				ontologyVersion);

		corpus.writeRawCorpusData(file);

	}
}
