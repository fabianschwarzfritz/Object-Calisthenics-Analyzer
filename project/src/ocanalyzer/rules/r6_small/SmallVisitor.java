package ocanalyzer.rules.r6_small;

import java.util.HashMap;

import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

class SmallVisitor extends ASTVisitor {

	private ViolationHandlerImpl validationHandler;

	private TypeDeclaration current;
	private HashMap<TypeDeclaration, Integer> expressionStatements;

	public SmallVisitor(ViolationHandlerImpl validatonHandler) {
		this.validationHandler = validatonHandler;
		expressionStatements = new HashMap<TypeDeclaration, Integer>();
	}

	@Override
	public boolean visit(TypeDeclaration node) {
		current = node;
		expressionStatements.put(current, 0);
		return true;
	}

	@Override
	public void endVisit(TypeDeclaration node) {
		if (expressionStatements.get(node) > 50) {
			validationHandler.printInfo(node);
		}
	}

	@Override
	public void endVisit(ExpressionStatement node) {
		Integer value = expressionStatements.get(current);
		expressionStatements.put(current, ++value);
	}

}
