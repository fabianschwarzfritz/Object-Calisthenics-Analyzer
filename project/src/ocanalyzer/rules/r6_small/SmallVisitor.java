package ocanalyzer.rules.r6_small;

import java.util.HashMap;

import ocanalyzer.rules.general.ViolationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

class SmallVisitor extends ASTVisitor {

	private ViolationHandler violationHandler;

	private TypeDeclaration current;
	private HashMap<TypeDeclaration, Integer> expressionStatements;

	public SmallVisitor(ViolationHandler violationHandler) {
		this.violationHandler = violationHandler;
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
			violationHandler.printInfo(node);
		}
	}

	@Override
	public void endVisit(ExpressionStatement node) {
		if (current != null) {
			int value = expressionStatements.get(current);
			expressionStatements.put(current, ++value);
		}
	}

}
