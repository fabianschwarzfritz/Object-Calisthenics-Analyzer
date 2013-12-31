package objectcalisthenicsvalidator.views;

import objectcalisthenicsvalidator.views.column.TableColumns;
import objectcalisthenicsvalidator.views.menu.Actions;
import objectcalisthenicsvalidator.views.menu.OcMenu;
import objectcalisthenicsvalidator.views.menu.OcToolbar;
import objectcalisthenicsvalidator.views.search.ViolationFilter;
import objectcalisthenicsvalidator.views.table.TablelabelProvider;
import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.ObjectCalisthenics;
import ocanalyzer.reporter.impl.DelegateReporter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
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

	private Actions menuActions;

	private TableColumns columns;

	public ObjectCalisthenicsView() {
		tableProvider = new ViolationProvider();
		DelegateReporter reporter = Create.reporter(tableProvider);
		oc = ObjectCalisthenics.create(reporter);
		filter = new ViolationFilter();
		menuActions = new Actions();
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
		menuActions.add(actionValidate);

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
	}

	private void hookDoubleClickAction() {
		rulesViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				actionSelectValidation = Create.openAction(rulesViewer);
				actionSelectValidation.run();
			}
		});
	}

	private void contributeToActionBars() {
		OcMenu theMenu = new OcMenu(rulesViewer, getSite(), menuActions);
		OcToolbar toolbar = new OcToolbar(getViewSite(), menuActions);
	}

	@Override
	public void setFocus() {
		rulesViewer.getControl().setFocus();
	}
}
