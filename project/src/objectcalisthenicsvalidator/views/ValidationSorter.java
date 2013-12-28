package objectcalisthenicsvalidator.views;

import ocanalyzer.reporter.Violation;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class ValidationSorter extends ViewerSorter {

	private static final int ASCENDING = 0;
	private static final int DESCENDING = 1;

	private int column;

	private int direction;

	public void doSort(int column) {
		if (column == this.column) {
			direction = 1 - direction;
			return;
		}
		this.column = column;
		direction = ASCENDING;
	}

	public int compare(Viewer viewer, Object e1, Object e2) {
		int result = 0;
		Violation violation1 = (Violation) e1;
		Violation violation2 = (Violation) e2;
		if (column == 1) {
			result = compareResource(violation1, violation2);
		} else if (column == 2) {
			result = compareMessage(violation1, violation2);
		}
		if (direction == DESCENDING)
			result = -result;
		return result;
	}

	private int compareMessage(Violation violation1, Violation violation2) {
		return violation1.getMessage().compareTo(violation2.getMessage());
	}

	private int compareResource(Violation violation1, Violation violation2) {
		return violation1.getResource().getName()
				.compareTo(violation2.getResource().getName());
	}
}
