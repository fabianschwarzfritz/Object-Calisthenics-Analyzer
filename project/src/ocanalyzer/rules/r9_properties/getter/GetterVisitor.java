package ocanalyzer.rules.r9_properties.getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.r9_properties.VariableBindings;

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

	private ValidationHandler validationHandler;
	private VariableBindings bindings;

	public GetterVisitor(ValidationHandler validatonHandler) {
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
		for (Object object : list) {
			VariableDeclarationFragment variableDeclaration = (VariableDeclarationFragment) object;
			IVariableBinding binding = variableDeclaration.resolveBinding();
			bindings.add(binding);
		}
		return true;
	}

	@Override
	public boolean visit(ReturnStatement node) {
		node.accept(new ReturnStatementVisitor(node, bindings,
				validationHandler));
		return true;
	}
}
