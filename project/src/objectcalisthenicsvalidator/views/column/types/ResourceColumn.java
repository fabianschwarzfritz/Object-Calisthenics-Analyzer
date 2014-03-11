/**
 * 
 */
package objectcalisthenicsvalidator.views.column.types;

import ocanalyzer.domain.Violation;
import ocanalyzer.dto.ViolationDTO;

import org.eclipse.core.resources.IResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ResourceColumn extends ViolationColumn {

	private IResource resourece;

	public ResourceColumn(Table parent) {
		super(parent, SWT.LEFT);
		setText("Resource");
		setWidth(450);
	}

	@Override
	public int compare(ViolationDTO violation1, ViolationDTO violation2) {
		return violation1.getResourceName().compareTo(violation2.getResourceName());
	}

}
