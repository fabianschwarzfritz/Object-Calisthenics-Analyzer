package ocanalyzer.rules.r5_shortnames.determinator;

import ocanalyzer.rules.general.ValidationHandlerImpl;

import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class TypeNameDeterminator {

	private ValidationHandlerImpl validationHandler;
	protected RegexMatcher matcher;

	public TypeNameDeterminator(ValidationHandlerImpl validationHandler) {
		this.validationHandler = validationHandler;
		this.matcher = new RegexMatcher(15, "([A-Z][a-z0-9]+){1,2}");
	}

	public void shortName(TypeDeclaration node) {
		SimpleName name = node.getName();
		matcher.matches(name, node, validationHandler);
	}
}
