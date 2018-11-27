package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie;

import de.hterhors.obie.core.ontology.interfaces.IOBIEThing;
import de.hterhors.obie.ml.explorer.IExplorationCondition;

/**
 * TODO:
 * 
 * @author hterhors
 *
 * @date Oct 11, 2017
 */
public class SCIOExplorationConditions implements IExplorationCondition {

	@Override
	public boolean matchesExplorationContitions(IOBIEThing baseClass, String baseClassField,
			IOBIEThing candidateClass) {

		return true;
	}

}
