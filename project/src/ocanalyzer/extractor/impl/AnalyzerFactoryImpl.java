package ocanalyzer.extractor.impl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

/**
 * This class is a concrete implementation of an {@link AnalyzerFacotory}. It
 * creates: {@link CompilationUnitExtractor}, {@link PackageExtractor}s,
 * {@link ProjectExtractor}s and {@link WorkspaceExtractor}s.
 * 
 * All of these analyzers also use a {@link ExtractorFactory} to create sub
 * analyzers (for example a {@link PackageExtractor} uses a
 * {@link CompilationUnitExtractor}).
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class AnalyzerFactoryImpl implements ExtractorFactory {

	/**
	 * This is the factory, the created analyzers are using to create sub
	 * factories.
	 */
	private ExtractorFactory delegateFactory;

	public AnalyzerFactoryImpl() {
		delegateFactory = this;
	}

	public AnalyzerFactoryImpl(ExtractorFactory delegateFactory) {
		this.delegateFactory = delegateFactory;
	}

	@Override
	public PackageExtractor createPackageAnalyzer(IPackageFragment fragment) {
		return new PackageExtractor(fragment);
	}

	@Override
	public ProjectExtractor createProjectAnalyzer(IProject project) {
		return new ProjectExtractor(project, delegateFactory);
	}

	@Override
	public WorkspaceExtractor createWorkspaceAnalyzer(IWorkspace workspace) {
		return new WorkspaceExtractor(workspace, delegateFactory);
	}
}
