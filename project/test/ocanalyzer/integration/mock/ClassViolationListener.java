package ocanalyzer.integration.mock;

import ocanalyzer.domain.ViolationImpl;

public interface ClassViolationListener {

	void push(ViolationImpl violation);

}
