package ocanalyzer.analyzer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

public class AnalyzerFactoryImpl implements AnalyzerFactory {

	private AnalyzerFactory delegateFactory;

	public AnalyzerFactoryImpl() {
		delegateFactory = this;
	}

	public AnalyzerFactoryImpl(AnalyzerFactory delegateFactory) {
		this.delegateFactory = delegateFactory;
	}

	@Override
	public CompilationUnitAnalyzer createCompilationUnitAnalyzer(
			ICompilationUnit compilationUni) {
		return new CompilationUnitAnalyzer(compilationUni);
	}

	@Override
	public PackageAnalyzer createPackageAnalyzer(IPackageFragment fragment) {
		return new PackageAnalyzer(fragment, delegateFactory);
	}

	@Override
	public ProjectAnalyzer createProjectAnalyzer(IProject project) {
		return new ProjectAnalyzer(project, delegateFactory);
	}

	@Override
	public WorkspaceAnalyzer createWorkspaceAnalyzer(IWorkspace workspace) {
		return new WorkspaceAnalyzer(workspace, delegateFactory);
	}
}
