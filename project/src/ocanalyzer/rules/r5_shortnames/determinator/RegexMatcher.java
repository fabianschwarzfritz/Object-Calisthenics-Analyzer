package ocanalyzer.rules.r5_shortnames.determinator;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.SimpleName;

public class RegexMatcher {

	private int maxlength;
	private String pattern;

	public RegexMatcher(int maxlength, String pattern) {
		this.maxlength = maxlength;
		this.pattern = pattern;
	}

	public void matches(SimpleName name, ASTNode node,
			ValidationHandler validationHandler) {
		String shortname = name.getIdentifier();
		if (!matchesConditions(shortname)) {
			validationHandler.printInfo(node);
		}
	}

	public boolean matchesConditions(String shortname) {
		boolean length = shortname.length() < maxlength;
		boolean matches = shortname.matches(pattern);
		return length & matches;
	}

}
