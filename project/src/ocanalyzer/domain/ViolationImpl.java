package ocanalyzer.domain;

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
public class ViolationImpl implements Violation {

	private Name name;
	private Message message;
	private Degree degree;
	private PositionInClass position;

	public ViolationImpl(IResource resource, Integer line, String message) {
		super();
		this.name = new Name(message);
		this.message = new Message(message);
		this.degree = Degree.MIDDLE;
		this.position = new PositionInClass(resource, line);
	}

	public IResource getResource() {
		return position.getResource();
	}

	public int getLine() {
		return position.getPosition();
	}

	public String getMessage() {
		return message.getShortDescription();
	}

}
