package ocanalyzer.test.integration.mock.indentationRule;

import java.util.List;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.task.IndentationRuleTask;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class IndentiationObjectCalisthenicsHandlerMock extends
		ObjectCalisthenicsHandler {

	public IndentiationObjectCalisthenicsHandlerMock(AnalyzerFactory factory,
			RuleViolationReporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		IndentationRuleTask task = new IndentationRuleTask(unitsToAnalyze,
				reporter);
		task.execute();
	}

}
