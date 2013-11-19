package ocanalyzer.analyzer.extractor;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.analyzer.factory.extractor.PackageExtractor;
import ocanalyzer.analyzer.factory.extractor.ProjectExtractor;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IPackageFragment;

public class ProjectAnalyzerMock extends ProjectExtractor {

	private String searchedPackageName;

	public ProjectAnalyzerMock(String packageName, IProject project,
			ExtractorFactory factory) {
		super(project, factory);
		this.searchedPackageName = packageName;
	}

	protected List<PackageExtractor> createPackageAnalyzers(
			IPackageFragment[] packages) {
		List<PackageExtractor> analyzers = new ArrayList<PackageExtractor>();
		for (IPackageFragment mypackage : packages) {
			IResource resource = mypackage.getResource();
			if (isValidPackage(resource)) {
				PackageExtractor packageAnalyzer = factory
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
