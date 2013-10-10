package ocanalyzer.test.integration.mock;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.ProjectAnalyzer;

import org.eclipse.core.resources.IProject;

public class ProjectAnalyzerMock extends ProjectAnalyzer {

	public ProjectAnalyzerMock(IProject project, AnalyzerFactory factory) {
		super(project, factory);
	}

}
