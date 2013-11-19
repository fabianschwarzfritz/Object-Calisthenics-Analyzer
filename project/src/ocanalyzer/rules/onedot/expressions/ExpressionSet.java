package ocanalyzer.rules.onedot.expressions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import ocanalyzer.rules.onedot.counter.CounterReporter;

import org.eclipse.jdt.core.dom.Expression;

public class ExpressionSet implements Expressions {

	private Set<Expression> expressions;

	public ExpressionSet() {
		expressions = new HashSet<Expression>();
	}

	public void add(Expression expression) {
		expressions.add(expression);
	}

	public void add(Collection<Expression> expressions) {
		expressions.addAll(expressions);
	}

	public void count(CounterReporter reporter) {
		reporter.count(expressions.size());
	}
}
