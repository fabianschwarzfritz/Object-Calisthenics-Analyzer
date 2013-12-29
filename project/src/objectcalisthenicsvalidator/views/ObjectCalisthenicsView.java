package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.search.ViolationFilter;
import objectcalisthenicsvalidator.views.table.TablelabelProvider;
import objectcalisthenicsvalidator.views.table.ValidationSorter;
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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
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

	private TableColumn lineColumn;
	private TableColumn nameColumn;
	private TableColumn locationColumn;

	private Table table;

	private ValidationSorter validationSorter;

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

		addFilter(parent);
		createTableViewer(parent);
		Create.sorting(rulesViewer, lineColumn, nameColumn, locationColumn);

		actionValidate = Create.startAction(oc, tableProvider, rulesViewer);
		actionSelectValidation = Create.openAction(rulesViewer);
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void addFilter(Composite parent) {
		Label searchLabel = new Label(parent, SWT.NONE);
		searchLabel.setText("Search: ");
		final Text searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
		searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_FILL));
		searchText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				filter.setSearchText(searchText.getText());
				rulesViewer.refresh();
			}
		});
	}

	private void createTableViewer(Composite parent) {
		rulesViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.SINGLE | SWT.FULL_SELECTION);
		table = rulesViewer.getTable();

		lineColumn = new TableColumn(table, SWT.LEFT);
		lineColumn.setText("Nr");
		lineColumn.setWidth(8);

		nameColumn = new TableColumn(table, SWT.LEFT);
		nameColumn.setText("Name");
		nameColumn.setWidth(100);

		locationColumn = new TableColumn(table, SWT.LEFT);
		locationColumn.setText("Location");
		locationColumn.setWidth(450);

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
