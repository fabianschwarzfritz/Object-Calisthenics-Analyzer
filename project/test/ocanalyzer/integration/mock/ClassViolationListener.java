package ocanalyzer.integration.mock;

import ocanalyzer.reporter.ViolationImpl;

public interface ClassViolationListener {

	void push(ViolationImpl violation);

}
