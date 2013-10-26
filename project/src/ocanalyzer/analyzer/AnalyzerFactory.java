package ocanalyzer.analyzer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

/**
 * This is an abstract analyzer factory class creating analyzer's for:
 * {@link IWorkspace}s, {@link IProject}s, {@link IPackageFragment}s and
 * {@link ICompilationUnit}s.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public interface AnalyzerFactory {

	public abstract CompilationUnitAnalyzer createCompilationUnitAnalyzer(
			ICompilationUnit compilationUni);

	public abstract PackageAnalyzer createPackageAnalyzer(
			IPackageFragment fragment);

	public abstract ProjectAnalyzer createProjectAnalyzer(IProject project);

	public abstract WorkspaceAnalyzer createWorkspaceAnalyzer(
			IWorkspace workspace);
}
