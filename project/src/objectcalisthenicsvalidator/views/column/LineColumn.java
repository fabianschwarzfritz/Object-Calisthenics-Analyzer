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
public class LineColumn extends ViolationColumn {

	private int line;

	public LineColumn(Table parent) {
		super(parent, SWT.LEFT);
		setText("Line");
		setWidth(8);
	}

	@Override
	public int compare(Violation violation1, Violation violation2) {
		return 0;
	}

}
