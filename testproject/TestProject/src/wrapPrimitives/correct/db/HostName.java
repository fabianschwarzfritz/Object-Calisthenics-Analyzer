package wrapPrimitives.correct.db;

public class HostName {

	public static final String HOSTNAME = "host";

	private String hostName;

	public HostName(String hostName) {
		super();
		this.hostName = hostName;
	}

	public static HostName getDefault() {
		String defaultHostName = System.getProperty(HOSTNAME, "localhost");
		return new HostName(defaultHostName);
	}

}
