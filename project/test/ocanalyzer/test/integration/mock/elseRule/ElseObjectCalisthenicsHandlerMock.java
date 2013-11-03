package ocanalyzer.test.integration.mock.elseRule;

import java.util.List;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;
import ocanalyzer.rules.task.AllRulesTask;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseObjectCalisthenicsHandlerMock extends
		ObjectCalisthenicsHandler {

	public ElseObjectCalisthenicsHandlerMock(AnalyzerFactory factory,
			RuleViolationReporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyOnUnits(List<CompilationUnit> unitsToAnalyze) {
		AllRulesTask task = new AllRulesTask(unitsToAnalyze, reporter);
		task.execute();
	}
}
