package wrapPrimitives_correct_db;

public class Port {

	public static final String PORT = "port";

	private int port;

	public Port(int port) {
		this.port = port;
	}

	public static Port getDefault() {
		int defaultPort = Integer.valueOf(System.getProperty(PORT, "4711"));
		return new Port(defaultPort);
	}

}
