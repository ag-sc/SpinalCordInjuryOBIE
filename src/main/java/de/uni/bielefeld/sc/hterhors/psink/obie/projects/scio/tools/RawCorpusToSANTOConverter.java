package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.tools;

import java.io.File;

import de.hterhors.obie.core.tools.annodb.ConvertRawCorpusToSANTOFormat;
import de.hterhors.obie.core.tools.annodb.OWLToAnnoDBConfigurationConverter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOOntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOProjectEnvironment;

/**
 * Loads the raw corpus and transforms it into an SANTO format for file writing.
 * 
 * @author hterhors
 *
 */
public class RawCorpusToSANTOConverter {

	public static void main(String[] args) {

		final File parentCSVDirectory = new File("annodb/configuration/corpus");
		final File parentCorpusDirectory = new File("annodb/corpus");

		new OWLToAnnoDBConfigurationConverter(parentCSVDirectory, SCIOOntologyEnvironment.getInstance());

		new ConvertRawCorpusToSANTOFormat(parentCorpusDirectory, SCIOProjectEnvironment.getInstance());

	}

}
