package ocanalyzer.analyzer.factory.extractor;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.analyzer.factory.ExtractorFactory;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class WorkspaceExtractor implements CompilationUnitsExtractable {

	private ExtractorFactory factory;
	private IWorkspace workspace;

	public WorkspaceExtractor(IWorkspace workspace, ExtractorFactory factory) {
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
		ProjectExtractor projectAnalyzer = factory
				.createProjectAnalyzer(project);
		List<CompilationUnit> units = projectAnalyzer.extractCompilationUnits();
		return units;
	}

}
