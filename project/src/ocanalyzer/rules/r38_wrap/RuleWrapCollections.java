package ocanalyzer.rules.r38_wrap;

import ocanalyzer.reporter.Reporter;

public class RuleWrapCollections extends RuleWrapNew {

	public RuleWrapCollections(Reporter reporter) {
		super(reporter, new CollectionDeterminator());
	}

}
