package reportexamples.rule2.example3;

public class NotFullfilled implements ConditionAction {

	@Override
	public void doAction() {
		doFalse();
		veryComplexAndLongOperations();
	}

	private void doFalse() {
	}

	private void veryComplexAndLongOperations() {
	}

}
