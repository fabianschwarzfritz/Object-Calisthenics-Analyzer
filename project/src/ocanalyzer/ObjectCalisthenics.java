package ocanalyzer;

import java.util.Collection;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.extractor.impl.ExtractorImpl;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.OCRules;
import ocanalyzer.rules.impl.OCRulesImpl;

import org.eclipse.jdt.core.ICompilationUnit;

public class ObjectCalisthenics {

	private Extractor extractor;
	private OCRules rules;

	public static ObjectCalisthenics create(Reporter reporter) {
		return new ObjectCalisthenics(new ExtractorImpl(),
				OCRulesImpl.createStandardRules(reporter));
	}

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
