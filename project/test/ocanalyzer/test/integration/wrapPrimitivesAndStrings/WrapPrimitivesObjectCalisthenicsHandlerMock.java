package ocanalyzer.test.integration.wrapPrimitivesAndStrings;

import java.util.List;
import java.util.Set;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.task.PrimitiveTypeTask;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class WrapPrimitivesObjectCalisthenicsHandlerMock extends
		ObjectCalisthenicsHandler {

	private Set<TypeDeclaration> wrappers;

	public WrapPrimitivesObjectCalisthenicsHandlerMock(AnalyzerFactory factory,
			RuleViolationReporter reporter) {
		super(factory, reporter);
	}

	@Override
	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		PrimitiveTypeTask task = new PrimitiveTypeTask(unitsToAnalyze, reporter);
		task.execute();

		wrappers = task.getWrappers();
	}

	public Set<TypeDeclaration> getWrappers() {
		return wrappers;
	}

}
