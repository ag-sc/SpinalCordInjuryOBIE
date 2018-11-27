package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie;

import de.hterhors.obie.core.owlreader.OWLReader;
import de.hterhors.obie.tools.owl2javabin.OWLToJavaBinaries;

public class CreateSCIOntologyJavaBinaries {

	public static void main(String[] args) throws Exception {
		OWLToJavaBinaries builder = new OWLToJavaBinaries(SCIOOntologyEnvironment.getInstance());

		builder.buildAndWriteClasses();

		builder.buildAndWriteInterfaces();

	}

}
