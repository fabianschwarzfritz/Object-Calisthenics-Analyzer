/**
 * 
 */
package objectcalisthenicsvalidator.views.column.types;

import ocanalyzer.dto.ViolationDTO;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class MessageColumn extends ViolationColumn {

	public MessageColumn(Table parent) {
		super(parent, SWT.LEFT);
		setText("Message");
		setWidth(100);
	}

	public int compare(ViolationDTO violation1, ViolationDTO violation2) {
		return violation1.getMessage().compareTo(violation2.getMessage());
	}

}
