package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.corpus;

import java.util.HashSet;
import java.util.Set;

import de.hterhors.obie.ml.ner.INamedEntitityLinker;
import de.hterhors.obie.ml.tools.BigramCorpusBuilder;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOOntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.nel.regex.SCIORegExNEL;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IResult;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

public class BigramCorpusCreator {

	public static void main(String[] args) throws Exception {

		Set<INamedEntitityLinker> linker = new HashSet<>();

		linker.add(new SCIORegExNEL(IResult.class));

		BigramCorpusBuilder.overrideCorpusFileIfExists = true;

		new BigramCorpusBuilder(SCIOProjectEnvironment.getInstance(), SCIOOntologyEnvironment.getInstance(), linker);

	}

}
