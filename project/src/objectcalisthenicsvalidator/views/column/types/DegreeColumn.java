package objectcalisthenicsvalidator.views.column.types;

import ocanalyzer.dto.ViolationDTO;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

public class DegreeColumn extends ViolationColumn {

	public DegreeColumn(Table parent) {
		super(parent, SWT.LEFT);
		setText("Degree");
		setWidth(100);
	}

	@Override
	public int compare(ViolationDTO violation1, ViolationDTO violation2) {
		return violation1.getDegree().compareTo(violation2.getDegree());
	}

}
