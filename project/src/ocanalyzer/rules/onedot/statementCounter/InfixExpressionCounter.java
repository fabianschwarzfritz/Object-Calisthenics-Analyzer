package ocanalyzer.rules.onedot.statementCounter;

import ocanalyzer.rules.onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.InfixExpression;

public class InfixExpressionCounter implements ExpressionCounter {

	private InfixExpression expr;

	public InfixExpressionCounter(InfixExpression expr) {
		super();
		this.expr = expr;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(expr.getLeftOperand());
		expressions.add(expr.getRightOperand());
	}

}
