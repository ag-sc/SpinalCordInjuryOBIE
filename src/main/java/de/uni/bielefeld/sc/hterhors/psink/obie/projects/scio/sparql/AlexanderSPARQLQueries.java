package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.sparql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

/**
 *
 * @author ABOROWI
 */
public class AlexanderSPARQLQueries {
	public static class SPARQLQuery {
		public final String queryName;
		public final String queryString;
		public final String[] varNames;

		public SPARQLQuery(String queryName, String queryString, String... varNames) {
			this.queryName = queryName;
			this.queryString = queryString;
			this.varNames = varNames;
		}
	}

	public static final SPARQLQuery QUERY_ANIMALMODELTYPES = new SPARQLQuery("AnimalModelTypes",
			"SELECT DISTINCT ?amt WHERE {" + "?a     <http://localhost:8080/organismModel>           ?om     ."
					+ "?om    <http://www.w3.org/2000/01/rdf-schema#:type>    ?amt    ." + "} ORDER BY ?amt",
			"amt");

	public static final SPARQLQuery QUERY_INVESTIGATIONMETHODTYPES = new SPARQLQuery("InvestigationMethodTypes",
			"SELECT DISTINCT ?imt WHERE {" + "?a     <http://localhost:8080/investigationMethod>     ?im     ."
					+ "?im    <http://www.w3.org/2000/01/rdf-schema#:type>    ?imt    ." + "} ORDER BY ?imt",
			"imt");

	public static final SPARQLQuery QUERY_JUDGEMENTTYPES = new SPARQLQuery("JudgementTypes",
			"SELECT DISTINCT ?jt WHERE {" + "?a <http://localhost:8080/judgement>               ?j  ."
					+ "?j <http://www.w3.org/2000/01/rdf-schema#:type>    ?jt ." + "}",
			"jt");

	public static final SPARQLQuery QUERY_TREATMENTTYPES = new SPARQLQuery("TreatmentTypes",
			"SELECT DISTINCT ?tt WHERE {" + "?a <http://localhost:8080/_treatmentTypes>         ?t  ."
					+ "?t <http://www.w3.org/2000/01/rdf-schema#:type>    ?tt ." + "}",
			"tt");

	public static final SPARQLQuery QUERY_INJURYMODELTYPES = new SPARQLQuery("InjuryModelTypes",
			"SELECT DISTINCT ?imt WHERE {" + "?a     <http://localhost:8080/injuryModel>             ?im     ."
					+ "?im    <http://www.w3.org/2000/01/rdf-schema#:type>    ?imt    ." + "} ORDER BY ?imt",
			"imt");

	public static final SPARQLQuery QUERY_RESULTS = new SPARQLQuery("Results", "SELECT ?r WHERE {"
			+ "?r    <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/Result>  ." + "} ORDER BY ?r",
			"r");

	public static final SPARQLQuery QUERY_INVESTIGATIONMETHODTYPE_JUDGEMENTTYPE = new SPARQLQuery(
			"InvestigationMethodType vs. JudgementType",
			"SELECT ?imt ?jt WHERE {" + "?r     <http://localhost:8080/investigationMethod>     ?im     ."
					+ "?im    <http://www.w3.org/2000/01/rdf-schema#:type>    ?imt    ."
					+ "?r     <http://localhost:8080/judgement>               ?j      ."
					+ "?j     <http://www.w3.org/2000/01/rdf-schema#:type>    ?jt     ." + "} ORDER BY ?imt",
			"imt", "jt");

	public static final SPARQLQuery QUERY_EXPERIMENT_INVESTIGATIONMETHODTYPE_JUDGEMENTTYPE = new SPARQLQuery(
			"Experiment vs. InvestigationMethodType vs. JudgementType",
			"SELECT ?e ?imt ?jt WHERE {"
					+ "?e     <http://www.w3.org/2000/01/rdf-schema#:type>    <http://localhost:8080/Experiment>  ."
					+ "?e     <http://localhost:8080/_results>                ?r                                  ."
					+ "?r     <http://localhost:8080/investigationMethod>     ?im                                 ."
					+ "?im    <http://www.w3.org/2000/01/rdf-schema#:type>    ?imt                                ."
					+ "?r     <http://localhost:8080/judgement>               ?j                                  ."
					+ "?j     <http://www.w3.org/2000/01/rdf-schema#:type>    ?jt                                 ."
					+ "} ORDER BY ?e ?imt",
			"e", "imt", "jt");

