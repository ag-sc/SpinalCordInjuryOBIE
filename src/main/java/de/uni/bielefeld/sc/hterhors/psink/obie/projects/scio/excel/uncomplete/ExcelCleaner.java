package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.excel.uncomplete;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.interfaces.IDatatype;
import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.utils.OBIEClassFormatter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SCIOSemanticInterpreter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AgeCategory;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AllenWeightDropDevice;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AneurysmClip;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnimalModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.AnimalSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Balloon;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Clip;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Compound;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.CompoundTreatment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DefinedExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.DeliveryMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.EpiduralClip;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Experiment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.FogartyBalloonCatheter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Forceps;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Gender;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.InfiniteHorizonImpactor;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Injury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.InjuryArea;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.InjuryDevice;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Investigation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.InvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Judgement;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.MASCISImpactor;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.NNumber;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.NYUImpactor;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Name;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.NumericValue;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.OSUImpactor;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Observation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.ObservedDifference;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Person;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Publication;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.PublicationYear;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.PubmedID;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Result;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.StatisticalTest;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.TemporalInterval;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Trend;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.UnivOfTriesteImpactor;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.Value;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.VertebralSegment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.WeightDrop;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IAgeCategory;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IAnimalModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IAnimalSpecies;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ICompound;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IDeliveryMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IDistance;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IDosage;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IDuration;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IForce;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IGender;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjury;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInjuryDevice;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IInvestigationMethod;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IJudgement;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.INNumber;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IObservedDifference;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IOrganismModel;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IPressure;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IResult;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITemporalInterval;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITreatment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ITrend;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IVolume;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IWeight;

/**
 * Reads and maps the Excel-Data (res/excel/Access_DB_Daten_TSV.csv) into the
 * newest version of the SCIO-Ontology. The data is converted to pre-build java
 * classes which are equivalent to the SCIO-OWL File.
 *
 * 
 * @author hterhors
 *
 *         Dec 14, 2016
 */
public class ExcelCleaner {

	public static void main(String[] args) throws Exception {

		System.out.println("#####START#####");
		ExcelCleaner e = new ExcelCleaner();

		Model model = e.convertToRDFModel();

		Lang outPutLang = Lang.NTRIPLES;

		e.writeModel(model, outPutLang);

	}

	/*
	 * Verbosity of the logging.
	 */
	final static int LOGGING_VERBOSITY_LEVEL = 2;

	/*
	 * Fields of the csv-file that are currently used in conversion.
	 */
	private static final int JUDGEMENT = 7;
	private static final int ANIMAL_TYPE = 10;
	private static final int ANIMAL_SUBTYPE = 11;
	private static final int ANIMAL_AGE = 12;
	private static final int ANIMAL_GENDER = 13;
	private static final int ANIMAL_WEIGHT = 14;
	private static final int INJURY_HEIGHT = 15;
	private static final int INJURY_TYPE = 16;
	private static final int OUTCOME_NAME = 17;
	// private static final int OUTCOME_FURTHER_DETAIL_NAME = 18;
	// private static final int OUTCOME_FURTHER_DETAIL_VALUE = 19;
	private static final int INJURY_LOCATION = 20;
	private static final int INJURY_DEVICE = 21;
	private static final int INJURY_DEVICE_DETAIL = 22;
	private static final int TREATMENT_DETAIL = 24;
	private static final int TREATMENT_APPLICATION = 25;
	private static final int TREATMENT_DOSAGE = 26;
	private static final int INJURED_TREATED = 27;
	private static final int INJURED_CONTROL = 28;
	private static final int TREND = 30;
	private static final int TIMEPOINT = 31;
	private static final int BBB_TREATED_VALUE = 35;
	private static final int BBB_CONTROL_VALUE = 36;

	/*
	 * Settings
	 */

	private final static String name = "Siekmann Testversion 2014_2018NB_V10-JK_original";

	// private static final String RESOURCE_FILE =
	// "excel/Access_DB_Daten_TSV.csv";
	private static final String RESOURCE_FILE = "excel/" + name + ".csv";

