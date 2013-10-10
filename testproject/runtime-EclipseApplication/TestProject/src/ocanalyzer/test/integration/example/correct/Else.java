package ocanalyzer.test.integration.example.correct;

public class Else {

	private Integer value;

	public Else(Integer value) {
		this.value = value;
	}

	public Integer aMethod() {
		if (value == 3) {
			return 5;
		}
		return 0;
	}

}

