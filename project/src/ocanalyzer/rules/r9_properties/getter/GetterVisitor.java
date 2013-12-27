package ocanalyzer.rules.r9_properties.getter;

import java.util.List;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.general.ViolationHandlerImpl;
import ocanalyzer.rules.r9_properties.VariableBindings;
import ocanalyzer.rules.r9_properties.general.ContainsBindingsVisitor;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

/**
 * 
 * This class is used find all rule violations of getters/setters/properties
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class GetterVisitor extends ASTVisitor {

	public ViolationHandlerImpl validationHandler;
	public VariableBindings bindings;

	public GetterVisitor(ViolationHandlerImpl validatonHandler) {
		this.validationHandler = validatonHandler;
		bindings = new VariableBindings();
	}

	public void endVisit(TypeDeclaration node) {
		bindings.clear();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean visit(FieldDeclaration node) {
		List list = node.fragments();
		VariableBindings bindings = new VariableBindings();
		for (Object object : list) {
			VariableDeclarationFragment variableDeclaration = (VariableDeclarationFragment) object;
			IVariableBinding binding = variableDeclaration.resolveBinding();
			bindings.add(binding);
		}
		return true;
	}

	@Override
	public void endVisit(ReturnStatement node) {
		Expression expressionNode = node.getExpression();
		node.accept(new ContainsBindingsVisitor(expressionNode, bindings,
				validationHandler));
	}

}
