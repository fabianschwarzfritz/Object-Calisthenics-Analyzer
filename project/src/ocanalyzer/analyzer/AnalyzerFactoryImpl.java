package ocanalyzer.analyzer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

/**
 * This class is a concrete implementation of an {@link AnalyzerFacotory}. It
 * creates: {@link CompilationUnitAnalyzer}, {@link PackageAnalyzer}s,
 * {@link ProjectAnalyzer}s and {@link WorkspaceAnalyzer}s.
 * 
 * All of these analyzers also use a {@link AnalyzerFactory} to create sub
 * analyzers (for example a {@link PackageAnalyzer} uses a
 * {@link CompilationUnitAnalyzer}).
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class AnalyzerFactoryImpl implements AnalyzerFactory {

	/**
	 * This is the factory, the created analyzers are using to create sub
	 * factories.
	 */
	private AnalyzerFactory delegateFactory;

	public AnalyzerFactoryImpl() {
		delegateFactory = this;
	}

	public AnalyzerFactoryImpl(AnalyzerFactory delegateFactory) {
		this.delegateFactory = delegateFactory;
	}

	@Override
	public CompilationUnitAnalyzer createCompilationUnitAnalyzer(
			ICompilationUnit compilationUni) {
		return new CompilationUnitAnalyzer(compilationUni);
	}

	@Override
	public PackageAnalyzer createPackageAnalyzer(IPackageFragment fragment) {
		return new PackageAnalyzer(fragment, delegateFactory);
	}

	@Override
	public ProjectAnalyzer createProjectAnalyzer(IProject project) {
		return new ProjectAnalyzer(project, delegateFactory);
	}

	@Override
	public WorkspaceAnalyzer createWorkspaceAnalyzer(IWorkspace workspace) {
		return new WorkspaceAnalyzer(workspace, delegateFactory);
	}
}
