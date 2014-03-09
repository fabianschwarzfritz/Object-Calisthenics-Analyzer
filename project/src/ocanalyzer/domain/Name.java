package ocanalyzer.domain;

public class Name {

	private String name;

	public Name(String message) {
		this.name = message;
	}

	public String createDTO() {
		return new String(name);
	}

}
