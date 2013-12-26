package ocanalyzer.rules.r5_shortnames.determinator;

public class VariableNameDeterminator {

	private String pattern = "([a-z0-9]+[A-Z]{0,1}[a-z0-9]+)";

	public boolean shortName(String shortname) {
		boolean length = shortname.length() < 15;
		boolean matches = shortname.matches(pattern);
		return length & matches;
	}
}
