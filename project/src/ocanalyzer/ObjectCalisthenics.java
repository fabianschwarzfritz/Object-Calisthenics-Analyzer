package ocanalyzer;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.extractor.impl.ExtractorImpl;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.OCRules;
import ocanalyzer.rules.general.ICompilationUnits;
import ocanalyzer.rules.impl.OCRulesImpl;

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
		ICompilationUnits units = extractor.extract();
		rules.apply(units);
	}

}
