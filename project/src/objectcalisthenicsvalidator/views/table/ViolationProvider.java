package objectcalisthenicsvalidator.views.table;

import ocanalyzer.dto.RunDTO;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ViolationProvider implements IStructuredContentProvider {

	private RunDTO run;
	private ViolationTable table;

	public ViolationProvider() {
		this.run = new RunDTO();
	}

	public ViolationProvider(RunDTO run) {
		this.run = run;
	}

	public void setRun(RunDTO run) {
		this.run = run;
	}

	public void refreshUi() {
		table.refresh();
	}
	
	public void setTable(ViolationTable table) {
		this.table = table;
	}

	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public Object[] getElements(Object parent) {
		return run.getViolations().toArray();
	}

}