	/*
	 * Ist das Judgement(Judgement) eines Tests (Result) in dem eine funktionale
	 * investigation method (FunctionalTest) benutzt worden ist, abhängig vom
	 * Geschlecht des Tieres.
	 */
	public static final SPARQLQuery QUERY = new SPARQLQuery("FunctionalTest: Judgement vs. Gender",
			"SELECT ?r ?jt ?eg ?gt WHERE {"
					+ "?r     <http://www.w3.org/2000/01/rdf-schema#:type>    <http://localhost:8080/Result>      ."
					+ "?r     <http://localhost:8080/judgement>               ?j                                  ."
					+ "?j     <http://www.w3.org/2000/01/rdf-schema#:type>    ?jt                                 ."
					+ "?r     <http://localhost:8080/investigationMethod>     ?im                                 ."
					+ "{?im   <http://www.w3.org/2000/01/rdf-schema#:type>    <http://localhost:8080/GaitTest>    .}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/LocomotorTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/PhysiologyTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/MotorReflexTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/MotorTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/NeurologicScalesTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/ElectrophysiologyTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/PainTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/SensoryTest>.}."
					+ "?r <http://localhost:8080/targetGroup> ?eg."
					+ "?eg    <http://localhost:8080/organismModel>           ?om                                 ."
					+ "?om    <http://localhost:8080/gender>                  ?g                                  ."
					+ "?g     <http://www.w3.org/2000/01/rdf-schema#:type>    ?gt                                 ."
					+ "?g     <http://www.w3.org/2000/01/rdf-schema#:type>    ?gt                                 ."
					+ "}",
			"r", "jt", "eg", "gt");

	/*
	 * Which investigation methods on rats, show a positive result while applying a
	 * compound treatment.
	 */
	public static final SPARQLQuery QUERY_1 = new SPARQLQuery(
			"Rats & CompoundTreatment & positive Judgement: InvestigationMethod",
			"SELECT DISTINCT ?imt WHERE {"
					+ "?r     <http://www.w3.org/2000/01/rdf-schema#:type>    <http://localhost:8080/Result>              ."
					+ "?r     <http://localhost:8080/judgement>               ?j                                          ."
					+ "?j     <http://www.w3.org/2000/01/rdf-schema#:type>    <http://localhost:8080/Positive>            ."
					+ "?r     <http://localhost:8080/investigationMethod>     ?im                                         ."
					+ "?im    <http://www.w3.org/2000/01/rdf-schema#:type>    ?imt                                        ."
					+ "?r <http://localhost:8080/targetGroup> ?eg."
					+ "?eg    <http://localhost:8080/_treatmentTypes>         ?t                                          ."
					+ "?t     <http://www.w3.org/2000/01/rdf-schema#:type>    <http://localhost:8080/CompoundTreatment>   ."
					+ "?eg    <http://localhost:8080/organismModel>           ?om                                         ."
					+ "{?om   <http://www.w3.org/2000/01/rdf-schema#:type>    <http://localhost:8080/LongEvansRatModel>   .}"
					+ "UNION{?om <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/SpragueDawleyRatModel>}"
					+ "UNION{?om <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/WistarRatModel>}."
					+ "} ORDER BY ?imt",
			"imt");

