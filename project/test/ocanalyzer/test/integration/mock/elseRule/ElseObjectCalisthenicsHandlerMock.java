package ocanalyzer.test.integration.mock.elseRule;

import java.util.List;

import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.tasks.ElseRuleTask;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseObjectCalisthenicsHandlerMock extends ObjectCalisthenicsHandler {

	public ElseObjectCalisthenicsHandlerMock(ExtractorFactory factory,
			Reporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		ElseRuleTask task = new ElseRuleTask(unitsToAnalyze, reporter);
		task.execute();
	}
}
