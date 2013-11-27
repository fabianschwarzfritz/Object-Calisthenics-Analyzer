package ocanalyzer.reporter;

import org.eclipse.core.resources.IResource;

/**
 * This class represents a rule violation. The location of the violation is
 * indicated by: **a given {@link #resource} **a given line. The line in which
 * the error occurred **a message, containing an information about the rule
 * violation.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ClassViolation implements Violation {

	private IResource resource;
	private Integer line;
	private String message;

	public ClassViolation(IResource resource, Integer line, String message) {
		super();
		this.resource = resource;
		this.line = line;
		this.message = message;
	}

	protected ClassViolation() {

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
