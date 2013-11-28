package ocanalyzer.newIntegration;

import ocanalyzer.reporter.ClassViolation;

import org.eclipse.core.resources.IResource;

public class ClassViolationDecorator {

	private ClassViolation violation;

	public ClassViolationDecorator(String resource, Integer line, String message) {
		violation = new ClassViolationFake(resource, line, message);
	}

	public ClassViolationDecorator(ClassViolation violation) {
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

		if (obj instanceof ClassViolation) {
			ClassViolation violation = (ClassViolation) obj;
			return this.violation.getResource().getName()
					.equals(violation.getResource().getName())
					& this.violation.getLine().equals(violation.getLine())
					& this.violation.getMessage()
							.equals(violation.getMessage());
		}
		return false;
	}

}
