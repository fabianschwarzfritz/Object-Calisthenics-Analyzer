package ocanalyzer.rules.r4_onedot.expressions;

import java.util.List;

import ocanalyzer.rules.r4_onedot.statementCounter.ExpressionCounter;

public interface ExpressionExtractable {

	void extractedCounters(List<ExpressionCounter> extractedCounters);

}
