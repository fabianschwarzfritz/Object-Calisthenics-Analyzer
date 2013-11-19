package ocanalyzer.rules.r4_onedot.statementCounter;

import ocanalyzer.rules.r4_onedot.expressions.Expressions;

import org.eclipse.jdt.core.dom.ClassInstanceCreation;

public class ClassInstanceCreationCounter implements ExpressionCounter {

	private ClassInstanceCreation expression;

	public ClassInstanceCreationCounter(ClassInstanceCreation expression) {
		super();
		this.expression = expression;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void extractExpressions(Expressions expressions) {
		expressions.add(expression.getExpression());
		expressions.add(expression.arguments());
	}

}
