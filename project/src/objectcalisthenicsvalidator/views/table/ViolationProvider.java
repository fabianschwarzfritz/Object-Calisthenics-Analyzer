package objectcalisthenicsvalidator.views.table;

import ocanalyzer.dto.RunDTO;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ViolationProvider implements IStructuredContentProvider {

	private RunDTO run;

	public ViolationProvider() {
		this.run = new RunDTO();
	}

	public ViolationProvider(RunDTO run) {
		this.run = run;
	}

	public void setRun(RunDTO run) {
		this.run = run;
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
