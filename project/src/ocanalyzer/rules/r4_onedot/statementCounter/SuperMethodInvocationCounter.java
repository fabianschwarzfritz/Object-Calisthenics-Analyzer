package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.SuperMethodInvocation;

public class SuperMethodInvocationCounter implements ExpressionCounter {

	private SuperMethodInvocation invocation;

	public SuperMethodInvocationCounter(SuperMethodInvocation invocation) {
		this.invocation = invocation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(invocation.arguments());
	}

}
