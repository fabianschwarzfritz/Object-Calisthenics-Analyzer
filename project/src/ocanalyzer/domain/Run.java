package ocanalyzer.domain;

import ocanalyzer.reporter.Reporter;

public interface Run {

	public abstract Run update();

	public abstract int countViolations();

	public void addViolation(Violation violation);

	public void validate(Reporter reporter);
}
