package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio;

import java.io.FileNotFoundException;
import java.util.List;
import de.hterhors.obie.ml.run.param.RunParameter.Builder;
import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.corpus.BigramCorpusProvider;
import de.hterhors.obie.ml.corpus.BigramInternalCorpus;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOParameterQuickAccess;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.InvestigationMethod;

public class CorpusInvestigation {

	public static void main(String[] args) throws FileNotFoundException {

		RunParameter param = SCIOParameterQuickAccess.getREParameter().build();

		BigramCorpusProvider corpusProvider = BigramCorpusProvider.loadCorpusFromFile(param);

		new CorpusInvestigation(param, corpusProvider.getTestCorpus());
	}

	final private RunParameter parameter;

	public CorpusInvestigation(RunParameter parameter, BigramInternalCorpus corpus) {
		/**
		 * Read test data
		 */

		List<OBIEInstance> documents = corpus.getInternalInstances();

		this.parameter = parameter;

		for (OBIEInstance doc : documents) {

			System.out.println(doc.getName());
			System.out.println(doc.getNamedEntityLinkingAnnotations().getAvailableClassTypes());
			for (Class<? extends IOBIEThing> investMethodClass : InvestigationMethod.class
					.getAnnotation(AssignableSubClasses.class).get()) {
				int i = doc.getNamedEntityLinkingAnnotations().getClassAnnotations(investMethodClass).size();
				System.out.println(investMethodClass + " : " + i);
			}

			System.out.println();
		}

	}

	public static void main2(String[] args) throws FileNotFoundException {

		// CorpusProvider corpusProvider = CorpusProvider
		// .restoreFromHardDrive(new
		// File("muc/corpus/Muc34_full_less_than_7_dev_v1.corpus"));
		//
		// /**
		// * QUICK HACK: for simple corpus reloading.
		// */
		// if (corpusProvider == null) {
		// ShuffleAndRedistributeConfig config = new
		// ShuffleAndRedistributeConfig(Muc34RegExNER.class, IIncident.class,
		// new File("muc/Muc34_full_v1_dev.bin"), true, 8, 0, 2, 100L, 6);
		// corpusProvider = new CorpusProvider(config);
		//
		// CorpusProvider.storeToHardDrive(new
		// File("muc/corpus/Muc34_full_less_than_7_dev_v1.corpus"),
		// corpusProvider);
		// }

		// ShuffleAndRedistributeConfig config = new
		// ShuffleAndRedistributeConfig(Muc34RegExNER.class, IDate.class,
		// new File("muc/Muc34_full_v1_dev.bin"), true, 8, 0, 2, 100L, 6);
		// CorpusProvider corpusProvider = new CorpusProvider(config);
		//
		// Muc34RegExNER ner = new Muc34RegExNER(new
		// HashSet<>(Arrays.asList(IDate.class)),
		// corpusProvider.getTrainingCorpus());
		//
		//

		RunParameter param = SCIOParameterQuickAccess.getREParameter().build();
		BigramCorpusProvider corpusProvider = BigramCorpusProvider.loadCorpusFromFile(param);

		// String documentContent = "SAN SALVADOR, 2 AUG 89 (ACAN - EFE) --
		// [EXCERPTS] THE SALVADORAN ARMY IS ON A STATE OF ALERT AND HAS
		// INCREASED ITS SURVEILLANCE IN SAN SALVADOR TO COUNTER A NEW GUERRILLA
		// OFFENSIVE, WHICH HAS CAUSED AT LEAST 48 MILITARY CASUALTIES OVER THE
		// PAST 24 HOURS IN SEVERAL ACTIONS THROUGHOUT THE COUNTRY.";

		// String documentContent = " MEXICO CITY (MEXICO), 2 MAY 90 (NOTIMEX)
		// -- [EXCERPTS] SAN";
		// documentContent = ContentCleaner.getInstance()
		// .process(DocumentDateUnifier.getInstance().process(documentContent));
		//
		// System.out.println(documentContent);
		//
		// ner.process(documentContent);
		//
		// ner.getOrDefaultAnnotations(Date.class, new
		// HashSet<>()).forEach(System.out::println);

		print(corpusProvider);

	}

	private static void print(BigramCorpusProvider corpusProvider) {

		BigramInternalCorpus corpus = corpusProvider.getTrainingCorpus();

		for (OBIEInstance doc : corpus.getInternalInstances()) {

			System.out.println("______________" + "Document: " + doc.getName() + "______________");
			System.out.println(doc.getContent());

			doc.getGoldAnnotation().getTemplateAnnotations()
					.forEach(s -> System.out.println(OBIEClassFormatter.format(s.getThing(), true)));

			for (Class<? extends IOBIEThing> availableClass : doc.getNamedEntityLinkingAnnotations()
					.getAvailableClassTypes()) {
				System.out.println("Available class: " + availableClass.getSimpleName() + ":");
				doc.getNamedEntityLinkingAnnotations().getClassAnnotations(availableClass)
						.forEach(a -> System.out.println(a));
				System.out.println("+++++++++++");
			}

			System.out
					.println("######################################################################################");
			System.out.println();
		}

		System.out.println();
		System.out.println();
		System.out.println();
	}
}
