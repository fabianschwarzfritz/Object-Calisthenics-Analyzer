package ocanalyzer.rules.onedot.statementCounter;

import ocanalyzer.rules.onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.MethodInvocation;

public class MethodInvocationCounter implements ExpressionCounter{

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
