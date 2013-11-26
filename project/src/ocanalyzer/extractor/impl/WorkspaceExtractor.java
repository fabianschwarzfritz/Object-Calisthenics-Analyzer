package ocanalyzer.extractor.impl;

import ocanalyzer.rules.general.ICompilationUnits;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jdt.core.JavaModelException;

public class WorkspaceExtractor implements CompilationUnitsExtractable {

	private ExtractorFactory factory;
	private IWorkspace workspace;

	public WorkspaceExtractor(IWorkspace workspace, ExtractorFactory factory) {
		this.workspace = workspace;
		this.factory = factory;
	}

	@Override
	public ICompilationUnits extractCompilationUnits() {
		ICompilationUnits units = new ICompilationUnits();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] workspaceProjects = root.getProjects();
		for (IProject project : workspaceProjects) {
			try {
				units.addAll(getUnitsFrom(project));
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		return units;
	}

	public ICompilationUnits getUnitsFrom(IProject project)
			throws JavaModelException {
		ProjectExtractor projectAnalyzer = factory
				.createProjectAnalyzer(project);
		ICompilationUnits units = projectAnalyzer.extractCompilationUnits();
		return units;
	}

}
