package ocanalyzer.extractor.impl;

import ocanalyzer.extractor.Extractor;
import ocanalyzer.rules.general.ICompilationUnits;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;

public class ExtractorImpl implements Extractor {

	private ExtractorFactory factory;

	public ExtractorImpl() {
		factory = new AnalyzerFactoryImpl();
	}

	@Override
	public ICompilationUnits extract() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		WorkspaceExtractor analyzer = factory
				.createWorkspaceAnalyzer(workspace);
		return analyzer.extractCompilationUnits();
	}
}
