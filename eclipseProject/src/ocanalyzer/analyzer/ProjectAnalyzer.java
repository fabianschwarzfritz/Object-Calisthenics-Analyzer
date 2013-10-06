package ocanalyzer.analyzer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class ProjectAnalyzer {

	private static final String JDT_NATURE = "org.eclipse.jdt.core.javanature";

	private AnalyzerFactory factory;
	private IProject project;

	public ProjectAnalyzer(IProject project, AnalyzerFactory factory) {
		this.project = project;
		this.factory = factory;
	}

	public void analyze() throws JavaModelException {
		boolean analyzeable = isJavaProject();

		if (analyzeable) {
			IPackageFragment[] packages = JavaCore.create(project)
					.getPackageFragments();

			List<PackageAnalyzer> createPackageAnalyzers = createPackageAnalyzers(packages);
			for (PackageAnalyzer packageAnalyzer : createPackageAnalyzers) {
				packageAnalyzer.handle();
			}
		}
	}

	private List<PackageAnalyzer> createPackageAnalyzers(
			IPackageFragment[] packages) {
		List<PackageAnalyzer> analyzers = new ArrayList<PackageAnalyzer>();
		for (IPackageFragment mypackage : packages) {
			PackageAnalyzer packageAnalyzer = factory
					.createPackageAnalyzer(mypackage);
			analyzers.add(packageAnalyzer);
		}
		return analyzers;
	}

	private boolean isJavaProject() {
		try {
			if (project.isNatureEnabled(JDT_NATURE)) {
				return true;
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return false;
	}

}
