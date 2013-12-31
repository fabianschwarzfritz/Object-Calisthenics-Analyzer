/**
 * 
 */
package objectcalisthenicsvalidator.views.table;

import objectcalisthenicsvalidator.views.column.ColumnAction;
import objectcalisthenicsvalidator.views.column.ViolationColumn;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class AddSortAction implements ColumnAction {

	private TableViewer viewer;

	public AddSortAction(TableViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void execute(final ViolationColumn column) {
		column.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				ViolationSorter sorter = (ViolationSorter) viewer.getSorter();
				sorter.doSort(column);
				viewer.refresh();
			}
		});
	}

}
