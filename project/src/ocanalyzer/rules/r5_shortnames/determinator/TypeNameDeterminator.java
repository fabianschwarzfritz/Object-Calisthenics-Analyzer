package ocanalyzer.rules.r5_shortnames.determinator;

import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class TypeNameDeterminator {

	private ViolationHandlerImpl violationHandler;
	protected RegexMatcher matcher;

	public TypeNameDeterminator(ViolationHandlerImpl violationHandler) {
		this.violationHandler = violationHandler;
		this.matcher = new RegexMatcher(15, "([A-Z][a-z]+){1,2}");
	}

	public void shortName(TypeDeclaration node) {
		SimpleName name = node.getName();
		matcher.matches(name, node, violationHandler);
	}
}
