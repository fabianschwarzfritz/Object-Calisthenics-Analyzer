package ocanalyzer.analyzer.reporter;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.reporter.PackageViolation;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.reporter.Violation;

public class TestReporter implements Reporter {

	private List<PackageViolation> packageviolations;
	private List<Violation> violations;

	public TestReporter() {
		violations = new ArrayList<Violation>();
	}

	@Override
	public void reportError(Violation violation) {
		violations.add(violation);
	}

	public List<Violation> getViolations() {
		return violations;
	}

	@Override
	public void reportError(PackageViolation violation) {
		packageviolations.add(violation);
	}

	public List<PackageViolation> getPackageviolations() {
		return packageviolations;
	}

}
