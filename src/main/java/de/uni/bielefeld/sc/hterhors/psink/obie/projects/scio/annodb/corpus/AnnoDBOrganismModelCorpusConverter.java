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
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;

/**
 * Converts data from anno db into an OBIE readable corpus.
 * 
 * @author hterhors
 *
 * @date Apr 16, 2018
 */
public class AnnoDBOrganismModelCorpusConverter {
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

//			if (fileName.contains("N224"))
//				continue;
//
//			if (fileName.contains("N223"))
//				continue;

			System.out.println(fileName + "...");

			File annotationFile = new File(dir + fileName + "_" + annotator + ".annodb");
			File rdfFile = new File(dir + fileName + "_" + annotator + ".n-triples");

			String documentContent = new AnnoDBTextReader(dir + fileName + "_export.csv").read().getText();

			AnnoDBRDFReader<IOrganismModel> reader = new AnnoDBRDFReader<>(IOrganismModel.class, rdfFile,
					annotationFile);

			List<IOrganismModel> rawData = new ArrayList<>(reader.get());

			final Map<Class<? extends IOBIEThing>, List<IOBIEThing>> results = new HashMap<>();

			results.put(IOrganismModel.class, new ArrayList<>());

			for (IOrganismModel orgModel : rawData) {

				/*
				 * FIXME: ANNOTATION FIX: During annotating the data the type of the organism
				 * model was not annotated, just the species. Thus, set the Type of the
				 * organismmOdel is applied now.
				 */
				if (orgModel.getOrganismSpecies() != null) {
					boolean ind = orgModel.getOrganismSpecies().getIndividual() != null;
					/**
					 * Rat
					 */

					if (orgModel.getOrganismSpecies().getClass() == RatSpecies.class) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new RatModel(), orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("WistarRat")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new RatModel(), orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("SpragueDawleyRat")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new RatModel(), orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("LongEvansRat")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new RatModel(), orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("ListerHoodedRat")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new RatModel(), orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("FischerRat")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new RatModel(), orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("LewisRat")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new RatModel(), orgModel);

						/**
						 * Mouse
						 */

					} else if (orgModel.getOrganismSpecies().getClass() == MouseSpecies.class) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new MouseModel(),
								orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("C57_BL6_Mouse")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new MouseModel(),
								orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("CD2_Mouse")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new MouseModel(),
								orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("BALB_C_Mouse")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new MouseModel(),
								orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("CD1_Mouse")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new MouseModel(),
								orgModel);
						/**
						 * GuineaPig
						 */
					} else if (orgModel.getOrganismSpecies().getClass() == GuineaPigSpecies.class) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new GuineaPigModel(),
								orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("HartleyGuineaPig")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new GuineaPigModel(),
								orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("NewZealandRabbit")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new RabbitModel(),
								orgModel);
						/**
						 * Cat
						 */
					} else if (orgModel.getOrganismSpecies().getClass() == CatSpecies.class) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new CatModel(), orgModel);

						/**
						 * Dog
						 */
					} else if (orgModel.getOrganismSpecies().getClass() == DogSpecies.class) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new DogModel(), orgModel);
					} else if (orgModel.getOrganismSpecies().getClass() == AnimalSpecies.class) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new AnimalModel(),
								orgModel);
					} else if (orgModel.getOrganismSpecies().getClass() == RabbitSpecies.class) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new RabbitModel(),
								orgModel);

						/**
						 * MiniPig
						 */
					} else if (orgModel.getOrganismSpecies().getClass() == MinipigSpecies.class) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new MinipigModel(),
								orgModel);
					} else if (orgModel.getOrganismSpecies().getClass() == MonkeySpecies.class) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new MonkeyModel(),
								orgModel);
					} else if (ind && orgModel.getOrganismSpecies().getIndividual().name.equals("MacaqueMonkey")) {
						orgModel = (IOrganismModel) ExplorationUtils.copyOntologyModelFields(new MonkeyModel(),
								orgModel);
					} else {
						System.out.println("ERRR");
					}
				}
				results.get(IOrganismModel.class).add(orgModel);

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

		final Set<Class<? extends IOBIEThing>> rootClassTypes = new HashSet<>(Arrays.asList(IOrganismModel.class));

		File file = CorpusFileTools.buildRawCorpusFile(new File("annodb/corpus/"), corpusPrefix, rootClassTypes,
				ontologyVersion);

		corpus.writeRawCorpusData(file);

	}
}
