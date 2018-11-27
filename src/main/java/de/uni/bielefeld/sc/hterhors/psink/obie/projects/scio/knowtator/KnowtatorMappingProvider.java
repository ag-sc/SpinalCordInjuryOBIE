package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOOntologyEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.SCIOProjectEnvironment;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.knowtator.container.DomainRelationRange;

public class KnowtatorMappingProvider {

	private static final String classMappingFileName = "scio/knowtator/res/mapping/v"
			+ SCIOOntologyEnvironment.getInstance().getOntologyVersion() + "/knowtator_scioClassesMapping.csv";
	private static final String relationMappingFileName = "scio/knowtator/res/mapping/v"
			+ SCIOOntologyEnvironment.getInstance().getOntologyVersion() + "/knowtator_scioRelationMapping.csv";
	private static final String complexMappingFileName = "scio/knowtator/res/mapping/v"
			+ SCIOOntologyEnvironment.getInstance().getOntologyVersion() + "/knowtator_scioComplexMapping.csv";

	/**
	 * OldScioEntity,NewScioEntity
	 */
	protected Map<DomainRelationRange, DomainRelationRange> scioComplexMapping = new HashMap<>();

	/**
	 * OldScioEntity,AddScioEntity
	 */
	protected Map<DomainRelationRange, Set<DomainRelationRange>> scioAddAdditionalMappingForComplex = new HashMap<>();

	/**
	 * The direct mapping of an old SCIO class that is used in Knowtator and its
	 * corresponding new SCIO class.
	 */
	protected Map<String, String> scioClassMapping = new HashMap<>();

	/**
	 * The direct mapping of an old SCIO Relation that is used in Knowtator and its
	 * corresponding new SCIO Relation.
	 */
	protected Map<String, String> scioRelationMapping = new HashMap<>();

	/**
	 * It may occur that some relation between domains and ranges are obsolete.This
	 * Set contains all obsolete relations.
	 */
	protected Set<DomainRelationRange> obsoletRelations = new HashSet<>();

	private static KnowtatorMappingProvider instance = null;

	public static void main(String[] args) {
		getInstance();
	}

	protected static KnowtatorMappingProvider getInstance() {

		if (instance == null) {
			try {
				instance = new KnowtatorMappingProvider();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return instance;

	}

	private KnowtatorMappingProvider() throws IOException {
		initializeData();
	}

	/**
	 * Initialize the mapping data.
	 * 
	 * @throws IOException
	 */
	protected void initializeData() throws IOException {
		/*
		 * Read all direct class mappings from file.
		 */
		Files.readAllLines(new File(classMappingFileName).toPath()).stream().skip(1).forEach(l -> {
			final String[] d = l.split("\t", -1);
			if (!d[3].trim().equals("??"))
				scioClassMapping.put(d[1], d[2]);
		});

		/*
		 * Read all direct relation mappings from file.
		 */
		Files.readAllLines(new File(relationMappingFileName).toPath()).stream().skip(1).forEach(l -> {
			final String[] d = l.split("\t", -1);
			if (!d[2].trim().equals("??"))
				scioRelationMapping.put(d[0], d[1]);
		});

		/*
		 * Read all complex mappings from file. A complex mapping depends not only on
		 * the old scio class but also on the actual value. The complex mapping file
		 * contains also the obsolete relations.
		 */
		Files.readAllLines(new File(complexMappingFileName).toPath()).stream().skip(1).forEach(l -> {
			final String[] d = l.split("\t", -1);
			if (d[12].trim().equals("x")) {
				obsoletRelations.add(new DomainRelationRange(d[2], "", d[3], d[4], ""));
			} else {
				DomainRelationRange key = new DomainRelationRange(d[2], d[0], d[3], d[4], d[1]);

				if (!(d[9].trim().isEmpty() || d[10].trim().isEmpty() || d[11].trim().isEmpty()))
					scioComplexMapping.put(key, new DomainRelationRange(d[9], d[0], d[10], d[11], d[1]));

				if (!d[13].trim().isEmpty() && !d[14].trim().isEmpty() && !d[15].trim().isEmpty())
					scioAddAdditionalMappingForComplex.putIfAbsent(key, new HashSet<>());

				if (!d[13].trim().isEmpty() && !d[14].trim().isEmpty() && !d[15].trim().isEmpty())
					scioAddAdditionalMappingForComplex.get(key)
							.add(new DomainRelationRange(d[13], d[0], d[14], d[15], d[1]));

				if (!d[16].trim().isEmpty() && !d[17].trim().isEmpty() && !d[18].trim().isEmpty())
					scioAddAdditionalMappingForComplex.get(key)
							.add(new DomainRelationRange(d[16], d[0], d[17], d[18], d[1]));
			}
		});
	}

	/**
	 * Maps a direct SCIO-Class to its corresponding new SCIO-Class if any. Else it
	 * returns the same object.
	 * 
	 * @param oldScioEntity
	 * @return the new SCIO-Class
	 */
	protected String mapClass(String oldScioEntity) {
		return scioClassMapping.getOrDefault(oldScioEntity, oldScioEntity);
	}

	/**
	 * Maps a direct SCIO-Relation to its corresponding new SCIO-Relation if any.
	 * Else it returns the same object.
	 * 
	 * @param oldScioEntity
	 * @return the new SCIO-Relation
	 */
	protected String mapRelation(String oldScioEntity) {
		return scioRelationMapping.getOrDefault(oldScioEntity, oldScioEntity);
	}

	/**
	 * Maps a complex SCIO-DRR to its corresponding new SCIO-DRR if any. Else it
	 * returns the same object.
	 * 
	 * @param oldScioEntity
	 * @return the new SCIO-DRR
	 */
	protected DomainRelationRange mapComplex(DomainRelationRange drr) {
		return scioComplexMapping.getOrDefault(drr, drr);
	}
}
