package ocanalyzer.rules.neu.wrap;

import ocanalyzer.reporter.ClassReporter;

public class RuleWrapPrimitives extends RuleWrapNew {

	public RuleWrapPrimitives(ClassReporter reporter) {
		super(reporter, new PrimitiveDeterminator());
	}

}
