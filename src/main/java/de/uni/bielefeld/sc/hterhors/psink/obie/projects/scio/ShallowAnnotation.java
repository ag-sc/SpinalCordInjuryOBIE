package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import de.hterhors.obie.core.OntologyAnalyzer;
import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.core.tools.corpus.OBIECorpus;
import de.hterhors.obie.core.tools.corpus.OBIECorpus.Instance;
import de.hterhors.obie.ml.corpus.BigramCorpusProvider;
import de.hterhors.obie.ml.corpus.BigramInternalCorpus;
import de.hterhors.obie.ml.ner.INamedEntitityLinker;
import de.hterhors.obie.ml.ner.NERLClassAnnotation;
import de.hterhors.obie.ml.ner.NERLIndividualAnnotation;
import de.hterhors.obie.ml.ner.NamedEntityLinkingAnnotations;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOOntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOParameterQuickAccess;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.nel.regex.SCIORegExNEL;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Compound;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DeliveryMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Dosage;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Duration;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.ExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Injury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.InjuryDevice;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.InvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Judgement;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Location;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Treatment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.VertebralLocation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IResult;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITrend;

/**
 * This class contains a set of classes that are used in the shallow annotation.
 * 
 * The shallow annotation guideline is a construct to save time and resources in
 * the annotation process. We limited the slots to fill, to a specific subset.
 * However, for each slot we consider the full range of possible slot fillers *
 * as potential candidates
 * 
 * The collection provided in this class mirrors the subset that are described
 * in the annotation guideline document.
 * 
 * 
 * @author hterhors
 *
 * @date Aug 8, 2018
 */
public class ShallowAnnotation {

	public static void main(String[] args) throws IOException {
		{
			OntologyInitializer.initializeOntology(SCIOOntologyEnvironment.getInstance());
		}

		BigramCorpusProvider proivider = BigramCorpusProvider.loadCorpusFromFile(SCIOParameterQuickAccess
				.getREParameter().setOntologyEnvironment(SCIOOntologyEnvironment.getInstance()).build());

		new ShallowAnnotation(proivider.getFullCorpus());
	}

	private Set<Class<? extends IOBIEThing>> shallowClasses;

	private Set<AbstractIndividual> shallowIndividuals;

	private PrintStream ps = System.out;

	private OBIECorpus rawCorpus;

	public ShallowAnnotation(BigramInternalCorpus corpus) throws IOException {

		ps = new PrintStream("nerl");

		buildShallowGuildeline();

		SCIOProjectEnvironment env = SCIOProjectEnvironment.getInstance();

		this.rawCorpus = OBIECorpus.readRawCorpusData(env.getRawCorpusFile());

		SCIORegExNEL linker = new SCIORegExNEL(IResult.class);

		rawCorpus.getInstances().values().parallelStream().forEach(instance -> {

			System.out.println(instance.name);

			try {
				final String instanceContent = instance.content;

				NamedEntityLinkingAnnotations.Builder annotationbuilder = new NamedEntityLinkingAnnotations.Builder();

				annotationbuilder.addClassAnnotations(linker.annotateClasses(instanceContent));
				annotationbuilder.addIndividualAnnotations(linker.annotateIndividuals(instanceContent));

				NamedEntityLinkingAnnotations nerl = annotationbuilder.build();

				for (Class<? extends IOBIEThing> clazz : nerl.getAvailableClassTypes()) {
					if (shallowClasses.contains(clazz))
						formatClassAnnotations(instance.name, nerl.getClassAnnotations(clazz));
				}
				for (AbstractIndividual individual : nerl.getAvailableIndividualTypes()) {
					if (shallowIndividuals.contains(individual))
						formatIndividualAnnotations(instance.name, nerl.getIndividualAnnotations(individual));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		ps.flush();
		ps.close();
	}

	/*
	 * N049_Wang_2011_21299884_anna.annodb RatSpecies 26434 26437 rat
	 * 
	 */
	private synchronized void formatClassAnnotations(final String instanceName,
			Set<NERLClassAnnotation> classAnnotations) {

		for (NERLClassAnnotation nerlClassAnnotation : classAnnotations) {

			ps.println(instanceName + "\t" + nerlClassAnnotation.classType.getSimpleName() + "\t"
					+ nerlClassAnnotation.getOnset() + "\t"
					+ (nerlClassAnnotation.getOnset() + nerlClassAnnotation.getText().length()) + "\t"
					+ nerlClassAnnotation.getText());

		}

	}

	private synchronized void formatIndividualAnnotations(final String instanceName,
			Set<NERLIndividualAnnotation> individualAnnotations) {

		for (NERLIndividualAnnotation nerlIndividualAnnotation : individualAnnotations) {

			ps.println(instanceName + "\t" + nerlIndividualAnnotation.relatedIndividual.name + "\t"
					+ nerlIndividualAnnotation.getOnset() + "\t"
					+ (nerlIndividualAnnotation.getOnset() + nerlIndividualAnnotation.getText().length()) + "\t"
					+ nerlIndividualAnnotation.getText());
		}
	}

	private void buildShallowGuildeline() {
		shallowClasses = new HashSet<>();
		shallowIndividuals = new HashSet<>();
		/**
		 * Treatment
		 */
		shallowClasses.addAll(Arrays.asList(Treatment.class.getAnnotation(AssignableSubClasses.class).get()));
		shallowClasses.addAll(Arrays.asList(Duration.class));
		shallowClasses.addAll(Arrays.asList(DeliveryMethod.class.getAnnotation(AssignableSubClasses.class).get()));
		shallowClasses.addAll(Arrays.asList(Location.class.getAnnotation(AssignableSubClasses.class).get()));
		shallowClasses.addAll(Arrays.asList(Dosage.class));
		shallowClasses.addAll(Arrays.asList(Compound.class.getAnnotation(AssignableSubClasses.class).get()));

		/**
		 * OrganismModel
		 */
		shallowClasses.addAll(OntologyAnalyzer.getRelatedClassTypesUnderRoot(IOrganismModel.class));

		/**
		 * Injury
		 */
		shallowClasses.addAll(Arrays.asList(Injury.class.getAnnotation(AssignableSubClasses.class).get()));
		shallowClasses.addAll(Arrays.asList(VertebralLocation.class.getAnnotation(AssignableSubClasses.class).get()));
		shallowClasses.addAll(Arrays.asList(InjuryDevice.class.getAnnotation(AssignableSubClasses.class).get()));
		shallowClasses.add(GroupName.class);

		/**
		 * ExperimentalGroup
		 */
		shallowClasses.addAll(Arrays.asList(ExperimentalGroup.class.getAnnotation(AssignableSubClasses.class).get()));
		shallowClasses.addAll(Arrays.asList(ExperimentalGroup.class.getAnnotation(AssignableSubClasses.class).get()));

		/**
		 * Result
		 */
		shallowClasses.addAll(Arrays.asList(Judgement.class.getAnnotation(AssignableSubClasses.class).get()));
		shallowClasses.addAll(Arrays.asList(InvestigationMethod.class.getAnnotation(AssignableSubClasses.class).get()));
		shallowClasses.addAll(OntologyAnalyzer.getRelatedClassTypesUnderRoot(ITrend.class));

		for (Class<? extends IOBIEThing> shallowClass : shallowClasses) {
			try {
				if (shallowClass.newInstance().getIndividualFactory() != null) {
					shallowIndividuals.addAll(shallowClass.newInstance().getIndividualFactory().getIndividuals());
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}

		}

	}
}
