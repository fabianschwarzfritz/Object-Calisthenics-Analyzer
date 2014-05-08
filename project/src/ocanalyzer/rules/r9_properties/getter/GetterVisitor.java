package ocanalyzer.rules.r9_properties.getter;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.r9_properties.general.ContainsBindingsVisitor;
import ocanalyzer.rules.r9_properties.general.Extract;
import ocanalyzer.rules.r9_properties.general.VariableBindings;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * 
 * This class is used find all rule violations of getters/setters/properties
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class GetterVisitor extends ASTVisitor {

	private ViolationHandler violationHandler;
	private VariableBindings bindings;

	public GetterVisitor(ViolationHandler violationHandler) {
		this.violationHandler = violationHandler;
		bindings = new VariableBindings();
	}

	public void endVisit(TypeDeclaration node) {
		bindings.clear();
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		Extract.the(node).into(bindings);
		return true;
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		int modifiers = node.getModifiers();
		boolean static1 = Modifier.isStatic(modifiers);
		boolean private1 = Modifier.isPrivate(modifiers);
		return !static1 & !private1;
	}

	@Override
	public boolean visit(ReturnStatement node) {
		Expression expression = node.getExpression();
		ContainsBindingsVisitor containsBindingsVisitor = new ContainsBindingsVisitor(
				expression, bindings, violationHandler);
		node.accept(containsBindingsVisitor);
		return true;
	}
}
