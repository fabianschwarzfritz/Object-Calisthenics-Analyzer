/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import ocanalyzer.dto.ViolationDTO;

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

	public boolean match(ViolationDTO violation) {
		return new ClassMatcher(searchString)
					.match(violation);
	}
}
