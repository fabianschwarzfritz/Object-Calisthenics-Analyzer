package ocanalyzer.integration.helper;

import java.util.ArrayList;
import java.util.Collection;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.integration.mock.ClassViolationDecorator;
import ocanalyzer.reporter.ClassReporter;

import org.junit.Assert;

public class ViolationAsserter implements ClassReporter {

	private Collection<ClassViolationDecorator> occuredViolations;
	private Collection<ClassViolationDecorator> violations;

	public ViolationAsserter(Collection<ClassViolationDecorator> violations) {
		this.violations = violations;
		occuredViolations = new ArrayList<ClassViolationDecorator>();
	}

	@Override
	public void reportError(ViolationImpl violation) {
		ClassViolationDecorator decorator = new ClassViolationDecorator(
				violation);
		Assert.assertTrue("The occurred class violation " + violation
				+ " is not scheduled in the test.", isPart(decorator));
		occuredViolations.add(decorator);
	}

	private boolean isPart(ClassViolationDecorator violation) {
		return violations.contains(violation);
	}

	public void guarantueeCount() {
		Assert.assertSame("The number of occured violations is not correct",
				violations.size(), occuredViolations.size());
	}
}
