package ocanalyzer.handlers;

import java.util.List;

import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.tasks.IndentationRuleTask;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class IndentiationHandlerMock extends
		ObjectCalisthenics {

	public IndentiationHandlerMock(ExtractorFactory factory,
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
