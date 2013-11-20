package ocanalyzer.handlers;

import java.util.List;

import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.tasks.ElseRuleTask;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class ElseHandlerMock extends ObjectCalisthenics {

	public ElseHandlerMock(ExtractorFactory factory,
			Reporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		ElseRuleTask task = new ElseRuleTask(unitsToAnalyze, reporter);
		task.execute();
	}
}
