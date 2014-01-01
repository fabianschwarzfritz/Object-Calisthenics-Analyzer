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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
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
		super(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.BORDER);

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
		getControl().setLayoutData(
				new GridData(GridData.FILL, GridData.FILL, true, true));

		getControl()
				.setBackground(new Color(table.getDisplay(), 140, 160, 190));
		getTable().setBackground(new Color(table.getDisplay(), 150, 60, 10));
	}

	private void setupColumns() {
		columns = new TableColumns(this);
		columns.each(new AddSortAction(this));
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		openAction.run();
	}

}
