package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.webanno;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import de.hterhors.obie.core.ontology.AbstractOntologyEnvironment;
import de.hterhors.obie.core.owlreader.OWLReader;
import de.hterhors.obie.core.owlreader.container.OntologyClass;
import de.hterhors.obie.core.owlreader.container.OntologySlotData;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.SlotFillingProjectEnvironment;

@Deprecated
public class WebAnnoLayerWriter {

	private static AbstractOntologyEnvironment env = OntologyEnvironment.getInstance();

	private static OWLReader dataProvider = new OWLReader(env);
	final int versionNumber;

	final String projectName = "PSINKAnnotation";
	final String entityLayerName = "SCIOEntities";
	final String relationLayerName = "CorpusRelations";
	final String projectNameSpace = "webanno.scio";

	Set<OntologyClass> classes = new HashSet<>();
	Map<OntologyClass, Set<WebAnnoConstraint>> constrains = new HashMap<>();
	Set<OntologySlotData> relations = new HashSet<>();

	public static void main(String[] args) throws Exception {

		/**
		 * Not updated since we are not using webanno anymore.
		 */
//		dataProvider.relations
		WebAnnoLayerWriter webannoSchemaWriter = new WebAnnoLayerWriter(null, dataProvider.classes, null, null,
				// dataProvider.domains, dataProvider.ranges,
				OntologyEnvironment.getInstance().getOntologyVersion());

		webannoSchemaWriter.write("OWLSCIOConstrains", "OWL");
	}

	public WebAnnoLayerWriter(Set<OntologySlotData> relations, Set<OntologyClass> classes,
			Map<OntologySlotData, Set<OntologyClass>> domain, Map<OntologySlotData, Set<OntologyClass>> range,
			final int versionNumber) {
		this.versionNumber = versionNumber;
		this.classes = classes;
		this.relations = relations;

		buildConstrains(domain, range);

	}

	public void write(final String constrainsFileName, final String relationFileNamePrefix) throws Exception {

		this.constrainsFileName = constrainsFileName;
		this.relationFileNamePrefix = relationFileNamePrefix;
		final String entityTagSet = writeOneLayer();

		writeRelationLayer(entityTagSet, relations);

		writeConstrains();

	}

	private void buildConstrains(Map<OntologySlotData, Set<OntologyClass>> domain,
			Map<OntologySlotData, Set<OntologyClass>> range) {
		for (OntologySlotData label : domain.keySet()) {

			final Set<OntologyClass> dependent = range.get(label);
			final Set<OntologyClass> governor = domain.get(label);

			for (OntologyClass gov : governor) {
				for (OntologyClass dep : dependent) {
					addConstrainsRecursive(label, gov, dep);
				}
			}

		}
	}

	private void addConstrainsRecursive(OntologySlotData label, OntologyClass gov, OntologyClass dep) {

		for (OntologyClass subDep : dep.subclasses) {
			addConstrainsRecursive(label, gov, subDep);
		}
		for (OntologyClass subGov : gov.subclasses) {
			addConstrainsRecursive(label, subGov, dep);
		}
		constrains.putIfAbsent(gov, new HashSet<>());
		constrains.get(gov).add(new WebAnnoConstraint(gov, dep, label));
	}

	private void writeRelationLayer(String entityTagSet, Set<OntologySlotData> relations) throws Exception {

		StringBuffer tagSetList = new StringBuffer();

		String relationLayerTemplate = loadRelationLayerTemplate();

		final String tagSet = generateTagSetForRelations(relations);
		tagSetList.append(tagSet);

		final String layer = String.format(relationLayerTemplate, projectNameSpace, relationLayerName,
				relationLayerName, tagSet, projectName, relationLayerName, projectNameSpace, entityLayerName,
				entityLayerName, entityTagSet, projectName, entityLayerName, projectName, projectName);

		PrintStream ps = new PrintStream(
				"gen/webanno/relationlayers/" + relationFileNamePrefix + relationLayerName + "_" + versionNumber);
		ps.print(layer);
		ps.close();

	}

