package wrapPrimitives.correct.db;

public class DBConfiguration {

	public static final String PORT = "port";
	public static final String HOSTNAME = "host";
	public static final String DBNAME = "name";

	private HostName hostName;
	private Port port;
	private DatabaseName databaseName;

	public static DBConfiguration getDefaultConfiguration() {
		HostName defaultHost = HostName.getDefault();
		DatabaseName defaultdb = DatabaseName.getDefault();
		Port defaultport = Port.getDefault();

		return new DBConfiguration(defaultHost, defaultport, defaultdb);
	}

	public DBConfiguration(HostName hostName, Port port,
			DatabaseName databaseName) {
		this.hostName = hostName;
		this.port = port;
		this.databaseName = databaseName;
	}

	public HostName getHostName() {
		return hostName;
	}

	public Port getPort() {
		return port;
	}

	public DatabaseName getDatabaseName() {
		return databaseName;
	}
}
