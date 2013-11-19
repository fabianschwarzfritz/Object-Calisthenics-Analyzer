package ocanalyzer.test.integration.mock.dotRule;

import java.util.List;

import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.tasks.DotRuleTask;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class DotObjectCalisthenicsHandlerMock extends ObjectCalisthenicsHandler {

	public DotObjectCalisthenicsHandlerMock(ExtractorFactory factory,
			Reporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		DotRuleTask task = new DotRuleTask(unitsToAnalyze, reporter);
		task.execute();
	}
}
