package ocanalyzer.test.integration.wrapPrimitivesAndStrings;

import java.util.List;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.task.PrimitiveTypeTask;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class WrapPrimitivesObjectCalisthenicsHandlerMock extends
		ObjectCalisthenicsHandler {

	public WrapPrimitivesObjectCalisthenicsHandlerMock(AnalyzerFactory factory,
			RuleViolationReporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		PrimitiveTypeTask task = new PrimitiveTypeTask(unitsToAnalyze, reporter);
		task.execute();
	}
}
