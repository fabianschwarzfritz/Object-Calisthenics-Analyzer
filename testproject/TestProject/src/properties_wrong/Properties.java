package properties_wrong;

public class Properties {

	private String property;

	public Properties() {
		property = "somevalue";
	}

	public String getProperty() {
		return property;
	}

	public void setProp(String prop) {
		property = prop;
	}

	public void setProp(String prop, boolean dos) {
		property = prop;
	}
}
