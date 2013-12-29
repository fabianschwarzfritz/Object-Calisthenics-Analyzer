/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import ocanalyzer.reporter.PackageViolation;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class PackageMatcher extends Matcher {

	public PackageMatcher(String searchString) {
		super(searchString);
	}

	public boolean match(PackageViolation violation) {
		return match(violation.getClass().getName(), violation.getMessage(),
				violation.getResource().getName());
	}

}
