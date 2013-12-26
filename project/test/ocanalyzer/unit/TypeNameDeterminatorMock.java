package ocanalyzer.unit;

import ocanalyzer.rules.r5_shortnames.determinator.TypeNameDeterminator;

public class TypeNameDeterminatorMock extends TypeNameDeterminator {

	public TypeNameDeterminatorMock() {
		super(null);
	}

	public boolean matches(String shortname) {
		return matcher.matchesConditions(shortname);
	}

}
