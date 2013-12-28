package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.actions.OpenViolation;
import objectcalisthenicsvalidator.views.actions.StartRuleValidation;
import objectcalisthenicsvalidator.views.search.ViolationFilter;
import ocanalyzer.ObjectCalisthenics;
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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

	private ObjectCalisthenics ocHandler;
	private ViewContentProvider tableProvider;

	private TableViewer rulesViewer;
	private final ViolationFilter filter;
	private Action actionValidate;
	private Action actionSelectValidation;

	private TableColumn lineColumn;
	private TableColumn nameColumn;
	private TableColumn locationColumn;

	public ObjectCalisthenicsView() {
		tableProvider = new ViewContentProvider();
		DelegateReporter reporter = createDelegationReporter();
		ocHandler = ObjectCalisthenics.create(reporter);
		filter = new ViolationFilter();
	}

	private DelegateReporter createDelegationReporter() {
		DelegateReporter reporter = new DelegateReporter();
		reporter.addClassReporter(new MarkerReporter());
		// reporter.addClassReporter(new ConsoleReporter(System.out));
		reporter.addClassReporter(tableProvider);
		reporter.addPackageReporter(tableProvider);
		return reporter;
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout(1, true);
		parent.setLayout(layout);
		// parent.setBackground(new Color(parent.getDisplay(), 40, 24, 200));

		addFilter(parent);
		createTableViewer(parent);
		addSorting();
		
		actionValidate = new StartRuleValidation(ocHandler, tableProvider,
				rulesViewer);
		actionSelectValidation = new OpenViolation(rulesViewer);

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

	private void addSorting() {
		rulesViewer.setSorter(new ValidationSorter());
		addSort(lineColumn, 0);
		addSort(nameColumn, 1);
		addSort(locationColumn, 2);
	}

	public void addSort(TableColumn column, final int sort) {
		column.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				((ValidationSorter) rulesViewer.getSorter()).doSort(sort);
				rulesViewer.refresh();
			}
		});
	}

	private void createTableViewer(Composite parent) {
		rulesViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.SINGLE | SWT.FULL_SELECTION);
		final Table table = rulesViewer.getTable();

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
		rulesViewer.setLabelProvider(new ViewLabelProvider());
		rulesViewer.setInput(getViewSite());
		rulesViewer.addFilter(filter);

		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Create the help context id for the viewer's control
		// PlatformUI
		// .getWorkbench()
		// .getHelpSystem()
		// .setHelp(rulesViewer.getControl(),
		// "ObjectCalisthenicsValidator.viewer");
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
