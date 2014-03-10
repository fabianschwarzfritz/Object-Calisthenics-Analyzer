/**
 * 
 */
package objectcalisthenicsvalidator.views.column;

import ocanalyzer.dto.ViolationDTO;

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

	public int compare(ViolationDTO violation1, ViolationDTO violation2) {
		return violation1.getPosition().compareTo(violation2.getPosition());
	}

}
