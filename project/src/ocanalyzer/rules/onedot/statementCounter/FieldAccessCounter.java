package ocanalyzer.rules.onedot.statementCounter;

import ocanalyzer.rules.onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.FieldAccess;

public class FieldAccessCounter implements ExpressionCounter {

	private FieldAccess access;

	public FieldAccessCounter(FieldAccess fieldAccess) {
		this.access = fieldAccess;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(access.getExpression());
	}

}
