package ocanalyzer.rules.r9_properties.setter;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.r9_properties.VariableBindings;
import ocanalyzer.rules.r9_properties.general.ContainsBindingsVisitor;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class SetterVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;
	private VariableBindings bindings;
	private VariableBindings parameterBindings;

	public SetterVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
		bindings = new VariableBindings();
	}

	public void endVisit(TypeDeclaration node) {
		bindings.clear();
	}

	@Override
	public boolean visit(MethodDeclaration node) {
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
			validationHandler.printInfo(node);
		}
	}

	private boolean rightsideIsParameter(Assignment node) {
		Expression rightHandSide = node.getRightHandSide();
		final AtomicBoolean right = new AtomicBoolean(false);
		ValidationHandler rightHandler = new ValidationHandler() {
			@Override
			public void printInfo(ASTNode node) {
				right.set(true);
			}
		};
		rightHandSide.accept(new ContainsBindingsVisitor(rightHandSide,
				parameterBindings, rightHandler));
		return right.get();
	}

	private boolean leftsideIsField(Assignment node) {
		Expression leftHandSide = node.getLeftHandSide();
		final AtomicBoolean left = new AtomicBoolean(false);
		ValidationHandler leftHandler = new ValidationHandler() {
			@Override
			public void printInfo(ASTNode node) {
				left.set(true);
			}
		};
		leftHandSide.accept(new ContainsBindingsVisitor(leftHandSide, bindings,
				leftHandler));
		return left.get();
	}
}
