package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.evaluation.PRF1;
import de.hterhors.obie.core.ontology.OntologyInitializer;
import de.hterhors.obie.ml.ner.INamedEntitityLinker;
import de.hterhors.obie.ml.run.AbstractOBIERunner;
import de.hterhors.obie.ml.run.DefaultEntityRecognitionRunner;
import de.hterhors.obie.ml.run.param.RunParameter;
import de.hterhors.obie.ml.templates.AbstractOBIETemplate;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import de.hterhors.obie.ml.variables.InstanceTemplateAnnotations;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.hterhors.obie.ml.variables.OBIEState;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.annotation.regex.SCIORegExNEL;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.run.parameter.EntityRecognitionParameter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.templates.nerl.ExampleTemplate;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IAge;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IWeight;

/**
 *
 * Preferred VM parameter: -Xmx12g -XX:+UseG1GC -XX:+UseStringDeduplication
 * 
 * @author hterhors
 *
 */
public class ExecuteEntityRecognition {

	protected static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) throws Exception {

		new ExecuteEntityRecognition();

	}

	public ExecuteEntityRecognition() throws Exception {
		{
			OntologyInitializer.initializeOntology(OntologyEnvironment.getInstance());
		}
		/*
		 * Detailed printing includes char-on and offset.
		 */
		OBIEClassFormatter.printDetailed = true;

		/*
		 * Start extraction procedure
		 */
		run();
	}

	private void run() throws Exception {

		log.info("Start entity recognition...");

		/**
		 * Store total training time.
		 */
		final long trt;

		/**
		 * Predefined set of parameter for the Runner. These parameter can be changed
		 * e.g. number of epochs, regularization etc.
		 */
		RunParameter.Builder parameterBuilder = EntityRecognitionParameter.getPreDefinedParameterBuilder();

		/**
		 * TODO: Set of templates for feature generation. Implement and add more
		 * sophisticated templates.
		 */
		final Set<Class<? extends AbstractOBIETemplate<?>>> templates = new HashSet<>();

		templates.add(ExampleTemplate.class);

		/*
		 * TODO: add these templates and observe the score.
		 */
//		templates.add(TokenContextTemplate.class);
//		templates.add(InterTokenTemplate.class);

		/*
		 * Add templates and build parameter.
		 */
		final RunParameter parameter = parameterBuilder.setTemplates(templates).build();

		/**
		 * The runner object, that starts the entity recognition process given the
		 * parameter.
		 */
		final AbstractOBIERunner runner = new DefaultEntityRecognitionRunner(parameter);

		/*
		 * Check if the model exists. If so, load , if not train the model.
		 */
		if (runner.modelExists()) {
			/*
			 * If the model exists, load the model from the file system. The model location
			 * is specified in the parameter and the environment.
			 */
			/**
			 * Load
			 */
			runner.loadModel();
			trt = 0;
		} else {
			/*
			 * If the model does not exists train. The model is automatically stored to the
			 * file system to the given model location!
			 */
			final long trainingTime = System.currentTimeMillis();
			/**
			 * Train
			 */
			runner.train();
			trt = (System.currentTimeMillis() - trainingTime);
			log.info("Total training time: " + trt + " ms.");
		}
		/**
		 * Store test time.
		 */
		final long testTime = System.currentTimeMillis();

		/**
		 * Evaluate the trained model on the test data.
		 */
		final PRF1 overallPRF1 = runner.evaluateNERLOnTest();

		final long tet = (System.currentTimeMillis() - testTime);

		log.info("--------" + runner.getParameter().runID + "--------");
		log.info("Evaluation results on test data:\n" + overallPRF1);
		log.info("Total training time: " + trt + " ms.");
		log.info("Total test time: " + tet + " ms.");
		log.info("Total time: "
				+ Duration.between(Instant.now(), Instant.ofEpochMilli(System.currentTimeMillis() + (trt + tet))));

		log.info("Write predictions to file...");

		Set<INamedEntitityLinker> linker = new HashSet<>();
		linker.add(new SCIORegExNEL(new HashSet<>(Arrays.asList(IAge.class, IWeight.class))));

		List<OBIEInstance> cleanInstance = new ArrayList<>();

		for (OBIEInstance oi : runner.corpusProvider.getFullCorpus().getInternalInstances()) {
			cleanInstance.add(new OBIEInstance(oi.getName(), oi.getContent(), new InstanceTemplateAnnotations(),
					oi.rootClassTypes));
		}

		List<OBIEState> predictions = runner.predictInstancesBatch(cleanInstance, linker);

		File outputDir = new File("nerl/annotations/");
		writePredictions(outputDir, predictions);

	}

	private void writePredictions(File outputDir, List<OBIEState> predictions) throws IOException {

		for (OBIEState sampledInstance : predictions) {
			int globalAnnotationID = 0;
			PrintStream ps = new PrintStream(
					outputDir + "/" + sampledInstance.getInstance().getName() + "_system.annodb");
			ps.println("# AnnotationID, ClassType, DocCharOnset(incl), DocCharOffset(excl), Text, Meta, Instances");
			for (IETmplateAnnotation annotation : sampledInstance.getCurrentIETemplateAnnotations().getAnnotations()) {
				ps.println(toAnnotDBFormat(globalAnnotationID, annotation));
				globalAnnotationID++;
			}
			ps.close();
		}

	}

	private String toAnnotDBFormat(int globalAnnotationID, IETmplateAnnotation annotation) {
		StringBuilder b = new StringBuilder();
		b.append(globalAnnotationID);
		b.append(", ");
		b.append(annotation.getThing().getLabel());
		b.append(", ");
		b.append(annotation.getThing().getCharacterOnset());
		b.append(", ");
		b.append(annotation.getThing().getCharacterOffset());
		b.append(", ");
		b.append("\"" + annotation.getThing().getTextMention() + "\"");
		b.append(", ");
		b.append("\"\"");
		b.append(", ");
		return b.toString();
	}

}
