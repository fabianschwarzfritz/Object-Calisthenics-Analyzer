package ocanalyzer.rules.r5_shortnames.determinator;

public class TypeNameDeterminator {

	private String pattern = "([A-Z][a-z0-9]+){1,2}";

	public boolean shortName(String shortname) {
		boolean length = shortname.length() < 15;
		boolean matches = shortname.matches(pattern);
		return length & matches;
	}
}
