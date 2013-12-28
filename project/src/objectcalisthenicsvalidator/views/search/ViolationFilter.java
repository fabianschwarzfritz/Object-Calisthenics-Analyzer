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
		return match(violation.getClass().getName(), violation.getMessage(),
				violation.getResource().getName(), violation.getLine()
						.toString());
	}

	private boolean match(PackageViolation violation) {
		return match(violation.getClass().getName(), violation.getMessage(),
				violation.getResource().getName());
	}

	private boolean match(String... string) {
		boolean result = false;
		for (String value : string) {
			result |= value.trim().toLowerCase().matches(searchString);
		}
		return result;
	}

}
