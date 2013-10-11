package ocanalyzer.test.integration.mock;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.CompilationUnitAnalyzer;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class TestAnalyzerMock extends CompilationUnitAnalyzer {

	private RuleViolationReporter testReporter;

	public TestAnalyzerMock(ICompilationUnit unit,
			RuleViolationReporter reporter, AnalyzerFactory factory) {
		super(unit, factory);
		this.testReporter = reporter;
	}

	@Override
	public void handle() {
		super.handle();
	}

	@Override
	protected RuleFactory createFactory(CompilationUnit compilationUnit) {
		return new RuleFactory(unit, compilationUnit, testReporter);
	}

	public void setCompilationUnit(ICompilationUnit unit) {
		this.unit = unit;
	}
}
