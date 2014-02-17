package reportexamples.rule2.example2;

public class MainEarlyreturn {

	public void conditionalMethod() {
		if (conditionIsFullfilled()) {
			doTrue();
			veryComplexAndLongOperations();
			return;
		}
		doFalse();
		veryComplexAndLongOperations();
		return;
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
