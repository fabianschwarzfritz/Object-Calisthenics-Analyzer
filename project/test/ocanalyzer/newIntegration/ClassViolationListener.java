package ocanalyzer.newIntegration;

import ocanalyzer.reporter.ClassViolation;

public interface ClassViolationListener {

	void push(ClassViolation violation);

}
