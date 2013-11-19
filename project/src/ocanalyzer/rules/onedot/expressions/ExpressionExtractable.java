package ocanalyzer.rules.onedot.expressions;

import java.util.List;

import ocanalyzer.rules.onedot.statementCounter.ExpressionCounter;

public interface ExpressionExtractable {

	void extractedCounters(List<ExpressionCounter> extractedCounters);

}
