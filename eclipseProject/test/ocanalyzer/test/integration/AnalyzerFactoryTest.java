package ocanalyzer.test.integration;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.CompilationUnitAnalyzer;
import ocanalyzer.analyzer.PackageAnalyzer;
import ocanalyzer.analyzer.ProjectAnalyzer;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.test.integration.mock.CompilationUnitAnalyzerMock;
import ocanalyzer.test.integration.mock.PackageAnalyzerMock;
import ocanalyzer.test.integration.mock.ProjectAnalyzerMock;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

public class AnalyzerFactoryTest implements AnalyzerFactory {

	private RuleViolationReporter testReporter;

	public AnalyzerFactoryTest(RuleViolationReporter testReporter) {
		this.testReporter = testReporter;
	}

	@Override
	public CompilationUnitAnalyzer createCompilationUnitAnalyzer(
			ICompilationUnit compilationUni) {
		return new CompilationUnitAnalyzerMock(compilationUni, testReporter,
				this);
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
