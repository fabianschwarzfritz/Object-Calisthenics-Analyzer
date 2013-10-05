package ocanalyzer.analyzer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class ProjectAnalyzer {

	private static final String JDT_NATURE = "org.eclipse.jdt.core.javanature";

	private IProject project;

	public ProjectAnalyzer(IProject project) {
		this.project = project;
	}

	public void analyze() throws JavaModelException {
		boolean analyzeable = isJavaProject();

		if (analyzeable) {
			IPackageFragment[] packages = JavaCore.create(project)
					.getPackageFragments();
			for (IPackageFragment mypackage : packages) {
				PackageAnalyzer handler = new PackageAnalyzer(mypackage);
				handler.handle();
			}
		}
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
