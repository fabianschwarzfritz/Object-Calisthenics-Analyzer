package ocanalyzer.reporter.impl;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.reporter.ReporterImpl;

public class NoReporter implements ReporterImpl {

	@Override
	public void reportError(ViolationImpl violation) {
	}

}
