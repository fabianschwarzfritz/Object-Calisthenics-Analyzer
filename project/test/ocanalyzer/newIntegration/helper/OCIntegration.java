package ocanalyzer.newIntegration.helper;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.extractor.impl.ExtractorFactory;
import ocanalyzer.extractor.impl.ExtractorImpl;
import ocanalyzer.newIntegration.mock.MockAnalyzerFactory;
import ocanalyzer.rules.general.ICompilationUnits;
import ocanalyzer.rules.impl.OCRulesImpl;

public class OCIntegration {

	private String packageName;

	private ICompilationUnits units;
	private OCRulesImpl rules;

	public OCIntegration(String packageName, OCRulesImpl rules) {
		super();
		this.packageName = packageName;
		this.rules = rules;
	}

	public void prepare() {
		extractUnits();
	}

	private void extractUnits() {
		ExtractorFactory factory = new MockAnalyzerFactory(packageName);
		Extractor extractor = new ExtractorImpl(factory);
		units = extractor.extract();
	}
	
	public void testRule() {
		rules.apply(units);
	}

}
