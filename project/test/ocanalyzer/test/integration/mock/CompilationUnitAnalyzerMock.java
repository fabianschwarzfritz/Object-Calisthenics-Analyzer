package ocanalyzer.test.integration.mock;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.CompilationUnitAnalyzer;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class CompilationUnitAnalyzerMock extends CompilationUnitAnalyzer {

	private RuleViolationReporter testReporter;

	public CompilationUnitAnalyzerMock(ICompilationUnit unit,
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

	@Override
	protected void acceptRules(CompilationUnit compilationUnit,
			RuleFactory factory) {
		acceptElseRule(compilationUnit, factory);
	}

}
