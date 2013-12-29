/**
 * 
 */
package objectcalisthenicsvalidator.views.column;

import ocanalyzer.reporter.Violation;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class MessageColumn extends ViolationColumn {

	private String message;

	public MessageColumn(Table parent) {
		super(parent, SWT.LEFT);
		setText("Name");
		setWidth(100);
	}

	@Override
	public int getNumber() {
		return 2;
	}

	public int compare(Violation violation1, Violation violation2) {
		return violation1.getMessage().compareTo(violation2.getMessage());
	}

}
