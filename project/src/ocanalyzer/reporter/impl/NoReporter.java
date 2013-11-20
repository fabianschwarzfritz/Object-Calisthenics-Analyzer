package ocanalyzer.reporter.impl;

import ocanalyzer.reporter.PackageViolation;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.reporter.Violation;

public class NoReporter implements Reporter {

	@Override
	public void reportError(Violation violation) {
	}

	@Override
	public void reportError(PackageViolation violation) {
	}

}
