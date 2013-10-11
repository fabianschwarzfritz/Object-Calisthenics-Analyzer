package ocanalyzer.test.integration.mock;

import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;
import ocanalyzer.test.integration.mock.elseRule.ElseRuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ObjectCalisthenicsHandlerMock extends ObjectCalisthenicsHandler {

	public ObjectCalisthenicsHandlerMock(RuleViolationReporter reporter) {
		super(reporter);
	}

	@Override
	protected RuleFactory getRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new ElseRuleFactory(iCompilationUnit, compilationUnit, reporter);
	}

}
