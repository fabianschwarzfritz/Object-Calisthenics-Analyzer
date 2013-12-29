/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import java.util.Locale;

import ocanalyzer.reporter.Violation;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ViolationFilter extends ViewerFilter {

	private String searchString;

	public void setSearchText(String s) {
		this.searchString = ".*" + s.toLowerCase(Locale.ENGLISH) + ".*";
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		Violation violation = (Violation) element;
		ViolationMatcher matcher = new ViolationMatcher(searchString);
		return matcher.match(violation);
	}
}
