package objectcalisthenicsvalidator.views.actions;

import ocanalyzer.Activator;
import ocanalyzer.reporter.Violation;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class OpenViolation extends Action {

	private TableViewer rulesViewer;

	public OpenViolation(TableViewer rulesViewer) {
		super();
		this.rulesViewer = rulesViewer;
	}

	public void run() {
		Violation violation = selectedViolation();
		IFile file = (IFile) violation.getResource();

		openViolationInEditor(violation, file);
	}

	private void openViolationInEditor(Violation violation, IFile file) {
		IEditorInput editorInput = new FileEditorInput(file);
		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();

		IEditorDescriptor editorDescriptor = Activator.getDefault()
				.getWorkbench().getEditorRegistry()
				.getDefaultEditor(violation.getResource().getName());
		try {
			page.openEditor(editorInput, editorDescriptor.getId());
		} catch (PartInitException coreException) {
			coreException.printStackTrace();
			showMessage("Error: " + coreException.toString());
		}
	}

	private Violation selectedViolation() {
		ISelection selection = rulesViewer.getSelection();
		Object element = ((IStructuredSelection) selection).getFirstElement();
		Violation violation = (Violation) element;
		return violation;
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(rulesViewer.getControl().getShell(),
				"ObjectCalisthenicsView", message);
	}

}