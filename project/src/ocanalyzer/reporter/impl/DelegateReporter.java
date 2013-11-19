package ocanalyzer.reporter.impl;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.reporter.Violation;

/**
 * This class is used to delegate a rule violation event to all given
 * {@link Reporter}s in {@link reporters}.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class DelegateReporter implements Reporter {

	private List<Reporter> reporters;

	public DelegateReporter() {
		reporters = new ArrayList<Reporter>();
	}

	public void add(Reporter reporter) {
		reporters.add(reporter);
	}

	@Override
	public void reportError(Violation violation) {
		for (Reporter reporter : reporters) {
			reporter.reportError(violation);
		}
	}

}
