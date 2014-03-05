package ocanalyzer.rules.r4_onedot.expressions;

import java.util.Collection;
import java.util.List;

import ocanalyzer.rules.r4_onedot.counter.CounterFactory;
import ocanalyzer.rules.r4_onedot.counter.CounterReporter;
import ocanalyzer.rules.r4_onedot.statementCounter.ExpressionCounter;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SuperFieldAccess;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.TypeLiteral;

public class ExpressionExtractor implements Expressions {

	private ExpressionExtractable extractable;
	private ExpressionSet expressions;

	public ExpressionExtractor(ExpressionExtractable extractable) {
		expressions = new ExpressionSet();
		this.extractable = extractable;
	}

	public void add(Expression expression) {
		if (expression instanceof MethodInvocation
				| expression instanceof SuperMethodInvocation
				| expression instanceof FieldAccess
				| expression instanceof SuperFieldAccess
				/* | expression instanceof ThisExpression */
				| expression instanceof TypeLiteral
				| expression instanceof QualifiedName) {
			expressions.add(expression);
		}

		List<ExpressionCounter> createCounters = new CounterFactory()
				.createCounters(expression);
		extractable.extractedCounters(createCounters);
	}

	public void add(Collection<Expression> expressions) {
		for (Expression expression : expressions) {
			this.add(expression);
		}
	}

	public void count(CounterReporter reporter) {
		expressions.count(reporter);
	}

}
