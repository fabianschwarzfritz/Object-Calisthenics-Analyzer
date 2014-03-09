package ocanalyzer.domain;

public enum Degree {
	LOW, MIDDLE, HIGH;

	public String createDTO() {
		return this.toString();
	}
}
