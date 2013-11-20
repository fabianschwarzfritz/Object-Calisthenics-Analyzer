package objectcalisthenicsvalidator.views;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.reporter.Violation;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ViewContentProvider implements IStructuredContentProvider,
		ClassReporter {

	private List<Violation> violations;

	public ViewContentProvider() {
		violations = new ArrayList<Violation>();
	}

	@Override
	public void reportError(Violation violation) {
		violations.add(violation);
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {
		return violations.toArray();
	}

	public void clear() {
		violations = new ArrayList<Violation>();
	}

}
