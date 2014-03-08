/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import ocanalyzer.reporter.ViolationImpl;
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
		if (violation instanceof ViolationImpl) {
			return new ClassMatcher(searchString)
					.match((ViolationImpl) violation);
		}
		if (violation instanceof PackageViolation) {
			return new PackageMatcher(searchString)
					.match((PackageViolation) violation);
		}
		return false;
	}
}
