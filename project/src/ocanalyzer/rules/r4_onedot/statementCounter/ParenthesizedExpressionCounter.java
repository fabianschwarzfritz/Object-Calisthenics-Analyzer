package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.ParenthesizedExpression;

public class ParenthesizedExpressionCounter implements ExpressionCounter {

	private ParenthesizedExpression expression;

	public ParenthesizedExpressionCounter(ParenthesizedExpression expression) {
		super();
		this.expression = expression;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(expression.getExpression());
	}

}
