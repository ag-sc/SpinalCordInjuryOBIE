package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.corpus;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.ml.ner.INamedEntitityLinker;
import de.hterhors.obie.ml.tools.BigramCorpusBuilder;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.annotation.extern.ExternalAnnotationsNEL;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.annotation.regex.SCIORegExNEL;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.EntityRecognitionProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.SlotFillingProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SCIOSemanticInterpreter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IAge;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITreatment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IWeight;

public class BigramCorpusCreator {

	public static void main(String[] args) throws Exception {

		OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());

//		linker.add(new GoldNEL<>(IOrganismModel.class, SCIOSemanticInterpreter.getInstance()));

		BigramCorpusBuilder.overrideCorpusFileIfExists = true;

//		nerl();
		slotWithRegex();
//		slotWithNerl();
	}

	private static void nerl() throws Exception {
		Set<INamedEntitityLinker> linker = new HashSet<>();
		linker.add(new SCIORegExNEL(new HashSet<>(Arrays.asList(IAge.class, IWeight.class))));
		new BigramCorpusBuilder(EntityRecognitionProjectEnvironment.getInstance(), OntologyEnvironment.getInstance(),
				linker);
	}

	private static void slotWithNerl() throws Exception {
		Set<INamedEntitityLinker> linker = new HashSet<>();
		linker.add(new ExternalAnnotationsNEL<>(IOrganismModel.class, SCIOSemanticInterpreter.getInstance(),
				new File("nerl/annotations/")));
		new BigramCorpusBuilder(SlotFillingProjectEnvironment.getInstance(), OntologyEnvironment.getInstance(), linker);
	}

	private static void slotWithRegex() throws Exception {
//		Set<INamedEntitityLinker> linker = new HashSet<>();
//		linker.add(new SCIORegExNEL(IInjury.class));
//		new BigramCorpusBuilder(SlotFillingProjectEnvironment.getInstance(), OntologyEnvironment.getInstance(), linker);
//		Set<INamedEntitityLinker> linker = new HashSet<>();
//		linker.add(new SCIORegExNEL(IOrganismModel.class));
//		new BigramCorpusBuilder(SlotFillingProjectEnvironment.getInstance(), OntologyEnvironment.getInstance(), linker);
		Set<INamedEntitityLinker> linker = new HashSet<>();
		linker.add(new SCIORegExNEL(ITreatment.class));
		new BigramCorpusBuilder(SlotFillingProjectEnvironment.getInstance(), OntologyEnvironment.getInstance(), linker);
//		Set<INamedEntitityLinker> linker = new HashSet<>();
//		linker.add(new SCIORegExNEL(IOrganismModel.class));
//		new BigramCorpusBuilder(SlotFillingProjectEnvironment.getInstance(), OntologyEnvironment.getInstance(), linker);

	}

}
