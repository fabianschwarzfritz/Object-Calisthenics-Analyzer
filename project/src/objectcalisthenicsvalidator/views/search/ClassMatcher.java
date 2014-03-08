/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import ocanalyzer.reporter.ViolationImpl;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
class ClassMatcher extends Matcher {

	public ClassMatcher(String searchString) {
		super(searchString);
	}

	public boolean match(ViolationImpl violation) {
		return match(violation.getClass().getName(), violation.getMessage(),
				violation.getResource().getName(), violation.getLine()
						.toString());
	}

}
