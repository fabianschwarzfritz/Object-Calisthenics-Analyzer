/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import ocanalyzer.domain.Violation;
import ocanalyzer.domain.ViolationImpl;

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
		return false;
	}
}
