package ocanalyzer.analyzer.factory;

import ocanalyzer.analyzer.extractor.ProjectAnalyzerMock;
import ocanalyzer.analyzer.factory.extractor.CompilationUnitExtractor;
import ocanalyzer.analyzer.factory.extractor.PackageExtractor;
import ocanalyzer.analyzer.factory.extractor.ProjectExtractor;
import ocanalyzer.analyzer.factory.extractor.WorkspaceExtractor;
import ocanalyzer.reporter.impl.NoReporter;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

public class MockAnalyzerFactory implements ExtractorFactory {

	private String packageName;

	public MockAnalyzerFactory(String packageName) {
		this.packageName = packageName;
	}

	@Override
	public CompilationUnitExtractor createCompilationUnitAnalyzer(
			ICompilationUnit compilationUni) {
		return new CompilationUnitExtractor(compilationUni);
	}

	@Override
	public PackageExtractor createPackageAnalyzer(IPackageFragment fragment) {
		return new PackageExtractor(fragment, this, new NoReporter());
	}

	@Override
	public ProjectExtractor createProjectAnalyzer(IProject project) {
		return new ProjectAnalyzerMock(packageName, project, this);
	}

	@Override
	public WorkspaceExtractor createWorkspaceAnalyzer(IWorkspace workspace) {
		return new WorkspaceExtractor(workspace, this);
	}
}
