package ocanalyzer.test.integration.mock.indentationRule;

import java.util.List;

import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.tasks.IndentationRuleTask;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class IndentiationObjectCalisthenicsHandlerMock extends
		ObjectCalisthenicsHandler {

	public IndentiationObjectCalisthenicsHandlerMock(ExtractorFactory factory,
			Reporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		IndentationRuleTask task = new IndentationRuleTask(unitsToAnalyze,
				reporter);
		task.execute();
	}

}
