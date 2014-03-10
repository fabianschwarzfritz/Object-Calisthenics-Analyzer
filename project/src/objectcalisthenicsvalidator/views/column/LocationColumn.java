/**
 * 
 */
package objectcalisthenicsvalidator.views.column;

import ocanalyzer.domain.Violation;
import ocanalyzer.dto.ViolationDTO;

import org.eclipse.core.resources.IResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class LocationColumn extends ViolationColumn {

	private IResource resourece;

	public LocationColumn(Table parent) {
		super(parent, SWT.LEFT);
		setText("Resource");
		setWidth(450);
	}

	@Override
	public int compare(ViolationDTO violation1, ViolationDTO violation2) {
		return violation1.getMessage().compareTo(violation2.getMessage());
	}

}
