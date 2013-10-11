package ocanalyzer.test.integration.mock;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.CompilationUnitAnalyzer;
import ocanalyzer.analyzer.PackageAnalyzer;
import ocanalyzer.analyzer.ProjectAnalyzer;
import ocanalyzer.reporter.RuleViolationReporter;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

public class AnalyzerFactoryTest implements AnalyzerFactory {

	private TestAnalyzerMock analyzerMock;

	public AnalyzerFactoryTest(TestAnalyzerMock analyzerMock) {
		this.analyzerMock = analyzerMock;
	}

	@Override
	public CompilationUnitAnalyzer createCompilationUnitAnalyzer(
			ICompilationUnit compilationUni) {
		analyzerMock.setCompilationUnit(compilationUni);
		return analyzerMock;
	}

	@Override
	public PackageAnalyzer createPackageAnalyzer(IPackageFragment fragment) {
		return new PackageAnalyzerMock(fragment, this);
	}

	@Override
	public ProjectAnalyzer createProjectAnalyzer(IProject project) {
		return new ProjectAnalyzerMock(project, this);
	}

}
