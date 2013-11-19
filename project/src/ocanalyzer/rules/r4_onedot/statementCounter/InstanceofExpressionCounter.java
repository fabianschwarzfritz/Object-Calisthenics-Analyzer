package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.InstanceofExpression;

public class InstanceofExpressionCounter implements ExpressionCounter {

	private InstanceofExpression expression;

	public InstanceofExpressionCounter(InstanceofExpression expression) {
		this.expression = expression;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(expression.getLeftOperand());
	}

}
