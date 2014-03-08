package ocanalyzer.integration.helper;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.integration.mock.ClassViolationListener;
import ocanalyzer.reporter.ClassReporter;

public class ClassTestReporter implements ClassReporter {

	private ClassViolationListener listener;

	public ClassTestReporter(ClassViolationListener listener) {
		this.listener = listener;
	}

	@Override
	public void reportError(ViolationImpl violation) {
		listener.push(violation);
	}

}
