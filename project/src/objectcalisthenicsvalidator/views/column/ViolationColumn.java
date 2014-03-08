/**
 * 
 */
package objectcalisthenicsvalidator.views.column;

import ocanalyzer.domain.Violation;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public abstract class ViolationColumn extends TableColumn {

	public ViolationColumn(Table parent, int style) {
		super(parent, style);
	}

	public abstract int compare(Violation violation1, Violation violation2);

	@Override
	protected void checkSubclass() {
		// This is not a framework, it's just crap...
	}
}
