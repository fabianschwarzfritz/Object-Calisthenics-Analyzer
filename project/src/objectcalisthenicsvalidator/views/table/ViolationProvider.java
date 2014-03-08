package objectcalisthenicsvalidator.views.table;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.reporter.Reporter;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ViolationProvider implements IStructuredContentProvider, Reporter {

	private List<ViolationImpl> violations;

	public ViolationProvider() {
		violations = new ArrayList<ViolationImpl>();
	}

	@Override
	public void reportError(ViolationImpl violation) {
		violations.add(violation);
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {
		List<Object> result = new ArrayList<Object>();
		result.addAll(violations);
		return result.toArray();
	}

	public void clear() {
		violations = new ArrayList<ViolationImpl>();
	}

}
