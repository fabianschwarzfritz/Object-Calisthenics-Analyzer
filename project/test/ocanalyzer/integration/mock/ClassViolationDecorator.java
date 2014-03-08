package ocanalyzer.integration.mock;

import ocanalyzer.reporter.ViolationImpl;

import org.eclipse.core.resources.IResource;

public class ClassViolationDecorator {

	private ViolationImpl violation;

	public ClassViolationDecorator(String resource, Integer line, String message) {
		violation = new ClassViolationFake(resource, line, message);
	}

	public ClassViolationDecorator(ViolationImpl violation) {
		super();
		this.violation = violation;
	}

	public IResource getResource() {
		return violation.getResource();
	}

	public Integer getLine() {
		return violation.getLine();
	}

	public String getMessage() {
		return violation.getMessage();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// Generage hash code from violation using the resource name
		result = prime
				* result
				+ ((violation.getLine() == null) ? 0 : violation.getLine()
						.hashCode());
		result = prime
				* result
				+ ((violation.getMessage() == null) ? 0 : violation
						.getMessage().hashCode());
		result = prime
				* result
				+ ((violation.getResource().getName() == null) ? 0 : violation
						.getResource().getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		if (obj instanceof ClassViolationDecorator) {
			ClassViolationDecorator otherDecorator = (ClassViolationDecorator) obj;
			ViolationImpl otherViolation = otherDecorator.violation;
			return this.violation.getResource().getName()
					.equals(otherViolation.getResource().getName())
					& this.violation.getLine().equals(otherViolation.getLine())
					& this.violation.getMessage().equals(
							otherViolation.getMessage());
		}
		return false;
	}

}