	public ExcelCleaner() throws Exception {

		readInExcelData();

		Map<String, List<IResult>> excelCorpus = new HashMap<>();

		for (Entry<String, Publication> pubs : PUBLICATION_FACTORY.entrySet()) {
			excelCorpus.put(pubs.getKey(), pubs.getValue().getDescribesExperiments().get(0).getResults());
		}

		Set<String> allProps = new HashSet<>();
		/*
		 * pubmedID , List of results (hashMap of property value pairs);
		 */

		Map<String, List<Map<String, String>>> data = new HashMap<>();

		/*
		 * prop, set of differnet values.
		 */
		Map<String, Set<String>> difVals = new HashMap<>();

		for (Entry<String, List<IResult>> dp : excelCorpus.entrySet()) {
			System.out.println(dp.getKey());

			data.putIfAbsent(dp.getKey(), new ArrayList<>());

			for (IResult r : dp.getValue()) {

				System.out.println(OBIEClassFormatter.format(r, true));

				Set<Props> list = new HashSet<>();
				getRec(list, null, r, "");

				Map<String, String> dMap = new HashMap<>();
				data.get(dp.getKey()).add(dMap);

				for (Props props : list) {
					if (props.classType2.isAnnotationPresent(DatatypeProperty.class)) {

						final String prop = props.propertyNameChain;
						final String value = props.type2SurfaceForms;
						difVals.putIfAbsent(prop, new HashSet<>());
						allProps.add(prop);
						dMap.put(prop, value);
						difVals.get(prop).add(value);
					} else {
						final String prop = props.propertyNameChain;
						final String value = props.classType2.getSimpleName();
						difVals.putIfAbsent(prop, new HashSet<>());
						allProps.add(prop);
						dMap.put(prop, value);
						difVals.get(prop).add(value);
					}

				}

			}
		}

		List<String> sortedProps = new ArrayList<>(allProps);

		// remove props where the value is the same everywhere

		for (Entry<String, Set<String>> pv : difVals.entrySet()) {
			if (pv.getValue().size() == 1) {
				sortedProps.remove(pv.getKey());
			}
		}
		Collections.sort(sortedProps);
		sortedProps.forEach(System.out::println);

		PrintStream ps = new PrintStream(new File("excel/" + name + "_Cleaned_v" + 63 + ".csv"));
		String header = "PubMedID";
		for (String string : sortedProps) {
			header += "\t" + string;
		}
		ps.println(header);

		for (Entry<String, List<Map<String, String>>> d : data.entrySet()) {

			for (Map<String, String> dpmap : d.getValue()) {
				String resultLine = "";
				resultLine += d.getKey() + "\t";
				for (String prop : sortedProps) {
					resultLine += dpmap.getOrDefault(prop, "") + "\t";
				}
				ps.println(resultLine.trim());
			}

		}

		ps.close();
		// SCIOCorpus corpus = new SCIOCorpus(excelCorpus, "excel",
		// SCIODataProvider.version);
		//
		// SCIOCorporaReaderWriter.writeData("gen/excel/ExcelData_v" +
		// SCIODataProvider.version + ".bin", corpus);

	}

	private void writeModel(Model model, Lang l) throws Exception {
		RDFDataMgr.write(
				new BufferedOutputStream(new FileOutputStream(
						new File("excel/" + name + "_FullExcel2RDFv" + 63 + "." + l.getName().toLowerCase()))),
				model, l);

	}

	class Props {

		/**
		 * The parent class type of the obie-template in a parent-child relation.
		 * Otherwise the first child of the pair.
		 */

		final Class<? extends IOBIEThing> classType1;

		/**
		 * The surface forms of the child-property. If distant supervision is enabled
		 * this set contains surface forms of all annotations that have the class type
		 * of the child-property. Else the set contains just a single surface form of
		 * that respective annotation.
		 */

		final String type1SurfaceForms;
		/**
		 * This describes the property chain which connects the parent class with the
		 * investigated child property. If it is not an parent-child relation this is
		 * null.
		 */

		final String propertyNameChain;

		/**
		 * The surface forms of the parent. If distant supervision is enabled this set
		 * contains surface forms of all annotations that have the class type of the
		 * child-property. Else the set contains just a single surface form of that
		 * respective annotation.
		 */

		final String type2SurfaceForms;

		/**
		 * The class type of the investigated child-property in a parent-child relation.
		 * Otherwise the second child of the pair.
		 */
		final Class<? extends IOBIEThing> classType2;

