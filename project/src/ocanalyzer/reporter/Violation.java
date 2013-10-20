package ocanalyzer.reporter;

import org.eclipse.core.resources.IResource;

public class Violation {

	private IResource resource;
	private Integer line;
	private String message;

	public Violation(IResource resource, Integer line, String message) {
		super();
		this.resource = resource;
		this.line = line;
		this.message = message;
	}

	public IResource getResource() {
		return resource;
	}

	public Integer getLine() {
		return line;
	}

	public String getMessage() {
		return message;
	}
}
