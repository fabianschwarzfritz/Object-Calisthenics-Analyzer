package objectcalisthenicsvalidator.views;

import ocanalyzer.reporter.RuleViolationReporter;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ViewContentProvider implements IStructuredContentProvider,
		RuleViolationReporter {

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {
		return new String[] {};
	}

	@Override
	public void reportError(IResource resource, int line, String msg) {
		// TODO Auto-generated method stub

	}
}
