package objectcalisthenicsvalidator.views.column.types;

import ocanalyzer.dto.ViolationDTO;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

public class NameColumn extends ViolationColumn {

	public NameColumn(Table parent) {
		super(parent, SWT.LEFT);
		setText("Name");
		setWidth(100);
	}

	@Override
	public int compare(ViolationDTO violation1, ViolationDTO violation2) {
		return violation1.getName().compareTo(violation2.getName());
	}

}
