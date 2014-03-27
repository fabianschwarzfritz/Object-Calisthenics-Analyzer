package ocanalyzer.rules.r4_onedot.counter;

import java.util.List;

import ocanalyzer.rules.r4_onedot.expressions.ExpressionExtractable;
import ocanalyzer.rules.r4_onedot.expressions.ExpressionExtractor;
import ocanalyzer.rules.r4_onedot.statementCounter.ExpressionCounter;

import org.eclipse.jdt.core.dom.Expression;

public class StatementDotCounter implements ExpressionExtractable,
		CounterReporter {

	private int resultCount;

	private Expression rootExpression;
	private ExpressionExtractor extractor;

	public StatementDotCounter(Expression root) {
		this.rootExpression = root;
		extractor = new ExpressionExtractor(this);
	}

	@Override
	public void count(int count) {
		resultCount += count;
	}

	public int count() {
		resultCount = 0;
		extractor.add(rootExpression);
		extractor.count(this);
		return resultCount;
	}

	@Override
	public void extractedCounters(List<ExpressionCounter> extractedCounters) {
		for (ExpressionCounter counter : extractedCounters) {
			counter.extractExpressions(extractor);
		}
	}
}
