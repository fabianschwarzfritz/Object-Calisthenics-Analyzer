package ocanalyzer.analyzer.factory;

import ocanalyzer.analyzer.extractor.CompilationUnitExtractor;
import ocanalyzer.analyzer.extractor.PackageExtractor;
import ocanalyzer.analyzer.extractor.ProjectExtractor;
import ocanalyzer.analyzer.extractor.WorkspaceExtractor;

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
public interface ExtractorFactory {

	public abstract CompilationUnitExtractor createCompilationUnitAnalyzer(
			ICompilationUnit compilationUnit);

	public abstract PackageExtractor createPackageAnalyzer(
			IPackageFragment fragment);

	public abstract ProjectExtractor createProjectAnalyzer(IProject project);

	public abstract WorkspaceExtractor createWorkspaceAnalyzer(
			IWorkspace workspace);
}
