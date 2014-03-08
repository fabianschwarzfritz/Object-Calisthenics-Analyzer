/**
 * 
 */
package objectcalisthenicsvalidator.views.column;

import ocanalyzer.domain.Violation;

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
		setText("Violation");
		setWidth(100);
	}

	public int compare(Violation violation1, Violation violation2) {
		return violation1.getResource().getName()
				.compareTo(violation2.getResource().getName());
	}

}
