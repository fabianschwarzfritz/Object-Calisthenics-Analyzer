package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.MethodInvocation;

public class MethodInvocationCounter implements ExpressionCounter {

	private MethodInvocation methodInvocation;

	public MethodInvocationCounter(MethodInvocation methodInvocation) {
		this.methodInvocation = methodInvocation;
	}

	@SuppressWarnings("unchecked")
	public void extractExpressions(Expressions expressions) {
		expressions.add(methodInvocation.getExpression());
		expressions.add(methodInvocation.arguments());
	}
}
