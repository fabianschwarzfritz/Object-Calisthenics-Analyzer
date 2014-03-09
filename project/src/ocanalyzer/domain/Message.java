package ocanalyzer.domain;

public class Message {
	private String shortDescription;
	private String longDescription;

	public Message(String message) {
		this.shortDescription = message;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String createDTO() {
		return new String(shortDescription);
	}
}
