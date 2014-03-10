package objectcalisthenicsvalidator.views.actions;

import ocanalyzer.Activator;
import ocanalyzer.dto.ViolationDTO;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
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

/**
 * This class represents an action called when opening an information screen for
 * a {@link Validation}.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class OpenViolation extends Action {

	private TableViewer rulesViewer;

	public OpenViolation(TableViewer rulesViewer) {
		super();
		this.rulesViewer = rulesViewer;
	}

	public void run() {
		openViolation();
	}

	private void openViolation() {
		ViolationDTO violation = selectedViolation();

		if (violation instanceof ViolationDTO) {
			ViolationDTO classViolation = (ViolationDTO) violation;
			IFile file = (IFile) classViolation.getResource();
			openClassViolation(classViolation, file);
		}
	}

	private void openClassViolation(ViolationDTO violation, IFile file) {
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
			Activator
					.getLogger()
					.log(new Status(
							Status.ERROR,
							Activator.PLUGIN_ID,
							"Error when opening editor containing the violation",
							coreException));
			showMessage("Error when opening the editor");
		}
	}

	private ViolationDTO selectedViolation() {
		ISelection selection = rulesViewer.getSelection();
		Object element = ((IStructuredSelection) selection).getFirstElement();
		ViolationDTO violation = (ViolationDTO) element;
		return violation;
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(rulesViewer.getControl().getShell(),
				"ObjectCalisthenicsView", message);
	}

}
