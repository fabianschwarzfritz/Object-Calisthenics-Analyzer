package wrapPrimitives_correct_db;

public class DatabaseName {

	public static final String DBNAME = "name";

	private String dbName;

	public DatabaseName(String dbName) {
		this.dbName = dbName;
	}

	public static DatabaseName getDefault() {
		String defaultDatabaseName = System.getProperty(DBNAME, "database1");
		return new DatabaseName(defaultDatabaseName);
	}

}
