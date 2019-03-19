package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.excel.uncomplete;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;

/**
 * This class provides data about mapping from Class names that were used in the
 * Excel-Data to the Class names of the current version of SCIO.
 * 
 * @author hterhors
 *
 *         Dec 14, 2016
 */
public class ExcelMappingProvider {

	private static final String EXCEL_SCIO_MAPPING_TABLE = "excel/scioMappingv"
			+ OntologyEnvironment.getInstance().getOntologyVersion() + ".csv";

	private static ExcelMappingProvider instance = null;

	protected static ExcelMappingProvider getInstance() {

		if (instance == null) {
			instance = new ExcelMappingProvider();
		}

		return instance;

	}

	/**
	 * String-value, ScioClass
	 */
	final public Map<String, String> mapping;

	private ExcelMappingProvider() {
		mapping = readMappingData();
	}

	private Map<String, String> readMappingData() {
		Map<String, String> mapping = new HashMap<>();
		try {
			Files.readAllLines(new File(EXCEL_SCIO_MAPPING_TABLE).toPath(), Charset.forName("UTF-8")).stream().skip(1)
					.forEach(l -> mapping.put(l.split("\t")[1], l.split("\t")[2]));
		} catch (IOException e) {
			e.printStackTrace();
		}

		mapping.keySet().forEach(System.out::println);

		return mapping;

	}

}
