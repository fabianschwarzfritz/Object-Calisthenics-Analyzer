package ocanalyzer.test.integration.mock;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.PackageAnalyzer;
import ocanalyzer.analyzer.ProjectAnalyzer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IPackageFragment;

public class ProjectAnalyzerMock extends ProjectAnalyzer {

	private String searchedPackageName;

	public ProjectAnalyzerMock(String packageName, IProject project,
			AnalyzerFactory factory) {
		super(project, factory);
		this.searchedPackageName = packageName;
	}

	protected List<PackageAnalyzer> createPackageAnalyzers(
			IPackageFragment[] packages) {
		List<PackageAnalyzer> analyzers = new ArrayList<PackageAnalyzer>();
		for (IPackageFragment mypackage : packages) {
			IResource resource = mypackage.getResource();
			if (isValidPackage(resource)) {
				PackageAnalyzer packageAnalyzer = factory
						.createPackageAnalyzer(mypackage);
				analyzers.add(packageAnalyzer);
			}
		}
		return analyzers;
	}

	private boolean isValidPackage(IResource resource) {
		if (resource != null) {
			String packageName = resource.getName();
			if (packageName.contains(searchedPackageName)) {
				return true;
			}
		}
		return false;
	}
}
