package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.ConditionalExpression;

public class ConditionalExpressionCounter implements ExpressionCounter {

	private ConditionalExpression expression;

	public ConditionalExpressionCounter(ConditionalExpression expression) {
		this.expression = expression;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(expression.getExpression());
		expressions.add(expression.getElseExpression());
		expressions.add(expression.getThenExpression());
	}

}
