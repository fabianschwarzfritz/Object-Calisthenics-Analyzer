package ocanalyzer.test.integration.mock.indentationRule;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class IndentiationObjectCalisthenicsHandlerMock extends
		ObjectCalisthenicsHandler {

	public IndentiationObjectCalisthenicsHandlerMock(AnalyzerFactory factory,
			RuleViolationReporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected RuleFactory getRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new IndentiationRuleFactory(iCompilationUnit, compilationUnit,
				reporter);
	}

}
