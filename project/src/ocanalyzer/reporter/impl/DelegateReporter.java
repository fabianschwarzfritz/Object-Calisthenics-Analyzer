package ocanalyzer.reporter.impl;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.reporter.ClassViolation;
import ocanalyzer.reporter.PackageReporter;
import ocanalyzer.reporter.PackageViolation;
import ocanalyzer.reporter.Reporter;

/**
 * This class is used to delegate a rule violation event to all given
 * {@link ClassReporter}s in {@link reporters}.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class DelegateReporter implements Reporter {

	private List<PackageReporter> packageReporters;
	private List<ClassReporter> reporters;

	public DelegateReporter() {
		reporters = new ArrayList<ClassReporter>();
		packageReporters = new ArrayList<PackageReporter>();
	}

	public void addClassReporter(ClassReporter reporter) {
		reporters.add(reporter);
	}

	public void addPackageReporter(PackageReporter packageReporter) {
		packageReporters.add(packageReporter);
	}

	@Override
	public void reportError(ClassViolation violation) {
		for (ClassReporter reporter : reporters) {
			reporter.reportError(violation);
		}
	}

	@Override
	public void reportError(PackageViolation violation) {
		for (PackageReporter reporter : packageReporters) {
			reporter.reportError(violation);
		}
	}

}
