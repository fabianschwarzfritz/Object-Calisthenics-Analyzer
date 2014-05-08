package properties_wrong;

public class Getters {

	private String property;

	public String getProperty3() {
		return "Jucheee";
	}

	public String getProperty2() {
		return new String("asdf");
	}

	public String getProperty1() {
		String a = property;
		return a; //x
	}

	public String getProperty() {
		return property;//x
	}

	private String getPrivateProperty() {
		return property;
	}
}
