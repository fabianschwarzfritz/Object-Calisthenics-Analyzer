package ocanalyzer.extractor.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;

public class WorkspaceExtractor implements CompilationUnitsExtractable {

	private ExtractorFactory factory;
	private IWorkspace workspace;

	public WorkspaceExtractor(IWorkspace workspace, ExtractorFactory factory) {
		this.workspace = workspace;
		this.factory = factory;
	}

	@Override
	public Collection<ICompilationUnit> extractCompilationUnits() {
		Collection<ICompilationUnit> resultUnits = new ArrayList<ICompilationUnit>();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] workspaceProjects = root.getProjects();
		for (IProject project : workspaceProjects) {
			try {
				resultUnits.addAll(getUnitsFrom(project));
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		return resultUnits;
	}

	public Collection<ICompilationUnit> getUnitsFrom(IProject project)
			throws JavaModelException {
		ProjectExtractor projectAnalyzer = factory
				.createProjectAnalyzer(project);
		Collection<ICompilationUnit> units = projectAnalyzer
				.extractCompilationUnits();
		return units;
	}

}
