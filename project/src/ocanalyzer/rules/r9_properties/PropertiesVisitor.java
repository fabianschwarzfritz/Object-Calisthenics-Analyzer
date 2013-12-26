package ocanalyzer.rules.r9_properties;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

/**
 * 
 * This class is used find all rule violations of getters/setters/properties
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class PropertiesVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	private Expression returnExpression;
	private Set<IVariableBinding> bindings;

	public PropertiesVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
		bindings = new HashSet<>();
	}

	public void endVisit(TypeDeclaration node) {
		bindings = new HashSet<>();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean visit(FieldDeclaration node) {
		List list = node.fragments();
		for (Object object : list) {
			VariableDeclarationFragment variableDeclaration = (VariableDeclarationFragment) object;
			IVariableBinding binding = variableDeclaration.resolveBinding();
			bindings.add(binding);
		}
		return true;
	}

	@Override
	public boolean visit(ReturnStatement node) {
		returnExpression = node.getExpression();
		return true;
	}

	public void endVisit(ReturnStatement node) {
		returnExpression = null;
	}

	public boolean visit(final SimpleName node) {
		if (returnExpression != null & !node.isDeclaration()) {
			final IBinding nodeBinding = node.resolveBinding();
			if (nodeBinding instanceof IVariableBinding) {
				determineFieldBinding(node, nodeBinding);
			}
		}
		return true;
	}

	private void determineFieldBinding(SimpleName node, IBinding binding) {
		boolean contains = bindings.contains(binding);
		if (contains) {
			validationHandler.printInfo(node);
		}
	}

}
