package ocanalyzer;

import java.util.Collection;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.rules.impl.OCRulesImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ObjectCalisthenics {

	private Extractor extractor;
	private OCRulesImpl rules;

	public ObjectCalisthenics(Extractor extractor, OCRulesImpl rules) {
		super();
		this.extractor = extractor;
		this.rules = rules;
	}

	public void validate() {
		// Extract
		Collection<ICompilationUnit> units = extractor.extract();
		// Run
		rules.apply(units);
	}

}