		public Props(Class<? extends IOBIEThing> classType1, Class<? extends IOBIEThing> classType2,
				String surfaceFormsType1, String surfaceFormsType2, String propertyNameChain) {
			this.classType1 = classType1;
			this.classType2 = classType2;
			this.type1SurfaceForms = surfaceFormsType1;
			this.type2SurfaceForms = surfaceFormsType2;
			this.propertyNameChain = propertyNameChain;
		}

	}

	private Set<Props> getRec(Set<Props> factors, final IOBIEThing parentClass, final IOBIEThing childClass,
			final String propertyNameChain) {
		String parentSurfaceForms = "";
		if (parentClass != null)
			parentSurfaceForms = parentClass.getTextMention();

		if (childClass == null) {
			return factors;
		}

		String childSurfaceForms;
		if (childClass.getClass().isAnnotationPresent(DatatypeProperty.class)) {
			childSurfaceForms = ((IDatatype) childClass).getInterpretedValue();
		} else {
			childSurfaceForms = childClass.getTextMention();
		}

		final Class<? extends IOBIEThing> childClassType = childClass == null ? null : childClass.getClass();
		/*
		 * Add factor for parent-child relation.
		 */
		if (parentClass != null) {
			factors.add(new Props(parentClass.getClass(), childClassType, parentSurfaceForms, childSurfaceForms,
					propertyNameChain));
		}
		/*
		 * Parent-Child relation
		 */
		Arrays.stream(childClass.getClass().getDeclaredFields())
				.filter(f -> f.isAnnotationPresent(OntologyModelContent.class)).forEach(field -> {
					field.setAccessible(true);
					try {
						if (field.isAnnotationPresent(RelationTypeCollection.class)) {
							for (IOBIEThing listObject : (List<IOBIEThing>) field.get(childClass)) {

								if (listObject instanceof Observation) {
									/*
									 * SEE HACK below!!
									 */

									if (((Observation) listObject).getBelongsToExperimentalGroup() == null) {
										/*
										 * TargetGroup
										 */
										factors.addAll(
												getRec(factors, childClass, listObject, "->targetExperimentalGroup"
														+ propertyNameChain + "->" + field.getName()));
									} else {
										/*
										 * Ref Group
										 */
										/*
										 * Remove here!
										 */
										((Observation) listObject).setBelongsToExperimentalGroup(null);
										factors.addAll(
												getRec(factors, childClass, listObject, "->referenceExperimentalGroup"
														+ propertyNameChain + "->" + field.getName()));
									}

								} else {
									factors.addAll(getRec(factors, childClass, listObject,
											propertyNameChain + "->" + field.getName()));
								}
							}
						} else {
							factors.addAll(getRec(factors, childClass, (IOBIEThing) field.get(childClass),
									propertyNameChain + "->" + field.getName()));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				});

		return factors;
	}

	/*
	 * PubmedID - Experiment
	 */
	private static final Map<String, Publication> PUBLICATION_FACTORY = new HashMap<>();

	private static final String PACKAGE_NAME_OF_SCIO_CLASSES = OntologyEnvironment
			.getInstance().OBIE_CLASSES_PACKAGE_NAME;

	/**
	 * Read line by line of the csv-data file and creates one result for each line.
	 * Results are grouped by publications iDs and collected.
	 * 
	 * @return the JenaModel that contains all Data
	 * @throws Exception
	 */
	public Model convertToRDFModel() throws Exception {

		Model model = ModelFactory.createDefaultModel();

		for (Entry<String, Publication> publication : PUBLICATION_FACTORY.entrySet()) {
			model.add(publication.getValue().getRDFModel(publication.getKey()));
		}
		return model;
	}

	public Map<String, Publication> convertToJavaInstances() {
		return PUBLICATION_FACTORY;
	}

	/**
	 * Reads the Excel-Data and converts it into java class instances. The instances
	 * are stored in PUBLICATION_FACTORY.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void readInExcelData() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(RESOURCE_FILE)));

		String line;
		int i = 0;

		while ((line = br.readLine()) != null) {

			i++;
			/*
			 * Skip header
			 */
			if (i <= 1)
				continue;

//			annotationID = "ExcelAnnotation_" + i;

			final String[] data = line.split("\t", -1);
			getPublicationInstance(data);

		}
		br.close();
	}

//	/**
//	 * Global access to current annotationID. (This is not the publication ID)
//	 */
//	private String annotationID;

