package objectcalisthenicsvalidator.views;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.reporter.Violation;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ViewContentProvider implements IStructuredContentProvider,
		RuleViolationReporter {

	private List<Violation> violations;

	public ViewContentProvider() {
		violations = new ArrayList<Violation>();
	}

	@Override
	public void reportError(IResource resource, int line, String msg) {
		violations.add(new Violation(resource, line, msg));
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
