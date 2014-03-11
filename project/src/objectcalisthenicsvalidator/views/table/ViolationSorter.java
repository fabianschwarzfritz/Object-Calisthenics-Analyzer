package objectcalisthenicsvalidator.views.table;

import objectcalisthenicsvalidator.views.column.types.ViolationColumn;
import ocanalyzer.domain.Violation;
import ocanalyzer.dto.ViolationDTO;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

public class ViolationSorter extends ViewerSorter {

	private static final int ASCENDING = 0;
	private static final int DESCENDING = 1;

	private Table table;

	private ViolationColumn column;
	private int direction;

	public ViolationSorter(Table table, ViolationColumn firstSortColumn) {
		this.table = table;
		this.column = firstSortColumn;
		doSort(firstSortColumn);
	}

	public void doSort(ViolationColumn column) {
		if (this.column == column) {
			changeSortDirection();
			return;
		}
		this.column = column;
		direction = ASCENDING;
		adjustArrow();

		table.setSortColumn(column);
	}

	private void changeSortDirection() {
		direction = 1 - direction;
		adjustArrow();
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		ViolationDTO violation1 = (ViolationDTO) e1;
		ViolationDTO violation2 = (ViolationDTO) e2;

		int result = column.compare(violation1, violation2);
		if (direction == DESCENDING) {
			result = -result;
		}
		return result;
	}

	public void adjustArrow() {
		table.setSortDirection(direction == ASCENDING ? SWT.UP : SWT.DOWN);
	}
}
