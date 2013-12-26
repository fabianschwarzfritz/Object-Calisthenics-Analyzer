package ocanalyzer.rules.r9_properties.general;

import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.r9_properties.VariableBindings;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.SimpleName;

public class ContainsBindingsVisitor extends ASTVisitor {

	private Expression expression;
	private VariableBindings bindings;
	private ValidationHandler handler;

	public ContainsBindingsVisitor(Expression node, VariableBindings bindings,
			ValidationHandler handler) {
		this.bindings = bindings;
		this.expression = node;
		this.handler = handler;
	}

	public boolean visit(final SimpleName node) {
		if (expression != null & !node.isDeclaration()) {
			final IBinding nodeBinding = node.resolveBinding();
			bindingCorrect(node, nodeBinding);
		}
		return true;
	}

	private void bindingCorrect(final SimpleName node,
			final IBinding nodeBinding) {
		if (nodeBinding instanceof IVariableBinding) {
			IVariableBinding variableBinding = (IVariableBinding) nodeBinding;
			determineFieldBinding(node, variableBinding);
		}
	}

	private void determineFieldBinding(SimpleName node, IVariableBinding binding) {
		bindings.print(binding, node, handler);
	}
}
