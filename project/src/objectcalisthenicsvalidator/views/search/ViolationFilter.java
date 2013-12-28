/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import ocanalyzer.reporter.ClassViolation;
import ocanalyzer.reporter.PackageViolation;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ViolationFilter extends ViewerFilter {

	private String searchString;

	public ViolationFilter() {
		System.out.println("new one");
	}

	public void setSearchText(String s) {
		this.searchString = ".*" + s.toLowerCase() + ".*";
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		if (element instanceof ClassViolation) {
			ClassViolation classViolation = (ClassViolation) element;
			return match(classViolation);
		}
		if (element instanceof PackageViolation) {
			PackageViolation packageViolation = (PackageViolation) element;
			return match(packageViolation);
		}
		return false;
	}

	private boolean match(ClassViolation violation) {
		return violation.getClass().getName().toLowerCase()
				.matches(searchString)
				| violation.getMessage().toLowerCase().matches(searchString)
				| violation.getResource().getName().toLowerCase()
						.matches(searchString)
				| violation.getLine().toString().toLowerCase()
						.matches(searchString);
	}

	private boolean match(PackageViolation violation) {
		return violation.getClass().getName().toLowerCase()
				.matches(searchString)
				| violation.getMessage().toLowerCase().matches(searchString)
				| violation.getResource().getName().toLowerCase()
						.matches(searchString);
	}

}
