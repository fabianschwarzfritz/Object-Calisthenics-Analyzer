/**
 * 
 */
package objectcalisthenicsvalidator.views.table;

import objectcalisthenicsvalidator.views.actions.OpenViolation;
import objectcalisthenicsvalidator.views.column.TableColumns;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IViewSite;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ViolationTable extends TableViewer implements IDoubleClickListener {

	private TableColumns columns;
	private Action openAction;

	public ViolationTable(Composite parent, ViolationProvider tableProvider,
			IViewSite viewSite) {
		super(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE
				| SWT.FULL_SELECTION);

		openAction = new OpenViolation(this);

		setupTable(tableProvider, viewSite);
		setupColumns();
		addDoubleClickListener(this);
	}

	private void setupTable(ViolationProvider tableProvider, IViewSite viewSite) {
		Table table = getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		setContentProvider(tableProvider);
		setLabelProvider(new TablelabelProvider());
		setInput(viewSite);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	private void setupColumns() {
		columns = new TableColumns(this);
		columns.each(new AddSortAction(this));
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		openAction.run();
	}

	public void moveBelow(Composite commonParent, Control control) {
		getControl().moveBelow(control);
		commonParent.layout();
	}

}
