package ocanalyzer.reporter.impl;

import ocanalyzer.reporter.PackageViolation;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.reporter.ClassViolation;

public class NoReporter implements Reporter {

	@Override
	public void reportError(ClassViolation violation) {
	}

	@Override
	public void reportError(PackageViolation violation) {
	}

}
