package ocanalyzer.analyzer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ProjectAnalyzer implements CompilationUnitsExtractable {

	private static final String JDT_NATURE = "org.eclipse.jdt.core.javanature";

	private IProject project;
	protected AnalyzerFactory factory;

	public ProjectAnalyzer(IProject project, AnalyzerFactory factory) {
		this.project = project;
		this.factory = factory;
	}

	public List<CompilationUnit> extractCompilationUnits() {
		List<CompilationUnit> resultUnits = new ArrayList<CompilationUnit>();
		try {
			if (isJavaProject()) {
				IPackageFragment[] packages = JavaCore.create(project)
						.getPackageFragments();

				List<PackageAnalyzer> createPackageAnalyzers = createPackageAnalyzers(packages);
				extract(resultUnits, createPackageAnalyzers);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return resultUnits;
	}

	private void extract(List<CompilationUnit> resultUnits,
			List<PackageAnalyzer> createPackageAnalyzers) {
		for (PackageAnalyzer packageAnalyzer : createPackageAnalyzers) {
			List<CompilationUnit> packageUnits = packageAnalyzer
					.extractCompilationUnits();
			resultUnits.addAll(packageUnits);
		}
	}

	protected List<PackageAnalyzer> createPackageAnalyzers(
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
