package ocanalyzer.rules.r4_onedot.expressions;

import java.util.Collection;

import ocanalyzer.rules.r4_onedot.counter.CounterReporter;

import org.eclipse.jdt.core.dom.Expression;

public interface Expressions {

	public void add(Expression expression);

	public void add(Collection<Expression> expressions);

	public void count(CounterReporter reporter);

}