	/**
	 * Creates a new publication model if there was no publication with the given
	 * publicationID.
	 * 
	 * @param line
	 * @return the publication for the given publication ID.
	 */
	private Publication getPublicationInstance(String[] line) {
		/*
		 * There is only one publication for each pubmedID. Each publication has exact
		 * one experiment. Each experiment has list of results.
		 */
		final String pubmedID = line[0];
		PUBLICATION_FACTORY.putIfAbsent(pubmedID, new Publication());

		if (PUBLICATION_FACTORY.get(pubmedID).getDescribesExperiments().isEmpty()) {
			PUBLICATION_FACTORY.get(pubmedID).addDescribesExperiment(new Experiment());
			PUBLICATION_FACTORY.get(pubmedID).setPublicationYear(new PublicationYear(line[5], line[5]));
			PUBLICATION_FACTORY.get(pubmedID).setPubmedID(new PubmedID(line[0], line[0]));
			PUBLICATION_FACTORY.get(pubmedID)
					.addAuthorPerson(new Person(null, null, line[3]).setName(new Name(line[3])));
		}

		PUBLICATION_FACTORY.get(pubmedID).getDescribesExperiments().get(0).addResult(buildResult(line));

		return PUBLICATION_FACTORY.get(pubmedID);
	}

	/**
	 * Builds a new Result-model given information of the current data-line. This
	 * methods fills all properties if information is available.
	 * 
	 * @param line
	 * @return a new Result.
	 */
	private IResult buildResult(String[] line) {
		Result r = new Result()
				.setInvestigation(new Investigation().setInvestigationMethod(reflectClassByName(line[OUTCOME_NAME],
						new InvestigationMethod(null, null,
								line[8] + " " + line[9] + " " + line[OUTCOME_NAME] + " " + line[18]),
						IInvestigationMethod.class)))
				.setJudgement(reflectClassByName(line[JUDGEMENT], new Judgement(null, null, line[JUDGEMENT]),
						IJudgement.class))
				.setReferenceExperimentalGroup(buildExperimentalReferenceGroup(line))
				.setTargetExperimentalGroup(buildExperimentalTargetGroup(line)).setTrend(buildTrend(line));

		/*
		 * HACK: Add ref group here and remove later while walking through results and
		 * collecting props and values. Helps to distinguishes between observation of
		 * reference group (this) and targetGroup(null)
		 */
		Observation o = new Observation().setBelongsToExperimentalGroup(buildExperimentalReferenceGroup(line))
				.setNumericValue(new NumericValue().setValue(line[BBB_CONTROL_VALUE].trim().isEmpty() ? null
						// QUICK HACK replace , to . for normalization
						: new Value(line[BBB_CONTROL_VALUE].replaceAll(",", "."), line[BBB_CONTROL_VALUE])));
		if (!o.isEmpty())
			r.addObservation(o);

		r.setStatisticalTest(new StatisticalTest());

		ITemporalInterval tp = new TemporalInterval();
		// reflectClassByName(line[TIMEPOINT], new TemporalInterval(),
		// ITemporalInterval.class);

		// tp.setEventBefore(((IEvent) ((IExperimentalGroup)
		// r.getTargetExperimentalGroup()).getInjuryModel()));
		tp.setDuration(reflectClassByName(line[TIMEPOINT], null, IDuration.class));
		// tp.setEventAfter(((IEvent) ((IExperimentalGroup)
		// r.getTargetExperimentalGroup()).getTreatmentTypes().get(0)));
		System.out.println("TP : " + tp);
		Observation o2 = new Observation()
				.setNumericValue(new NumericValue().setValue(line[BBB_TREATED_VALUE].trim().isEmpty() ? null
						// QUICK HACK replace , to . for normalization
						: new Value(line[BBB_TREATED_VALUE].replaceAll(",", "."), line[BBB_TREATED_VALUE])));
		if (!tp.isEmpty())
			o2.addTemporalInterval(tp);

		if (!o2.isEmpty())
			r.addObservation(o2);
		return r;
	}

	/**
	 * Builds a new Trend-model given information of the current data-line. This
	 * methods fills all properties if information is available.
	 * 
	 * @param line
	 * @return a new Trend-model.
	 */
	private ITrend buildTrend(String[] line) {
		return new Trend().setObservedDifference(reflectClassByName(line[TREND],
				new ObservedDifference(null, null, line[TREND]), IObservedDifference.class));
	}

