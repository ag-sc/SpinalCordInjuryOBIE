package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.sparql;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;

import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.excel.uncomplete.ExcelCorpusConverter;

public class SPARQLQueryExcelAccess {

	public static void main(String[] args) throws Exception {

		Model model = ModelFactory.createDefaultModel();
		model.read(new FileInputStream("gen/FullExcel2RDFv39.n-triples"), null, "N-TRIPLES");

		String queryString = "prefix x: <urn:ex:> CONSTRUCT { ?s ?p ?o } "
				+ "WHERE { <http://localhost:8080/Result_441>  (x:|!x:)* ?s . ?s ?p ?o . }";

		Query query = QueryFactory.create(queryString);
		Model subGraph = null;
		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
			subGraph = qexec.execConstruct();
		}

		String queryString2 = "SELECT ?s ?p ?o " + "WHERE { ?s ?p ?o . }";

		Query query2 = QueryFactory.create(queryString2);

		try (QueryExecution qexec = QueryExecutionFactory.create(query2, subGraph)) {
			ResultSet results = qexec.execSelect();

			for (; results.hasNext();) {
				QuerySolution querySolution = results.nextSolution();
				try {

					System.out.println(querySolution.getResource("s") + "\t" + querySolution.getResource("p") + "\t"
							+ querySolution.getResource("o"));
				} catch (Exception e) {
					System.out.println(querySolution.getResource("s") + "\t" + querySolution.getResource("p") + "\t"
							+ querySolution.getLiteral("o"));
				}

			}
		}
		// args = new String[] { "res/excel/Access_DB_Daten_TSV.csv", "",
		// "http://localhost:8080/", "false" };
		//
		// SPARQLQueryExcelAccess excelAccess = new
		// SPARQLQueryExcelAccess(args);
		//
		// // excelAccess.queryModel("Select * where{ ?a ?b ?c}");
		// excelAccess.queryModel(CompetencyQuestionsSPARQLQueries.COMPETENCY_QUESTION_4);

	}

	private Model excelModel = null;

	public SPARQLQueryExcelAccess() throws Exception {
		excelModel = new ExcelCorpusConverter().convertToRDFModel();
	}

	public void queryModel(String queryString) {

		System.out.println("#########################");
		System.out.println("Complete query:\n" + queryString + "\n");
		System.out.println("#########################");
		Query query = QueryFactory.create(queryString);

		Map<String, String> vars = new HashMap<>();

		try (QueryExecution qexec = QueryExecutionFactory.create(query, excelModel)) {
			ResultSet results = qexec.execSelect();
			for (; results.hasNext();) {
				QuerySolution querySolution = results.nextSolution();

				for (String var : query.getResultVars()) {

					String value;

					try {
						Resource r = querySolution.getResource(var);
						if (r != null)
							value = r.toString().replaceAll("http://localhost:8080/", "");
						else {
							value = null;
						}
					} catch (ClassCastException e) {
						value = querySolution.getLiteral(var).toString();
					}

					vars.put(var, value);
				}

				System.out.println(vars);
				vars.clear();

			}
		}

	}

	public void query2WEKA(String queryString) {

		Query query = QueryFactory.create(queryString);

		Map<String, String> l = new HashMap<>();

		l.put("Contusion", "1,0,0,0,0");
		l.put("CompleteTransection", "0,1,0,0,0");
		l.put("PartialTransection", "0,0,1,0,0");
		l.put("Compression", "0,0,0,1,0");
		l.put("Injury", "0,0,0,0,1");

		System.out.println(query.getResultVars());

		Set<String> investigationMethod = new HashSet<>();
		Set<String> injuryModels = new HashSet<>();

		try (QueryExecution qexec = QueryExecutionFactory.create(query, excelModel)) {
			ResultSet results = qexec.execSelect();
			for (; results.hasNext();) {
				QuerySolution soln = results.nextSolution();

				Resource r = soln.getResource("injuryType");
				Resource r2 = soln.getResource("judgementType");
				Resource r3 = soln.getResource("test");

				injuryModels.add(r.toString().replaceAll("http://localhost:8080/", ""));
				investigationMethod.add(r3.toString().replaceAll("http://localhost:8080/", ""));

				// System.out.print(l.get() + ","
				// + r2.toString().replaceAll("http://localhost:8080/", "") +
				// "\n");

			}
		}

		List<String> investigationMethodL = new ArrayList<>(investigationMethod);
		List<String> injuryModelsL = new ArrayList<>(injuryModels);

		for (String string : injuryModelsL) {
			System.out.println("@attribute " + string + "{1,0}");
		}
		for (String string : investigationMethodL) {
			System.out.println("@attribute " + string + "{1,0}");
		}
		System.out.println("@attribute Judgement{Positive,Neutral,Negative}\n\n");
		System.out.println("@data");

		try (QueryExecution qexec = QueryExecutionFactory.create(query, excelModel)) {
			ResultSet results = qexec.execSelect();
			for (; results.hasNext();) {
				QuerySolution soln = results.nextSolution();

				Resource r = soln.getResource("injuryType");
				Resource r2 = soln.getResource("judgementType");
				Resource r3 = soln.getResource("test");

				for (String string : injuryModelsL) {
					System.out
							.print(string.equals(r.toString().replaceAll("http://localhost:8080/", "")) ? "1," : "0,");
				}
				for (String string : investigationMethodL) {
					System.out
							.print(string.equals(r3.toString().replaceAll("http://localhost:8080/", "")) ? "1," : "0,");
				}
				System.out.print(r2.toString().replaceAll("http://localhost:8080/", "") + "\n");

			}
		}

	}

}
