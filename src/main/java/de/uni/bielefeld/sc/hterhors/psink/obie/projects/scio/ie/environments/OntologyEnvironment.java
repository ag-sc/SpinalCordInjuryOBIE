package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.hterhors.obie.core.ontology.AbstractOntologyEnvironment;
import de.hterhors.obie.core.owlreader.IClassFilter;
import de.hterhors.obie.core.owlreader.container.OntologyClass;

public class OntologyEnvironment extends AbstractOntologyEnvironment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static OntologyEnvironment instance = new OntologyEnvironment();

	private final String ontologyBasePackage = "de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.";

	final public static int version = 64;

	public static final File ONTOLOGY_FILE = new File("src/main/resources/owl/SCIO_" + version + ".owl");
	public static final String DEFAULT_DATA_NAMESPACE = "http://scio/data/";
	public static final String ONTOLOGY_NAME = "SCIO";

	@Override
	public int getOntologyVersion() {
		return version;
	}

	@Override
	public String getDataNameSpace() {
		return DEFAULT_DATA_NAMESPACE;
	}

	@Override
	public File getOntologyFile() {
		return ONTOLOGY_FILE;
	}

	public static OntologyEnvironment getInstance() {
		return instance;
	}

	@Override
	public String getOntologyName() {
		return ONTOLOGY_NAME;
	}

	@Override
	public IClassFilter getOwlClassFilter() {
		return new IClassFilter() {

			@Override
			public boolean matchesCondition(OntologyClass ocd) {

				if (ocd.documentation.containsKey("clinicalTerm")
						&& ocd.documentation.get("clinicalTerm").get(0).equals("true"))
					return false;

				return recSuperClassCheck(ocd);

			}

			private boolean recSuperClassCheck(OntologyClass ocd) {
				for (OntologyClass superClass : ocd.superclasses) {
					boolean b = matchesCondition(superClass);
					if (!b)
						return false;
				}
				return true;
			}
		};
	}

	@Override
	public Set<String> getCollectiveClasses() {
		return Collections.unmodifiableSet(new HashSet<>(Arrays.asList("http://psink.de/scio/Event",
				"http://data.nasa.gov/qudt/owl/qudt#Quantity", "http://www.w3.org/2006/time#TemporalEntity")));
	}

	@Override
	public String getAdditionalPrefixes() {
		return "PREFIX scio: <http://psink.de/scio/>" + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>";
	}

	@Override
	public List<String> getAdditionalPropertyNames() {
		return additionalInfoVariableNames;
	}

	final static String VARIABLE_NAME_EXAMPLE = "scio:example";
	final static String VARIABLE_NAME_EXAMPLE_SOURCE = "scio:exampleSource";
	final static String VARIABLE_NAME_LABEL = "rdfs:label";
	final static String VARIABLE_NAME_CLINICAL_TERM = "scio:clinicalTerm";
	final static String VARIABLE_NAME_VISUALIZATION_CONTAINER = "scio:visualizationContainer";
	final static String VARIABLE_NAME_DESCRIPTION_SOURCE = "scio:descriptionSource";
	final static String VARIABLE_NAME_DESCRIPTION = "rdfs:description";
	final static String VARIABLE_NAME_COMMENT = "rdfs:comment";
	final static String VARIABLE_NAME_CLOSE_MATCH = "skos:closeMatch";

	final static List<String> additionalInfoVariableNames = Arrays.asList(VARIABLE_NAME_EXAMPLE,
			VARIABLE_NAME_EXAMPLE_SOURCE, VARIABLE_NAME_LABEL, VARIABLE_NAME_CLINICAL_TERM,
			VARIABLE_NAME_VISUALIZATION_CONTAINER, VARIABLE_NAME_DESCRIPTION_SOURCE, VARIABLE_NAME_COMMENT,
			VARIABLE_NAME_DESCRIPTION, VARIABLE_NAME_CLOSE_MATCH);

	@Override
	public String getBasePackage() {
		return ontologyBasePackage;
	}

}
