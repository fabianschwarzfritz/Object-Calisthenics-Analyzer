package ocanalyzer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.JavaModelException;

public class WorkspaceHandler extends AbstractHandler {

	private static final String JDT_NATURE = "org.eclipse.jdt.core.javanature";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();

		IProject[] workspaceProjects = root.getProjects();
		for (IProject project : workspaceProjects) {
			try {
				addProject(project);
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public void addProject(IProject project) throws JavaModelException {
		ProjectHandler handler = new ProjectHandler(project);
		handler.analyze();
	}

}
