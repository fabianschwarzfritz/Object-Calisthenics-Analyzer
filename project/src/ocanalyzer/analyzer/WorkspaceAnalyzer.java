package ocanalyzer.analyzer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class WorkspaceAnalyzer implements CompilationUnitsExtractable {

	private AnalyzerFactory factory;
	private IWorkspace workspace;

	public WorkspaceAnalyzer(IWorkspace workspace, AnalyzerFactory factory) {
		this.workspace = workspace;
		this.factory = factory;
	}

	@Override
	public List<CompilationUnit> extractCompilationUnits() {
		List<CompilationUnit> resultUnits = new ArrayList<CompilationUnit>();
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

	public List<CompilationUnit> getUnitsFrom(IProject project)
			throws JavaModelException {
		ProjectAnalyzer projectAnalyzer = factory
				.createProjectAnalyzer(project);
		List<CompilationUnit> units = projectAnalyzer.extractCompilationUnits();
		return units;
	}

}
