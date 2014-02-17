package reportexamples.rule2.example3;

public class MainNull {

	public void conditionalMethod() {
		ConditionAction action = conditionIsFullfilled();
		action.doAction();
	}

	private ConditionAction conditionIsFullfilled() {
		return new FullFilled();
		// return new NotFullfilled();
	}
}
