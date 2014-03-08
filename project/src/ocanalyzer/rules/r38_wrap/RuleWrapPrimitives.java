package ocanalyzer.rules.r38_wrap;

import ocanalyzer.reporter.Reporter;

public class RuleWrapPrimitives extends RuleWrapNew {

	public RuleWrapPrimitives(Reporter reporter) {
		super(reporter, new PrimitiveDeterminator());
	}

}
