package ocanalyzer;

import java.util.Collection;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.rules.OCRules;

import org.eclipse.jdt.core.ICompilationUnit;

public class ObjectCalisthenics {

	private Extractor extractor;
	private OCRules rules;

	public ObjectCalisthenics(Extractor extractor, OCRules rules) {
		super();
		this.extractor = extractor;
		this.rules = rules;
	}

	public void validate() {
		Collection<ICompilationUnit> units = extractor.extract();
		rules.apply(units);
	}

}
