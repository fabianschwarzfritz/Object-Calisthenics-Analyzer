package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.column.TableColumns;
import objectcalisthenicsvalidator.views.search.ViolationFilter;
import objectcalisthenicsvalidator.views.table.TablelabelProvider;
import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.ObjectCalisthenics;
import ocanalyzer.reporter.impl.DelegateReporter;

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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
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

	private ObjectCalisthenics oc;
	private ViolationProvider tableProvider;

	private TableViewer rulesViewer;
	private ViolationFilter filter;
	private Action actionValidate;
	private Action actionSelectValidation;

	private Table table;

	private TableColumns columns;

	public ObjectCalisthenicsView() {
		tableProvider = new ViolationProvider();
		DelegateReporter reporter = Create.reporter(tableProvider);
		oc = ObjectCalisthenics.create(reporter);
		filter = new ViolationFilter();
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout(1, true);
		parent.setLayout(layout);

		createTableViewer(parent);
		columns = new TableColumns(rulesViewer);
		Create.filter(parent, rulesViewer, filter);
		Create.sorting(rulesViewer, columns);

		actionValidate = Create.startAction(oc, tableProvider, rulesViewer);
		actionSelectValidation = Create.openAction(rulesViewer);
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void createTableViewer(Composite parent) {
		rulesViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.SINGLE | SWT.FULL_SELECTION);
		table = rulesViewer.getTable();

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		rulesViewer.setContentProvider(tableProvider);
		rulesViewer.setLabelProvider(new TablelabelProvider());
		rulesViewer.setInput(getViewSite());
		rulesViewer.addFilter(filter);

		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
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

	@Override
	public void setFocus() {
		rulesViewer.getControl().setFocus();
	}
}
