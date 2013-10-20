package ocanalyzer.test.integration.mock.indentationRule;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.CompilationUnitAnalyzer;
import ocanalyzer.analyzer.PackageAnalyzer;
import ocanalyzer.analyzer.ProjectAnalyzer;
import ocanalyzer.analyzer.WorkspaceAnalyzer;
import ocanalyzer.test.integration.mock.ProjectAnalyzerMock;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

public class IndentationTestAnalyzerFactory implements AnalyzerFactory {

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
		return new ProjectAnalyzerMock("indentationRule", project, this);
	}

	@Override
	public WorkspaceAnalyzer createWorkspaceAnalyzer(IWorkspace workspace) {
		return new WorkspaceAnalyzer(workspace, this);
	}
}