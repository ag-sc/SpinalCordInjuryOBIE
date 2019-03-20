package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.corpus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.ml.ner.INamedEntitityLinker;
import de.hterhors.obie.ml.tools.BigramCorpusBuilder;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.annotation.regex.SCIORegExNEL;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.EntityRecognitionProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IAge;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IWeight;

public class BigramCorpusCreator {

	public static void main(String[] args) throws Exception {

		OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());

		Set<INamedEntitityLinker> linker = new HashSet<>();

//		linker.add(new SCIORegExNEL(new HashSet<>(Arrays.asList(IAge.class, IWeight.class))));
		linker.add(new SCIORegExNEL(IOrganismModel.class));

//		linker.add(new GoldNEL<>(IOrganismModel.class, SCIOSemanticInterpreter.getInstance()));

		BigramCorpusBuilder.overrideCorpusFileIfExists = true;

		new BigramCorpusBuilder(EntityRecognitionProjectEnvironment.getInstance(), OntologyEnvironment.getInstance(),
				linker);

	}

}
