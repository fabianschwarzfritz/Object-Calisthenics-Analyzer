/**
 * 
 */
package objectcalisthenicsvalidator.views.column;

import java.util.ArrayList;
import java.util.List;

import objectcalisthenicsvalidator.views.column.types.DegreeColumn;
import objectcalisthenicsvalidator.views.column.types.MessageColumn;
import objectcalisthenicsvalidator.views.column.types.NameColumn;
import objectcalisthenicsvalidator.views.column.types.PositionColumn;
import objectcalisthenicsvalidator.views.column.types.ResourceColumn;
import objectcalisthenicsvalidator.views.column.types.ViolationColumn;
import objectcalisthenicsvalidator.views.table.ViolationSorter;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Table;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class TableColumns {

	private List<ViolationColumn> columns;

	private NameColumn nameColumn;
	private MessageColumn messageColumn;
	private DegreeColumn degreeColumn;
	private PositionColumn positionColumn;
	private ResourceColumn resourceColumn;

	public TableColumns(TableViewer viewer) {
		Table table = viewer.getTable();

		initColumns(viewer, table);
	}

	private void initColumns(TableViewer viewer, Table table) {
		columns = new ArrayList<>();
		ViolationColumn nameColumn = new NameColumn(table);
		ViolationColumn messageColumn = new MessageColumn(table);
		ViolationColumn degreeColumn = new DegreeColumn(table);
		ViolationColumn positionColumn = new PositionColumn(table);
		ViolationColumn resourceColumn = new ResourceColumn(table);

		columns.add(nameColumn);
		columns.add(messageColumn);
		columns.add(degreeColumn);
		columns.add(positionColumn);
		columns.add(resourceColumn);

		determineFirstSort(viewer, table, nameColumn);
	}

	private void determineFirstSort(TableViewer viewer, Table table,
			ViolationColumn firstColumn) {
		ViolationColumn firstSortColumn = firstColumn;
		ViolationSorter violationSorter = new ViolationSorter(table,
				firstSortColumn);
		viewer.setSorter(violationSorter);
	}

	public void each(ColumnAction action) {
		for (ViolationColumn column : columns) {
			action.execute(column);
		}
	}

}
