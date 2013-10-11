package ocanalyzer.test.integration.mock.elseRule;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseObjectCalisthenicsHandlerMock extends
		ObjectCalisthenicsHandler {
	
	private RuleFactoryMock ruleFactory;

	public ElseObjectCalisthenicsHandlerMock(AnalyzerFactory analyzerFactory,
			RuleViolationReporter reporter, RuleFactory ruleFactory) {
		super(analyzerFactory, reporter);
		this.ruleFactory = ruleFactory
	}

	@Override
	protected RuleFactory getRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
	}

}
