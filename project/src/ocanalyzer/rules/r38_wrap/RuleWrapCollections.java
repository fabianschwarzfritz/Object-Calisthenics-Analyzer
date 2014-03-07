package ocanalyzer.rules.r38_wrap;

import ocanalyzer.reporter.ClassReporter;

public class RuleWrapCollections extends RuleWrapNew {

	public RuleWrapCollections(ClassReporter reporter) {
		super(reporter, new CollectionDeterminator());
	}

}
