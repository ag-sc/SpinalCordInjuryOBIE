package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.corpus;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.ml.ner.INamedEntitityLinker;
import de.hterhors.obie.ml.tools.BigramCorpusBuilder;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.annotation.extern.ExternalAnnotationsNEL;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.EntityRecognitionProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SCIOSemanticInterpreter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;

public class BigramCorpusCreator {

	public static void main(String[] args) throws Exception {

		OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());

		Set<INamedEntitityLinker> linker = new HashSet<>();

//		linker.add(new SCIORegExNEL(new HashSet<>(Arrays.asList(IAge.class, IWeight.class))));
//		linker.add(new SCIORegExNEL(IOrganismModel.class));

		File externalResourceDir = new File("nerl/annotations/");

		linker.add(new ExternalAnnotationsNEL<>(IOrganismModel.class, SCIOSemanticInterpreter.getInstance(),
				externalResourceDir));

//		linker.add(new GoldNEL<>(IOrganismModel.class, SCIOSemanticInterpreter.getInstance()));

		BigramCorpusBuilder.overrideCorpusFileIfExists = true;

		new BigramCorpusBuilder(EntityRecognitionProjectEnvironment.getInstance(), OntologyEnvironment.getInstance(),
				linker);

	}

}