	/*
	 * Using a functional test, how is the outcome(Positive, Negative,Neutral)
	 * distribution of between Female, Male WistarRats and Female, Male
	 * SpragueDawleyRats?
	 */
	public static final SPARQLQuery QUERY_2 = new SPARQLQuery(
			"Number of Positive/Negative/Neutral outcomes of female/male WistarRats/SpragueDawleyRats using FunctionalTests: ",
			"SELECT ?om ?gt ?jt (COUNT(*) AS ?count)  WHERE {"
					+ "?r     <http://www.w3.org/2000/01/rdf-schema#:type>    <http://localhost:8080/Result>                  ."
					+ "?r     <http://localhost:8080/investigationMethod>     ?im                                             ."
					+ "{?im   <http://www.w3.org/2000/01/rdf-schema#:type>    <http://localhost:8080/GaitTest>                .}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/LocomotorTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/PhysiologyTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/MotorReflexTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/MotorTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/NeurologicScalesTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/ElectrophysiologyTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/PainTest>.}"
					+ "UNION{?im <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/NeuroprotectionTest>.}."
					+ "?r     <http://localhost:8080/judgement>               ?j                                              ."
					+ "?j     <http://www.w3.org/2000/01/rdf-schema#:type>    ?jt                                             ."
					+ "?r <http://localhost:8080/targetGroup> ?eg."
					+ "?eg    <http://localhost:8080/organismModel>           ?om                                             ."
					+ "{?om   <http://www.w3.org/2000/01/rdf-schema#:type>    <http://localhost:8080/SpragueDawleyRatModel>   .}"
					+ "UNION{?om <http://www.w3.org/2000/01/rdf-schema#:type> <http://localhost:8080/WistarRatModel>}."
					+ "?om    <http://localhost:8080/gender>                  ?g                                  ."
					+ "?g     <http://www.w3.org/2000/01/rdf-schema#:type>    ?gt                                 ."
					+ "} GROUP BY ?om ?gt ?jt",
			"om", "gt", "jt", "count");

	/**
	 * @param args the command line arguments
	 * @throws java.io.FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Model model = ModelFactory.createDefaultModel();
		model.read(new FileInputStream("gen/FullExcel2RDFv39.n-triples"), null, "N-TRIPLES");

		// AnimalModelTypes:
		// executeQueryAndPrintResults(model,
		// SPARQLQueries.QUERY_ANIMALMODELTYPES);

		// InvestigationMethodTypes:
		// executeQueryAndPrintResults(model,
		// SPARQLQueries.QUERY_INVESTIGATIONMETHODTYPES);

		// JudgementTypes:
		// executeQueryAndPrintResults(model,
		// SPARQLQueries.QUERY_JUDGEMENTTYPES);

		// TreatmentTypes:
		// executeQueryAndPrintResults(model,
		// SPARQLQueries.QUERY_TREATMENTTYPES);

		// InjuryModelTypes:
		// executeQueryAndPrintResults(model,
		// SPARQLQueries.QUERY_INJURYMODELTYPES);

		// Results:
		// executeQueryAndPrintResults(model, SPARQLQueries.QUERY_RESULTS);

		// InvestigationMethodType vs. JudgementType:
		// executeQueryAndPrintResults(model,
		// SPARQLQueries.QUERY_INVESTIGATIONMETHODTYPE_JUDGEMENTTYPE);

		// Experiment vs. InvestigationMethodType vs. JudgementType:
		executeQueryAndPrintResults(model, QUERY);
	}

	public static void executeQueryAndPrintResults(Model model, SPARQLQuery sparqlQuery) {
		Query query = QueryFactory.create(sparqlQuery.queryString);

		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
			ResultSet results = qexec.execSelect();
			printResults(results, sparqlQuery);
		}
	}

	public static void printResults(ResultSet results, SPARQLQuery sparqlQuery) {
		System.out.println(sparqlQuery.queryName + ":");
		QuerySolution solution;
		int counter;
		for (counter = 0; results.hasNext(); counter++) {
			solution = results.nextSolution();

			for (String varName : sparqlQuery.varNames) {
				try {
					System.out.print(solution.getResource(varName) + "\t");
				} catch (ClassCastException e) {
					System.out.println(solution.getLiteral(varName) + "\t");
				}
			}
			System.out.println();
		}
		System.out.println("--> " + counter + " results found!");
	}
}
