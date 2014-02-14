/**
 * 
 */
package objectcalisthenicsvalidator.views.column;

import objectcalisthenicsvalidator.views.table.ViolationSorter;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Table;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class TableColumns {

	private LineColumn lineColumn;
	private MessageColumn messageColumn;
	private LocationColumn locationColumn;

	public TableColumns(TableViewer viewer) {
		Table table = viewer.getTable();
		lineColumn = new LineColumn(table);
		messageColumn = new MessageColumn(table);
		locationColumn = new LocationColumn(table);

		ViolationColumn firstSortColumn = lineColumn;
		ViolationSorter violationSorter = new ViolationSorter(table,
				firstSortColumn);
		viewer.setSorter(violationSorter);
	}

	public void each(ColumnAction action) {
		action.execute(lineColumn);
		action.execute(messageColumn);
		action.execute(locationColumn);
	}

}
