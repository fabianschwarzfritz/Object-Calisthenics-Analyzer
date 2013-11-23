package ocanalyzer.analyzer.factory;

import ocanalyzer.analyzer.extractor.ProjectAnalyzerMock;
import ocanalyzer.extractor.impl.CompilationUnitExtractor;
import ocanalyzer.extractor.impl.ExtractorFactory;
import ocanalyzer.extractor.impl.PackageExtractor;
import ocanalyzer.extractor.impl.ProjectExtractor;
import ocanalyzer.extractor.impl.WorkspaceExtractor;
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
