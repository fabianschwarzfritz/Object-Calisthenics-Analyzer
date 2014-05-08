package ocanalyzer.rules.r9_properties.general;

import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.SimpleName;

public class ContainsBindingsVisitor extends ASTVisitor {

	private Expression returnStatement;
	private VariableBindings bindings;
	private ViolationHandler handler;

	public ContainsBindingsVisitor(Expression expression,
			VariableBindings bindings, ViolationHandler handler) {
		this.returnStatement = expression;
		this.bindings = bindings;
		this.handler = handler;
	}

	public boolean visit(final SimpleName node) {
		if (node != null) {
			IBinding binding = node.resolveBinding();
			bindingCorrect(node, binding);
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
