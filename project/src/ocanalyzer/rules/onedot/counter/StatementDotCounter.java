package ocanalyzer.rules.onedot.counter;

import java.util.List;

import ocanalyzer.rules.onedot.expressions.ExpressionExtractable;
import ocanalyzer.rules.onedot.expressions.ExpressionExtractor;
import ocanalyzer.rules.onedot.statementCounter.ExpressionCounter;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;

public class StatementDotCounter implements ExpressionExtractable {

	private Expression rootExpression;
	private ExpressionExtractor extractor;
	private CounterReporter reporter;

	public StatementDotCounter(ExpressionStatement statement,
			CounterReporter reporter) {
		this.reporter = reporter;
		extractor = new ExpressionExtractor(this);
		rootExpression = statement.getExpression();
	}

	public void count() {
		extractor.add(rootExpression);
		extractor.count(reporter);
	}

	@Override
	public void extractedCounters(List<ExpressionCounter> extractedCounters) {
		for (ExpressionCounter counter : extractedCounters) {
			counter.extractExpressions(extractor);
		}
	}
}
