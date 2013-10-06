package ocanalyzer.test.integration.example.wrong;

public class Else {

	private Integer value;

	public Else(Integer value) {
		this.value = value;
	}

	public Integer aMethod() {
		Integer returnValue = null;;
		if (value == 3) {
			returnValue = new Integer(5);
		} else {
			returnValue = new Integer(0);
		}
		return returnValue;
	}

}
