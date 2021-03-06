package ocanalyzer.rules.r9_properties.setter;

import java.util.List;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.r9_properties.general.Extract;
import ocanalyzer.rules.r9_properties.general.VariableBindings;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class SetterVisitor extends ASTVisitor {

	private ViolationHandler violationHandler;
	private VariableBindings parameterBindings;

	public SetterVisitor(ViolationHandler violationHandler) {
		this.violationHandler = violationHandler;
		parameterBindings = new VariableBindings();
	}

	public void endVisit(TypeDeclaration node) {
		parameterBindings.clear();
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		Extract.the(node).into(parameterBindings);
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean visit(MethodDeclaration node) {
		if (node.isConstructor()) {
			return false;
		}
		parameterBindings = new VariableBindings();
		List parameters = node.parameters();
		if (parameters.size() == 1) {
			SingleVariableDeclaration variableDeclaration = (SingleVariableDeclaration) parameters
					.get(0);
			IVariableBinding resolveBinding = variableDeclaration
					.resolveBinding();
			parameterBindings.add(resolveBinding);
			return true;
		}
		return false;
	}

	public void endVisit(MethodDeclaration node) {
		parameterBindings.clear();
	}

	@Override
	public void endVisit(Assignment node) {
		if (leftsideIsField(node) & rightsideIsParameter(node)) {
			violationHandler.printInfo(node);
		}
	}

	private boolean rightsideIsParameter(Assignment node) {
		return new Rightside(node).isParameter(parameterBindings);
	}

	private boolean leftsideIsField(Assignment node) {
		return new Leftside(node).isParameter(parameterBindings);
	}
}
