/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import ocanalyzer.reporter.ClassViolation;
import ocanalyzer.reporter.PackageViolation;
import ocanalyzer.reporter.Violation;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
class ViolationMatcher {

	private String searchString;

	public ViolationMatcher(String searchString) {
		super();
		this.searchString = searchString;
	}

	public boolean match(Violation violation) {
		if (violation instanceof ClassViolation) {
			return new ClassMatcher(searchString)
					.match((ClassViolation) violation);
		}
		if (violation instanceof PackageViolation) {
			return new PackageMatcher(searchString)
					.match((PackageViolation) violation);
		}
		return false;
	}
}
