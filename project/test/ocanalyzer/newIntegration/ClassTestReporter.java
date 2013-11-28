package ocanalyzer.newIntegration;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.reporter.ClassViolation;

public class ClassTestReporter implements ClassReporter {

	private ClassViolationListener listener;

	public ClassTestReporter(ClassViolationListener listener) {
		this.listener = listener;
	}

	@Override
	public void reportError(ClassViolation violation) {
		listener.push(violation);
	}

}
