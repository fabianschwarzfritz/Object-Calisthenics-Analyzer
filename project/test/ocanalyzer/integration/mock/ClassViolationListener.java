package ocanalyzer.integration.mock;

import ocanalyzer.reporter.ClassViolation;

public interface ClassViolationListener {

	void push(ClassViolation violation);

}
