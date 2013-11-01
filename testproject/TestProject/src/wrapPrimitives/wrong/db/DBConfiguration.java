package wrapPrimitives.wrong.db;

public class DBConfiguration {

	public static final String PORT = "port";
	public static final String HOSTNAME = "host";
	public static final String DBNAME = "name";

	private String hostName;
	private int port;
	private String databaseName;

	public static DBConfiguration getDefaultConfiguration() {
		String defaultHostName = System.getProperty(HOSTNAME, "localhost");
		int defaultPort = Integer.valueOf(System.getProperty(PORT, "4711"));
		String defaultDatabaseName = System.getProperty(DBNAME, "database1");

		return new DBConfiguration(defaultHostName, defaultPort,
				defaultDatabaseName);
	}

	public DBConfiguration(String hostName, int port, String databaseName) {
		this.hostName = hostName;
		this.port = port;
		this.databaseName = databaseName;
	}

	public String getHostName() {
		return hostName;
	}

	public int getPort() {
		return port;
	}

	public String getDatabaseName() {
		return databaseName;
	}
}
