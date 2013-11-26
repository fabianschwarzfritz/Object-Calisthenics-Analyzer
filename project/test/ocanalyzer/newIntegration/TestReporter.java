package ocanalyzer.newIntegration;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.reporter.PackageViolation;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.reporter.ClassViolation;

public class TestReporter implements Reporter {

	private List<PackageViolation> packageviolations;
	private List<ClassViolation> violations;

	public TestReporter() {
		violations = new ArrayList<ClassViolation>();
	}

	@Override
	public void reportError(ClassViolation violation) {
		violations.add(violation);
	}

	public List<ClassViolation> getViolations() {
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
