/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import ocanalyzer.dto.ViolationDTO;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
class ClassMatcher extends Matcher {

	public ClassMatcher(String searchString) {
		super(searchString);
	}

	public boolean match(ViolationDTO violation) {
		String line = "" + violation.getPosition();
		String name = violation.getClass().getName();
		String message = violation.getMessage();
		String resourceName = violation.getResource().getName();
		return match(name, message, resourceName, line);
	}
}
