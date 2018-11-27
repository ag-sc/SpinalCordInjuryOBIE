package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.projects.AbstractProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

public class SCIOProjectEnvironment extends AbstractProjectEnvironment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static Logger log = LogManager.getRootLogger();

	private static SCIOProjectEnvironment instance = new SCIOProjectEnvironment();

//	final public static String OWL_CARDINALITY_ANNOTATION_NAME = "http://psink.de/scio/relationType";
//	final public static String CLINICAL_TERM_ANNOTATION_NAME = "http://psink.de/scio/clinicalTerm";

	final public File rawCorpusFile = new File("annodb/corpus/annodb_27082018_organismmodel_v64.bin");
//	final public File rawCorpusFile = new File("scio/annodb/corpus/annodb_27082018_injury_v64.bin");
//	final public File rawCorpusFile = new File("scio/annodb/corpus/annodb_27082018_treatment_v64.bin");

	final public File bigramCorpusFileDirectory = new File("bigram/corpus/");

	public static SCIOProjectEnvironment getInstance() {
		log.info("Return instance of " + SCIOProjectEnvironment.class.getName());
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
	public Class<? extends IOBIEThing> getOntologyThingInterface() {
		return ISCIOThing.class;
	}

	@Override
	public String getCorpusPrefix() {
		return "organism_model";
	}

}
