/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import java.util.Locale;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
class Matcher {

	private String searchString;

	public Matcher(String searchString) {
		super();
		this.searchString = searchString;
	}

	protected boolean match(String... string) {
		boolean result = false;
		for (String value : string) {
			result |= value.trim().toLowerCase(Locale.ENGLISH)
					.matches(searchString);
		}
		return result;
	}

}
