package ocanalyzer.analyzer;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

public class AnalyzerFactoryImpl implements AnalyzerFactory {

	private AnalyzerFactory factory;

	public AnalyzerFactoryImpl(AnalyzerFactory factory) {
		this.factory = factory;
	}

	@Override
	public CompilationUnitAnalyzer createCompilationUnitAnalyzer(
			ICompilationUnit compilationUni) {
		return new CompilationUnitAnalyzer(compilationUni, factory);
	}

	@Override
	public PackageAnalyzer createPackageAnalyzer(IPackageFragment fragment) {
		return new PackageAnalyzer(fragment, factory);
	}

	@Override
	public ProjectAnalyzer createProjectAnalyzer(IProject project) {
		return new ProjectAnalyzer(project, factory);
	}

	public AnalyzerFactory getFactory() {
		return factory;
	}

	public void setFactory(AnalyzerFactory factory) {
		this.factory = factory;
	}
}
