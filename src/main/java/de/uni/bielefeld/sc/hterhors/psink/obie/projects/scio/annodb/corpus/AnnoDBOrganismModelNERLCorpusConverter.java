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
import de.hterhors.obie.core.ontology.container.Slot;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.corpus.CorpusFileTools;
import de.hterhors.obie.core.tools.corpus.OBIECorpus;
import de.hterhors.obie.core.tools.corpus.OBIECorpus.Instance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf.AnnoDBRDFReader;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus.rdf.AnnoDBTextReader;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

/**
 * Converts data from anno db into an OBIE readable corpus.
 * 
 * @author hterhors
 *
 * @date Apr 16, 2018
 */
public class AnnoDBOrganismModelNERLCorpusConverter {
	final static public String exportDate = "10012019";

	public static void main(String[] args) throws Exception {

		OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());

		String corpusName = "NERL_v" + OntologyEnvironment.getInstance().getOntologyVersion() + "_OrgModel";

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
		final Set<Class<? extends IOBIEThing>> rootClassTypes = new HashSet<>();
		for (String fileName : fileNamesSortbyAnnotator.get(annotator)) {

			System.out.println(fileName + "...");

			File annotationFile = new File(dir + fileName + "_" + annotator + ".annodb");
			File rdfFile = new File(dir + fileName + "_" + annotator + ".n-triples");

			String documentContent = new AnnoDBTextReader(dir + fileName + "_export.csv").read().getText();

			AnnoDBRDFReader<IOrganismModel> reader = new AnnoDBRDFReader<>(IOrganismModel.class, rdfFile,
					annotationFile);

			List<IOBIEThing> rawData = new ArrayList<>(reader.get());

			final Map<Class<? extends IOBIEThing>, List<IOBIEThing>> results = new HashMap<>();

			for (IOBIEThing orgModel : rawData) {

				for (Slot slot : orgModel.getInvestigatedSlots()) {
					if (slot != null && slot.getSingleValue() != null) {
						results.putIfAbsent(slot.getSingleValue().getClass(), new ArrayList<>());
						results.get(slot.getSingleValue().getClass()).add(slot.getSingleValue());
						rootClassTypes.add(slot.getSingleValue().getClass());
					}
				}

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

		final String corpusPrefix = "org_model_" + exportDate ;
		final long ontologyVersion = OntologyEnvironment.getInstance().getOntologyVersion();

		File file = CorpusFileTools.buildRawCorpusFile(new File("annodb/corpus/nerl/"), corpusPrefix, rootClassTypes,
				ontologyVersion);

		corpus.writeRawCorpusData(file);

	}
}
