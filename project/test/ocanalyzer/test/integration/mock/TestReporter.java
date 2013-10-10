package ocanalyzer.test.integration.mock;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.helper.Triple;
import ocanalyzer.reporter.RuleViolationReporter;

import org.eclipse.core.resources.IResource;

public class TestReporter implements RuleViolationReporter {

	private List<Triple<IResource, Integer, String>> violations;

	public TestReporter() {
		violations = new ArrayList<Triple<IResource, Integer, String>>();
	}

	@Override
	public void reportError(IResource resource, int line, String msg) {
		violations.add(new Triple<IResource, Integer, String>(resource, line,
				msg));
	}

	public List<Triple<IResource, Integer, String>> getViolations() {
		return violations;
	}
}