	private String loadRelationLayerTemplate() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File("res/webanno/relationLayerTemplate")));

		String line = "";

		StringBuffer document = new StringBuffer("");
		while ((line = br.readLine()) != null) {
			document.append(line + "\n");
		}

		br.close();
		final String doc = document.toString().trim();
		return doc;
	}

	private String writeOneLayer() throws Exception {

		StringBuffer tagSetList = new StringBuffer();

		String layerTemplate = loadTemplate();

		final String classTagSet = generateTagSetForClasses(classes);
		tagSetList.append(classTagSet);
		tagSetList.append(",");

		final String tagSetListString = tagSetList.toString().substring(0, tagSetList.length() - 1);

		final String layer = String.format(layerTemplate, projectNameSpace, entityLayerName, entityLayerName,
				tagSetListString, projectName, entityLayerName, projectName);

		PrintStream ps = new PrintStream(
				"gen/webanno/layers/" + relationFileNamePrefix + entityLayerName + "_" + versionNumber);
		ps.print(layer);
		ps.close();

		return tagSetListString;

	}

	final private String tagTemplate = "\t{\n\t\t\t\t\t\"tag_name\":\"%s\",\n\t\t\t\t\t\"tag_description\":null\n\t\t\t\t}";
	private String constrainsFileName;
	private String relationFileNamePrefix;

	private String generateTagSetForClasses(Collection<OntologyClass> classes) {

		final StringBuffer tagSetList = new StringBuffer();

		for (OntologyClass tag : classes) {
			tagSetList.append(String.format(tagTemplate, tag.javaClassName));
			tagSetList.append(",\n\t\t\t");
		}

		final String tagSetListString = tagSetList.toString().substring(0, tagSetList.length() - 5);

		return tagSetListString;
	}

	private String generateTagSetForRelations(Collection<OntologySlotData> relations) {

		final StringBuffer tagSetList = new StringBuffer();

		for (OntologySlotData tag : relations) {
			tagSetList.append(String.format(tagTemplate, tag.ontologyPropertyName));
			tagSetList.append(",\n\t\t\t");
		}

		final String tagSetListString = tagSetList.toString().substring(0, tagSetList.length() - 5);

		return tagSetListString;
	}

	private String generateTagSet(Entry<String, Set<String>> sc) {

		final StringBuffer sb = new StringBuffer();

		sb.append(String.format(tagTemplate, sc.getKey()));

		if (sc.getValue().isEmpty())
			return sb.toString();

		for (String tag : sc.getValue()) {
			sb.append(",\n\t\t\t");
			sb.append(String.format(tagTemplate, tag));
		}

		return sb.toString();

	}

	private String loadTemplate() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File("res/webanno/layersTemplate")));

		String line = "";

		StringBuffer document = new StringBuffer("");
		while ((line = br.readLine()) != null) {
			document.append(line + "\n");
		}
		br.close();
		final String doc = document.toString().trim();
		return doc;
	}

	private void writeConstrains() throws Exception {

		// final String header1 = "import " + projectNameSpace + "." +
		// entityLayerName + " as ENT;";
		final String header2 = "import " + projectNameSpace + "." + relationLayerName + " as "
				+ relationLayerName.toUpperCase() + ";";
		final StringBuffer sb = new StringBuffer();
		// sb.append(header1);
		// sb.append("\n");
		sb.append(header2);
		sb.append("\n");
		sb.append("\n");
		sb.append(relationLayerName.toUpperCase());
		sb.append(" {");
		sb.append("\n");

		for (Entry<OntologyClass, Set<WebAnnoConstraint>> cons : constrains.entrySet()) {

			// final String constrainsName = cons.getKey();

			for (WebAnnoConstraint con : cons.getValue()) {

				sb.append(String.format("\tGovernor.value = \"%s\" & Dependent.value = \"%s\" -> label = \"%s\";",
						con.governor.javaClassName, con.dependent.javaClassName, con.label.ontologyPropertyName));
				sb.append("\n");
			}

		}
		sb.append("}");

		PrintStream ps = new PrintStream("gen/webanno/constrains/" + constrainsFileName + "_" + versionNumber);
		ps.print(sb.toString());
		ps.close();
	}

}
