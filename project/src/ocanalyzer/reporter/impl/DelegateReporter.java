package ocanalyzer.reporter.impl;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.reporter.Reporter;

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

	public void addReporter(Reporter reporter) {
		reporters.add(reporter);
	}

	@Override
	public void reportError(ViolationImpl violation) {
		for (Reporter reporter : reporters) {
			reporter.reportError(violation);
		}
	}
}
