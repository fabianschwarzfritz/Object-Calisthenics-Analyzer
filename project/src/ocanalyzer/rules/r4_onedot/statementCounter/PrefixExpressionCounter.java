package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.PrefixExpression;

public class PrefixExpressionCounter implements ExpressionCounter {

	private PrefixExpression prefix;

	public PrefixExpressionCounter(PrefixExpression prefix) {
		super();
		this.prefix = prefix;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(prefix.getOperand());

	}

}
