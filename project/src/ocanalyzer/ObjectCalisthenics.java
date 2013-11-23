package ocanalyzer;

import java.util.Collection;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.rules.impl.ObjectCalisthenicsRulesImpl;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class ObjectCalisthenics {

	private Extractor extractor;
	private ObjectCalisthenicsRulesImpl rules;

	public ObjectCalisthenics(Extractor extractor, ObjectCalisthenicsRulesImpl rules) {
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
