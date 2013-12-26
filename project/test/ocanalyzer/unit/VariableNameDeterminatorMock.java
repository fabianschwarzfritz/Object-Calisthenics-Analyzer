package ocanalyzer.unit;

import ocanalyzer.rules.r5_shortnames.determinator.VariableNameDeterminator;

public class VariableNameDeterminatorMock extends VariableNameDeterminator {

	public VariableNameDeterminatorMock() {
		super(null);
	}

	public boolean matches(String shortname) {
		return matcher.matchesConditions(shortname);
	}

}
