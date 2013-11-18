package ocanalyzer.rules.onedot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTMatcher;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

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

	private Map<Expression, Integer> expressions;

	public DotVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
		expressions = new HashMap<Expression, Integer>();
	}

	public boolean visit(TypeDeclaration type) {
		System.out.println("TypeDeclaration: " + type.getName());
		return true;
	}

	@Override
	public boolean visit(ExpressionStatement node) {
		Expression expression = node.getExpression();
		addExpression(expression, 0);
		return true;
	}

	private void addExpression(Expression pExpression, Integer pCount) {
		Integer newCount = pCount++;
		expressions.put(pExpression, newCount);
		if (pExpression instanceof MethodInvocation) {
			MethodInvocation methodInvocation = (MethodInvocation) pExpression;

			Expression methodExpression = methodInvocation.getExpression();
			addExpression(methodExpression, newCount);
			@SuppressWarnings("unchecked")
			List<Expression> argementExpressions = methodInvocation.arguments();
			for (Expression expr : argementExpressions) {
				addExpression(expr, newCount);
			}

		} else if (pExpression instanceof FieldAccess) {
			FieldAccess fieldAccess = (FieldAccess) pExpression;
			Expression expression2 = fieldAccess.getExpression();
			addExpression(expression2, newCount);
		}
	}

	// TODO wrap colleciton and use subtree match

	@Override
	public void endVisit(ExpressionStatement node) {
		Expression expression = node.getExpression();

		for (Expression expr : expressions.keySet()) {
			boolean subtreeMatch = expression.subtreeMatch(new ASTMatcher(),
					expr);
			if (subtreeMatch) {
				Integer integer = expressions.get(expr);
				System.err.println("DotVisitor.endVisit(): " + integer);
				if (integer != null && integer.intValue() > 1) {
					validationHandler.printInfo(node);
				}
			}
		}
	}
}
