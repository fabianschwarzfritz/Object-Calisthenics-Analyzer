package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.Assignment;

public class AssignmentCounter implements ExpressionCounter {

	private Assignment expression;

	public AssignmentCounter(Assignment assignment) {
		this.expression = assignment;
	}

	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(expression.getLeftHandSide());
		expressions.add(expression.getRightHandSide());
	}

}
