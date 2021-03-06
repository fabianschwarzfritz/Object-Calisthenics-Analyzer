package ocanalyzer.rules.r5_shortnames.determinator;

import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclaration;

public class VariableNameDeterminator {

	private ViolationHandler violationHandler;
	protected RegexMatcher matcher;

	public VariableNameDeterminator(ViolationHandler violationHandler) {
		this.violationHandler = violationHandler;
		this.matcher = new RegexMatcher(15, "([a-z]+[A-Z]{0,1}[a-z]+)");
	}

	public void shortName(VariableDeclaration node) {
		SimpleName name = node.getName();
		matcher.matches(name, node, violationHandler);
	}
}
