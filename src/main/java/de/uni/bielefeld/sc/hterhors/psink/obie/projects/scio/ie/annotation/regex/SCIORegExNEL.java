package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.annotation.regex;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.ml.ner.regex.AbstractRegExNERL;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ie.semantics.SCIOSemanticInterpreter;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.ISCIOThing;

public class SCIORegExNEL extends AbstractRegExNERL<ISCIOThing> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MIN_NER_LENGTH = 2;

	private static Logger log = LogManager.getFormatterLogger(SCIORegExNEL.class);

	public SCIORegExNEL(Set<Class<? extends ISCIOThing>> rootClasses) {
		super(rootClasses, new SCIORegExPattern(), SCIOSemanticInterpreter.getInstance(), MIN_NER_LENGTH);
	}

	public SCIORegExNEL(Class<? extends ISCIOThing> rootClass) {
		this(new HashSet<>(Arrays.asList(rootClass)));
	}

	@Override
	protected Map<Class<? extends ISCIOThing>, Set<Pattern>> getAdditionalPatternForClasses(
			Class<? extends ISCIOThing> rootClassType) {
		return Collections.emptyMap();
	}

	@Override
	protected Map<AbstractIndividual, Set<Pattern>> getAdditionalPatternForIndividuals(
			Class<? extends ISCIOThing> rootClassType) {
		return Collections.emptyMap();
	}

}
