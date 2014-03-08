package ocanalyzer.reporter.impl;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.reporter.Reporter;

public class NoReporter implements Reporter {

	@Override
	public void reportError(ViolationImpl violation) {
	}

}
