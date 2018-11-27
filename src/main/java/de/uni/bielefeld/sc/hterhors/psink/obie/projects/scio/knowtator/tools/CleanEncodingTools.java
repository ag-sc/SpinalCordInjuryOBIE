package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import edu.stanford.smi.protege.model.SimpleInstance;

/**
 * Class that provides methods to clean Strings with non readable characters.
 * The mapping was done manually.
 * 
 * @author hterhors
 *
 *         Dec 14, 2016
 */
public class CleanEncodingTools {

	/**
	 * String that contains wrong chars, Fixed String
	 */
	private static Map<String, String> wrongCharMapping = new HashMap<>();

	private static final String RESOURCE_WRONG_CHAR_MAPPING_FILENAME = "res/knowtator/mapping/knowtator_wrongCharMapping.csv";

	private static void factory() {
		if (wrongCharMapping.isEmpty())
			try {
				Files.readAllLines(new File(RESOURCE_WRONG_CHAR_MAPPING_FILENAME).toPath()).stream().forEach(l -> {
					final String[] d = l.split("\t", -1);
					wrongCharMapping.put(d[0], d[1]);
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	/**
	 * 
	 * @param replaceAll
	 * @return
	 */
	public static String encode(String replaceAll) {
		factory();
		return wrongCharMapping.getOrDefault(replaceAll, replaceAll);
	}

	/**
	 * Checks if the given strings contains incorrect character.
	 * 
	 * @param string the string to test.
	 * 
	 * @return true if string contains invalid chars.
	 */
	public static boolean containsInvalidCharMapping(final String string) {
		return string.matches(".*[^\\x20-\\x7E].*");
	}

	/**
	 * Simple method to clean the text of an annotation. This comprises a deletion
	 * of all newLine-Character.
	 * 
	 * @param mention
	 * 
	 * @return cleaned version of the mention.
	 */
	public static String getCleanBrowserText(SimpleInstance mention) {
		return mention.getBrowserText().replaceAll("\n", " ");
	}

}
