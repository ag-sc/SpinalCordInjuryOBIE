package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.projects.AbstractProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

public class EntityRecognitionProjectEnvironment extends AbstractProjectEnvironment<ISCIOThing> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static Logger log = LogManager.getRootLogger();

	private static EntityRecognitionProjectEnvironment instance = new EntityRecognitionProjectEnvironment();

//	final public static String OWL_CARDINALITY_ANNOTATION_NAME = "http://psink.de/scio/relationType";
//	final public static String CLINICAL_TERM_ANNOTATION_NAME = "http://psink.de/scio/clinicalTerm";

//	final public File rawCorpusFile = new File("annodb/corpus/export_10012019_investigationmethod_v64.bin");
//	final public File rawCorpusFile = new File("annodb/corpus/export_10012019_result_v64.bin");
	final public File rawCorpusFile = new File("annodb/corpus/nerl/org_model_10012019_v64.bin");
//	final public File rawCorpusFile = new File("annodb/corpus/export_10012019_injury_v64.bin");
//	final public File rawCorpusFile = new File("annodb/corpus/export_10012019_treatment_v64.bin");

	final public File bigramCorpusFileDirectory = new File("bigram/corpus/nerl/");

	public static EntityRecognitionProjectEnvironment getInstance() {
		log.info("Return instance of " + EntityRecognitionProjectEnvironment.class.getName());
		return instance;
	}

	@Override
	public File getRawCorpusFile() {
		return rawCorpusFile;
	}

	@Override
	public File getBigramCorpusFileDirectory() {
		return bigramCorpusFileDirectory;
	}

	@Override
	public Class<? extends ISCIOThing> getOntologyThingInterface() {
		return ISCIOThing.class;
	}

	@Override
	public String getCorpusName() {
		return "org_model_nerl_v_10012019";
	}

}
