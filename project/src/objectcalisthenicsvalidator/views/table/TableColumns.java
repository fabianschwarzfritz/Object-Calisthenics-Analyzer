/**
 * 
 */
package objectcalisthenicsvalidator.views.table;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class TableColumns {

	private Table table;

	private TableColumn lineColumn;
	private TableColumn nameColumn;
	private TableColumn locationColumn;

	public TableColumns(Table table) {
		this.table = table;
		CreateColumn.line(table);
		CreateColumn.name(table);
		CreateColumn.location(table);
	}

}
