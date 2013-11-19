package ocanalyzer.rules.onedot.statementCounter;

import ocanalyzer.rules.onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.CastExpression;

public class CastExpressionCounter implements ExpressionCounter {

	private CastExpression castExpression;

	public CastExpressionCounter(CastExpression castExpression) {
		this.castExpression = castExpression;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(castExpression.getExpression());
	}

}
