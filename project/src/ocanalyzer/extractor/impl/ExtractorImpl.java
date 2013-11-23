package ocanalyzer.extractor.impl;

import java.util.Collection;

import ocanalyzer.extractor.Extractor;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;

public class ExtractorImpl implements Extractor {

	private ExtractorFactory factory;

	public ExtractorImpl() {
		factory = new AnalyzerFactoryImpl();
	}

	@Override
	public Collection<ICompilationUnit> extract() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		WorkspaceExtractor analyzer = factory
				.createWorkspaceAnalyzer(workspace);
		return analyzer.extractCompilationUnits();
	}
}
