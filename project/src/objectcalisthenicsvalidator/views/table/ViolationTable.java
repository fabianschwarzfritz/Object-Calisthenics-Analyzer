/**
 * 
 */
package objectcalisthenicsvalidator.views.table;

import objectcalisthenicsvalidator.views.Create;
import objectcalisthenicsvalidator.views.actions.OpenViolation;
import objectcalisthenicsvalidator.views.column.TableColumns;
import objectcalisthenicsvalidator.views.search.ViolationFilter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IViewSite;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ViolationTable extends TableViewer implements IDoubleClickListener {

	private ViolationFilter filter;
	private Table table;
	private TableColumns columns;
	private Action openAction;

	public ViolationTable(Composite parent, ViolationProvider tableProvider,
			IViewSite viewSite) {
		super(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE
				| SWT.FULL_SELECTION);

		openAction = new OpenViolation(this);
		filter = new ViolationFilter();

		setupTable(tableProvider, viewSite);
		setupFilter(parent);
		setupColumns();
	}

	private void setupColumns() {
		columns = new TableColumns(this);
		Create.sorting(this, columns);
	}

	private void setupFilter(Composite parent) {
		addFilter(filter);
		Create.filter(parent, this, filter);
	}

	private void setupTable(ViolationProvider tableProvider, IViewSite viewSite) {
		getTable().setHeaderVisible(true);
		getTable().setLinesVisible(true);
		setContentProvider(tableProvider);
		setLabelProvider(new TablelabelProvider());
		setInput(viewSite);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		openAction.run();
	}

}
