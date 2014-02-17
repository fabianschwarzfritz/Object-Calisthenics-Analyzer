package reportexamples.rule2.example2;

public class Main {

	public void conditionalMethod() {
		if (conditionIsFullfilled()) {
			doTrue();
			veryComplexAndLongOperations();
		} else {
			doFalse();
			veryComplexAndLongOperations();
		}
	}

	private boolean conditionIsFullfilled() {
		return false;
	}

	private void doTrue() {
	}

	private void doFalse() {
	}

	private void veryComplexAndLongOperations() {
	}

}
