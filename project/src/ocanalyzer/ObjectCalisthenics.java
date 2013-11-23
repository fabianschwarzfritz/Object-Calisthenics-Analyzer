package ocanalyzer;

import java.util.Collection;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.rules.impl.RulesImpl;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class ObjectCalisthenics {

	private Extractor extractor;
	private RulesImpl rules;

	public ObjectCalisthenics(Extractor extractor, RulesImpl rules) {
		super();
		this.extractor = extractor;
		this.rules = rules;
	}

	public void validate() {
		// Extract
		Collection<CompilationUnit> units = extractor.extract();
		// Run
		rules.apply(units);
	}

}
