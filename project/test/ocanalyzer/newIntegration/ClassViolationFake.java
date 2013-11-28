package ocanalyzer.newIntegration;

import ocanalyzer.reporter.ClassViolation;

import org.eclipse.core.resources.IResource;

public class ClassViolationFake extends ClassViolation {

	private String resource;
	private Integer line;
	private String message;

	public ClassViolationFake(String resource, Integer line, String message) {
		super();
		this.resource = resource;
		this.line = line;
		this.message = message;
	}

	@Override
	public IResource getResource() {
		return new NamedIResource(resource);
	}

}
