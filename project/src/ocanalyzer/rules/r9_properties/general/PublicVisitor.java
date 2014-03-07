package ocanalyzer.rules.r9_properties.general;

import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Modifier;

public class PublicVisitor extends ASTVisitor {

	private ViolationHandler violationHandler;

	public PublicVisitor(ViolationHandler violationHandler) {
		this.violationHandler = violationHandler;
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		int modifiers = node.getModifiers();
		if (Modifier.isPublic(modifiers)) {
			violationHandler.printInfo(node);
		}
		return true;
	}
}
