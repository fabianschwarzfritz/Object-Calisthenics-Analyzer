/**
 * 
 */
package objectcalisthenicsvalidator.views.column;

import objectcalisthenicsvalidator.views.table.ValidationSorter;

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
		ValidationSorter validationSorter = new ValidationSorter(table,
				firstSortColumn);
		viewer.setSorter(validationSorter);
	}

	public void each(ColumnAction action) {
		action.execute(lineColumn);
		action.execute(messageColumn);
		action.execute(locationColumn);
	}

}
