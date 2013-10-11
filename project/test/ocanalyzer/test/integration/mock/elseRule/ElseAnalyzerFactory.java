package ocanalyzer.test.integration.mock.elseRule;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.CompilationUnitAnalyzer;
import ocanalyzer.analyzer.PackageAnalyzer;
import ocanalyzer.analyzer.ProjectAnalyzer;
import ocanalyzer.analyzer.WorkspaceAnalyzer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

public class ElseAnalyzerFactory implements AnalyzerFactory {

	@Override
	public CompilationUnitAnalyzer createCompilationUnitAnalyzer(
			ICompilationUnit compilationUni) {
		return new CompilationUnitAnalyzer(compilationUni);
	}

	@Override
	public PackageAnalyzer createPackageAnalyzer(IPackageFragment fragment) {
		return new PackageAnalyzer(fragment, this);
	}

	@Override
	public ProjectAnalyzer createProjectAnalyzer(IProject project) {
		return new ProjectElseAnalyzerMock(project, this);
	}

	@Override
	public WorkspaceAnalyzer createWorkspaceAnalyzer(IWorkspace workspace) {
		return new WorkspaceAnalyzer(workspace, this);
	}
}
