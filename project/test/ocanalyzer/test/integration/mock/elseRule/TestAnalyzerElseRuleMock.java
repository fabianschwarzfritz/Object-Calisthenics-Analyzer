package ocanalyzer.test.integration.mock.elseRule;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;
import ocanalyzer.test.integration.mock.AnalyzerFactoryTest;
import ocanalyzer.test.integration.mock.TestAnalyzerMock;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class TestAnalyzerElseRuleMock extends TestAnalyzerMock {

	public TestAnalyzerElseRuleMock(RuleViolationReporter reporter) {
		super(null, reporter, new AnalyzerFactoryTest(null));
	}

	public TestAnalyzerElseRuleMock(ICompilationUnit unit,
			RuleViolationReporter reporter, AnalyzerFactory factory) {
		super(unit, reporter, factory);
	}

	@Override
	protected void acceptRules(CompilationUnit compilationUnit,
			RuleFactory factory) {
		acceptElseRule(compilationUnit, factory);
	}

}
