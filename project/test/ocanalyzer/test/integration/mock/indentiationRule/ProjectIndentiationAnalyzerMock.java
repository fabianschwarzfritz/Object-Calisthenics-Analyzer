package ocanalyzer.test.integration.mock.indentiationRule;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.PackageAnalyzer;
import ocanalyzer.analyzer.ProjectAnalyzer;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IPackageFragment;

public class ProjectIndentiationAnalyzerMock extends ProjectAnalyzer {

	public ProjectIndentiationAnalyzerMock(IProject project,
			AnalyzerFactory factory) {
		super(project, factory);
	}

	protected List<PackageAnalyzer> createPackageAnalyzers(
			IPackageFragment[] packages) {
		List<PackageAnalyzer> analyzers = new ArrayList<PackageAnalyzer>();
		for (IPackageFragment mypackage : packages) {
			String packageName = mypackage.getResource().getName();
			if (packageName.contains("indentiationRule")) {
				PackageAnalyzer packageAnalyzer = factory
						.createPackageAnalyzer(mypackage);
				analyzers.add(packageAnalyzer);
			}
		}
		return analyzers;
	}
}
