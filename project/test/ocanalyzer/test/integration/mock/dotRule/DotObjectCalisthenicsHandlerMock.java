package ocanalyzer.test.integration.mock.dotRule;

import java.util.List;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.task.DotRuleTask;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class DotObjectCalisthenicsHandlerMock extends ObjectCalisthenicsHandler {

	public DotObjectCalisthenicsHandlerMock(AnalyzerFactory factory,
			RuleViolationReporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		DotRuleTask task = new DotRuleTask(unitsToAnalyze, reporter);
		task.execute();
	}
}
