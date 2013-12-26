package ocanalyzer.rules.r9_properties;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;

public class ReturnStatementVisitor extends ASTVisitor {

	private ReturnStatement returnStatement;
	private VariableBindings bindings;
	private ValidationHandler handler;

	public ReturnStatementVisitor(ReturnStatement node,
			VariableBindings bindings, ValidationHandler handler) {
		this.bindings = bindings;
		this.returnStatement = node;
		this.handler = handler;
	}

	public boolean visit(final SimpleName node) {
		Expression returnExpression = returnStatement.getExpression();
		if (returnExpression != null & !node.isDeclaration()) {
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
