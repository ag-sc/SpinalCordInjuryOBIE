package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.annodb.corpus;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVReader;

import de.hterhors.obie.ml.variables.InstanceTemplateAnnotations;
import de.hterhors.obie.ml.variables.OBIEInstance;
import de.hterhors.obie.ml.variables.IETmplateAnnotation;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.environments.OntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.classes.GroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IExperimentalGroup;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IGroupName;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.IObservedDifference;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

/**
 * Converts data from anno db into an OBIE readable corpus.
 * 
 * @author hterhors
 *
 * @date Apr 16, 2018
 */
public class AnnoDBExpGroupsAndResults {

	public static void main(String[] args) throws Exception {

		final String dir = "webanno/gen/";
		final Set<String> groupNames = new HashSet<>();
		List<OBIEInstance> instances = new ArrayList<>();
		Arrays.stream(new File(dir).listFiles()).filter(file -> file.getName().endsWith(".annodb")).sorted()
				.forEach(file -> {
					try {
						Map<String, Set<String>> groupedSurfaceNames = new HashMap<>();

						System.out.println(file + "...");

						String documentContent = "";//

						CSVReader reader = new CSVReader(new FileReader(file), '\t');
						String[] line;
						InstanceTemplateAnnotations ias = new InstanceTemplateAnnotations();
						while ((line = reader.readNext()) != null) {

							@SuppressWarnings("unchecked")
							final Class<? extends ISCIOThing> clzz = (Class<? extends ISCIOThing>) Class
									.forName(OntologyEnvironment.getInstance().getBasePackage() + "classes."
											+ line[1]);

							if (!(IExperimentalGroup.class.isAssignableFrom(clzz)
									|| IObservedDifference.class.isAssignableFrom(clzz)))
								continue;

							final String surfaceForm = line[4];

							final String ids = line[5];

							if (ids.isEmpty())
								continue;

							for (String id : ids.split(",")) {
								id = id.trim();
								groupedSurfaceNames.putIfAbsent(id, new HashSet<>());
								groupedSurfaceNames.get(id).add(surfaceForm);
								groupNames.add(surfaceForm);
								IGroupName groupName = new GroupName(surfaceForm, surfaceForm);
								groupName.setCharacterOnset(Integer.parseInt(line[2]));
//								groupName.setCharacterOffset(Integer.parseInt(line[3]));
								IETmplateAnnotation ia = new IETmplateAnnotation(IGroupName.class, groupName);
								ias.addAnnotation(ia);
							}

						}
						OBIEInstance ii = new OBIEInstance(file.getName(), documentContent, ias,
								new HashSet<>(Arrays.asList(IGroupName.class)));
						instances.add(ii);
						reader.close();
						groupedSurfaceNames.entrySet().forEach(System.out::println);
						System.out.println("#################################");
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		System.out.println("#################################");
		groupNames.forEach(System.out::println);
		System.out.println("#################################");

	}
}
