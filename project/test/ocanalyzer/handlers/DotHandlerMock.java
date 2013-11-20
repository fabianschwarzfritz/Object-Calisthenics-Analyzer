package ocanalyzer.handlers;

import java.util.List;

import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.tasks.DotRuleTask;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class DotHandlerMock extends ObjectCalisthenics {

	public DotHandlerMock(ExtractorFactory factory,
			Reporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		DotRuleTask task = new DotRuleTask(unitsToAnalyze, reporter);
		task.execute();
	}
}
