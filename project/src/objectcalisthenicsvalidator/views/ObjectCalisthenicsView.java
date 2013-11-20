package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.actions.OpenViolation;
import objectcalisthenicsvalidator.views.actions.StartRuleValidation;
import ocanalyzer.handlers.ObjectCalisthenics;
import ocanalyzer.reporter.impl.ConsoleReporter;
import ocanalyzer.reporter.impl.DelegateReporter;
import ocanalyzer.reporter.impl.MarkerReporter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * This class represents the main view displaying information about rule
 * violations in the Object Calisthenics.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class ObjectCalisthenicsView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "objectcalisthenicsvalidator.views.ObjectCalisthenicsView";

	private ObjectCalisthenics ocHandler;
	private ViewContentProvider tableProvider;

	private TableViewer rulesViewer;
	private Action actionValidate;
	private Action actionSelectValidation;

	private TableColumn typeColumn;
	private TableColumn nameColumn;
	private TableColumn locationColumn;

	public ObjectCalisthenicsView() {
		tableProvider = new ViewContentProvider();
		DelegateReporter reporter = createDelegationReporter();
		ocHandler = new ObjectCalisthenics(reporter);
	}

	private DelegateReporter createDelegationReporter() {
		DelegateReporter reporter = new DelegateReporter();
		reporter.addClassReporter(new MarkerReporter());
		reporter.addClassReporter(new ConsoleReporter(System.out));
		reporter.addClassReporter(tableProvider);
		return reporter;
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

		rulesViewer.setContentProvider(tableProvider);
		rulesViewer.setLabelProvider(new ViewLabelProvider());
		rulesViewer.setInput(getViewSite());

		// Create the help context id for the viewer's control
		PlatformUI
				.getWorkbench()
				.getHelpSystem()
				.setHelp(rulesViewer.getControl(),
						"ObjectCalisthenicsValidator.viewer");

		actionValidate = new StartRuleValidation(ocHandler, tableProvider,
				rulesViewer);
		actionSelectValidation = new OpenViolation(rulesViewer);

		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
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
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(actionValidate);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		rulesViewer.getControl().setFocus();
	}
}
