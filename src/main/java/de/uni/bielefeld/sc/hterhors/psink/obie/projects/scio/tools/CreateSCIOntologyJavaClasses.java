package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.tools;

import de.hterhors.obie.tools.owl2javabin.OWLToJavaBinaries;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOOntologyEnvironment;

public class CreateSCIOntologyJavaClasses {

	public static void main(String[] args) throws Exception {

		OWLToJavaBinaries builder = new OWLToJavaBinaries(SCIOOntologyEnvironment.getInstance());

		builder.buildAndWriteClasses();

		builder.buildAndWriteInterfaces();

	}

}
