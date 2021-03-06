package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.ArrayAccess;

public class ArrayAccessCounter implements ExpressionCounter {

	private ArrayAccess invocation;

	public ArrayAccessCounter(ArrayAccess invocation) {
		this.invocation = invocation;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(invocation.getArray());
		expressions.add(invocation.getIndex());
	}

}
