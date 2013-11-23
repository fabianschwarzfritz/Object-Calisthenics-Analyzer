package ocanalyzer;

import java.util.Collection;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.rules.Rules;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class ObjectCalisthenics {

	private Extractor extractor;
	private Rules rules;

	public ObjectCalisthenics(Extractor extractor, Rules rules) {
		super();
		this.extractor = extractor;
		this.rules = rules;
	}

	public void validate() {
		// Extract
		Collection<CompilationUnit> units = extractor.extractUnits();
		// Run
		rules.apply(units);
	}

}
