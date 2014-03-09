package ocanalyzer.domain;

import ocanalyzer.dto.ViolationDTO;

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
	private Position position;

	public ViolationImpl(Name name, Message message, Degree degree,
			Position position) {
		super();
		this.name = name;
		this.message = message;
		this.degree = degree;
		this.position = position;
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

	@Override
	public ViolationDTO createDTO() {
		return new ViolationDTO(name.createDTO(), message.createDTO(),
				degree.createDTO(), position.createDTO());
	}

}
