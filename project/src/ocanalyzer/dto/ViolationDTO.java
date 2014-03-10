package ocanalyzer.dto;

import org.eclipse.core.resources.IResource;

public class ViolationDTO {

	private String name;
	private String message;
	private String degree;
	private String position;
	private IResource resource;

	public ViolationDTO(String name, String message, String degree,
			String position, IResource resource) {
		super();
		this.name = name;
		this.message = message;
		this.degree = degree;
		this.position = position;
		this.resource = resource;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public String getDegree() {
		return degree;
	}

	public String getPosition() {
		return position;
	}

	public IResource getResource() {
		return resource;
	}

}
