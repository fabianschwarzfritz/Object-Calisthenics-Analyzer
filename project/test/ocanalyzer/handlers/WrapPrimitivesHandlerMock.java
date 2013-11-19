package ocanalyzer.handlers;

import java.util.List;
import java.util.Set;

import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.tasks.PrimitiveTypeTask;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class WrapPrimitivesHandlerMock extends
		ObjectCalisthenics {

	private Set<TypeDeclaration> wrappers;

	public WrapPrimitivesHandlerMock(ExtractorFactory factory,
			Reporter reporter) {
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
