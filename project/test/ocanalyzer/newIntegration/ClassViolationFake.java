package ocanalyzer.newIntegration;

import ocanalyzer.reporter.ClassViolation;

import org.eclipse.core.resources.IResource;

public class ClassViolationFake extends ClassViolation {

	private String resourceName;

	public ClassViolationFake(String resourceName, Integer line, String message) {
		super(null, line, message);
		this.resourceName = resourceName;
	}

	@Override
	public IResource getResource() {
		return new NamedIResource(resourceName);
	}

}
