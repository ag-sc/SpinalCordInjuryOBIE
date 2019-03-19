package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.tools;

import de.hterhors.obie.tools.owl2javabin.OWLToJavaBinaries;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;

public class CreateSCIOntologyJavaBinaries {

	public static void main(String[] args) throws Exception {
		OWLToJavaBinaries builder = new OWLToJavaBinaries(OntologyEnvironment.getInstance());

		builder.buildAndWriteClasses();

		builder.buildAndWriteInterfaces();

	}

}
