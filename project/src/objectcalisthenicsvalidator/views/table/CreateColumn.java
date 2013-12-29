/**
 * 
 */
package objectcalisthenicsvalidator.views.table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class CreateColumn {

	static TableColumn location(Table table) {
		TableColumn locationColumn = new TableColumn(table, SWT.LEFT);
		locationColumn.setText("Location");
		locationColumn.setWidth(450);
		return locationColumn;
	}

	static TableColumn name(Table table) {
		TableColumn nameColumn = new TableColumn(table, SWT.LEFT);
		nameColumn.setText("Name");
		nameColumn.setWidth(100);
		return nameColumn;
	}

	static TableColumn line(Table table) {
		TableColumn lineColumn = new TableColumn(table, SWT.LEFT);
		lineColumn.setText("Nr");
		lineColumn.setWidth(8);
		return lineColumn;
	}
}
