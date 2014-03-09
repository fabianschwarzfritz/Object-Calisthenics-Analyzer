package ocanalyzer.dto;

public class ViolationDTO {

	private String name;
	private String message;
	private String degree;
	private String position;

	public ViolationDTO(String name, String message, String degree,
			String position) {
		super();
		this.name = name;
		this.message = message;
		this.degree = degree;
		this.position = position;
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

}
