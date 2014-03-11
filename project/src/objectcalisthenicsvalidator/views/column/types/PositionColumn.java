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
public class PositionColumn extends ViolationColumn {

	public PositionColumn(Table parent) {
		super(parent, SWT.LEFT);
		setText("Position");
		setWidth(50);
	}

	@Override
	public int compare(ViolationDTO violation1, ViolationDTO violation2) {
		return violation1.getPosition().compareTo(violation2.getPosition());
	}

}
