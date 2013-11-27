package ocanalyzer.newIntegration;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.extractor.impl.ExtractorFactory;
import ocanalyzer.extractor.impl.ExtractorImpl;
import ocanalyzer.rules.general.ICompilationUnits;
import ocanalyzer.rules.impl.OCRulesImpl;

import org.junit.Before;

public class OCIntegration {

	private String packageName;

	protected TestReporter reporter;
	protected ICompilationUnits units;
	protected OCRulesImpl rules;

	public OCIntegration(String packageName) {
		this.packageName = packageName;
	}

	@Before
	public void extractUnits() {
		ExtractorFactory factory = createMock(packageName);
		Extractor extractor = new ExtractorImpl(factory);
		units = extractor.extract();
	}

	private ExtractorFactory createMock(String packagename) {
		return new MockAnalyzerFactory(packagename);
	}

	@Before
	public void initTestReporter() {
		reporter = new TestReporter();
	}

}
