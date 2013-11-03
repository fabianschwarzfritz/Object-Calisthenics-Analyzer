package ocanalyzer.test.integration.mock.elseRule;

import java.util.List;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.task.ElseRuleTask;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseObjectCalisthenicsHandlerMock extends
		ObjectCalisthenicsHandler {

	public ElseObjectCalisthenicsHandlerMock(AnalyzerFactory factory,
			RuleViolationReporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		ElseRuleTask task = new ElseRuleTask(unitsToAnalyze, reporter);
		task.execute();
	}
}
