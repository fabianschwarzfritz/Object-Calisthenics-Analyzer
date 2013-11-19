package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

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
