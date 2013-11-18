package ocanalyzer.rules.onedot;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Statement;

/**
 * 
 * This class is used to visit all if {@link Statement}.
 * 
 * An if {@link Statement} which does have a corresponding else
 * {@link Statement} is saved and furthermore it is reported to the given
 * {@link DotValidationHandler}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class DotVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	private ExpressionStatement current;
	private int methodInvocationCount;

	public DotVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
		methodInvocationCount = 0;
	}

	@Override
	public boolean visit(ExpressionStatement node) {
		current = node;
		return true;
	}

	@Override
	public void endVisit(ExpressionStatement expressionStatement) {
		if (methodInvocationCount > 1) {
			validationHandler.printInfo(expressionStatement);
		}
	}

	// @Override
	// public boolean visit(MethodInvocation node) {
	// }

	@Override
	public void endVisit(MethodInvocation methodInvocation) {
		methodInvocationCount++;
	}

	@Override
	public void endVisit(FieldAccess node) {
		methodInvocationCount++;
	}
	
	
}
