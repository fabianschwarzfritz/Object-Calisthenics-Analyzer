package objectcalisthenicsvalidator.views;

import ocanalyzer.handlers.ObjectCalisthenicsHandler;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class ObjectCalisthenicsView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "objectcalisthenicsvalidator.views.ObjectCalisthenicsView";

	private ObjectCalisthenicsHandler ocHandler;

	private TableViewer rulesViewer;
	private Action actionValidate;
	private Action actionSelectValidation;

	private TableColumn typeColumn;
	private TableColumn nameColumn;
	private TableColumn locationColumn;

	public ObjectCalisthenicsView() {
		ocHandler = new ObjectCalisthenicsHandler();
	}

	public void createPartControl(Composite parent) {
		rulesViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.MULTI | SWT.FULL_SELECTION);
		final Table table = rulesViewer.getTable();

		typeColumn = new TableColumn(table, SWT.LEFT);
		typeColumn.setText("Nr");
		typeColumn.setWidth(8);

		nameColumn = new TableColumn(table, SWT.LEFT);
		nameColumn.setText("Name");
		nameColumn.setWidth(100);

		locationColumn = new TableColumn(table, SWT.LEFT);
		locationColumn.setText("Location");
		locationColumn.setWidth(450);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		rulesViewer.setContentProvider(new ViewContentProvider());
		rulesViewer.setLabelProvider(new ViewLabelProvider());
		rulesViewer.setInput(getViewSite());

		// Create the help context id for the viewer's control
		PlatformUI
				.getWorkbench()
				.getHelpSystem()
				.setHelp(rulesViewer.getControl(),
						"ObjectCalisthenicsValidator.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void makeActions() {
		actionValidate = new Action() {
			public void run() {
				showMessage("Start to validate rules");
				try {
					ocHandler.execute(null);
				} catch (ExecutionException e) {
					e.printStackTrace();
					showMessage("Error validating rule: " + e.toString());
				}
			}
		};
		actionValidate.setText("Validate");
		actionValidate.setToolTipText("??");
		actionValidate.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		actionSelectValidation = new Action() {
			public void run() {
				ISelection selection = rulesViewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				showMessage("Double click: " + obj.toString());
			}
		};
	}

	private void hookContextMenu() {
		MenuManager menuManager = new MenuManager("#PopupMenu");
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ObjectCalisthenicsView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuManager.createContextMenu(rulesViewer.getControl());
		rulesViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuManager, rulesViewer);
	}

	private void hookDoubleClickAction() {
		rulesViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				actionSelectValidation.run();
			}
		});
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(actionValidate);
		manager.add(new Separator());
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(actionValidate);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(actionValidate);
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(rulesViewer.getControl().getShell(),
				"ObjectCalisthenicsView", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		rulesViewer.getControl().setFocus();
	}
}