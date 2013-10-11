package ocanalyzer.test.integration.mock.indentiationRule;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;
import ocanalyzer.test.integration.mock.AnalyzerFactoryTest;
import ocanalyzer.test.integration.mock.TestAnalyzerMock;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class TestAnalyzerIndentiationRuleMock extends TestAnalyzerMock {

	public TestAnalyzerIndentiationRuleMock(RuleViolationReporter reporter) {
		super(null, reporter, new AnalyzerFactoryTest(null));
	}

	@Override
	protected void acceptRules(CompilationUnit compilationUnit,
			RuleFactory factory) {
		acceptIndentiationRule(compilationUnit, factory);
	}

}
