/**
 * 
 */
package objectcalisthenicsvalidator.views.table;

import objectcalisthenicsvalidator.views.Create;
import objectcalisthenicsvalidator.views.actions.OpenViolation;
import objectcalisthenicsvalidator.views.column.TableColumns;
import objectcalisthenicsvalidator.views.search.SearchAdapter;
import objectcalisthenicsvalidator.views.search.ViolationFilter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewSite;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ViolationTable extends TableViewer implements IDoubleClickListener {

	private ViolationFilter filter;
	private TableColumns columns;
	private Action openAction;

	public ViolationTable(Composite parent, ViolationProvider tableProvider,
			IViewSite viewSite) {
		super(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE
				| SWT.FULL_SELECTION);

		openAction = new OpenViolation(this);
		filter = new ViolationFilter();

		setupFilter(parent);
		
		setupTable(tableProvider, viewSite);
		setupColumns();
		addDoubleClickListener(this);
	}

	private void setupFilter(Composite parent) {
		addFilter(filter);

		Label label = new Label(parent, SWT.NONE);
		label.setText("Search: ");

		Text text = new Text(parent, SWT.BORDER | SWT.SEARCH);
		text.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_FILL));
		text.addKeyListener(new SearchAdapter(this, filter, text));
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
		Create.sorting(this, columns);
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		openAction.run();
	}

}
