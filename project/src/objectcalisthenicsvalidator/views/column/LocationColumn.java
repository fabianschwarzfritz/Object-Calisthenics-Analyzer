/**
 * 
 */
package objectcalisthenicsvalidator.views.column;

import ocanalyzer.reporter.Violation;

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
		setText("Location");
		setWidth(450);
	}

	@Override
	public int compare(Violation violation1, Violation violation2) {
		return violation1.getMessage().compareTo(violation2.getMessage());
	}

}
