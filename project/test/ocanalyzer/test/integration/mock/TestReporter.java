package ocanalyzer.test.integration.mock;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.reporter.Violation;

import org.eclipse.core.resources.IResource;

public class TestReporter implements RuleViolationReporter {

	private List<Violation> violations;

	public TestReporter() {
		violations = new ArrayList<Violation>();
	}

	@Override
	public void reportError(IResource resource, int line, String msg) {
		violations.add(new Violation(resource, line, msg));
	}

	public List<Violation> getViolations() {
		return violations;
	}
}
