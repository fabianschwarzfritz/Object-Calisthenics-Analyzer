package ocanalyzer.analyzer.factory;

import ocanalyzer.analyzer.factory.extractor.CompilationUnitExtractor;
import ocanalyzer.analyzer.factory.extractor.PackageExtractor;
import ocanalyzer.analyzer.factory.extractor.ProjectExtractor;
import ocanalyzer.analyzer.factory.extractor.WorkspaceExtractor;
import ocanalyzer.reporter.PackageReporter;

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
	private PackageReporter writer;

	public AnalyzerFactoryImpl(PackageReporter writer) {
		this.writer = writer;
		delegateFactory = this;
	}

	public AnalyzerFactoryImpl(ExtractorFactory delegateFactory) {
		this.delegateFactory = delegateFactory;
	}

	@Override
	public CompilationUnitExtractor createCompilationUnitAnalyzer(
			ICompilationUnit compilationUni) {
		return new CompilationUnitExtractor(compilationUni);
	}

	@Override
	public PackageExtractor createPackageAnalyzer(IPackageFragment fragment) {
		return new PackageExtractor(fragment, delegateFactory, writer);
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