	/**
	 * Builds a new ExperimentalTargetGroup-model given information of the current
	 * data-line. This methods fills all properties if information is available.
	 * 
	 * @param line
	 * @return a new AnalyzedExperimentalGroup-model.
	 */
	private IExperimentalGroup buildExperimentalTargetGroup(String[] line) {
		return new DefinedExperimentalGroup()
				.setNNumber(reflectClassByName(line[INJURED_TREATED],
						new NNumber(line[INJURED_TREATED], line[INJURED_TREATED]), INNumber.class))
				.setOrganismModel(buildAnimalModel(line))
				// .setGroupNumber(new GroupNumber())
				.setInjuryModel(buildInjuryModel(line)).addTreatmentType(buildTreatmentType(line));
	}

	/**
	 * Builds a new Treatment-model given information of the current data-line. This
	 * methods fills all properties if information is available.
	 * 
	 * @param line
	 * @return a new Treatment-model.
	 */
	private ITreatment buildTreatmentType(String[] line) {
		ITreatment treatmentType = reflectClassByName(line[TREATMENT_DETAIL],
				new CompoundTreatment(null, null, line[23] + " " + line[TREATMENT_DETAIL]), ITreatment.class)
						// .setFrequency(new Frequency())
						// .setApplicationInstrument(new
						// ApplicationInstrument())
						.setDeliveryMethod(reflectClassByName(line[TREATMENT_APPLICATION],
								new DeliveryMethod(null, null, line[TREATMENT_APPLICATION]), IDeliveryMethod.class))
						.setDuration(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IDuration.class));
		// .setInterval(new Interval()).setTreatmentLocation(new
		// AnatomicalLocation());

		if (treatmentType instanceof CompoundTreatment) {
			((CompoundTreatment) treatmentType).setCompound(reflectClassByName(line[TREATMENT_DETAIL],
					new Compound(null, null, line[23] + " " + line[TREATMENT_DETAIL]), ICompound.class));
			((CompoundTreatment) treatmentType)
					.setDosage(reflectClassByName(line[TREATMENT_DOSAGE], null, IDosage.class));
			// try {
			//
			// ((CompoundTreatment) treatmentType).setDosage(new Dosage(new
			// SemanticDosageBuilder()
			// .fillFromString(line[TREATMENT_DOSAGE]).build().toNormalizedString()));
			// System.out.println("ConvertedValue = " + new
			// SemanticDosageBuilder()
			// .fillFromString(line[TREATMENT_DOSAGE]).build().toNormalizedString());
			//
			// } catch (Exception e) {
			// System.err.println(e.getMessage());
			// ((CompoundTreatment) treatmentType).setDosage(new
			// Dosage(line[TREATMENT_DOSAGE]));
			//
			// }
		}

