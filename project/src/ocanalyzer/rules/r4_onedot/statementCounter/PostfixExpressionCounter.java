package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.PostfixExpression;

public class PostfixExpressionCounter implements ExpressionCounter {

	private PostfixExpression postFix;

	public PostfixExpressionCounter(PostfixExpression postFix) {
		super();
		this.postFix = postFix;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(postFix.getOperand());

	}

}
