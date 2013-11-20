package objectcalisthenicsvalidator.views;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.PackageViolation;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.reporter.Violation;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ViewContentProvider implements IStructuredContentProvider,
		Reporter {

	private List<PackageViolation> packageViolations;
	private List<Violation> violations;

	public ViewContentProvider() {
		violations = new ArrayList<Violation>();
		packageViolations = new ArrayList<PackageViolation>();
	}

	@Override
	public void reportError(Violation violation) {
		violations.add(violation);
	}

	@Override
	public void reportError(PackageViolation violation) {
		packageViolations.add(violation);
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {
		List<Object> result = new ArrayList<Object>();
		result.addAll(violations);
		result.addAll(packageViolations);
		return result.toArray();
	}

	public void clear() {
		violations = new ArrayList<Violation>();
		packageViolations = new ArrayList<PackageViolation>();
	}

}
