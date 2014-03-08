package ocanalyzer.reporter.impl;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.reporter.PackageViolation;
import ocanalyzer.reporter.Reporter;

public class NoReporter implements Reporter {

	@Override
	public void reportError(ViolationImpl violation) {
	}

	@Override
	public void reportError(PackageViolation violation) {
	}

}
