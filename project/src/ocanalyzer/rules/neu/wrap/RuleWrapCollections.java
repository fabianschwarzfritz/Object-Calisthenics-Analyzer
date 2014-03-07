package ocanalyzer.rules.neu.wrap;

import ocanalyzer.reporter.ClassReporter;

public class RuleWrapCollections extends RuleWrapNew {

	public RuleWrapCollections(ClassReporter reporter) {
		super(reporter, new CollectionDeterminator());
	}

}
