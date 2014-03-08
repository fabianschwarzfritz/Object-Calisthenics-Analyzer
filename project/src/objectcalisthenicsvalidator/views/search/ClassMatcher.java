/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import ocanalyzer.domain.ViolationImpl;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
class ClassMatcher extends Matcher {

	public ClassMatcher(String searchString) {
		super(searchString);
	}

	public boolean match(ViolationImpl violation) {
		String line = "" + violation.getLine();
		String name = violation.getClass().getName();
		String message = violation.getMessage();
		String resourceName = violation.getResource().getName();
		return match(name, message, resourceName, line);
	}
}