		return treatmentType;
	}

	/**
	 * Builds a new Injury-model given information of the current data-line. This
	 * methods fills all properties if information is available.
	 * 
	 * @param line
	 * @return a new Injury-model.
	 */
	private IInjury buildInjuryModel(String[] line) {
		return reflectClassByName(line[INJURY_TYPE], new Injury(null, null, line[INJURY_TYPE]), IInjury.class)
				// .addInjuryAnaesthesiaAnaesthetic(
				// new Anaesthetic().setDeliveryMethod(new
				// DeliveryMethod()).setDosage(new Dosage()))
				.setInjuryDevice(buildInjuryDevice(line))
				.setInjuryVertebralLocation(line[INJURY_HEIGHT].trim().isEmpty() ? null
						: new VertebralSegment(null, null, line[INJURY_HEIGHT]))
				// .setInjuryIntensity(new InjuryIntensity())
				.setInjuryArea(line[INJURY_LOCATION].trim().isEmpty() ? null
						: new InjuryArea(null, null, line[INJURY_LOCATION]));
		// .addInjuryPostsurgicalCareAnimalCareCondition(new
		// AnimalCareCondition())
		// .addMedicationDuringSurgery(new MedicationDuringSurgery());

	}

	/**
	 * Builds a new InjuryDevice-model given information of the current data-line.
	 * This methods fills all properties if information is available.
	 * 
	 * @param line
	 * @return a new InjuryDevice-model.
	 */
	private IInjuryDevice buildInjuryDevice(String[] line) {
		IInjuryDevice device = reflectClassByName(line[INJURY_DEVICE],
				new InjuryDevice(null, null, line[INJURY_DEVICE]), IInjuryDevice.class);

		if (device instanceof AneurysmClip) {
			AneurysmClip aneuyrismClip = (AneurysmClip) device;
			aneuyrismClip.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setWeight((IWeight) reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IWeight.class));
			return aneuyrismClip;
		} else if (device instanceof UnivOfTriesteImpactor) {
			UnivOfTriesteImpactor aneuyrismClip = (UnivOfTriesteImpactor) device;
			aneuyrismClip.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setWeight((IWeight) reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IWeight.class))
					.setDistance(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IDistance.class));

			return aneuyrismClip;
		} else if (device instanceof NYUImpactor) {
			NYUImpactor aneuyrismClip = (NYUImpactor) device;
			aneuyrismClip.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setWeight((IWeight) reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IWeight.class))
					.setDistance(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IDistance.class));
			return aneuyrismClip;
		} else if (device instanceof MASCISImpactor) {
			MASCISImpactor aneuyrismClip = (MASCISImpactor) device;
			aneuyrismClip.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setWeight(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IWeight.class))
					.setDistance(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IDistance.class));

			return aneuyrismClip;
		} else if (device instanceof WeightDrop) {
			WeightDrop aneuyrismClip = (WeightDrop) device;
			aneuyrismClip.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setWeight((IWeight) reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IWeight.class))
					.setDistance(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IDistance.class));

			return aneuyrismClip;
		} else if (device instanceof Balloon) {
			Balloon aneuyrismClip = (Balloon) device;
			aneuyrismClip.setPressure(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IPressure.class))
					.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setVolume(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IVolume.class));

			return aneuyrismClip;
		} else if (device instanceof InfiniteHorizonImpactor) {
			InfiniteHorizonImpactor aneuyrismClip = (InfiniteHorizonImpactor) device;
			aneuyrismClip.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setWeight((IWeight) reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IWeight.class))
					.setDistance(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IDistance.class));

			return aneuyrismClip;
		} else if (device instanceof FogartyBalloonCatheter) {
			FogartyBalloonCatheter aneuyrismClip = (FogartyBalloonCatheter) device;
			aneuyrismClip.setPressure(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IPressure.class))
					.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setVolume(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IVolume.class));

			return aneuyrismClip;
		} else if (device instanceof Clip) {
			Clip aneuyrismClip = (Clip) device;
			aneuyrismClip.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setWeight((IWeight) reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IWeight.class));
			return aneuyrismClip;
		} else if (device instanceof OSUImpactor) {
			OSUImpactor aneuyrismClip = (OSUImpactor) device;
			aneuyrismClip.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setWeight((IWeight) reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IWeight.class))
					.setDistance(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IDistance.class));

			return aneuyrismClip;
		} else if (device instanceof EpiduralClip) {
			EpiduralClip aneuyrismClip = (EpiduralClip) device;
			aneuyrismClip.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setWeight((IWeight) reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IWeight.class));
			return aneuyrismClip;
		} else if (device instanceof AllenWeightDropDevice) {
			AllenWeightDropDevice aneuyrismClip = (AllenWeightDropDevice) device;
			aneuyrismClip.setForce(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IForce.class))
					.setWeight((IWeight) reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IWeight.class))
					.setDistance(reflectClassByName(line[INJURY_DEVICE_DETAIL], null, IDistance.class));

			return aneuyrismClip;
		} else if (device instanceof Forceps) {
			Forceps forceps = (Forceps) device;
			return forceps;
//		} else if (device instanceof No5DumontForeceps) {
//			throw new NotImplementedException("Not yet implemented since migration to class vs individual");
//			No5DumontForeceps no5DumountForeceps = (No5DumontForeceps) device;
//			return no5DumountForeceps;
//		} else if (device instanceof Vibraknife) {
//			throw new NotImplementedException("Not yet implemented since migration to class vs individual");
//			Vibraknife vibraKnife = (Vibraknife) device;
//			return vibraKnife;
		} else {
			throw new NotImplementedException("Not yet implemented since migration to class vs individual");
//			return null;
		}

	}

	/**
	 * Builds a new OrganismModel-model given information of the current data-line.
	 * This methods fills all properties if information is available.
	 * 
	 * @param line
	 * @return a new OrganismModel-model.
	 */
	private IOrganismModel buildAnimalModel(String[] line) {
		IOrganismModel model = reflectClassByName(line[ANIMAL_TYPE],
				new AnimalModel(null, null,line[ANIMAL_SUBTYPE] + "-" + line[ANIMAL_TYPE]), IAnimalModel.class)
						.setOrganismSpecies(reflectClassByName(line[ANIMAL_SUBTYPE],
								new AnimalSpecies(null,null, line[ANIMAL_SUBTYPE]), IAnimalSpecies.class))
						.setAgeCategory(reflectClassByName(line[ANIMAL_AGE], new AgeCategory(null,null, line[ANIMAL_AGE]),
								IAgeCategory.class))
						.setGender(reflectClassByName(line[ANIMAL_GENDER], new Gender(null, null,line[ANIMAL_GENDER]),
								IGender.class))
						.setWeight(reflectClassByName(line[ANIMAL_WEIGHT], null, IWeight.class));

		return model;
	}

	/**
	 * Builds a new ExperimentalReferenceGroup-model given information of the
	 * current data-line. This methods fills all properties if information is
	 * available.
	 * 
	 * @param line
	 * @return a new IAnalyzedExperimentalGroup-model.
	 */
	private IExperimentalGroup buildExperimentalReferenceGroup(String[] line) {
		return new DefinedExperimentalGroup().setNNumber(reflectClassByName(line[INJURED_CONTROL],
				new NNumber(line[INJURED_CONTROL], line[INJURED_CONTROL]), INNumber.class));
		// .setOrganismModel(buildAnimalModel(line));
	}

	private <I extends ISCIOThing, C extends I> I reflectClassByName(String className, C defaultInstance,
			Class<I> superInterfaceOfDefaultInstance) {

		if (className.trim().isEmpty())
			return (I) defaultInstance;

		if (LOGGING_VERBOSITY_LEVEL > 3)
			System.out.println("Reflect class name by value: " + className);

		Object id = null;

		try {
			id = Class.forName(
					PACKAGE_NAME_OF_SCIO_CLASSES + ExcelMappingProvider.getInstance().mapping.get(className.trim()))
					.newInstance();
			Field annID = id.getClass().getDeclaredField("null");
			annID.setAccessible(true);
			annID.set(id, null);

			Field mention = id.getClass().getDeclaredField("textMention");
			mention.setAccessible(true);
			mention.set(id, className);
			try {
				// EField.DATATYPE_PROPERTY_VALUE_ANNOTATION_NAME.variableName
				Field value = id.getClass().getDeclaredField("semanticValue");
				value.setAccessible(true);

				String v = null;
				try {
					v = SCIOSemanticInterpreter.getInstance().interpret((Class<ISCIOThing>) id.getClass(), className)
							.asFormattedString();
					System.out.println("IDS: " + id.getClass().getSimpleName());
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

				if (v == null)
					v = className;

				if (LOGGING_VERBOSITY_LEVEL > 2)
					System.out.println("Converted \"" + className + "\" to: \"" + v + "\"");

				value.set(id, v);
			} catch (NoSuchFieldException e) {
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (LOGGING_VERBOSITY_LEVEL > 2)
				System.out.println("Found mapping. Try to cast to expected class:("
						+ superInterfaceOfDefaultInstance.getSimpleName() + ")");

			if (superInterfaceOfDefaultInstance.isAssignableFrom(id.getClass())) {
				if (LOGGING_VERBOSITY_LEVEL > 2)
					System.out.println("Successfully cast class to: " + ((I) id).getClass().getSimpleName());
				return (I) id;
			} else {
				if (LOGGING_VERBOSITY_LEVEL > 1)
					System.out.println(
							"###Could not cast (" + className + ") to class: " + ((I) id).getClass().getSimpleName()
									+ " expected class = " + superInterfaceOfDefaultInstance.getSimpleName());
			}
		} catch (ClassCastException | ClassNotFoundException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | NoSuchFieldException | SecurityException e) {

			if (LOGGING_VERBOSITY_LEVEL > 1)
				System.err.println("Could not map class name: '" + className + "', to "
						+ ExcelMappingProvider.getInstance().mapping.get(className.trim()));

			System.out.println(className);
			if (!ExcelMappingProvider.getInstance().mapping.get(className.trim()).equals("-"))
				e.printStackTrace();

		}
		return (I) defaultInstance;

	}

}
